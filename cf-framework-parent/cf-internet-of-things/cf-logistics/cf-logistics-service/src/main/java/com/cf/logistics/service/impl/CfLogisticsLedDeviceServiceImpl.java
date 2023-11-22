package com.cf.logistics.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.IdWorker;
import com.cf.framework.utils.StringTools;
import com.cf.logistics.dao.mapper.CfLogisticsLedDeviceMapper;
import com.cf.logistics.domain.CfLogisticsLedDevice;
import com.cf.logistics.domain.CfLogisticsLedDeviceExample;
import com.cf.logistics.domain.device.CfLinXinLed;
import com.cf.logistics.domain.device.CfLinXinLedArea;
import com.cf.logistics.domain.device.CfLinXinLedProgram;
import com.cf.logistics.domain.request.CfLogisticsLedDeviceQuery;
import com.cf.logistics.service.CfLogisticsLedDeviceService;
import com.cf.logistics.service.socket.CfLogisticsLedClient;
import com.github.pagehelper.PageHelper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfLogisticsLedDeviceServiceImpl implements CfLogisticsLedDeviceService {
    // 用户保存用户id与通道的Map对象
    public static Map<String, CfLogisticsLedClient> logisticsLedClientMap = new HashMap<>();
    public static final String DEVICE_LINK_IP = "logistics_ledDevice_link_ip_";
    @Autowired
    private CfLogisticsLedDeviceMapper cfLogisticsLedDeviceMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public CfLogisticsLedDevice add(CfLogisticsLedDevice cfLogisticsLedDevice) {
        cfLogisticsLedDevice.setId(idWorker.nextLongId());
        cfLogisticsLedDeviceMapper.insertSelective(cfLogisticsLedDevice);
        return cfLogisticsLedDevice;
    }

    @Override
    public CfLogisticsLedDevice update(CfLogisticsLedDevice cfLogisticsLedDevice) {
        cfLogisticsLedDeviceMapper.updateByPrimaryKeySelective(cfLogisticsLedDevice);
        return cfLogisticsLedDevice;
    }

    @Override
    public Integer delete(Long id) {
        return cfLogisticsLedDeviceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfLogisticsLedDevice findById(Long id) {
        return cfLogisticsLedDeviceMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfLogisticsLedDevice findById(Long id, boolean expectEmpty) {
        CfLogisticsLedDevice cfLogisticsLedDevice = findById(id);
        if(expectEmpty && cfLogisticsLedDevice!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfLogisticsLedDevice==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfLogisticsLedDevice;
    }

    @Override
    public CfLogisticsLedDeviceExample getExampleByQuery(CfLogisticsLedDeviceQuery cfLogisticsLedDeviceQuery) {
        CfLogisticsLedDeviceExample cfLogisticsLedDeviceExample = new CfLogisticsLedDeviceExample();
        CfLogisticsLedDeviceExample.Criteria criteria = cfLogisticsLedDeviceExample.createCriteria();
        if(cfLogisticsLedDeviceQuery.getQueuingAreaId()!=null){
            criteria.andQueuingAreaIdEqualTo(cfLogisticsLedDeviceQuery.getQueuingAreaId());
        }
        if(cfLogisticsLedDeviceQuery.getSerialNumber()!=null){
            criteria.andSerialNumberEqualTo(cfLogisticsLedDeviceQuery.getSerialNumber());
        }

        if(StringUtils.isNotEmpty(cfLogisticsLedDeviceQuery.getOrderBy())){
            cfLogisticsLedDeviceExample.setOrderByClause(cfLogisticsLedDeviceQuery.getOrderBy());
        }
        if(cfLogisticsLedDeviceQuery.getPage()!=null && cfLogisticsLedDeviceQuery.getSize()!=null){
            PageHelper.startPage(cfLogisticsLedDeviceQuery.getPage(), cfLogisticsLedDeviceQuery.getSize());
        }
        return cfLogisticsLedDeviceExample;
    }

    @Override
    public List<CfLogisticsLedDevice> getListByQuery(CfLogisticsLedDeviceQuery cfLogisticsLedDeviceQuery) {
        return cfLogisticsLedDeviceMapper.selectByExample(getExampleByQuery(cfLogisticsLedDeviceQuery));
    }

    @Override
    public Integer countByQuery(CfLogisticsLedDeviceQuery cfLogisticsLedDeviceQuery) {
        cfLogisticsLedDeviceQuery.setPage(null);
        cfLogisticsLedDeviceQuery.setOrderBy(null);
        return cfLogisticsLedDeviceMapper.countByExample(getExampleByQuery(cfLogisticsLedDeviceQuery));
    }

    @Override
    public void handleLink(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] data = new byte[buf.readableBytes()];
        buf.readBytes(data);
        String message = StringTools.bytesToString16(data);

        CfLogisticsLedClient cfLogisticsLedClient = new CfLogisticsLedClient();
        cfLogisticsLedClient.setChannel(ctx.channel());
        cfLogisticsLedClient.setFrameHeader(message.substring(0,8));
        cfLogisticsLedClient.setAddress(message.substring(8,10));
        cfLogisticsLedClient.setMarker(message.substring(10,12));
        cfLogisticsLedClient.setOpcode(message.substring(12,16));
        cfLogisticsLedClient.setReservedCode(message.substring(16,20));
        cfLogisticsLedClient.setFrameNumber(message.substring(20,28));
        cfLogisticsLedClient.setTotalLength(message.substring(28,36));
        cfLogisticsLedClient.setFrameLength(message.substring(36,40));
        cfLogisticsLedClient.setSerialNumber(message.substring(40,message.length()-8));
        cfLogisticsLedClient.setEndOfFrame(message.substring(message.length()-8,message.length()));

        System.out.println(cfLogisticsLedClient);
        ByteBuf returnProtocolBuf = Unpooled.buffer();
        if(cfLogisticsLedClient.getOpcode().equals("00D8")){
            cfLogisticsLedClient.setHeartBeatContents(message);
            //说明是正常心跳
            CfLogisticsLedClient logisticsLedClient = logisticsLedClientMap.get(cfLogisticsLedClient.getSerialNumber());
            if(logisticsLedClient==null || !logisticsLedClient.getChannel().id().asLongText().equals(ctx.channel().id().asLongText())){
                logisticsLedClientMap.put(cfLogisticsLedClient.getSerialNumber(), cfLogisticsLedClient);
                //将设备在线设备ip记录到redis中去
                redisTemplate.boundValueOps(CfLogisticsLedDeviceServiceImpl.DEVICE_LINK_IP+cfLogisticsLedClient.getSerialNumber()).set(InetAddress.getLocalHost().getHostAddress());
                redisTemplate.expire(CfLogisticsLedDeviceServiceImpl.DEVICE_LINK_IP+cfLogisticsLedClient.getSerialNumber(),365, TimeUnit.DAYS);
            }
            returnProtocolBuf.writeBytes(StringTools.hexStringToBytes(message));
            ctx.channel().writeAndFlush(returnProtocolBuf);
        }
    }

    @Override
    public String makeTcpData(String serialNumber, CfLinXinLed cfLinXinLed) throws Exception {
        CfLogisticsLedClient cfLogisticsLedClient = logisticsLedClientMap.get(serialNumber);
        if(cfLogisticsLedClient==null){
            throw new Exception("指定序列号["+serialNumber+"]设备不在线");
        }
        //【显示数据属性】
        String datas = "75757575757575757575757575757575";  //固定
        datas += StringTools.reverseOrder(StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLed.getScreenWidth()),4), 2); //显示屏宽，横向点数
        datas += StringTools.reverseOrder(StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLed.getScreenHigh()),4), 2); //显示屏高，纵向点数
        datas += StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLed.getPrimaryColor()),2); //1—单基色，2—双基色，3—三基色
        datas += StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLed.getGrayScale()),2); //灰度等级 bit 数（无灰度为 1，4 级灰度为 2，8 级灰度为 3，16 级灰度为 4，32 级灰度时为 5）
        datas += StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLed.getNumberOfPrograms()),2); //存入所在位置的节目个数(两者之和需小于 256)
        datas += StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLed.getPlaybackMode()),2); //0---节目存入 Flash，如之前有 RAM 节目存在时是混合一起播放1---节目存入 RAM，如之前有 Flash 节目存在时是混合一起播放2—节目存入 Flash 且仅播放 Flash 节目3—节目存入 RAM 且仅播放 RAM 节目
        datas += "0000000000000000"; //全为 0x00
        datas += StringTools.reverseOrder(StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLed.getTotalSizeOfProgramData()),8), 2); //整个节目数据的总大小
        datas += "0000000000000000"; //全为 0x00
        //【节目属性】
        for(CfLinXinLedProgram cfLinXinLedProgram: cfLinXinLed.getCfLinXinLedProgramList()){
            datas += StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedProgram.getProgramNumber()),2); //节目编号，从 0 开始，从小到大排，不能跳跃
            datas += StringTools.reverseOrder(StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedProgram.getProgramDataBlockSize()),8), 2); //节目数据块的大小
            datas += "02"; //固定为 0x02
            datas += StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedProgram.getAreaSize()),2); //节目中区域个数
            datas += StringTools.reverseOrder(StringTools.preMakeUp(Integer.toHexString(cfLinXinLedProgram.getProgramPlayMode()),"0",4), 2); //0—单节目循环播放，非 0—单节目定长播放秒数
            datas += StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedProgram.getCyclePlaybackTimes()),2); //单节目循环播放时的次数
            datas += "00000000000000000000000000000000"; //全为 0x00
            //【区域属性】
            for(CfLinXinLedArea cfLinXinLedArea: cfLinXinLedProgram.getCfLinXinLedAreaList()){
                datas += StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getAreaNumber()),2); //区域编号
                datas += StringTools.reverseOrder(StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getAreaDataBlockSize()),8), 2); //区域数据块的大小
                datas += "E5"; //固定为 0Xe5
                datas += "01"; //固定为 0x01
                datas += "01"; //固定为 0x01
                datas += "00000000"; //全为 0x00
                datas += StringTools.reverseOrder(StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getAreaX()),4), 2); //区域开始 x 坐标
                datas += StringTools.reverseOrder(StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getAreaY()),4), 2); //区域开始 y 坐标
                datas += StringTools.reverseOrder(StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getAreaXX()-1),4), 2); //区域开始 xx 坐标
                datas += StringTools.reverseOrder(StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getAreaYY()-1),4), 2); //区域开始 yy 坐标
                datas += "000000000000000000000000"; //全为 0x00
                datas += "02"; //固定为 0x02
                datas += StringTools.reverseOrder(StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getAreaDataBlockSize()-32),8), 2); //区域数据块的大小 减去 32
                datas += "0E"; //固定为 0x0E
                datas += StringTools.reverseOrder(StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getNumberOfPages()),4), 2); //区域中的页数
                datas += StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getFontSizeWidth()),2); //字体宽
                datas += StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getFontSizeHigh()),2); //字体高
                datas += StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getFontColor()),2); //字体颜色值
                datas += "03"; //固定为 0x03
                datas += "000000000000000000000000"; //全为 0x00
                datas += StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getFontInMode()),2); //当前页进场特效
                datas += "FF"; //固定为 0x00
                datas += StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getFontInSpeed()),2); //当前页进场移动速度
                datas += "FF"; //固定为 0x00
                datas += StringTools.reverseOrder(StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getFontResidenceTime()),4), 2); //当前页停留时间
                datas += StringTools.reverseOrder(StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getPageAreaX()),4), 2); //当前页数据有效区域 x 坐标
                datas += StringTools.reverseOrder(StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getPageAreaY()),4), 2); //当前页数据有效区域 y 坐标
                datas += StringTools.reverseOrder(StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getPageAreaXX()-1),4), 2); //当前页数据有效区域 xx 坐标
                datas += StringTools.reverseOrder(StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getPageAreaYY()-1),4), 2); //当前页数据有效区域 yy 坐标
                datas += StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getFontMoveStep()),2); //连续移动时的步长
                datas += StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getFontRowSpacing()),2); //当前页的行间距，两行之间的点数
                datas += StringTools.reverseOrder(StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getPageDataSize()),4), 2); //本页的数据长度
                datas += StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLedArea.getFontWordSpacing()),2); //当前页的字间距
                datas += "FF"; //固定为 0x00
                datas += cfLinXinLedArea.getHexContents();  //文字数据内容
            }
        }
        cfLogisticsLedClient.setTotalLength(StringTools.reverseOrder(StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLed.getTotalSizeOfProgramData()),8), 2));
        cfLogisticsLedClient.setFrameLength(StringTools.reverseOrder(StringTools.preMakeUp("0", Integer.toHexString(cfLinXinLed.getTotalSizeOfProgramData()),4), 2));
        return cfLogisticsLedClient.getFrameHeader()+cfLogisticsLedClient.getAddress()
                +"01"+"00DA"+cfLogisticsLedClient.getReservedCode()
                +cfLogisticsLedClient.getFrameNumber()+cfLogisticsLedClient.getTotalLength()
                +cfLogisticsLedClient.getFrameLength()+datas
                +cfLogisticsLedClient.getEndOfFrame();
    }

    @Override
    public void sendTcpData(String serialNumber, CfLinXinLed cfLinXinLed) throws Exception {
        CfLogisticsLedClient cfLogisticsLedClient = logisticsLedClientMap.get(serialNumber);
        if(cfLogisticsLedClient==null){
            throw new Exception("指定序列号["+serialNumber+"]设备不在线");
        }
        String tcpData = makeTcpData(serialNumber, cfLinXinLed).toUpperCase();
        ByteBuf returnProtocolBuf = Unpooled.buffer();
        returnProtocolBuf.writeBytes(StringTools.hexStringToBytes(tcpData));
        cfLogisticsLedClient.getChannel().writeAndFlush(returnProtocolBuf);
    }
}
