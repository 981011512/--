package com.cf.framework.domain.lang;

import com.cf.framework.domain.response.ResultCode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 语言包
 *
 * @ClassName Lang
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/4/004 14:05
 * @Version 1.0
 **/
public class I18n {

    public static Map<String, Map<Integer, Map<String, String>>> langMap = null;

    public static Map<String, Map<Integer, Map<String, String>>> initLangMap()
    {
        Map<String, Map<Integer, Map<String, String>>> langMap = new HashMap<String, Map<Integer, Map<String, String>>>();
        //CommonCode
        I18n.putMessageBody(langMap, "CommonCode",10000, "zh", "非法参数");
        I18n.putMessageBody(langMap, "CommonCode",10000, "en", "Illegal parameter");

        I18n.putMessageBody(langMap, "CommonCode",10002, "zh", "操作成功");
        I18n.putMessageBody(langMap, "CommonCode",10002, "en", "Successful operation");

        I18n.putMessageBody(langMap, "CommonCode",10003, "zh", "操作失败");
        I18n.putMessageBody(langMap, "CommonCode",10003, "en", "operation failed");

        I18n.putMessageBody(langMap, "CommonCode",10004, "zh", "没有数据");
        I18n.putMessageBody(langMap, "CommonCode",10004, "en", "no data");

        I18n.putMessageBody(langMap, "CommonCode",10005, "zh", "此操作需要登陆系统");
        I18n.putMessageBody(langMap, "CommonCode",10005, "en", "This operation requires logging into the system");

        I18n.putMessageBody(langMap, "CommonCode",10006, "zh", "权限不足，无权操作");
        I18n.putMessageBody(langMap, "CommonCode",10006, "en", "Insufficient authority, no right to operate");

        I18n.putMessageBody(langMap, "CommonCode",99999, "zh", "抱歉，系统繁忙，请稍后重试");
        I18n.putMessageBody(langMap, "CommonCode",99999, "en", "Sorry, the system is busy, please try again later");

        I18n.putMessageBody(langMap, "CommonCode",10007, "zh", "重复数据");
        I18n.putMessageBody(langMap, "CommonCode",10007, "en", "Duplicate data");

        //CarParkCode
        I18n.putMessageBody(langMap, "CarParkCode",11000, "zh", "绑定车辆已达上限");
        I18n.putMessageBody(langMap, "CarParkCode",11000, "en", "The bound vehicle has reached the upper limit");

        I18n.putMessageBody(langMap, "CarParkCode",11001, "zh", "重复绑定车牌");
        I18n.putMessageBody(langMap, "CarParkCode",11001, "en", "Bind license plates repeatedly");

        I18n.putMessageBody(langMap, "CarParkCode",11002, "zh", "设备未注册");
        I18n.putMessageBody(langMap, "CarParkCode",11002, "en", "Device is not registered");

        I18n.putMessageBody(langMap, "CarParkCode",11003, "zh", "无法解析设备数据");
        I18n.putMessageBody(langMap, "CarParkCode",11003, "en", "Unable to parse device data");

        I18n.putMessageBody(langMap, "CarParkCode",11004, "zh", "指定的停车场不存在");
        I18n.putMessageBody(langMap, "CarParkCode",11004, "en", "The designated parking lot does not exist");

        I18n.putMessageBody(langMap, "CarParkCode",11005, "zh", "请提供停车场id和车牌号");
        I18n.putMessageBody(langMap, "CarParkCode",11005, "en", "Please provide parking id and license plate number");

        I18n.putMessageBody(langMap, "CarParkCode",11006, "zh", "指定的停车记录不存在");
        I18n.putMessageBody(langMap, "CarParkCode",11006, "en", "The specified parking lot record does not exist");

        I18n.putMessageBody(langMap, "CarParkCode",11007, "zh", "该记录存在异常");
        I18n.putMessageBody(langMap, "CarParkCode",11007, "en", "There is an exception in this record");

        I18n.putMessageBody(langMap, "CarParkCode",11008, "zh", "关卡不存在");
        I18n.putMessageBody(langMap, "CarParkCode",11008, "en", "Checkpoint do not exist");

        I18n.putMessageBody(langMap, "CarParkCode",11009, "zh", "结束时间必须大于开始时间");
        I18n.putMessageBody(langMap, "CarParkCode",11009, "en", "End time must be greater than start time");

        I18n.putMessageBody(langMap, "CarParkCode",11010, "zh", "没有找到收费规则");
        I18n.putMessageBody(langMap, "CarParkCode",11010, "en", "No charging rules found");

        I18n.putMessageBody(langMap, "CarParkCode",11011, "zh", "暂时未支持的品牌设备");
        I18n.putMessageBody(langMap, "CarParkCode",11011, "en", "Brand devices that are not currently supported");

        I18n.putMessageBody(langMap, "CarParkCode",11012, "zh", "设备品牌未指定");
        I18n.putMessageBody(langMap, "CarParkCode",11012, "en", "Device brand is not specified");

        I18n.putMessageBody(langMap, "CarParkCode",11013, "zh", "设备序列号未指定");
        I18n.putMessageBody(langMap, "CarParkCode",11013, "en", "Device serial number is not specified");

        I18n.putMessageBody(langMap, "CarParkCode",11014, "zh", "重复申请通行");
        I18n.putMessageBody(langMap, "CarParkCode",11014, "en", "Repeat application");

        I18n.putMessageBody(langMap, "CarParkCode",11015, "zh", "申请通行记录不存在");
        I18n.putMessageBody(langMap, "CarParkCode",11015, "en", "Application pass record does not exist");

        I18n.putMessageBody(langMap, "CarParkCode",11016, "zh", "未缴纳停车费");
        I18n.putMessageBody(langMap, "CarParkCode",11016, "en", "Unpaid parking fee");

        I18n.putMessageBody(langMap, "CarParkCode",11017, "zh", "距离订阅时间太近");
        I18n.putMessageBody(langMap, "CarParkCode",11017, "en", "Too close to subscription time");

        I18n.putMessageBody(langMap, "CarParkCode",11018, "zh", "距离订阅时间太长");
        I18n.putMessageBody(langMap, "CarParkCode",11018, "en", "Too long to subscribe");

        I18n.putMessageBody(langMap, "CarParkCode",11019, "zh", "车位不足");
        I18n.putMessageBody(langMap, "CarParkCode",11019, "en", "Insufficient parking spaces");

        I18n.putMessageBody(langMap, "CarParkCode",11020, "zh", "暂停营业");
        I18n.putMessageBody(langMap, "CarParkCode",11020, "en", "Suspend business");

        I18n.putMessageBody(langMap, "CarParkCode",11021, "zh", "没权限操作该停车场相关数据");
        I18n.putMessageBody(langMap, "CarParkCode",11021, "en", "No permission to operate the parking lot related data");

        I18n.putMessageBody(langMap, "CarParkCode",11022, "zh", "指定的车辆不在停车场内");
        I18n.putMessageBody(langMap, "CarParkCode",11022, "en", "The designated vehicle is not in the car park");

        I18n.putMessageBody(langMap, "CarParkCode",11023, "zh", "车辆不在出口");
        I18n.putMessageBody(langMap, "CarParkCode",11023, "en", "The vehicle is not at the exit");

        I18n.putMessageBody(langMap, "CarParkCode",11024, "zh", "还未绑定车牌号");
        I18n.putMessageBody(langMap, "CarParkCode",11024, "en", "The license plate number has not been bound yet");

        I18n.putMessageBody(langMap, "CarParkCode",11025, "zh", "该活动未设置主店铺");
        I18n.putMessageBody(langMap, "CarParkCode",11025, "en", "There is no main store set for this activity");

        I18n.putMessageBody(langMap, "CarParkCode",11026, "zh", "车辆类型不存在");
        I18n.putMessageBody(langMap, "CarParkCode",11026, "en", "Vehicle type does not exist");

        I18n.putMessageBody(langMap, "CarParkCode",11027, "zh", "套餐产品不存在");
        I18n.putMessageBody(langMap, "CarParkCode",11027, "en", "Package product does not exist");

        I18n.putMessageBody(langMap, "CarParkCode",11028, "zh", "还未绑定任何停车场");
        I18n.putMessageBody(langMap, "CarParkCode",11028, "en", "No parking lot has been bound yet");

        I18n.putMessageBody(langMap, "CarParkCode",11029, "zh", "到访记录未找到");
        I18n.putMessageBody(langMap, "CarParkCode",11029, "en", "No visit record found");

        I18n.putMessageBody(langMap, "CarParkCode",11030, "zh", "到访记录已存在");
        I18n.putMessageBody(langMap, "CarParkCode",11030, "en", "The visit record already exists");

        I18n.putMessageBody(langMap, "CarParkCode",11031, "zh", "缺少设备编号");
        I18n.putMessageBody(langMap, "CarParkCode",11031, "en", "Missing device number");

        I18n.putMessageBody(langMap, "CarParkCode",11032, "zh", "设备被占用");
        I18n.putMessageBody(langMap, "CarParkCode",11032, "en", "Equipment occupied");

        //FileSystemCode
        I18n.putMessageBody(langMap, "FileSystemCode",25001, "zh", "上传文件为空");
        I18n.putMessageBody(langMap, "FileSystemCode",25001, "en", "Upload file is empty");

        I18n.putMessageBody(langMap, "FileSystemCode",25002, "zh", "业务Id为空");
        I18n.putMessageBody(langMap, "FileSystemCode",25002, "en", "Business Id is empty");

        I18n.putMessageBody(langMap, "FileSystemCode",25003, "zh", "上传文件服务器失败");
        I18n.putMessageBody(langMap, "FileSystemCode",25003, "en", "Failed to upload file server");

        I18n.putMessageBody(langMap, "FileSystemCode",25004, "zh", "删除的文件不存在");
        I18n.putMessageBody(langMap, "FileSystemCode",25004, "en", "The deleted file does not exist");

        I18n.putMessageBody(langMap, "FileSystemCode",25005, "zh", "删除文件信息失败");
        I18n.putMessageBody(langMap, "FileSystemCode",25005, "en", "Failed to delete file information");

        I18n.putMessageBody(langMap, "FileSystemCode",25006, "zh", "删除文件失败");
        I18n.putMessageBody(langMap, "FileSystemCode",25006, "en", "Failed to delete file");

        I18n.putMessageBody(langMap, "FileSystemCode",25007, "zh", "上传文件的元信息请使用json格式");
        I18n.putMessageBody(langMap, "FileSystemCode",25007, "en", "Please use the json format for the meta information of the uploaded file");

        I18n.putMessageBody(langMap, "FileSystemCode",25008, "zh", "上传文件用户为空");
        I18n.putMessageBody(langMap, "FileSystemCode",25008, "en", "The user who uploaded the file is empty");

        I18n.putMessageBody(langMap, "FileSystemCode",25009, "zh", "初始化fastDFS环境出错");
        I18n.putMessageBody(langMap, "FileSystemCode",25009, "en", "Error initializing fastDFS environment");

        I18n.putMessageBody(langMap, "FileSystemCode",25010, "zh", "无效的文件名");
        I18n.putMessageBody(langMap, "FileSystemCode",25010, "en", "Invalid file name");

        I18n.putMessageBody(langMap, "FileSystemCode",25011, "zh", "不支持的文件服务平台");
        I18n.putMessageBody(langMap, "FileSystemCode",25011, "en", "Unsupported file service platform");

        //MessageCode
        I18n.putMessageBody(langMap, "MessageCode",60001, "zh", "指定的消息记录不存在");
        I18n.putMessageBody(langMap, "MessageCode",60001, "en", "The specified message record does not exist");

        I18n.putMessageBody(langMap, "MessageCode",60002, "zh", "您无权操作此条消息数据");
        I18n.putMessageBody(langMap, "MessageCode",60002, "en", "You don't have permission to manipulate this message data");

        I18n.putMessageBody(langMap, "MessageCode",60003, "zh", "消息发送者id与当前用户id不匹配");
        I18n.putMessageBody(langMap, "MessageCode",60003, "en", "Message sender id does not match current user id");

        I18n.putMessageBody(langMap, "MessageCode",60004, "zh", "不合法订阅通知消息类型");
        I18n.putMessageBody(langMap, "MessageCode",60004, "en", "Illegal subscription notification message type");

        //PayCode
        I18n.putMessageBody(langMap, "PayCode",12000, "zh", "订单编号不能为空");
        I18n.putMessageBody(langMap, "PayCode",12000, "en", "Order number cannot be empty");

        I18n.putMessageBody(langMap, "PayCode",12001, "zh", "退款金额必须大于0");
        I18n.putMessageBody(langMap, "PayCode",12001, "en", "The refund amount must be greater than 0");

        I18n.putMessageBody(langMap, "PayCode",12002, "zh", "获取预支付交易会话标识失败");
        I18n.putMessageBody(langMap, "PayCode",12002, "en", "Failed to obtain prepaid transaction session ID");

        I18n.putMessageBody(langMap, "PayCode",12003, "zh", "微信支付统一下单失败");
        I18n.putMessageBody(langMap, "PayCode",12003, "en", "WeChat Pay failed to place a unified order");

        I18n.putMessageBody(langMap, "PayCode",12004, "zh", "微信退款失败");
        I18n.putMessageBody(langMap, "PayCode",12004, "en", "WeChat refund failed");

        I18n.putMessageBody(langMap, "PayCode",12005, "zh", "订单不存在");
        I18n.putMessageBody(langMap, "PayCode",12005, "en", "Order does not exist");

        I18n.putMessageBody(langMap, "PayCode",12006, "zh", "无需支付");
        I18n.putMessageBody(langMap, "PayCode",12006, "en", "No need to pay");

        I18n.putMessageBody(langMap, "PayCode",12007, "zh", "支付机构不存在");
        I18n.putMessageBody(langMap, "PayCode",12007, "en", "Payment institution does not exist");

        I18n.putMessageBody(langMap, "PayCode",12008, "zh", "商户支付账号不存在");
        I18n.putMessageBody(langMap, "PayCode",12008, "en", "Merchant payment account does not exist");

        I18n.putMessageBody(langMap, "PayCode",12009, "zh", "没有找到停车场支付配置");
        I18n.putMessageBody(langMap, "PayCode",12009, "en", "No parking payment configuration found");

        I18n.putMessageBody(langMap, "PayCode",12010, "zh", "该优惠券不属于你");
        I18n.putMessageBody(langMap, "PayCode",12010, "en", "This coupon does not belong to you");

        I18n.putMessageBody(langMap, "PayCode",12011, "zh", "优惠券使用场景不匹配");
        I18n.putMessageBody(langMap, "PayCode",12011, "en", "Coupon usage scenarios do not match");

        I18n.putMessageBody(langMap, "PayCode",12012, "zh", "优惠券已过期或未生效");
        I18n.putMessageBody(langMap, "PayCode",12012, "en", "Coupon has expired or is not yet valid");

        I18n.putMessageBody(langMap, "PayCode",12013, "zh", "缺少支付宝应用公钥证书路径");
        I18n.putMessageBody(langMap, "PayCode",12013, "en", "Missing Alipay application public key certificate path");

        I18n.putMessageBody(langMap, "PayCode",12014, "zh", "缺少支付宝公钥证书路径");
        I18n.putMessageBody(langMap, "PayCode",12014, "en", "Alipay public key certificate path is missing");

        I18n.putMessageBody(langMap, "PayCode",12015, "zh", "缺少支付宝根证书路径");
        I18n.putMessageBody(langMap, "PayCode",12015, "en", "Alipay root certificate path is missing");

        I18n.putMessageBody(langMap, "PayCode",12016, "zh", "缺少或错误证书路径配置");
        I18n.putMessageBody(langMap, "PayCode",12016, "en", "Missing or wrong certificate path configuration");

        I18n.putMessageBody(langMap, "PayCode",12017, "zh", "支付宝预下单错误");
        I18n.putMessageBody(langMap, "PayCode",12017, "en", "Alipay pre-order error");

        I18n.putMessageBody(langMap, "PayCode",12018, "zh", "微信支付通知失败");
        I18n.putMessageBody(langMap, "PayCode",12018, "en", "WeChat payment notification failed");

        I18n.putMessageBody(langMap, "PayCode",12019, "zh", "税务账号不存在");
        I18n.putMessageBody(langMap, "PayCode",12019, "en", "Tax account does not exist");

        I18n.putMessageBody(langMap, "PayCode",12020, "zh", "税务账号缺少配置");
        I18n.putMessageBody(langMap, "PayCode",12020, "en", "Tax account is missing configuration");

        I18n.putMessageBody(langMap, "PayCode",12021, "zh", "税务平台不存在");
        I18n.putMessageBody(langMap, "PayCode",12021, "en", "Tax platform does not exist");

        I18n.putMessageBody(langMap, "PayCode",12022, "zh", "优惠使用对象不匹配");
        I18n.putMessageBody(langMap, "PayCode",12022, "en", "Preference object does not match");

        //AccountCode
        I18n.putMessageBody(langMap, "AccountCode",13000, "zh", "指定的资金账户不存在");
        I18n.putMessageBody(langMap, "AccountCode",13000, "en", "The specified fund account does not exist");

        I18n.putMessageBody(langMap, "AccountCode",13001, "zh", "资金账户余额不足");
        I18n.putMessageBody(langMap, "AccountCode",13001, "en", "Insufficient fund account balance");

        I18n.putMessageBody(langMap, "AccountCode",13002, "zh", "未指定资金账户积分类型或用户");
        I18n.putMessageBody(langMap, "AccountCode",13002, "en", "No credit account type or user specified");

        I18n.putMessageBody(langMap, "AccountCode",13003, "zh", "指定的积分类型不存在");
        I18n.putMessageBody(langMap, "AccountCode",13003, "en", "The specified credit type does not exist");

        //Charging
        I18n.putMessageBody(langMap, "ChargingCode",14000, "zh", "充电设备故障");
        I18n.putMessageBody(langMap, "ChargingCode",14000, "en", "Faulty charging equipment");

        I18n.putMessageBody(langMap, "ChargingCode",14001, "zh", "重复绑定车牌");
        I18n.putMessageBody(langMap, "ChargingCode",14001, "en", "Repeated binding license plate");

        I18n.putMessageBody(langMap, "ChargingCode",14002, "zh", "设备未注册");
        I18n.putMessageBody(langMap, "ChargingCode",14002, "en", "Device not registered");

        I18n.putMessageBody(langMap, "ChargingCode",14003, "zh", "无法解析设备数据");
        I18n.putMessageBody(langMap, "ChargingCode",14003, "en", "Could not parse device data");

        I18n.putMessageBody(langMap, "ChargingCode",14004, "zh", "结束时间必须大于开始时间");
        I18n.putMessageBody(langMap, "ChargingCode",14004, "en", "End time must be greater than start time");

        I18n.putMessageBody(langMap, "ChargingCode",14005, "zh", "没有找到收费规则");
        I18n.putMessageBody(langMap, "AccountCode",14005, "en", "No charge rules found");

        I18n.putMessageBody(langMap, "ChargingCode",14006, "zh", "暂时未支持的品牌设备");
        I18n.putMessageBody(langMap, "ChargingCode",14006, "en", "Brand devices that are not currently supported");

        I18n.putMessageBody(langMap, "ChargingCode",14007, "zh", "设备品牌未指定");
        I18n.putMessageBody(langMap, "ChargingCode",14007, "en", "Device brand not specified");

        I18n.putMessageBody(langMap, "ChargingCode",14008, "zh", "设备序列号未指定");
        I18n.putMessageBody(langMap, "ChargingCode",14008, "en", "Device serial number not specified");

        I18n.putMessageBody(langMap, "ChargingCode",14009, "zh", "设备不在线");
        I18n.putMessageBody(langMap, "ChargingCode",14009, "en", "Device is offline");

        I18n.putMessageBody(langMap, "ChargingCode",14010, "zh", "指定的充电口不存在");
        I18n.putMessageBody(langMap, "ChargingCode",14010, "en", "The specified charging port does not exist");

        I18n.putMessageBody(langMap, "ChargingCode",14011, "zh", "充电口已被占用");
        I18n.putMessageBody(langMap, "ChargingCode",14011, "en", "The charging port is occupied");

        I18n.putMessageBody(langMap, "ChargingCode",14012, "zh", "非充电中用户");
        I18n.putMessageBody(langMap, "ChargingCode",14012, "en", "non-charging users");

        I18n.putMessageBody(langMap, "ChargingCode",14013, "zh", "缺少收费规则");
        I18n.putMessageBody(langMap, "ChargingCode",14013, "en", "Missing fee rules");

        I18n.putMessageBody(langMap, "ChargingCode",14014, "zh", "未匹配到充电价格");
        I18n.putMessageBody(langMap, "ChargingCode",14014, "en", "Not matched to charging price");

        I18n.putMessageBody(langMap, "ChargingCode",14015, "zh", "该记录不属于您");
        I18n.putMessageBody(langMap, "ChargingCode",14015, "en", "The record does not belong to you");

        //SmsCode
        I18n.putMessageBody(langMap, "SmsCode",80001, "zh", "频繁发送");
        I18n.putMessageBody(langMap, "SmsCode",80001, "en", "Send frequently");

        I18n.putMessageBody(langMap, "SmsCode",80002, "zh", "无效的短信验证码");
        I18n.putMessageBody(langMap, "SmsCode",80002, "en", "Invalid SMS verification code");

        I18n.putMessageBody(langMap, "SmsCode",80003, "zh", "校验太频繁，请稍后再试");
        I18n.putMessageBody(langMap, "SmsCode",80003, "en", "Checking too frequently, please try again later");

        I18n.putMessageBody(langMap, "SmsCode",80004, "zh", "缺少手机号");
        I18n.putMessageBody(langMap, "SmsCode",80004, "en", "Phone number missing");

        //FriendsCode
        I18n.putMessageBody(langMap, "FriendsCode",70001, "zh", "指定的好友申请记录不存在");
        I18n.putMessageBody(langMap, "FriendsCode",70001, "en", "The specified friend application record does not exist");

        I18n.putMessageBody(langMap, "FriendsCode",70002, "zh", "该友好申请记录不属于您");
        I18n.putMessageBody(langMap, "FriendsCode",70002, "en", "This friendly application record does not belong to you");

        I18n.putMessageBody(langMap, "FriendsCode",70003, "zh", "该好友申请记录已处理过了");
        I18n.putMessageBody(langMap, "FriendsCode",70003, "en", "The friend application record has been processed");

        I18n.putMessageBody(langMap, "FriendsCode",70004, "zh", "不能添加自己为好友");
        I18n.putMessageBody(langMap, "FriendsCode",70004, "en", "Can't add yourself as a friend");

        I18n.putMessageBody(langMap, "FriendsCode",70005, "zh", "好友已经存在");
        I18n.putMessageBody(langMap, "FriendsCode",70005, "en", "Friend already exists");

        I18n.putMessageBody(langMap, "FriendsCode",70006, "zh", "指定的好友不存在");
        I18n.putMessageBody(langMap, "FriendsCode",70006, "en", "The specified friend does not exist");

        I18n.putMessageBody(langMap, "FriendsCode",70007, "zh", "群已经存在");
        I18n.putMessageBody(langMap, "FriendsCode",70007, "en", "Group already exists");

        I18n.putMessageBody(langMap, "FriendsCode",70008, "zh", "指定的群不存在");
        I18n.putMessageBody(langMap, "FriendsCode",70008, "en", "The specified group does not exist");

        I18n.putMessageBody(langMap, "FriendsCode",70009, "zh", "您不具备该群的管理");
        I18n.putMessageBody(langMap, "FriendsCode",70009, "en", "You do not have management of this group");

        //AuthCode
        I18n.putMessageBody(langMap, "AuthCode",24001, "zh", "请输入账号");
        I18n.putMessageBody(langMap, "AuthCode",24001, "en", "Please input Username");

        I18n.putMessageBody(langMap, "AuthCode",24002, "zh", "请输入密码");
        I18n.putMessageBody(langMap, "AuthCode",24002, "en", "Please enter the password");

        I18n.putMessageBody(langMap, "AuthCode",24003, "zh", "请输入验证码");
        I18n.putMessageBody(langMap, "AuthCode",24003, "en", "please enter verification code");

        I18n.putMessageBody(langMap, "AuthCode",24004, "zh", "账号不存在");
        I18n.putMessageBody(langMap, "AuthCode",24004, "en", "Account does not exist");

        I18n.putMessageBody(langMap, "AuthCode",24005, "zh", "账号或密码错误");
        I18n.putMessageBody(langMap, "AuthCode",24005, "en", "Incorrect username or password");

        I18n.putMessageBody(langMap, "AuthCode",24006, "zh", "登陆过程出现异常请尝试重新操作");
        I18n.putMessageBody(langMap, "AuthCode",24006, "en", "An exception occurs during the login process, please try again");

        I18n.putMessageBody(langMap, "AuthCode",24007, "zh", "申请令牌失败");
        I18n.putMessageBody(langMap, "AuthCode",24007, "en", "Failed to apply for token");

        I18n.putMessageBody(langMap, "AuthCode",24008, "zh", "存储令牌失败");
        I18n.putMessageBody(langMap, "AuthCode",24008, "en", "Failed to store token");

        I18n.putMessageBody(langMap, "AuthCode",24009, "zh", "非法的身份令牌");
        I18n.putMessageBody(langMap, "AuthCode",24009, "en", "Illegal identity token");

        I18n.putMessageBody(langMap, "AuthCode",24010, "zh", "身份信息已过期");
        I18n.putMessageBody(langMap, "AuthCode",24010, "en", "Identity information has expired");

        I18n.putMessageBody(langMap, "AuthCode",24011, "zh", "退出失败");
        I18n.putMessageBody(langMap, "AuthCode",24011, "en", "Exit failed");

        I18n.putMessageBody(langMap, "AuthCode",24012, "zh", "该权限存在下级，禁止删除");
        I18n.putMessageBody(langMap, "AuthCode",24012, "en", "This permission has subordinates, and it is forbidden to delete");

        I18n.putMessageBody(langMap, "AuthCode",24013, "zh", "权限模块-控制器-方法格式错误");
        I18n.putMessageBody(langMap, "AuthCode",24013, "en", "Permission module-controller-method format error");

        I18n.putMessageBody(langMap, "AuthCode",24014, "zh", "该权限存在下级，禁止移动");
        I18n.putMessageBody(langMap, "AuthCode",24014, "en", "This permission has subordinates and is forbidden to move");

        I18n.putMessageBody(langMap, "AuthCode",24015, "zh", "请提供用户权限列表");
        I18n.putMessageBody(langMap, "AuthCode",24015, "en", "Please provide a list of user permissions");

        I18n.putMessageBody(langMap, "AuthCode",24016, "zh", "权限不足");
        I18n.putMessageBody(langMap, "AuthCode",24016, "en", "Insufficient permissions");

        I18n.putMessageBody(langMap, "AuthCode",24017, "zh", "微信登录失败");
        I18n.putMessageBody(langMap, "AuthCode",24017, "en", "WeChat login failed");

        //RoleCode
        I18n.putMessageBody(langMap, "RoleCode",90000, "zh", "请提供用户角色列表数据");
        I18n.putMessageBody(langMap, "RoleCode",90000, "en", "Please provide user role list data");

        //UcenterCode
        I18n.putMessageBody(langMap, "UcenterCode",23001, "zh", "请输入账号");
        I18n.putMessageBody(langMap, "UcenterCode",23001, "en", "Please input Username");

        I18n.putMessageBody(langMap, "UcenterCode",23002, "zh", "请输入密码");
        I18n.putMessageBody(langMap, "UcenterCode",23002, "en", "Please enter the password");

        I18n.putMessageBody(langMap, "UcenterCode",23003, "zh", "请输入验证码");
        I18n.putMessageBody(langMap, "UcenterCode",23003, "en", "please enter verification code");

        I18n.putMessageBody(langMap, "UcenterCode",23004, "zh", "账号不存在");
        I18n.putMessageBody(langMap, "UcenterCode",23004, "en", "Account does not exist");

        I18n.putMessageBody(langMap, "UcenterCode",23005, "zh", "账号或密码错误");
        I18n.putMessageBody(langMap, "UcenterCode",23005, "en", "Incorrect username or password");

        I18n.putMessageBody(langMap, "UcenterCode",23006, "zh", "登陆过程出现异常请尝试重新操作");
        I18n.putMessageBody(langMap, "UcenterCode",23006, "en", "An exception occurs during the login process, please try again");

        I18n.putMessageBody(langMap, "UcenterCode",23007, "zh", "用户名已经存在");
        I18n.putMessageBody(langMap, "UcenterCode",23007, "en", "username already exists");

        I18n.putMessageBody(langMap, "UcenterCode",23008, "zh", "该手机号已经注册过了");
        I18n.putMessageBody(langMap, "UcenterCode",23008, "en", "The phone number has already been registered");

        I18n.putMessageBody(langMap, "UcenterCode",23009, "zh", "该用户已经存在");
        I18n.putMessageBody(langMap, "UcenterCode",23009, "en", "The user already exists");

        I18n.putMessageBody(langMap, "UcenterCode",23010, "zh", "指定的用户不存在");
        I18n.putMessageBody(langMap, "UcenterCode",23010, "en", "The specified user does not exist");

        I18n.putMessageBody(langMap, "UcenterCode",23011, "zh", "该手机还未注册");
        I18n.putMessageBody(langMap, "UcenterCode",23011, "en", "The phone has not been registered");

        I18n.putMessageBody(langMap, "UcenterCode",23012, "zh", "缺少微信配置");
        I18n.putMessageBody(langMap, "UcenterCode",23012, "en", "Missing WeChat configuration");

        I18n.putMessageBody(langMap, "UcenterCode",23013, "zh", "指定的微信配置不存在");
        I18n.putMessageBody(langMap, "UcenterCode",23013, "en", "The specified WeChat configuration does not exist");

        I18n.putMessageBody(langMap, "UcenterCode",23014, "zh", "指定的系统配置不存在");
        I18n.putMessageBody(langMap, "UcenterCode",23014, "en", "The specified System configuration does not exist");

        I18n.putMessageBody(langMap, "UcenterCode",23015, "zh", "图形验证码不匹配");
        I18n.putMessageBody(langMap, "UcenterCode",23015, "en", "Graphic verification code does not match");

        I18n.putMessageBody(langMap, "UcenterCode",23016, "zh", "用户证件未上传或未审核通过");
        I18n.putMessageBody(langMap, "UcenterCode",23016, "en", "User ID is not uploaded or not approved");

        I18n.putMessageBody(langMap, "UcenterCode",23017, "zh", "证件号已绑定");
        I18n.putMessageBody(langMap, "UcenterCode",23017, "en", "ID number is bound");

        I18n.putMessageBody(langMap, "UcenterCode",23018, "zh", "调用密钥无效");
        I18n.putMessageBody(langMap, "UcenterCode",23018, "en", "Invalid call key");

        //StaffCode
        I18n.putMessageBody(langMap, "StaffCode",26001, "zh", "指定的员工不存在");
        I18n.putMessageBody(langMap, "StaffCode",26001, "en", "The specified employee does not exist");

        I18n.putMessageBody(langMap, "StaffCode",26002, "zh", "指定的员工不属于您");
        I18n.putMessageBody(langMap, "StaffCode",26002, "en", "The designated employee does not belong to you");

        I18n.putMessageBody(langMap, "StaffCode",26003, "zh", "您不能把您自己添加为员工");
        I18n.putMessageBody(langMap, "StaffCode",26003, "en", "You cannot add yourself as an employee");

        I18n.putMessageBody(langMap, "StaffCode",26004, "zh", "不能重复添加员工");
        I18n.putMessageBody(langMap, "StaffCode",26004, "en", "Employees cannot be added repeatedly");

        //CouponActivityCode
        I18n.putMessageBody(langMap, "CouponActivityCode",27001, "zh", "指定的优惠券活动不存在");
        I18n.putMessageBody(langMap, "CouponActivityCode",27001, "en", "The specified coupon activity does not exist");

        I18n.putMessageBody(langMap, "CouponActivityCode",27002, "zh", "指定的店铺与用户不匹配");
        I18n.putMessageBody(langMap, "CouponActivityCode",27002, "en", "The specified store does not match the user");

        I18n.putMessageBody(langMap, "CouponActivityCode",27003, "zh", "该优惠券类型与优惠券活动不匹配");
        I18n.putMessageBody(langMap, "CouponActivityCode",27003, "en", "The coupon type does not match the coupon activity");

        I18n.putMessageBody(langMap, "CouponActivityCode",27004, "zh", "活动优惠券余额不足");
        I18n.putMessageBody(langMap, "CouponActivityCode",27004, "en", "Insufficient activity coupon balance");

        I18n.putMessageBody(langMap, "CouponActivityCode",27005, "zh", "活动优惠券余额不足");
        I18n.putMessageBody(langMap, "CouponActivityCode",27005, "en", "The activity is not open yet. Please look forward to it");

        I18n.putMessageBody(langMap, "CouponActivityCode",27006, "zh", "活动优惠券余额不足");
        I18n.putMessageBody(langMap, "CouponActivityCode",27006, "en", "Your activity coupon balance is insufficient");

        I18n.putMessageBody(langMap, "CouponActivityCode",27007, "zh", "重复领取");
        I18n.putMessageBody(langMap, "CouponActivityCode",27007, "en", "Repeat collection");

        I18n.putMessageBody(langMap, "CouponActivityCode",27008, "zh", "缺少赠送目标");
        I18n.putMessageBody(langMap, "CouponActivityCode",27008, "en", "Missing gift goal");

        I18n.putMessageBody(langMap, "CouponActivityCode",27009, "zh", "缺少数量");
        I18n.putMessageBody(langMap, "CouponActivityCode",27009, "en", "Missing quantity");

        I18n.putMessageBody(langMap, "CouponActivityCode",27010, "zh", "优惠券已达上限");
        I18n.putMessageBody(langMap, "CouponActivityCode",27010, "en", "The coupon has reached the upper limit");

        //QrCode
        I18n.putMessageBody(langMap, "QrCode",28000, "zh", "指定的二维码不存在");
        I18n.putMessageBody(langMap, "QrCode",28000, "en", "The specified QR code does not exist");

        I18n.putMessageBody(langMap, "QrCode",28001, "zh", "指定的二维码已失效");
        I18n.putMessageBody(langMap, "QrCode",28001, "en", "The specified QR code is invalid");

        //CouponCode
        I18n.putMessageBody(langMap, "CouponCode",29000, "zh", "指定的优惠券类型不存在");
        I18n.putMessageBody(langMap, "CouponCode",29000, "en", "The specified coupon type does not exist");

        I18n.putMessageBody(langMap, "QrCode",29001, "zh", "指定的优惠券类型已经存在");
        I18n.putMessageBody(langMap, "QrCode",29001, "en", "The specified coupon type already exists");

        //AdCode
        I18n.putMessageBody(langMap, "AdCode",31000, "zh", "指定的广告不存在");
        I18n.putMessageBody(langMap, "AdCode",31000, "en", "The specified ad does not exist");

        //LogisticsCode
        I18n.putMessageBody(langMap, "LogisticsCode",32000, "zh", "重复预约");
        I18n.putMessageBody(langMap, "LogisticsCode",32000, "en", "Repeat appointment");

        I18n.putMessageBody(langMap, "LogisticsCode",32001, "zh", "预约已满");
        I18n.putMessageBody(langMap, "LogisticsCode",32001, "en", "Appointment is full");

        I18n.putMessageBody(langMap, "LogisticsCode",32002, "zh", "不在预约时间段内");
        I18n.putMessageBody(langMap, "LogisticsCode",32002, "en", "Not within the appointment time period");

        I18n.putMessageBody(langMap, "LogisticsCode",32003, "zh", "该预约记录不属于您");
        I18n.putMessageBody(langMap, "LogisticsCode",32003, "en", "This appointment record does not belong to you");

        I18n.putMessageBody(langMap, "LogisticsCode",32004, "zh", "当前预约记录状态禁止签到操作");
        I18n.putMessageBody(langMap, "LogisticsCode",32004, "en", "The current reservation record status prohibits the check-in operation");

        I18n.putMessageBody(langMap, "LogisticsCode",32005, "zh", "找不到月台");
        I18n.putMessageBody(langMap, "LogisticsCode",32005, "en", "Can't find platform");

        I18n.putMessageBody(langMap, "LogisticsCode",32006, "zh", "找不到排队区域");
        I18n.putMessageBody(langMap, "LogisticsCode",32006, "en", "Can't find queuing area");

        I18n.putMessageBody(langMap, "LogisticsCode",32007, "zh", "未处在排队中");
        I18n.putMessageBody(langMap, "LogisticsCode",32007, "en", "not in line");

        I18n.putMessageBody(langMap, "LogisticsCode",32008, "zh", "禁止切换顺序");
        I18n.putMessageBody(langMap, "LogisticsCode",32008, "en", "Prohibit switching order");

        I18n.putMessageBody(langMap, "LogisticsCode",32009, "zh", "只能操作子级数据");
        I18n.putMessageBody(langMap, "LogisticsCode",32009, "en", "Only child data can be operated");

        I18n.putMessageBody(langMap, "LogisticsCode",32010, "zh", "找不到对应序号的任务数据");
        I18n.putMessageBody(langMap, "LogisticsCode",32010, "en", "The task data corresponding to the serial number cannot be found");

        I18n.putMessageBody(langMap, "LogisticsCode",32011, "zh", "指定的货物类型不存在");
        I18n.putMessageBody(langMap, "LogisticsCode",32011, "en", "The specified cargo type does not exist");

        //WeiXinCode
        I18n.putMessageBody(langMap, "WeiXinCode",33000, "zh", "指定的微信模板不存在");
        I18n.putMessageBody(langMap, "WeiXinCode",33000, "en", "The specified WeChat template does not exist");

        //其它语言待扩展...
        return langMap;
    }

    /**
     * 获取指定语言的消息
     * @param resultCode
     * @param lang
     * @return
     */
    public static String getMessageByCodeAndLang(ResultCode resultCode, String lang)
    {
        if(I18n.langMap==null || I18n.langMap.size()==0){
            I18n.langMap = I18n.initLangMap();
        }
        return I18n.langMap.get(resultCode.getClass().getSimpleName()).get(resultCode.code()).get(lang);
    }

    //填充数据
    public static void putMessageBody(Map<String, Map<Integer, Map<String, String>>> langMap, String codeClassName, Integer code , String lang, String message)
    {
        if(langMap.get(codeClassName)==null || langMap.get(codeClassName).size()==0){
            Map<Integer, Map<String, String>> codes = new HashMap<Integer, Map<String, String>>();
            Map<String, String> messageMap = new HashMap<String, String>();
            messageMap.put(lang, message);
            codes.put(code, messageMap);
            langMap.put(codeClassName, codes);
        }else{
            if(langMap.get(codeClassName).get(code)==null || langMap.get(codeClassName).get(code).size()==0){
                Map<String, String> messageMap = new HashMap<String, String>();
                messageMap.put(lang, message);
                langMap.get(codeClassName).put(code, messageMap);
            }else{
                langMap.get(codeClassName).get(code).put(lang, message);
            }
        }

    }

    public static ResultCode getFullMessage(ResultCode resultCode) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String lang = request.getHeader("lang");
        if(lang==null || lang.equals("")){
            lang = "zh";
        }
        try{
            String message = I18n.getMessageByCodeAndLang(resultCode, lang);
            resultCode.setMessage(message);

        }catch (Exception e){
            e.printStackTrace();
        }

        return resultCode;
    }
}
