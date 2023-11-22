package com.cf.forward.hk.hardware.hcsdk;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import com.sun.jna.examples.win32.W32API;
import com.sun.jna.examples.win32.W32API.HWND;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.ShortByReference;

//SDK接口说明,HCNetSDK.dll
public interface HCNetSDK extends StdCallLibrary {

    //HCNetSDK INSTANCE = (HCNetSDK) Native.loadLibrary(System.getProperty("user.dir") + "\\HCNetSDK.dll", HCNetSDK.class);
    HCNetSDK INSTANCE = (HCNetSDK) Native.loadLibrary( "HCNetSDK", HCNetSDK.class);
    /***宏定义***/
    //常量

    public static final int MAX_NAMELEN = 16;    //DVR本地登陆名
    public static final int MAX_RIGHT = 32;    //设备支持的权限（1-12表示本地权限，13-32表示远程权限）
    public static final int NAME_LEN = 32;    //用户名长度
    public static final int PASSWD_LEN = 16;    //密码长度
    public static final int SERIALNO_LEN = 48;   //序列号长度
    public static final int MACADDR_LEN = 6;      //mac地址长度
    public static final int MAX_ETHERNET = 2;   //设备可配以太网络
    public static final int PATHNAME_LEN = 128;   //路径长度
    public static final int MAX_TIMESEGMENT_V30 = 8;    //9000设备最大时间段数
    public static final int MAX_TIMESEGMENT = 4;   //8000设备最大时间段数
    public static final int MAX_SHELTERNUM = 4;   //8000设备最大遮挡区域数
    public static final int MAX_DAYS = 7;      //每周天数
    public static final int PHONENUMBER_LEN = 32;   //pppoe拨号号码最大长度
    public static final int MAX_DISKNUM_V30 = 33;        //9000设备最大硬盘数/* 最多33个硬盘(包括16个内置SATA硬盘、1个eSATA硬盘和16个NFS盘) */
    public static final int MAX_DISKNUM = 16;     //8000设备最大硬盘数
    public static final int MAX_DISKNUM_V10 = 8;   //1.2版本之前版本
    public static final int MAX_WINDOW_V30 = 32; //9000设备本地显示最大播放窗口数
    public static final int MAX_WINDOW = 16;    //8000设备最大硬盘数
    public static final int MAX_VGA_V30 = 4;     //9000设备最大可接VGA数
    public static final int MAX_VGA = 1;    //8000设备最大可接VGA数
    public static final int MAX_USERNUM_V30 = 32;  //9000设备最大用户数
    public static final int MAX_USERNUM = 16;  //8000设备最大用户数
    public static final int MAX_EXCEPTIONNUM_V30 = 32;  //9000设备最大异常处理数
    public static final int MAX_EXCEPTIONNUM = 16;   //8000设备最大异常处理数
    public static final int MAX_LINK = 6;    //8000设备单通道最大视频流连接数
    public static final int MAX_DECPOOLNUM = 4;   //单路解码器每个解码通道最大可循环解码数
    public static final int MAX_DECNUM = 4;    //单路解码器的最大解码通道数（实际只有一个，其他三个保留）
    public static final int MAX_TRANSPARENTNUM = 2;   //单路解码器可配置最大透明通道数
    public static final int MAX_CYCLE_CHAN = 16;   //单路解码器最大轮循通道数
    public static final int MAX_DIRNAME_LENGTH = 80;   //最大目录长度
    public static final int MAX_STRINGNUM_V30 = 8;        //9000设备最大OSD字符行数数
    public static final int MAX_STRINGNUM = 4;   //8000设备最大OSD字符行数数
    public static final int MAX_STRINGNUM_EX = 8;   //8000定制扩展
    public static final int MAX_AUXOUT_V30 = 16;   //9000设备最大辅助输出数
    public static final int MAX_AUXOUT = 4;      //8000设备最大辅助输出数
    public static final int MAX_HD_GROUP = 16;   //9000设备最大硬盘组数
    public static final int MAX_NFS_DISK = 8;    //8000设备最大NFS硬盘数
    public static final int IW_ESSID_MAX_SIZE = 32;    //WIFI的SSID号长度
    public static final int IW_ENCODING_TOKEN_MAX = 32;   //WIFI密锁最大字节数
    public static final int MAX_SERIAL_NUM = 64;    //最多支持的透明通道路数
    public static final int MAX_DDNS_NUMS = 10;   //9000设备最大可配ddns数
    public static final int MAX_DOMAIN_NAME = 64;    /* 最大域名长度 */

    public static final int MAX_EMAIL_ADDR_LEN = 48;  //最大email地址长度
    public static final int MAX_EMAIL_PWD_LEN = 32;     //最大email密码长度
    public static final int MAXPROGRESS = 100;  //回放时的最大百分率
    public static final int MAX_SERIALNUM = 2;    //8000设备支持的串口数 1-232， 2-485
    public static final int CARDNUM_LEN = 20;    //卡号长度
    public static final int MAX_VIDEOOUT_V30 = 4;      //9000设备的视频输出数
    public static final int MAX_VIDEOOUT = 2;      //8000设备的视频输出数
    public static final int MAX_PRESET_V30 = 256;    /* 9000设备支持的云台预置点数 */
    public static final int MAX_TRACK_V30 = 256;    /* 9000设备支持的云台轨迹数 */
    public static final int MAX_CRUISE_V30 = 256;    /* 9000设备支持的云台巡航数 */
    public static final int MAX_PRESET = 128;    /* 8000设备支持的云台预置点数 */
    public static final int MAX_TRACK = 128;    /* 8000设备支持的云台轨迹数 */
    public static final int MAX_CRUISE = 128;    /* 8000设备支持的云台巡航数 */
    public static final int CRUISE_MAX_PRESET_NUMS = 32;    /* 一条巡航最多的巡航点 */
    public static final int MAX_SERIAL_PORT = 8;    //9000设备支持232串口数
    public static final int MAX_PREVIEW_MODE = 8;    /* 设备支持最大预览模式数目 1画面,4画面,9画面,16画面.... */
    public static final int MAX_MATRIXOUT = 16;  /* 最大模拟矩阵输出个数 */
    public static final int LOG_INFO_LEN = 11840; /* 日志附加信息 */
    public static final int DESC_LEN = 16;    /* 云台描述字符串长度 */
    public static final int PTZ_PROTOCOL_NUM = 200;   /* 9000最大支持的云台协议数 */
    public static final int MAX_AUDIO = 1;    //8000语音对讲通道数
    public static final int MAX_AUDIO_V30 = 2;   //9000语音对讲通道数
    public static final int MAX_CHANNUM = 16;   //8000设备最大通道数
    public static final int MAX_ALARMIN = 16;  //8000设备最大报警输入数
    public static final int MAX_ALARMOUT = 4;    //8000设备最大报警输出数
    //9000 IPC接入
    public static final int MAX_ANALOG_CHANNUM = 32;    //最大32个模拟通道
    public static final int MAX_ANALOG_ALARMOUT = 32;    //最大32路模拟报警输出
    public static final int MAX_ANALOG_ALARMIN = 32;    //最大32路模拟报警输入
    public static final int MAX_IP_ALARMIN_V40 = 4096;    //允许加入的最多报警输入数
    public static final int MAX_IP_ALARMOUT_V40 = 4096;    //允许加入的最多报警输出数
    public static final int MAX_ALARMOUT_V40 = (MAX_IP_ALARMOUT_V40 + MAX_ANALOG_ALARMOUT); //4128
    public static final int MAX_ALARMIN_V40 = (MAX_IP_ALARMIN_V40 + MAX_ANALOG_ALARMOUT); //4128
    public static final int MAX_CHANNUM_V40 = 512;
    public static final int MAX_IP_DEVICE = 32;    //允许接入的最大IP设备数
    public static final int MAX_IP_CHANNEL = 32;   //允许加入的最多IP通道数
    public static final int MAX_IP_ALARMIN = 128;   //允许加入的最多报警输入数
    public static final int MAX_IP_ALARMOUT = 64; //允许加入的最多报警输出数

    /* 最大支持的通道数 最大模拟加上最大IP支持 */
    public static final int MAX_CHANNUM_V30 = (MAX_ANALOG_CHANNUM + MAX_IP_CHANNEL);//64
    public static final int MAX_ALARMOUT_V30 = (MAX_ANALOG_ALARMOUT + MAX_IP_ALARMOUT);//96
    public static final int MAX_ALARMIN_V30 = (MAX_ANALOG_ALARMIN + MAX_IP_ALARMIN);//160
    public static final int MAX_IP_DEVICE_V40 = 64;
    public static final int STREAM_ID_LEN = 32;

    public static final int MAX_LICENSE_LEN = 16;
    public static final int MAX_LICENSE_LEN_EX = 32; //车牌号最大长度
    public static final int MAX_CARDNO_LEN = 48;     //卡号最大长度
    public static final int VCA_MAX_POLYGON_POINT_NUM = 10;

    public static final int MAX_ID_NUM_LEN = 32;  //最大身份证号长度
    public static final int MAX_ID_NAME_LEN = 128;   //最大姓名长度
    public static final int MAX_ID_ADDR_LEN = 280;   //最大住址长度
    public static final int MAX_ID_ISSUING_AUTHORITY_LEN = 128; //最大签发机关长度
    public static final int MAX_CARD_READER_NUM_512 = 512;  //最大读卡器数
    public static final int ERROR_MSG_LEN = 32;   //下发错误信息
    public static final int MAX_FACE_NUM = 2;    //最大人脸数
    public static final int MAX_FINGER_PRINT_LEN = 768;  //最大指纹长度

    public static final int DEV_TYPE_NAME_LEN = 24;      //设备类型名称长度
    public static final int MAX_FACE_PIC_NUM = 30;      /*人脸子图个数*/
    public static final int CARDNUM_LEN_V30 = 40;

    public static final int MAX_NOTICE_NUMBER_LEN = 32;   //公告编号最大长度
    public static final int MAX_NOTICE_THEME_LEN = 64;   //公告主题最大长度
    public static final int MAX_NOTICE_DETAIL_LEN = 1024; //公告详情最大长度
    public static final int MAX_NOTICE_PIC_NUM = 6;    //公告信息最大图片数量
    public static final int MAX_DEV_NUMBER_LEN = 32;   //设备编号最大长度
    public static final int LOCK_NAME_LEN = 32;  //锁名称

    public static final int NET_SDK_EMPLOYEE_NO_LEN = 32;  //工号长度
    public static final int NET_SDK_UUID_LEN = 36;  //UUID长度

    public static final int MAX_INQUEST_CDRW_NUM = 4;     //最大刻录机数目
    public static final int INQUEST_MESSAGE_LEN = 44;    //审讯重点标记信息长度
    public static final int INQUEST_MAX_ROOM_NUM = 2;     //最大审讯室个数
    public static final int MAX_RESUME_SEGMENT = 2;     //支持同时恢复的片段数目

    public static final int SUPPORT_PD_NUM = 16;
    public static final int SUPPORT_ARRAY_NUM = 8;
    public static final int SUPPORT_VD_NUM = 128;
    public static final int SUPPORT_PD_NUM_ = 16;
    public static final int SUPPORT_PD_NUM_PARTTWO = 8;

    public static final int CARDNUM_LEN_OUT = 32; //外部结构体卡号长度
    public static final int GUID_LEN = 16;        //GUID长度

    public static final int MAX_ROIDETECT_NUM = 8;    //支持的ROI区域数
    public static final int MAX_LANERECT_NUM = 5;    //最大车牌识别区域数
    public static final int MAX_FORTIFY_NUM = 10;   //最大布防个数
    public static final int MAX_INTERVAL_NUM = 4;    //最大时间间隔个数
    public static final int MAX_CHJC_NUM = 3;    //最大车辆省份简称字符个数
    public static final int MAX_VL_NUM = 5;    //最大虚拟线圈个数
    public static final int MAX_DRIVECHAN_NUM = 16;  //最大车道数
    public static final int MAX_COIL_NUM = 3;    //最大线圈个数
    public static final int MAX_SIGNALLIGHT_NUM = 6;   //最大信号灯个数
    public static final int MAX_IOSPEED_GROUP_NUM = 4; //IO测速组个数
    public static final int MAX_IOOUT_NUM = 4;  //最大IO输出口个数
    public static final int MAX_IOIN_NUM = 8;  //最大IO输入口个数
    public static final int MAX_RELAY_NUM = 12; //继电器控制设备最大数 2013-11-04
    public static final int MAX_VEHICLE_TYPE_NUM = 8;  //车辆信息管控最大数2013-11-04
    public static final int MAX_IOIN_NUMEX = 10; //最大IO输入口个数(扩展)
    public static final int MAX_ITC_LANE_NUM = 6;  //最大车道个数
    public static final int MAX_LANEAREA_NUM = 2;  //单车道最大区域个数
    public static final int ITC_MAX_POLYGON_POINT_NUM = 20;    //检测区域最多支持20个点的多边形
    public static final int MAX_ITC_SERIALCHECK_NUM = 8; //串口校验类型个数
    public static final int MAX_LIGHT_NUM = 6; //最大交通灯数
    public static final int MAX_VIDEO_INTERVAL_NUM = 2;  //最大抓拍间隔数
    public static final int MAX_VIDEO_DETECT_LIGHT_NUM = 12;  //视频检测的最大检测区域
    public static final int MAX_CALIB_RECOG_NUM = 2;  //标定区域个数
    public static final int MAX_RS485_NUM = 12; //485口最大支持数
    public static final int MAX_MOBILE_POLYGON_NUM = 3; //移动布控支持最大牌识区域个数
    public static final int MAX_MOBILE_DETECTLINE_NUM = 3; //移动布控支持最大违规检测线个数
    public static final int MAX_IOOUT_K_NUM = 8;  //K系列最大IO输出口个数

    public static final int NET_SDK_MAX_FDID_LEN = 256; //人脸库ID最大长度
    public static final int NET_SDK_MAX_PICID_LEN = 256; //人脸ID最大长度
    public static final int NET_SDK_MAX_INDENTITY_KEY_LEN = 64; //交互操作口令长度

    public static final int SEARCH_EVENT_INFO_LEN = 300;    //事件信息长度
    public static final int SEARCH_EVENT_INFO_LEN_V40 = 800;
    public static final int MAX_POS_KEYWORDS_NUM = 3; //支持关键字查找条数
    public static final int MAX_POS_KEYWORD_LEN = 128; //每条关键字长度
    public static final int INQUEST_CASE_LEN = 64;    //审讯信息长度

    public static final int SEARCH_CASE_NO_LEN = 56;
    public static final int SEARCH_CASE_NAME_LEN = 100;
    public static final int SEARCH_LITIGANT_LEN = 32;
    public static final int SEARCH_CHIEF_JUDGE_LEN = 32;
    public static final int CASE_NO_RET_LEN = 52;
    public static final int CASE_NAME_RET_LEN = 64;
    public static final int LITIGANT_RET_LEN = 24;
    public static final int CHIEF_JUDGE_RET_LEN = 24;
    public static final int NET_SDK_CASETYPE_LEN = 32;
    public static final int NET_SDK_MAX_TAPE_INDEX_LEN = 32;  //磁带编号最大长度
    public static final int NET_SDK_MAX_FILE_LEN = 256;  //文件名最大长度
    /******************************************************************/

    /*******************全局错误码 begin**********************/
    public static final int NET_DVR_NOERROR = 0;    //没有错误
    public static final int NET_DVR_PASSWORD_ERROR = 1;    //用户名密码错误
    public static final int NET_DVR_NOENOUGHPRI = 2;//权限不足
    public static final int NET_DVR_NOINIT = 3;//没有初始化
    public static final int NET_DVR_CHANNEL_ERROR = 4;    //通道号错误
    public static final int NET_DVR_OVER_MAXLINK = 5;    //连接到DVR的客户端个数超过最大
    public static final int NET_DVR_VERSIONNOMATCH = 6;    //版本不匹配
    public static final int NET_DVR_NETWORK_FAIL_CONNECT = 7;//连接服务器失败
    public static final int NET_DVR_NETWORK_SEND_ERROR = 8;    //向服务器发送失败
    public static final int NET_DVR_NETWORK_RECV_ERROR = 9;    //从服务器接收数据失败
    public static final int NET_DVR_NETWORK_RECV_TIMEOUT = 10;    //从服务器接收数据超时
    public static final int NET_DVR_NETWORK_ERRORDATA = 11;    //传送的数据有误
    public static final int NET_DVR_ORDER_ERROR = 12;    //调用次序错误
    public static final int NET_DVR_OPERNOPERMIT = 13;    //无此权限
    public static final int NET_DVR_COMMANDTIMEOUT = 14;    //DVR命令执行超时
    public static final int NET_DVR_ERRORSERIALPORT = 15;    //串口号错误
    public static final int NET_DVR_ERRORALARMPORT = 16;    //报警端口错误
    public static final int NET_DVR_PARAMETER_ERROR = 17;//参数错误
    public static final int NET_DVR_CHAN_EXCEPTION = 18;    //服务器通道处于错误状态
    public static final int NET_DVR_NODISK = 19;    //没有硬盘
    public static final int NET_DVR_ERRORDISKNUM = 20;    //硬盘号错误
    public static final int NET_DVR_DISK_FULL = 21;    //服务器硬盘满
    public static final int NET_DVR_DISK_ERROR = 22;//服务器硬盘出错
    public static final int NET_DVR_NOSUPPORT = 23;//服务器不支持
    public static final int NET_DVR_BUSY = 24;//服务器忙
    public static final int NET_DVR_MODIFY_FAIL = 25;//服务器修改不成功
    public static final int NET_DVR_PASSWORD_FORMAT_ERROR = 26;//密码输入格式不正确
    public static final int NET_DVR_DISK_FORMATING = 27;    //硬盘正在格式化，不能启动操作
    public static final int NET_DVR_DVRNORESOURCE = 28;    //DVR资源不足
    public static final int NET_DVR_DVROPRATEFAILED = 29; //DVR操作失败
    public static final int NET_DVR_OPENHOSTSOUND_FAIL = 30; //打开PC声音失败
    public static final int NET_DVR_DVRVOICEOPENED = 31; //服务器语音对讲被占用
    public static final int NET_DVR_TIMEINPUTERROR = 32; //时间输入不正确
    public static final int NET_DVR_NOSPECFILE = 33;  //回放时服务器没有指定的文件
    public static final int NET_DVR_CREATEFILE_ERROR = 34;    //创建文件出错
    public static final int NET_DVR_FILEOPENFAIL = 35; //打开文件出错
    public static final int NET_DVR_OPERNOTFINISH = 36; //上次的操作还没有完成
    public static final int NET_DVR_GETPLAYTIMEFAIL = 37; //获取当前播放的时间出错
    public static final int NET_DVR_PLAYFAIL = 38; //播放出错
    public static final int NET_DVR_FILEFORMAT_ERROR = 39;//文件格式不正确
    public static final int NET_DVR_DIR_ERROR = 40;    //路径错误
    public static final int NET_DVR_ALLOC_RESOURCE_ERROR = 41;//资源分配错误
    public static final int NET_DVR_AUDIO_MODE_ERROR = 42;    //声卡模式错误
    public static final int NET_DVR_NOENOUGH_BUF = 43;    //缓冲区太小
    public static final int NET_DVR_CREATESOCKET_ERROR = 44;    //创建SOCKET出错
    public static final int NET_DVR_SETSOCKET_ERROR = 45;    //设置SOCKET出错
    public static final int NET_DVR_MAX_NUM = 46;    //个数达到最大
    public static final int NET_DVR_USERNOTEXIST = 47;    //用户不存在
    public static final int NET_DVR_WRITEFLASHERROR = 48;//写FLASH出错
    public static final int NET_DVR_UPGRADEFAIL = 49;//DVR升级失败
    public static final int NET_DVR_CARDHAVEINIT = 50; //解码卡已经初始化过
    public static final int NET_DVR_PLAYERFAILED = 51;    //调用播放库中某个函数失败
    public static final int NET_DVR_MAX_USERNUM = 52; //设备端用户数达到最大
    public static final int NET_DVR_GETLOCALIPANDMACFAIL = 53;//获得客户端的IP地址或物理地址失败
    public static final int NET_DVR_NOENCODEING = 54;    //该通道没有编码
    public static final int NET_DVR_IPMISMATCH = 55;    //IP地址不匹配
    public static final int NET_DVR_MACMISMATCH = 56;//MAC地址不匹配
    public static final int NET_DVR_UPGRADELANGMISMATCH = 57;//升级文件语言不匹配
    public static final int NET_DVR_MAX_PLAYERPORT = 58;//播放器路数达到最大
    public static final int NET_DVR_NOSPACEBACKUP = 59;//备份设备中没有足够空间进行备份
    public static final int NET_DVR_NODEVICEBACKUP = 60;    //没有找到指定的备份设备
    public static final int NET_DVR_PICTURE_BITS_ERROR = 61;    //图像素位数不符，限24色
    public static final int NET_DVR_PICTURE_DIMENSION_ERROR = 62;//图片高*宽超限， 限128*256
    public static final int NET_DVR_PICTURE_SIZ_ERROR = 63;    //图片大小超限，限100K
    public static final int NET_DVR_LOADPLAYERSDKFAILED = 64;    //载入当前目录下Player Sdk出错
    public static final int NET_DVR_LOADPLAYERSDKPROC_ERROR = 65;    //找不到Player Sdk中某个函数入口
    public static final int NET_DVR_LOADDSSDKFAILED = 66;    //载入当前目录下DSsdk出错
    public static final int NET_DVR_LOADDSSDKPROC_ERROR = 67;    //找不到DsSdk中某个函数入口
    public static final int NET_DVR_DSSDK_ERROR = 68;    //调用硬解码库DsSdk中某个函数失败
    public static final int NET_DVR_VOICEMONOPOLIZE = 69;    //声卡被独占
    public static final int NET_DVR_JOINMULTICASTFAILED = 70;    //加入多播组失败
    public static final int NET_DVR_CREATEDIR_ERROR = 71;    //建立日志文件目录失败
    public static final int NET_DVR_BINDSOCKET_ERROR = 72;    //绑定套接字失败
    public static final int NET_DVR_SOCKETCLOSE_ERROR = 73;    //socket连接中断，此错误通常是由于连接中断或目的地不可达
    public static final int NET_DVR_USERID_ISUSING = 74;    //注销时用户ID正在进行某操作
    public static final int NET_DVR_SOCKETLISTEN_ERROR = 75;    //监听失败
    public static final int NET_DVR_PROGRAM_EXCEPTION = 76;    //程序异常
    public static final int NET_DVR_WRITEFILE_FAILED = 77;    //写文件失败
    public static final int NET_DVR_FORMAT_READONLY = 78;//禁止格式化只读硬盘
    public static final int NET_DVR_WITHSAMEUSERNAME = 79;//用户配置结构中存在相同的用户名
    public static final int NET_DVR_DEVICETYPE_ERROR = 80; /*导入参数时设备型号不匹配*/
    public static final int NET_DVR_LANGUAGE_ERROR = 81; /*导入参数时语言不匹配*/
    public static final int NET_DVR_PARAVERSION_ERROR = 82; /*导入参数时软件版本不匹配*/
    public static final int NET_DVR_IPCHAN_NOTALIVE = 83; /*预览时外接IP通道不在线*/
    public static final int NET_DVR_RTSP_SDK_ERROR = 84;    /*加载高清IPC通讯库StreamTransClient.dll失败*/
    public static final int NET_DVR_CONVERT_SDK_ERROR = 85;    /*加载转码库失败*/
    public static final int NET_DVR_IPC_COUNT_OVERFLOW = 86; /*超出最大的ip接入通道数*/
    public static final int NET_PLAYM4_NOERROR = 500;    //no error
    public static final int NET_PLAYM4_PARA_OVER = 501;//input parameter is invalid;
    public static final int NET_PLAYM4_ORDER_ERROR = 502;//The order of the function to be called is error.
    public static final int NET_PLAYM4_TIMER_ERROR = 503;//Create multimedia clock failed;
    public static final int NET_PLAYM4_DEC_VIDEO_ERROR = 504;//Decode video data failed.
    public static final int NET_PLAYM4_DEC_AUDIO_ERROR = 505;//Decode audio data failed.
    public static final int NET_PLAYM4_ALLOC_MEMORY_ERROR = 506;    //Allocate memory failed.
    public static final int NET_PLAYM4_OPEN_FILE_ERROR = 507;    //Open the file failed.
    public static final int NET_PLAYM4_CREATE_OBJ_ERROR = 508;//Create thread or event failed
    public static final int NET_PLAYM4_CREATE_DDRAW_ERROR = 509;//Create DirectDraw object failed.
    public static final int NET_PLAYM4_CREATE_OFFSCREEN_ERROR = 510;//failed when creating off-screen surface.
    public static final int NET_PLAYM4_BUF_OVER = 511;    //buffer is overflow
    public static final int NET_PLAYM4_CREATE_SOUND_ERROR = 512;    //failed when creating audio device.
    public static final int NET_PLAYM4_SET_VOLUME_ERROR = 513;//Set volume failed
    public static final int NET_PLAYM4_SUPPORT_FILE_ONLY = 514;//The function only support play file.
    public static final int NET_PLAYM4_SUPPORT_STREAM_ONLY = 515;//The function only support play stream.
    public static final int NET_PLAYM4_SYS_NOT_SUPPORT = 516;//System not support.
    public static final int NET_PLAYM4_FILEHEADER_UNKNOWN = 517;    //No file header.
    public static final int NET_PLAYM4_VERSION_INCORRECT = 518;    //The version of decoder and encoder is not adapted.
    public static final int NET_PALYM4_INIT_DECODER_ERROR = 519;    //Initialize decoder failed.
    public static final int NET_PLAYM4_CHECK_FILE_ERROR = 520;    //The file data is unknown.
    public static final int NET_PLAYM4_INIT_TIMER_ERROR = 521;    //Initialize multimedia clock failed.
    public static final int NET_PLAYM4_BLT_ERROR = 522;//Blt failed.
    public static final int NET_PLAYM4_UPDATE_ERROR = 523;//Update failed.
    public static final int NET_PLAYM4_OPEN_FILE_ERROR_MULTI = 524; //openfile error, streamtype is multi
    public static final int NET_PLAYM4_OPEN_FILE_ERROR_VIDEO = 525; //openfile error, streamtype is video
    public static final int NET_PLAYM4_JPEG_COMPRESS_ERROR = 526; //JPEG compress error
    public static final int NET_PLAYM4_EXTRACT_NOT_SUPPORT = 527;    //Don't support the version of this file.
    public static final int NET_PLAYM4_EXTRACT_DATA_ERROR = 528;    //extract video data failed.
    /*******************全局错误码 end**********************/
    /*************************************************
     NET_DVR_IsSupport()返回值
     1－9位分别表示以下信息（位与是TRUE)表示支持；
     **************************************************/
    public static final int NET_DVR_SUPPORT_DDRAW = 0x01;//支持DIRECTDRAW，如果不支持，则播放器不能工作；
    public static final int NET_DVR_SUPPORT_BLT = 0x02;//显卡支持BLT操作，如果不支持，则播放器不能工作；
    public static final int NET_DVR_SUPPORT_BLTFOURCC = 0x04;//显卡BLT支持颜色转换，如果不支持，播放器会用软件方法作RGB转换；
    public static final int NET_DVR_SUPPORT_BLTSHRINKX = 0x08;//显卡BLT支持X轴缩小；如果不支持，系统会用软件方法转换；
    public static final int NET_DVR_SUPPORT_BLTSHRINKY = 0x10;//显卡BLT支持Y轴缩小；如果不支持，系统会用软件方法转换；
    public static final int NET_DVR_SUPPORT_BLTSTRETCHX = 0x20;//显卡BLT支持X轴放大；如果不支持，系统会用软件方法转换；
    public static final int NET_DVR_SUPPORT_BLTSTRETCHY = 0x40;//显卡BLT支持Y轴放大；如果不支持，系统会用软件方法转换；
    public static final int NET_DVR_SUPPORT_SSE = 0x80;//CPU支持SSE指令，Intel Pentium3以上支持SSE指令；
    public static final int NET_DVR_SUPPORT_MMX = 0x100;//CPU支持MMX指令集，Intel Pentium3以上支持SSE指令；
    /**********************云台控制命令 begin*************************/
    public static final int LIGHT_PWRON = 2;    /* 接通灯光电源 */
    public static final int WIPER_PWRON = 3;    /* 接通雨刷开关 */
    public static final int FAN_PWRON = 4;    /* 接通风扇开关 */
    public static final int HEATER_PWRON = 5;    /* 接通加热器开关 */
    public static final int AUX_PWRON1 = 6;    /* 接通辅助设备开关 */
    public static final int AUX_PWRON2 = 7;    /* 接通辅助设备开关 */
    public static final int SET_PRESET = 8;    /* 设置预置点 */
    public static final int CLE_PRESET = 9;    /* 清除预置点 */
    public static final int ZOOM_IN = 11;    /* 焦距以速度SS变大(倍率变大) */
    public static final int ZOOM_OUT = 12;    /* 焦距以速度SS变小(倍率变小) */
    public static final int FOCUS_NEAR = 13; /* 焦点以速度SS前调 */
    public static final int FOCUS_FAR = 14; /* 焦点以速度SS后调 */
    public static final int IRIS_OPEN = 15; /* 光圈以速度SS扩大 */
    public static final int IRIS_CLOSE = 16; /* 光圈以速度SS缩小 */
    public static final int TILT_UP = 21;    /* 云台以SS的速度上仰 */
    public static final int TILT_DOWN = 22;    /* 云台以SS的速度下俯 */
    public static final int PAN_LEFT = 23;    /* 云台以SS的速度左转 */
    public static final int PAN_RIGHT = 24;    /* 云台以SS的速度右转 */
    public static final int UP_LEFT = 25;    /* 云台以SS的速度上仰和左转 */
    public static final int UP_RIGHT = 26;    /* 云台以SS的速度上仰和右转 */
    public static final int DOWN_LEFT = 27;    /* 云台以SS的速度下俯和左转 */
    public static final int DOWN_RIGHT = 28;    /* 云台以SS的速度下俯和右转 */
    public static final int PAN_AUTO = 29;    /* 云台以SS的速度左右自动扫描 */
    public static final int FILL_PRE_SEQ = 30;    /* 将预置点加入巡航序列 */
    public static final int SET_SEQ_DWELL = 31;    /* 设置巡航点停顿时间 */
    public static final int SET_SEQ_SPEED = 32;    /* 设置巡航速度 */
    public static final int CLE_PRE_SEQ = 33;/* 将预置点从巡航序列中删除 */
    public static final int STA_MEM_CRUISE = 34;/* 开始记录轨迹 */
    public static final int STO_MEM_CRUISE = 35;/* 停止记录轨迹 */
    public static final int RUN_CRUISE = 36;    /* 开始轨迹 */
    public static final int RUN_SEQ = 37;    /* 开始巡航 */
    public static final int STOP_SEQ = 38;    /* 停止巡航 */
    public static final int GOTO_PRESET = 39;    /* 快球转到预置点 */

    /**********************云台控制命令 end*************************/
    /*************************************************
     回放时播放控制命令宏定义
     NET_DVR_PlayBackControl
     NET_DVR_PlayControlLocDisplay
     NET_DVR_DecPlayBackCtrl的宏定义
     具体支持查看函数说明和代码
     **************************************************/
    public static final int NET_DVR_PLAYSTART = 1;//开始播放
    public static final int NET_DVR_PLAYSTOP = 2;//停止播放
    public static final int NET_DVR_PLAYPAUSE = 3;//暂停播放
    public static final int NET_DVR_PLAYRESTART = 4;//恢复播放
    public static final int NET_DVR_PLAYFAST = 5;//快放
    public static final int NET_DVR_PLAYSLOW = 6;//慢放
    public static final int NET_DVR_PLAYNORMAL = 7;//正常速度
    public static final int NET_DVR_PLAYFRAME = 8;//单帧放
    public static final int NET_DVR_PLAYSTARTAUDIO = 9;//打开声音
    public static final int NET_DVR_PLAYSTOPAUDIO = 10;//关闭声音
    public static final int NET_DVR_PLAYAUDIOVOLUME = 11;//调节音量
    public static final int NET_DVR_PLAYSETPOS = 12;//改变文件回放的进度
    public static final int NET_DVR_PLAYGETPOS = 13;//获取文件回放的进度
    public static final int NET_DVR_PLAYGETTIME = 14;//获取当前已经播放的时间(按文件回放的时候有效)
    public static final int NET_DVR_PLAYGETFRAME = 15;//获取当前已经播放的帧数(按文件回放的时候有效)
    public static final int NET_DVR_GETTOTALFRAMES = 16;//获取当前播放文件总的帧数(按文件回放的时候有效)
    public static final int NET_DVR_GETTOTALTIME = 17;//获取当前播放文件总的时间(按文件回放的时候有效)
    public static final int NET_DVR_THROWBFRAME = 20;//丢B帧
    public static final int NET_DVR_SETSPEED = 24;//设置码流速度
    public static final int NET_DVR_KEEPALIVE = 25;//保持与设备的心跳(如果回调阻塞，建议2秒发送一次)
    public static final int NET_DVR_SET_TRANS_TYPE = 32; //设置转码格式

    //远程按键定义如下：
    /* key value send to CONFIG program */
    public static final int KEY_CODE_1 = 1;
    public static final int KEY_CODE_2 = 2;
    public static final int KEY_CODE_3 = 3;
    public static final int KEY_CODE_4 = 4;
    public static final int KEY_CODE_5 = 5;
    public static final int KEY_CODE_6 = 6;
    public static final int KEY_CODE_7 = 7;
    public static final int KEY_CODE_8 = 8;
    public static final int KEY_CODE_9 = 9;
    public static final int KEY_CODE_0 = 10;
    public static final int KEY_CODE_POWER = 11;
    public static final int KEY_CODE_MENU = 12;
    public static final int KEY_CODE_ENTER = 13;
    public static final int KEY_CODE_CANCEL = 14;
    public static final int KEY_CODE_UP = 15;
    public static final int KEY_CODE_DOWN = 16;
    public static final int KEY_CODE_LEFT = 17;
    public static final int KEY_CODE_RIGHT = 18;
    public static final int KEY_CODE_EDIT = 19;
    public static final int KEY_CODE_ADD = 20;
    public static final int KEY_CODE_MINUS = 21;
    public static final int KEY_CODE_PLAY = 22;
    public static final int KEY_CODE_REC = 23;
    public static final int KEY_CODE_PAN = 24;
    public static final int KEY_CODE_M = 25;
    public static final int KEY_CODE_A = 26;
    public static final int KEY_CODE_F1 = 27;
    public static final int KEY_CODE_F2 = 28;

    /* for PTZ control */
    public static final int KEY_PTZ_UP_START = KEY_CODE_UP;
    public static final int KEY_PTZ_UP_STO = 32;
    public static final int KEY_PTZ_DOWN_START = KEY_CODE_DOWN;
    public static final int KEY_PTZ_DOWN_STOP = 33;
    public static final int KEY_PTZ_LEFT_START = KEY_CODE_LEFT;
    public static final int KEY_PTZ_LEFT_STOP = 34;
    public static final int KEY_PTZ_RIGHT_START = KEY_CODE_RIGHT;
    public static final int KEY_PTZ_RIGHT_STOP = 35;
    public static final int KEY_PTZ_AP1_START = KEY_CODE_EDIT;/* 光圈+ */
    public static final int KEY_PTZ_AP1_STOP = 36;
    public static final int KEY_PTZ_AP2_START = KEY_CODE_PAN;/* 光圈- */
    public static final int KEY_PTZ_AP2_STOP = 37;
    public static final int KEY_PTZ_FOCUS1_START = KEY_CODE_A;/* 聚焦+ */
    public static final int KEY_PTZ_FOCUS1_STOP = 38;
    public static final int KEY_PTZ_FOCUS2_START = KEY_CODE_M;/* 聚焦- */
    public static final int KEY_PTZ_FOCUS2_STOP = 39;
    public static final int KEY_PTZ_B1_START = 40;/* 变倍+ */
    public static final int KEY_PTZ_B1_STOP = 41;
    public static final int KEY_PTZ_B2_START = 42;/* 变倍- */
    public static final int KEY_PTZ_B2_STOP = 43;
    //9000新增
    public static final int KEY_CODE_11 = 44;
    public static final int KEY_CODE_12 = 45;
    public static final int KEY_CODE_13 = 46;
    public static final int KEY_CODE_14 = 47;
    public static final int KEY_CODE_15 = 48;
    public static final int KEY_CODE_16 = 49;
    /*************************参数配置命令 begin*******************************/
//用于NET_DVR_SetDVRConfig和NET_DVR_GetDVRConfig,注意其对应的配置结构
    public static final int NET_DVR_GET_DEVICECFG = 100;    //获取设备参数
    public static final int NET_DVR_SET_DEVICECFG = 101;    //设置设备参数
    public static final int NET_DVR_GET_DEVICECFG_V40 = 1100; //获取扩展设备参数
    public static final int NET_DVR_SET_DEVICECFG_V40 = 1101; //设置扩展设备参数
    public static final int NET_DVR_GET_NETCFG = 102;    //获取网络参数
    public static final int NET_DVR_SET_NETCFG = 103;    //设置网络参数
    public static final int NET_DVR_GET_PICCFG = 104;    //获取图象参数
    public static final int NET_DVR_SET_PICCFG = 105;    //设置图象参数
    public static final int NET_DVR_GET_COMPRESSCFG = 106;    //获取压缩参数
    public static final int NET_DVR_SET_COMPRESSCFG = 107;    //设置压缩参数
    public static final int NET_DVR_GET_RECORDCFG = 108;    //获取录像时间参数
    public static final int NET_DVR_SET_RECORDCFG = 109;    //设置录像时间参数
    public static final int NET_DVR_GET_DECODERCFG = 110;    //获取解码器参数
    public static final int NET_DVR_SET_DECODERCFG = 111;    //设置解码器参数
    public static final int NET_DVR_GET_RS232CFG = 112;    //获取232串口参数
    public static final int NET_DVR_SET_RS232CFG = 113;    //设置232串口参数
    public static final int NET_DVR_GET_ALARMINCFG = 114;    //获取报警输入参数
    public static final int NET_DVR_SET_ALARMINCFG = 115;    //设置报警输入参数
    public static final int NET_DVR_GET_ALARMOUTCFG = 116;    //获取报警输出参数
    public static final int NET_DVR_SET_ALARMOUTCFG = 117;    //设置报警输出参数
    public static final int NET_DVR_GET_TIMECFG = 118;    //获取DVR时间
    public static final int NET_DVR_SET_TIMECFG = 119;        //设置DVR时间
    public static final int NET_DVR_GET_PREVIEWCFG = 120;    //获取预览参数
    public static final int NET_DVR_SET_PREVIEWCFG = 121;    //设置预览参数
    public static final int NET_DVR_GET_VIDEOOUTCFG = 122;    //获取视频输出参数
    public static final int NET_DVR_SET_VIDEOOUTCFG = 123;    //设置视频输出参数
    public static final int NET_DVR_GET_USERCFG = 124;    //获取用户参数
    public static final int NET_DVR_SET_USERCFG = 125;    //设置用户参数
    public static final int NET_DVR_GET_EXCEPTIONCFG = 126;    //获取异常参数
    public static final int NET_DVR_SET_EXCEPTIONCFG = 127;    //设置异常参数
    public static final int NET_DVR_GET_ZONEANDDST = 128;    //获取时区和夏时制参数
    public static final int NET_DVR_SET_ZONEANDDST = 129;    //设置时区和夏时制参数
    public static final int NET_DVR_GET_SHOWSTRING = 130;    //获取叠加字符参数
    public static final int NET_DVR_SET_SHOWSTRING = 131;    //设置叠加字符参数
    public static final int NET_DVR_GET_EVENTCOMPCFG = 132;    //获取事件触发录像参数
    public static final int NET_DVR_SET_EVENTCOMPCFG = 133;    //设置事件触发录像参数
    public static final int NET_DVR_GET_AUXOUTCFG = 140;    //获取报警触发辅助输出设置(HS设备辅助输出2006-02-28)
    public static final int NET_DVR_SET_AUXOUTCFG = 141;    //设置报警触发辅助输出设置(HS设备辅助输出2006-02-28)
    public static final int NET_DVR_GET_PREVIEWCFG_AUX = 142;    //获取-s系列双输出预览参数(-s系列双输出2006-04-13)
    public static final int NET_DVR_SET_PREVIEWCFG_AUX = 143;    //设置-s系列双输出预览参数(-s系列双输出2006-04-13)
    public static final int NET_DVR_GET_PICCFG_EX = 200;    //获取图象参数(SDK_V14扩展命令)
    public static final int NET_DVR_SET_PICCFG_EX = 201;    //设置图象参数(SDK_V14扩展命令)
    public static final int NET_DVR_GET_USERCFG_EX = 202;    //获取用户参数(SDK_V15扩展命令)
    public static final int NET_DVR_SET_USERCFG_EX = 203;    //设置用户参数(SDK_V15扩展命令)
    public static final int NET_DVR_GET_COMPRESSCFG_EX = 204;    //获取压缩参数(SDK_V15扩展命令2006-05-15)
    public static final int NET_DVR_SET_COMPRESSCFG_EX = 205;    //设置压缩参数(SDK_V15扩展命令2006-05-15)
    public static final int NET_DVR_GET_NETAPPCFG = 222;    //获取网络应用参数 NTP/DDNS/EMAIL
    public static final int NET_DVR_SET_NETAPPCFG = 223;    //设置网络应用参数 NTP/DDNS/EMAIL
    public static final int NET_DVR_GET_NTPCFG = 224;    //获取网络应用参数 NTP
    public static final int NET_DVR_SET_NTPCFG = 225;    //设置网络应用参数 NTP
    public static final int NET_DVR_GET_DDNSCFG = 226;    //获取网络应用参数 DDNS
    public static final int NET_DVR_SET_DDNSCFG = 227;        //设置网络应用参数 DDNS
    //对应NET_DVR_EMAILPARA
    public static final int NET_DVR_GET_EMAILCFG = 228;    //获取网络应用参数 EMAIL
    public static final int NET_DVR_SET_EMAILCFG = 229;    //设置网络应用参数 EMAIL
    public static final int NET_DVR_GET_NFSCFG = 230;    /* NFS disk config */
    public static final int NET_DVR_SET_NFSCFG = 231;    /* NFS disk config */
    public static final int NET_DVR_GET_SHOWSTRING_EX = 238;    //获取叠加字符参数扩展(支持8条字符)
    public static final int NET_DVR_SET_SHOWSTRING_EX = 239;    //设置叠加字符参数扩展(支持8条字符)
    public static final int NET_DVR_GET_NETCFG_OTHER = 244;    //获取网络参数
    public static final int NET_DVR_SET_NETCFG_OTHER = 245;    //设置网络参数
    //对应NET_DVR_EMAILCFG结构
    public static final int NET_DVR_GET_EMAILPARACFG = 250;    //Get EMAIL parameters
    public static final int NET_DVR_SET_EMAILPARACFG = 251;    //Setup EMAIL parameters
    public static final int NET_DVR_GET_DDNSCFG_EX = 274;//获取扩展DDNS参数
    public static final int NET_DVR_SET_DDNSCFG_EX = 275;//设置扩展DDNS参数
    public static final int NET_DVR_SET_PTZPOS = 292;    //云台设置PTZ位置
    public static final int NET_DVR_GET_PTZPOS = 293;        //云台获取PTZ位置
    public static final int NET_DVR_GET_PTZSCOPE = 294;//云台获取PTZ范围

    public static final int NET_DVR_COMPLETE_RESTORE_CTRL = 3420;    //设置完全恢复出厂值
    /***************************DS9000新增命令(_V30) begin *****************************/
//网络(NET_DVR_NETCFG_V30结构)
    public static final int NET_DVR_GET_NETCFG_V30 = 1000;    //获取网络参数
    public static final int NET_DVR_SET_NETCFG_V30 = 1001;    //设置网络参数
    //图象(NET_DVR_PICCFG_V30结构)
    public static final int NET_DVR_GET_PICCFG_V30 = 1002;    //获取图象参数
    public static final int NET_DVR_SET_PICCFG_V30 = 1003;    //设置图象参数
    public static final int NET_DVR_GET_PICCFG_V40 = 6179;   //获取图象参数
    public static final int NET_DVR_SET_PICCFG_V40 = 6180;   //设置图象参数
    //录像时间(NET_DVR_RECORD_V30结构)
    public static final int NET_DVR_GET_RECORDCFG_V30 = 1004;    //获取录像参数
    public static final int NET_DVR_SET_RECORDCFG_V30 = 1005;    //设置录像参数
    //用户(NET_DVR_USER_V30结构)
    public static final int NET_DVR_GET_USERCFG_V30 = 1006;    //获取用户参数
    public static final int NET_DVR_SET_USERCFG_V30 = 1007;    //设置用户参数
    //9000DDNS参数配置(NET_DVR_DDNSPARA_V30结构)
    public static final int NET_DVR_GET_DDNSCFG_V30 = 1010;    //获取DDNS(9000扩展)
    public static final int NET_DVR_SET_DDNSCFG_V30 = 1011;    //设置DDNS(9000扩展)
    //EMAIL功能(NET_DVR_EMAILCFG_V30结构)
    public static final int NET_DVR_GET_EMAILCFG_V30 = 1012;//获取EMAIL参数
    public static final int NET_DVR_SET_EMAILCFG_V30 = 1013;//设置EMAIL参数
    //巡航参数 (NET_DVR_CRUISE_PARA结构)
    public static final int NET_DVR_GET_CRUISE = 1020;
    public static final int NET_DVR_SET_CRUISE = 1021;
    //报警输入结构参数 (NET_DVR_ALARMINCFG_V30结构)
    public static final int NET_DVR_GET_ALARMINCFG_V30 = 1024;
    public static final int NET_DVR_SET_ALARMINCFG_V30 = 1025;
    //报警输出结构参数 (NET_DVR_ALARMOUTCFG_V30结构)
    public static final int NET_DVR_GET_ALARMOUTCFG_V30 = 1026;
    public static final int NET_DVR_SET_ALARMOUTCFG_V30 = 1027;
    //视频输出结构参数 (NET_DVR_VIDEOOUT_V30结构)
    public static final int NET_DVR_GET_VIDEOOUTCFG_V30 = 1028;
    public static final int NET_DVR_SET_VIDEOOUTCFG_V30 = 1029;
    //叠加字符结构参数 (NET_DVR_SHOWSTRING_V30结构)
    public static final int NET_DVR_GET_SHOWSTRING_V30 = 1030;
    public static final int NET_DVR_SET_SHOWSTRING_V30 = 1031;
    //异常结构参数 (NET_DVR_EXCEPTION_V30结构)
    public static final int NET_DVR_GET_EXCEPTIONCFG_V30 = 1034;
    public static final int NET_DVR_SET_EXCEPTIONCFG_V30 = 1035;
    //串口232结构参数 (NET_DVR_RS232CFG_V30结构)
    public static final int NET_DVR_GET_RS232CFG_V30 = 1036;
    public static final int NET_DVR_SET_RS232CFG_V30 = 1037;
    //压缩参数 (NET_DVR_COMPRESSIONCFG_V30结构)
    public static final int NET_DVR_GET_COMPRESSCFG_V30 = 1040;
    public static final int NET_DVR_SET_COMPRESSCFG_V30 = 1041;
    //获取485解码器参数 (NET_DVR_DECODERCFG_V30结构)
    public static final int NET_DVR_GET_DECODERCFG_V30 = 1042;    //获取解码器参数
    public static final int NET_DVR_SET_DECODERCFG_V30 = 1043;    //设置解码器参数
    //获取预览参数 (NET_DVR_PREVIEWCFG_V30结构)
    public static final int NET_DVR_GET_PREVIEWCFG_V30 = 1044;    //获取预览参数
    public static final int NET_DVR_SET_PREVIEWCFG_V30 = 1045;    //设置预览参数
    //辅助预览参数 (NET_DVR_PREVIEWCFG_AUX_V30结构)
    public static final int NET_DVR_GET_PREVIEWCFG_AUX_V30 = 1046;    //获取辅助预览参数
    public static final int NET_DVR_SET_PREVIEWCFG_AUX_V30 = 1047;    //设置辅助预览参数
    //IP接入配置参数 （NET_DVR_IPPARACFG结构）
    public static final int NET_DVR_GET_IPPARACFG = 1048;    //获取IP接入配置信息
    public static final int NET_DVR_SET_IPPARACFG = 1049;    //设置IP接入配置信息
    //IP接入配置参数V40 （NET_DVR_IPPARACFG_V40结构）
    public static final int NET_DVR_GET_IPPARACFG_V40 = 1062;    //获取IP接入配置信息
    public static final int NET_DVR_SET_IPPARACFG_V40 = 1063;    //设置IP接入配置信息
    //IP报警输入接入配置参数 （NET_DVR_IPALARMINCFG结构）
    public static final int NET_DVR_GET_IPALARMINCFG = 1050;    //获取IP报警输入接入配置信息
    public static final int NET_DVR_SET_IPALARMINCFG = 1051;   //设置IP报警输入接入配置信息
    //IP报警输出接入配置参数 （NET_DVR_IPALARMOUTCFG结构）
    public static final int NET_DVR_GET_IPALARMOUTCFG = 1052;   //获取IP报警输出接入配置信息
    public static final int NET_DVR_SET_IPALARMOUTCFG = 1053;  //设置IP报警输出接入配置信息
    //硬盘管理的参数获取 (NET_DVR_HDCFG结构)
    public static final int NET_DVR_GET_HDCFG = 1054;    //获取硬盘管理配置参数
    public static final int NET_DVR_SET_HDCFG = 1055;    //设置硬盘管理配置参数
    //盘组管理的参数获取 (NET_DVR_HDGROUP_CFG结构)
    public static final int NET_DVR_GET_HDGROUP_CFG = 1056;    //获取盘组管理配置参数
    public static final int NET_DVR_SET_HDGROUP_CFG = 1057;    //设置盘组管理配置参数
    //设备编码类型配置(NET_DVR_COMPRESSION_AUDIO结构)
    public static final int NET_DVR_GET_COMPRESSCFG_AUD = 1058;     //获取设备语音对讲编码参数
    public static final int NET_DVR_SET_COMPRESSCFG_AUD = 1059;     //设置设备语音对讲编码参数

    public static final int NET_SDK_FINDMEDICALFILE = 3954;    //慧影科技智慧医疗查找录像文件
    public static final int NET_SDK_FINDMEDICALPICTURE = 3955;    //慧影科技智慧医疗查找图片文件

    public static final int NET_DVR_GET_RAPIDMOVE_DETECTION = 3539;    //获取快速运动侦测配置
    public static final int NET_DVR_SET_RAPIDMOVE_DETECTION = 3540;    //设置快速运动侦测配置

    public static final int NET_DVR_GET_RAPIDMOVE_TRIGGER = 3543;    //获取快速运动联动配置
    public static final int NET_DVR_SET_RAPIDMOVE_TRIGGER = 3544;    //设置快速运动联动配置
    public static final int NET_DVR_GET_RAPIDMOVE_SCHEDULE = 3545;    //获取快速运动的布防时间配置
    public static final int NET_DVR_SET_RAPIDMOVE_SCHEDULE = 3546;    //设置快速运动的布防时间配置

    public static final int NET_DVR_GET_PRESET_NAME = 3383; //获取预置点名称
    public static final int NET_DVR_SET_PRESET_NAME = 3382; //设置预置点名称
    public static final int NET_DVR_GET_RULECFG_V42 = 5049;  //获取行为分析参数(支持16条规则扩展)
    public static final int NET_DVR_SET_RULECFG_V42 = 5050;  //设置行为分析参数(支持16条规则扩展)

    //车牌识别（NET_VCA_PLATE_CFG）;
    public static final int NET_DVR_SET_PLATECFG = 150;//设置车牌识别参数

    public static final int NET_DVR_GET_PLATECFG = 151;    //获取车牌识别参数
    //行为对应（NET_VCA_RULECFG）
    public static final int NET_DVR_SET_RULECFG = 152;    //设置行为分析规则
    public static final int NET_DVR_GET_RULECFG = 153;//获取行为分析规则
    //双摄像机标定参数（NET_DVR_LF_CFG）
    public static final int NET_DVR_SET_LF_CFG = 160;//设置双摄像机的配置参数
    public static final int NET_DVR_GET_LF_CFG = 161;//获取双摄像机的配置参数
    //智能分析仪取流配置结构
    public static final int NET_DVR_SET_IVMS_STREAMCFG = 162;    //设置智能分析仪取流参数
    public static final int NET_DVR_GET_IVMS_STREAMCFG = 163;    //获取智能分析仪取流参数
    //智能控制参数结构
    public static final int NET_DVR_SET_VCA_CTRLCFG = 164; //设置智能控制参数
    public static final int NET_DVR_GET_VCA_CTRLCFG = 165;     //获取智能控制参数
    //屏蔽区域NET_VCA_MASK_REGION_LIST
    public static final int NET_DVR_SET_VCA_MASK_REGION = 166;     //设置屏蔽区域参数
    public static final int NET_DVR_GET_VCA_MASK_REGION = 167;     //获取屏蔽区域参数
    //ATM进入区域 NET_VCA_ENTER_REGION
    public static final int NET_DVR_SET_VCA_ENTER_REGION = 168; //设置进入区域参数
    public static final int NET_DVR_GET_VCA_ENTER_REGION = 169;     //获取进入区域参数
    //标定线配置NET_VCA_LINE_SEGMENT_LIST
    public static final int NET_DVR_SET_VCA_LINE_SEGMENT = 170;     //设置标定线
    public static final int NET_DVR_GET_VCA_LINE_SEGMENT = 171;     //获取标定线
    // ivms屏蔽区域NET_IVMS_MASK_REGION_LIST
    public static final int NET_DVR_SET_IVMS_MASK_REGION = 172;     //设置IVMS屏蔽区域参数
    public static final int NET_DVR_GET_IVMS_MASK_REGION = 173;     //获取IVMS屏蔽区域参数
    // ivms进入检测区域NET_IVMS_ENTER_REGION
    public static final int NET_DVR_SET_IVMS_ENTER_REGION = 174; //设置IVMS进入区域参数
    public static final int NET_DVR_GET_IVMS_ENTER_REGION = 175; //获取IVMS进入区域参数
    public static final int NET_DVR_SET_IVMS_BEHAVIORCFG = 176;//设置智能分析仪行为规则参数
    public static final int NET_DVR_GET_IVMS_BEHAVIORCFG = 177;    //获取智能分析仪行为规则参数
    public static final int NET_DVR_GET_TRAVERSE_PLANE_DETECTION = 3360; //获取越界侦测配置
    public static final int NET_DVR_SET_TRAVERSE_PLANE_DETECTION = 3361;
    public static final int NET_DVR_GET_FIELD_DETECTION = 3362; //获取区域侦测配置
    public static final int NET_DVR_SET_FIELD_DETECTION = 3363; //设置区域侦测配置

    public static final int NET_DVR_GET_STREAM_INFO = 6023; //获取已添加流ID信息
    public static final int NET_DVR_GET_STREAM_RECORD_STATUS = 6021; //获取流状态信息

    public static final int NET_DVR_GET_ALL_VEHICLE_CONTROL_LIST = 3124; //获取所有车辆禁止和允许名单信息
    public static final int NET_DVR_VEHICLELIST_CTRL_START = 3133; //设置车辆禁止和允许名单信息(批量)
    public static final int ENUM_SENDDATA = 0x0; //发送数据

    public static final int NET_DVR_GET_LEDDISPLAY_CFG = 3673;
    public static final int NET_DVR_SET_LEDDISPLAY_CFG = 3672;
    public static final int NET_DVR_SET_VOICEBROADCAST_CFG = 3675;
    public static final int NET_DVR_SET_CHARGE_ACCOUNTINFO = 3662;

    public static final int NET_DVR_GET_TRAFFIC_DATA = 3141;   //长连接获取交通数据
    public static final int NET_DVR_GET_TRAFFIC_FLOW = 3142;   //长连接获取交通流量

    public static final int NET_DVR_GET_CARD_CFG = 2116; //获取卡参数
    public static final int NET_DVR_SET_CARD_CFG = 2117; //设置卡参数
    public static final int NET_DVR_GET_CARD_CFG_V50 = 2178;    //获取新卡参数(V50)
    public static final int NET_DVR_SET_CARD_CFG_V50 = 2179;    //设置新卡参数(V50)
    public static final int NET_DVR_GET_FACE_PARAM_CFG = 2507;    //获取人脸参数
    public static final int NET_DVR_SET_FACE_PARAM_CFG = 2508;    //设置人脸参数
    public static final int NET_DVR_DEL_FACE_PARAM_CFG = 2509;    //删除人脸参数
    public static final int NET_DVR_GET_FINGERPRINT_CFG_V50 = 2183;    //获取指纹参数V50
    public static final int NET_DVR_SET_FINGERPRINT_CFG_V50 = 2184;   //设置指纹参数V50
    public static final int NET_DVR_DEL_FINGERPRINT_CFG_V50 = 2517;    //删除指纹参数V50
    public static final int NET_DVR_GET_CARD_RIGHT_WEEK_PLAN_V50 = 2304;  //获取卡权限周计划参数V50
    public static final int NET_DVR_SET_CARD_RIGHT_WEEK_PLAN_V50 = 2305;  //设置卡权限周计划参数V50
    public static final int NET_DVR_GET_CARD_RIGHT_PLAN_TEMPLATE_V50 = 2322; //获取卡权限计划模板参数V50
    public static final int NET_DVR_SET_CARD_RIGHT_PLAN_TEMPLATE_V50 = 2323;//设置卡权限计划模板参数V50
    public static final int NET_DVR_GET_DOOR_CFG = 2108;    //获取门参数
    public static final int NET_DVR_SET_DOOR_CFG = 2109;    //设置门参数
    public static final int NET_DVR_GET_DOOR_STATUS_PLAN = 2110; //获取门状态计划参数
    public static final int NET_DVR_SET_DOOR_STATUS_PLAN = 2111; //设置门状态计划参数
    public static final int NET_DVR_GET_EVENT_CARD_LINKAGE_CFG_V50 = 2181;    //获取事件卡号联动配置参数(V50)
    public static final int NET_DVR_SET_EVENT_CARD_LINKAGE_CFG_V50 = 2182;    //设置事件卡号联动配置参数(V50)
    public static final int NET_DVR_CAPTURE_FACE_INFO = 2510;    //采集人脸信息
    public static final int NET_DVR_GET_ACS_EVENT = 2514;//设备事件获取

    public static final int NET_DVR_GET_SUPPLEMENTLIGHT = 3728;  //获取内置补光灯配置协议
    public static final int NET_DVR_SET_SUPPLEMENTLIGHT = 3729;  //设置内置补光灯配置协议

    public static final int NET_DVR_GET_FACECONTRAST_TRIGGER = 3965;//获取人脸比对联动配置
    public static final int NET_DVR_SET_FACECONTRAST_TRIGGER = 3966;//设置人脸比对联动配置

    public static final int NET_DVR_GET_FACECONTRAST_SCHEDULE = 3968;//获取人脸比对布防时间配置
    public static final int NET_DVR_SET_FACECONTRAST_SCHEDULE = 3969;//设置人脸比对布防时间配置

    public static final int NET_DVR_INQUEST_GET_CDW_STATUS = 6350;  //获取审讯机刻录状态-长连接

    public static final int NET_DVR_GET_REALTIME_THERMOMETRY = 3629; //实时温度检测
    public static final int NET_DVR_GET_MANUALTHERM_INFO = 6706;     //手动测温实时获取
    public static final int NET_DVR_GET_THERMOMETRY_MODE = 6765;//获取测温模式参数
    public static final int NET_DVR_SET_THERMOMETRY_MODE = 6766;//设置测温模式参数
    public static final int NET_DVR_GET_THERMOMETRY_PRESETINFO = 3624;  //获取测温预置点关联配置参数
    public static final int NET_DVR_SET_THERMOMETRY_PRESETINFO = 3625;  //设置测温预置点关联配置参数

    public static final int NET_DVR_GET_PHY_DISK_INFO = 6306;   //获取物理磁盘信息
    public static final int NET_DVR_GET_WORK_STATUS = 6189;   //获取设备工作状态

    public static final int NET_DVR_GET_CURTRIGGERMODE = 3130;   //获取设备当前触发模式
    public static final int NET_ITC_GET_TRIGGERCFG = 3003;  //获取触发参数
    public static final int NET_ITC_SET_TRIGGERCFG = 3004;  //设置触发参数
    public static final int NET_ITC_GET_VIDEO_TRIGGERCFG = 3017;  //获取视频电警触发参数
    public static final int NET_ITC_SET_VIDEO_TRIGGERCFG = 3018;  //设置视频电警触发参数

    public static final int NET_DVR_GET_MULTI_STREAM_COMPRESSIONCFG = 3216;//远程获取多码流压缩参数
    public static final int NET_DVR_SET_MULTI_STREAM_COMPRESSIONCFG = 3217;//远程设置多码流压缩参数

    public static final int NET_DVR_GET_CMS_CFG = 2070;
    public static final int NET_DVR_SET_CMS_CFG = 2071;

    public static final int NET_DVR_GET_ALARM_INFO = 4193;  //获取报警事件数据
    /***************************DS9000新增命令(_V30) end *****************************/

    /*************************参数配置命令 end*******************************/
    /*******************查找文件和日志函数返回值*************************/
    public static final int NET_DVR_FILE_SUCCESS = 1000;    //获得文件信息
    public static final int NET_DVR_FILE_NOFIND = 1001;    //没有文件
    public static final int NET_DVR_ISFINDING = 1002;//正在查找文件
    public static final int NET_DVR_NOMOREFILE = 1003;//查找文件时没有更多的文件
    public static final int NET_DVR_FILE_EXCEPTION = 1004;//查找文件时异常
    /*********************回调函数类型 begin************************/
    public static final int COMM_ALARM = 0x1100;    //8000报警信息主动上传
    public static final int COMM_TRADEINFO = 0x1500;  //ATMDVR主动上传交易信息
    public static final int COMM_ALARM_V30 = 0x4000;//9000报警信息主动上传
    public static final int COMM_ALARM_V40 = 0x4007;
    public static final int COMM_ALARM_RULE = 0x1102;//行为分析信息上传
    public static final int COMM_ALARM_PDC = 0x1103;//客流量统计报警上传
    public static final int COMM_UPLOAD_PLATE_RESULT = 0x2800;//交通抓拍结果上传
    public static final int COMM_ITS_PLATE_RESULT = 0x3050;//交通抓拍的终端图片上传
    public static final int COMM_IPCCFG = 0x4001;//9000设备IPC接入配置改变报警信息主动上传
    public static final int COMM_ITS_PARK_VEHICLE = 0x3056;//停车场数据上传
    public static final int COMM_VEHICLE_CONTROL_ALARM = 0x3059;//车辆报警上传
    public static final int COMM_ALARM_TFS = 0x1113; //交通取证报警信息
    public static final int COMM_ALARM_TPS_V41 = 0x1114; //交通事件报警信息扩展
    public static final int COMM_ALARM_AID_V41 = 0x1115; //交通事件报警信息扩展
    public static final int COMM_UPLOAD_FACESNAP_RESULT = 0x1112;  //人脸识别结果上传
    public static final int COMM_SNAP_MATCH_ALARM = 0x2902;  //人脸比对结果上传
    public static final int COMM_ALARM_ACS = 0x5002; //门禁主机报警信息
    public static final int COMM_ID_INFO_ALARM = 0x5200; //门禁身份证刷卡信息
    public static final int COMM_VCA_ALARM = 0x4993; //智能检测通用报警
    public static final int COMM_ISAPI_ALARM = 0x6009;//ISAPI协议报警信息
    public static final int COMM_ALARM_TPS_STATISTICS = 0x3082; //TPS统计过车数据上传

    public static final int COMM_ALARMHOST_CID_ALARM = 0x1127;  //报告报警上传
    public static final int COMM_SENSOR_VALUE_UPLOAD = 0x1120;  //模拟量数据实时上传
    public static final int COMM_SENSOR_ALARM = 0x1121;  //模拟量报警上传
    public static final int COMM_SWITCH_ALARM = 0x1122;     //开关量报警
    public static final int COMM_ALARMHOST_EXCEPTION = 0x1123;  //报警主机故障报警
    public static final int COMM_ALARMHOST_OPERATEEVENT_ALARM = 0x1124;  //操作事件报警上传
    public static final int COMM_ALARMHOST_SAFETYCABINSTATE = 0x1125;    //防护舱状态
    public static final int COMM_ALARMHOST_ALARMOUTSTATUS = 0x1126;     //报警输出口/警号状态
    public static final int COMM_ALARMHOST_DATA_UPLOAD = 0x1129;     //报警数据上传

    public static final int COMM_UPLOAD_VIDEO_INTERCOM_EVENT = 0x1132;  //可视对讲事件记录上传
    public static final int COMM_ALARM_VIDEO_INTERCOM = 0x1133;  //可视对讲报警上传
    public static final int COMM_THERMOMETRY_ALARM = 0x5212;  //温度报警上传

    public static final int COMM_UPLOAD_AIOP_VIDEO = 0x4021; //设备支持AI开放平台接入，上传视频检测数据
    public static final int COMM_UPLOAD_AIOP_PICTURE = 0x4022; //设备支持AI开放平台接入，上传图片检测数据
    public static final int COMM_UPLOAD_AIOP_POLLING_SNAP = 0x4023; //设备支持AI开放平台接入，上传轮巡抓图图片检测数据 对应的结构体(NET_AIOP_POLLING_PICTURE_HEAD)
    public static final int COMM_UPLOAD_AIOP_POLLING_VIDEO = 0x4024; //设备支持AI开放平台接入，上传轮巡视频检测数据 对应的结构体(NET_AIOP_POLLING_VIDEO_HEAD)

    /*************操作异常类型(消息方式, 回调方式(保留))****************/
    public static final int EXCEPTION_EXCHANGE = 0x8000;//用户交互时异常
    public static final int EXCEPTION_AUDIOEXCHANGE = 0x8001;//语音对讲异常
    public static final int EXCEPTION_ALARM = 0x8002;//报警异常
    public static final int EXCEPTION_PREVIEW = 0x8003;//网络预览异常
    public static final int EXCEPTION_SERIAL = 0x8004;//透明通道异常
    public static final int EXCEPTION_RECONNECT = 0x8005;    //预览时重连
    public static final int EXCEPTION_ALARMRECONNECT = 0x8006;//报警时重连
    public static final int EXCEPTION_SERIALRECONNECT = 0x8007;//透明通道重连
    public static final int EXCEPTION_PLAYBACK = 0x8010;//回放异常
    public static final int EXCEPTION_DISKFMT = 0x8011;//硬盘格式化
    /********************预览回调函数*********************/
    public static final int NET_DVR_SYSHEAD = 1;//系统头数据
    public static final int NET_DVR_STREAMDATA = 2;//视频流数据（包括复合流和音视频分开的视频流数据）
    public static final int NET_DVR_AUDIOSTREAMDATA = 3;//音频流数据
    public static final int NET_DVR_STD_VIDEODATA = 4;//标准视频流数据
    public static final int NET_DVR_STD_AUDIODATA = 5;//标准音频流数据
    //回调预览中的状态和消息
    public static final int NET_DVR_REALPLAYEXCEPTION = 111;//预览异常
    public static final int NET_DVR_REALPLAYNETCLOSE = 112;//预览时连接断开
    public static final int NET_DVR_REALPLAY5SNODATA = 113;//预览5s没有收到数据
    public static final int NET_DVR_REALPLAYRECONNECT = 114;//预览重连
    /********************回放回调函数*********************/
    public static final int NET_DVR_PLAYBACKOVER = 101;//回放数据播放完毕
    public static final int NET_DVR_PLAYBACKEXCEPTION = 102;//回放异常
    public static final int NET_DVR_PLAYBACKNETCLOSE = 103;//回放时候连接断开
    public static final int NET_DVR_PLAYBACK5SNODATA = 104;    //回放5s没有收到数据
    /*********************回调函数类型 end************************/
//设备型号(DVR类型)
    /* 设备类型 */
    public static final int DVR = 1;            /*对尚未定义的dvr类型返回NETRET_DVR*/
    public static final int ATMDVR = 2;        /*atm dvr*/
    public static final int DVS = 3;            /*DVS*/
    public static final int DEC = 4;            /* 6001D */
    public static final int ENC_DEC = 5;            /* 6001F */
    public static final int DVR_HC = 6;            /*8000HC*/
    public static final int DVR_HT = 7;            /*8000HT*/
    public static final int DVR_HF = 8;            /*8000HF*/
    public static final int DVR_HS = 9;            /* 8000HS DVR(no audio) */
    public static final int DVR_HTS = 10;         /* 8016HTS DVR(no audio) */
    public static final int DVR_HB = 11;         /* HB DVR(SATA HD) */
    public static final int DVR_HCS = 12;         /* 8000HCS DVR */
    public static final int DVS_A = 13;         /* 带ATA硬盘的DVS */
    public static final int DVR_HC_S = 14;         /* 8000HC-S */
    public static final int DVR_HT_S = 15;         /* 8000HT-S */
    public static final int DVR_HF_S = 16;         /* 8000HF-S */
    public static final int DVR_HS_S = 17;         /* 8000HS-S */
    public static final int ATMDVR_S = 18;         /* ATM-S */
    public static final int LOWCOST_DVR = 19;            /*7000H系列*/
    public static final int DEC_MAT = 20;         /*多路解码器*/
    public static final int DVR_MOBILE = 21;            /* mobile DVR */
    public static final int DVR_HD_S = 22;        /* 8000HD-S */
    public static final int DVR_HD_SL = 23;            /* 8000HD-SL */
    public static final int DVR_HC_SL = 24;            /* 8000HC-SL */
    public static final int DVR_HS_ST = 25;            /* 8000HS_ST */
    public static final int DVS_HW = 26;         /* 6000HW */
    public static final int IPCAM = 30;            /*IP 摄像机*/
    public static final int MEGA_IPCAM = 31;            /*X52MF系列,752MF,852MF*/
    public static final int IPCAM_X62MF = 32;            /*X62MF系列可接入9000设备,762MF,862MF*/
    public static final int IPDOME = 40;            /*IP标清快球*/
    public static final int MEGA_IPDOME = 41;     /*IP高清快球*/
    public static final int IPMOD = 50;            /*IP 模块*/
    public static final int DS71XX_H = 71;            /* DS71XXH_S */
    public static final int DS72XX_H_S = 72;            /* DS72XXH_S */
    public static final int DS73XX_H_S = 73;            /* DS73XXH_S */
    public static final int DS81XX_HS_S = 81;            /* DS81XX_HS_S */
    public static final int DS81XX_HL_S = 82;            /* DS81XX_HL_S */
    public static final int DS81XX_HC_S = 83;            /* DS81XX_HC_S */
    public static final int DS81XX_HD_S = 84;            /* DS81XX_HD_S */
    public static final int DS81XX_HE_S = 85;            /* DS81XX_HE_S */
    public static final int DS81XX_HF_S = 86;            /* DS81XX_HF_S */
    public static final int DS81XX_AH_S = 87;            /* DS81XX_AH_S */
    public static final int DS81XX_AHF_S = 88;            /* DS81XX_AHF_S */
    public static final int DS90XX_HF_S = 90;       /*DS90XX_HF_S*/
    public static final int DS91XX_HF_S = 91;             /*DS91XX_HF_S*/
    public static final int DS91XX_HD_S = 92;            /*91XXHD-S(MD)*/

    /* 操作 */
//主类型
    public static final int MAJOR_OPERATION = 0x3;
    //次类型
    public static final int MINOR_START_DVR = 0x41; /* 开机 */
    public static final int MINOR_STOP_DVR = 0x42;/* 关机 */
    public static final int MINOR_STOP_ABNORMAL = 0x43;/* 异常关机 */
    public static final int MINOR_REBOOT_DVR = 0x44;   /*本地重启设备*/
    public static final int MINOR_LOCAL_LOGIN = 0x50; /* 本地登陆 */
    public static final int MINOR_LOCAL_LOGOUT = 0x51; /* 本地注销登陆 */
    public static final int MINOR_LOCAL_CFG_PARM = 0x52; /* 本地配置参数 */
    public static final int MINOR_LOCAL_PLAYBYFILE = 0x53; /* 本地按文件回放或下载 */
    public static final int MINOR_LOCAL_PLAYBYTIME = 0x54; /* 本地按时间回放或下载*/
    public static final int MINOR_LOCAL_START_REC = 0x55; /* 本地开始录像 */
    public static final int MINOR_LOCAL_STOP_REC = 0x56; /* 本地停止录像 */
    public static final int MINOR_LOCAL_PTZCTRL = 0x57; /* 本地云台控制 */
    public static final int MINOR_LOCAL_PREVIEW = 0x58;/* 本地预览 (保留不使用)*/
    public static final int MINOR_LOCAL_MODIFY_TIME = 0x59;/* 本地修改时间(保留不使用) */
    public static final int MINOR_LOCAL_UPGRADE = 0x5a;/* 本地升级 */
    public static final int MINOR_LOCAL_RECFILE_OUTPUT = 0x5b;   /* 本地备份录象文件 */
    public static final int MINOR_LOCAL_FORMAT_HDD = 0x5c;  /* 本地初始化硬盘 */
    public static final int MINOR_LOCAL_CFGFILE_OUTPUT = 0x5d;  /* 导出本地配置文件 */
    public static final int MINOR_LOCAL_CFGFILE_INPUT = 0x5e;  /* 导入本地配置文件 */
    public static final int MINOR_LOCAL_COPYFILE = 0x5f;  /* 本地备份文件 */
    public static final int MINOR_LOCAL_LOCKFILE = 0x60;  /* 本地锁定录像文件 */
    public static final int MINOR_LOCAL_UNLOCKFILE = 0x61;   /* 本地解锁录像文件 */
    public static final int MINOR_LOCAL_DVR_ALARM = 0x62;  /* 本地手动清除和触发报警*/
    public static final int MINOR_IPC_ADD = 0x63;  /* 本地添加IPC */
    public static final int MINOR_IPC_DEL = 0x64;  /* 本地删除IPC */
    public static final int MINOR_IPC_SET = 0x65;  /* 本地设置IPC */
    public static final int MINOR_LOCAL_START_BACKUP = 0x66;    /* 本地开始备份 */
    public static final int MINOR_LOCAL_STOP_BACKUP = 0x67;/* 本地停止备份*/
    public static final int MINOR_LOCAL_COPYFILE_START_TIME = 0x68;/* 本地备份开始时间*/
    public static final int MINOR_LOCAL_COPYFILE_END_TIME = 0x69;    /* 本地备份结束时间*/
    public static final int MINOR_REMOTE_LOGIN = 0x70;/* 远程登录 */
    public static final int MINOR_REMOTE_LOGOUT = 0x71;/* 远程注销登陆 */
    public static final int MINOR_REMOTE_START_REC = 0x72;/* 远程开始录像 */
    public static final int MINOR_REMOTE_STOP_REC = 0x73;/* 远程停止录像 */
    public static final int MINOR_START_TRANS_CHAN = 0x74;/* 开始透明传输 */
    public static final int MINOR_STOP_TRANS_CHAN = 0x75; /* 停止透明传输 */
    public static final int MINOR_REMOTE_GET_PARM = 0x76;/* 远程获取参数 */
    public static final int MINOR_REMOTE_CFG_PARM = 0x77;/* 远程配置参数 */
    public static final int MINOR_REMOTE_GET_STATUS = 0x78;/* 远程获取状态 */
    public static final int MINOR_REMOTE_ARM = 0x79; /* 远程布防 */
    public static final int MINOR_REMOTE_DISARM = 0x7a;/* 远程撤防 */
    public static final int MINOR_REMOTE_REBOOT = 0x7b; /* 远程重启 */
    public static final int MINOR_START_VT = 0x7c;/* 开始语音对讲 */
    public static final int MINOR_STOP_VT = 0x7d;/* 停止语音对讲 */
    public static final int MINOR_REMOTE_UPGRADE = 0x7e; /* 远程升级 */
    public static final int MINOR_REMOTE_PLAYBYFILE = 0x7f; /* 远程按文件回放 */
    public static final int MINOR_REMOTE_PLAYBYTIME = 0x80; /* 远程按时间回放 */
    public static final int MINOR_REMOTE_PTZCTRL = 0x81; /* 远程云台控制 */
    public static final int MINOR_REMOTE_FORMAT_HDD = 0x82;  /* 远程格式化硬盘 */
    public static final int MINOR_REMOTE_STOP = 0x83;  /* 远程关机 */
    public static final int MINOR_REMOTE_LOCKFILE = 0x84;/* 远程锁定文件 */
    public static final int MINOR_REMOTE_UNLOCKFILE = 0x85;/* 远程解锁文件 */
    public static final int MINOR_REMOTE_CFGFILE_OUTPUT = 0x86;   /* 远程导出配置文件 */
    public static final int MINOR_REMOTE_CFGFILE_INTPUT = 0x87;   /* 远程导入配置文件 */
    public static final int MINOR_REMOTE_RECFILE_OUTPUT = 0x88;   /* 远程导出录象文件 */
    public static final int MINOR_REMOTE_DVR_ALARM = 0x89;    /* 远程手动清除和触发报警*/
    public static final int MINOR_REMOTE_IPC_ADD = 0x8a;  /* 远程添加IPC */
    public static final int MINOR_REMOTE_IPC_DEL = 0x8b;/* 远程删除IPC */
    public static final int MINOR_REMOTE_IPC_SET = 0x8c; /* 远程设置IPC */
    public static final int MINOR_REBOOT_VCA_LIB = 0x8d;        /*重启智能库*/

    /*日志附加信息*/
//主类型
    public static final int MAJOR_INFORMATION = 0x4;   /*附加信息*/
    //次类型
    public static final int MINOR_HDD_INFO = 0xa1;/*硬盘信息*/
    public static final int MINOR_SMART_INFO = 0xa2;   /*SMART信息*/
    public static final int MINOR_REC_START = 0xa3;   /*开始录像*/
    public static final int MINOR_REC_STOP = 0xa4;/*停止录像*/
    public static final int MINOR_REC_OVERDUE = 0xa5;/*过期录像删除*/
    public static final int MINOR_LINK_START = 0xa6; // ivms多路解码器等连接前端设备
    public static final int MINOR_LINK_STOP = 0xa7;// ivms多路解码器等断开前端设备　
    //当日志的主类型为MAJOR_OPERATION=03，次类型为MINOR_LOCAL_CFG_PARM=0x52或者MINOR_REMOTE_GET_PARM=0x76或者MINOR_REMOTE_CFG_PARM=0x77时，dwParaType:参数类型有效，其含义如下：
    public static final int PARA_VIDEOOUT = 0x1;
    public static final int PARA_IMAGE = 0x2;
    public static final int PARA_ENCODE = 0x4;
    public static final int PARA_NETWORK = 0x8;
    public static final int PARA_ALARM = 0x10;
    public static final int PARA_EXCEPTION = 0x20;
    public static final int PARA_DECODER = 0x40; /*解码器*/
    public static final int PARA_RS232 = 0x80;
    public static final int PARA_PREVIEW = 0x100;
    public static final int PARA_SECURITY = 0x200;
    public static final int PARA_DATETIME = 0x400;
    public static final int PARA_FRAMETYPE = 0x800;  /*帧格式*/
    public static final int PARA_VCA_RULE = 0x1000;    //行为规则
    //SDK_V222
//智能设备类型
    public static final int DS6001_HF_B = 60;//行为分析：DS6001-HF/B
    public static final int DS6001_HF_P = 61;//车牌识别：DS6001-HF/P
    public static final int DS6002_HF_B = 62;//双机跟踪：DS6002-HF/B
    public static final int DS6101_HF_B = 63;//行为分析：DS6101-HF/B
    public static final int IVMS_2000 = 64;//智能分析仪
    public static final int DS9000_IVS = 65;//9000系列智能DVR
    public static final int DS8004_AHL_A = 66;//智能ATM, DS8004AHL-S/A
    public static final int DS6101_HF_P = 67;//车牌识别：DS6101-HF/P
    //能力获取命令
    public static final int VCA_DEV_ABILITY = 0x100;//设备智能分析的总能力
    public static final int VCA_CHAN_ABILITY = 0x110;//行为分析能力
    public static final int DEVICE_ABILITY_INFO = 0x011; //设备通用能力类型，具体能力根据发送的能力节点来区分
    /**********************设备类型 end***********************/

    /*************************************************
     参数配置结构、参数(其中_V30为9000新增)
     **************************************************/

    /////////////////////////////////////////////////////////////////////////
    //校时结构参数
    public static class NET_DVR_TIME extends Structure {//校时结构参数
        public int dwYear;        //年
        public int dwMonth;        //月
        public int dwDay;        //日
        public int dwHour;        //时
        public int dwMinute;        //分
        public int dwSecond;        //秒

        public String toString() {
            return "NET_DVR_TIME.dwYear: " + dwYear + "\n" + "NET_DVR_TIME.dwMonth: \n" + dwMonth + "\n" + "NET_DVR_TIME.dwDay: \n" + dwDay + "\n" + "NET_DVR_TIME.dwHour: \n" + dwHour + "\n" + "NET_DVR_TIME.dwMinute: \n" + dwMinute + "\n" + "NET_DVR_TIME.dwSecond: \n" + dwSecond;
        }

        //用于列表中显示
        public String toStringTime() {
            return String.format("%02d/%02d/%02d%02d:%02d:%02d", dwYear, dwMonth, dwDay, dwHour, dwMinute, dwSecond);
        }

        //存储文件名使用
        public String toStringTitle() {
            return String.format("Time%02d%02d%02d%02d%02d%02d", dwYear, dwMonth, dwDay, dwHour, dwMinute, dwSecond);
        }
    }

    public static class NET_DVR_SCHEDTIME extends Structure {
        public byte byStartHour;    //开始时间
        public byte byStartMin;
        public byte byStopHour;            //结束时间
        public byte byStopMin;


    }

    public static class NET_DVR_HANDLEEXCEPTION_V30 extends Structure {
        public int dwHandleType;    /*处理方式,处理方式的"或"结果*//*0x00: 无响应*//*0x01: 监视器上警告*//*0x02: 声音警告*//*0x04: 上传中心*/    /*0x08: 触发报警输出*//*0x20: 触发抓图*/  //(JPEG定制)
        public byte[] byRelAlarmOut = new byte[MAX_ALARMOUT_V30];  //报警触发的输出通道,报警触发的输出,为1表示触发该输出

    }

    //报警和异常处理结构(子结构)(多处使用)
    public static class NET_DVR_HANDLEEXCEPTION extends Structure {
        public int dwHandleType;            /*处理方式,处理方式的"或"结果*//*0x00: 无响应*//*0x01: 监视器上警告*//*0x02: 声音警告*//*0x04: 上传中心*/    /*0x08: 触发报警输出*//*0x20: 触发抓图*/  //(JPEG定制)
        public byte[] byRelAlarmOut = new byte[MAX_ALARMOUT];  //报警触发的输出通道,报警触发的输出,为1表示触发该输出

    }

    //DVR设备参数
    public static class NET_DVR_DEVICECFG extends Structure {
        public int dwSize;
        public byte[] sDVRName = new byte[NAME_LEN];     //DVR名称
        public int dwDVRID;                 //DVR ID,用于遥控器 //V1.4(0-99), V1.5(0-255)
        public int dwRecycleRecord;                 //是否循环录像,0:不是; 1:是
        //以下不可更改
        public byte[] sSerialNumber = new byte[SERIALNO_LEN];  //序列号
        public int dwSoftwareVersion;                   //软件版本号,高16位是主版本,低16位是次版本
        public int dwSoftwareBuildDate;                    //软件生成日期,0xYYYYMMDD
        public int dwDSPSoftwareVersion;                //DSP软件版本,高16位是主版本,低16位是次版本
        public int dwDSPSoftwareBuildDate;                // DSP软件生成日期,0xYYYYMMDD
        public int dwPanelVersion;                // 前面板版本,高16位是主版本,低16位是次版本
        public int dwHardwareVersion;            // 硬件版本,高16位是主版本,低16位是次版本
        public byte byAlarmInPortNum;        //DVR报警输入个数
        public byte byAlarmOutPortNum;        //DVR报警输出个数
        public byte byRS232Num;            //DVR 232串口个数
        public byte byRS485Num;            //DVR 485串口个数
        public byte byNetworkPortNum;        //网络口个数
        public byte byDiskCtrlNum;            //DVR 硬盘控制器个数
        public byte byDiskNum;                //DVR 硬盘个数
        public byte byDVRType;                //DVR类型, 1:DVR 2:ATM DVR 3:DVS ......
        public byte byChanNum;                //DVR 通道个数
        public byte byStartChan;            //起始通道号,例如DVS-1,DVR - 1
        public byte byDecordChans;            //DVR 解码路数
        public byte byVGANum;                //VGA口的个数
        public byte byUSBNum;                //USB口的个数
        public byte byAuxoutNum;            //辅口的个数
        public byte byAudioNum;                    //语音口的个数
        public byte byIPChanNum;            //最大数字通道数


    }

    //DVR设备参数
    public static class NET_DVR_DEVICECFG_V40 extends Structure {
        public int dwSize;
        public byte[] sDVRName = new byte[NAME_LEN];     //DVR名称
        public int dwDVRID;                //DVR ID,用于遥控器 //V1.4(0-99), V1.5(0-255)
        public int dwRecycleRecord;        //是否循环录像,0:不是; 1:是
        //以下不可更改
        public byte[] sSerialNumber = new byte[SERIALNO_LEN];  //序列号
        public int dwSoftwareVersion;            //软件版本号,高16位是主版本,低16位是次版本
        public int dwSoftwareBuildDate;            //软件生成日期,0xYYYYMMDD
        public int dwDSPSoftwareVersion;            //DSP软件版本,高16位是主版本,低16位是次版本
        public int dwDSPSoftwareBuildDate;        // DSP软件生成日期,0xYYYYMMDD
        public int dwPanelVersion;                // 前面板版本,高16位是主版本,低16位是次版本
        public int dwHardwareVersion;    // 硬件版本,高16位是主版本,低16位是次版本
        public byte byAlarmInPortNum;        //DVR报警输入个数
        public byte byAlarmOutPortNum;        //DVR报警输出个数
        public byte byRS232Num;            //DVR 232串口个数
        public byte byRS485Num;            //DVR 485串口个数
        public byte byNetworkPortNum;        //网络口个数
        public byte byDiskCtrlNum;            //DVR 硬盘控制器个数
        public byte byDiskNum;                //DVR 硬盘个数
        public byte byDVRType;                //DVR类型, 1:DVR 2:ATM DVR 3:DVS ......
        public byte byChanNum;                //DVR 通道个数
        public byte byStartChan;            //起始通道号,例如DVS-1,DVR - 1
        public byte byDecordChans;            //DVR 解码路数
        public byte byVGANum;                //VGA口的个数
        public byte byUSBNum;                //USB口的个数
        public byte byAuxoutNum;            //辅口的个数
        public byte byAudioNum;            //语音口的个数
        public byte byIPChanNum;            //最大数字通道数 低8位，高8位见byHighIPChanNum
        public byte byZeroChanNum;            //零通道编码个数
        public byte bySupport;        //能力，位与结果为0表示不支持，1表示支持，
        public byte byEsataUseage;        //Esata的默认用途，0-默认备份，1-默认录像
        public byte byIPCPlug;            //0-关闭即插即用，1-打开即插即用
        public byte byStorageMode;        //0-盘组模式,1-磁盘配额, 2抽帧模式, 3-自动
        public byte bySupport1;        //能力，位与结果为0表示不支持，1表示支持
        public short wDevType;//设备型号
        public byte[] byDevTypeName = new byte[DEV_TYPE_NAME_LEN];//设备型号名称
        public byte bySupport2; //能力集扩展，位与结果为0表示不支持，1表示支持
        //bySupport2 & 0x1, 表示是否支持扩展的OSD字符叠加(终端和抓拍机扩展区分)
        public byte byAnalogAlarmInPortNum; //模拟报警输入个数
        public byte byStartAlarmInNo;    //模拟报警输入起始号
        public byte byStartAlarmOutNo;  //模拟报警输出起始号
        public byte byStartIPAlarmInNo;  //IP报警输入起始号
        public byte byStartIPAlarmOutNo; //IP报警输出起始号
        public byte byHighIPChanNum;      //数字通道个数，高8位
        public byte byEnableRemotePowerOn;//是否启用在设备休眠的状态下远程开机功能，0-不启用，1-启用
        public short wDevClass; //设备大类备是属于哪个产品线，0 保留，1-50 DVR，51-100 DVS，101-150 NVR，151-200 IPC，65534 其他，具体分类方法见《设备类型对应序列号和类型值.docx》
        public byte[] byRes2 = new byte[6];    //保留


    }

    public static class NET_DVR_IPADDR extends Structure {
        public byte[] sIpV4 = new byte[16];
        public byte[] byRes = new byte[128];

        public String toString() {
            return "NET_DVR_IPADDR.sIpV4: " + new String(sIpV4) + "\n" + "NET_DVR_IPADDR.byRes: " + new String(byRes) + "\n";
        }


    }


    //网络数据结构(子结构)(9000扩展)
    public static class NET_DVR_ETHERNET_V30 extends Structure {
        public NET_DVR_IPADDR struDVRIP;
        public NET_DVR_IPADDR struDVRIPMask;
        public int dwNetInterface;
        public short wDVRPort;
        public short wMTU;
        public byte[] byMACAddr = new byte[6];

        public String toString() {
            return "NET_DVR_ETHERNET_V30.struDVRIP: \n" + struDVRIP + "\n" + "NET_DVR_ETHERNET_V30.struDVRIPMask: \n" + struDVRIPMask + "\n" + "NET_DVR_ETHERNET_V30.dwNetInterface: " + dwNetInterface + "\n" + "NET_DVR_ETHERNET_V30.wDVRPort: " + wDVRPort + "\n" + "NET_DVR_ETHERNET_V30.wMTU: " + wMTU + "\n" + "NET_DVR_ETHERNET_V30.byMACAddr: " + new String(byMACAddr) + "\n";
        }


    }

    public static class NET_DVR_ETHERNET extends Structure {//网络数据结构(子结构)
        public byte[] sDVRIP = new byte[16];                    //DVR IP地址
        public byte[] sDVRIPMask = new byte[16];                //DVR IP地址掩码
        public int dwNetInterface;               //网络接口 1-10MBase-T 2-10MBase-T全双工 3-100MBase-TX 4-100M全双工 5-10M/100M自适应
        public short wDVRPort;                        //端口号
        public byte[] byMACAddr = new byte[MACADDR_LEN];        //服务器的物理地址


    }

    public static class NET_DVR_PPPOECFG extends Structure {//PPPoe
        public int dwPPPoE;
        public byte[] sPPPoEUser = new byte[32];
        public byte[] sPPPoEPassword = new byte[16];
        public NET_DVR_IPADDR struPPPoEIP;


    }

    public static class NET_DVR_NETCFG_V30 extends Structure {
        public int dwSize;
        public NET_DVR_ETHERNET_V30[] struEtherNet = new NET_DVR_ETHERNET_V30[2];
        public NET_DVR_IPADDR[] struRes1 = new NET_DVR_IPADDR[2];
        public NET_DVR_IPADDR struAlarmHostIpAddr;
        public short[] wRes2 = new short[2];
        public short wAlarmHostIpPort;
        public byte byUseDhcp;
        public byte byRes3;
        public NET_DVR_IPADDR struDnsServer1IpAddr;
        public NET_DVR_IPADDR struDnsServer2IpAddr;
        public byte[] byIpResolver = new byte[64];
        public short wIpResolverPort;
        public short wHttpPortNo;
        public NET_DVR_IPADDR struMulticastIpAddr;
        public NET_DVR_IPADDR struGatewayIpAddr;
        public NET_DVR_PPPOECFG struPPPoE;
        public byte[] byRes = new byte[64];

        public String toString() {
            return "NET_DVR_NETCFG_V30.dwSize: " + dwSize + "\n" + "NET_DVR_NETCFG_V30.struEtherNet[0]: \n" + struEtherNet[0] + "\n" + "NET_DVR_NETCFG_V30.struAlarmHostIpAddr: \n" + struAlarmHostIpAddr + "\n" + "NET_DVR_NETCFG_V30.wAlarmHostIpPort: " + wAlarmHostIpPort + "\n" + "NET_DVR_NETCFG_V30.wHttpPortNo: " + wHttpPortNo + "\n" + "NET_DVR_NETCFG_V30.struGatewayIpAddr: \n" + struGatewayIpAddr + "\n";
        }


    }


    public static class NET_DVR_NETCFG extends Structure {//网络配置结构
        public int dwSize;
        public NET_DVR_ETHERNET[] struEtherNet = new NET_DVR_ETHERNET[MAX_ETHERNET];        /* 以太网口 */
        public byte[] sManageHostIP = new byte[16];            //远程管理主机地址
        public short wManageHostPort;            //远程管理主机端口号
        public byte[] sIPServerIP = new byte[16];           //IPServer服务器地址
        public byte[] sMultiCastIP = new byte[16];          //多播组地址
        public byte[] sGatewayIP = new byte[16];            //网关地址
        public byte[] sNFSIP = new byte[16];                //NFS主机IP地址
        public byte[] sNFSDirectory = new byte[PATHNAME_LEN];//NFS目录
        public int dwPPPOE;                    //0-不启用,1-启用
        public byte[] sPPPoEUser = new byte[NAME_LEN];        //PPPoE用户名
        public byte[] sPPPoEPassword = new byte[PASSWD_LEN];// PPPoE密码
        public byte[] sPPPoEIP = new byte[16];                //PPPoE IP地址(只读)


    }

    //通道图象结构
    public static class NET_DVR_SCHEDTIMEWEEK extends Structure {
        public NET_DVR_SCHEDTIME[] struAlarmTime = new NET_DVR_SCHEDTIME[8];


    }

    public static class byte96 extends Structure {
        public byte[] byMotionScope = new byte[96];


    }

    public static class NET_DVR_MOTION_V30 extends Structure {//移动侦测(子结构)(9000扩展)
        public byte96[] byMotionScope = new byte96[64];                        /*侦测区域,0-96位,表示64行,共有96*64个小宏块,为1表示是移动侦测区域,0-表示不是*/
        public byte byMotionSensitive;                            /*移动侦测灵敏度, 0 - 5,越高越灵敏,oxff关闭*/
        public byte byEnableHandleMotion;                        /* 是否处理移动侦测 0－否 1－是*/
        public byte byPrecision;                            /* 移动侦测算法的进度: 0--16*16, 1--32*32, 2--64*64 ... */
        public byte reservedData;
        public NET_DVR_HANDLEEXCEPTION_V30 struMotionHandleType;            /* 处理方式 */
        public NET_DVR_SCHEDTIMEWEEK[] struAlarmTime = new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS]; /*布防时间*/
        public byte[] byRelRecordChan = new byte[64];                    /* 报警触发的录象通道*/


    }

    public static class NET_DVR_MOTION extends Structure {//移动侦测(子结构)
        public byte[] byMotionScope = new byte[18 * 22];    /*侦测区域,共有22*18个小宏块,为1表示改宏块是移动侦测区域,0-表示不是*/
        public byte byMotionSensitive;        /*移动侦测灵敏度, 0 - 5,越高越灵敏,0xff关闭*/
        public byte byEnableHandleMotion;    /* 是否处理移动侦测 */
        public byte[] reservedData = new byte[2];
        public NET_DVR_HANDLEEXCEPTION strMotionHandleType;    /* 处理方式 */
        public byte[] byRelRecordChan = new byte[MAX_CHANNUM]; //报警触发的录象通道,为1表示触发该通道


    }

    public static class NET_DVR_HIDEALARM_V30 extends Structure {//遮挡报警
        public int dwEnableHideAlarm;                /* 是否启动遮挡报警 ,0-否,1-低灵敏度 2-中灵敏度 3-高灵敏度*/
        public short wHideAlarmAreaTopLeftX;            /* 遮挡区域的x坐标 */
        public short wHideAlarmAreaTopLeftY;            /* 遮挡区域的y坐标 */
        public short wHideAlarmAreaWidth;                /* 遮挡区域的宽 */
        public short wHideAlarmAreaHeight;                /*遮挡区域的高*/
        public NET_DVR_HANDLEEXCEPTION_V30 strHideAlarmHandleType;    /* 处理方式 */
        public NET_DVR_SCHEDTIMEWEEK[] struAlarmTime = new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS];//布防时间


    }

    public static class NET_DVR_HIDEALARM extends Structure {//遮挡报警(子结构)  区域大小704*576
        public int dwEnableHideAlarm;                /* 是否启动遮挡报警 ,0-否,1-低灵敏度 2-中灵敏度 3-高灵敏度*/
        public short wHideAlarmAreaTopLeftX;            /* 遮挡区域的x坐标 */
        public short wHideAlarmAreaTopLeftY;            /* 遮挡区域的y坐标 */
        public short wHideAlarmAreaWidth;                /* 遮挡区域的宽 */
        public short wHideAlarmAreaHeight;                /*遮挡区域的高*/
        public NET_DVR_HANDLEEXCEPTION strHideAlarmHandleType;    /* 处理方式 */


    }

    public static class NET_DVR_VILOST_V30 extends Structure {    //信号丢失报警(子结构)(9000扩展)
        public byte byEnableHandleVILost;                         /* 是否处理信号丢失报警 */
        public NET_DVR_HANDLEEXCEPTION_V30 strVILostHandleType;         /* 处理方式 */
        public NET_DVR_SCHEDTIMEWEEK[] struAlarmTime = new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS];//布防时间

    }

    public static class NET_DVR_VILOST extends Structure {    //信号丢失报警(子结构)
        public byte byEnableHandleVILost;    /* 是否处理信号丢失报警 */
        public NET_DVR_HANDLEEXCEPTION strVILostHandleType;    /* 处理方式 */

    }

    public static class NET_DVR_SHELTER extends Structure {  //遮挡区域(子结构)
        public short wHideAreaTopLeftX;                /* 遮挡区域的x坐标 */
        public short wHideAreaTopLeftY;                /* 遮挡区域的y坐标 */
        public short wHideAreaWidth;                /* 遮挡区域的宽 */
        public short wHideAreaHeight;                /* 遮挡区域的高*/


    }

    public static class NET_DVR_COLOR extends Structure {
        public byte byBrightness;    /*亮度,0-255*/
        public byte byContrast;        /*对比度,0-255*/
        public byte bySaturation;    /*饱和度,0-255*/
        public byte byHue;            /*色调,0-255*/


    }

    public static class NET_DVR_VICOLOR extends Structure {
        public NET_DVR_COLOR[] struColor = new NET_DVR_COLOR[MAX_TIMESEGMENT_V30];/*图象参数(第一个有效，其他三个保留)*/
        public NET_DVR_SCHEDTIME[] struHandleTime = new NET_DVR_SCHEDTIME[MAX_TIMESEGMENT_V30];/*处理时间段(保留)*/


    }

    //信号丢失
    public static class NET_DVR_VILOST_V40 extends Structure {
        public int dwEnableVILostAlarm;                /* 是否启动信号丢失报警 ,0-否,1-是*/
        /* 信号丢失触发报警输出 */
        public int dwHandleType;        //异常处理,异常处理方式的"或"结果
        /*0x00: 无响应*/
        /*0x01: 监视器上警告*/
        /*0x02: 声音警告*/
        /*0x04: 上传中心*/
        /*0x08: 触发报警输出*/
        /*0x10: 触发JPRG抓图并上传Email*/
        /*0x20: 无线声光报警器联动*/
        /*0x40: 联动电子地图(目前只有PCNVR支持)*/
        /*0x200: 抓图并上传FTP*/
        /*0x1000:抓图上传到云*/
        public int dwMaxRelAlarmOutChanNum; //触发的报警输出通道数（只读）最大支持数量
        public int[] dwRelAlarmOut = new int[MAX_ALARMOUT_V40]; /*触发报警输出号，按值表示,采用紧凑型排列，从下标0 - dwRelAlarmOut -1有效，如果中间遇到0xffffffff,则后续无效*/
        public NET_DVR_SCHEDTIMEWEEK[] struAlarmTime = new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS]; /*布防时间*/
        public byte byVILostAlarmThreshold;    /*信号丢失报警阈值，当值低于阈值，认为信号丢失，取值0-99*/
        public byte[] byRes = new byte[63]; //保留


    }

    public static class NET_DVR_DNMODE extends Structure {
        public byte byObjectSize;//占比参数(0~100)
        public byte byMotionSensitive; /*移动侦测灵敏度, 0 - 5,越高越灵敏,0xff关闭*/
        public byte[] byRes = new byte[6];


    }

    public static class NET_DVR_MOTION_MULTI_AREAPARAM extends Structure {
        public byte byAreaNo;//区域编号(IPC- 1~8)
        public byte[] byRes = new byte[3];
        public NET_VCA_RECT struRect = new NET_VCA_RECT();//单个区域的坐标信息(矩形) size = 16;
        public NET_DVR_DNMODE struDayNightDisable = new NET_DVR_DNMODE();//关闭模式
        public NET_DVR_DNMODE struDayModeParam = new NET_DVR_DNMODE();//白天模式
        public NET_DVR_DNMODE struNightModeParam = new NET_DVR_DNMODE();//夜晚模式
        public byte[] byRes1 = new byte[8];


    }

    public static final int MAX_MULTI_AREA_NUM = 24;

    public static class NET_DVR_MOTION_MULTI_AREA extends Structure {
        public byte byDayNightCtrl;//日夜控制 0~关闭,1~自动切换,2~定时切换(默认关闭)
        public byte byAllMotionSensitive; /*移动侦测灵敏度, 0 - 5,越高越灵敏,0xff关闭，全部区域的灵敏度范围*/
        public byte[] byRes = new byte[2];//
        public NET_DVR_SCHEDULE_DAYTIME struScheduleTime = new NET_DVR_SCHEDULE_DAYTIME();//切换时间  16
        public NET_DVR_MOTION_MULTI_AREAPARAM[] struMotionMultiAreaParam = new NET_DVR_MOTION_MULTI_AREAPARAM[MAX_MULTI_AREA_NUM];//最大支持24个区域
        public byte[] byRes1 = new byte[60];


    }

    public static class NET_DVR_MOTION_SINGLE_AREA extends Structure {
        public byte[] byMotionScope = new byte[64 * 96];        /*侦测区域,0-96位,表示64行,共有96*64个小宏块,目前有效的是22*18,为1表示是移动侦测区域,0-表示不是*/
        public byte byMotionSensitive;            /*移动侦测灵敏度, 0 - 5,越高越灵敏,0xff关闭*/
        public byte[] byRes = new byte[3];


    }

    public static class NET_DVR_MOTION_MODE_PARAM extends Structure {
        public NET_DVR_MOTION_SINGLE_AREA struMotionSingleArea = new NET_DVR_MOTION_SINGLE_AREA(); //普通模式下的单区域设
        public NET_DVR_MOTION_MULTI_AREA struMotionMultiArea = new NET_DVR_MOTION_MULTI_AREA(); //专家模式下的多区域设置


    }

    public static class NET_DVR_MOTION_V40 extends Structure {
        public NET_DVR_MOTION_MODE_PARAM struMotionMode = new NET_DVR_MOTION_MODE_PARAM(); //(5.1.0新增)
        public byte byEnableHandleMotion;        /* 是否处理移动侦测 0－否 1－是*/
        public byte byEnableDisplay;    /*启用移动侦测高亮显示，0-否，1-是*/
        public byte byConfigurationMode; //0~普通,1~专家(5.1.0新增)
        public byte byKeyingEnable; //启用键控移动侦测 0-不启用，1-启用
        /* 异常处理方式 */
        public int dwHandleType;        //异常处理,异常处理方式的"或"结果
        /*0x00: 无响应*/
        /*0x01: 监视器上警告*/
        /*0x02: 声音警告*/
        /*0x04: 上传中心*/
        /*0x08: 触发报警输出*/
        /*0x10: 触发JPRG抓图并上传Email*/
        /*0x20: 无线声光报警器联动*/
        /*0x40: 联动电子地图(目前只有PCNVR支持)*/
        /*0x200: 抓图并上传FTP*/
        /*0x1000: 抓图上传到云*/
        public int dwMaxRelAlarmOutChanNum; //触发的报警输出通道数（只读）最大支持数量
        public int[] dwRelAlarmOut = new int[MAX_ALARMOUT_V40]; //实际触发的报警输出号，按值表示,采用紧凑型排列，从下标0 - dwRelAlarmOut -1有效，如果中间遇到0xffffffff,则后续无效
        public NET_DVR_SCHEDTIMEWEEK[] struAlarmTime = new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS]; /*布防时间*/
        /*触发的录像通道*/
        public int dwMaxRecordChanNum;   //设备支持的最大关联录像通道数-只读
        public int[] dwRelRecordChan = new int[MAX_CHANNUM_V40];     /* 实际触发录像通道，按值表示,采用紧凑型排列，从下标0 - dwRelRecordChan -1有效，如果中间遇到0xffffffff,则后续无效*/
        public byte byDiscardFalseAlarm; //启用去误报 0-无效，1-不启用，2-启用
        public byte[] byRes = new byte[127]; //保留字节


    }

    public static class NET_DVR_RGB_COLOR extends Structure {
        public byte byRed;      //RGB颜色三分量中的红色
        public byte byGreen;    //RGB颜色三分量中的绿色
        public byte byBlue;     //RGB颜色三分量中的蓝色
        public byte byRes;       //保留


    }

    public static class NET_DVR_HIDEALARM_V40 extends Structure {
        public int dwEnableHideAlarm;                /* 是否启动遮挡报警，0-否，1-低灵敏度，2-中灵敏度，3-高灵敏度*/
        public short wHideAlarmAreaTopLeftX;            /* 遮挡区域的x坐标 */
        public short wHideAlarmAreaTopLeftY;            /* 遮挡区域的y坐标 */
        public short wHideAlarmAreaWidth;                /* 遮挡区域的宽 */
        public short wHideAlarmAreaHeight;                /*遮挡区域的高*/
        /* 信号丢失触发报警输出 */
        public int dwHandleType;        //异常处理,异常处理方式的"或"结果
        /*0x00: 无响应*/
        /*0x01: 监视器上警告*/
        /*0x02: 声音警告*/
        /*0x04: 上传中心*/
        /*0x08: 触发报警输出*/
        /*0x10: 触发JPRG抓图并上传Email*/
        /*0x20: 无线声光报警器联动*/
        /*0x40: 联动电子地图(目前只有PCNVR支持)*/
        /*0x200: 抓图并上传FTP*/
        /*0x1000:抓图上传到云*/
        public int dwMaxRelAlarmOutChanNum; //触发的报警输出通道数（只读）最大支持数量
        public int[] dwRelAlarmOut = new int[MAX_ALARMOUT_V40]; /*触发报警输出号，按值表示,采用紧凑型排列，从下标0 - dwRelAlarmOut -1有效，如果中间遇到0xffffffff,则后续无效*/
        public NET_DVR_SCHEDTIMEWEEK[] struAlarmTime = new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS]; /*布防时间*/
        public byte[] byRes = new byte[64]; //保留


    }//遮挡报警

    public static class NET_DVR_PICCFG_V40 extends Structure {
        public int dwSize;
        public byte[] sChanName = new byte[NAME_LEN];
        public int dwVideoFormat;    /* 只读 视频制式 1-NTSC 2-PAL  */
        public NET_DVR_VICOLOR struViColor = new NET_DVR_VICOLOR();//    图像参数按时间段设置
        //显示通道名
        public int dwShowChanName; // 预览的图象上是否显示通道名称,0-不显示,1-显示
        public short wShowNameTopLeftX;                /* 通道名称显示位置的x坐标 */
        public short wShowNameTopLeftY;                /* 通道名称显示位置的y坐标 */
        //隐私遮挡
        public int dwEnableHide;        /* 是否启动遮挡 ,0-否,1-是*/
        public NET_DVR_SHELTER[] struShelter = new NET_DVR_SHELTER[MAX_SHELTERNUM];
        //OSD
        public int dwShowOsd;// 预览的图象上是否显示OSD,0-不显示,1-显示
        public short wOSDTopLeftX;                /* OSD的x坐标 */
        public short wOSDTopLeftY;                /* OSD的y坐标 */
        public byte byOSDType;                    /* OSD类型(主要是年月日格式) */
        /* 0: XXXX-XX-XX 年月日 */
        /* 1: XX-XX-XXXX 月日年 */
        /* 2: XXXX年XX月XX日 */
        /* 3: XX月XX日XXXX年 */
        /* 4: XX-XX-XXXX 日月年*/
        /* 5: XX日XX月XXXX年 */
        /*6: xx/xx/xxxx(月/日/年) */
        /*7: xxxx/xx/xx(年/月/日) */
        /*8: xx/xx/xxxx(日/月/年)*/
        public byte byDispWeek;                /* 是否显示星期 */
        public byte byOSDAttrib;                /* OSD属性:透明，闪烁 */
        /* 0: 不显示OSD */
        /* 1: 透明，闪烁 */
        /* 2: 透明，不闪烁 */
        /* 3: 不透明，闪烁 */
        /* 4: 不透明，不闪烁 */
        public byte byHourOSDType;                /* OSD小时制:0-24小时制,1-12小时制 */
        public byte byFontSize;      //16*16(中)/8*16(英)，1-32*32(中)/16*32(英)，2-64*64(中)/32*64(英)  3-48*48(中)/24*48(英) 4-24*24(中)/12*24(英) 5-96*96(中)/48*96(英) 6-128*128(中)/64*128(英) 7-80*80(中)/40*80(英) 8-112*112(中)/56*112(英) 0xff-自适应(adaptive)
        public byte byOSDColorType;     //0-默认（黑白）；1-自定义
        public byte byAlignment;//对齐方式 0-自适应，1-右对齐, 2-左对齐，3-国标模式，4-全部右对齐(包含叠加字符、时间以及标题等所有OSD字符)，5-全部左对齐(包含叠加字符、时间以及标题等所有OSD字符)
        public byte byOSDMilliSecondEnable;//视频叠加时间支持毫秒；0~不叠加, 1-叠加
        public NET_DVR_VILOST_V40 struVILost = new NET_DVR_VILOST_V40();  //视频信号丢失报警（支持组）
        public NET_DVR_VILOST_V40 struAULost = new NET_DVR_VILOST_V40();  /*音频信号丢失报警（支持组）*/
        public NET_DVR_MOTION_V40 struMotion = new NET_DVR_MOTION_V40();  //移动侦测报警（支持组）
        public NET_DVR_HIDEALARM_V40 struHideAlarm = new NET_DVR_HIDEALARM_V40();  //遮挡报警（支持组）
        public NET_DVR_RGB_COLOR struOsdColor = new NET_DVR_RGB_COLOR();//OSD颜色
        public int dwBoundary; //边界值，左对齐，右对齐以及国标模式的边界值，0-表示默认值，单位：像素;在国标模式下，单位修改为字符个数（范围是，0,1,2）
        public NET_DVR_RGB_COLOR struOsdBkColor = new NET_DVR_RGB_COLOR(); //自定义OSD背景色
        public byte byOSDBkColorMode; //OSD背景色模式，0-默认，1-自定义OSD背景色
        public byte byUpDownBoundary; //上下最小边界值选项，单位为字符个数（范围是，0,1,2）,国标模式下无效。byAlignment=3该字段无效，通过dwBoundary进行边界配置，.byAlignment不等于3的情况下， byUpDownBoundary/byLeftRightBoundary配置成功后，dwBoundary值将不生效
        public byte byLeftRightBoundary; //左右最小边界值选项，单位为字符个数（范围是，0,1,2）, 国标模式下无效。byAlignment=3该字段无效，通过dwBoundary进行边界配置，.byAlignment不等于3的情况下， byUpDownBoundary/byLeftRightBoundary配置成功后，dwBoundary值将不生效
        public byte[] byRes = new byte[113];


    }

    public static class NET_DVR_PICCFG_V30 extends Structure {
        public int dwSize;
        public byte[] sChanName = new byte[NAME_LEN];
        public int dwVideoFormat;                /* 只读 视频制式 1-NTSC 2-PAL*/
        public NET_DVR_VICOLOR struViColor;        // 图像参数按时间段设置
        public int dwShowChanName;               // 预览的图象上是否显示通道名称,0-不显示,1-显示 区域大小704*576
        public short wShowNameTopLeftX;                /* 通道名称显示位置的x坐标 */
        public short wShowNameTopLeftY;                /* 通道名称显示位置的y坐标 */
        public NET_DVR_VILOST_V30 struVILost;      //视频信号丢失报警
        public NET_DVR_VILOST_V30 struAULost;    /*音频信号丢失报警(保留)*/
        public NET_DVR_MOTION_V30 struMotion;      //移动侦测
        public NET_DVR_HIDEALARM_V30 struHideAlarm;//遮挡报警
        public int dwEnableHide;                    /* 是否启动遮盖(区域大小704*576) ,0-否,1-是*/
        public NET_DVR_SHELTER[] struShelter = new NET_DVR_SHELTER[4];
        public int dwShowOsd;                //预览的图象上是否显示OSD,0-不显示,1-显示 区域大小704*576
        public short wOSDTopLeftX;                /* OSD的x坐标 */
        public short wOSDTopLeftY;                /* OSD的y坐标 */
        public byte byOSDType;                    /* OSD类型(主要是年月日格式) */
        public byte byDispWeek;                /* 是否显示星期 */
        public byte byOSDAttrib;                /* OSD属性:透明，闪烁 */
        public byte byHourOSDType;                /* OSD小时制:0-24小时制,1-12小时制 */
        public byte[] byRes = new byte[64];


    }

    public static class NET_DVR_PICCFG_EX extends Structure {//通道图象结构SDK_V14扩展
        public int dwSize;
        public byte[] sChanName = new byte[NAME_LEN];
        public int dwVideoFormat;    /* 只读 视频制式 1-NTSC 2-PAL*/
        public byte byBrightness;    /*亮度,0-255*/
        public byte byContrast;        /*对比度,0-255*/
        public byte bySaturation;    /*饱和度,0-255 */
        public byte byHue;                /*色调,0-255*/
        //显示通道名
        public int dwShowChanName; // 预览的图象上是否显示通道名称,0-不显示,1-显示 区域大小704*576
        public short wShowNameTopLeftX;                /* 通道名称显示位置的x坐标 */
        public short wShowNameTopLeftY;                /* 通道名称显示位置的y坐标 */
        //信号丢失报警
        public NET_DVR_VILOST struVILost;
        //移动侦测
        public NET_DVR_MOTION struMotion;
        //遮挡报警
        public NET_DVR_HIDEALARM struHideAlarm;
        //遮挡  区域大小704*576
        public int dwEnableHide;        /* 是否启动遮挡 ,0-否,1-是*/
        public NET_DVR_SHELTER[] struShelter = new NET_DVR_SHELTER[MAX_SHELTERNUM];
        //OSD
        public int dwShowOsd;// 预览的图象上是否显示OSD,0-不显示,1-显示 区域大小704*576
        public short wOSDTopLeftX;                /* OSD的x坐标 */
        public short wOSDTopLeftY;                /* OSD的y坐标 */
        public byte byOSDType;                    /* OSD类型(主要是年月日格式) */
        /* 0: XXXX-XX-XX 年月日 */
        /* 1: XX-XX-XXXX 月日年 */
        /* 2: XXXX年XX月XX日 */
        /* 3: XX月XX日XXXX年 */
        /* 4: XX-XX-XXXX 日月年*/
        /* 5: XX日XX月XXXX年 */
        public byte byDispWeek;                /* 是否显示星期 */
        public byte byOSDAttrib;                /* OSD属性:透明，闪烁 */
        /* 0: 不显示OSD */
        /* 1: 透明,闪烁 */
        /* 2: 透明,不闪烁 */
        /* 3: 闪烁,不透明 */
        /* 4: 不透明,不闪烁 */
        public byte byHourOsdType;    //小时制：0表示24小时制，1-12小时制或am/pm


    }


    public static class NET_DVR_PICCFG extends Structure { //通道图象结构(SDK_V13及之前版本)
        public int dwSize;
        public byte[] sChanName = new byte[NAME_LEN];
        public int dwVideoFormat;    /* 只读 视频制式 1-NTSC 2-PAL*/
        public byte byBrightness;    /*亮度,0-255*/
        public byte byContrast;        /*对比度,0-255*/
        public byte bySaturation;    /*饱和度,0-255 */
        public byte byHue;                /*色调,0-255*/
        //显示通道名
        public int dwShowChanName; // 预览的图象上是否显示通道名称,0-不显示,1-显示 区域大小704*576
        public short wShowNameTopLeftX;                /* 通道名称显示位置的x坐标 */
        public short wShowNameTopLeftY;                /* 通道名称显示位置的y坐标 */
        //信号丢失报警
        public NET_DVR_VILOST struVILost;
        //移动侦测
        public NET_DVR_MOTION struMotion;
        //遮挡报警
        public NET_DVR_HIDEALARM struHideAlarm;
        //遮挡  区域大小704*576
        public int dwEnableHide;        /* 是否启动遮挡 ,0-否,1-是*/
        public short wHideAreaTopLeftX;                /* 遮挡区域的x坐标 */
        public short wHideAreaTopLeftY;                /* 遮挡区域的y坐标 */
        public short wHideAreaWidth;                /* 遮挡区域的宽 */
        public short wHideAreaHeight;                /*遮挡区域的高*/
        //OSD
        public int dwShowOsd;// 预览的图象上是否显示OSD,0-不显示,1-显示 区域大小704*576
        public short wOSDTopLeftX;                /* OSD的x坐标 */
        public short wOSDTopLeftY;                /* OSD的y坐标 */
        public byte byOSDType;                    /* OSD类型(主要是年月日格式) */
        /* 0: XXXX-XX-XX 年月日 */
        /* 1: XX-XX-XXXX 月日年 */
        /* 2: XXXX年XX月XX日 */
        /* 3: XX月XX日XXXX年 */
        /* 4: XX-XX-XXXX 日月年*/
        /* 5: XX日XX月XXXX年 */
        byte byDispWeek;                /* 是否显示星期 */
        byte byOSDAttrib;                /* OSD属性:透明，闪烁 */
        /* 0: 不显示OSD */
        /* 1: 透明,闪烁 */
        /* 2: 透明,不闪烁 */
        /* 3: 闪烁,不透明 */
        /* 4: 不透明,不闪烁 */
        public byte reservedData2;


    }

    public static class NET_DVR_MULTI_STREAM_COMPRESSIONCFG_COND extends Structure {
        public int dwSize;
        public NET_DVR_STREAM_INFO struStreamInfo = new NET_DVR_STREAM_INFO();
        public int dwStreamType;
        public byte[] byRes = new byte[32];
    }

    public static class NET_DVR_MULTI_STREAM_COMPRESSIONCFG extends Structure {
        public int dwSize;
        public int dwStreamType;
        public NET_DVR_COMPRESSION_INFO_V30 struStreamPara = new NET_DVR_COMPRESSION_INFO_V30();
        public byte[] byRes = new byte[80];
    }

    //码流压缩参数(子结构)(9000扩展)
    public static class NET_DVR_COMPRESSION_INFO_V30 extends Structure {
        public byte byStreamType;        //码流类型 0-视频流, 1-复合流
        public byte byResolution;    //分辨率0-DCIF 1-CIF, 2-QCIF, 3-4CIF, 4-2CIF 5（保留）16-VGA（640*480） 17-UXGA（1600*1200） 18-SVGA （800*600）19-HD720p（1280*720）20-XVGA  21-HD900p
        public byte byBitrateType;        //码率类型 0:定码率，1:变码率
        public byte byPicQuality;        //图象质量 0-最好 1-次好 2-较好 3-一般 4-较差 5-差
        public int dwVideoBitrate;    //视频码率 0-保留 1-16K 2-32K 3-48k 4-64K 5-80K 6-96K 7-128K 8-160k 9-192K 10-224K 11-256K 12-320K 13-384K 14-448K 15-512K 16-640K 17-768K 18-896K 19-1024K 20-1280K 21-1536K 22-1792K 23-2048最高位(31位)置成1表示是自定义码流, 0-30位表示码流值。
        public int dwVideoFrameRate;    //帧率 0-全部; 1-1/16; 2-1/8; 3-1/4; 4-1/2; 5-1; 6-2; 7-4; 8-6; 9-8; 10-10; 11-12; 12-16; 13-20; V2.0版本中新加14-15; 15-18; 16-22;
        public short wIntervalFrameI;  //I帧间隔
        public byte byIntervalBPFrame;//0-BBP帧; 1-BP帧; 2-单P帧
        public byte byENumber;        //E帧数量（保留）
        public byte byVideoEncType;//视频编码类型 0 hik264;1标准h264; 2标准mpeg4;
        public byte byAudioEncType;//音频编码类型 0 G722
        public byte[] byres = new byte[10];


    }

    //通道压缩参数(9000扩展)
    public static class NET_DVR_COMPRESSIONCFG_V30 extends Structure {
        public int dwSize;
        public NET_DVR_COMPRESSION_INFO_V30 struNormHighRecordPara;    //录像 对应8000的普通
        public NET_DVR_COMPRESSION_INFO_V30 struRes;   //保留 String[28];
        public NET_DVR_COMPRESSION_INFO_V30 struEventRecordPara;       //事件触发压缩参数
        public NET_DVR_COMPRESSION_INFO_V30 struNetPara;               //网传(子码流)


    }


    public static class NET_DVR_COMPRESSION_INFO extends Structure {//码流压缩参数(子结构)
        public byte byStreamType;        //码流类型0-视频流,1-复合流,表示压缩参数时最高位表示是否启用压缩参数
        public byte byResolution;    //分辨率0-DCIF 1-CIF, 2-QCIF, 3-4CIF, 4-2CIF, 5-2QCIF(352X144)(车载专用)
        public byte byBitrateType;        //码率类型0:变码率，1:定码率
        public byte byPicQuality;        //图象质量 0-最好 1-次好 2-较好 3-一般 4-较差 5-差
        public int dwVideoBitrate;    //视频码率 0-保留 1-16K(保留) 2-32K 3-48k 4-64K 5-80K 6-96K 7-128K 8-160k 9-192K 10-224K 11-256K 12-320K
        // 13-384K 14-448K 15-512K 16-640K 17-768K 18-896K 19-1024K 20-1280K 21-1536K 22-1792K 23-2048K
        //最高位(31位)置成1表示是自定义码流, 0-30位表示码流值(MIN-32K MAX-8192K)。
        public int dwVideoFrameRate;    //帧率 0-全部; 1-1/16; 2-1/8; 3-1/4; 4-1/2; 5-1; 6-2; 7-4; 8-6; 9-8; 10-10; 11-12; 12-16; 13-20;


    }

    public static class NET_DVR_COMPRESSIONCFG extends Structure {//通道压缩参数
        public int dwSize;
        public NET_DVR_COMPRESSION_INFO struRecordPara; //录像/事件触发录像
        public NET_DVR_COMPRESSION_INFO struNetPara;    //网传/保留


    }


    public static class NET_DVR_COMPRESSION_INFO_EX extends Structure {//码流压缩参数(子结构)(扩展) 增加I帧间隔
        public byte byStreamType;        //码流类型0-视频流, 1-复合流
        public byte byResolution;    //分辨率0-DCIF 1-CIF, 2-QCIF, 3-4CIF, 4-2CIF, 5-2QCIF(352X144)(车载专用)
        public byte byBitrateType;        //码率类型0:变码率，1:定码率
        public byte byPicQuality;        //图象质量 0-最好 1-次好 2-较好 3-一般 4-较差 5-差
        public int dwVideoBitrate;    //视频码率 0-保留 1-16K(保留) 2-32K 3-48k 4-64K 5-80K 6-96K 7-128K 8-160k 9-192K 10-224K 11-256K 12-320K
        // 13-384K 14-448K 15-512K 16-640K 17-768K 18-896K 19-1024K 20-1280K 21-1536K 22-1792K 23-2048K
        //最高位(31位)置成1表示是自定义码流, 0-30位表示码流值(MIN-32K MAX-8192K)。
        public int dwVideoFrameRate;    //帧率 0-全部; 1-1/16; 2-1/8; 3-1/4; 4-1/2; 5-1; 6-2; 7-4; 8-6; 9-8; 10-10; 11-12; 12-16; 13-20, //V2.0增加14-15, 15-18, 16-22;
        public short wIntervalFrameI;  //I帧间隔
        //2006-08-11 增加单P帧的配置接口，可以改善实时流延时问题
        public byte byIntervalBPFrame;//0-BBP帧; 1-BP帧; 2-单P帧
        public byte byENumber;//E帧数量


    }

    public static class NET_DVR_RECORDSCHED extends Structure //时间段录像参数配置(子结构)
    {
        public NET_DVR_SCHEDTIME struRecordTime = new NET_DVR_SCHEDTIME();
        public byte byRecordType;    //0:定时录像，1:移动侦测，2:报警录像，3:动测|报警，4:动测&报警, 5:命令触发, 6: 智能录像
        public byte[] reservedData = new byte[3];


    }

    public static class NET_DVR_RECORDDAY extends Structure //全天录像参数配置(子结构)
    {
        public short wAllDayRecord;                /* 是否全天录像 0-否 1-是*/
        public byte byRecordType;                /* 录象类型 0:定时录像，1:移动侦测，2:报警录像，3:动测|报警，4:动测&报警 5:命令触发, 6: 智能录像*/
        public byte reservedData;


    }

    public static class NET_DVR_RECORDSCHEDWEEK extends Structure {
        public NET_DVR_RECORDSCHED[] struRecordSched = new NET_DVR_RECORDSCHED[MAX_TIMESEGMENT_V30];


    }

    public static class NET_DVR_RECORD_V30 extends Structure {    //通道录像参数配置(9000扩展)
        public int dwSize;
        public int dwRecord;                        /*是否录像 0-否 1-是*/
        public NET_DVR_RECORDDAY[] struRecAllDay = new NET_DVR_RECORDDAY[MAX_DAYS];
        public NET_DVR_RECORDSCHEDWEEK[] struRecordSched = new NET_DVR_RECORDSCHEDWEEK[MAX_DAYS];
        public int dwRecordTime;                    /* 录象延时长度 0-5秒， 1-20秒， 2-30秒， 3-1分钟， 4-2分钟， 5-5分钟， 6-10分钟*/
        public int dwPreRecordTime;                /* 预录时间 0-不预录 1-5秒 2-10秒 3-15秒 4-20秒 5-25秒 6-30秒 7-0xffffffff(尽可能预录) */
        public int dwRecorderDuration;                /* 录像保存的最长时间 */
        public byte byRedundancyRec;    /*是否冗余录像,重要数据双备份：0/1*/
        public byte byAudioRec;        /*录像时复合流编码时是否记录音频数据：国外有此法规*/
        public byte[] byReserve = new byte[10];


    }

    public static class NET_DVR_RECORD extends Structure { //通道录像参数配置
        public int dwSize;
        public int dwRecord;  /*是否录像 0-否 1-是*/
        public NET_DVR_RECORDDAY[] struRecAllDay = new NET_DVR_RECORDDAY[MAX_DAYS];
        public NET_DVR_RECORDSCHEDWEEK[] struRecordSched = new NET_DVR_RECORDSCHEDWEEK[MAX_DAYS];
        public int dwRecordTime;    /* 录象时间长度 0-5秒， 1-20秒， 2-30秒， 3-1分钟， 4-2分钟， 5-5分钟， 6-10分钟*/
        public int dwPreRecordTime;    /* 预录时间 0-不预录 1-5秒 2-10秒 3-15秒 4-20秒 5-25秒 6-30秒 7-0xffffffff(尽可能预录) */


    }

    public static class NET_DVR_STATFRAME extends Structure { //单帧统计参数
        public int dwRelativeTime;
        public int dwAbsTime;  /*统计绝对时标*/
        public byte[] byRes = new byte[92];


    }

    public static class NET_DVR_STATTIME extends Structure { //单帧统计参数
        public NET_DVR_TIME tmStart;  //统计开始时间
        public NET_DVR_TIME tmEnd;    //统计结束时间
        public byte[] byRes = new byte[92];


    }

    public static class UNION_PDC_STATPARAM extends Union {
        // public byte[] byLen = new byte[140];
        public NET_DVR_STATFRAME struStatFrame;
        public NET_DVR_STATTIME struStatTime;


    }

    public static class NET_DVR_PDC_ALRAM_INFO extends Structure { //通道录像参数配置
        public int dwSize;
        public byte byMode;  /*0-单帧统计结果，1-最小时间段统计结果*/
        public byte byChannel;
        public byte bySmart;         //专业智能返回0，Smart 返回 1
        public byte byRes1;          // 保留字节
        public NET_VCA_DEV_INFO struDevInfo = new NET_VCA_DEV_INFO();             //前端设备信息
        public UNION_PDC_STATPARAM uStatModeParam = new UNION_PDC_STATPARAM();
        public int dwLeaveNum;    /* 离开人数 */
        public int dwEnterNum;    /* 进入人数 */
        public byte byBrokenNetHttp;     //断网续传标志位，0-不是重传数据，1-重传数据
        public byte byRes3;
        public short wDevInfoIvmsChannelEx;     //与NET_VCA_DEV_INFO里的byIvmsChannel含义相同，能表示更大的值。老客户端用byIvmsChannel能继续兼容，但是最大到255。新客户端版本请使用wDevInfoIvmsChannelEx
        public int dwPassingNum;        // 经过人数（进入区域后徘徊没有触发进入、离开的人数）
        public byte[] byRes2 = new byte[32];

        public void read() {
            super.read();
            switch (byMode) {
                case 0:
                    uStatModeParam.setType(NET_DVR_STATFRAME.class);
                    break;
                case 1:
                    uStatModeParam.setType(NET_DVR_STATTIME.class);
                    break;
                default:
                    break;
            }
            uStatModeParam.read();
        }

        public void write() {
            super.write();
            uStatModeParam.write();
        }


    }

    //云台协议表结构配置
    public static class NET_DVR_PTZ_PROTOCOL extends Structure {
        public int dwType;               /*解码器类型值，从1开始连续递增*/
        public byte[] byDescribe = new byte[DESC_LEN]; /*解码器的描述符，和8000中的一致*/


    }

    public static class NET_DVR_PTZCFG extends Structure {
        public int dwSize;
        public NET_DVR_PTZ_PROTOCOL[] struPtz = new NET_DVR_PTZ_PROTOCOL[PTZ_PROTOCOL_NUM];/*最大200中PTZ协议*/
        public int dwPtzNum;           /*有效的ptz协议数目，从0开始(即计算时加1)*/
        public byte[] byRes = new byte[8];


    }

    /***************************云台类型(end)******************************/
    public static class NET_DVR_DECODERCFG_V30 extends Structure {//通道解码器(云台)参数配置(9000扩展)
        public int dwSize;
        public int dwBaudRate;       //波特率(bps)，0－50，1－75，2－110，3－150，4－300，5－600，6－1200，7－2400，8－4800，9－9600，10－19200， 11－38400，12－57600，13－76800，14－115.2k;
        public byte byDataBit;         // 数据有几位 0－5位，1－6位，2－7位，3－8位;
        public byte byStopBit;         // 停止位 0－1位，1－2位;
        public byte byParity;          // 校验 0－无校验，1－奇校验，2－偶校验;
        public byte byFlowcontrol;     // 0－无，1－软流控,2-硬流控
        public short wDecoderType;      //解码器类型, 0－YouLi，1－LiLin-1016，2－LiLin-820，3－Pelco-p，4－DM DynaColor，5－HD600，6－JC-4116，7－Pelco-d WX，8－Pelco-d PICO
        public short wDecoderAddress;    /*解码器地址:0 - 255*/
        public byte[] bySetPreset = new byte[MAX_PRESET_V30];        /* 预置点是否设置,0-没有设置,1-设置*/
        public byte[] bySetCruise = new byte[MAX_CRUISE_V30];        /* 巡航是否设置: 0-没有设置,1-设置 */
        public byte[] bySetTrack = new byte[MAX_TRACK_V30];            /* 轨迹是否设置,0-没有设置,1-设置*/


    }

    public static class NET_DVR_DECODERCFG extends Structure {//通道解码器(云台)参数配置
        public int dwSize;
        public int dwBaudRate;       //波特率(bps)，0－50，1－75，2－110，3－150，4－300，5－600，6－1200，7－2400，8－4800，9－9600，10－19200， 11－38400，12－57600，13－76800，14－115.2k;
        public byte byDataBit;         // 数据有几位 0－5位，1－6位，2－7位，3－8位;
        public byte byStopBit;         // 停止位 0－1位，1－2位;
        public byte byParity;          // 校验 0－无校验，1－奇校验，2－偶校验;
        public byte byFlowcontrol;     // 0－无，1－软流控,2-硬流控
        public short wDecoderType;      //解码器类型, 0－YouLi，1－LiLin-1016，2－LiLin-820，3－Pelco-p，4－DM DynaColor，5－HD600，6－JC-4116，7－Pelco-d WX，8－Pelco-d PICO
        public short wDecoderAddress;    /*解码器地址:0 - 255*/
        public byte[] bySetPreset = new byte[MAX_PRESET];        /* 预置点是否设置,0-没有设置,1-设置*/
        public byte[] bySetCruise = new byte[MAX_CRUISE];        /* 巡航是否设置: 0-没有设置,1-设置 */
        public byte[] bySetTrack = new byte[MAX_TRACK];            /* 轨迹是否设置,0-没有设置,1-设置*/


    }

    public static class NET_DVR_PPPCFG_V30 extends Structure {//ppp参数配置(子结构)
        public NET_DVR_IPADDR struRemoteIP;    //远端IP地址
        public NET_DVR_IPADDR struLocalIP;        //本地IP地址
        public byte[] sLocalIPMask = new byte[16];            //本地IP地址掩码
        public byte[] sUsername = new byte[NAME_LEN];        /* 用户名 */
        public byte[] sPassword = new byte[PASSWD_LEN];        /* 密码 */
        public byte byPPPMode;                    //PPP模式, 0－主动，1－被动
        public byte byRedial;                    //是否回拨 ：0-否,1-是
        public byte byRedialMode;                //回拨模式,0-由拨入者指定,1-预置回拨号码
        public byte byDataEncrypt;                //数据加密,0-否,1-是
        public int dwMTU;                    //MTU
        public byte[] sTelephoneNumber = new byte[PHONENUMBER_LEN];   //电话号码


    }

    public static class NET_DVR_PPPCFG extends Structure {//ppp参数配置(子结构)
        public byte[] sRemoteIP = new byte[16];                //远端IP地址
        public byte[] sLocalIP = new byte[16];                //本地IP地址
        public byte[] sLocalIPMask = new byte[16];            //本地IP地址掩码
        public byte[] sUsername = new byte[NAME_LEN];        /* 用户名 */
        public byte[] sPassword = new byte[PASSWD_LEN];        /* 密码 */
        public byte byPPPMode;                    //PPP模式, 0－主动，1－被动
        public byte byRedial;                    //是否回拨 ：0-否,1-是
        public byte byRedialMode;                //回拨模式,0-由拨入者指定,1-预置回拨号码
        public byte byDataEncrypt;                //数据加密,0-否,1-是
        public int dwMTU;                    //MTU
        public byte[] sTelephoneNumber = new byte[PHONENUMBER_LEN];   //电话号码


    }


    public static class NET_DVR_SINGLE_RS232 extends Structure {//RS232串口参数配置(9000扩展)
        public int dwBaudRate;   /*波特率(bps)，0－50，1－75，2－110，3－150，4－300，5－600，6－1200，7－2400，8－4800，9－9600，10－19200， 11－38400，12－57600，13－76800，14－115.2k;*/
        public byte byDataBit;     /* 数据有几位 0－5位，1－6位，2－7位，3－8位 */
        public byte byStopBit;     /* 停止位 0－1位，1－2位 */
        public byte byParity;      /* 校验 0－无校验，1－奇校验，2－偶校验 */
        public byte byFlowcontrol; /* 0－无，1－软流控,2-硬流控 */
        public int dwWorkMode;   /* 工作模式，0－232串口用于PPP拨号，1－232串口用于参数控制，2－透明通道 */


    }

    public static class NET_DVR_RS232CFG_V30 extends Structure {//RS232串口参数配置(9000扩展)
        public int dwSize;
        public NET_DVR_SINGLE_RS232 struRs232;/*目前只有第一个串口设置有效，所有设备都只支持一个串口，其他七个保留*/
        public byte[] byRes = new byte[84];
        public NET_DVR_PPPCFG_V30 struPPPConfig;/*ppp参数*/


    }

    public static class NET_DVR_RS232CFG extends Structure {//RS232串口参数配置
        public int dwSize;
        public int dwBaudRate;//波特率(bps)，0－50，1－75，2－110，3－150，4－300，5－600，6－1200，7－2400，8－4800，9－9600，10－19200， 11－38400，12－57600，13－76800，14－115.2k;
        public byte byDataBit;// 数据有几位 0－5位，1－6位，2－7位，3－8位;
        public byte byStopBit;// 停止位 0－1位，1－2位;
        public byte byParity;// 校验 0－无校验，1－奇校验，2－偶校验;
        public byte byFlowcontrol;// 0－无，1－软流控,2-硬流控
        public int dwWorkMode;// 工作模式，0－窄带传输(232串口用于PPP拨号)，1－控制台(232串口用于参数控制)，2－透明通道
        public NET_DVR_PPPCFG struPPPConfig;


    }

    public static class NET_DVR_ALARMINCFG_V30 extends Structure {//报警输入参数配置(9000扩展)
        public int dwSize;
        public byte[] sAlarmInName = new byte[NAME_LEN];    /* 名称 */
        public byte byAlarmType;                //报警器类型,0：常开,1：常闭
        public byte byAlarmInHandle;            /* 是否处理 0-不处理 1-处理*/
        public byte[] reservedData = new byte[2];
        public NET_DVR_HANDLEEXCEPTION_V30 struAlarmHandleType;    /* 处理方式 */
        public NET_DVR_SCHEDTIMEWEEK[] struAlarmTime = new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS];//布防时间
        public byte[] byRelRecordChan = new byte[MAX_CHANNUM_V30]; //报警触发的录象通道,为1表示触发该通道
        public byte[] byEnablePreset = new byte[MAX_CHANNUM_V30];        /* 是否调用预置点 0-否,1-是*/
        public byte[] byPresetNo = new byte[MAX_CHANNUM_V30];            /* 调用的云台预置点序号,一个报警输入可以调用多个通道的云台预置点, 0xff表示不调用预置点。*/
        public byte[] byEnablePresetRevert = new byte[MAX_CHANNUM_V30]; /* 是否恢复到调用预置点前的位置(保留) */
        public short[] wPresetRevertDelay = new short[MAX_CHANNUM_V30];    /* 恢复预置点延时(保留) */
        public byte[] byEnableCruise = new byte[MAX_CHANNUM_V30];        /* 是否调用巡航 0-否,1-是*/
        public byte[] byCruiseNo = new byte[MAX_CHANNUM_V30];            /* 巡航 */
        public byte[] byEnablePtzTrack = new byte[MAX_CHANNUM_V30];        /* 是否调用轨迹 0-否,1-是*/
        public byte[] byPTZTrack = new byte[MAX_CHANNUM_V30];            /* 调用的云台的轨迹序号 */
        public byte[] byRes = new byte[16];


    }

    public static class NET_DVR_ALARMINCFG extends Structure {//报警输入参数配置
        public int dwSize;
        public byte[] sAlarmInName = new byte[NAME_LEN];    /* 名称 */
        public byte byAlarmType;    //报警器类型,0：常开,1：常闭
        public byte byAlarmInHandle;    /* 是否处理 0-不处理 1-处理*/
        public NET_DVR_HANDLEEXCEPTION struAlarmHandleType;    /* 处理方式 */
        public NET_DVR_SCHEDTIMEWEEK[] struAlarmTime = new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS];//布防时间
        public byte[] byRelRecordChan = new byte[MAX_CHANNUM]; //报警触发的录象通道,为1表示触发该通道
        public byte[] byEnablePreset = new byte[MAX_CHANNUM];        /* 是否调用预置点 0-否,1-是*/
        public byte[] byPresetNo = new byte[MAX_CHANNUM];            /* 调用的云台预置点序号,一个报警输入可以调用多个通道的云台预置点, 0xff表示不调用预置点。*/
        public byte[] byEnableCruise = new byte[MAX_CHANNUM];        /* 是否调用巡航 0-否,1-是*/
        public byte[] byCruiseNo = new byte[MAX_CHANNUM];            /* 巡航 */
        public byte[] byEnablePtzTrack = new byte[MAX_CHANNUM];        /* 是否调用轨迹 0-否,1-是*/
        public byte[] byPTZTrack = new byte[MAX_CHANNUM];            /* 调用的云台的轨迹序号 */


    }

    public static class NET_DVR_ADDIT_POSITION extends Structure {//车载GPS信息结构(2007-12-27)
        public byte[] sDevName = new byte[32];        /* 设备名称 */
        public int dwSpeed;            /*速度*/
        public int dwLongitude;        /* 经度*/
        public int dwLatitude;       /* 纬度*/
        public byte[] direction = new byte[2];   /* direction[0]:'E'or'W'(东经/西经), direction[1]:'N'or'S'(北纬/南纬) */
        public byte[] res = new byte[2];              /* 保留位 */


    }

    public static class struRecordingHost extends Structure {
        public byte bySubAlarmType;
        public byte[] byRes1 = new byte[3];
        public NET_DVR_TIME_EX struRecordEndTime = new NET_DVR_TIME_EX();
        public byte[] byRes = new byte[116];

    }

    public static class struAlarmHardDisk extends Structure {
        public int dwAlarmHardDiskNum;


    }

    public static class struAlarmChannel extends Structure {
        public int dwAlarmChanNum;


    }

    public static class struIOAlarm extends Structure {
        public int dwAlarmInputNo;
        public int dwTrigerAlarmOutNum;
        public int dwTrigerRecordChanNum;


    }

    public static class NET_DVR_TIME_EX extends Structure {
        public short wYear;
        public byte byMonth;
        public byte byDay;
        public byte byHour;
        public byte byMinute;
        public byte bySecond;
        public byte byRes;


    }

    public static class uStruAlarm extends Union {
        public byte[] byUnionLen = new byte[128];
        public struIOAlarm struioAlarm = new struIOAlarm();
        public struAlarmHardDisk strualarmHardDisk = new struAlarmHardDisk();
        public struAlarmChannel strualarmChannel = new struAlarmChannel();
        public struRecordingHost strurecordingHost = new struRecordingHost();


    }

    public static class NET_DVR_ALRAM_FIXED_HEADER extends Structure {
        public int dwAlarmType;
        public NET_DVR_TIME_EX struAlarmTime = new NET_DVR_TIME_EX();
        public uStruAlarm ustruAlarm = new uStruAlarm();


    }

    public static class NET_DVR_ALARMINFO_V40 extends Structure {
        public NET_DVR_ALRAM_FIXED_HEADER struAlarmFixedHeader = new NET_DVR_ALRAM_FIXED_HEADER();
        public Pointer pAlarmData;


    }

    public static class NET_DVR_ALARMINFO_V30 extends Structure {//上传报警信息(9000扩展)
        public int dwAlarmType;/*0-信号量报警,1-硬盘满,2-信号丢失,3－移动侦测,4－硬盘未格式化,5-读写硬盘出错,6-遮挡报警,7-制式不匹配, 8-非法访问, 0xa-GPS定位信息(车载定制)*/
        public int dwAlarmInputNumber;/*报警输入端口*/
        public byte[] byAlarmOutputNumber = new byte[MAX_ALARMOUT_V30];/*触发的输出端口，为1表示对应输出*/
        public byte[] byAlarmRelateChannel = new byte[MAX_CHANNUM_V30];/*触发的录像通道，为1表示对应录像, dwAlarmRelateChannel[0]对应第1个通道*/
        public byte[] byChannel = new byte[MAX_CHANNUM_V30];/*dwAlarmType为2或3,6时，表示哪个通道，dwChannel[0]对应第1个通道*/
        public byte[] byDiskNumber = new byte[MAX_DISKNUM_V30];/*dwAlarmType为1,4,5时,表示哪个硬盘, dwDiskNumber[0]对应第1个硬盘*/


    }

    public static class NET_DVR_ALARMINFO extends Structure {
        public int dwAlarmType;/*0-信号量报警,1-硬盘满,2-信号丢失,3－移动侦测,4－硬盘未格式化,5-读写硬盘出错,6-遮挡报警,7-制式不匹配, 8-非法访问, 9-串口状态, 0xa-GPS定位信息(车载定制)*/
        public int dwAlarmInputNumber;/*报警输入端口, 当报警类型为9时该变量表示串口状态0表示正常， -1表示错误*/
        public int[] dwAlarmOutputNumber = new int[MAX_ALARMOUT];/*触发的输出端口，为1表示对应哪一个输出*/
        public int[] dwAlarmRelateChannel = new int[MAX_CHANNUM];/*触发的录像通道，dwAlarmRelateChannel[0]为1表示第1个通道录像*/
        public int[] dwChannel = new int[MAX_CHANNUM];/*dwAlarmType为2或3,6时，表示哪个通道，dwChannel[0]位对应第1个通道*/
        public int[] dwDiskNumber = new int[MAX_DISKNUM];/*dwAlarmType为1,4,5时,表示哪个硬盘, dwDiskNumber[0]位对应第1个硬盘*/


    }

    public static class NET_DVR_ALARMINFO_EX extends Structure {//上传报警信息(杭州竞天定制 2006-07-28)
        public int dwAlarmType;/*0-信号量报警,1-硬盘满,2-信号丢失,3－移动侦测,4－硬盘未格式化,5-读写硬盘出错,6-遮挡报警,7-制式不匹配, 8-非法访问*/
        public int dwAlarmInputNumber;/*报警输入端口*/
        public int[] dwAlarmOutputNumber = new int[MAX_ALARMOUT];/*报警输入端口对应的输出端口，哪一位为1表示对应哪一个输出*/
        public int[] dwAlarmRelateChannel = new int[MAX_CHANNUM];/*报警输入端口对应的录像通道，哪一位为1表示对应哪一路录像,dwAlarmRelateChannel[0]对应第1个通道*/
        public int[] dwChannel = new int[MAX_CHANNUM];/*dwAlarmType为2或3,6时，表示哪个通道，dwChannel[0]位对应第0个通道*/
        public int[] dwDiskNumber = new int[MAX_DISKNUM];/*dwAlarmType为1,4,5时,表示哪个硬盘*/
        public byte[] sSerialNumber = new byte[SERIALNO_LEN];  //序列号
        public byte[] sRemoteAlarmIP = new byte[16];            //远程报警IP地址；


    }

    //////////////////////////////////////////////////////////////////////////////////////
//IPC接入参数配置
    public static class NET_DVR_IPDEVINFO extends Structure {/* IP设备结构 */
        public int dwEnable;                    /* 该IP设备是否启用 */
        public byte[] sUserName = new byte[NAME_LEN];        /* 用户名 */
        public byte[] sPassword = new byte[PASSWD_LEN];        /* 密码 */
        public NET_DVR_IPADDR struIP = new NET_DVR_IPADDR();            /* IP地址 */
        public short wDVRPort;                    /* 端口号 */
        public byte[] byres = new byte[34];                /* 保留 */


    }

    public static class NET_DVR_IPCHANINFO extends Structure {/* IP通道匹配参数 */
        public byte byEnable;                    /* 该通道是否启用 */
        public byte byIPID;                    /* IP设备ID 取值1- MAX_IP_DEVICE */
        public byte byChannel;                    /* 通道号 */
        public byte[] byres = new byte[33];                    /* 保留 */


    }

    public static class NET_DVR_IPPARACFG extends Structure {/* IP接入配置结构 */
        public int dwSize;                                        /* 结构大小 */
        public NET_DVR_IPDEVINFO[] struIPDevInfo = new NET_DVR_IPDEVINFO[MAX_IP_DEVICE];    /* IP设备 */
        public byte[] byAnalogChanEnable = new byte[MAX_ANALOG_CHANNUM];        /* 模拟通道是否启用，从低到高表示1-32通道，0表示无效 1有效 */
        public NET_DVR_IPCHANINFO[] struIPChanInfo = new NET_DVR_IPCHANINFO[MAX_IP_CHANNEL];    /* IP通道 */


    }

    public class NET_DVR_IPDEVINFO_V31 extends Structure {
        public byte byEnable;/* 该通道是否启用 */
        public byte byProType;//协议类型(默认为私有协议)，0- 私有协议，1- 松下协议，2- 索尼，更多协议通过NET_DVR_GetIPCProtoList获取。
        public byte byEnableQuickAdd;//0-不支持快速添加；1-使用快速添加
        public byte byRes1;//保留，置为0
        public byte[] sUserName = new byte[HCNetSDK.NAME_LEN];//用户名
        public byte[] sPassword = new byte[HCNetSDK.PASSWD_LEN];//密码
        public byte[] byDomain = new byte[HCNetSDK.MAX_DOMAIN_NAME];//设备域名
        public NET_DVR_IPADDR struIP = new NET_DVR_IPADDR();//IP地址
        public short wDVRPort;//端口号
        public byte[] szDeviceID = new byte[32];
        public byte[] byRes2 = new byte[2];//保留，置为0


    }

    public class NET_DVR_STREAM_MODE extends Structure {

        public byte byGetStreamType;//取流方式：0- 直接从设备取流；1- 从流媒体取流；2- 通过IPServer获得IP地址后取流；
        //3- 通过IPServer找到设备，再通过流媒体取设备的流； 4- 通过流媒体由URL去取流；5- 通过hiDDNS域名连接设备然后从设备取流
        public byte[] byRes = new byte[3];//保留，置为0
        public NET_DVR_GET_STREAM_UNION uGetStream = new NET_DVR_GET_STREAM_UNION();//不同取流方式联合体

        public void read() {
            super.read();
            switch (byGetStreamType) {
                case 0:
                    uGetStream.setType(NET_DVR_IPCHANINFO.class);
                    break;
                case 6:
                    uGetStream.setType(NET_DVR_IPCHANINFO_V40.class);
                    break;
                default:
                    break;
            }
        }


    }

    public class NET_DVR_IPSERVER_STREAM extends Structure {
        public byte byEnable;
        public byte[] byRes = new byte[3];
        public NET_DVR_IPADDR struIPServer = new NET_DVR_IPADDR();
        public short wPort;
        public short wDvrNameLen;
        public byte[] byDVRName = new byte[HCNetSDK.NAME_LEN];
        public short wDVRSerialLen;
        public short[] byRes1 = new short[2];
        public byte[] byDVRSerialNumber = new byte[HCNetSDK.SERIALNO_LEN];
        public byte[] byUserName = new byte[HCNetSDK.NAME_LEN];
        public byte[] byPassWord = new byte[HCNetSDK.PASSWD_LEN];
        public byte byChannel;
        public byte[] byRes2 = new byte[11];


    }

    public class NET_DVR_STREAM_MEDIA_SERVER_CFG extends Structure {

        public byte byValid;//是否启用流媒体服务器取流：0-不启用，非0-启用
        public byte[] byRes1 = new byte[3];//保留，置为0
        public NET_DVR_IPADDR struDevIP = new NET_DVR_IPADDR();//流媒体服务器的IP地址
        public short wDevPort;//流媒体服务器端口
        public byte byTransmitType;//传输协议类型：0-TCP，1-UDP
        public byte[] byRes2 = new byte[69];


    }

    public class NET_DVR_DEV_CHAN_INFO extends Structure {
        public NET_DVR_IPADDR struIP = new NET_DVR_IPADDR();//设备IP地址
        public short wDVRPort;//设备端口号
        public byte byChannel;//通道号,目前设备的模拟通道号是从1开始的，对于9000等设备的IPC接入，数字通道号从33开始
        public byte byTransProtocol;//传输协议类型：0-TCP，1-UDP，2-多播方式，3-RTP
        public byte byTransMode;//传输码流模式：0－主码流，1－子码流
        public byte byFactoryType;//前端设备厂家类型， 通过接口NET_DVR_GetIPCProtoList获取
        public byte byDeviceType;//设备类型(视频综合平台使用)：1- IPC，2- ENCODER
        public byte byDispChan;//	显示通道号（智能配置使用），根据能力集决定使用解码通道还是显示通道
        public byte bySubDispChan;//显示通道子通道号（智能配置时使用）
        public byte byResolution;//分辨率：1- CIF，2- 4CIF，3- 720P，4- 1080P，5- 500W，用于多屏控制器，多屏控制器会根据该参数分配解码资源
        public byte[] byRes = new byte[2];//保留，置为0
        public byte[] byDomain = new byte[HCNetSDK.MAX_DOMAIN_NAME];//设备域名
        public byte[] sUserName = new byte[HCNetSDK.NAME_LEN];//设备登陆帐号
        public byte[] sPassword = new byte[HCNetSDK.PASSWD_LEN];//设备密码
    }

    public class NET_DVR_PU_STREAM_CFG extends Structure {
        public int dwSize;//结构体大小
        public NET_DVR_STREAM_MEDIA_SERVER_CFG struStreamMediaSvrCfg = new NET_DVR_STREAM_MEDIA_SERVER_CFG();
        public NET_DVR_DEV_CHAN_INFO struDevChanInfo = new NET_DVR_DEV_CHAN_INFO();
    }

    public class NET_DVR_PU_STREAM_CFG_V41 extends Structure {
        public int dwSize;
        public byte byStreamMode;/*取流模式，0-无效，1-通过IP或域名取流，2-通过URL取流,3-通过动态域名解析向设备取流*/
        public byte byStreamEncrypt;  //是否进行码流加密处理,0-不支持,1-支持
        public byte[] byRes1 = new byte[2];
        public NET_DVR_DEC_STREAM_MODE uDecStreamMode;//取流信息
        public int dwDecDelayTime;//解码延时时间，单位：毫秒
        public byte[] sStreamPassword = new byte[STREAM_PASSWD_LEN];  //码流加密密码,需敏感信息加密
        public byte[] byRes2 = new byte[48];
    }


    public class NET_DVR_DDNS_STREAM_CFG extends Structure {
        public byte byEnable;
        public byte[] byRes1 = new byte[3];
        public NET_DVR_IPADDR struStreamServer = new NET_DVR_IPADDR();
        public short wStreamServerPort;
        public byte byStreamServerTransmitType;
        public byte byRes2;
        public NET_DVR_IPADDR struIPServer = new NET_DVR_IPADDR();
        public short wIPServerPort;
        public byte[] byRes3 = new byte[2];
        public byte[] sDVRName = new byte[HCNetSDK.NAME_LEN];
        public short wDVRNameLen;
        public short wDVRSerialLen;
        public byte[] sDVRSerialNumber = new byte[HCNetSDK.SERIALNO_LEN];
        public byte[] sUserName = new byte[HCNetSDK.NAME_LEN];
        public byte[] sPassWord = new byte[HCNetSDK.PASSWD_LEN];
        public short wDVRPort;
        public byte[] byRes4 = new byte[2];
        public byte byChannel;
        public byte byTransProtocol;
        public byte byTransMode;
        public byte byFactoryType;


    }

    public class NET_DVR_PU_STREAM_URL extends Structure {
        public byte byEnable;//是否启用：0- 禁用，1- 启用
        public byte[] strURL = new byte[240];//取流URL路径
        public byte byTransPortocol;//传输协议类型：0-TCP，1-UDP
        public short wIPID;//设备ID号，wIPID = iDevInfoIndex + iGroupNO*64 +1
        public byte byChannel;//设备通道号
        public byte[] byRes = new byte[7];//保留，置为0


    }

    public class NET_DVR_HKDDNS_STREAM extends Structure {
        public byte byEnable;//是否启用
        public byte[] byRes = new byte[3];//保留
        public byte[] byDDNSDomain = new byte[64];//hiDDNS服务器地址
        public short wPort;//hiDDNS端口，默认：80
        public short wAliasLen;//别名长度
        public byte[] byAlias = new byte[HCNetSDK.NAME_LEN];//别名
        public short wDVRSerialLen;//序列号长度
        public byte[] byRes1 = new byte[2];//保留
        public byte[] byDVRSerialNumber = new byte[HCNetSDK.SERIALNO_LEN];//设备序列号
        public byte[] byUserName = new byte[HCNetSDK.NAME_LEN];//设备登录用户名
        public byte[] byPassWord = new byte[HCNetSDK.PASSWD_LEN];//设备登录密码
        public byte byChannel;//设备通道号
        public byte[] byRes2 = new byte[11];//保留


    }

    public class NET_DVR_IPCHANINFO_V40 extends Structure {

        public byte byEnable;//IP通道在线状态，是一个只读的属性；
        //0表示HDVR或者NVR设备的数字通道连接对应的IP设备失败，该通道不在线；1表示连接成功，该通道在线
        public byte byRes1;//保留，置为0
        public short wIPID;//IP设备ID
        public int dwChannel;//IP设备的通道号，例如设备A（HDVR或者NVR设备）的IP通道01，对应的是设备B（DVS）里的通道04，则byChannel=4，如果前端接的是IPC则byChannel=1。
        public byte byTransProtocol;//传输协议类型：0- TCP，1- UDP，2- 多播，0xff- auto(自动)
        public byte byTransMode;//传输码流模式：0- 主码流，1- 子码流
        public byte byFactoryType;//前端设备厂家类型
        public byte[] byRes = new byte[241];//保留，置为0


    }


    public static class NET_DVR_GET_STREAM_UNION extends Union {
        public NET_DVR_IPCHANINFO struChanInfo = new NET_DVR_IPCHANINFO(); /*IP通道信息*/
        public NET_DVR_IPCHANINFO_V40 struIPChan = new NET_DVR_IPCHANINFO_V40(); //直接从设备取流（扩展）
        public byte[] byUnionLen = new byte[492]; //直接从设备取流（扩展）


    }

    public static class NET_DVR_IPPARACFG_V40 extends Structure {/* IP接入配置结构V40 */
        public int dwSize;   /* 结构大小 */
        public int dwGroupNum;//设备支持的总组数（只读）。
        public int dwAChanNum;//最大模拟通道个数（只读）
        public int dwDChanNum;//数字通道个数（只读）
        public int dwStartDChan;//起始数字通道（只读）
        public byte[] byAnalogChanEnable = new byte[MAX_CHANNUM_V30]; //模拟通道资源是否启用，从低到高表示1-64通道：0-禁用，1-启用。
        public NET_DVR_IPDEVINFO_V31[] struIPDevInfo = new NET_DVR_IPDEVINFO_V31[MAX_IP_DEVICE_V40];//IP设备信息，下标0对应设备IP ID为1
        public NET_DVR_STREAM_MODE[] struStreamMode = new NET_DVR_STREAM_MODE[MAX_CHANNUM_V30];//取流模式
        public byte[] byRes2 = new byte[20];//保留，置为0


    }

    public static class NET_DVR_IPALARMOUTINFO extends Structure {/* 报警输出参数 */
        public byte byIPID;                    /* IP设备ID取值1- MAX_IP_DEVICE */
        public byte byAlarmOut;                /* 报警输出号 */
        public byte[] byRes = new byte[18];                    /* 保留 */


    }

    public static class NET_DVR_IPALARMOUTCFG extends Structure {/* IP报警输出配置结构 */
        public int dwSize;                                    /* 结构大小 */
        public NET_DVR_IPALARMOUTINFO[] struIPAlarmOutInfo = new NET_DVR_IPALARMOUTINFO[MAX_IP_ALARMOUT];/* IP报警输出 */


    }

    public static class NET_DVR_IPALARMININFO extends Structure {/* 报警输入参数 */
        public byte byIPID;                    /* IP设备ID取值1- MAX_IP_DEVICE */
        public byte byAlarmIn;                    /* 报警输入号 */
        public byte[] byRes = new byte[18];                    /* 保留 */


    }

    public static class NET_DVR_IPALARMINCFG extends Structure {/* IP报警输入配置结构 */
        public int dwSize;                                    /* 结构大小 */
        public NET_DVR_IPALARMININFO[] struIPAlarmInInfo = new NET_DVR_IPALARMININFO[MAX_IP_ALARMIN];/* IP报警输入 */


    }

    public static class NET_DVR_IPALARMINFO extends Structure {//ipc alarm info
        public NET_DVR_IPDEVINFO[] struIPDevInfo = new NET_DVR_IPDEVINFO[MAX_IP_DEVICE];            /* IP设备 */
        public byte[] byAnalogChanEnable = new byte[MAX_ANALOG_CHANNUM];                /* 模拟通道是否启用，0-未启用 1-启用 */
        public NET_DVR_IPCHANINFO[] struIPChanInfo = new NET_DVR_IPCHANINFO[MAX_IP_CHANNEL];            /* IP通道 */
        public NET_DVR_IPALARMININFO[] struIPAlarmInInfo = new NET_DVR_IPALARMININFO[MAX_IP_ALARMIN];    /* IP报警输入 */
        public NET_DVR_IPALARMOUTINFO[] struIPAlarmOutInfo = new NET_DVR_IPALARMOUTINFO[MAX_IP_ALARMOUT]; /* IP报警输出 */


    }

    public static class NET_DVR_SINGLE_HD extends Structure {//本地硬盘信息配置
        public int dwHDNo;         /*硬盘号, 取值0~MAX_DISKNUM_V30-1*/
        public int dwCapacity;     /*硬盘容量(不可设置)*/
        public int dwFreeSpace;    /*硬盘剩余空间(不可设置)*/
        public int dwHdStatus;     /*硬盘状态(不可设置) 0-正常, 1-未格式化, 2-错误, 3-SMART状态, 4-不匹配, 5-休眠*/
        public byte byHDAttr;       /*0-默认, 1-冗余; 2-只读*/
        public byte[] byRes1 = new byte[3];
        public int dwHdGroup;      /*属于哪个盘组 1-MAX_HD_GROUP*/
        public byte[] byRes2 = new byte[120];
    }

    public static class NET_DVR_HDCFG extends Structure {
        public int dwSize;
        public int dwHDCount;          /*硬盘数(不可设置)*/
        public NET_DVR_SINGLE_HD[] struHDInfo = new NET_DVR_SINGLE_HD[MAX_DISKNUM_V30];//硬盘相关操作都需要重启才能生效；
    }

    public static class NET_DVR_SINGLE_HDGROUP extends Structure {//本地盘组信息配置
        public int dwHDGroupNo;       /*盘组号(不可设置) 1-MAX_HD_GROUP*/
        public byte[] byHDGroupChans = new byte[64]; /*盘组对应的录像通道, 0-表示该通道不录象到该盘组，1-表示录象到该盘组*/
        public byte[] byRes = new byte[8];
    }

    public static class NET_DVR_HDGROUP_CFG extends Structure {
        public int dwSize;
        public int dwHDGroupCount;        /*盘组总数(不可设置)*/
        public NET_DVR_SINGLE_HDGROUP[] struHDGroupAttr = new NET_DVR_SINGLE_HDGROUP[MAX_HD_GROUP];//硬盘相关操作都需要重启才能生效；
    }

    public static class NET_DVR_SCALECFG extends Structure {//配置缩放参数的结构
        public int dwSize;
        public int dwMajorScale;    /* 主显示 0-不缩放，1-缩放*/
        public int dwMinorScale;    /* 辅显示 0-不缩放，1-缩放*/
        public int[] dwRes = new int[2];
    }

    public static class NET_DVR_ALARMOUTCFG_V30 extends Structure {//DVR报警输出(9000扩展)
        public int dwSize;
        public byte[] sAlarmOutName = new byte[NAME_LEN];    /* 名称 */
        public int dwAlarmOutDelay;    /* 输出保持时间(-1为无限，手动关闭) */
        //0-5秒,1-10秒,2-30秒,3-1分钟,4-2分钟,5-5分钟,6-10分钟,7-手动
        public NET_DVR_SCHEDTIMEWEEK[] struAlarmOutTime = new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS];/* 报警输出激活时间段 */
        public byte[] byRes = new byte[16];
    }

    public static class NET_DVR_ALARMOUTCFG extends Structure {//DVR报警输出
        public int dwSize;
        public byte[] sAlarmOutName = new byte[NAME_LEN];    /* 名称 */
        public int dwAlarmOutDelay;    /* 输出保持时间(-1为无限，手动关闭) */
        //0-5秒,1-10秒,2-30秒,3-1分钟,4-2分钟,5-5分钟,6-10分钟,7-手动
        public NET_DVR_SCHEDTIMEWEEK[] struAlarmOutTime = new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS];/* 报警输出激活时间段 */
    }

    public static class NET_DVR_PREVIEWCFG_V30 extends Structure {//DVR本地预览参数(9000扩展)
        public int dwSize;
        public byte byPreviewNumber;//预览数目,0-1画面,1-4画面,2-9画面,3-16画面, 4-6画面, 5-8画面, 0xff:最大画面
        public byte byEnableAudio;//是否声音预览,0-不预览,1-预览
        public short wSwitchTime;//切换时间,0-不切换,1-5s,2-10s,3-20s,4-30s,5-60s,6-120s,7-300s
        public byte[][] bySwitchSeq = new byte[MAX_PREVIEW_MODE][MAX_WINDOW_V30];//切换顺序,如果lSwitchSeq[i]为 0xff表示不用
        public byte[] byRes = new byte[24];
    }

    public static class NET_DVR_PREVIEWCFG extends Structure {//DVR本地预览参数
        public int dwSize;
        public byte byPreviewNumber;//预览数目,0-1画面,1-4画面,2-9画面,3-16画面,0xff:最大画面
        public byte byEnableAudio;//是否声音预览,0-不预览,1-预览
        public short wSwitchTime;//切换时间,0-不切换,1-5s,2-10s,3-20s,4-30s,5-60s,6-120s,7-300s
        public byte[] bySwitchSeq = new byte[MAX_WINDOW];//切换顺序,如果lSwitchSeq[i]为 0xff表示不用
    }

    public static class NET_DVR_VGAPARA extends Structure {//DVR视频输出
        public short wResolution;                            /* 分辨率 */
        public short wFreq;                                    /* 刷新频率 */
        public int dwBrightness;                            /* 亮度 */
    }

    /*
     * MATRIX输出参数结构
     */
    public static class NET_DVR_MATRIXPARA_V30 extends Structure {
        public short[] wOrder = new short[MAX_ANALOG_CHANNUM];        /* 预览顺序, 0xff表示相应的窗口不预览 */
        public short wSwitchTime;                    /* 预览切换时间 */
        public byte[] res = new byte[14];
    }

    public static class NET_DVR_MATRIXPARA extends Structure {
        public short wDisplayLogo;                        /* 显示视频通道号(保留) */
        public short wDisplayOsd;                        /* 显示时间(保留) */
    }

    public static class NET_DVR_VOOUT extends Structure {
        public byte byVideoFormat;                        /* 输出制式,0-PAL,1-NTSC */
        public byte byMenuAlphaValue;                    /* 菜单与背景图象对比度 */
        public short wScreenSaveTime;                    /* 屏幕保护时间 0-从不,1-1分钟,2-2分钟,3-5分钟,4-10分钟,5-20分钟,6-30分钟 */
        public short wVOffset;                            /* 视频输出偏移 */
        public short wBrightness;                        /* 视频输出亮度 */
        public byte byStartMode;                        /* 启动后视频输出模式(0:菜单,1:预览)*/
        public byte byEnableScaler;                    /* 是否启动缩放 (0-不启动, 1-启动)*/
    }

    public static class NET_DVR_VIDEOOUT_V30 extends Structure {//DVR视频输出(9000扩展)
        public int dwSize;
        public NET_DVR_VOOUT[] struVOOut = new NET_DVR_VOOUT[MAX_VIDEOOUT_V30];
        public NET_DVR_VGAPARA[] struVGAPara = new NET_DVR_VGAPARA[MAX_VGA_V30];    /* VGA参数 */
        public NET_DVR_MATRIXPARA_V30[] struMatrixPara = new NET_DVR_MATRIXPARA_V30[MAX_MATRIXOUT];        /* MATRIX参数 */
        public byte[] byRes = new byte[16];
    }

    public static class NET_DVR_VIDEOOUT extends Structure {//DVR视频输出
        public int dwSize;
        public NET_DVR_VOOUT[] struVOOut = new NET_DVR_VOOUT[MAX_VIDEOOUT];
        public NET_DVR_VGAPARA[] struVGAPara = new NET_DVR_VGAPARA[MAX_VGA];    /* VGA参数 */
        public NET_DVR_MATRIXPARA struMatrixPara;        /* MATRIX参数 */
    }

    public static class NET_DVR_USER_INFO_V30 extends Structure {//单用户参数(子结构)(9000扩展)
        public byte[] sUserName = new byte[NAME_LEN];        /* 用户名 */
        public byte[] sPassword = new byte[PASSWD_LEN];        /* 密码 */
        public byte[] byLocalRight = new byte[MAX_RIGHT];    /* 本地权限 */
        /*数组0: 本地控制云台*/
        /*数组1: 本地手动录象*/
        /*数组2: 本地回放*/
        /*数组3: 本地设置参数*/
        /*数组4: 本地查看状态、日志*/
        /*数组5: 本地高级操作(升级，格式化，重启，关机)*/
        /*数组6: 本地查看参数 */
        /*数组7: 本地管理模拟和IP camera */
        /*数组8: 本地备份 */
        /*数组9: 本地关机/重启 */
        public byte[] byRemoteRight = new byte[MAX_RIGHT];/* 远程权限 */
        /*数组0: 远程控制云台*/
        /*数组1: 远程手动录象*/
        /*数组2: 远程回放 */
        /*数组3: 远程设置参数*/
        /*数组4: 远程查看状态、日志*/
        /*数组5: 远程高级操作(升级，格式化，重启，关机)*/
        /*数组6: 远程发起语音对讲*/
        /*数组7: 远程预览*/
        /*数组8: 远程请求报警上传、报警输出*/
        /*数组9: 远程控制，本地输出*/
        /*数组10: 远程控制串口*/
        /*数组11: 远程查看参数 */
        /*数组12: 远程管理模拟和IP camera */
        /*数组13: 远程关机/重启 */
        public byte[] byNetPreviewRight = new byte[MAX_CHANNUM_V30];        /* 远程可以预览的通道 0-有权限，1-无权限*/
        public byte[] byLocalPlaybackRight = new byte[MAX_CHANNUM_V30];        /* 本地可以回放的通道 0-有权限，1-无权限*/
        public byte[] byNetPlaybackRight = new byte[MAX_CHANNUM_V30];        /* 远程可以回放的通道 0-有权限，1-无权限*/
        public byte[] byLocalRecordRight = new byte[MAX_CHANNUM_V30];        /* 本地可以录像的通道 0-有权限，1-无权限*/
        public byte[] byNetRecordRight = new byte[MAX_CHANNUM_V30];            /* 远程可以录像的通道 0-有权限，1-无权限*/
        public byte[] byLocalPTZRight = new byte[MAX_CHANNUM_V30];            /* 本地可以PTZ的通道 0-有权限，1-无权限*/
        public byte[] byNetPTZRight = new byte[MAX_CHANNUM_V30];            /* 远程可以PTZ的通道 0-有权限，1-无权限*/
        public byte[] byLocalBackupRight = new byte[MAX_CHANNUM_V30];        /* 本地备份权限通道 0-有权限，1-无权限*/
        public NET_DVR_IPADDR struUserIP;        /* 用户IP地址(为0时表示允许任何地址) */
        public byte[] byMACAddr = new byte[MACADDR_LEN];    /* 物理地址 */
        public byte byPriority;                /* 优先级，0xff-无，0--低，1--中，2--高 */
        /*
                                    无……表示不支持优先级的设置
                                    低……默认权限:包括本地和远程回放,本地和远程查看日志和状态,本地和远程关机/重启
                                    中……包括本地和远程控制云台,本地和远程手动录像,本地和远程回放,语音对讲和远程预览
                                          本地备份,本地/远程关机/重启
                                    高……管理员
                                    */
        public byte[] byRes = new byte[17];
    }

    public static class NET_DVR_USER_INFO_EX extends Structure {//单用户参数(SDK_V15扩展)(子结构)
        public byte[] sUserName = new byte[NAME_LEN];        /* 用户名 */
        public byte[] sPassword = new byte[PASSWD_LEN];        /* 密码 */
        public int[] dwLocalRight = new int[MAX_RIGHT];    /* 权限 */
        /*数组0: 本地控制云台*/
        /*数组1: 本地手动录象*/
        /*数组2: 本地回放*/
        /*数组3: 本地设置参数*/
        /*数组4: 本地查看状态、日志*/
        /*数组5: 本地高级操作(升级，格式化，重启，关机)*/
        public int dwLocalPlaybackRight;        /* 本地可以回放的通道 bit0 -- channel 1*/
        public int[] dwRemoteRight = new int[MAX_RIGHT];    /* 权限 */
        /*数组0: 远程控制云台*/
        /*数组1: 远程手动录象*/
        /*数组2: 远程回放 */
        /*数组3: 远程设置参数*/
        /*数组4: 远程查看状态、日志*/
        /*数组5: 远程高级操作(升级，格式化，重启，关机)*/
        /*数组6: 远程发起语音对讲*/
        /*数组7: 远程预览*/
        /*数组8: 远程请求报警上传、报警输出*/
        /*数组9: 远程控制，本地输出*/
        /*数组10: 远程控制串口*/
        public int dwNetPreviewRight;        /* 远程可以预览的通道 bit0 -- channel 1*/
        public int dwNetPlaybackRight;        /* 远程可以回放的通道 bit0 -- channel 1*/
        public byte[] sUserIP = new byte[16];                /* 用户IP地址(为0时表示允许任何地址) */
        public byte[] byMACAddr = new byte[MACADDR_LEN];    /* 物理地址 */
    }

    public static class NET_DVR_USER_INFO extends Structure {//单用户参数(子结构)
        public byte[] sUserName = new byte[NAME_LEN];        /* 用户名 */
        public byte[] sPassword = new byte[PASSWD_LEN];        /* 密码 */
        public int[] dwLocalRight = new int[MAX_RIGHT];    /* 权限 */
        /*数组0: 本地控制云台*/
        /*数组1: 本地手动录象*/
        /*数组2: 本地回放*/
        /*数组3: 本地设置参数*/
        /*数组4: 本地查看状态、日志*/
        /*数组5: 本地高级操作(升级，格式化，重启，关机)*/
        public int[] dwRemoteRight = new int[MAX_RIGHT];    /* 权限 */
        /*数组0: 远程控制云台*/
        /*数组1: 远程手动录象*/
        /*数组2: 远程回放 */
        /*数组3: 远程设置参数*/
        /*数组4: 远程查看状态、日志*/
        /*数组5: 远程高级操作(升级，格式化，重启，关机)*/
        /*数组6: 远程发起语音对讲*/
        /*数组7: 远程预览*/
        /*数组8: 远程请求报警上传、报警输出*/
        /*数组9: 远程控制，本地输出*/
        /*数组10: 远程控制串口*/
        public byte[] sUserIP = new byte[16];                /* 用户IP地址(为0时表示允许任何地址) */
        public byte[] byMACAddr = new byte[MACADDR_LEN];    /* 物理地址 */
    }

    public static class NET_DVR_USER_V30 extends Structure {//DVR用户参数(9000扩展)
        public int dwSize;
        public NET_DVR_USER_INFO_V30[] struUser = new NET_DVR_USER_INFO_V30[MAX_USERNUM_V30];
    }

    public static class NET_DVR_USER_EX extends Structure {//DVR用户参数(SDK_V15扩展)
        public int dwSize;
        public NET_DVR_USER_INFO_EX[] struUser = new NET_DVR_USER_INFO_EX[MAX_USERNUM];
    }

    public static class NET_DVR_USER extends Structure {//DVR用户参数
        public int dwSize;
        public NET_DVR_USER_INFO[] struUser = new NET_DVR_USER_INFO[MAX_USERNUM];
    }

    public static class NET_DVR_EXCEPTION_V30 extends Structure {//DVR异常参数(9000扩展)
        public int dwSize;
        public NET_DVR_HANDLEEXCEPTION_V30[] struExceptionHandleType = new NET_DVR_HANDLEEXCEPTION_V30[MAX_EXCEPTIONNUM_V30];
        /*数组0-盘满,1- 硬盘出错,2-网线断,3-局域网内IP 地址冲突,4-非法访问, 5-输入/输出视频制式不匹配, 6-行车超速(车载专用), 7-视频信号异常(9000)*/
    }

    public static class NET_DVR_EXCEPTION extends Structure {//DVR异常参数
        public int dwSize;
        public NET_DVR_HANDLEEXCEPTION[] struExceptionHandleType = new NET_DVR_HANDLEEXCEPTION[MAX_EXCEPTIONNUM];
        /*数组0-盘满,1- 硬盘出错,2-网线断,3-局域网内IP 地址冲突,4-非法访问, 5-输入/输出视频制式不匹配, 6-行车超速(车载专用)*/
    }

    public static class NET_DVR_CHANNELSTATE_V30 extends Structure {//通道状态(9000扩展)
        public byte byRecordStatic; //通道是否在录像,0-不录像,1-录像
        public byte bySignalStatic; //连接的信号状态,0-正常,1-信号丢失
        public byte byHardwareStatic;//通道硬件状态,0-正常,1-异常,例如DSP死掉
        public byte byRes1;        //保留
        public int dwBitRate;//实际码率
        public int dwLinkNum;//客户端连接的个数
        public NET_DVR_IPADDR[] struClientIP = new NET_DVR_IPADDR[MAX_LINK];//客户端的IP地址
        public int dwIPLinkNum;//如果该通道为IP接入，那么表示IP接入当前的连接数
        public byte byExceedMaxLink;        // 是否超出了单路6路连接数 0 - 未超出, 1-超出
        public byte[] byRes = new byte[3];        // 保留字节
        public int dwAllBitRate;      //所有实际码率之和
        public int dwChannelNo;    //当前的通道号，0xffffffff表示无效
    }

    public static class NET_DVR_CHANNELSTATE extends Structure {//通道状态
        public byte byRecordStatic; //通道是否在录像,0-不录像,1-录像
        public byte bySignalStatic; //连接的信号状态,0-正常,1-信号丢失
        public byte byHardwareStatic;//通道硬件状态,0-正常,1-异常,例如DSP死掉
        public byte reservedData;        //保留
        public int dwBitRate;//实际码率
        public int dwLinkNum;//客户端连接的个数
        public int[] dwClientIP = new int[MAX_LINK];//客户端的IP地址
    }

    public static class NET_DVR_DISKSTATE extends Structure {//硬盘状态
        public int dwVolume;//硬盘的容量
        public int dwFreeSpace;//硬盘的剩余空间
        public int dwHardDiskStatic; //硬盘的状态,按位:1-休眠,2-不正常,3-休眠硬盘出错
    }

    public static class NET_DVR_WORKSTATE_V30 extends Structure {//DVR工作状态(9000扩展)
        public int dwDeviceStatic;    //设备的状态,0-正常,1-CPU占用率太高,超过85%,2-硬件错误,例如串口死掉
        public NET_DVR_DISKSTATE[] struHardDiskStatic = new NET_DVR_DISKSTATE[MAX_DISKNUM_V30];
        public NET_DVR_CHANNELSTATE_V30[] struChanStatic = new NET_DVR_CHANNELSTATE_V30[MAX_CHANNUM_V30];//通道的状态
        public byte[] byAlarmInStatic = new byte[MAX_ALARMIN_V30]; //报警端口的状态,0-没有报警,1-有报警
        public byte[] byAlarmOutStatic = new byte[MAX_ALARMOUT_V30]; //报警输出端口的状态,0-没有输出,1-有报警输出
        public int dwLocalDisplay;//本地显示状态,0-正常,1-不正常
        public byte[] byAudioChanStatus = new byte[MAX_AUDIO_V30];//表示语音通道的状态 0-未使用，1-使用中, 0xff无效
        public byte[] byRes = new byte[10];
    }

    public static class NET_DVR_WORKSTATE extends Structure {//DVR工作状态
        public int dwDeviceStatic;    //设备的状态,0-正常,1-CPU占用率太高,超过85%,2-硬件错误,例如串口死掉
        public NET_DVR_DISKSTATE[] struHardDiskStatic = new NET_DVR_DISKSTATE[MAX_DISKNUM];
        public NET_DVR_CHANNELSTATE[] struChanStatic = new NET_DVR_CHANNELSTATE[MAX_CHANNUM];//通道的状态
        public byte[] byAlarmInStatic = new byte[MAX_ALARMIN]; //报警端口的状态,0-没有报警,1-有报警
        public byte[] byAlarmOutStatic = new byte[MAX_ALARMOUT]; //报警输出端口的状态,0-没有输出,1-有报警输出
        public int dwLocalDisplay;//本地显示状态,0-正常,1-不正常
    }

    public static class NET_DVR_LOG_V30 extends Structure {//日志信息(9000扩展)
        public NET_DVR_TIME strLogTime;
        public int dwMajorType;    //主类型 1-报警; 2-异常; 3-操作; 0xff-全部
        public int dwMinorType;//次类型 0-全部;
        public byte[] sPanelUser = new byte[MAX_NAMELEN]; //操作面板的用户名
        public byte[] sNetUser = new byte[MAX_NAMELEN];//网络操作的用户名
        public NET_DVR_IPADDR struRemoteHostAddr;//??程主机地址
        public int dwParaType;//参数类型
        public int dwChannel;//通道号
        public int dwDiskNumber;//硬盘号
        public int dwAlarmInPort;//报警输入端口
        public int dwAlarmOutPort;//报警输出端口
        public int dwInfoLen;
        public byte[] sInfo = new byte[LOG_INFO_LEN];
    }

    //日志信息
    public static class NET_DVR_LOG extends Structure {
        public NET_DVR_TIME strLogTime;
        public int dwMajorType;    //主类型 1-报警; 2-异常; 3-操作; 0xff-全部
        public int dwMinorType;//次类型 0-全部;
        public byte[] sPanelUser = new byte[MAX_NAMELEN]; //操作面板的用户名
        public byte[] sNetUser = new byte[MAX_NAMELEN];//网络操作的用户名
        public byte[] sRemoteHostAddr = new byte[16];//远程主机地址
        public int dwParaType;//参数类型
        public int dwChannel;//通道号
        public int dwDiskNumber;//硬盘号
        public int dwAlarmInPort;//报警输入端口
        public int dwAlarmOutPort;//报警输出端口
    }

    /************************DVR日志 end***************************/
    public static class NET_DVR_ALARMOUTSTATUS_V30 extends Structure {//报警输出状态(9000扩展)
        public byte[] Output = new byte[MAX_ALARMOUT_V30];
    }

    public static class NET_DVR_ALARMOUTSTATUS extends Structure {//报警输出状态
        public byte[] Output = new byte[MAX_ALARMOUT];
    }

    public static class NET_DVR_TRADEINFO extends Structure {//交易信息
        public short m_Year;
        public short m_Month;
        public short m_Day;
        public short m_Hour;
        public short m_Minute;
        public short m_Second;
        public byte[] DeviceName = new byte[24];    //设备名称
        public int dwChannelNumer;    //通道号
        public byte[] CardNumber = new byte[32];    //卡号
        public byte[] cTradeType = new byte[12];    //交易类型
        public int dwCash;            //交易金额
    }

    public static class NET_DVR_FRAMETYPECODE extends Structure {/*帧格式*/
        public byte[] code = new byte[12];        /* 代码 */
    }

    public static class NET_DVR_FRAMEFORMAT_V30 extends Structure {//ATM参数(9000扩展)
        public int dwSize;
        public NET_DVR_IPADDR struATMIP;                /* ATM IP地址 */
        public int dwATMType;                            /* ATM类型 */
        public int dwInputMode;                        /* 输入方式	0-网络侦听 1-网络接收 2-串口直接输入 3-串口ATM命令输入*/
        public int dwFrameSignBeginPos;                /* 报文标志位的起始位置*/
        public int dwFrameSignLength;                    /* 报文标志位的长度 */
        public byte[] byFrameSignContent = new byte[12];                /* 报文标志位的内容 */
        public int dwCardLengthInfoBeginPos;            /* 卡号长度信息的起始位置 */
        public int dwCardLengthInfoLength;                /* 卡号长度信息的长度 */
        public int dwCardNumberInfoBeginPos;            /* 卡号信息的起始位置 */
        public int dwCardNumberInfoLength;                /* 卡号信息的长度 */
        public int dwBusinessTypeBeginPos;                /* 交易类型的起始位置 */
        public int dwBusinessTypeLength;                /* 交易类型的长度 */
        public NET_DVR_FRAMETYPECODE[] frameTypeCode = new NET_DVR_FRAMETYPECODE[10];    /* 类型 */
        public short wATMPort;                            /* 卡号捕捉端口号(网络协议方式) (保留)0xffff表示该值无效*/
        public short wProtocolType;                        /* 网络协议类型(保留) 0xffff表示该值无效*/
        public byte[] byRes = new byte[24];
    }

    public static class NET_DVR_FRAMEFORMAT extends Structure {//ATM参数
        public int dwSize;
        public byte[] sATMIP = new byte[16];                        /* ATM IP地址 */
        public int dwATMType;                        /* ATM类型 */
        public int dwInputMode;                        /* 输入方式	0-网络侦听 1-网络接收 2-串口直接输入 3-串口ATM命令输入*/
        public int dwFrameSignBeginPos;              /* 报文标志位的起始位置*/
        public int dwFrameSignLength;                /* 报文标志位的长度 */
        public byte[] byFrameSignContent = new byte[12];            /* 报文标志位的内容 */
        public int dwCardLengthInfoBeginPos;            /* 卡号长度信息的起始位置 */
        public int dwCardLengthInfoLength;            /* 卡号长度信息的长度 */
        public int dwCardNumberInfoBeginPos;            /* 卡号信息的起始位置 */
        public int dwCardNumberInfoLength;            /* 卡号信息的长度 */
        public int dwBusinessTypeBeginPos;           /* 交易类型的起始位置 */
        public int dwBusinessTypeLength;                /* 交易类型的长度 */
        public NET_DVR_FRAMETYPECODE[] frameTypeCode = new NET_DVR_FRAMETYPECODE[10];/* 类型 */
    }

    public static class NET_DVR_FTPTYPECODE extends Structure {
        public byte[] sFtpType = new byte[32];     /*客户定义的操作类型*/
        public byte[] sFtpCode = new byte[8];      /*客户定义的操作类型的对应的码*/
    }

    public static class NET_DVR_FRAMEFORMAT_EX extends Structure {//ATM参数添加FTP上传参数, 俄罗斯银行定制, 2006-11-17
        public int dwSize;
        public byte[] sATMIP = new byte[16];                        /* ATM IP地址 */
        public int dwATMType;                        /* ATM类型 */
        public int dwInputMode;                        /* 输入方式	0-网络侦听 1-网络接收 2-串口直接输入 3-串口ATM命令输入*/
        public int dwFrameSignBeginPos;              /* 报文标志位的起始位置*/
        public int dwFrameSignLength;                /* 报文标志位的长度 */
        public byte[] byFrameSignContent = new byte[12];            /* 报文标志位的内容 */
        public int dwCardLengthInfoBeginPos;            /* 卡号长度信息的起始位置 */
        public int dwCardLengthInfoLength;            /* 卡号长度信息的长度 */
        public int dwCardNumberInfoBeginPos;            /* 卡号信息的起始位置 */
        public int dwCardNumberInfoLength;            /* 卡号信息的长度 */
        public int dwBusinessTypeBeginPos;           /* 交易类型的起始位置 */
        public int dwBusinessTypeLength;                /* 交易类型的长度 */
        public NET_DVR_FRAMETYPECODE[] frameTypeCode = new NET_DVR_FRAMETYPECODE[10];/* 类型 */
        public byte[] sFTPIP = new byte[16];                        /* FTP IP */
        public byte[] byFtpUsername = new byte[NAME_LEN];            /* 用户名 */
        public byte[] byFtpPasswd = new byte[PASSWD_LEN];            /* 密码 */
        public byte[] sDirName = new byte[NAME_LEN];                /*服务器目录名*/
        public int dwATMSrvType;                        /*ATM服务器类型，0--wincor ，1--diebold*/
        public int dwTimeSpace;                        /*取值为1.2.3.4.5.10*/
        public NET_DVR_FTPTYPECODE[] sFtpTypeCodeOp = new NET_DVR_FTPTYPECODE[300];    /*新加的*/
        public int dwADPlay;    /* 1 表示在播放广告，0 表示没有播放广告*/
        public int dwNewPort;  //端口
    }
/****************************ATM(end)***************************/

    /*****************************DS-6001D/F(begin)***************************/
//DS-6001D Decoder
    public static class NET_DVR_DECODERINFO extends Structure {
        public byte[] byEncoderIP = new byte[16];        //解码设备连接的服务器IP
        public byte[] byEncoderUser = new byte[16];        //解码设备连接的服务器的用户名
        public byte[] byEncoderPasswd = new byte[16];    //解码设备连接的服务器的密码
        public byte bySendMode;            //解码设备连接服务器的连接模式
        public byte byEncoderChannel;        //解码设备连接的服务器的通道号
        public short wEncoderPort;            //解码设备连接的服务器的端口号
        public byte[] reservedData = new byte[4];        //保留
    }

    public static class NET_DVR_DECODERSTATE extends Structure {
        public byte[] byEncoderIP = new byte[16];        //解码设备连接的服务器IP
        public byte[] byEncoderUser = new byte[16];        //解码设备连接的服务器的用户名
        public byte[] byEncoderPasswd = new byte[16];    //解码设备连接的服务器的密码
        public byte byEncoderChannel;        //解码设备连接的服务器的通道号
        public byte bySendMode;            //解码设备连接的服务器的连接模式
        public short wEncoderPort;            //解码设备连接的服务器的端口号
        public int dwConnectState;        //解码设备连接服务器的状态
        public byte[] reservedData = new byte[4];        //保留
    }

    public static class NET_DVR_DECCHANINFO extends Structure {
        public byte[] sDVRIP = new byte[16];                /* DVR IP地址 */
        public short wDVRPort;                    /* 端口号 */
        public byte[] sUserName = new byte[NAME_LEN];        /* 用户名 */
        public byte[] sPassword = new byte[PASSWD_LEN];        /* 密码 */
        public byte byChannel;                    /* 通道号 */
        public byte byLinkMode;                /* 连接模式 */
        public byte byLinkType;                /* 连接类型 0－主码流 1－子码流 */
    }

    public static class NET_DVR_DECINFO extends Structure {/*每个解码通道的配置*/
        public byte byPoolChans;            /*每路解码通道上的循环通道数量, 最多4通道 0表示没有解码*/
        public NET_DVR_DECCHANINFO[] struchanConInfo = new NET_DVR_DECCHANINFO[MAX_DECPOOLNUM];
        public byte byEnablePoll;            /*是否轮巡 0-否 1-是*/
        public byte byPoolTime;                /*轮巡时间 0-保留 1-10秒 2-15秒 3-20秒 4-30秒 5-45秒 6-1分钟 7-2分钟 8-5分钟 */
    }

    public static class NET_DVR_DECCFG extends Structure {/*整个设备解码配置*/
        public int dwSize;
        public int dwDecChanNum;        /*解码通道的数量*/
        public NET_DVR_DECINFO[] struDecInfo = new NET_DVR_DECINFO[MAX_DECNUM];
    }

    //2005-08-01
    public static class NET_DVR_PORTINFO extends Structure {/* 解码设备透明通道设置 */
        public int dwEnableTransPort;    /* 是否启动透明通道 0－不启用 1－启用*/
        public byte[] sDecoderIP = new byte[16];        /* DVR IP地址 */
        public short wDecoderPort;            /* 端口号 */
        public short wDVRTransPort;            /* 配置前端DVR是从485/232输出，1表示232串口,2表示485串口 */
        public byte[] cReserve = new byte[4];
    }

    public static class NET_DVR_PORTCFG extends Structure {
        public int dwSize;
        public NET_DVR_PORTINFO[] struTransPortInfo = new NET_DVR_PORTINFO[MAX_TRANSPARENTNUM]; /* 数组0表示232 数组1表示485 */
    }

    /*https://jna.dev.java.net/javadoc/com/sun/jna/Union.html#setType(java.lang.Class)  see how to use the JNA Union*/
    public static class NET_DVR_PLAYREMOTEFILE extends Structure {/* 控制网络文件回放 */
        public int dwSize;
        public byte[] sDecoderIP = new byte[16];        /* DVR IP地址 */
        public short wDecoderPort;            /* 端口号 */
        public short wLoadMode;                /* 回放下载模式 1－按名字 2－按时间 */
        public byte[] byFile = new byte[100];

        public static class mode_size extends Union {
            public byte[] byFile = new byte[100];        // 回放的文件名

            public static class bytime extends Structure {
                public int dwChannel;
                public byte[] sUserName = new byte[NAME_LEN];    //请求视频用户名
                public byte[] sPassword = new byte[PASSWD_LEN];    // 密码
                public NET_DVR_TIME struStartTime;    //按时间回放的开始时间
                public NET_DVR_TIME struStopTime;    // 按时间回放的结束时间
            }
        }
    }

    public static class NET_DVR_DECCHANSTATUS extends Structure {/*当前设备解码连接状态*/
        public int dwWorkType;        /*工作方式：1：轮巡、2：动态连接解码、3：文件回放下载 4：按时间回放下载*/
        public byte[] sDVRIP = new byte[16];        /*连接的设备ip*/
        public short wDVRPort;            /*连接端口号*/
        public byte byChannel;            /* 通道号 */
        public byte byLinkMode;        /* 连接模式 */
        public int dwLinkType;        /*连接类型 0－主码流 1－子码流*/
        public byte[] sUserName = new byte[NAME_LEN];    /*请求视频用户名*/
        public byte[] sPassword = new byte[PASSWD_LEN];    /* 密码 */
        public byte[] cReserve = new byte[52];

        public static class objectInfo extends Union {
            public static class userInfo extends Structure {
                public byte[] sUserName = new byte[NAME_LEN];    //请求视频用户名
                public byte[] sPassword = new byte[PASSWD_LEN];    // 密码
                public byte[] cReserve = new byte[52];
            }

            public static class fileInfo extends Structure {
                public byte[] fileName = new byte[100];
            }

            public static class timeInfo extends Structure {
                public int dwChannel;
                public byte[] sUserName = new byte[NAME_LEN];    //请求视频用户名
                public byte[] sPassword = new byte[PASSWD_LEN];    // 密码
                public NET_DVR_TIME struStartTime;        // 按时间回放的开始时间
                public NET_DVR_TIME struStopTime;        //按时间回放的结束时间
            }
        }
    }

    public static class NET_DVR_DECSTATUS extends Structure {
        public int dwSize;
        public NET_DVR_DECCHANSTATUS[] struDecState = new NET_DVR_DECCHANSTATUS[MAX_DECNUM];
    }

    /*****************************DS-6001D/F(end)***************************/

    public static class NET_DVR_SHOWSTRINGINFO extends Structure {//单字符参数(子结构)
        public short wShowString;                // 预览的图象上是否显示字符,0-不显示,1-显示 区域大小704*576,单个字符的大小为32*32
        public short wStringSize;                /* 该行字符的长度，不能大于44个字符 */
        public short wShowStringTopLeftX;        /* 字符显示位置的x坐标 */
        public short wShowStringTopLeftY;        /* 字符名称显示位置的y坐标 */
        public byte[] sString = new byte[44];                /* 要显示的字符内容 */
    }

    //叠加字符(9000扩展)
    public static class NET_DVR_SHOWSTRING_V30 extends Structure {
        public int dwSize;
        public NET_DVR_SHOWSTRINGINFO[] struStringInfo = new NET_DVR_SHOWSTRINGINFO[MAX_STRINGNUM_V30];                /* 要显示的字符内容 */
    }

    //叠加字符扩展(8条字符)
    public static class NET_DVR_SHOWSTRING_EX extends Structure {
        public int dwSize;
        public NET_DVR_SHOWSTRINGINFO[] struStringInfo = new NET_DVR_SHOWSTRINGINFO[MAX_STRINGNUM_EX];                /* 要显示的字符内容 */
    }

    //叠加字符
    public static class NET_DVR_SHOWSTRING extends Structure {
        public int dwSize;
        public NET_DVR_SHOWSTRINGINFO[] struStringInfo = new NET_DVR_SHOWSTRINGINFO[MAX_STRINGNUM];                /* 要显示的字符内容 */
    }

    /****************************DS9000新增结构(begin)******************************/

/*
EMAIL参数结构
*/
    public static class NET_DVR_SENDER extends Structure {
        public byte[] sName = new byte[NAME_LEN];                /* 发件人姓名 */
        public byte[] sAddress = new byte[MAX_EMAIL_ADDR_LEN];        /* 发件人地址 */
    }

    public static class NET_DVRRECEIVER extends Structure {
        public byte[] sName = new byte[NAME_LEN];                /* 收件人姓名 */
        public byte[] sAddress = new byte[MAX_EMAIL_ADDR_LEN];        /* 收件人地址 */
    }

    public static class NET_DVR_EMAILCFG_V30 extends Structure {
        public int dwSize;
        public byte[] sAccount = new byte[NAME_LEN];                /* 账号*/
        public byte[] sPassword = new byte[MAX_EMAIL_PWD_LEN];            /*密码 */
        public NET_DVR_SENDER struSender;
        public byte[] sSmtpServer = new byte[MAX_EMAIL_ADDR_LEN];    /* smtp服务器 */
        public byte[] sPop3Server = new byte[MAX_EMAIL_ADDR_LEN];    /* pop3服务器 */
        public NET_DVRRECEIVER[] struReceiver = new NET_DVRRECEIVER[3];                            /* 最多可以设置3个收件人 */
        public byte byAttachment;                    /* 是否带附件 */
        public byte bySmtpServerVerify;                /* 发送服务器要求身份验证 */
        public byte byMailInterval;                 /* mail interval */
        public byte[] res = new byte[77];
    }

    /*
DVR实现巡航数据结构
*/
    public static class NET_DVR_CRUISE_PARA extends Structure {
        public int dwSize;
        public byte[] byPresetNo = new byte[CRUISE_MAX_PRESET_NUMS];        /* 预置点号 */
        public byte[] byCruiseSpeed = new byte[CRUISE_MAX_PRESET_NUMS];    /* 巡航速度 */
        public short[] wDwellTime = new short[CRUISE_MAX_PRESET_NUMS];        /* 停留时间 */
        public byte[] byEnableThisCruise;                        /* 是否启用 */
        public byte[] res = new byte[15];
    }

    /****************************DS9000新增结构(end)******************************/

//时间点
    public static class NET_DVR_TIMEPOINT extends Structure {
        public int dwMonth;        //月 0-11表示1-12个月
        public int dwWeekNo;        //第几周 0－第1周 1－第2周 2－第3周 3－第4周 4－最后一周
        public int dwWeekDate;    //星期几 0－星期日 1－星期一 2－星期二 3－星期三 4－星期四 5－星期五 6－星期六
        public int dwHour;        //小时	开始时间0－23 结束时间1－23
        public int dwMin;        //分	0－59
    }

    //夏令时参数
    public static class NET_DVR_ZONEANDDST extends Structure {
        public int dwSize;
        public byte[] byRes1 = new byte[16];            //保留
        public int dwEnableDST;        //是否启用夏时制 0－不启用 1－启用
        public byte byDSTBias;    //夏令时偏移值，30min, 60min, 90min, 120min, 以分钟计，传递原始数值
        public byte[] byRes2 = new byte[3];
        public NET_DVR_TIMEPOINT struBeginPoint;    //夏时制开始时间
        public NET_DVR_TIMEPOINT struEndPoint;    //夏时制停止时间
    }

    //图片质量
    public static class NET_DVR_JPEGPARA extends Structure {
        /*注意：当图像压缩分辨率为VGA时，支持0=CIF, 1=QCIF, 2=D1抓图，
	当分辨率为3=UXGA(1600x1200), 4=SVGA(800x600), 5=HD720p(1280x720),6=VGA,7=XVGA, 8=HD900p
	仅支持当前分辨率的抓图*/
        public short wPicSize;                /* 0=CIF, 1=QCIF, 2=D1 3=UXGA(1600x1200), 4=SVGA(800x600), 5=HD720p(1280x720),6=VGA*/
        public short wPicQuality;            /* 图片质量系数 0-最好 1-较好 2-一般 */
    }

    /* aux video out parameter */
//辅助输出参数配置
    public static class NET_DVR_AUXOUTCFG extends Structure {
        public int dwSize;
        public int dwAlarmOutChan;                       /* 选择报警弹出大报警通道切换时间：1画面的输出通道: 0:主输出/1:辅1/2:辅2/3:辅3/4:辅4 */
        public int dwAlarmChanSwitchTime;                /* :1秒 - 10:10秒 */
        public int[] dwAuxSwitchTime = new int[MAX_AUXOUT];            /* 辅助输出切换时间: 0-不切换,1-5s,2-10s,3-20s,4-30s,5-60s,6-120s,7-300s */
        public byte[][] byAuxOrder = new byte[MAX_AUXOUT][MAX_WINDOW];    /* 辅助输出预览顺序, 0xff表示相应的窗口不预览 */
    }

    //ntp
    public static class NET_DVR_NTPPARA extends Structure {
        public byte[] sNTPServer = new byte[64];   /* Domain Name or IP addr of NTP server */
        public short wInterval;         /* adjust time interval(hours) */
        public byte byEnableNTP;    /* enable NPT client 0-no，1-yes*/
        public byte cTimeDifferenceH; /* 与国际标准时间的 小时偏移-12 ... +13 */
        public byte cTimeDifferenceM;/* 与国际标准时间的 分钟偏移0, 30, 45*/
        public byte res1;
        public short wNtpPort;         /* ntp server port 9000新增 设备默认为123*/
        public byte[] res2 = new byte[8];
    }

    //ddns
    public static class NET_DVR_DDNSPARA extends Structure {
        public byte[] sUsername = new byte[NAME_LEN];  /* DDNS账号用户名/密码 */
        public byte[] sPassword = new byte[PASSWD_LEN];
        public byte[] sDomainName = new byte[64];       /* 域名 */
        public byte byEnableDDNS;            /*是否应用 0-否，1-是*/
        public byte[] res = new byte[15];
    }

    public static class NET_DVR_DDNSPARA_EX extends Structure {
        public byte byHostIndex;                    /* 0-Hikvision DNS 1－Dyndns 2－PeanutHull(花生壳), 3-希网3322*/
        public byte byEnableDDNS;                    /*是否应用DDNS 0-否，1-是*/
        public short wDDNSPort;                        /* DDNS端口号 */
        public byte[] sUsername = new byte[NAME_LEN];            /* DDNS用户名*/
        public byte[] sPassword = new byte[PASSWD_LEN];            /* DDNS密码 */
        public byte[] sDomainName = new byte[MAX_DOMAIN_NAME];    /* 设备配备的域名地址 */
        public byte[] sServerName = new byte[MAX_DOMAIN_NAME];    /* DDNS 对应的服务器地址，可以是IP地址或域名 */
        public byte[] byRes = new byte[16];
    }

    public static class NET_DVR_DDNS extends Structure {
        public byte[] sUsername = new byte[NAME_LEN];            /* DDNS账号用户名*/
        public byte[] sPassword = new byte[PASSWD_LEN];            /* 密码 */
        public byte[] sDomainName = new byte[MAX_DOMAIN_NAME];    /* 设备配备的域名地址 */
        public byte[] sServerName = new byte[MAX_DOMAIN_NAME];    /* DDNS协议对应的服务器地址，可以是IP地址或域名 */
        public short wDDNSPort;                        /* 端口号 */
        public byte[] byRes = new byte[10];
    }

    //9000扩展
    public static class NET_DVR_DDNSPARA_V30 extends Structure {
        public byte byEnableDDNS;
        public byte byHostIndex;/* 0-Hikvision DNS(保留) 1－Dyndns 2－PeanutHull(花生壳) 3－希网3322 */
        public byte[] byRes1 = new byte[2];
        public NET_DVR_DDNS[] struDDNS = new NET_DVR_DDNS[MAX_DDNS_NUMS];//9000目前只支持前3个配置，其他配置保留
        public byte[] byRes2 = new byte[16];
    }

    //email
    public static class NET_DVR_EMAILPARA extends Structure {
        public byte[] sUsername = new byte[64];  /* 邮件账号/密码 */
        public byte[] sPassword = new byte[64];
        public byte[] sSmtpServer = new byte[64];
        public byte[] sPop3Server = new byte[64];
        public byte[] sMailAddr = new byte[64];   /* email */
        public byte[] sEventMailAddr1 = new byte[64];  /* 上传报警/异常等的email */
        public byte[] sEventMailAddr2 = new byte[64];
        public byte[] res = new byte[16];
    }

    public static class NET_DVR_NETAPPCFG extends Structure {//网络参数配置
        public int dwSize;
        public byte[] sDNSIp = new byte[16];                /* DNS服务器地址 */
        public NET_DVR_NTPPARA struNtpClientParam;      /* NTP参数 */
        public NET_DVR_DDNSPARA struDDNSClientParam;     /* DDNS参数 */
        //NET_DVR_EMAILPARA struEmailParam;       /* EMAIL参数 */
        public byte[] res = new byte[464];            /* 保留 */
    }

    public static class NET_DVR_SINGLE_NFS extends Structure {//nfs结构配置
        public byte[] sNfsHostIPAddr = new byte[16];
        public byte[] sNfsDirectory = new byte[PATHNAME_LEN];        // PATHNAME_LEN = 128
    }

    public static class NET_DVR_NFSCFG extends Structure {
        public int dwSize;
        public NET_DVR_SINGLE_NFS[] struNfsDiskParam = new NET_DVR_SINGLE_NFS[MAX_NFS_DISK];
    }

    //巡航点配置(HIK IP快球专用)
    public static class NET_DVR_CRUISE_POINT extends Structure {
        public byte PresetNum;    //预置点
        public byte Dwell;        //停留时间
        public byte Speed;        //速度
        public byte Reserve;    //保留
    }

    public static class NET_DVR_CRUISE_RET extends Structure {
        public NET_DVR_CRUISE_POINT[] struCruisePoint = new NET_DVR_CRUISE_POINT[32];            //最大支持32个巡航点
    }

    /************************************多路解码器(begin)***************************************/
//多路解码器扩展 added by zxy 2007-05-23
    public static class NET_DVR_NETCFG_OTHER extends Structure {
        public int dwSize;
        public byte[] sFirstDNSIP = new byte[16];
        public byte[] sSecondDNSIP = new byte[16];
        public byte[] sRes = new byte[32];
    }

    public static class NET_DVR_MATRIX_DECINFO extends Structure {
        public byte[] sDVRIP = new byte[16];                /* DVR IP地址 */
        public short wDVRPort;                /* 端口号 */
        public byte byChannel;                /* 通道号 */
        public byte byTransProtocol;            /* 传输协议类型 0-TCP 1-UDP */
        public byte byTransMode;                /* 传输码流模式 0－主码流 1－子码流*/
        public byte[] byRes = new byte[3];
        public byte[] sUserName = new byte[NAME_LEN];            /* 监控主机登陆帐号 */
        public byte[] sPassword = new byte[PASSWD_LEN];            /* 监控主机密码 */
    }

    public static class NET_DVR_MATRIX_DYNAMIC_DEC extends Structure {//启动/停止动态解码
        public int dwSize;
        public NET_DVR_MATRIX_DECINFO struDecChanInfo;        /* 动态解码通道信息 */
    }

    public static class NET_DVR_MATRIX_DEC_CHAN_STATUS extends Structure {//2007-12-13 modified by zxy 修改多路解码器的NET_DVR_MATRIX_DEC_CHAN_STATUS结构
        public int dwSize;//2008-1-16 modified by zxy dwIsLinked的状态由原来的0－未链接 1－连接修改成以下三种状态。
        public int dwIsLinked;         /* 解码通道状态 0－休眠 1－正在连接 2－已连接 3-正在解码 */
        public int dwStreamCpRate;     /* Stream copy rate, X kbits/second */
        public byte[] cRes = new byte[64];        /* 保留 */
    }
//end 2007-12-13 modified by zxy

    public static class NET_DVR_MATRIX_DEC_CHAN_INFO extends Structure {
        public int dwSize;
        public NET_DVR_MATRIX_DECINFO struDecChanInfo;        /* 解码通道信息 */
        public int dwDecState;    /* 0-动态解码 1－循环解码 2－按时间回放 3－按文件回放 */
        public NET_DVR_TIME StartTime;        /* 按时间回放开始时间 */
        public NET_DVR_TIME StopTime;        /* 按时间回放停止时间 */
        public byte[] sFileName = new byte[128];        /* 按文件回放文件名 */
    }

    //连接的通道配置 2007-11-05
    public static class NET_DVR_MATRIX_DECCHANINFO extends Structure {
        public int dwEnable;                    /* 是否启用 0－否 1－启用*/
        public NET_DVR_MATRIX_DECINFO struDecChanInfo;        /* 轮循解码通道信息 */
    }

    //2007-11-05 新增每个解码通道的配置
    public static class NET_DVR_MATRIX_LOOP_DECINFO extends Structure {
        public int dwSize;
        public int dwPoolTime;            /*轮巡时间 */
        public NET_DVR_MATRIX_DECCHANINFO[] struchanConInfo = new NET_DVR_MATRIX_DECCHANINFO[MAX_CYCLE_CHAN];
    }

    //2007-05-25  多路解码器数字矩阵配置
//矩阵行信息 2007-12-28
    public static class NET_DVR_MATRIX_ROW_ELEMENT extends Structure {
        public byte[] sSurvChanName = new byte[128];            /* 监控通道名称，支持中文 */
        public int dwRowNum;                /* 行号 */
        public NET_DVR_MATRIX_DECINFO struDecChanInfo;        /* 矩阵行信息 */
    }

    public static class NET_DVR_MATRIX_ROW_INDEX extends Structure {
        public byte[] sSurvChanName = new byte[128];            /* 监控通道名称，支持中文 */
        public int dwRowNum;                /* 行号 */
    }

    //矩阵列信息 2007-12-28
    public static class NET_DVR_MATRIX_COLUMN_ELEMENT extends Structure {
        public int dwLocalDispChanNum;    /* 本地显示通道号 */
        public int dwGlobalDispChanNum;    /* 全局显示通道号 */
        public int dwRes;            /* 保留 */
    }

    public static class NET_DVR_MATRIX_GLOBAL_COLUMN_ELEMENT extends Structure {
        public int dwConflictTag;        /* 冲突标记，0：无冲突，1：冲突 */
        public int dwConflictGloDispChan;    /* 与之冲突的全局通道号 */
        public NET_DVR_MATRIX_COLUMN_ELEMENT struColumnInfo;/* 矩阵列元素结构体 */
    }

    //手动查看 2007-12-28
    public static class NET_DVR_MATRIX_ROW_COLUMN_LINK extends Structure {
        public int dwSize;
        /*
         *	以下三个参数只需要指定其中一个便可指定数字矩阵里的某一行
         *	所代表的远程监控通道。
         *	如果指定了多个域并有冲突，设备将按照域的先后顺序为准取最先定义者。
         */
        public int dwRowNum;            /* -1代表无效域,大于0者方为有效的矩阵行号 */
        public byte[] sSurvChanName = new byte[128];    /* 监控通道名,是否无效按字符串的有效性判断 */
        public int dwSurvNum;            /* 监控通道号,按矩阵行列表的顺序指定，一般情况下与行号一致 */
        /*
         *	以下两项只需要指定其中一项便可，如果两项都有效默认选择第一项
         */
        public int dwGlobalDispChanNum;            /* 电视墙上的电视机编号 */
        public int dwLocalDispChanNum;
        /*
         *	0代表播放即时码流，
         *	1表示按时间回访远程监控设备的文件
         *	2表示按文件名回访
         */
        public int dwTimeSel;
        public NET_DVR_TIME StartTime;
        public NET_DVR_TIME StopTime;
        public byte[] sFileName = new byte[128];
    }

    public static class NET_DVR_MATRIX_PREVIEW_DISP_CHAN extends Structure {
        public int dwSize;
        public int dwGlobalDispChanNum;        /* 电视墙上的电视机编号 */
        public int dwLocalDispChanNum;        /* 解码通道 */
    }

    public static class NET_DVR_MATRIX_LOOP_PLAY_SET extends Structure {//轮循功能 2007-12-28
        public int dwSize;
        /* 任意指定一个,-1为无效,如果都指定则以LocalDispChanNum为准 */
        public int dwLocalDispChanNum;    /* 解码通道 */
        public int dwGlobalDispChanNum;    /* 电视墙上的电视机编号 */
        public int dwCycTimeInterval;    /* 轮循时间间隔 */
    }

    public static class NET_DVR_MATRIX_LOCAL_HOST_INFO extends Structure {//矩阵中心配置 2007-12-28
        public int dwSize;
        public int dwLocalHostProperty;    /* 本地主机类型 0－服务器 1－客户端*/
        public int dwIsIsolated;        /* 本地主机是否独立于系统，0：联网，1：独立 */
        public int dwLocalMatrixHostPort;    /* 本地主机访问端口 */
        public byte[] byLocalMatrixHostUsrName = new byte[NAME_LEN];        /* 本地主机登录用户名 */
        public byte[] byLocalMatrixHostPasswd = new byte[PASSWD_LEN];        /* 本地主机登录密码 */
        public int dwLocalMatrixCtrlMedia;                /* 控制方式 0x1串口键盘控制 0x2网络键盘控制 0x4矩阵中心控制 0x8PC客户端控制*/
        public byte[] sMatrixCenterIP = new byte[16];        /* 矩阵中心IP地址 */
        public int dwMatrixCenterPort;        /* 矩阵中心端口号 */
        public byte[] byMatrixCenterUsrName = new byte[NAME_LEN];    /* 矩阵中心登录用户名 */
        public byte[] byMatrixCenterPasswd = new byte[PASSWD_LEN];    /* 矩阵中心登录密码 */
    }

    //2007-12-22
    public static class TTY_CONFIG extends Structure {
        public byte baudrate;    /* 波特率 */
        public byte databits;        /* 数据位 */
        public byte stopbits;        /* 停止位 */
        public byte parity;        /* 奇偶校验位 */
        public byte flowcontrol;    /* 流控 */
        public byte[] res = new byte[3];
    }

    public static class NET_DVR_MATRIX_TRAN_CHAN_INFO extends Structure {
        public byte byTranChanEnable;    /* 当前透明通道是否打开 0：关闭 1：打开 */
        /*
         *	多路解码器本地有1个485串口，1个232串口都可以作为透明通道,设备号分配如下：
         *	0 RS485
         *	1 RS232 Console
         */
        public byte byLocalSerialDevice;            /* Local serial device */
        /*
         *	远程串口输出还是两个,一个RS232，一个RS485
         *	1表示232串口
         *	2表示485串口
         */
        public byte byRemoteSerialDevice;            /* Remote output serial device */
        public byte res1;                            /* 保留 */
        public byte[] sRemoteDevIP = new byte[16];                /* Remote Device IP */
        public short wRemoteDevPort;                /* Remote Net Communication Port */
        public byte[] res2 = new byte[2];                        /* 保留 */
        public TTY_CONFIG RemoteSerialDevCfg;
    }

    public static class NET_DVR_MATRIX_TRAN_CHAN_CONFIG extends Structure {
        public int dwSize;
        public byte by232IsDualChan; /* 设置哪路232透明通道是全双工的 取值1到MAX_SERIAL_NUM */
        public byte by485IsDualChan; /* 设置哪路485透明通道是全双工的 取值1到MAX_SERIAL_NUM */
        public byte[] res = new byte[2];    /* 保留 */
        public NET_DVR_MATRIX_TRAN_CHAN_INFO[] struTranInfo = new NET_DVR_MATRIX_TRAN_CHAN_INFO[MAX_SERIAL_NUM];/*同时支持建立MAX_SERIAL_NUM个透明通道*/
    }

    //2007-12-24 Merry Christmas Eve...
    public static class NET_DVR_MATRIX_DEC_REMOTE_PLAY extends Structure {
        public int dwSize;
        public byte[] sDVRIP = new byte[16];        /* DVR IP地址 */
        public short wDVRPort;            /* 端口号 */
        public byte byChannel;            /* 通道号 */
        public byte byReserve;
        public byte[] sUserName = new byte[NAME_LEN];        /* 用户名 */
        public byte[] sPassword = new byte[PASSWD_LEN];        /* 密码 */
        public int dwPlayMode;    /* 0－按文件 1－按时间*/
        public NET_DVR_TIME StartTime;
        public NET_DVR_TIME StopTime;
        public byte[] sFileName = new byte[128];
    }


    public static class NET_DVR_MATRIX_DEC_REMOTE_PLAY_CONTROL extends Structure {
        public int dwSize;
        public int dwPlayCmd;        /* 播放命令 见文件播放命令*/
        public int dwCmdParam;        /* 播放命令参数 */
    }

    public static class NET_DVR_MATRIX_DEC_REMOTE_PLAY_STATUS extends Structure {
        public int dwSize;
        public int dwCurMediaFileLen; /* 当前播放的媒体文件长度 */
        public int dwCurMediaFilePosition; /* 当前播放文件的播放位置 */
        public int dwCurMediaFileDuration; /* 当前播放文件的总时间 */
        public int dwCurPlayTime; /* ½前已经播放的时间 */
        public int dwCurMediaFIleFrames; /* 当前播放文件的总帧数 */
        public int dwCurDataType; /* 当前传输的数据类型，19-文件头，20-流数据， 21-播放结束标志 */
        public byte[] res = new byte[72];
    }

    public static class NET_DVR_MATRIX_PASSIVEMODE extends Structure {
        public short wTransProtol;        //传输协议，0-TCP, 1-UDP, 2-MCAST
        public short wPassivePort;        //TCP,UDP时为TCP,UDP端口, MCAST时为MCAST端口
        public byte[] sMcastIP = new byte[16];        //TCP,UDP时无效, MCAST时为多播地址
        public byte[] res = new byte[8];
    }
/************************************多路解码器(end)***************************************/


    /************************************拼控(Start)***************************************/
    public static final int NET_DVR_GET_VIDEOWALLWINDOWPOSITION = 1735;//获取电视墙窗口参数
    public static final int NET_DVR_SET_VIDEOWALLWINDOWPOSITION = 1736;//设置电视墙窗口参数
    public static final int NET_DVR_GET_VW_SCENE_PARAM = 1746;//获取电视墙场景模式参数
    public static final int NET_DVR_SET_VW_SCENE_PARAM = 1747;//设置电视墙场景模式参数
    public static final int NET_DVR_SCENE_CONTROL = 1744; //场景控制

    public static final int NET_DVR_GET_SUBWND_DECODE_OSD = 9183;  //获取子窗口解码OSD信息
    public static final int NET_DVR_GET_SUBWND_DECODE_OSD_ALL = 9184;  //获取所有子窗口解码OSD信息
    public static final int NET_DVR_SET_SUBWND_DECODE_OSD = 9185;  //设置子窗口解码OSD信息
    public static final int NET_DVR_GET_SUBWND_DECODE_OSD_CAP = 9186;  //获取子窗口解码OSD信息能力集
    public static final int NET_DVR_GET_DECODE_CHANNEL_OSD = 9187;  //获取解码通道OSD信息
    public static final int NET_DVR_SET_DECODE_CHANNEL_OSD = 9188;  //设置解码通道OSD信息

    public static final int MAX_PLAN_ACTION_NUM = 32;    //预案动作个数
    public static final int DAYS_A_WEEK = 7;    //一周7天
    public static final int MAX_PLAN_COUNT = 16;    //预案个数
    public static final int MAX_LEN_OSD_CONTENT = 256;  //OSD信息最大长度
    public static final int MAX_NUM_OSD_ONE_SUBWND = 8;  //单个子窗口支持的最大OSD数量
    public static final int MAX_NUM_SPLIT_WND = 64; //单个窗口支持的最大分屏窗口数量（即子窗口数量）
    public static final int MAX_NUM_OSD = 8;
    public static final int MAX_CYCLE_CHAN_V30 = 64;      //最大轮巡通道数（扩展）
    public static final int STREAM_PASSWD_LEN = 12;      //码流加密密钥最大长度

    public static class NET_DVR_VIDEO_WALL_INFO extends Structure {
        public int dwSize;
        //窗口号：1字节墙号+1字节保留+2字节窗口号
        public int dwWindowNo;
        public int dwSceneNo;//场景号
        public int dwDestWallNo; //目的墙号
        public int dwDestSceneNo;//目的场景号
        public byte[] byRes = new byte[12];
    }

    public static class NET_DVR_SCENE_CONTROL_INFO extends Structure {
        public int dwSize;
        public NET_DVR_VIDEO_WALL_INFO struVideoWallInfo; //电视墙信息
        public int dwCmd; //场景控制命令，1-场景模式切换（如果要切换的是当前场景，则不进行切换），2-初始化场景（将此场景的配置清空，如果是当前场景，则同时对当前场景进行清屏操作），3-强制切换（无论是否是当前场景，强制切换），4-保存当前模式到某场景 5-删除场景 ,6-场景复制
        public byte[] byRes = new byte[4];
    }

    public static class NET_DVR_BUF_INFO extends Structure {
        public Pointer pBuf;
        public int nLen;
    }

    public static class NET_DVR_IN_PARAM extends Structure {
        public NET_DVR_BUF_INFO struCondBuf;
        public NET_DVR_BUF_INFO struInParamBuf;
        public int dwRecvTimeout;      //接收数据超时时间，单位：ms,置0采用接口默认超时
        public byte[] byRes = new byte[32];
    }

    public static class NET_DVR_OUT_PARAM extends Structure {
        public NET_DVR_BUF_INFO struOutBuf;
        public Pointer lpStatusList;
        public byte[] byRes = new byte[32];
    }

    public static class NET_DVR_RECTCFG_EX extends Structure {
        public int dwXCoordinate; /*矩形左上角起始点X坐标*/
        public int dwYCoordinate; /*矩形左上角Y坐标*/
        public int dwWidth;       /*矩形宽度*/
        public int dwHeight;      /*矩形高度*/
        public byte[] byRes = new byte[4];

    }

    public static class NET_DVR_VIDEOWALLWINDOWPOSITION extends Structure {
        public int dwSize;
        public byte byEnable;  //窗口使能,0-不使能，1-使能
        public byte byWndOperateMode;  //窗口操作模式，0-统一坐标，1-分辨率坐标
        public byte[] byRes1 = new byte[6];
        public int dwWindowNo;//窗口号
        public int dwLayerIndex;//窗口相对应的图层号，图层号到最大即置顶，置顶操作
        public NET_DVR_RECTCFG_EX struRect; //目的窗口统一坐标(相对显示墙)，获取或按统一坐标设置时有效
        public NET_DVR_RECTCFG_EX struResolution; //目的窗口分辨率坐标，获取或按分辨率坐标设置有效
        public int dwXCoordinate; //LED区域左上角X坐标（统一坐标），获取或按分辨率坐标设置有效
        public int dwYCoordinate; //LED区域左上角Y坐标（统一坐标），获取或按分辨率坐标设置有效
        public byte[] byRes2 = new byte[36];
    }

    public static class NET_DVR_WALLWINPARAM extends Structure {
        public int dwSize;
        public byte byTransparency; //使能透明度，0-关，非0-开
        public byte byWinMode;//窗口分屏模式，能力集获取
        public byte byEnableSpartan;//畅显使能，0-关，1-开
        public byte byDecResource;  //为窗口分配的解码资源，1-D1,2-720P,3-1080P
        public byte byWndShowMode; //窗口显示模式，0-此字段不用，1-子窗口模式，2-子窗口全屏模式
        public byte byEnabledFeature; //是否启用场景特写，0-不启用，!0-启用
        public byte byFeatureMode; //特写模式，启用场景特写时有效，0-无效，1-“1+5”模式
        public byte byRes1;
        public int dwAmplifyingSubWndNo; //全屏子窗口号（1字节墙号+1字节子窗口号+2字节窗口号）
        //当byWndShowMode为2时有效，表示当前全屏显示的子窗口
        public byte byWndTopKeep; //窗口置顶保持，0-不保持，1-保持
        public byte byWndOpenKeep; //窗口打开保持，0-不保持，1-保持
        public byte[] byRes = new byte[22];
    }

    public static class NET_DVR_PLAN_LIST extends Structure {
        public int dwSize;
        public int dwPlanNums;            //设备输入信号源数量
        public Pointer pBuffer;            //指向dwInputSignalNums个NET_DVR_PLAN_CFG结构大小的缓冲区
        public byte byWallNo;            //墙号，从1开始
        public byte[] byRes1 = new byte[2];
        public int dwBufLen;            //所分配缓冲区长度，输入参数（大于等于dwInputSignalNums个NET_DVR_PLAN_CFG结构大小）
        public byte[] byRes2 = new byte[64];
    }

    /*预案项信息*/
    public static class NET_DVR_PLAN_INFO extends Structure {
        public byte byValid;          // 该项是否有效
        public byte byType;           // 见定义NET_DVR_PLAN_OPERATE_TYPE
        public short wLayoutNo;      // 布局号
        public byte byScreenStyle;    //屏幕型号，开关机所用，1是低亮，2是高亮
        public byte byBaseMapType;  //底图类型，1-图片底图，2-超高清输入底图，底图切换时有效
        public byte[] byRes1 = new byte[2];
        public int dwDelayTime;      // 一个项的运行时间, 单位秒
        public int dwSerialNo;        //串口号，屏幕控制时使用
        public int dwBaseMapWndNo; //底图窗口号，底图切换时有效
        public int dwBaseMapNo;   //底图号，底图切换时有效；底图类型为1时，此参数为图片序号，底图类型为2时此参数为超高清输入子系统输入号（1字节设备号+1字节子板号+2字节显示输入序号）
        public byte[] byRes2 = new byte[20];
    }

    public static class NET_DVR_CYCLE_TIME extends Structure {
        public byte byValid;
        public byte[] byRes = new byte[3];
        public NET_DVR_TIME_EX struTime = new NET_DVR_TIME_EX();
    }

    /*预案管理*/
    public static class NET_DVR_PLAN_CFG extends Structure {
        public int dwSize;
        public byte byValid;          // 该预案是否有效
        public byte byWorkMode;      // 预案工作模式 1表示手动，2自动，3预案循环
        public byte byWallNo;        //电视墙号，从1开始
        public byte byPlanNo;    //预案号，获取预案列表时有效，0-无效或不支持
        public byte[] byPlanName = new byte[NAME_LEN/*32*/]; //预案名称
        public NET_DVR_TIME_EX struTime; // 工作模式为自动时使用
        public NET_DVR_CYCLE_TIME[] struTimeCycle = new NET_DVR_CYCLE_TIME[DAYS_A_WEEK/*7*/]; /*循环时间，周期为一个星期，年、月、日三个参数不使用。如：struTimeCycle[0]中的byValid的值是1，表示星期天执行该预案。星期取值区间为[0,6]，其中0代表星期天，1代表星期一，以此类推*/
        public int dwWorkCount;      // 预案内容执行次数
        public NET_DVR_PLAN_INFO[] strPlanEntry = new NET_DVR_PLAN_INFO[MAX_PLAN_ACTION_NUM/*32*/];  // 预案执行的内容
        public int dwPlanNo; //4字节预案号，客户端统一使用4字节的预案号，单字节的预案号不再使用
        public byte[] byRes2 = new byte[60];
    }

    public static class NET_DVR_WALLSCENECFG extends Structure {
        public int dwSize;
        public byte[] sSceneName = new byte[NAME_LEN];    //场景名称
        public byte byEnable;                //场景是否有效，0-无效，1-有效
        public byte bySceneIndex;            //场景号，只能获取。获取所有场景时使用该参数
        public byte[] byRes = new byte[78];
    }

    public static class NET_DVR_SUBWND_DECODE_OSD extends Structure {
        public int dwSize = 0;
        public int dwSubWndNo = 0; //子窗口号（4字节组合方式）
        public int dwOSDNums = 0;  //该子窗口配置的OSD信息的个数
        public NET_DVR_OSD_INFO[] struOSDList = new NET_DVR_OSD_INFO[MAX_NUM_OSD_ONE_SUBWND];  //OSD信息列表
        public byte[] byRes = new byte[32];
    }

    public static class NET_DVR_OSD_INFO extends Structure {
        public byte byEnabled = 1;  //是否使能，零-不使能，非零-使能
        public byte byEnabledFlash = 0;  //是否闪烁，零-不闪烁，非零-闪烁
        public byte byFontSize = 1;  //字体大小，1-大，2-中，3-小
        public byte byTransparent = 0;  //透明度，取值范围0-100
        public NET_DVR_RGB_COLOR struColor = new NET_DVR_RGB_COLOR();  //字体颜色
        public short wCoordinateX = 0;  //OSD左上角X坐标
        public short wCoordinateY = 0;  //OSD左上角Y坐标
        public byte[] byContent = new byte[MAX_LEN_OSD_CONTENT];  //OSD信息
        public byte[] byRes = new byte[32];
    }

    public static class NET_DVR_DEV_CHAN_INFO_EX extends Structure {
        public byte byChanType;              //通道类型，0-普通通道,1-零通道,2-流ID，3-本地输入源，4-虚拟屏服务器通道，5-拼接通道，6-屏幕服务器，7-分布式网络源，8-多相机融合通道，9-网络输入源
        public byte[] byStreamId = new byte[STREAM_ID_LEN]; //流ID，当byChanType=2、9时，该字段用于指定流或者网络ipc的ID号
        public byte[] byRes1 = new byte[3];
        public int dwChannel;  //通道号，通道类型为普通通道，零通道，本地输入源，虚拟屏服务器通道，拼接通道，屏幕服务器，分布式网络源时填此字段
        public byte[] byRes2 = new byte[24];
        public byte[] byAddress = new byte[MAX_DOMAIN_NAME];    //设备域名
        public short wDVRPort;                 //端口号
        public byte byChannel;                //通道号,dwChannel不为0时此字段无效
        public byte byTransProtocol;        //传输协议类型0-TCP，1-UDP
        public byte byTransMode;            //传输码流模式 0－主码流 1－子码流
        public byte byFactoryType;            /*前端设备厂家类型,通过接口获取*/
        public byte byDeviceType; //设备类型(视频综合平台智能板使用)，1-解码器（此时根据视频综合平台能力集中byVcaSupportChanMode字段来决定是使用解码通道还是显示通道），2-编码器
        public byte byDispChan;//显示通道号,智能配置使用
        public byte bySubDispChan;//显示通道子通道号，智能配置时使用
        public byte byResolution;    //; 1-CIF 2-4CIF 3-720P 4-1080P 5-500w大屏控制器使用，大屏控制器会根据该参数分配解码资源
        public byte[] byRes = new byte[2];
        public byte[] sUserName = new byte[NAME_LEN];    //监控主机登陆帐号
        public byte[] sPassword = new byte[PASSWD_LEN];    //监控主机密码
    }

    public static class NET_DVR_STREAM_MEDIA_SERVER extends Structure {
        public byte byValid; //是否启用，0-否，1-是
        public byte[] byRes1 = new byte[3];
        public byte[] byAddress = new byte[MAX_DOMAIN_NAME];   //IP或者域名
        public short wDevPort;            /*流媒体服务器端口*/
        public byte byTransmitType;        /*传输协议类型 0-TCP，1-UDP*/
        public byte[] byRes2 = new byte[5];
    }

    public static class NET_DVR_DEV_DDNS_INFO extends Structure {
        public byte[] byDevAddress = new byte[MAX_DOMAIN_NAME];    //域名(IPServer或hiDDNS时可填序列号或者别名)
        public byte byTransProtocol;        //传输协议类型0-TCP，1-UDP, 2-MCAST
        public byte byTransMode;            //传输码流模式 0－主码流 1－子码流
        public byte byDdnsType;         //域名服务器类型，0-IPServer 1－Dyndns 2－PeanutHull(花生壳)，3- NO-IP, 4- hiDDNS
        public byte byRes1;
        public byte[] byDdnsAddress = new byte[MAX_DOMAIN_NAME];  //DDNS服务器地址
        public short wDdnsPort;                 //DDNS服务器端口号
        public byte byChanType;              //0-普通通道,1-零通道,2-流ID
        public byte byFactoryType;            //前端设备厂家类型,通过接口获取
        public int dwChannel; //通道号
        public byte[] byStreamId = new byte[STREAM_ID_LEN]; //流ID
        public byte[] sUserName = new byte[NAME_LEN];    //监控主机登陆帐号
        public byte[] sPassword = new byte[PASSWD_LEN];    //监控主机密码
        public short wDevPort;                //前端设备通信端口
        public byte[] byRes2 = new byte[2];
    }

    public static class NET_DVR_DEC_STREAM_DEV_EX extends Structure {
        public NET_DVR_STREAM_MEDIA_SERVER struStreamMediaSvrCfg = new NET_DVR_STREAM_MEDIA_SERVER();
        public NET_DVR_DEV_CHAN_INFO_EX struDevChanInfo = new NET_DVR_DEV_CHAN_INFO_EX();
    }

    //DDNS方式取流
    public static class NET_DVR_DEC_DDNS_DEV extends Structure {
        public NET_DVR_DEV_DDNS_INFO struDdnsInfo;
        public NET_DVR_STREAM_MEDIA_SERVER struMediaServer;
    }

    public static class NET_DVR_DEC_STREAM_MODE extends Union {
        public NET_DVR_DEC_STREAM_DEV_EX struDecStreamDev = new NET_DVR_DEC_STREAM_DEV_EX();
        public NET_DVR_PU_STREAM_URL struUrlInfo = new NET_DVR_PU_STREAM_URL();
        public NET_DVR_DEC_DDNS_DEV struDdnsDecInfo = new NET_DVR_DEC_DDNS_DEV();
        public byte[] byRes = new byte[300];
    }

    public static class NET_DVR_MATRIX_CHAN_INFO_V41 extends Structure {
        public byte byEnable; //是否启用，0-否，1-是
        public byte byStreamMode;/*取流模式，0-无效，1-通过IP或域名取流，2-通过URL取流,3-通过动态域名解析向设备取流*/
        public byte[] byRes = new byte[2];
        public NET_DVR_DEC_STREAM_MODE uDecStreamMode = new NET_DVR_DEC_STREAM_MODE();//取流信息
    }

    public static class NET_DVR_MATRIX_LOOP_DECINFO_V41 extends Structure {
        public int dwSize;
        public int dwPoolTime;        /*轮巡间隔*/
        public NET_DVR_MATRIX_CHAN_INFO_V41[] struchanConInfo = new NET_DVR_MATRIX_CHAN_INFO_V41[MAX_CYCLE_CHAN_V30];
        public byte byStreamEncrypt;  //是否进行码流加密处理,0-不支持,1-支持
        public byte[] byRes = new byte[3];
        public byte[] sStreamPassword = new byte[STREAM_PASSWD_LEN];  //码流加密密码,需敏感信息加密
    }

    /************************************拼控(End)***************************************/

    public static class NET_DVR_EMAILCFG extends Structure {    /* 12 bytes */
        public int dwSize;
        public byte[] sUserName = new byte[32];
        public byte[] sPassWord = new byte[32];
        public byte[] sFromName = new byte[32];            /* Sender *///字符串中的第一个字符和最后一个字符不能是"@",并且字符串中要有"@"字符
        public byte[] sFromAddr = new byte[48];            /* Sender address */
        public byte[] sToName1 = new byte[32];            /* Receiver1 */
        public byte[] sToName2 = new byte[32];            /* Receiver2 */
        public byte[] sToAddr1 = new byte[48];            /* Receiver address1 */
        public byte[] sToAddr2 = new byte[48];            /* Receiver address2 */
        public byte[] sEmailServer = new byte[32];        /* Email server address */
        public byte byServerType;            /* Email server type: 0-SMTP, 1-POP, 2-IMTP…*/
        public byte byUseAuthen;            /* Email server authentication method: 1-enable, 0-disable */
        public byte byAttachment;            /* enable attachment */
        public byte byMailinterval;            /* mail interval 0-2s, 1-3s, 2-4s. 3-5s*/
    }

    public static class NET_DVR_COMPRESSIONCFG_NEW extends Structure {
        public int dwSize;
        public NET_DVR_COMPRESSION_INFO_EX struLowCompression;    //定时录像
        public NET_DVR_COMPRESSION_INFO_EX struEventCompression;    //事件触发录像
    }

    //球机位置信息
    public static class NET_DVR_PTZPOS extends Structure {
        public short wAction;//获取时该字段无效
        public short wPanPos;//水平参数
        public short wTiltPos;//垂直参数
        public short wZoomPos;//变倍参数
    }

    //球机范围信息
    public static class NET_DVR_PTZSCOPE extends Structure {
        public short wPanPosMin;//水平参数min
        public short wPanPosMax;//水平参数max
        public short wTiltPosMin;//垂直参数min
        public short wTiltPosMax;//垂直参数max
        public short wZoomPosMin;//变倍参数min
        public short wZoomPosMax;//变倍参数max
    }

    public static class NET_DVR_PTZABSOLUTEEX_CFG extends Structure {
        public int dwSize;//结构体大小
        public NET_PTZ_INFO struPTZCtrl = new NET_PTZ_INFO();//设备PTZF信息
        public int dwFocalLen;//焦距范围：0-100000MM
        public float fHorizontalSpeed;//水平转动速度：0.01-1000.00度/S
        public float fVerticalSpeed;//垂直转动速度：0.01-1000.00度/S
        /*镜头变倍配置类型；absoluteZoom:通过变倍参数进行配置，选择为该类型时struPTZCtrl中的fZoom参数生效。focalLen:通过焦距参数进行配置，选择为该类型时，dwFocalLen参数生效。*/
        public byte byZoomType;// 镜头变倍配置类型0~ absoluteZoom，1~ focalLen
        public byte[] byRes = new byte[123];
    }

    //rtsp配置 ipcamera专用
    public static class NET_DVR_RTSPCFG extends Structure {
        public int dwSize;         //长度
        public short wPort;          //rtsp服务器侦听端口
        public byte[] byReserve = new byte[54];  //预留
    }

    /********************************接口参数结构(begin)*********************************/

//NET_DVR_Login()参数结构
    public static class NET_DVR_DEVICEINFO extends Structure {
        public byte[] sSerialNumber = new byte[SERIALNO_LEN];   //序列号
        public byte byAlarmInPortNum;                //DVR报警输入个数
        public byte byAlarmOutPortNum;                //DVR报警输出个数
        public byte byDiskNum;                        //DVR硬盘个数
        public byte byDVRType;                        //DVR类型, 1:DVR 2:ATM DVR 3:DVS ......
        public byte byChanNum;                        //DVR 通道个数
        public byte byStartChan;                    //起始通道号,例如DVS-1,DVR - 1
    }

    //NET_DVR_Login_V30()参数结构
    public static class NET_DVR_DEVICEINFO_V30 extends Structure {
        public byte[] sSerialNumber = new byte[SERIALNO_LEN];  //序列号
        public byte byAlarmInPortNum;    //报警输入个数
        public byte byAlarmOutPortNum;   //报警输出个数
        public byte byDiskNum;           //硬盘个数
        public byte byDVRType;         //设备类型, 1:DVR 2:ATM DVR 3:DVS ......
        public byte byChanNum;         //模拟通道个数
        public byte byStartChan;      //起始通道号,例如DVS-1,DVR - 1
        public byte byAudioChanNum;    //语音通道数
        public byte byIPChanNum;     //最大数字通道个数，低位
        public byte byZeroChanNum;    //零通道编码个数 //2010-01-16
        public byte byMainProto;      //主码流传输协议类型 0-private, 1-rtsp,2-同时支持private和rtsp
        public byte bySubProto;        //子码流传输协议类型0-private, 1-rtsp,2-同时支持private和rtsp
        public byte bySupport;        //能力，位与结果为0表示不支持，1表示支持，
        public byte bySupport1;        // 能力集扩充，位与结果为0表示不支持，1表示支持
        public byte bySupport2; /*能力*/
        public short wDevType;              //设备型号
        public byte bySupport3; //能力集扩展
        public byte byMultiStreamProto;//是否支持多码流,按位表示,0-不支持,1-支持,bit1-码流3,bit2-码流4,bit7-主码流，bit-8子码流
        public byte byStartDChan;        //起始数字通道号,0表示无效
        public byte byStartDTalkChan;    //起始数字对讲通道号，区别于模拟对讲通道号，0表示无效
        public byte byHighDChanNum;        //数字通道个数，高位
        public byte bySupport4;        //能力集扩展
        public byte byLanguageType;// 支持语种能力,按位表示,每一位0-不支持,1-支持
        //  byLanguageType 等于0 表示 老设备
        //  byLanguageType & 0x1表示支持中文
        //  byLanguageType & 0x2表示支持英文
        public byte byVoiceInChanNum;   //音频输入通道数
        public byte byStartVoiceInChanNo; //音频输入起始通道号 0表示无效
        public byte bySupport5;
        public byte bySupport6;   //能力
        public byte byMirrorChanNum;    //镜像通道个数，<录播主机中用于表示导播通道>
        public short wStartMirrorChanNo;  //起始镜像通道号
        public byte bySupport7;   //能力
        public byte byRes2;        //保留
    }

    public static final int NET_DVR_DEV_ADDRESS_MAX_LEN = 129;
    public static final int NET_DVR_LOGIN_USERNAME_MAX_LEN = 64;
    public static final int NET_DVR_LOGIN_PASSWD_MAX_LEN = 64;

    public static interface FLoginResultCallBack extends StdCallCallback {
        public int invoke(int lUserID, int dwResult, NET_DVR_DEVICEINFO_V30 lpDeviceinfo, Pointer pUser);
    }

    //NET_DVR_Login_V40()参数
    public static class NET_DVR_USER_LOGIN_INFO extends Structure {
        public byte[] sDeviceAddress = new byte[NET_DVR_DEV_ADDRESS_MAX_LEN];
        public byte byUseTransport;
        public short wPort;
        public byte[] sUserName = new byte[NET_DVR_LOGIN_USERNAME_MAX_LEN];
        public byte[] sPassword = new byte[NET_DVR_LOGIN_PASSWD_MAX_LEN];
        public FLoginResultCallBack cbLoginResult;
        public Pointer pUser;
        public boolean bUseAsynLogin;
        public byte byProxyType; //0:不使用代理，1：使用标准代理，2：使用EHome代理
        public byte byUseUTCTime;    //0-不进行转换，默认,1-接口上输入输出全部使用UTC时间,SDK完成UTC时间与设备时区的转换,2-接口上输入输出全部使用平台本地时间，SDK完成平台本地时间与设备时区的转换
        public byte byLoginMode; //0-Private 1-ISAPI 2-自适应
        public byte byHttps;    //0-不适用tls，1-使用tls 2-自适应
        public int iProxyID;    //代理服务器序号，添加代理服务器信息时，相对应的服务器数组下表值
        public byte byVerifyMode;  //认证方式，0-不认证，1-双向认证，2-单向认证；认证仅在使用TLS的时候生效;
        public byte[] byRes2 = new byte[119];
    }

    //NET_DVR_Login_V40()参数
    public static class NET_DVR_DEVICEINFO_V40 extends Structure {
        public NET_DVR_DEVICEINFO_V30 struDeviceV30 = new NET_DVR_DEVICEINFO_V30();
        public byte bySupportLock;
        public byte byRetryLoginTime;
        public byte byPasswordLevel;
        public byte byRes1;
        public int dwSurplusLockTime;
        public byte byCharEncodeType;//字符编码类型：0- 无字符编码信息(老设备)，1- GB2312(简体中文)，2- GBK，3- BIG5(繁体中文)，4- Shift_JIS(日文)，5- EUC-KR(韩文)，6- UTF-8，7- ISO8859-1，8- ISO8859-2，9- ISO8859-3，…，依次类推，21- ISO8859-15(西欧)
        public byte bySupportDev5; //支持v50版本的设备参数获取，设备名称和设备类型名称长度扩展为64字节
        public byte bySupport;  //能力集扩展，位与结果：0- 不支持，1- 支持
        public byte byLoginMode; //登录模式 0-Private登录 1-ISAPI登录
        public int dwOEMCode;
        public int iResidualValidity;   //该用户密码剩余有效天数，单位：天，返回负值，表示密码已经超期使用，例如“-3表示密码已经超期使用3天”
        public byte byResidualValidity; // iResidualValidity字段是否有效，0-无效，1-有效
        public byte bySingleStartDTalkChan;    //独立音轨接入的设备，起始接入通道号，0-为保留字节，无实际含义，音轨通道号不能从0开始
        public byte bySingleDTalkChanNums;    //独立音轨接入的设备的通道总数，0-表示不支持
        public byte byPassWordResetLevel; //0-无效，1-管理员创建一个非管理员用户为其设置密码，该非管理员用户正确登录设备后要提示“请修改初始登录密码”，未修改的情况下，用户每次登入都会进行提醒；2-当非管理员用户的密码被管理员修改，该非管理员用户再次正确登录设备后，需要提示“请重新设置登录密码”，未修改的情况下，用户每次登入都会进行提醒。
        public byte bySupportStreamEncrypt;  //能力集扩展，位与结果：0- 不支持，1- 支持 bySupportStreamEncrypt & 0x1:表示是否支持RTP/TLS取流 bySupportStreamEncrypt & 0x2:  表示是否支持SRTP/UDP取流 bySupportStreamEncrypt & 0x4:  表示是否支持SRTP/MULTICAST取流
        public byte byMarketType;//0-无效（未知类型）,1-经销型，2-行业型
        public byte[] byRes2 = new byte[238];
    }

    //sdk网络环境枚举变量，用于远程升级
    enum _SDK_NET_ENV {
        LOCAL_AREA_NETWORK,
        WIDE_AREA_NETWORK
    }

    //显示模式
    enum DISPLAY_MODE {
        NORMALMODE,
        OVERLAYMODE
    }

    //发送模式
    enum SEND_MODE {
        PTOPTCPMODE,
        PTOPUDPMODE,
        MULTIMODE,
        RTPMODE,
        RESERVEDMODE
    }

    ;

    //抓图模式
    enum CAPTURE_MODE {
        BMP_MODE,        //BMP模式
        JPEG_MODE        //JPEG模式
    }

    ;

    //实时声音模式
    enum REALSOUND_MODE {
        NONE,                   //SDK中无此模式,只是为了填补0这个位置
        MONOPOLIZE_MODE,       //独占模式 1
        SHARE_MODE        //共享模式 2
    }

    ;

    //软解码预览参数
    public static class NET_DVR_CLIENTINFO extends Structure {
        public int lChannel;
        public int lLinkMode;
        public HWND hPlayWnd;
        public String sMultiCastIP;
    }

    //预览V40接口
    public static class NET_DVR_PREVIEWINFO extends Structure {
        public int lChannel;//通道号
        public int dwStreamType;    // 码流类型，0-主码流，1-子码流，2-码流3，3-码流4, 4-码流5,5-码流6,7-码流7,8-码流8,9-码流9,10-码流10
        public int dwLinkMode;// 0：TCP方式,1：UDP方式,2：多播方式,3 - RTP方式，4-RTP/RTSP,5-RSTP/HTTP ,6- HRUDP（可靠传输） ,7-RTSP/HTTPS
        public HWND hPlayWnd;//播放窗口的句柄,为NULL表示不播放图象
        public int bBlocked;  //0-非阻塞取流, 1-阻塞取流, 如果阻塞SDK内部connect失败将会有5s的超时才能够返回,不适合于轮询取流操作.
        public int bPassbackRecord; //0-不启用录像回传,1启用录像回传
        public byte byPreviewMode;//预览模式，0-正常预览，1-延迟预览
        public byte[] byStreamID = new byte[32];//流ID，lChannel为0xffffffff时启用此参数
        public byte byProtoType; //应用层取流协议，0-私有协议，1-RTSP协议
        public byte byRes1;
        public byte byVideoCodingType; //码流数据编解码类型 0-通用编码数据 1-热成像探测器产生的原始数据（温度数据的加密信息，通过去加密运算，将原始数据算出真实的温度值）
        public int dwDisplayBufNum; //播放库播放缓冲区最大缓冲帧数，范围1-50，置0时默认为1
        public byte byNPQMode;    //NPQ是直连模式，还是过流媒体 0-直连 1-过流媒体
        public byte[] byRes = new byte[215];
    }

    public static class NET_DVR_STREAM_INFO extends Structure {
        public int dwSize;
        public byte[] byID = new byte[32];
        public int dwChannel;
        public byte[] byRes = new byte[32];
    }

    //配置条件
    public static class NET_DVR_CLOUDSTORAGE_COND extends Structure {
        public int dwSize;
        public int dwChannel;
        public byte[] byRes1 = new byte[64];
    }

    public static class NET_DVR_STREAM_RECORD_STATUS extends Structure {
        public int dwSize;
        public byte byRecord;
        public byte byOffLineRecord;
        public byte[] byRes1 = new byte[2];
        public int dwRelatedHD;
        public byte[] byRes2 = new byte[8];
    }

    //SDK状态信息(9000新增)
    public static class NET_DVR_SDKSTATE extends Structure {
        public int dwTotalLoginNum;        //当前login用户数
        public int dwTotalRealPlayNum;    //当前realplay路数
        public int dwTotalPlayBackNum;    //当前回放或下载路数
        public int dwTotalAlarmChanNum;    //当前建立报警通道路数
        public int dwTotalFormatNum;        //当前硬盘格式化路数
        public int dwTotalFileSearchNum;    //当前日志或文件搜索路数
        public int dwTotalLogSearchNum;    //当前日志或文件搜索路数
        public int dwTotalSerialNum;        //当前透明通道路数
        public int dwTotalUpgradeNum;    //当前升级路数
        public int dwTotalVoiceComNum;    //当前语音转发路数
        public int dwTotalBroadCastNum;    //当前语音广播路数
        public int[] dwRes = new int[10];
    }

    //SDK功能支持信息(9000新增)
    public static class NET_DVR_SDKABL extends Structure {
        public int dwMaxLoginNum;        //最大login用户数 MAX_LOGIN_USERS
        public int dwMaxRealPlayNum;        //最大realplay路数 WATCH_NUM
        public int dwMaxPlayBackNum;        //最大回放或下载路数 WATCH_NUM
        public int dwMaxAlarmChanNum;    //最大建立报警通道路数 ALARM_NUM
        public int dwMaxFormatNum;        //最大硬盘格式化路数 SERVER_NUM
        public int dwMaxFileSearchNum;    //最大文件搜索路数 SERVER_NUM
        public int dwMaxLogSearchNum;    //最大日志搜索路数 SERVER_NUM
        public int dwMaxSerialNum;        //最大透明通道路数 SERVER_NUM
        public int dwMaxUpgradeNum;        //最大升级路数 SERVER_NUM
        public int dwMaxVoiceComNum;        //最大语音转发路数 SERVER_NUM
        public int dwMaxBroadCastNum;    //最大语音广播路数 MAX_CASTNUM
        public int[] dwRes = new int[10];
    }

    //报警设备信息
    public static class NET_DVR_ALARMER extends Structure {
        public byte byUserIDValid;                 /* userid是否有效 0-无效，1-有效 */
        public byte bySerialValid;                 /* 序列号是否有效 0-无效，1-有效 */
        public byte byVersionValid;                /* 版本号是否有效 0-无效，1-有效 */
        public byte byDeviceNameValid;             /* 设备名字是否有效 0-无效，1-有效 */
        public byte byMacAddrValid;                /* MAC地址是否有效 0-无效，1-有效 */
        public byte byLinkPortValid;               /* login端口是否有效 0-无效，1-有效 */
        public byte byDeviceIPValid;               /* 设备IP是否有效 0-无效，1-有效 */
        public byte bySocketIPValid;               /* socket ip是否有效 0-无效，1-有效 */
        public int lUserID;                       /* NET_DVR_Login()返回值, 布防时有效 */
        public byte[] sSerialNumber = new byte[SERIALNO_LEN];    /* 序列号 */
        public int dwDeviceVersion;                /* 版本信息 高16位表示主版本，低16位表示次版本*/
        public byte[] sDeviceName = new byte[NAME_LEN];            /* 设备名字 */
        public byte[] byMacAddr = new byte[MACADDR_LEN];        /* MAC地址 */
        public short wLinkPort;                     /* link port */
        public byte[] sDeviceIP = new byte[128];                /* IP地址 */
        public byte[] sSocketIP = new byte[128];                /* 报警主动上传时的socket IP地址 */
        public byte byIpProtocol;                  /* Ip协议 0-IPV4, 1-IPV6 */
        public byte[] byRes2 = new byte[11];


    }

    //硬解码显示区域参数(子结构)
    public static class NET_DVR_DISPLAY_PARA extends Structure {
        public int bToScreen;
        public int bToVideoOut;
        public int nLeft;
        public int nTop;
        public int nWidth;
        public int nHeight;
        public int nReserved;
    }

    //硬解码预览参数
    public static class NET_DVR_CARDINFO extends Structure {
        public int lChannel;//通道号
        public int lLinkMode; //最高位(31)为0表示主码流，为1表示子，0－30位表示码流连接方式:0：TCP方式,1：UDP方式,2：多播方式,3 - RTP方式，4-电话线，5－128k宽带，6－256k宽带，7－384k宽带，8－512k宽带；
        public String sMultiCastIP;
        public NET_DVR_DISPLAY_PARA struDisplayPara;
    }

    //录象文件参数
    public static class NET_DVR_FIND_DATA extends Structure {
        public byte[] sFileName = new byte[100];//文件名
        public NET_DVR_TIME struStartTime;//文件的开始时间
        public NET_DVR_TIME struStopTime;//文件的结束时间
        public int dwFileSize;//文件的大小
    }

    //录象文件参数(9000)
    public static class NET_DVR_FINDDATA_V30 extends Structure {
        public byte[] sFileName = new byte[100];//文件名
        public NET_DVR_TIME struStartTime;//文件的开始时间
        public NET_DVR_TIME struStopTime;//文件的结束时间
        public int dwFileSize;//文件的大小
        public byte[] sCardNum = new byte[32];
        public byte byLocked;//9000设备支持,1表示此文件已经被锁定,0表示正常的文件
        public byte[] byRes = new byte[3];
    }

    //录象文件参数(带卡号)
    public static class NET_DVR_FINDDATA_CARD extends Structure {
        public byte[] sFileName = new byte[100];//文件名
        public NET_DVR_TIME struStartTime;//文件的开始时间
        public NET_DVR_TIME struStopTime;//文件的结束时间
        public int dwFileSize;//文件的大小
        public byte[] sCardNum = new byte[32];
    }

    public static class NET_DVR_FILECOND_V40 extends Structure {
        public int lChannel;
        public int dwFileType;
        public int dwIsLocked;
        public int dwUseCardNo;//是否带ATM信息进行查询：0-不带ATM信息，1-按交易卡号查询，2-按交易类型查询，3-按交易金额查询，4-按卡号、交易类型及交易金额的组合查询 5-按课程名称查找，此时卡号表示课程名称
        public byte[] sCardNumber = new byte[CARDNUM_LEN_OUT];
        public NET_DVR_TIME struStartTime = new NET_DVR_TIME();
        public NET_DVR_TIME struStopTime = new NET_DVR_TIME();
        public byte byDrawFrame; //0:不抽帧，1：抽帧
        public byte byFindType; //0:查询普通卷，1：查询存档卷
        public byte byQuickSearch; //0:普通查询，1：快速（日历）查询
        public byte bySpecialFindInfoType;    //专有查询条件类型 0-无效， 1-带ATM查询条件
        public int dwVolumeNum;  //存档卷号
        public byte[] byWorkingDeviceGUID = new byte[GUID_LEN];    //工作机GUID，通过获取N+1得到
        public NET_DVR_SPECIAL_FINDINFO_UNION uSpecialFindInfo = new NET_DVR_SPECIAL_FINDINFO_UNION();   //专有查询条件
        public byte byStreamType;    //0-同一个时间段只返回一种录像，优先级顺序为：主码流、子码流、三码流，1-子码流，2-三码流，3-主码流，254-双码流搜索(优先返回主码流录像，没有主码流录像时返回子码流录像)
        public byte byAudioFile;                //音频文件 0-非音频文件，1-音频文件
        public byte[] byRes2 = new byte[30];    //保留
    }

    public static class NET_DVR_SPECIAL_FINDINFO_UNION extends Union {
        public byte[] byLenth = new byte[8];
        public NET_DVR_ATMFINDINFO struATMFindInfo = new NET_DVR_ATMFINDINFO();           //ATM查询
    }

    public static class NET_DVR_ATMFINDINFO extends Structure {
        public byte byTransactionType;       //交易类型 0-全部，1-查询， 2-取款， 3-存款， 4-修改密码，5-转账， 6-无卡查询 7-无卡存款， 8-吞钞 9-吞卡 10-自定义
        public byte[] byRes = new byte[3];    //保留
        public int dwTransationAmount;     //交易金额 ;
    }

    //录像文件查找条件结构V50
    public static class NET_DVR_FILECOND_V50 extends Structure {
        public NET_DVR_STREAM_INFO struStreamID; //流ID或通道号
        public NET_DVR_TIME_SEARCH_COND struStartTime = new NET_DVR_TIME_SEARCH_COND(); //开始时间
        public NET_DVR_TIME_SEARCH_COND struStopTime = new NET_DVR_TIME_SEARCH_COND(); //结束时间
        public byte byFindType; //0-查询普通卷，1-查询存档卷 2-查询N+1录像文件
        public byte byDrawFrame; //是否抽帧 0-不抽帧 1-抽帧
        public byte byQuickSearch; //0-普通查询，1-快速（日历）查询
        public byte byStreamType; //0-主码流，1-子码流，2-3码流，0xff-全部
        public int dwFileType; // 文件类型
        public int dwVolumeNum; //存档卷号，byFindType为1时有效
        public byte byIsLocked; //是否锁定 0-正常文件,1-锁定文件, 0xff表示所有文件
        public byte byNeedCard; //是否需要查询卡，0-不需要 1-需要
        public byte byOnlyAudioFile;        //音频文件 0-视频文件 1-音频文件
        public byte bySpecialFindInfoType; //0-无效， 1-带ATM查询条件
        public byte[] szCardNum = new byte[32];  //卡号，byNeedCard为1时有效
        public byte[] szWorkingDeviceGUID = new byte[16]; //工作机GUID，通过获取N+1得到，byFindType为2时有效
        public NET_DVR_SPECIAL_FINDINFO_UNION uSpecialFindInfo = new NET_DVR_SPECIAL_FINDINFO_UNION(); //专有查询条件联合体
        public int dwTimeout; //查找超时时间（指定NET_DVR_FindNextFile_V30/NET_DVR_FindNextFile_V40/NET_DVR_FindNextFile_V50接口的超时时间返回）；单位：毫秒，不填写（默认为0时），接口行为跟以前一样 ;有效值：0, [5000 – 15000]
        public byte[] byRes = new byte[252];
    }

    public static class NET_DVR_FINDDATA_V40 extends Structure {
        public byte[] sFileName = new byte[100];//文件名
        public NET_DVR_TIME struStartTime = new NET_DVR_TIME();//文件的开始时间
        public NET_DVR_TIME struStopTime = new NET_DVR_TIME();//文件的结束时间
        public int dwFileSize;//文件的大小
        public byte[] sCardNum = new byte[32];
        public byte byLocked;//9000设备支持,1表示此文件已经被锁定,0表示正常的文件
        public byte byFileType;  //文件类型:0－定时录像,1-移动侦测 ，2－报警触发，
        //3-报警|移动侦测 4-报警&移动侦测 5-命令触发 6-手动录像,7－震动报警，8-环境报警，9-智能报警，10-PIR报警，11-无线报警，12-呼救报警,14-智能交通事件
        public byte byQuickSearch; //0:普通查询结果，1：快速（日历）查询结果
        public byte byRes;
        public int dwFileIndex; //文件索引号
        public byte byStreamType;
        public byte[] byRes1 = new byte[127];
    }

    public static class NET_DVR_TIME_SEARCH extends Structure {
        public short wYear;        //年，设备OSD时间
        public byte byMonth;        //月，设备OSD时间
        public byte byDay;        //日，设备OSD时间
        public byte byHour;        //时，设备OSD时间
        public byte byMinute;    //分，设备OSD时间
        public byte bySecond;    //秒，设备OSD时间
        public byte cTimeDifferenceH;        //与国际标准时间的时差（小时），-12 ... +14
        public byte cTimeDifferenceM;        //与国际标准时间的时差（分钟），-30, 0, 30, 45
        public byte byLocalOrUTC;      //0-时差无效，设备本地时间，即设备OSD时间  1-时差有效
        public short wMillisecond;      //毫秒，精度不够，默认为0
    }

    public static class NET_DVR_ADDRESS extends Structure {
        public NET_DVR_IPADDR struIP = new NET_DVR_IPADDR(); //IP地址
        public short wPort;    //端口号
        public byte[] byRes = new byte[2];
    }

    public static class NET_DVR_FINDDATA_V50 extends Structure {
        public byte[] sFileName = new byte[100];
        public NET_DVR_TIME_SEARCH struStartTime = new NET_DVR_TIME_SEARCH();
        public NET_DVR_TIME_SEARCH struStopTime = new NET_DVR_TIME_SEARCH();
        public NET_DVR_ADDRESS struAddr = new NET_DVR_ADDRESS(); //片段所在的地址信息，集群回放时用到
        public int dwFileSize; //文件大小
        public byte byLocked; //文件是否被锁定，1－文件已锁定；0－文件未锁定
        public byte byFileType; //文件类型，与V40相同
        public byte byQuickSearch; //0- 普通查询结果，1- 快速（日历）查询结果
        public byte byStreamType; //码流类型：0- 主码流，1- 子码流，2- 码流三
        public int dwFileIndex; //文件索引号
        public byte[] sCardNum = new byte[32]; //卡号
        public int dwTotalLenH; // 对于大文件搜索，时间段内数据总长度，高32字节
        public int dwTotalLenL; // 对于大文件搜索，时间段内数据总长度，低32字节
        public byte byBigFileType;  // 0为普通片段搜索，1为大文件搜索
        public byte[] byRes = new byte[247];
    }

    public static class NET_DVR_FILECOND extends Structure //录象文件查找条件结构
    {
        public int lChannel;//通道号
        public int dwFileType;//录象文件类型0xff－全部，0－定时录像,1-移动侦测 ，2－报警触发，3-报警|移动侦测 4-报警&移动侦测 5-命令触发 6-手动录像
        public int dwIsLocked;//是否锁定 0-正常文件,1-锁定文件, 0xff表示所有文件
        public int dwUseCardNo;//是否使用卡号
        public byte[] sCardNumber = new byte[32];//卡号
        public NET_DVR_TIME struStartTime;//开始时间
        public NET_DVR_TIME struStopTime;//结束时间
    }

    public static class NET_DVR_PLAYCOND extends Structure //回放或者下载信息结构体
    {
        public int dwChannel;//通道号
        public NET_DVR_TIME struStartTime;
        public NET_DVR_TIME struStopTime;
        public byte byDrawFrame;  //0:不抽帧，1：抽帧
        public byte byStreamType; //码流类型，0-主码流 1-子码流 2-码流三
        public byte[] byStreamID = new byte[STREAM_ID_LEN];
        public byte[] byRes = new byte[30];//保留
    }

    public static class NET_DVR_VOD_PARA extends Structure //回放或者下载信息结构体
    {
        public int dwSize;
        public NET_DVR_STREAM_INFO struIDInfo;
        public NET_DVR_TIME struBeginTime;
        public NET_DVR_TIME struEndTime;
        public HWND hWnd;
        public byte byDrawFrame; //0:不抽帧，1：抽帧
        public byte byVolumeType;  //0-普通录像卷  1-存档卷
        public byte byVolumeNum;  //卷号，目前指存档卷号
        public byte byStreamType;   //码流类型 0-主码流， 1-子码流，2-码流三
        public int dwFileIndex;      //存档卷上的录像文件索引，搜索存档卷录像时返回的值
        public byte byAudioFile;    //音频文件0-否，1-是
        public byte byCourseFile;    //课程文件0-否，1-是
        public byte byDownload;    //是否下载 0-否，1-是
        public byte byOptimalStreamType;    //是否按最优码流类型回放 0-否，1-是（对于双码流设备，某一段时间内的录像文件与指定码流类型不同，则返回实际码流类型的录像）
        public byte[] byRes2 = new byte[20];
    }

    //图片查找条件
    public static class NET_DVR_FIND_PICTURE_PARAM extends Structure {
        public int dwSize;         // 结构体大小
        public int lChannel;       // 通道号
        public byte byFileType;   //图片查找类型
        public byte byNeedCard;     // 是否需要卡号
        /*
                           0-保留，1-澳，2-京，3-渝，4-闽，5-甘，6-粤，7-桂，
                           8-贵，9-琼，10-冀，11-豫，12-黑，13-鄂，14-湘，
                           15-吉，16-苏，17-赣，18-辽，19-蒙，20-宁，21-青，
                           22-鲁，23-晋，24-陕，25-沪，26-川，27-台，28-津，
                           29-藏，30-港，31-新，32-云，33-浙，34-皖，0xff-全部
                           */
        public byte byProvince;     //省份索引值
        public byte byEventType;      // 事件类型：0保留，1-交通事件；2-违章取证；3-其他事件
        public byte[] sCardNum = new byte[CARDNUM_LEN_V30];     // 卡号
        public NET_DVR_TIME struStartTime = new NET_DVR_TIME();//查找图片的开始时间
        public NET_DVR_TIME struStopTime = new NET_DVR_TIME();// 查找图片的结束时间
        //ITC3.7 新增
        public int dwTrafficType; //图片检索生效项 参考 VCA_OPERATE _TYPE
        public int dwVehicleType; //车辆类型 参考 VCA_VEHICLE_TYPE
        //违规检测类型参考 VCA_ILLEGAL_TYPE 当前不支持复选
        public int dwIllegalType;
        public byte byLaneNo;  //车道号(1~99)
        public byte bySubHvtType;//0-保留,1-机动车(机动车子类型中支持车牌检索，省份检索),2-非机动车,3-行人
        public byte[] byRes2 = new byte[2];
        public byte[] sLicense = new byte[MAX_LICENSE_LEN/*16*/];    //车牌号码
        public byte byRegion;     // 区域索引值 0-保留，1-欧洲(Europe Region)，2-俄语区域(Russian Region)，3-欧洲&俄罗斯(EU&CIS), 4-中东(Middle East),0xff-所有
        public byte byCountry;     // 国家索引值，参照：COUNTRY_INDEX
        public byte byArea;  //地区
        public byte byISO8601;  //是否是8601的时间格式，即时差字段是否有效0-时差无效，年月日时分秒为设备本地时间 1-时差有效
        public byte cStartTimeDifferenceH;   //开始时间与UTC的时差（小时），-12 ... +14， 正数表示东时区
        public byte cStartTimeDifferenceM;   //开始时间与UTC的时差（分钟），-30, 0, 30, 45，正数表示东时区
        public byte cStopTimeDifferenceH;    //结束时间与UTC的时差（小时），-12 ... +14，正数表示东时区
        public byte cStopTimeDifferenceM;    //结束时间与UTC的时差（分钟），-30, 0, 30, 45，正数表示东时区
    }

    public class NET_DVR_FIND_PICTURE_V50 extends Structure {
        public byte[] sFileName = new byte[PICTURE_NAME_LEN];//图片名
        public NET_DVR_TIME struTime = new NET_DVR_TIME();//图片的时间
        public int dwFileSize;//图片的大小
        public byte[] sCardNum = new byte[CARDNUM_LEN_V30];    //卡号
        public byte byPlateColor;//参考结构 VCA_PLATE_COLOR
        public byte byVehicleLogo;//参考结构 VLR_VEHICLE_CLASS
        public byte byFileType;  //文件类型， :0定时抓图1 移动侦测抓图 2 报警抓图3  报警 | 移动侦测抓图 4 报警 & 移动侦测抓图     6 手动抓图 ,9-智能图片,10- PIR报警，11- 无线报警，12- 呼救报警,    0xa 预览时截图，0xd 人脸侦测, 0xe 越界侦测，0xf 入侵区域侦测，0x10 场景变更侦测, 0x11-设备本地回放时截图, 0x12-智能侦测
        public byte byRecogResult;//识别结果参考结构VTR_RESULT
        public byte[] sLicense = new byte[MAX_LICENSE_LEN/*16*/];    //车牌号码
        public byte byEventSearchStatus; //连续图片表示同一查找结果的时候，0-表示后面没有图片信息，1-表示后面还有图片信息。总共图片信息包括最后一张状态为0的图片。
        public NET_DVR_ADDRESS struAddr;        //图片所在的地址信息，图片下载时用到
        public byte[] byRes = new byte[256];        //  保留字节
        public NET_DVR_PIC_EXTRA_INFO_UNION uPicExtraInfo; //图片附件信息
    }

    public class NET_DVR_PIC_PARAM extends Structure {
        public Pointer pDVRFileName;
        public Pointer pSavedFileBuf;
        public int dwBufLen;
        public IntByReference lpdwRetLen;
        public NET_DVR_ADDRESS struAddr;
        public byte[] byRes = new byte[256];
    }

    //查找结果结构体
    public static class NET_DVR_FIND_PICTURE_V40 extends Structure {
        public byte[] sFileName = new byte[PICTURE_NAME_LEN];//图片名
        public NET_DVR_TIME struTime = new NET_DVR_TIME();//图片的时间
        public int dwFileSize;//图片的大小
        public byte[] sCardNum = new byte[CARDNUM_LEN_V30];    //卡号
        public byte byPlateColor;//参考结构 VCA_PLATE_COLOR
        public byte byVehicleLogo;//参考结构 VLR_VEHICLE_CLASS
        public byte byFileType;  //文件类型， :0定时抓图1 移动侦测抓图 2 报警抓图3  报警 | 移动侦测抓图 4 报警 & 移动侦测抓图     6 手动抓图 ,9-智能图片,10- PIR报警，11- 无线报警，12- 呼救报警,    0xa 预览时截图，0xd 人脸侦测, 0xe 越界侦测，0xf 入侵区域侦测，0x10 场景变更侦测, 0x11-设备本地回放时截图, 0x12-智能侦测, 0x32-防区报警, 0x33-紧急求助, 0x34-业务咨询
        public byte byRecogResult;//识别结果参考结构VTR_RESULT
        public byte[] sLicense = new byte[MAX_LICENSE_LEN/*16*/];    //车牌号码
        public byte byEventSearchStatus; //连续图片表示同一查找结果的时候，0-表示后面没有图片信息，1-表示后面还有图片信息。总共图片信息包括最后一张状态为0的图片。
        public byte[] byRes = new byte[75];        //  保留字节
        public NET_DVR_PIC_EXTRA_INFO_UNION uPicExtraInfo; //图片附件信息
    }

    public static class NET_DVR_FACE_EXTRA_INFO extends Union {
        public NET_VCA_RECT[] struVcaRect = new NET_VCA_RECT[MAX_FACE_PIC_NUM];  //人脸子图坐标信息
        public byte[] byRes = new byte[64];
    }

    //图片附件信息联合体
    public static class NET_DVR_PIC_EXTRA_INFO_UNION extends Union {
        public byte[] byUnionLen = new byte[544];   //联合体长度，无实际意义
        public NET_DVR_FACE_EXTRA_INFO struFaceExtraInfo;   //人脸侦测信息
    }

    public static class NET_DVR_PACKET_INFO_EX extends Union {
        public short wWidth;         //width
        public short wHeight;        //height
        public int dwTimeStamp;    //lower time stamp
        public int dwTimeStampHigh;//higher time stamp
        public int dwYear;            //year
        public int dwMonth;         //month
        public int dwDay;           //day
        public int dwHour;          //hour
        public int dwMinute;        //minute
        public int dwSecond;        //second
        public int dwMillisecond;   //millisecond
        public int dwFrameNum;     //frame num
        public int dwFrameRate;    //frame rate,当帧率小于0时，0x80000002:表示1/2帧率，同理可推0x80000010为1/16帧率
        public int dwFlag;         //flag E帧标记
        public int dwFilePos;      //file pos
        public int dwPacketType;    //Packet type:0 -file head，1 -video I frame，2- video B frame， 3- video P frame， 10- audio packet， 11- private packet
        public int dwPacketSize;   //packet size
        public Pointer pPacketBuffer;  //packet buffer
        public byte[] byRes1 = new byte[4];
        public int dwPacketMode;   //打包方式:0-保留，1-FU_A打包方式
        public byte[] byRes2 = new byte[16];
        public int[] dwReserved = new int[6];    //reserved[0] 表示私有数据类型
    }

    //云台区域选择放大缩小(HIK 快球专用)
    public static class NET_DVR_POINT_FRAME extends Structure {
        public int xTop;     //方框起始点的x坐标
        public int yTop;     //方框结束点的y坐标
        public int xBottom;  //方框结束点的x坐标
        public int yBottom;  //方框结束点的y坐标
        public int bCounter; //保留
    }

    //语音对讲参数
    public static class NET_DVR_COMPRESSION_AUDIO extends Structure {
        public byte byAudioEncType;   //音频编码类型 0-G722; 1-G711
        public byte[] byres = new byte[7];//这里保留音频的压缩参数
    }

    public static class NET_DVR_AUDIODEC_INFO extends Structure {
        public int nchans;                         /* 声道数 */
        public int sample_rate;                  /* 采样率 */
        public int aacdec_profile;               /* 编码用的框架 */
        public int[] reserved = new int[16];                 /* 保留 */
    }

    //音频解码
    public static class NET_DVR_AUDIODEC_PROCESS_PARAM extends Structure {
        public Pointer in_buf;                      /* 输入数据buf */
        public Pointer out_buf;                     /* 输出数据buf */
        public int in_data_size;                 /* 输入in_buf内数据byte数 */
        public int proc_data_size;               /* 输出解码库处理in_buf中数据大小bytes */
        public int out_frame_size;               /* 解码一帧后数据BYTE数 */
        public NET_DVR_AUDIODEC_INFO dec_info = new NET_DVR_AUDIODEC_INFO();                     /* 输出解码信息 */
        public int g726dec_reset;                /* 重置开关 */
        public int g711_type;                    /* g711编码类型,0 - U law, 1- A law */
        public int[] reserved = new int[16];                 /* 保留 */
    }

    public static class NET_DVR_AUDIOENC_INFO extends Structure {
        public int in_frame_size;                /* 输入一帧数据大小(BYTES)，由GetInfoParam函数返回         */
        public int[] reserved = new int[16];                 /* 保留 */
    }

    //音频编码
    public static class NET_DVR_AUDIOENC_PROCESS_PARAM extends Structure {
        public Pointer in_buf;                      /* 输入buf */
        public Pointer out_buf;                     /* 输出buf */
        public int out_frame_size;               /* 编码一帧后的BYTE数 */
        public int g726enc_reset;                /* 重置开关 */
        public int g711_type;                    /* g711编码类型,0 - U law, 1- A law */
        public int enc_mode;                     /* 音频编码模式，AMR编码配置 */
        public int[] reserved = new int[16];                 /* 保留 */
    }

    //用于接收报警信息的缓存区
    public static class RECV_ALARM extends Structure {
        public byte[] RecvBuffer = new byte[4000];//此处的400应不小于最大报警报文长度
    }

    //布防参数
    public static class NET_DVR_SETUPALARM_PARAM extends Structure {
        public int dwSize;
        public byte byLevel; //布防优先级，0-一等级（高），1-二等级（中），2-三等级（低）
        public byte byAlarmInfoType; //上传报警信息类型（抓拍机支持），0-老报警信息（NET_DVR_PLATE_RESULT），1-新报警信息(NET_ITS_PLATE_RESULT)2012-9-28
        public byte byRetAlarmTypeV40; //0--返回NET_DVR_ALARMINFO_V30或NET_DVR_ALARMINFO, 1--设备支持NET_DVR_ALARMINFO_V40则返回NET_DVR_ALARMINFO_V40，不支持则返回NET_DVR_ALARMINFO_V30或NET_DVR_ALARMINFO
        public byte byRetDevInfoVersion; //CVR上传报警信息回调结构体版本号 0-COMM_ALARM_DEVICE， 1-COMM_ALARM_DEVICE_V40
        public byte byRetVQDAlarmType; //VQD报警上传类型，0-上传报报警NET_DVR_VQD_DIAGNOSE_INFO，1-上传报警NET_DVR_VQD_ALARM
        public byte byFaceAlarmDetection;
        public byte bySupport;
        public byte byBrokenNetHttp;
        public short wTaskNo;    //任务处理号 和 (上传数据NET_DVR_VEHICLE_RECOG_RESULT中的字段dwTaskNo对应 同时 下发任务结构 NET_DVR_VEHICLE_RECOG_COND中的字段dwTaskNo对应)
        public byte byDeployType;    //布防类型：0-客户端布防，1-实时布防
        public byte[] byRes1 = new byte[3];
        public byte byAlarmTypeURL;//bit0-表示人脸抓拍报警上传（INTER_FACESNAP_RESULT）；0-表示二进制传输，1-表示URL传输（设备支持的情况下，设备支持能力根据具体报警能力集判断,同时设备需要支持URL的相关服务，当前是”云存储“）
        public byte byCustomCtrl;//Bit0- 表示支持副驾驶人脸子图上传: 0-不上传,1-上传,(注：只在公司内部8600/8200等平台开放)


    }


    //区域框参数
    public static class NET_VCA_RECT extends Structure {
        public float fX;
        public float fY;
        public float fWidth;
        public float fHeight;
    }

    //报警目标信息
    public static class NET_VCA_TARGET_INFO extends Structure {
        public int dwID;
        public NET_VCA_RECT struRect;
        public byte[] byRes = new byte[4];
    }

    //前端设备信息
    public static class NET_VCA_DEV_INFO extends Structure {
        public NET_DVR_IPADDR struDevIP;
        public short wPort;
        public byte byChannel;
        public byte byIvmsChannel;
    }

    //事件规则信息
    public static class NET_VCA_RULE_INFO extends Structure {
        public byte byRuleID;
        public byte byRes;
        public short wEventTypeEx;
        public byte[] byRuleName = new byte[NAME_LEN];
        public int dwEventType;
        public NET_VCA_EVENT_UNION uEventParam;

        public void read() {
            super.read();
            switch (wEventTypeEx) {
                case 1:
                    uEventParam.setType(NET_VCA_TRAVERSE_PLANE.class);
                    break;
                case 2:
                case 3:
                    uEventParam.setType(NET_VCA_AREA.class);
                    break;
                default:
                    break;
            }
            uEventParam.read();
        }

        public void write() {
            super.write();
            uEventParam.write();
        }

    }

    //警戒规则参数联合体
    public static class NET_VCA_EVENT_UNION extends Union {
        public int[] uLen = new int[23];
        public NET_VCA_TRAVERSE_PLANE struTraversePlane;
        public NET_VCA_AREA struArea;
    }

    //穿越警戒面参数
    public static class NET_VCA_TRAVERSE_PLANE extends Structure {
        public NET_VCA_LINE struPlaneBottom;
        public int dwCrossDirection;
        public byte bySensitivity;
        public byte byPlaneHeight;
        public byte byDetectionTarget;/*检测目标：0- 所有目标，1- 人，2- 车   */
        public byte[] byRes2 = new byte[37];
    }

    public static class NET_DVR_HANDLEEXCEPTION_V40 extends Structure {
        public int dwHandleType;/*处理方式，各种异常处理方式的"或"结果，异常处理方式：
                                    0x00: 无响应    0x01: 监视器上警告  0x02: 声音警告  0x04: 上传中心
                                    0x08: 触发报警输出  0x10: Jpeg抓图并上传EMail
                                    0x20: 无线声光报警器联动    0x40: 联动电子地图(目前仅PCNVR支持)
                                    0x200：抓图并上传ftp    0x400: 虚焦侦测联动聚焦
                                    0x800: PTZ联动跟踪(球机跟踪目标)
                                    E.g. dwHandleType==0x01|0x04 表示配置报警发生时联动监视器上警告并且将报警信息上传中心。 */
        public int dwMaxRelAlarmOutChanNum;/*设备最大支持的触发报警输出通道数（只读） */
        public int dwRelAlarmOutChanNum;/*已配置的触发的报警输出通道个数，决定dwRelAlarmOut取前多少个数组下标 */
        public int[] dwRelAlarmOut = new int[MAX_CHANNUM_V30];/*触发报警输出通道，取数组前dwRelAlarmOutChanNum个值，
                                        其值表示报警输出通道号(从1开始)，初始值是0xfffffffff(不关联通道)。
                                        例如，dwRelAlarmOutChanNum=5，则可以配置触发报警输出通道dwRelAlarmOut[0]~dwRelAlarmOut[4]。 */
        public byte[] byRes = new byte[64]; /*保留，置为0 */
    }

    public static final int MAX_ALERTLINE_NUM = 8;

    public static class NET_VCA_TRAVERSE_PLANE_DETECTION extends Structure {
        public int dwSize;
        public byte byEnable;//使能
        public byte byEnableDualVca;// 启用支持智能后检索 0-不启用，1-启用
        public byte[] byRes1 = new byte[2];
        public NET_VCA_TRAVERSE_PLANE[] struAlertParam = new NET_VCA_TRAVERSE_PLANE[MAX_ALERTLINE_NUM];  //警戒线参数
        public NET_DVR_SCHEDTIMEWEEK[] struAlarmSched = new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS];
        public NET_DVR_HANDLEEXCEPTION_V40 struHandleException;  //异常处理方式
        public int dwMaxRelRecordChanNum;  //报警触发的录象通道 数（只读）最大支持数量
        public int dwRelRecordChanNum;     //报警触发的录象通道 数 实际支持的数量
        public int[] byRelRecordChan = new int[MAX_CHANNUM_V30];//触发录像的通道号
        public NET_DVR_SCHEDTIME[] struHolidayTime = new NET_DVR_SCHEDTIME[MAX_TIMESEGMENT_V30]; //假日布防时间
        public byte[] byRes2 = new byte[100];
    }

    public static class NET_VCA_INTRUSION extends Structure {
        public NET_VCA_POLYGON struRegion;//区域范围
        public short wDuration;            //行为事件触发时间阈值: 1-120秒，建议5秒，判断是有效报警的时间  在ATM系统中触发文件阈值为 1-1000秒
        public byte bySensitivity;        //灵敏度参数，范围[1-100]
        public byte byRate;               //占比：区域内所有未报警目标尺寸目标占区域面积的比重，归一化为－；
        /*
    检测目标，可支持多选，具体定义为：
    0~所有目标（表示不锁定检测目标，所有目标都将进行检测）
    0x01 ~ 人，
    0x02 ~ 车，
    0x04 ~ 其他
    */
        public byte byDetectionTarget;
        public byte byPriority;//优先级,0~低,1~中,2~高
        public byte[] byRes = new byte[2];             //保留
    }

    public static final int MAX_INTRUSIONREGION_NUM = 8; //最大区域数数

    public static class NET_VCA_FIELDDETECION extends Structure {
        public int dwSize;
        public byte byEnable; //使能，是否开启
        public byte byEnableDualVca;// 启用支持智能后检索 0-不启用，1-启用
        public byte byEnableHumanMisinfoFilter;// 启用人体去误报 0-不启用，1-启用
        public byte byEnableVehicleMisinfoFilter;// 启用车辆去误报 0-不启用，1-启用
        public NET_VCA_INTRUSION[] struIntrusion = new NET_VCA_INTRUSION[MAX_INTRUSIONREGION_NUM];//每个区域的参数设置
        public NET_DVR_SCHEDTIMEWEEK[] struAlarmSched = new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS]; //布防时间
        public NET_DVR_HANDLEEXCEPTION_V40 struHandleException;  //异常处理方式
        public int dwMaxRelRecordChanNum;  //报警触发的录象通道 数（只读）最大支持数量
        public int dwRelRecordChanNum;     //报警触发的录象通道 数 实际支持的数量
        public int[] byRelRecordChan = new int[MAX_CHANNUM_V30];//触发录像通道
        public NET_DVR_SCHEDTIME[] struHolidayTime = new NET_DVR_SCHEDTIME[MAX_TIMESEGMENT_V30]; //假日布防时间
        public byte[] byRes2 = new byte[100];
    }

    public static class NET_DVR_CHANNEL_GROUP extends Structure {
        public int dwSize;
        public int dwChannel;
        public int dwGroup;
        public byte byID;
        public byte[] byRes1 = new byte[3];
        public int dwPositionNo;
        public byte[] byRes = new byte[56];
    }

    //线结构参数
    public static class NET_VCA_LINE extends Structure {
        public NET_VCA_POINT struStart;
        public NET_VCA_POINT struEnd;
    }

    //点坐标参数
    public static class NET_VCA_POINT extends Structure {
        public float fX;
        public float fY;


    }

    //进入/离开区域参数
    public static class NET_VCA_AREA extends Structure {
        public NET_VCA_POLYGON struRegion;
        public byte[] byRes = new byte[8];
    }

    //多边形结构体
    public static class NET_VCA_POLYGON extends Structure {
        public int dwPointNum;
        public NET_VCA_POINT[] struPos = new NET_VCA_POINT[VCA_MAX_POLYGON_POINT_NUM];
    }

    public static class NET_VCA_SIZE_FILTER extends Structure {
        public byte byActive;            //是否激活尺寸过滤器 0-否 非0-是
        public byte byMode;         //过滤器模式SIZE_FILTER_MODE
        public byte[] byRes = new byte[2];        //保留，置0
        public NET_VCA_RECT struMiniRect;    //最小目标框,全0表示不设置
        public NET_VCA_RECT struMaxRect;      //最大目标框,全0表示不设置
    }


    //尺寸过滤策略
    public static class NET_VCA_FILTER_STRATEGY extends Structure {
        public byte byStrategy;      //尺寸过滤策略 0 - 不启用 1-高度和宽度过滤,2-面积过滤
        public byte[] byRes = new byte[11];       //保留
    }

    //行为分析报警
    public static class NET_VCA_RULE_ALARM extends Structure {
        public int dwSize;
        public int dwRelativeTime;
        public int dwAbsTime;
        public NET_VCA_RULE_INFO struRuleInfo;
        public NET_VCA_TARGET_INFO struTargetInfo;
        public NET_VCA_DEV_INFO struDevInfo;
        public int dwPicDataLen;
        public byte byPicType;
        public byte byRelAlarmPicNum; //关联通道报警图片数量
        public byte bySmart;//IDS设备返回0(默认值)，Smart Functiom Return 1
        public byte byPicTransType;        //图片数据传输方式: 0-二进制；1-url
        public int dwAlarmID;     //报警ID，用以标识通道间关联产生的组合报警，0表示无效
        public short wDevInfoIvmsChannelEx;     //与NET_VCA_DEV_INFO里的byIvmsChannel含义相同，能表示更大的值。老客户端用byIvmsChannel能继续兼容，但是最大到255。新客户端版本请使用wDevInfoIvmsChannelEx。
        public byte byRelativeTimeFlag;      //dwRelativeTime字段是否有效  0-无效， 1-有效，dwRelativeTime表示UTC时间
        public byte byAppendInfoUploadEnabled; //附加信息上传使能 0-不上传 1-上传
        public Pointer pAppendInfo;     //指向附加信息NET_VCA_APPEND_INFO的指针，byAppendInfoUploadEnabled为1时或者byTimeDiffFlag为1时有效
        public Pointer pImage;
    }

    public static class NET_DVR_SYSTEM_TIME extends Structure {
        public short wYear;           //年
        public short wMonth;          //月
        public short wDay;            //日
        public short wHour;           //时
        public short wMinute;      //分
        public short wSecond;      //秒
        public short wMilliSec;    //毫秒
        public byte[] byRes = new byte[2];
    }

    //设备支持AI开放平台接入，上传视频检测数据
    public static class NET_AIOP_VIDEO_HEAD extends Structure {
        public int dwSize;      //dwSize = sizeof(NET_AIOP_VIDEO_HEAD)
        public int dwChannel;    //设备分析通道的通道号；
        public NET_DVR_SYSTEM_TIME struTime = new NET_DVR_SYSTEM_TIME();    //时间
        public byte[] szTaskID = new byte[64];     //视频任务ID，来自于视频任务派发
        public int dwAIOPDataSize;   //对应AIOPDdata数据长度
        public int dwPictureSize;    //对应分析图片长度
        public byte[] szMPID = new byte[64];        //检测模型包ID，用于匹配AIOP的检测数据解析；可以通过URI(GET /ISAPI/Intelligent/AIOpenPlatform/algorithmModel/management?format=json)获取当前设备加载的模型包的label description信息；
        public Pointer pBufferAIOPData;  //AIOPDdata数据
        public Pointer pBufferPicture;//对应分析图片数据
        public byte byPictureMode;//图片数据传输模式 0-二进制，1-武汉云云存储，当byPictureMode为0时pBufferPicture为二进制数据，当byPictureMode为1时pBufferPicture为武汉云URL
        public byte[] byRes2 = new byte[3];//保留字节
        public int dwPresetIndex; //预置点序号
        public byte[] byRes = new byte[176];
    }

    //设备支持AI开放平台接入，上传图片检测数据
    public static class NET_AIOP_PICTURE_HEAD extends Structure {
        public int dwSize;           //dwSize = sizeof(NET_AIOP_PICTURE_HEAD)
        public NET_DVR_SYSTEM_TIME struTime = new NET_DVR_SYSTEM_TIME();    //时间
        public byte[] szPID = new byte[64];        //透传下发的图片ID，来自于图片任务派发
        public int dwAIOPDataSize;   //对应AIOPDdata数据长度
        public byte byStatus;         //状态值：0-成功，1-图片大小错误
        public byte[] byRes1 = new byte[3];
        public byte[] szMPID = new byte[64]; //检测模型包ID，用于匹配AIOP的检测数据解析；
        public Pointer pBufferAIOPData;//AIOPDdata数据
        public int dwPresetIndex; //预置点序号
        public byte[] byRes = new byte[180];
    }

    public static class NET_DVR_AI_PICTUR_UPLOAD extends Structure {
        public int dwSize;
        public byte[] szTaskID = new byte[64];   //任务id，strlen.max = 64,业务平台统一维护管理
        public byte[] szPID = new byte[64];   //图片id，strlen.max = 64，业务平台统一维护管理
        public byte[] byRes = new byte[128];
    }

    //规则触发参数
    public static class NET_VCA_RULE_TRIGGER_PARAM extends Structure {
        public byte byTriggerMode;   //规则的触发方式，0- 不启用，1- 轨迹点 2- 目标面积
        public byte byTriggerPoint;  //触发点，触发方式为轨迹点时有效 0- 中,1-上,2-下
        public byte[] byRes1 = new byte[2];       //保留
        public float fTriggerArea;    //触发目标面积百分比 [0,100]，触发方式为目标面积时有效
        public byte[] byRes2 = new byte[4];       //保留
    }

    public static class NET_VCA_ONE_RULE_V42 extends Structure {
        public byte byActive;       //是否激活规则, 0-否，非0-是
        public byte byEventPriority;//事件优先级 0-低，1-中，2-高
        public byte[] byRes1 = new byte[4];           //保留，设置为0字段
        public short wEventType;        //行为事件类型，参考VCA_RULE_EVENT_TYPE_EX
        public byte[] byRuleName = new byte[NAME_LEN/*32*/];        //规则名称
        public NET_VCA_EVENT_UNION uEventParam;            //行为分析事件参数
        public NET_VCA_SIZE_FILTER struSizeFilter;          //尺寸过滤器
        public NET_DVR_SCHEDTIMEWEEK[] struAlarmTime = new NET_DVR_SCHEDTIMEWEEK[MAX_DAYS];//布防时间
        public NET_DVR_HANDLEEXCEPTION_V40 struAlarmHandleType; /*处理方式*/
        //异常处理方式中报警输出号与组号绑定，即组号为0时，表示关联的报警输出号范围为1-64，当组号为1时，表示关联的报警输出号范围为65-128， 且是组内紧凑排列，如果遇到0xffffffff表示本组 当前的及组内后续的报警出号无效
        public int[] dwRelRecordChan = new int[MAX_CHANNUM_V30];    /* 报警触发的录象通道（四字节的通道号，初始值是 0xffffffff）*/
        //关联的录像通道号与组号绑定，即组号为0时，表示关联的通道号范围为1-64，当组号为1时，表示关联的通道号范围为65-128， 且是组内紧凑排列，如果遇到0xffffffff表示本组 当前的及组内后续的关联通道号无效
        public short wAlarmDelay; //智能报警延时，0-5s,1-10,2-30s,3-60s,4-120s,5-300s,6-600s
        public byte[] byRes2 = new byte[2];           //保留
        public NET_VCA_FILTER_STRATEGY struFilterStrategy;  //尺寸过滤策略
        public NET_VCA_RULE_TRIGGER_PARAM struTriggerParam; //规则触发参数
        public byte[] byRes = new byte[32];
    }

    public static class NET_DVR_PTZ_POSITION extends Structure {
        // 是否启用场景，在设置场景行为规则的时候该字段无效，在设置球机本地配置场景位置信息时作为使能位
        public byte byEnable;
        public byte[] byRes1 = new byte[3];  //保留
        public byte[] byPtzPositionName = new byte[NAME_LEN]; //场景位置名称
        public NET_DVR_PTZPOS struPtzPos; //ptz 坐标
        public byte[] byRes2 = new byte[40];
    }

    //行为分析配置结构体
    public static class NET_VCA_RULECFG_V42 extends Structure {
        public int dwSize;             //结构图大小
        public byte byPicProType;            //报警时图片处理方式 0-不处理 1-上传
        public byte byUpLastAlarm;         //是否先上传最近一次的报警，0-否，1-是
        public byte byPicRecordEnable;   //是否启用图片存储, 0-不启用, 1-启用
        public byte byRes1;
        public NET_DVR_JPEGPARA struPicParam;         //图片规格结构
        public NET_VCA_ONE_RULE_V42[] struRule = new NET_VCA_ONE_RULE_V42[16];       /* 规则数组*/
        public short[] wRelSnapChan = new short[3]; //关联抓图通道，当主通道报警时，同时会上传关联通道的抓拍图片，0表示不关联，其他值为关联通道号
        public byte byTrackEnable; //是否启用跟踪
        public byte byRes2;
        public NET_DVR_PTZ_POSITION struPTZPosition;  //场景位置信息
        public short wTrackDuration; //跟踪持续时间，单位s
        public short wIntervalTime; //单次报警间隔时间（秒）[1-7200]（默认为600）
        public short wHeightLimit;//目标检测高度下限（厘米）[0-250]（默认为80cm），小于此高度的目标将不作为目标进行检测
        public byte[] byRes = new byte[58];//保留
    }

    public static final int CID_CODE_LEN = 4;
    public static final int DEV_SERIAL_LEN = 9;
    public static final int ACCOUNTNUM_LEN = 6;
    public static final int ACCOUNTNUM_LEN_32 = 32;

    public static class NET_DVR_CID_ALARM extends Structure {
        public int dwSize;
        public byte[] sCIDCode = new byte[CID_CODE_LEN/*4*/];    //CID事件号
        public byte[] sCIDDescribe = new byte[NAME_LEN/*32*/];    //CID事件名
        public NET_DVR_TIME_EX struTriggerTime = new NET_DVR_TIME_EX();            //触发报警的时间点
        public NET_DVR_TIME_EX struUploadTime = new NET_DVR_TIME_EX();                //上传报警的时间点
        public byte[] sCenterAccount = new byte[ACCOUNTNUM_LEN/*6*/];    //中心帐号
        public byte byReportType;                    //见定义NET_DVR_ALARMHOST_REPORT_TYPE
        public byte byUserType;                        //用户类型，0-网络用户 1-键盘用户,2-手机用户,3-系统用户
        public byte[] sUserName = new byte[NAME_LEN/*32*/];        //网络用户用户名
        public short wKeyUserNo;                        //键盘用户号    0xFFFF表示无效
        public byte byKeypadNo;                        //键盘号        0xFF表示无效
        public byte bySubSysNo;                        //子系统号        0xFF表示无效
        public short wDefenceNo;                        //防区号        0xFFFF表示无效
        public byte byVideoChanNo;                    //视频通道号    0xFF表示无效
        public byte byDiskNo;                        //硬盘号        0xFF表示无效
        public short wModuleAddr;                    //模块地址        0xFFFF表示无效
        public byte byCenterType;                    //0-无效, 1-中心账号(长度6),2-扩展的中心账号(长度9)
        public byte byRes1;
        public byte[] sCenterAccountV40 = new byte[ACCOUNTNUM_LEN_32/*32*/];    //中心账号V40,使用此字段时sCenterAccount无效
        public byte[] byDevSerialNo = new byte[DEV_SERIAL_LEN];   /*产品序列号*/
        public byte byRepeaterNo;    //中继器号，为0无效
        public short wRemoteCtrllerUserNo;    //遥控器用户号，为0无效
        public int dwIOTChannelNo;    //IOT通道号
        public byte[] byRes2 = new byte[12];
    }

    public static class NET_DVR_SENSOR_ALARM extends Structure {
        public int dwSize;                // 结构体大小
        public int dwAbsTime;            // 绝对时标信息  OSD显示信息
        public byte[] byName = new byte[NAME_LEN];     // sensor 名称
        public byte bySensorChannel;    // 模拟量通道
        public byte byType;             // 模拟量类型
        public byte byAlarmType;        // 1-上4、2-上3、3-上2、4-上1、5-下1、6-下2、7-下3、8-下4 和当前模式有关
        // 例如当为1000时,有上1下1，2，3报警四种报警
        public byte byAlarmMode;        //报警模式，五种，-HHHH、-HHHL、-HHLL、HLLL、-LLLL， 作为平台报警程度判断功能,即：1111（上上上上），1110（上上上下），1100（上上下下），1000(上下下下)，0000(下下下下)
        public float fValue;                // 但前模拟量的值
        public float fOriginalValue; //原始电流电压值，保留小数点后三位，具体值表示电流还是电压根据NET_DVR_SENSOR_INFO的bySensorStandard类型
        public byte[] byRes2 = new byte[28];            // 保留字节
    }

    //开关量报警上传
    public static class NET_DVR_SWITCH_ALARM extends Structure {
        public int dwSize;
        public byte[] byName = new byte[NAME_LEN];     // switch 名称
        public short wSwitchChannel;     // 开关量通道, 0-255
        public byte byAlarmType;        // 报警类型 0--正常，1--短路，2--断路,3-异常
        public byte[] byRes = new byte[41];            // 保留字节
    }

    public static class NET_DVR_ALARMHOST_EXCEPTION_ALARM extends Structure {
        public int dwSize;             // 结构体大小
        // 异常参数  1-设备防拆报警 2-设备防拆后后恢复正常 3-主电源掉电报警 4-主电源掉电后恢复正常 5-内部通信故障报警
        // 6-内部通信故障后恢复正常  7-电话线断线 8-电话线断线恢复 9-自检失败报警  10-自检失败后恢复正常
        // 11蓄电池欠压  12蓄电池电压恢复正常，13-蓄电池故障；14-MBUS模块掉线；15-MBUS模块掉线恢复；16-键盘掉线；
        //17-键盘掉线恢复；18-设备被移动；19-设备被移动复位  20-485外设线路断报警  21-485外设线路断后恢复正常
        //25-子板1插上,26-子板1拔出, 27-子板2插上,28-子板2拔出
        public int dwExceptionType;
        public byte[] byRes = new byte[36];          // 保留
    }


    public static class NET_DVR_ALARMHOST_POINT_VALUE extends Structure {
        public byte byChanType;        //接入类型，1-本地模拟量通道，2-本地开关量通道，3-485通道，4-网络通道
        public byte byPointType;    //点类型，1-遥测（模拟量），2-遥信（开关量）
        public byte[] byRes1 = new byte[2];        //保留
        public int dwChanNo;        //485通道号，0xffffffff表示无效，通道类型为1时：表示本地模拟量通道号，通道类型为2时表示本地开关量通道号，通道类型为3时表示485通道号。
        public int dwSubChanNo;    //槽位号， 0xffffffff表示无效，通道类型为3时使用
        public int dwVariableNo;    //变量编号，0xffffffff表示无效
        public int dwPointNo;        //104点号，0xffffffff表示无效
        public int iValue;            //监测点的值，表示低32位
        public int iValueEx;          //监测点的值，表示高32位
        public byte[] byRes = new byte[12];
    }

    public static class NET_DVR_ALARMHOST_DATA_UNION extends Structure {
        public byte[] byLength = new byte[40];
        public NET_DVR_ALARMHOST_POINT_VALUE struPointValue;    //监测点实时数据
    }

    public static class NET_DVR_ALARMHOST_DATA_UPLOAD extends Structure {
        public int dwSize;
        public byte byDataType;        //数据类型，1-监测点实时数据上传
        public byte[] byRes1 = new byte[3];
        public NET_DVR_ALARMHOST_DATA_UNION struAlarmData;
        public byte[] byRes2 = new byte[32];
    }

    //车牌识别结果子结构
    public static class NET_DVR_PLATE_INFO extends Structure {
        public byte byPlateType;                    //车牌类型
        public byte byColor;                        //车牌颜色
        public byte byBright;                        //车牌亮度
        public byte byLicenseLen;                    //车牌字符个数
        public byte byEntireBelieve;                //整个车牌的置信度，-100
        public byte byRegion;                       // 区域索引值 0-保留，1-欧洲(EU)，2-俄语区域(ER)，3-欧洲&俄罗斯(EU&CIS) ,4-中东(ME),0xff-所有
        public byte byCountry;                      // 国家索引值，参照枚举COUNTRY_INDEX（不支持"COUNTRY_ALL = 0xff, //ALL  全部"）
        public byte byArea;                         //区域（省份），各国家内部区域枚举，阿联酋参照 EMI_AREA
        public byte byPlateSize;                    //车牌尺寸，0~未知，1~long, 2~short(中东车牌使用)
        public byte byAddInfoFlag;
        public short wCRIndex;//国家/地区索引，索引值参考_CR_ INDEX_
        public byte[] byRes = new byte[12];   //保留
        public byte[] sPlateCategory = new byte[8];//车牌附加信息, 即中东车牌中车牌号码旁边的小字信息，(目前只有中东地区支持)
        public int dwXmlLen;                        //XML报警信息长度
        public Pointer pXmlBuf;                      // XML报警信息指针,报警类型为 COMM_ITS_PLATE_RESUL时有效，其XML对应到EventNotificationAlert XML Block
        public NET_VCA_RECT struPlateRect = new NET_VCA_RECT();        //车牌位置
        public byte[] sLicense = new byte[MAX_LICENSE_LEN];        //车牌号码,注：中东车牌需求把小字也纳入车牌号码，小字和车牌号中间用空格分隔
        public byte[] byBelieve = new byte[MAX_LICENSE_LEN];    //各个识别字符的置信度，如检测到车牌"浙A12345", 置信度为,20,30,40,50,60,70，则表示"浙"字正确的可能性只有%，"A"字的正确的可能性是%
    }

    public static class NET_DVR_VEHICLE_INFO extends Structure {
        public int dwIndex;          //车辆序号
        public byte byVehicleType;    //车辆类型 0 表示其它车型，1 表示小型车，2 表示大型车 ,3表示行人触发 ,4表示二轮车触发 5表示三轮车触发(3.5Ver)
        public byte byColorDepth;        //车身颜色深浅
        public byte byColor;          //车身颜色,参考VCR_CLR_CLASS
        /*雷达异常状态：
    0~雷达正常，
    1~雷达故障
    2~雷达一直发送某一个相同速度值
    3~雷达送出数据为0
    4~雷达送出数据过大或者过小
    */
        public byte byRadarState;
        public short wSpeed;           //单位km/h
        public short wLength;          //前一辆车的车身长度
        /*违规类型，0-正常，1-低速，2-超速，3-逆行，4-闯红灯,5-压车道线,6-不按导向，7-路口滞留，
                            8-机占非，9-违法变道，10-不按车道 11-违反禁令，12-路口停车，13-绿灯停车, 14-未礼让行人(违法代码1357),
    15-违章停车，16-违章掉头,17-占用应急车道,18-禁右,19-禁左,20-压黄线,21-未系安全带,22-行人闯红灯,23-加塞,24-违法使用远光灯，
    25-驾驶时拨打接听手持电话，26-左转不让直行，27-右转不让左转，28-掉头不让直行，29-大弯小转, 30-闯绿灯，31-未带头盔，
    32-非机动车载人，33-非机动车占用机动车道，34-非机动车打伞棚, 35-黑烟车, 36-鸣笛*/
        public byte byIllegalType;
        public byte byVehicleLogoRecog; //参考枚举类型 VLR_VEHICLE_CLASS
        public byte byVehicleSubLogoRecog; //车辆品牌子类型识别；参考VSB_VOLKSWAGEN_CLASS等子类型枚举。
        public byte byVehicleModel; //车辆子品牌年款，0-未知，参考"车辆子品牌年款.xlsx"
        public byte[] byCustomInfo = new byte[16];  //自定义信息
        public short wVehicleLogoRecog;  //车辆主品牌，参考"车辆主品牌.xlsx" (该字段兼容byVehicleLogoRecog);
        public byte byIsParking;//是否停车 0-无效，1-停车，2-未停车
        public byte byRes;//保留字节
        public int dwParkingTime; //停车时间，单位：s
        public byte[] byRes3 = new byte[8];
    }

    //手动抓拍
    public static class NET_DVR_MANUALSNAP extends Structure {
        public byte byOSDEnable;//0-不关闭(默认)，1-关闭
        public byte byLaneNo;//车道号, 范围为1-6，默认为1(抓拍机内部测试使用)
        public byte byChannel;//通道号
        public byte[] byRes = new byte[21]; //保留
    }

    //交通抓拍结果信息
    public static class NET_DVR_PLATE_RESULT extends Structure {
        public int dwSize;
        public byte byResultType;
        public byte byChanIndex;
        public short wAlarmRecordID;
        public int dwRelativeTime;
        public byte[] byAbsTime = new byte[32];
        public int dwPicLen;
        public int dwPicPlateLen;
        public int dwVideoLen;
        public byte byTrafficLight;
        public byte byPicNum;
        public byte byDriveChan;
        public byte byVehicleType;
        public int dwBinPicLen;
        public int dwCarPicLen;
        public int dwFarCarPicLen;
        public Pointer pBuffer3;
        public Pointer pBuffer4;
        public Pointer pBuffer5;
        public byte[] byRes3 = new byte[8];
        public NET_DVR_PLATE_INFO struPlateInfo;
        public NET_DVR_VEHICLE_INFO struVehicleInfo;
        public Pointer pBuffer1;
        public Pointer pBuffer2;
    }

    public static class NET_DVR_TIME_V30 extends Structure {
        public short wYear;
        public byte byMonth;
        public byte byDay;
        public byte byHour;
        public byte byMinute;
        public byte bySecond;
        public byte byRes;
        public short wMilliSec;
        public byte[] byRes1 = new byte[2];


    }

    public static class NET_ITS_PICTURE_INFO extends Structure {
        public int dwDataLen;
        public byte byType;
        public byte byDataType;
        public byte byCloseUpType;
        public byte byPicRecogMode;
        public int dwRedLightTime;
        public byte[] byAbsTime = new byte[32];
        public NET_VCA_RECT struPlateRect = new NET_VCA_RECT();
        public NET_VCA_RECT struPlateRecgRect = new NET_VCA_RECT();
        public Pointer pBuffer;
        public int dwUTCTime;//UTC时间
        public byte byCompatibleAblity;//兼容能力字段，按位表示，值：0- 无效，1- 有效
        public byte byTimeDiffFlag;      /*时差字段是否有效  0-时差无效， 1-时差有效 */
        public byte cTimeDifferenceH;         /*与UTC的时差（小时），-12 ... +14， +表示东区,，byTimeDiffFlag为1时有效*/
        public byte cTimeDifferenceM;        /*与UTC的时差（分钟），-30, 30, 45， +表示东区，byTimeDiffFlag为1时有效*/
        public byte[] byRes2 = new byte[4];
    }

    public static class NET_ITS_PLATE_RESULT extends Structure {
        public int dwSize;
        public int dwMatchNo;
        public byte byGroupNum;
        public byte byPicNo;
        public byte bySecondCam;
        public byte byFeaturePicNo;
        public byte byDriveChan;
        public byte byVehicleType;
        public byte byDetSceneID;
        public byte byVehicleAttribute;
        public short wIllegalType;
        public byte[] byIllegalSubType = new byte[8];
        public byte byPostPicNo;
        public byte byChanIndex;
        public short wSpeedLimit;
        public byte byChanIndexEx; //byChanIndexEx*256+byChanIndex表示真实通道号。
        public byte byRes2;
        public NET_DVR_PLATE_INFO struPlateInfo = new NET_DVR_PLATE_INFO();
        public NET_DVR_VEHICLE_INFO struVehicleInfo = new NET_DVR_VEHICLE_INFO();
        public byte[] byMonitoringSiteID = new byte[48];
        public byte[] byDeviceID = new byte[48];
        public byte byDir;
        public byte byDetectType;
        public byte byRelaLaneDirectionType;
        public byte byCarDirectionType;
        public int dwCustomIllegalType;
        public Pointer pIllegalInfoBuf;
        public byte byIllegalFromatType;
        public byte byPendant;
        public byte byDataAnalysis;
        public byte byYellowLabelCar;
        public byte byDangerousVehicles;
        public byte byPilotSafebelt;
        public byte byCopilotSafebelt;
        public byte byPilotSunVisor;
        public byte byCopilotSunVisor;
        public byte byPilotCall;
        public byte byBarrierGateCtrlType;
        public byte byAlarmDataType;
        public NET_DVR_TIME_V30 struSnapFirstPicTime = new NET_DVR_TIME_V30();
        public int dwIllegalTime;
        public int dwPicNum;
        public NET_ITS_PICTURE_INFO[] struPicInfo = new NET_ITS_PICTURE_INFO[6];
    }

    public int MAX_PARKNO_LEN = 16; //车位编号长度
    public int MAX_ID_LEN = 48; //编号最大长度

    //停车场数据上传
    public static class NET_ITS_PARK_VEHICLE extends Structure {
        public int dwSize; //结构长度
        public byte byGroupNum; //图片组数量（单次轮询抓拍的图片数量）
        public byte byPicNo; //连拍的图片组上传图片序号（接收到图片组数量后，表示接收完成
        //接收超时不足图片组数量时，根据需要保留或删除）
        public byte byLocationNum; //单张图片所管理的车位数
        public byte byParkError; //停车异常，0-正常 1 异常
        public byte[] byParkingNo = new byte[MAX_PARKNO_LEN];//车位编号
        public byte byLocationStatus; //车位车辆状态，0-无车，1有车
        public byte bylogicalLaneNum;//逻辑车位号，0-3，一个相机最大能管4个车位 （0代表最左边，3代表最右边）
        public short wUpLoadType;//第零位表示：0~轮训上传、1~变化上传
        public byte[] byRes1 = new byte[4]; //保留字节
        public int dwChanIndex; //通道号数字通道
        public NET_DVR_PLATE_INFO struPlateInfo;  //车牌信息结构
        public NET_DVR_VEHICLE_INFO struVehicleInfo; //车辆信息
        public byte[] byMonitoringSiteID = new byte[MAX_ID_LEN]; //监测点编号
        public byte[] byDeviceID = new byte[MAX_ID_LEN]; //设备编号
        public int dwPicNum; //图片数量（与picGroupNum不同，代表本条信息附带的图片数量，图片信息由struVehicleInfoEx定义
        public NET_ITS_PICTURE_INFO[] struPicInfo = new NET_ITS_PICTURE_INFO[2];  //图片信息,单张回调，最多2张图，由序号区分
        public byte[] byRes2 = new byte[256];
    }

    public static class NET_DVR_SNAPCFG extends Structure {

        public int dwSize;
        public byte byRelatedDriveWay;//触发IO关联的车道号
        public byte bySnapTimes; //线圈抓拍次数，0-不抓拍，非0-连拍次数，目前最大5次
        public short wSnapWaitTime;  //抓拍等待时间，单位ms，取值范围[0,60000]
        public short[] wIntervalTime = new short[MAX_INTERVAL_NUM];//连拍间隔时间，ms
        public int dwSnapVehicleNum; //抓拍车辆序号。
        public NET_DVR_JPEGPARA struJpegPara;//抓拍图片参数
        public byte[] byRes2 = new byte[16];
    }

    // 道闸控制
    public static class NET_DVR_BARRIERGATE_CFG extends Structure {
        public int dwSize;
        public int dwChannel; //通道号
        public byte byLaneNo;  //道闸号（0-表示无效值(设备需要做有效值判断),1-道闸1）
        /*
    若老的平台不支持byUnlock字段，该字段将赋值为0，通过“0-关闭道闸,1-开启道闸,2-停止道闸”中的任何一种操作皆可进行解锁。
    若新平台支持byUnlock字段，需byUnlock字段赋值为1，并结合4~解锁道闸来进行解锁。byUnlock字段赋值为1后，“0-关闭道闸,1-开启道闸,2-停止道闸”操作将不可用于解锁。
    */
        public byte byBarrierGateCtrl;//0-关闭道闸,1-开启道闸,2-停止道闸 3-锁定道闸,4~解锁道闸
        public byte byEntranceNo;//出入口编号 [1,8]
        public byte byUnlock;//启用解锁使能，0~为不启用，1~启用
        public byte[] byRes = new byte[12];
    }


    public static class NET_DVR_AGEGROUP_PARAM extends Structure {
        public int dwTeenage;//少年（人数）
        public int dwYouth;//青年（人数）
        public int dwMidLife;//中年（人数）
        public int dwElderly;//老年（人数）
        public int dwChild;//儿童（人数）
        public int dwAdolescent;//青少年（人数）
        public int dwPrime;//壮年（人数）
        public int dwMidage;//中老年（人数）
        public byte[] byRes = new byte[48];
    }

    public static class NET_DVR_SEXGROUP_PARAM extends Structure {
        public int dwMale;//男（人数）
        public int dwFemale;//女（人数）
        public byte[] byRes = new byte[64];
    }

    public static class NET_DVR_PROGRAM_INFO extends Structure {
        public int dwProgramNo; //节目编号
        public byte[] sProgramName = new byte[NAME_LEN]; //节目名称
        public byte[] byRes = new byte[16];
    }

    public static class NET_DVR_FACECAPTURE_STATISTICS_RESULT extends Structure {
        public int dwSize;
        public NET_DVR_TIME_EX struStartTime;/*间隔开始时间*/
        public NET_DVR_TIME_EX struEndTime;/*间隔结束时间*/
        public byte byStatType;//数据类型统计：Bit0-年龄段有效，Bit1-性别有效，Bit2-人数有效
        public byte[] byRes = new byte[7];
        public int dwPeopleNum;//人数统计
        public NET_DVR_AGEGROUP_PARAM struAgeGroupParam;//年龄段人数统计
        public NET_DVR_SEXGROUP_PARAM struSexGroupParam;//性别人数统计
        public NET_DVR_PROGRAM_INFO struProgramInfo;        //节目信息
        public byte[] byRes1 = new byte[76];
    }

    //获取交通数据条件结构
    public static class NET_DVR_TRAFFIC_DATA_QUERY_COND extends Structure {
        public int dwSize;
        /*
       Bit0-通道有效
       Bit1-时间有效
       Bit2-车牌号有效
       Bit3-车牌类型有效
       Bit4-车牌颜色有效
       Bit5-车身颜色有效
       Bit6-车辆类型有效
       Bit7-车辆品牌有效
       Bit8-车道号有效
       Bit9-监测方向有效
       Bit10-最低速度有效
       Bit11-最高速度有效
       Bit12-数据类型有效
       Bit13-布控方式类型有效
       Bit14-违法取证有效
       Bit15-事件类型有效
       Bit16-取证类型有效
       */
        public int dwQueryCond;//查询条件 0表示无效，1表示有效
        public int dwChannel;//默认是1（[1~32]，bit0表示通道1，依次类推bit31表示通道32）
        public NET_DVR_TIME_V30 struStartTime;//开始时间
        public NET_DVR_TIME_V30 struEndTime;//结束时间
        public byte[] sLicense = new byte[MAX_LICENSE_LEN/*16*/];//(设备支持模糊查询, GB2312编码)
        /*
       Bit0-未知（其他）
       Bit1-标准民用车与军车
       Bit2-02式民用车牌
       Bit3-武警车
       Bit4-警车
       Bit5-民用车双行尾牌
       Bit6-使馆车牌
       Bit7-农用车
       Bit8-摩托车
       */
        public int dwPlateType;//车牌类型（支持按位表示，可以复选）
        /*
       Bit0-未知（其他）
       Bit1-黄色
       Bit2-白色
       Bit3-黑色
       Bit4-绿色
       Bit5-蓝色
       */
        public int dwPlateColor;//车牌颜色（支持按位表示，可以复选）
        /*
       Bit0-未ª知（其他）
       Bit1-白色
       Bit2-银色
       Bit3-灰色
       Bit4-黑色
       Bit5-红色
       Bit6-深蓝色
       Bit7-蓝色
       Bit8-黄色
       Bit9-绿色
       Bit10-棕色
       Bit11-粉色
       Bit12-紫色
       Bit13-深灰色
       */
        public int dwVehicleColor;//车身颜色（支持按位表示，可以复选）
        /*
       Bit0-未知（其他）
       Bit1-客车
       Bit2-大货车
       Bit3-轿车
       Bit4-面包车
       Bit5-小货车
       Bit6-行人
       Bit7-二轮车
       Bit8-三轮车
       Bit9-SUV/MPV
       Bit10-中型客车
       */
        public int dwVehicleType;//车辆类型（支持按位表示，可以复选）
        /**
         * Bit0-其他（保留）
         * Bit1-低速
         * Bit2-超速
         * Bit3-逆行
         * Bit4-闯红灯
         * Bit5-压车道线
         * Bit6-不按导向
         * Bit7-路口滞留
         * Bit8-机占非
         * Bit9-违法变道
         * Bit10-不按车道
         * Bit11-违反禁令
         * Bit12-路口停车
         * Bit13-绿灯停车
         * Bit14-未礼让行人
         * Bit15-违章停车
         * Bit16-违章掉头
         * Bit17-占用应急车道
         * Bit18-未系安全带
         */
        public int dwIllegalType;
        /**
         * Bit0-其他（保留）
         * Bit1-拥堵
         * Bit2-停车
         * Bit3-逆行
         * Bit4-行人
         * Bit5-抛洒物
         * Bit6-烟雾
         * Bit7-压线
         * Bit8-禁止名单
         * Bit9-超速
         * Bit10-变道
         * Bit11-掉头
         * Bit12-机占非
         * Bit13-加塞
         */
        public int dwEventType;
        /**
         * Bit0-其他（保留）
         * Bit1-城市公路违法停车
         * Bit2-高速公路违法停车
         * Bit3-压线
         * Bit4-逆行
         * Bit5-违法变道
         * Bit6-机占非
         */
        public int dwForensiceType;
        public short wVehicleLogoRecog;  //车辆主品牌，参考"车辆主品牌.xlsx" （仅单选）
        public byte byLaneNo;//车道号（0~255,0号车道 表示 车道号未知）
        public byte byDirection;//监测方向，1-上行，2-下行，3-双向，4-由东向西，5-由南向北,6-由西向东，7-由北向南
        public short wMinSpeed;//最低速度（0~999）单位km/h
        public short wMaxSpeed;//最高速度（0~999）单位km/h
        public byte byDataType;//数据类型 0-卡口数据，1-违法数据，2-交通事件，3-取证数据 （仅单选）
        public byte byExecuteCtrl;//布控 0-允许名单，1-禁止名单，0xff-其他
        public byte[] byRes = new byte[254];
    }

    public static final int MAX_TRAFFIC_PICTURE_NUM = 8; //交通图片数量

    //交通数据结构体
    public static class NET_DVR_TRAFFIC_DATA_QUERY_RESULT extends Structure {
        public int dwSize;
        public int dwChannel;//默认是1（[1~32]）
        public byte[] sLicense = new byte[MAX_LICENSE_LEN/*16*/];
        /*
    Bit0-未知（其他）
    Bit1-标准民用车与军车
    Bit2-02式民用车牌
    Bit3-武警车
    Bit4-警车
    Bit5-民用车双行尾牌
    Bit6-使馆车牌
    Bit7-农用车
    Bit8-摩托车
    */
        public int dwPlateType;//车牌类型
        /*
    Bit0-未知（其他）
    Bit1-黄色
    Bit2-白色
    Bit3-黑色
    Bit4-绿色
    Bit5-蓝色
    */
        public int dwPlateColor;//车牌颜色
        /*
    Bit0-未知（其他）
    Bit1-白色
    Bit2-银色
    Bit3-灰色
    Bit4-黑色
    Bit5-红色
    Bit6-深蓝色
    Bit7-蓝色
    Bit8-黄色
    Bit9-绿色
    Bit10-棕色
    Bit11-粉色
    Bit12-紫色
    Bit13-深灰色
    */
        public int dwVehicleColor;//车身颜色
        /*
    Bit0-未知（其他）
    Bit1-客车
    Bit2-大货车
    Bit3-轿车
    Bit4-面包车
    Bit5-小货车
    Bit6-行人
    Bit7-二轮车
    Bit8-三轮车
    Bit9-SUV/MPV
    Bit10-中型客车
    Bit11-机动车
    Bit12-非机动车
    Bit13-小型轿车
    Bit14-微型轿车
    Bit15-皮卡车
    Bit16-集装箱卡车
    Bit17-微卡，栏板卡
    Bit18-渣土车
    Bit19-吊车，工程车
    Bit20-油罐车
    Bit21-混凝土搅拌车
    Bit22-平板拖车
    Bit23-两厢轿车
    Bit24-三厢轿车
    Bit25-轿跑
    Bit26-小型客车
    */
        public int dwVehicleType;//车辆类型
        /**
         * Bit0-其他（保留）
         * Bit1-低速
         * Bit2-超速
         * Bit3-逆行
         * Bit4-闯红灯
         * Bit5-压车道线
         * Bit6-不按导向
         * Bit7-路口滞留
         * Bit8-机占非
         * Bit9-违法变道
         * Bit10-不按车道
         * Bit11-违反禁令
         * Bit12-路口停车
         * Bit13-绿灯停车
         * Bit14-未礼让行人
         * Bit15-违章停车
         * Bit16-违章掉头
         * Bit17-占用应急车道
         * Bit18-未系安全带
         */
        public int dwIllegalType;
        /**
         * Bit0-其他（保留）
         * Bit1-拥堵
         * Bit2-停车
         * Bit3-逆行
         * Bit4-行人
         * Bit5-抛洒物
         * Bit6-烟雾
         * Bit7-压线
         * Bit8-禁止名单
         * Bit9-超速
         * Bit10-变道
         * Bit11-掉头
         * Bit12-机占非
         * Bit13-加塞
         */
        public int dwEventType;
        /**
         * Bit0-其他（保留）
         * Bit1-城市公路违法停车
         * Bit2-高速公路违法停车
         * Bit3-压线
         * Bit4-逆行
         * Bit5-违法变道
         * Bit6-机占非
         */
        public int dwForensiceType;
        public short wVehicleLogoRecog;  //车辆主品牌，参考"车辆主品牌.xlsx"
        public byte byLaneNo;//车道号（0~255,0号车道 表示 车道号未知）
        public byte byDirection;//监测方向，1-上行，2-下行，3-双向，4-由东向西，5-由南向北,6-由西向东，7-由北向南
        public short wSpeed;//速度（0~999）单位km/h
        public byte byDataType;//数据类型: 0-卡口 1-违法 2-事件 3-取证
        public byte[] byRes = new byte[253];
        public NET_DVR_TRAFFIC_PICTURE_PARAM[] struTrafficPic = new NET_DVR_TRAFFIC_PICTURE_PARAM[MAX_TRAFFIC_PICTURE_NUM/*8*/];
    }

    //交通图片参数子结构
    public static final int PICTURE_NAME_LEN = 64;

    public static class NET_DVR_TRAFFIC_PICTURE_PARAM extends Structure {
        public NET_DVR_TIME_V30 struRelativeTime = new NET_DVR_TIME_V30(); //抓拍相对时标
        public NET_DVR_TIME_V30 struAbsTime = new NET_DVR_TIME_V30();  //抓拍绝对时标
        public byte[] szPicName = new byte[PICTURE_NAME_LEN/*64*/];
        public byte byPicType;//图片类型 0-车牌图，1-抓拍原图，2-合成图，3-特写图
        public byte[] byRes = new byte[63];
    }

    public static class NET_DVR_VEHICLE_CONTROL_COND extends Structure {
        public int dwChannel;
        public int dwOperateType;
        public byte[] sLicense = new byte[MAX_LICENSE_LEN];
        public byte[] sCardNo = new byte[48];
        public byte byListType;
        public byte[] byRes1 = new byte[3];
        public int dwDataIndex;
        public byte[] byRes = new byte[116];
    }

    public static class NET_DVR_VEHICLE_CONTROL_LIST_INFO extends Structure {
        public int dwSize;
        public int dwChannel;
        public int dwDataIndex;
        public byte[] sLicense = new byte[16];
        public byte byListType;
        public byte byPlateType;
        public byte byPlateColor;
        public byte[] byRes = new byte[21];
        public byte[] sCardNo = new byte[48];
        public NET_DVR_TIME_V30 struStartTime = new NET_DVR_TIME_V30();
        public NET_DVR_TIME_V30 struStopTime = new NET_DVR_TIME_V30();
        public byte[] sOperateIndex = new byte[32];
        public byte[] byRes1 = new byte[224];
    }

    //车辆报警
    public static class NET_DVR_VEHICLE_CONTROL_ALARM extends Structure {
        public int dwSize;
        public byte byListType;   //名单属性：0-允许名单，1-禁止名单，2-临时名单
        public byte byPlateType;  //车牌类型
        public byte byPlateColor;    //车牌颜色
        public byte byRes1;
        public byte[] sLicense = new byte[MAX_LICENSE_LEN];//车牌号码
        public byte[] sCardNo = new byte[MAX_CARDNO_LEN];  // 卡号
        public NET_DVR_TIME_V30 struAlarmTime = new NET_DVR_TIME_V30(); //报警时间
        public int dwChannel;          //设备通道号，如果直连的是IPC，则为ipc通道号；如果连的DVR\nvr,则为DVR\NVR的通道号
        public int dwPicDataLen;   //图片数据大小，0表示无图片，不为0是表示后面带图片数据
        public byte byPicType;    //图片类型，0-JPEG
        public byte byPicTransType;        //图片数据传输方式: 0-二进制；1-url
        public byte[] byRes3 = new byte[2];
        public Pointer pPicData;
        public byte[] byRes2 = new byte[48];
    }

    public int MAX_LED_INFO_LEN = 512;
    public int MAX_VOICE_INFO_LEN = 128;

    //LED屏幕显示参数
    public static class NET_DVR_LEDDISPLAY_CFG extends Structure {
        public int dwSize;//结构体大小
        public byte[] sDisplayInfo = new byte[MAX_LED_INFO_LEN/*512*/]; // LED显示内容
        public byte byDisplayMode;//显示方式:0~左移,1~右移,2~立即显示
        public byte bySpeedType;//速度类型:0~快,1~中,2~慢
        public byte byShowPlateEnable;//显示车牌使能，0~关闭，1~启用
        public byte byRes1;
        public int dwShowTime;//显示时长，1~60秒
        public byte[] byRes = new byte[128];
    }

    //语音播报控制参数
    public static class NET_DVR_VOICEBROADCAST_CFG extends Structure {
        public int dwSize;//结构体大小
        public byte[] sInfo = new byte[MAX_VOICE_INFO_LEN/*128*/]; //语音播报内容
        public byte byBroadcastNum;// 语音播报次数， 1~10次
        public byte byIntervalTime;// 语音播报间隔时间,1~5s
        public byte[] byRes = new byte[126];
    }

    //缴费金额信息
    public static class NET_DVR_CHARGEACCOUNT_CFG extends Structure {
        public int dwSize;//结构体大小
        public float fAccount;//实际收费金额
        public byte[] byRes = new byte[128];
    }

    public static final int DOOR_NAME_LEN = 32;        //门名称
    public static final int STRESS_PASSWORD_LEN = 8;   //胁迫密码长度
    public static final int SUPER_PASSWORD_LEN = 8;    //胁迫密码长度
    public static final int UNLOCK_PASSWORD_LEN = 8;   // 解除密码长度

    public static class NET_DVR_DOOR_CFG extends Structure {
        public int dwSize;
        public byte[] byDoorName = new byte[DOOR_NAME_LEN]; //门名称
        public byte byMagneticType; //门磁类型，0-常闭，1-常开
        public byte byOpenButtonType; //开门按钮类型，0-常闭，1-常开
        public byte byOpenDuration; //开门持续时间，1-255s（楼层继电器动作时间）
        public byte byDisabledOpenDuration; //残障人士卡开门持续时间，1-255s
        public byte byMagneticAlarmTimeout; //门磁检测超时报警时间，0-255s，0表示不报警
        public byte byEnableDoorLock; //是否启用闭门回锁，0-否，1-是
        public byte byEnableLeaderCard; //是否启用首卡常开功能，0-否，1-是
        public byte byLeaderCardMode; //首卡模式，0-不启用首卡功能，1-首卡常开模式，2-首卡授权模式（使用了此字段，则byEnableLeaderCard无效）
        public int dwLeaderCardOpenDuration; //首卡常开持续时间，1-1440min
        public byte[] byStressPassword = new byte[STRESS_PASSWORD_LEN]; //胁迫密码
        public byte[] bySuperPassword = new byte[SUPER_PASSWORD_LEN]; //超级密码
        public byte[] byUnlockPassword = new byte[UNLOCK_PASSWORD_LEN];         //解除码NET_DVR_LOCAL_CONTROLLER_STATUS
        public byte byUseLocalController; //只读，是否连接在就地控制器上，0-否，1-是
        public byte byRes1;
        public short wLocalControllerID; //只读，就地控制器序号，1-64,0代表未注册
        public short wLocalControllerDoorNumber; //只读，就地控制器的门编号，1-4,0代表未注册
        public short wLocalControllerStatus; //只读，就地控制器在线状态：0-离线，1-网络在线，2-环路1上的RS485串口1，3-环路1上的RS485串口2，4-环路2上的RS485串口1，5-环路2上的RS485串口2，6-环路3上的RS485串口1，7-环路3上的RS485串口2，8-环路4上的RS485串口1，9-环路4上的RS485串口2（只读）
        public byte byLockInputCheck; //是否启用门锁输入检测(1字节，0不启用，1启用，默认不启用)
        public byte byLockInputType; //门锁输入类型(1字节，0常闭，1常开，默认常闭)
        public byte byDoorTerminalMode; //门相关端子工作模式(1字节，0防剪防短，1普通，默认防剪防短)
        public byte byOpenButton; //是否启用开门按钮(1字节，0是，1否，默认是)
        public byte byLadderControlDelayTime; //梯控访客延迟时间，1-255min
        public byte[] byRes2 = new byte[43];
    }

    public static class NET_DVR_DOOR_STATUS_PLAN extends Structure {
        public int dwSize;
        public int dwTemplateNo; //计划模板编号，为0表示取消关联，恢复默认状态（普通状态）
        public byte[] byRes = new byte[64];
    }


    public static class NET_DVR_EVENT_CARD_LINKAGE_COND extends Structure {
        public int dwSize;
        public int dwEventID; //事件ID
        public short wLocalControllerID; //就地控制器序号[1,64]
        public byte[] byRes = new byte[106];
    }

    public static final int MAX_ALARMHOST_ALARMIN_NUM = 512;//网络报警主机最大报警输入口数
    public static final int MAX_ALARMHOST_ALARMOUT_NUM = 512;//网络报警主机最大报警输出口数

    public static class NET_DVR_EVENT_CARD_LINKAGE_CFG_V50 extends Structure {
        public int dwSize;    //结构体大小
        public byte byProMode;                          //联动方式，0-事件，1-卡号, 2-MAC地址
        public byte[] byRes1 = new byte[3];
        public int dwEventSourceID;                    //事件源ID，当主类型为设备事件时无效， 当主类型是门事件时为门编号;当主类型为读卡器事件时，为读卡器ID;当为报警输入事件时为防区报警输入ID或事件报警输入ID。0xffffffff表示联动全部
        public NET_DVR_EVETN_CARD_LINKAGE_UNION uLinkageInfo = new NET_DVR_EVETN_CARD_LINKAGE_UNION();  //联动方式参数
        public byte[] byAlarmout = new byte[MAX_ALARMHOST_ALARMOUT_NUM];            //关联的报警输出号，按位表示，为0表示不关联，为1表示关联
        public byte[] byRes2 = new byte[32];                         //保留
        public byte[] byOpenDoor = new byte[MAX_DOOR_NUM_256];     //按位表示,是否联动开门，0-不联动，1-联动
        public byte[] byCloseDoor = new byte[MAX_DOOR_NUM_256];    //按位表示,是否联动关门，0-不联动，1-联动
        public byte[] byNormalOpen = new byte[MAX_DOOR_NUM_256];   //按位表示,是否联动常开，0-不联动，1-联动
        public byte[] byNormalClose = new byte[MAX_DOOR_NUM_256];  //按位表示,是否联动常关，0-不联动，1-联动
        public byte byMainDevBuzzer;                    //主机蜂鸣器   0-不联动，1-联动输出
        public byte byCapturePic;                           //是否联动抓拍，0-不联动抓拍，1-联动抓拍
        public byte byRecordVideo;                          //是否联动录像，0-不联动录像，1-联动录像
        public byte[] byRes3 = new byte[29];                         //保留
        public byte[] byReaderBuzzer = new byte[MAX_CARD_READER_NUM_512]; //联动读卡器蜂鸣器，按位表示，0-不联动，1-联动
        public byte[] byAlarmOutClose = new byte[MAX_ALARMHOST_ALARMOUT_NUM];            //关联报警输出关闭，按字节表示，为0表示不关联，为1表示关联
        public byte[] byAlarmInSetup = new byte[MAX_ALARMHOST_ALARMIN_NUM];  //关联防区布防，按字节表示，为0表示不关联，为1表示关联
        public byte[] byAlarmInClose = new byte[MAX_ALARMHOST_ALARMIN_NUM];  //关联防区撤防，按字节表示，为0表示不关联，为1表示关联
        public byte[] byRes = new byte[500];                           //保留
    }

    public static class NET_DVR_EVENT_LINKAGE_INFO extends Structure {
        public short wMainEventType;                     //事件主类型，0-设备事件，1-报警输入事件，2-门事件，3-读卡器事件
        public short wSubEventType;                      //事件次类型
        public byte[] byRes = new byte[28];
    }

    public static class NET_DVR_EVETN_CARD_LINKAGE_UNION extends Union {
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN];          //卡号
        public NET_DVR_EVENT_LINKAGE_INFO struEventLinkage;                   //事件联动时参数
        public byte[] byMACAddr = new byte[MACADDR_LEN];          //物理MAC地址
        public byte[] byEmployeeNo = new byte[NET_SDK_EMPLOYEE_NO_LEN]; //工号（人员ID）
    }

    //卡参数配置条件
    public static class NET_DVR_CARD_CFG_COND extends Structure {
        public int dwSize;
        public int dwCardNum;
        public byte byCheckCardNo;
        public byte[] ibyRes = new byte[31];
    }

    //获取卡参数的发送数据
    public static class NET_DVR_CARD_CFG_SEND_DATA extends Structure {
        public int dwSize;
        public byte[] byCardNo = new byte[32];
        public byte[] byRes = new byte[16];
    }

    public static class CARDRIGHTPLAN extends Structure {
        public byte[] byRightPlan = new byte[4];
    }

    //卡参数
    public static class NET_DVR_CARD_CFG extends Structure {
        public int dwSize;
        public int dwModifyParamType;
        public byte[] byCardNo = new byte[32];
        public byte byCardValid;
        public byte byCardType;
        public byte byLeaderCard;
        public byte byRes1;
        public int dwDoorRight;
        public NET_DVR_VALID_PERIOD_CFG struValid;
        public int dwBelongGroup;
        public byte[] byCardPassword = new byte[8];
        public CARDRIGHTPLAN[] byCardRightPlan = new CARDRIGHTPLAN[32];
        public int dwMaxSwipeTime;
        public int dwSwipeTime;
        public short wRoomNumber;
        public short wFloorNumber;
        public byte[] byRes2 = new byte[20];
    }

    public int ACS_CARD_NO_LEN = 32;  //门禁卡号长度
    public int MAX_GROUP_NUM_128 = 128; //最大群组数
    public int MAX_DOOR_NUM_256 = 256; //最大门数
    public int CARD_PASSWORD_LEN = 8;   //卡密码长度
    public int MAX_CARD_READER_NUM = 64;  //最大读卡器数
    public int MAX_DOOR_CODE_LEN = 8; //房间代码长度
    public int MAX_LOCK_CODE_LEN = 8; //锁代码长度
    public int MAX_CARD_RIGHT_PLAN_NUM = 4; //卡权限最大计划个数
    public int MAX_CASE_SENSOR_NUM = 8;  //最大case sensor触发器数

    public static class CARDRIGHTPLAN_WORD extends Structure {
        public short[] wRightPlan = new short[MAX_CARD_RIGHT_PLAN_NUM];
    }

    public static class NET_DVR_CARD_CFG_V50 extends Structure {
        public int dwSize;
        public int dwModifyParamType;//需要修改的卡参数，设置卡参数时有效，按位表示，每位代表一种参数，1为需要修改，0为不修改
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN]; //卡号
        public byte byCardValid; //卡是否有效，0-无效，1-有效（用于删除卡，设置时置为0进行删除，获取时此字段始终为1）
        public byte byCardType; //卡类型，1-普通卡，2-残障人士卡，3-禁止名单卡，4-巡更卡，5-胁迫卡，6-超级卡，7-来宾卡，8-解除卡，9-员工卡，10-应急卡，11-应急管理卡，默认普通卡
        public byte byLeaderCard; //是否为首卡，1-是，0-否
        public byte byRes1;
        public byte[] byDoorRight = new byte[MAX_DOOR_NUM_256]; //门权限(楼层权限)，按位表示，1为有权限，0为无权限，从低位到高位表示对门1-N是否有权限
        public NET_DVR_VALID_PERIOD_CFG struValid; //有效期参数
        public byte[] byBelongGroup = new byte[MAX_GROUP_NUM_128]; //所属群组，按字节表示，1-属于，0-不属于
        public byte[] byCardPassword = new byte[CARD_PASSWORD_LEN]; //卡密码
        public CARDRIGHTPLAN_WORD[] wCardRightPlan = new CARDRIGHTPLAN_WORD[MAX_DOOR_NUM_256]; //卡权限计划，取值为计划模板编号，同个门不同计划模板采用权限或的方式处理
        public int dwMaxSwipeTime; //最大刷卡次数，0为无次数限制（开锁次数）
        public int dwSwipeTime; //已刷卡次数
        public short wRoomNumber;  //房间号
        public short wFloorNumber;   //层号
        public int dwEmployeeNo;   //工号
        public byte[] byName = new byte[NAME_LEN];   //姓名
        public short wDepartmentNo;   //部门编号
        public short wSchedulePlanNo;   //排班计划编号
        public byte bySchedulePlanType;  //排班计划类型：0-无意义、1-个人、2-部门
        public byte byRightType;  //下发权限类型：0-普通发卡权限、1-二维码权限、2-蓝牙权限（可视对讲设备二维码权限配置项：房间号、卡号（虚拟卡号）、最大刷卡次数（开锁次数）、有效期参数；蓝牙权限：卡号（萤石APP账号）、其他参数配置与普通发卡权限一致）
        public byte[] byRes2 = new byte[2];
        public int dwLockID;  //锁ID
        public byte[] byLockCode = new byte[MAX_LOCK_CODE_LEN];    //锁代码
        public byte[] byRoomCode = new byte[MAX_DOOR_CODE_LEN];  //房间代码
        public int dwCardRight;      //卡权限
        public int dwPlanTemplate;   //计划模板(每天)各时间段是否启用，按位表示，0--不启用，1-启用
        public int dwCardUserId;    //持卡人ID
        public byte byCardModelType;  //0-空，1- MIFARE S50，2- MIFARE S70，3- FM1208 CPU卡，4- FM1216 CPU卡，5-国密CPU卡，6-身份证，7- NFC
        public byte[] byRes3 = new byte[83];
    }

    //有效期参数结构体
    public static class NET_DVR_VALID_PERIOD_CFG extends Structure {
        public byte byEnable;
        public byte[] byRes1 = new byte[3];
        public NET_DVR_TIME_EX struBeginTime;
        public NET_DVR_TIME_EX struEndTime;
        public byte[] byRes2 = new byte[32];
    }

    //扩展结构体信息
    public static class NET_DVR_ID_CARD_INFO_EXTEND extends Structure {
        public byte byRemoteCheck; //是否需要远程核验（0-无效，1-不需要（默认），2-需要）
        public byte byThermometryUnit; //测温单位（0-摄氏度（默认），1-华氏度，2-开尔文）
        public byte byIsAbnomalTemperature; //人脸抓拍测温是否温度异常：1-是，0-否
        public byte byRes2;
        public float fCurrTemperature; //人脸温度（精确到小数点后一位）
        public NET_VCA_POINT struRegionCoordinates = new NET_VCA_POINT(); //人脸温度坐标
        public int dwQRCodeInfoLen; //二维码信息长度，不为0是表示后面带数据
        public int dwVisibleLightDataLen; //热成像相机可见光图片长度，不为0是表示后面带数据
        public int dwThermalDataLen; //热成像图片长度，不为0是表示后面带数据
        public Pointer pQRCodeInfo; //二维码信息指针
        public Pointer pVisibleLightData; //热成像相机可见光图片指针
        public Pointer pThermalData; //热成像图片指针
        public byte[] byRes = new byte[1024];
    }

    //身份证信息报警
    public static class NET_DVR_ID_CARD_INFO_ALARM extends Structure {
        public int dwSize;        //结构长度
        public NET_DVR_ID_CARD_INFO struIDCardCfg = new NET_DVR_ID_CARD_INFO();//身份证信息
        public int dwMajor; //报警主类型，参考宏定义
        public int dwMinor; //报警次类型，参考宏定义
        public NET_DVR_TIME_V30 struSwipeTime = new NET_DVR_TIME_V30(); //时间
        public byte[] byNetUser = new byte[MAX_NAMELEN];//网络操作的用户名
        public NET_DVR_IPADDR struRemoteHostAddr = new NET_DVR_IPADDR();//远程主机地址
        public int dwCardReaderNo; //读卡器编号，为0无效
        public int dwDoorNo; //门编号，为0无效
        public int dwPicDataLen;   //图片数据大小，不为0是表示后面带数据
        public Pointer pPicData;
        public byte byCardType; //卡类型，1-普通卡，2-残障人士卡，3-禁止名单卡，4-巡更卡，5-胁迫卡，6-超级卡，7-来宾卡，8-解除卡，为0无效
        public byte byDeviceNo;                             // 设备编号，为0时无效（有效范围1-255）
        public byte byMask; //是否带口罩：0-保留，1-未知，2-不戴口罩，3-戴口罩
        public byte byCurrentEvent; //是否为实时事件：0-无效，1-是（实时事件），2-否（离线事件）
        public int dwFingerPrintDataLen;                  // 指纹数据大小，不为0是表示后面带数据
        public Pointer pFingerPrintData;
        public int dwCapturePicDataLen;                   // 抓拍图片数据大小，不为0是表示后面带数据
        public Pointer pCapturePicData;
        public int dwCertificatePicDataLen;   //证件抓拍图片数据大小，不为0是表示后面带数据
        public Pointer pCertificatePicData;
        public byte byCardReaderKind; //读卡器属于哪一类，0-无效，1-IC读卡器，2-身份证读卡器，3-二维码读卡器,4-指纹头
        public byte[] byRes3 = new byte[2];
        public byte byIDCardInfoExtend;    //pIDCardInfoExtend是否有效：0-无效，1-有效
        public Pointer pIDCardInfoExtend;    //byIDCardInfoExtend为1时，表示指向一个NET_DVR_ID_CARD_INFO_EXTEND结构体
        public int dwSerialNo; //事件流水号，为0无效
        public byte[] byRes = new byte[168];
    }

    public static final int CARD_READER_DESCRIPTION = 32;            //读卡器描述

    public static class NET_DVR_CARD_READER_CFG_V50 extends Structure {
        public int dwSize;
        public byte byEnable; //是否使能，1-使能，0-不使能
        public byte byCardReaderType; //读卡器类型，1-DS-K110XM/MK/C/CK，2-DS-K192AM/AMP，3-DS-K192BM/BMP，4-DS-K182AM/AMP，5-DS-K182BM/BMP，6-DS-K182AMF/ACF，7-韦根或485不在线，8- DS-K1101M/MK，9- DS-K1101C/CK，10- DS-K1102M/MK/M-A，11- DS-K1102C/CK，12- DS-K1103M/MK，13- DS-K1103C/CK，14- DS-K1104M/MK，15- DS-K1104C/CK，16- DS-K1102S/SK/S-A，17- DS-K1102G/GK，18- DS-K1100S-B，19- DS-K1102EM/EMK，20- DS-K1102E/EK，21- DS-K1200EF，22- DS-K1200MF，23- DS-K1200CF，24- DS-K1300EF，25- DS-K1300MF，26- DS-K1300CF，27- DS-K1105E，28- DS-K1105M，29- DS-K1105C，30- DS-K182AMF，31- DS-K196AMF，32-DS-K194AMP，33-DS-K1T200EF/EF-C/MF/MF-C/CF/CF-C,34-DS-K1T300EF/EF-C/MF/MF-C/CF/CF-C，35-DS-K1T105E/E-C/M/M-C/C/C-C,36-DS-K1T803F/F-M/F-S/F-E,37-DS-K1A801F/F-M/F-S/F-E,38-DS-K1107M/MK,39-DS-K1107E/EK,40-DS-K1107S/SK,41-DS-K1108M/MK,42-DS-K1108E/EK,43-DS-K1108S/SK,44-DS-K1200F,45-DS-K1S110-I,46-DS-K1T200M-PG/PGC,47-DS-K1T200M-PZ/PZC,48-DS-K1109H
        public byte byOkLedPolarity; //OK LED极性，0-阴极，1-阳极
        public byte byErrorLedPolarity; //Error LED极性，0-阴极，1-阳极
        public byte byBuzzerPolarity; //蜂鸣器极性，0-阴极，1-阳极
        public byte bySwipeInterval; //重复刷卡间隔时间，单位：秒
        public byte byPressTimeout;  //按键超时时间，单位：秒
        public byte byEnableFailAlarm; //是否启用读卡失败超次报警，0-不启用，1-启用
        public byte byMaxReadCardFailNum; //最大读卡失败次数
        public byte byEnableTamperCheck;  //是否支持防拆检测，0-disable ，1-enable
        public byte byOfflineCheckTime;  //掉线检测时间 单位秒
        public byte byFingerPrintCheckLevel; //指纹识别等级，1-1/10误认率，2-1/100误认率，3-1/1000误认率，4-1/10000误认率，5-1/100000误认率，6-1/1000000误认率，7-1/10000000误认率，8-1/100000000误认率，9-3/100误认率，10-3/1000误认率，11-3/10000误认率，12-3/100000误认率，13-3/1000000误认率，14-3/10000000误认率，15-3/100000000误认率，16-Automatic Normal,17-Automatic Secure,18-Automatic More Secure（目前门禁不支持）
        public byte byUseLocalController; //只读，是否连接在就地控制器上，0-否，1-是
        public byte byRes1;
        public short wLocalControllerID; //只读，就地控制器序号, byUseLocalController=1时有效，1-64,0代表未注册
        public short wLocalControllerReaderID; //只读，就地控制器的读卡器ID，byUseLocalController=1时有效，0代表未注册
        public short wCardReaderChannel; //只读，读卡器通信通道号，byUseLocalController=1时有效，0韦根或离线，1-RS485A,2-RS485B
        public byte byFingerPrintImageQuality; //指纹图像质量，0-无效，1-低质量(V1)，2-中等质量(V1)，3-高质量(V1)，4-最高质量(V1)，5-低质量(V2)，6-中等质量(V2)，7-高质量(V2)，8-最高质量(V2)
        public byte byFingerPrintContrastTimeOut; //指纹对比超时时间，0-无效，范围1-20代表:1s-20s，0xff-无限大
        public byte byFingerPrintRecogizeInterval; //指纹连续识别间隔，0-无效，范围1-10代表:1s-10s，0xff-无延迟
        public byte byFingerPrintMatchFastMode; //指纹匹配快速模式，0-无效，范围1-5代表:快速模式1-快速模式5，0xff-自动
        public byte byFingerPrintModuleSensitive; //指纹模组灵敏度，0-无效，范围1-8代表：灵敏度级别1-灵敏度级别8
        public byte byFingerPrintModuleLightCondition; //指纹模组光线条件，0-无效，1-室外，2-室内
        public byte byFaceMatchThresholdN; //人脸比对阀值，范围0-100
        public byte byFaceQuality; //人脸质量，范围0-100
        public byte byFaceRecogizeTimeOut; //人脸识别超时时间，范围1-20代表：1s-20s，0xff-无限大
        public byte byFaceRecogizeInterval; //人脸连续识别间隔，0-无效，范围1-10代表：1s-10s，0xff-无延迟
        public short wCardReaderFunction; //只读，读卡器种类，按位表示：第1位-指纹，第二位-人脸，第三位-指静脉
        public byte[] byCardReaderDescription = new byte[CARD_READER_DESCRIPTION]; //读卡器描述
        public short wFaceImageSensitometry; //只读，人脸图像曝光度，范围0-65535
        public byte byLivingBodyDetect; //真人检测，0-无效，1-不启用，2-启用
        public byte byFaceMatchThreshold1; //人脸1:1匹配阀值，范围0-100
        public short wBuzzerTime; //蜂鸣时间，范围0s-5999s（0-代表长鸣）
        public byte byFaceMatch1SecurityLevel; //人脸1:1识别安全等级，0-无效，1-一般，2-较强，3-极强
        public byte byFaceMatchNSecurityLevel; //人脸1:N识别安全等级，0-无效，1-一般，2-较强，3-极强
        public byte byEnvirMode;//人脸识别环境模式，0-无效，1-室内，2-其他；
        public byte byLiveDetLevelSet;//活体检测阈值等级设置，0-无效，1-低，2-中，3-高；
        public byte byLiveDetAntiAttackCntLimit;//活体检测防攻击次数， 0-无效，1-255次（客户端、设备统一次数限制，根据能力级限制）；
        public byte byEnableLiveDetAntiAttack;//活体检测防攻击使能，0-无效，1-不启用，2-启用
        public byte bySupportDelFPByID;//只读，读卡器是否支持按手指ID删除指纹，0-无效，1-不支持，2-支持
        public byte byFaceContrastMotionDetLevel;//人脸比对时移动侦测级别，0-无效，1-低，2-中，3-高，0xff-禁用
        public byte byDayFaceMatchThresholdN; //白天人脸1:N匹配阀值，范围0-100
        public byte byNightFaceMatchThresholdN; //夜晚人脸1:N匹配阀值，范围0-100
        public byte byFaceRecogizeEnable; //人脸识别使能：0-无效，1-开启，2-关闭
        public byte byBlockListMatchThreshold; //禁止名单匹配阀值，范围0-100
        public byte byRes3;
        public byte byDefaultVerifyMode; //只读，读卡器默认验证方式（出厂默认），1-休眠，2-刷卡+密码，3-刷卡，4-刷卡或密码，5-指纹，6-指纹+密码，7-指纹或刷卡，8-指纹+刷卡，9-指纹+刷卡+密码，10-人脸或指纹或刷卡或密码，11-人脸+指纹，12-人脸+密码，13-人脸+刷卡，14-人脸，15-工号+密码，16-指纹或密码，17-工号+指纹，18-工号+指纹+密码，19-人脸+指纹+刷卡，20-人脸+密码+指纹，21-工号+人脸，22-人脸或人脸+刷卡，23-指纹或人脸，24-刷卡或人脸或密码，25-刷卡或人脸，26-刷卡或人脸或指纹，27-刷卡或指纹或密码
        public int dwFingerPrintCapacity;//只读，指纹容量
        public int dwFingerPrintNum;//只读，已存在指纹数量
        public byte byEnableFingerPrintNum;//只读，指纹容量使能：0-不使能，1-使能（只有当该字段为1-使能时，dwFingerPrintCapacity和dwFingerPrintNum才有效）
        public byte[] byRes = new byte[231];
    }

    /****************优化接口结构体定义开始*************/
    public static final int NET_DVR_GET_CARD = 2560;
    public static final int NET_DVR_SET_CARD = 2561;
    public static final int NET_DVR_GET_FACE = 2566;
    public static final int NET_DVR_SET_FACE = 2567;
    public static final int NET_DVR_DEL_CARD = 2562;

    public static final int NET_SDK_CONFIG_STATUS_SUCCESS = 1000;
    public static final int NET_SDK_CONFIG_STATUS_NEEDWAIT = 1001;
    public static final int NET_SDK_CONFIG_STATUS_FINISH = 1002;
    public static final int NET_SDK_CONFIG_STATUS_FAILED = 1003;
    public static final int NET_SDK_CONFIG_STATUS_EXCEPTION = 1004;

    public static final int NET_SDK_GET_NEXT_STATUS_SUCCESS = 1000;
    public static final int NET_SDK_GET_NEXT_STATUS_NEED_WAIT = 1001;
    public static final int NET_SDK_NEXT_STATUS__FINISH = 1002;
    public static final int NET_SDK_GET_NEXT_STATUS_FAILED = 1003;

    public static class NET_DVR_CARD_COND extends Structure {
        public int dwSize;
        public int dwCardNum; //设置或获取卡数量，获取时置为0xffffffff表示获取所有卡信息
        public byte[] byRes = new byte[64];
    }

    public static class NET_DVR_CARD_SEND_DATA extends Structure {
        public int dwSize;
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN]; //卡号
        public byte[] byRes = new byte[16];
    }

    public static class NET_DVR_CARD_RECORD extends Structure {
        public int dwSize;
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN];
        public byte byCardType;
        public byte byLeaderCard;
        public byte byUserType;
        public byte byRes1;
        public byte[] byDoorRight = new byte[MAX_DOOR_NUM_256];
        public NET_DVR_VALID_PERIOD_CFG struValid = new NET_DVR_VALID_PERIOD_CFG();
        public byte[] byBelongGroup = new byte[MAX_GROUP_NUM_128];
        public byte[] byCardPassword = new byte[CARD_PASSWORD_LEN];
        public short[] wCardRightPlan = new short[MAX_DOOR_NUM_256];
        public int dwMaxSwipeTimes;
        public int dwSwipeTimes;
        public int dwEmployeeNo;
        public byte[] byName = new byte[NAME_LEN];
        //按位表示，0-无权限，1-有权限
        //第0位表示：弱电报警
        //第1位表示：开门提示音
        //第2位表示：限制客卡
        //第3位表示：通道
        //第4位表示：反锁开门
        //第5位表示：巡更功能
        public int dwCardRight;
        public byte[] byRes = new byte[256];
    }

    public static class NET_DVR_CARD_STATUS extends Structure {
        public int dwSize;
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN];
        public int dwErrorCode;
        public byte byStatus; // 状态：0-失败，1-成功
        public byte[] byRes = new byte[23];
    }


    public static class NET_DVR_FACE_COND extends Structure {
        public int dwSize;
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN];
        public int dwFaceNum;
        public int dwEnableReaderNo;
        public byte[] byRes = new byte[124];
    }

    public static class NET_DVR_FACE_RECORD extends Structure {
        public int dwSize;
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN];
        public int dwFaceLen;
        public Pointer pFaceBuffer;
        public byte[] byRes = new byte[128];
    }

    public static class NET_DVR_FACE_STATUS extends Structure {
        public int dwSize;
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN];
        public byte[] byErrorMsg = new byte[ERROR_MSG_LEN];
        public int dwReaderNo;
        public byte byRecvStatus;
        public byte[] byRes = new byte[131];
    }

    /**************优化接口结构体定义结束***************************/

//开锁记录
    public static class NET_DVR_UNLOCK_RECORD_INFO extends Structure {
        public byte byUnlockType; //开锁方式，参考UNLOCK_TYPE_ENUM
        public byte[] byRes1 = new byte[3]; //保留
        public byte[] byControlSrc = new byte[NAME_LEN]; //操作发起源信息，刷卡开锁时为卡号，蓝牙开锁时为萤石的APP账号，二维码开锁时为访客的手机号，其余情况下为设备编号
        public int dwPicDataLen; //图片数据长度
        public Pointer pImage; //图片指针
        public int dwCardUserID; //持卡人ID
        public short nFloorNumber;//刷卡开锁时有效，为楼层号
        public short wRoomNumber; //操作发起源附加信息，刷卡开锁时有效，为房间号，
        public short wLockID; //（对于门口机，0-表示本机控制器上接的锁、1-表示外接控制器上接的锁）
        public byte[] byRes2 = new byte[2];
        public byte[] byLockName = new byte[LOCK_NAME_LEN]; //刷卡开锁时有效，锁名称，对应门参数配置中门名称
        public byte[] byEmployeeNo = new byte[NET_SDK_EMPLOYEE_NO_LEN]; //工号（人员ID）
        public byte[] byRes = new byte[136]; //保留
    }

    //公告信息阅读回执
    public static class NET_DVR_NOTICEDATA_RECEIPT_INFO extends Structure {
        public byte[] byNoticeNumber = new byte[MAX_NOTICE_NUMBER_LEN]; //公告编号
        public byte[] byRes = new byte[224];  //保留
    }

    //认证记录（设备未实现）
    public static class NET_DVR_AUTH_INFO extends Structure {
        public byte byAuthResult; //认证结果：0-无效，1-认证成功，2-认证失败
        public byte byAuthType; //认证方式：0-无效，1-指纹，2-人脸
        public byte[] byRes1 = new byte[2]; //保留
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN/*32*/]; //卡号
        public int dwPicDataLen; //图片数据长度（当认证方式byAuthType为人脸时有效）
        public Pointer pImage; //图片指针（当认证方式byAuthType为人脸时有效）
        public byte[] byRes = new byte[212];  //保留
    }

    //车牌信息上传
    public static class NET_DVR_UPLOAD_PLATE_INFO extends Structure {
        public byte[] sLicense = new byte[MAX_LICENSE_LEN];        //车牌号码
        public byte byColor;                      //车牌颜色，参考结构VCA_PLATE_COLOR
        public byte[] byRes = new byte[239];  //保留
    }

    public static class NET_DVR_SEND_CARD_INFO extends Structure {
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN/*32*/]; //卡号
        public byte[] byRes = new byte[224];  //保留
    }

    //可视对讲事件记录信息联合体
    public static class NET_DVR_VIDEO_INTERCOM_EVENT_INFO_UINON extends Union {
        public byte[] byLen = new byte[256]; //联合体大小
        public NET_DVR_UNLOCK_RECORD_INFO struUnlockRecord = new NET_DVR_UNLOCK_RECORD_INFO(); //开锁记录
        public NET_DVR_NOTICEDATA_RECEIPT_INFO struNoticedataReceipt = new NET_DVR_NOTICEDATA_RECEIPT_INFO(); //公告信息阅读回执
        public NET_DVR_AUTH_INFO struAuthInfo = new NET_DVR_AUTH_INFO(); //认证记录（设备未实现）
        public NET_DVR_UPLOAD_PLATE_INFO struUploadPlateInfo = new NET_DVR_UPLOAD_PLATE_INFO(); //车牌信息上传
        public NET_DVR_SEND_CARD_INFO struSendCardInfo = new NET_DVR_SEND_CARD_INFO(); //门口机发卡,对应设备处于发卡状态，刷卡时上传该事件
    }

    //可视对讲事件记录
    public static class NET_DVR_VIDEO_INTERCOM_EVENT extends Structure {
        public int dwSize; //结构体大小
        public NET_DVR_TIME_EX struTime = new NET_DVR_TIME_EX(); //时间
        public byte[] byDevNumber = new byte[MAX_DEV_NUMBER_LEN]; //设备编号
        public byte byEventType; //事件信息类型，1-开锁记录，2-公告信息阅读回执，3-认证记录，4-车牌信息上传，5非法卡刷卡事件，6-门口机发卡记录(需要启动门口机发卡功能，刷卡时才会上传该事件)
        public byte byPicTransType;        //图片数据传输方式: 0-二进制；1-url
        public byte[] byRes1 = new byte[2]; //保留
        public NET_DVR_VIDEO_INTERCOM_EVENT_INFO_UINON uEventInfo = new NET_DVR_VIDEO_INTERCOM_EVENT_INFO_UINON(); //事件信息，具体内容参考byEventType取值
        public int dwIOTChannelNo;    //IOT通道号
        public byte[] byRes2 = new byte[252]; //保留
    }

    public static class NET_DVR_CONTROL_GATEWAY extends Structure {
        public int dwSize; //结构体大小
        public int dwGatewayIndex; //门禁序号，从1开始
        public byte byCommand; //操作命令，0-关闭，1-打开，2-常开（通道状态），3-恢复（普通状态）
        public byte byLockType; //锁类型，0-普通（以前默认都为0）,1-智能锁
        public short wLockID; //锁ID，从1开始（远程开门口机锁时，0表示门口机本机控制器上接的锁、1表示外接控制器上接的锁）
        public byte[] byControlSrc = new byte[NAME_LEN]; //操作发起源信息
        public byte byControlType; //开锁类型，1-监视，2-通话
        public byte[] byRes3 = new byte[3];
        public byte[] byPassword = new byte[PASSWD_LEN];       //锁密码，当byLockType为智能锁时有效
        public byte[] byRes2 = new byte[108]; //保留
    }


    //公告图片信息结构体
    public static class NET_DVR_NOTICE_PIC extends Structure {
        public Pointer pPicData; //图片指针
        public int dwPicDataLen; //图片数据长度
        public byte[] byRes = new byte[32]; //保留
    }

    //公告数据
    public static class NET_DVR_NOTICE_DATA extends Structure {
        public int dwSize; //结构体大小
        public NET_DVR_TIME_EX struTime = new NET_DVR_TIME_EX(); //公告时间
        public byte[] byNoticeNumber = new byte[MAX_NOTICE_NUMBER_LEN]; //公告编号
        public byte[] byNoticeTheme = new byte[MAX_NOTICE_THEME_LEN];//公告主题
        public byte[] byNoticeDetail = new byte[MAX_NOTICE_DETAIL_LEN]; //公告详情
        public byte byLevel; //公告等级，1-广告类信息；2-物业信息；3-报警类信息;4-通知类信息
        public byte byPicNum; //公告图片数量
        public byte[] byRes1 = new byte[2]; //保留
        public NET_DVR_NOTICE_PIC[] struNoticePic = new NET_DVR_NOTICE_PIC[MAX_NOTICE_PIC_NUM]; //公告图片
        public byte[] byRes2 = new byte[128]; //保留
    }

    public static class NET_DVR_DATE extends Structure {
        public short wYear;        //年
        public byte byMonth;        //月
        public byte byDay;        //日
    }

    //身份证信息
    public static class NET_DVR_ID_CARD_INFO extends Structure {
        public int dwSize;        //结构长度
        public byte[] byName = new byte[MAX_ID_NAME_LEN];   //姓名
        public NET_DVR_DATE struBirth; //出生日期
        public byte[] byAddr = new byte[MAX_ID_ADDR_LEN];  //住址
        public byte[] byIDNum = new byte[MAX_ID_NUM_LEN];   //身份证号码
        public byte[] byIssuingAuthority = new byte[MAX_ID_ISSUING_AUTHORITY_LEN];  //签发机关
        public NET_DVR_DATE struStartDate;  //有效开始日期
        public NET_DVR_DATE struEndDate;  //有效截止日期
        public byte byTermOfValidity;  //是否长期有效， 0-否，1-是（有效截止日期无效）
        public byte bySex;  //性别，1-男，2-女
        public byte byNation; //民族
        public byte[] byRes = new byte[101];
    }

    public static class NET_DVR_ACS_EVENT_INFO_EXTEND_V20 extends Structure {
        public byte byRemoteCheck; //是否需要远程核验（0-无效，1-不需要（默认），2-需要）
        public byte byThermometryUnit; //测温单位（0-摄氏度（默认），1-华氏度，2-开尔文）
        public byte byIsAbnomalTemperature; //人脸抓拍测温是否温度异常：1-是，0-否
        public byte byRes2;
        public float fCurrTemperature; //人脸温度（精确到小数点后一位）
        public NET_VCA_POINT struRegionCoordinates = new NET_VCA_POINT(); //人脸温度坐标
        public int dwQRCodeInfoLen; //二维码信息长度，不为0是表示后面带数据
        public int dwVisibleLightDataLen; //热成像相机可见光图片长度，不为0是表示后面带数据
        public int dwThermalDataLen; //热成像图片长度，不为0是表示后面带数据
        public Pointer pQRCodeInfo; //二维码信息指针
        public Pointer pVisibleLightData; //热成像相机可见光图片指针
        public Pointer pThermalData; //热成像图片指针
        public byte[] byRes = new byte[1024];


    }

    //门禁主机报警信息结构体
    public static class NET_DVR_ACS_ALARM_INFO extends Structure {
        public int dwSize;
        public int dwMajor; //报警主类型，参考宏定义
        public int dwMinor; //报警次类型，参考宏定义
        public NET_DVR_TIME struTime = new NET_DVR_TIME(); //时间
        public byte[] sNetUser = new byte[MAX_NAMELEN];//网络操作的用户名
        public NET_DVR_IPADDR struRemoteHostAddr = new NET_DVR_IPADDR();//远程主机地址
        public NET_DVR_ACS_EVENT_INFO struAcsEventInfo = new NET_DVR_ACS_EVENT_INFO(); //详细参数
        public int dwPicDataLen;   //图片数据大小，不为0是表示后面带数据
        public Pointer pPicData;
        public short wInductiveEventType; //归纳事件类型，0-无效，客户端判断该值为非0值后，报警类型通过归纳事件类型区分，否则通过原有报警主次类型（dwMajor、dwMinor）区分
        public byte byPicTransType;        //图片数据传输方式: 0-二进制；1-url
        public byte byRes1;             //保留字节
        public int dwIOTChannelNo;    //IOT通道号
        public Pointer pAcsEventInfoExtend;    //byAcsEventInfoExtend为1时，表示指向一个NET_DVR_ACS_EVENT_INFO_EXTEND结构体
        public byte byAcsEventInfoExtend;    //pAcsEventInfoExtend是否有效：0-无效，1-有效
        public byte byTimeType; //时间类型：0-设备本地时间，1-UTC时间（struTime的时间）
        public byte byRes2;             //保留字节
        public byte byAcsEventInfoExtendV20;    //pAcsEventInfoExtendV20是否有效：0-无效，1-有效
        public Pointer pAcsEventInfoExtendV20;    //byAcsEventInfoExtendV20为1时，表示指向一个NET_DVR_ACS_EVENT_INFO_EXTEND_V20结构体
        public byte[] byRes = new byte[4];
    }

    //门禁主机事件信息
    public static class NET_DVR_ACS_EVENT_INFO extends Structure {
        public int dwSize;
        public byte[] byCardNo = new byte[32];
        public byte byCardType;
        public byte byAllowListNo;
        public byte byReportChannel;
        public byte byCardReaderKind;
        public int dwCardReaderNo;
        public int dwDoorNo;
        public int dwVerifyNo;
        public int dwAlarmInNo;
        public int dwAlarmOutNo;
        public int dwCaseSensorNo;
        public int dwRs485No;
        public int dwMultiCardGroupNo;
        public short wAccessChannel;
        public byte byDeviceNo;
        public byte byDistractControlNo;
        public int dwEmployeeNo;
        public short wLocalControllerID;
        public byte byInternetAccess;
        public byte byType;
        public byte[] byMACAddr = new byte[MACADDR_LEN]; //物理地址，为0无效
        public byte bySwipeCardType;//刷卡类型，0-无效，1-二维码
        public byte byMask; //是否带口罩：0-保留，1-未知，2-不戴口罩，3-戴口罩
        public int dwSerialNo; //事件流水号，为0无效
        public byte byChannelControllerID; //通道控制器ID，为0无效，1-主通道控制器，2-从通道控制器
        public byte byChannelControllerLampID; //通道控制器灯板ID，为0无效（有效范围1-255）
        public byte byChannelControllerIRAdaptorID; //通道控制器红外转接板ID，为0无效（有效范围1-255）
        public byte byChannelControllerIREmitterID; //通道控制器红外对射ID，为0无效（有效范围1-255）
        public byte byHelmet;//可选，是否戴安全帽：0-保留，1-未知，2-不戴安全, 3-戴安全帽
        public byte[] byRes = new byte[3];
    }

    public static final int NET_DEV_NAME_LEN = 64;

    public static class NET_DVR_ACS_EVENT_INFO_EXTEND extends Structure {
        public int dwFrontSerialNo; //事件流水号，为0无效（若该字段为0，平台根据dwSerialNo判断是否丢失事件；若该字段不为0，平台根据该字段和dwSerialNo字段共同判断是否丢失事件）（主要用于解决报警订阅后导致dwSerialNo不连续的情况）
        public byte byUserType; //人员类型：0-无效，1-普通人（主人），2-来宾（访客），3-禁止名单人，4-管理员
        public byte byCurrentVerifyMode; //读卡器当前验证方式：0-无效，1-休眠，2-刷卡+密码，3-刷卡，4-刷卡或密码，5-指纹，6-指纹+密码，7-指纹或刷卡，8-指纹+刷卡，9-指纹+刷卡+密码，10-人脸或指纹或刷卡或密码，11-人脸+指纹，12-人脸+密码，13-人脸+刷卡，14-人脸，15-工号+密码，16-指纹或密码，17-工号+指纹，18-工号+指纹+密码，19-人脸+指纹+刷卡，20-人脸+密码+指纹，21-工号+人脸，22-人脸或人脸+刷卡，23-指纹或人脸，24-刷卡或人脸或密码，25-刷卡或人脸，26-刷卡或人脸或指纹，27-刷卡或指纹或密码
        public byte byCurrentEvent; //是否为实时事件：0-无效，1-是（实时事件），2-否（离线事件）
        public byte byPurePwdVerifyEnable; //设备是否支持纯密码认证， 0-不支持，1-支持
        public byte[] byEmployeeNo = new byte[NET_SDK_EMPLOYEE_NO_LEN]; //工号（人员ID）（对于设备来说，如果使用了工号（人员ID）字段，byEmployeeNo一定要传递，如果byEmployeeNo可转换为dwEmployeeNo，那么该字段也要传递；对于上层平台或客户端来说，优先解析byEmployeeNo字段，如该字段为空，再考虑解析dwEmployeeNo字段）
        public byte byAttendanceStatus; //考勤状态：0-未定义,1-上班，2-下班，3-开始休息，4-结束休息，5-开始加班，6-结束加班
        public byte byStatusValue; //考勤状态值
        public byte[] byRes2 = new byte[2];
        public byte[] byUUID = new byte[NET_SDK_UUID_LEN/*36*/]; //UUID（该字段仅在对接萤石平台过程中才会使用）
        public byte[] byDeviceName = new byte[NET_DEV_NAME_LEN/*64*/];   //设备序列号
        public byte[] byRes = new byte[24];

    }

    public static class NET_DVR_ACS_EVENT_DETAIL extends Structure {
        public int dwSize;
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN]; //卡号（mac地址），为0无效
        public byte byCardType; //卡类型，1-普通卡，2-残障人士卡，3-禁止名单卡，4-巡更卡，5-胁迫卡，6-超级卡，7-来宾卡，8-解除卡，为0无效
        public byte byAllowListNo; //允许名单单号,1-8，为0无效
        public byte byReportChannel; //报告上传通道，1-布防上传，2-中心组1上传，3-中心组2上传，为0无效
        public byte byCardReaderKind; //读卡器属于哪一类，0-无效，1-IC读卡器，2-身份证读卡器，3-二维码读卡器,4-指纹头
        public int dwCardReaderNo; //读卡器编号，为0无效
        public int dwDoorNo; //门编号（楼层编号），为0无效
        public int dwVerifyNo; //多重卡认证序号，为0无效
        public int dwAlarmInNo;  //报警输入号，为0无效
        public int dwAlarmOutNo; //报警输出号，为0无效
        public int dwCaseSensorNo; //事件触发器编号
        public int dwRs485No;    //RS485通道号，为0无效
        public int dwMultiCardGroupNo; //群组编号
        public short wAccessChannel;    //人员通道号
        public byte byDeviceNo; //设备编号，为0无效（有效范围1-255）
        public byte byDistractControlNo;//分控器编号，为0无效
        public int dwEmployeeNo; //工号，为0无效
        public short wLocalControllerID; //就地控制器编号，0-门禁主机，1-64代表就地控制器
        public byte byInternetAccess; //网口ID：（1-上行网口1,2-上行网口2,3-下行网口1）
        public byte byType;     //防区类型，0:即时防区,1-24小时防区,2-延时防区 ,3-内部防区，4-钥匙防区 5-火警防区 6-周界防区 7-24小时无声防区  8-24小时辅助防区，9-24小时震动防区,10-门禁紧急开门防区，11-门禁紧急关门防区 0xff-无
        public byte[] byMACAddr = new byte[MACADDR_LEN]; //物理地址，为0无效
        public byte bySwipeCardType;//刷卡类型，0-无效，1-二维码
        public byte byEventAttribute; //事件属性：0-未定义，1-合法认证，2-其它
        public int dwSerialNo; //事件流水号，为0无效
        public byte byChannelControllerID; //通道控制器ID，为0无效，1-主通道控制器，2-从通道控制器
        public byte byChannelControllerLampID; //通道控制器灯板ID，为0无效（有效范围1-255）
        public byte byChannelControllerIRAdaptorID; //通道控制器红外转接板ID，为0无效（有效范围1-255）
        public byte byChannelControllerIREmitterID; //通道控制器红外对射ID，为0无效（有效范围1-255）
        public int dwRecordChannelNum; //录像通道数目
        public Pointer pRecordChannelData;//录像通道，大小为sizeof(DWORD)* dwRecordChannelNum
        public byte byUserType; //人员类型：0-无效，1-普通人（主人），2-来宾（访客），3-禁止名单人，4-管理员
        public byte byCurrentVerifyMode; //读卡器当前验证方式：0-无效，1-休眠，2-刷卡+密码，3-刷卡，4-刷卡或密码，5-指纹，6-指纹+密码，7-指纹或刷卡，8-指纹+刷卡，9-指纹+刷卡+密码，10-人脸或指纹或刷卡或密码，11-人脸+指纹，12-人脸+密码，
        //13-人脸+刷卡，14-人脸，15-工号+密码，16-指纹或密码，17-工号+指纹，18-工号+指纹+密码，19-人脸+指纹+刷卡，20-人脸+密码+指纹，21-工号+人脸，22-人脸或人脸+刷卡，23-指纹或人脸，24-刷卡或人脸或密码，25-刷卡或人脸，26-刷卡或人脸或指纹，27-刷卡或指纹或密码
        public byte byAttendanceStatus;  //考勤状态：0-未定义,1-上班，2-下班，3-开始休息，4-结束休息，5-开始加班，6-结束加班
        public byte byStatusValue;  //考勤状态值
        public byte[] byEmployeeNo = new byte[NET_SDK_EMPLOYEE_NO_LEN]; //工号（人员ID）（对于设备来说，如果使用了工号（人员ID）字段，byEmployeeNo一定要传递，如果byEmployeeNo可转换为dwEmployeeNo，那么该字段也要传递；对于上层平台或客户端来说，优先解析byEmployeeNo字段，如该字段为空，再考虑解析dwEmployeeNo字段）
        public byte[] byRes = new byte[64];
    }

    public static class NET_DVR_ACS_EVENT_CFG extends Structure {
        public int dwSize;
        public int dwMajor; //报警主类型，参考宏定义
        public int dwMinor; //报警次类型，参考宏定义
        public NET_DVR_TIME struTime = new NET_DVR_TIME(); //时间
        public byte[] sNetUser = new byte[MAX_NAMELEN];//网络操作的用户名
        public NET_DVR_IPADDR struRemoteHostAddr;//远程主机地址
        public NET_DVR_ACS_EVENT_DETAIL struAcsEventInfo; //详细参数
        public int dwPicDataLen;   //图片数据大小，不为0是表示后面带数据
        public Pointer pPicData;
        public short wInductiveEventType; //归纳事件类型，0-无效，其他值参见2.2章节，客户端判断该值为非0值后，报警类型通过归纳事件类型区分，否则通过原有报警主次类型（dwMajor、dwMinor）区分
        public byte byTimeType; //时间类型：0-设备本地时间（默认），1-UTC时间（struTime的时间）
        public byte byRes1;
        public int dwQRCodeInfoLen; //二维码信息长度，不为0是表示后面带数据
        public int dwVisibleLightDataLen; //热成像相机可见光图片长度，不为0是表示后面带数据
        public int dwThermalDataLen; //热成像图片长度，不为0是表示后面带数据
        public Pointer pQRCodeInfo; //二维码信息指针
        public Pointer pVisibleLightData; //热成像相机可见光图片指针
        public Pointer pThermalData; //热成像图片指针
        public byte[] byRes = new byte[36];
    }

    public static final int NET_SDK_MONITOR_ID_LEN = 64;

    public static class NET_DVR_ACS_EVENT_COND extends Structure {
        public int dwSize;
        public int dwMajor; //报警主类型，参考事件上传宏定义，0-全部
        public int dwMinor; //报警次类型，参考事件上传宏定义，0-全部
        public NET_DVR_TIME struStartTime; //开始时间
        public NET_DVR_TIME struEndTime; //结束时间
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN]; //卡号
        public byte[] byName = new byte[NAME_LEN]; //持卡人姓名
        public byte byPicEnable; //是否带图片，0-不带图片，1-带图片
        public byte byTimeType; //时间类型：0-设备本地时间（默认），1-UTC时间（struStartTime和struEndTime的时间）
        public byte[] byRes2 = new byte[2]; //保留
        public int dwBeginSerialNo; //起始流水号（为0时默认全部）
        public int dwEndSerialNo; //结束流水号（为0时默认全部）
        public int dwIOTChannelNo; //IOT通道号，0-无效
        public short wInductiveEventType; //归纳事件类型，0-无效，其他值参见2.2章节，客户端判断该值为非0值后，报警类型通过归纳事件类型区分，否则通过原有报警主次类型（dwMajor、dwMinor）区分
        public byte bySearchType;      //搜索方式：0-保留，1-按事件源搜索（此时通道号为非视频通道号），2-按监控点ID搜索
        public byte byEventAttribute; //事件属性：0-未定义，1-合法事件，2-其它
        public byte[] szMonitorID = new byte[NET_SDK_MONITOR_ID_LEN/*64*/];          //监控点ID（由设备序列号、通道类型、编号组成，例如门禁点：设备序列号+“DOOR”+门编号）
        public byte[] byEmployeeNo = new byte[NET_SDK_EMPLOYEE_NO_LEN]; //工号（人员ID）
        public byte[] byRes = new byte[140]; //保留
    }

    public static class NET_DVR_ACS_WORK_STATUS_V50 extends Structure {
        public int dwSize;
        public byte[] byDoorLockStatus = new byte[MAX_DOOR_NUM_256]; //门锁状态(继电器开合状态)，0-正常关，1-正常开，2-短路报警，3-断路报警，4-异常报警
        public byte[] byDoorStatus = new byte[MAX_DOOR_NUM_256]; //门状态(楼层状态)，1-休眠，2-常开状态(自由)，3-常闭状态(禁用)，4-普通状态(受控)
        public byte[] byMagneticStatus = new byte[MAX_DOOR_NUM_256]; //门磁状态，0-正常关，1-正常开，2-短路报警，3-断路报警，4-异常报警
        public byte[] byCaseStatus = new byte[MAX_CASE_SENSOR_NUM]; //事件触发器状态，0-无输入，1-有输入
        public short wBatteryVoltage; //蓄电池电压值，实际值乘10，单位：伏特
        public byte byBatteryLowVoltage; //蓄电池是否处于低压状态，0-否，1-是
        public byte byPowerSupplyStatus; //设备供电状态，1-交流电供电，2-蓄电池供电
        public byte byMultiDoorInterlockStatus; //多门互锁状态，0-关闭，1-开启
        public byte byAntiSneakStatus; //反潜回状态，0-关闭，1-开启
        public byte byHostAntiDismantleStatus; //主机防拆状态，0-关闭，1-开启
        public byte byIndicatorLightStatus; //指示灯状态，0-掉线，1-在线
        public byte[] byCardReaderOnlineStatus = new byte[MAX_CARD_READER_NUM_512]; //读卡器在线状态，0-不在线，1-在线
        public byte[] byCardReaderAntiDismantleStatus = new byte[MAX_CARD_READER_NUM_512]; //读卡器防拆状态，0-关闭，1-开启
        public byte[] byCardReaderVerifyMode = new byte[MAX_CARD_READER_NUM_512]; //读卡器当前验证方式，1-休眠，2-刷卡+密码，3-刷卡，4-刷卡或密码
        public byte[] bySetupAlarmStatus = new byte[MAX_ALARMHOST_ALARMIN_NUM];//报警输入口布防状态，0-对应报警输入口处于撤防状态，1-对应报警输入口处于布防状态
        public byte[] byAlarmInStatus = new byte[MAX_ALARMHOST_ALARMIN_NUM]; //按位表示报警输入口报警状态，0-对应报警输入口当前无报警，1-对应报警输入口当前有报警
        public byte[] byAlarmOutStatus = new byte[MAX_ALARMHOST_ALARMOUT_NUM]; //按位表示报警输出口状态，0-对应报警输出口无报警，1-对应报警输出口有报警
        public int dwCardNum; //已添加的卡数量
        public byte byFireAlarmStatus; //消防报警状态显示：0-正常、1-短路报警、2-断开报警
        public byte byBatteryChargeStatus; //电池充电状态：0-无效；1-充电中；2-未充电
        public byte byMasterChannelControllerStatus; //主通道控制器在线状态：0-无效；1-不在线；2-在线
        public byte bySlaveChannelControllerStatus; //从通道控制器在线状态：0-无效；1-不在线；2-在线
        public byte byAntiSneakServerStatus; //反潜回服务器状态：0-无效，1-未启用，2-正常，3-断开
        public byte[] byRes3 = new byte[3];
        public int dwAllowFaceNum; //已添加的允许名单人脸数量（通过能力集判断）
        public int dwBlockFaceNum; //已添加的禁止名单人脸数量（通过能力集判断）
        public byte[] byRes2 = new byte[108];
    }

    public static class NET_DVR_FACE_PARAM_COND extends Structure {
        public int dwSize;
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN];    //人脸关联的卡号
        public byte[] byEnableCardReader = new byte[MAX_CARD_READER_NUM_512];  //人脸的读卡器是否有效，0-无效，1-有效
        public int dwFaceNum;    //设置或获取人脸数量，获取时置为0xffffffff表示获取所有人脸信息
        public byte byFaceID;     //人脸编号，有效值范围为1-2   0xff表示该卡所有人脸
        public byte[] byRes = new byte[127];   //保留
    }

    public static class NET_DVR_FACE_PARAM_CFG extends Structure {
        public int dwSize;
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN];    //人脸关联的卡号
        public int dwFaceLen;    //人脸数据长度<DES加密处理>，设备端返回的即加密后的数据
        public Pointer pFaceBuffer;  //人脸数据指针
        public byte[] byEnableCardReader = new byte[MAX_CARD_READER_NUM_512];  //需要下发人脸的读卡器，按数组表示，从低位到高位表示，0-不下发该读卡器，1-下发到该读卡器
        public byte byFaceID;     //人脸编号，有效值范围为1-2
        public byte byFaceDataType;   //人脸数据类型：0-模板（默认），1-图片
        public byte[] byRes = new byte[126];
    }

    public static class NET_DVR_FACE_PARAM_STATUS extends Structure {
        public int dwSize;
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN]; //人脸关联的卡号
        public byte[] byCardReaderRecvStatus = new byte[MAX_CARD_READER_NUM_512];  //人脸读卡器状态，按字节表示，0-失败，1-成功，2-重试或人脸质量差，3-内存已满，4-已存在该人脸，5-非法人脸ID
        public byte[] byErrorMsg = new byte[ERROR_MSG_LEN]; //下发错误信息，当byCardReaderRecvStatus为4时，表示已存在人脸对应的卡号
        public int dwCardReaderNo;  //纹读卡器编号，可用于下发错误返回
        public byte byTotalStatus;  //下发总的状态，0-当前人脸未下完所有读卡器，1-已下完所有读卡器(这里的所有指的是门禁主机往所有的读卡器下发了，不管成功与否)
        public byte byFaceID;     //人脸编号，有效值范围为1-2
        public byte[] byRes = new byte[130];
    }

    public static class NET_DVR_FACE_PARAM_BYCARD extends Structure {
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN]; //人脸关联的卡号
        public byte[] byEnableCardReader = new byte[MAX_CARD_READER_NUM_512];  //人脸的读卡器信息，按数组表示
        public byte[] byFaceID = new byte[MAX_FACE_NUM];        //需要删除的人脸编号，按数组下标，值表示0-不删除，1-删除该人脸
        public byte[] byRes1 = new byte[42];          //保留
    }

    public static class NET_DVR_FACE_PARAM_BYREADER extends Structure {
        public int dwCardReaderNo;  //按值表示，人脸读卡器编号
        public byte byClearAllCard;  //是否删除所有卡的人脸信息，0-按卡号删除人脸信息，1-删除所有卡的人脸信息
        public byte[] byRes1 = new byte[3];       //保留
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN]; //人脸关联的卡号
        public byte[] byRes = new byte[548];          //保留
    }

    public static class NET_DVR_DEL_FACE_PARAM_MODE extends Union {
        public byte[] uLen = new byte[588];   //联合体长度
        public NET_DVR_FACE_PARAM_BYCARD struByCard;     //按卡号的方式删除
        public NET_DVR_FACE_PARAM_BYREADER struByReader;   //按读卡器的方式删除
    }

    public static class NET_DVR_FACE_PARAM_CTRL extends Structure {
        public int dwSize;
        public byte byMode;          //删除方式，0-按卡号方式删除，1-按读卡器删除
        public byte[] byRes1 = new byte[3];        //保留
        public NET_DVR_DEL_FACE_PARAM_MODE struProcessMode;  //处理方式
        public byte[] byRes = new byte[64];          //保留
    }

    public static class NET_DVR_CHECK_FACE_PICTURE_COND extends Structure {
        public int dwSize;
        public int dwPictureNum; //图片数量
        public byte byCheckTemplate; //0-校验图片是否合法（默认），1-校验图片和建模数据是否匹配
        public byte[] byRes = new byte[127];
    }

    public static class NET_DVR_CHECK_FACE_PICTURE_CFG extends Structure {
        public int dwSize;
        public int dwPictureNo; //图片编号
        public int dwPictureLen; //图片长度（图片大小不超过200k）
        public Pointer pPictureBuffer; //图片指针
        public int dwFaceTemplateLen;  //人脸建模数据长度
        public Pointer pFaceTemplateBuffer;   //人脸建模数据指针
        public byte[] byRes = new byte[248];
    }

    public static class NET_DVR_CHECK_FACE_PICTURE_STATUS extends Structure {
        public int dwSize;
        public int dwPictureNo; //图片编号
        public byte byCheckStatus; //校验结果：0-无效，1-建模成功，2-建模失败，3-人脸模块通讯异常，4-图像无人脸，5-人脸朝上，6-人脸朝下，7-人脸偏左，8-人脸偏右，9-人脸顺时旋转，
        //10 - 人脸逆时旋转，11-人眼间距小，12-人脸和模板匹配，13-人脸和模板不匹配,14-传输数据有误
        public byte[] byRes = new byte[127];
    }

    public static class NET_DVR_FINGER_PRINT_CFG_V50 extends Structure {
        public int dwSize;
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN]; //指纹关联的卡号
        public int dwFingerPrintLen;    //指纹数据长度
        public byte[] byEnableCardReader = new byte[MAX_CARD_READER_NUM_512];  //需要下发指纹的读卡器，按数组表示，从低位到高位表示，0-不下发该读卡器，1-下发到该读卡器
        public byte byFingerPrintID;     //手指编号，有效值范围为1-10
        public byte byFingerType;       //指纹类型  0-普通指纹，1-胁迫指纹，2-巡更指纹，3-超级指纹，4-解除指纹
        public byte[] byRes1 = new byte[30];
        public byte[] byFingerData = new byte[MAX_FINGER_PRINT_LEN];        //指纹数据内容
        public byte[] byEmployeeNo = new byte[NET_SDK_EMPLOYEE_NO_LEN]; //工号（人员ID）
        public byte[] byLeaderFP = new byte[MAX_DOOR_NUM_256]; //对门是否有首次认证功能（按字节表示）：0-无首次认证功能，1-有首次认证功能
        public byte[] byRes = new byte[128];
    }

    public static class NET_DVR_FINGER_PRINT_STATUS_V50 extends Structure {
        public int dwSize;
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN]; //指纹关联的卡号
        public byte[] byCardReaderRecvStatus = new byte[MAX_CARD_READER_NUM_512];  //指纹读卡器状态，按字节表示，0-失败，1-成功，2-该指纹模组不在线，3-重试或指纹质量差，4-内存已满，5-已存在该指纹，6-已存在该指纹ID，7-非法指纹ID，8-该指纹模组无需配置，10-指纹读卡器版本过低（无法支持工号）
        public byte byFingerPrintID;     //手指编号，有效值范围为1-10
        public byte byFingerType;       //指纹类型  0-普通指纹，1-胁迫指纹，2-巡更指纹，3-超级指纹，4-解除指纹
        public byte byTotalStatus;  //下发总的状态，0-当前指纹未下完所有读卡器，1-已下完所有读卡器(这里的所有指的是门禁主机往所有的读卡器下发了，不管成功与否)
        public byte byRecvStatus;    //主机错误状态：0-成功，1-手指编号错误，2-指纹类型错误，3-卡号错误（卡号规格不符合设备要求），4-指纹未关联工号或卡号（工号或卡号字段为空），5-工号不存在，6-指纹数据长度为0，7-读卡器编号错误，8-工号错误
        public byte[] byErrorMsg = new byte[ERROR_MSG_LEN]; //下发错误信息，当byCardReaderRecvStatus为5时，表示已存在指纹对应的卡号
        public int dwCardReaderNo;  //当byCardReaderRecvStatus为5时，表示已存在指纹对应的指纹读卡器编号，可用于下发错误返回。0时表示无错误信息
        public byte[] byEmployeeNo = new byte[NET_SDK_EMPLOYEE_NO_LEN]; //工号（人员ID）
        public byte[] byErrorEmployeeNo = new byte[NET_SDK_EMPLOYEE_NO_LEN]; //下发错误信息，当byCardReaderRecvStatus为5时，表示已存在指纹对应的工号（人员ID）
        public byte[] byRes = new byte[128];
    }

    public static class NET_DVR_FINGER_PRINT_INFO_COND_V50 extends Structure {
        public int dwSize;
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN]; //指纹关联的卡号（该字段获取时有效，设置时无效）
        public byte[] byEnableCardReader = new byte[MAX_CARD_READER_NUM_512];  //指纹的读卡器是否有效，0-无效，1-有效
        public int dwFingerPrintNum; //设置或获指纹数量，获取时置为0xffffffff表示获取所有指纹信息
        public byte byFingerPrintID;     //手指编号，有效值范围为1-10   0xff表示该卡所有指纹
        public byte byCallBackMode;     //设备回调方式，0-设备所有读卡器下完了返回，1-在时间段内下了部分也返回
        public byte[] byRes2 = new byte[2];          //保留
        public byte[] byEmployeeNo = new byte[NET_SDK_EMPLOYEE_NO_LEN]; //工号（人员ID）
        public byte[] byRes1 = new byte[128];          //保留
    }

    //自定义结构体，用于二维数组转换
    public static class NET_DVR_SINGLE_PLAN_SEGMENT_WEEK extends Structure {
        public NET_DVR_SINGLE_PLAN_SEGMENT[] struPlanCfgDay = new NET_DVR_SINGLE_PLAN_SEGMENT[MAX_TIMESEGMENT_V30]; //一天的计划参数
    }

    public static class NET_DVR_WEEK_PLAN_CFG extends Structure {
        public int dwSize;
        public byte byEnable;  //是否使能，1-使能，0-不使能
        public byte[] byRes1 = new byte[3];
        public NET_DVR_SINGLE_PLAN_SEGMENT_WEEK[] struPlanCfg = new NET_DVR_SINGLE_PLAN_SEGMENT_WEEK[MAX_DAYS]; //周计划参数
        public byte[] byRes2 = new byte[16];
    }

    public static class NET_DVR_SINGLE_PLAN_SEGMENT extends Structure {
        public byte byEnable; //是否使能，1-使能，0-不使能
        public byte byDoorStatus; //门状态模式（梯控模式），0-无效，1-常开状态（自由），2-常闭状态（禁用），3-普通状态（门状态计划使用）
        public byte byVerifyMode; //验证方式，0-无效，1-刷卡，2-刷卡+密码(读卡器验证方式计划使用)，3-刷卡,4-刷卡或密码(读卡器验证方式计划使用), 5-指纹，6-指纹+密码，7-指纹或刷卡，8-指纹+刷卡，9-指纹+刷卡+密码（无先后顺序），10-人脸或指纹或刷卡或密码，11-人脸+指纹，12-人脸+密码，
        //13-人脸+刷卡，14-人脸，15-工号+密码，16-指纹或密码，17-工号+指纹，18-工号+指纹+密码，19-人脸+指纹+刷卡，20-人脸+密码+指纹，21-工号+人脸，22-人脸或人脸+刷卡
        public byte[] byRes = new byte[5];
        public NET_DVR_TIME_SEGMENT struTimeSegment; //时间段参数
    }


    public static class NET_DVR_TIME_SEGMENT extends Structure {
        public NET_DVR_SIMPLE_DAYTIME struBeginTime; //开始时间点
        public NET_DVR_SIMPLE_DAYTIME struEndTime;   //结束时间点
    }

    public static class NET_DVR_SIMPLE_DAYTIME extends Structure {
        public byte byHour; //时
        public byte byMinute; //分
        public byte bySecond; //秒
        public byte byRes;
    }

    public static class NET_DVR_WEEK_PLAN_COND extends Structure {
        public int dwSize;
        public int dwWeekPlanNumber; //周计划编号
        public short wLocalControllerID; //就地控制器序号[1,64]
        public byte[] byRes = new byte[106];
    }

    public static final int TEMPLATE_NAME_LEN = 32;      //计划模板名称长度
    public static final int MAX_HOLIDAY_GROUP_NUM = 16;  //计划模板最大假日组数

    public static class NET_DVR_PLAN_TEMPLATE extends Structure {
        public int dwSize;
        public byte byEnable; //是否启用，1-启用，0-不启用
        public byte[] byRes1 = new byte[3];
        public byte[] byTemplateName = new byte[TEMPLATE_NAME_LEN]; //模板名称
        public int dwWeekPlanNo; //周计划编号，0为无效
        public int[] dwHolidayGroupNo = new int[MAX_HOLIDAY_GROUP_NUM]; //假日组编号，就前填充，遇0无效
        public byte[] byRes2 = new byte[32];
    }

    public static class NET_DVR_PLAN_TEMPLATE_COND extends Structure {
        public int dwSize;
        public int dwPlanTemplateNumber; //计划模板编号，从1开始，最大值从门禁能力集获取
        public short wLocalControllerID; //就地控制器序号[1,64]，0无效
        public byte[] byRes = new byte[106];
    }

    public static class NET_DVR_CAPTURE_FACE_COND extends Structure {
        public int dwSize;
        public byte[] byRes = new byte[128];
    }

    public static class NET_DVR_FACE_FEATURE extends Structure {
        public NET_VCA_RECT struFace; //人脸子图区域
        public NET_VCA_POINT struLeftEye;    // 左眼坐标
        public NET_VCA_POINT struRightEye;   // 右眼坐标
        public NET_VCA_POINT struLeftMouth;  // 嘴左边坐标
        public NET_VCA_POINT struRightMouth; // 嘴右边坐标
        public NET_VCA_POINT struNoseTip;   // 鼻子坐标
    }

    public static class NET_DVR_CAPTURE_FACE_CFG extends Structure {
        public int dwSize;
        public int dwFaceTemplate1Size;  //人脸模板1数据大小，等于0时，代表无人脸模板1数据
        public Pointer pFaceTemplate1Buffer; //人脸模板1数据缓存（不大于2.5k）
        public int dwFaceTemplate2Size;  //人脸模板2数据大小，等于0时，代表无人脸模板2数据
        public Pointer pFaceTemplate2Buffer; //人脸模板2数据缓存（不大于2.5K）
        public int dwFacePicSize;        //人脸图片数据大小，等于0时，代表无人脸图片数据
        public Pointer pFacePicBuffer;       //人脸图片数据缓存
        public byte byFaceQuality1;        //人脸质量，范围1-100
        public byte byFaceQuality2;        //人脸质量，范围1-100
        public byte byCaptureProgress;    //采集进度，目前只有两种进度值：0-未采集到人脸，100-采集到人脸（只有在进度为100时，才解析人脸信息）
        public byte byFacePicQuality;  //人脸图片中人脸质量
        public int dwInfraredFacePicSize;   //红外人脸图片数据大小，等于0时，代表无人脸图片数据
        public Pointer pInfraredFacePicBuffer;      //红外人脸图片数据缓存
        public byte byInfraredFacePicQuality;  //红外人脸图片中人脸质量
        public byte[] byRes1 = new byte[3];
        public NET_DVR_FACE_FEATURE struFeature = new NET_DVR_FACE_FEATURE(); //人脸抠图特征信息
        public byte[] byRes = new byte[56];
    }

    public static class NET_DVR_XML_CONFIG_INPUT extends Structure {
        public int dwSize;
        public Pointer lpRequestUrl;
        public int dwRequestUrlLen;
        public Pointer lpInBuffer;
        public int dwInBufferSize;
        public int dwRecvTimeOut;
        public byte[] byRes = new byte[32];
    }

    public static class NET_DVR_STRING_POINTER extends Structure {
        public byte[] byString = new byte[2 * 1024];
    }

    public static class NET_DVR_XML_CONFIG_OUTPUT extends Structure {
        public int dwSize;
        public Pointer lpOutBuffer;
        public int dwOutBufferSize;
        public int dwReturnedXMLSize;
        public Pointer lpStatusBuffer;
        public int dwStatusSize;
        public byte[] byRes = new byte[32];
    }

    //报警场景信息
    public static class NET_DVR_SCENE_INFO extends Structure {
        public int dwSceneID;              //场景ID, 0 - 表示该场景无效
        public byte[] bySceneName = new byte[NAME_LEN];  //场景名称
        public byte byDirection;            //监测方向 1-上行，2-下行，3-双向，4-由东向西，5-由南向北，6-由西向东，7-由北向南，8-其它
        public byte[] byRes1 = new byte[3];              //保留
        public NET_DVR_PTZPOS struPtzPos;             //Ptz 坐标
        public byte[] byRes2 = new byte[64];            //保留
    }

    // 方向结构体
    public static class NET_DVR_DIRECTION extends Structure {
        public NET_VCA_POINT struStartPoint = new NET_VCA_POINT();   // 方向起始点
        public NET_VCA_POINT struEndPoint = new NET_VCA_POINT();     // 方向结束点
    }

    // 交通事件信息
    public static class NET_DVR_AID_INFO extends Structure {
        public byte byRuleID;   // 规则序号，为规则配置结构下标，0-16
        public byte[] byRes1 = new byte[3];
        public byte[] byRuleName = new byte[NAME_LEN]; //  规则名称
        public int dwAIDType;  // 报警事件类型
        public NET_DVR_DIRECTION struDirect = new NET_DVR_DIRECTION(); // 报警指向区域
        public byte bySpeedLimit; //限速值，单位km/h[0,255]
        public byte byCurrentSpeed; //当前速度值，单位km/h[0,255]
        public byte byVehicleEnterState; //车辆出入状态：0- 无效，1- 驶入，2- 驶出
        public byte byState; //0-变化上传，1-轮巡上传
        public byte[] byParkingID = new byte[16]; //停车位编号
        public byte[] byRes2 = new byte[20];  // 保留字节
    }

    public int ILLEGAL_LEN = 32; //违法代码长度
    public int MONITORSITE_ID_LEN = 48;//监测点编号长度
    public int DEVICE_ID_LEN = 48;

    //交通取证报警
    public static class NET_DVR_TFS_ALARM extends Structure {
        public int dwSize;                //结构体大小
        public int dwRelativeTime;        //相对时标
        public int dwAbsTime;               //绝对时标
        public int dwIllegalType;         //违章类型，采用国标定义，当dwIllegalType值为0xffffffff时使用byIllegalCode
        public int dwIllegalDuration;     //违法持续时间（单位：秒） = 抓拍最后一张图片的时间 - 抓拍第一张图片的时间
        public byte[] byMonitoringSiteID = new byte[MONITORSITE_ID_LEN];//监测点编号（路口编号、内部编号）
        public byte[] byDeviceID = new byte[DEVICE_ID_LEN];             //设备编号
        public NET_VCA_DEV_INFO struDevInfo = new NET_VCA_DEV_INFO();           //前端设备信息
        public NET_DVR_SCENE_INFO struSceneInfo = new NET_DVR_SCENE_INFO();         //场景信息
        public NET_DVR_TIME_EX struBeginRecTime = new NET_DVR_TIME_EX();      //录像开始时间
        public NET_DVR_TIME_EX struEndRecTime = new NET_DVR_TIME_EX();        //录像结束时间
        public NET_DVR_AID_INFO struAIDInfo = new NET_DVR_AID_INFO();           //交通事件信息
        public NET_DVR_PLATE_INFO struPlateInfo = new NET_DVR_PLATE_INFO();         //车牌信息
        public NET_DVR_VEHICLE_INFO struVehicleInfo = new NET_DVR_VEHICLE_INFO();       //车辆信息
        public int dwPicNum; //图片数量
        public NET_ITS_PICTURE_INFO[] struPicInfo = new NET_ITS_PICTURE_INFO[8];        //图片信息，最多8张
        public byte bySpecificVehicleType;     //具体车辆种类  参考识别结果类型VTR_RESULT
        public byte byLaneNo;  //关联车道号
        public byte[] byRes1 = new byte[2]; //保留
        public NET_DVR_TIME_V30 struTime = new NET_DVR_TIME_V30();//手动跟踪定位，当前时间。
        public int dwSerialNo;//序号；
        public byte byVehicleAttribute;//车辆属性，按位表示，0- 无附加属性(普通车)，bit1- 黄标车(类似年检的标志)，bit2- 危险品车辆，值：0- 否，1- 是
        public byte byPilotSafebelt;//0-表示未知,1-系安全带,2-不系安全带
        public byte byCopilotSafebelt;//0-表示未知,1-系安全带,2-不系安全带
        public byte byPilotSunVisor;//0-表示未知,1-不打开遮阳板,2-打开遮阳板
        public byte byCopilotSunVisor;//0-表示未知, 1-不打开遮阳板,2-打开遮阳板
        public byte byPilotCall;// 0-表示未知, 1-不打电话,2-打电话
        public byte[] byRes2 = new byte[2]; //保留
        public byte[] byIllegalCode = new byte[ILLEGAL_LEN/*32*/];//违法代码扩展，当dwIllegalType值为0xffffffff；使用这个值
        public short wCountry; // 国家索引值,参照枚举COUNTRY_INDEX
        public byte byRegion; //区域索引值,0-保留，1-欧洲(Europe Region)，2-俄语区域(Russian Region)，3-欧洲&俄罗斯(EU&CIS) , 4-中东（Middle East），0xff-所有
        public byte byCrossLine;//是否压线停车（侧方停车），0-表示未知，1-不压线，2-压线
        public byte[] byParkingSerialNO = new byte[16];//泊车位编号
        public byte byCrossSpaces;//是否跨泊车位停车（侧方停车），0-表示未知，1-未跨泊车位停车，2-跨泊车位停车
        public byte byAngledParking;//是否倾斜停车（侧方停车）, 0-表示未知，1-未倾斜停车，2-倾斜停车
        public byte byAlarmValidity;//报警置信度，可以输出驶入驶出的置信度，范围0-100；置信度越高，事件真实性越高
        public byte byDoorsStatus;//车门状态 0-车门关闭 1-车门开启
        public int dwXmlLen;//XML报警信息长度
        public Pointer pXmlBuf; // XML报警信息指针,其XML对应到EventNotificationAlert XML Block
        public byte byVehicleHeadTailStatus;//车头车尾状态 0-保留 1-车头 2-车尾
        public byte[] byRes = new byte[31]; //保留
    }

    public static class NET_ITS_OVERLAPCFG_COND extends Structure {
        public int dwSize;
        public int dwChannel;
        public int dwConfigMode; //配置模式，0-终端，1-前端(直连前端或终端接前端)
        public byte byPicModeType;//0-表示小图(独立图)，1-表示大图(合成图)
        /*
          0表示关联 抓拍MPR模式（多帧触发抓拍 IPC使用）
          1 表示关联 抓拍 HVT 模式（混卡IPC使用）
        */
        public byte byRelateType;
        public byte[] byRes = new byte[14];

    }

    //字符叠加每一条信息结构体
    public static class NET_ITS_OVERLAP_SINGLE_ITEM_PARAM_V50 extends Structure {
        public byte[] byRes1 = new byte[2];                   // 保留
        public byte byItemType;       //类型，详见OVERLAP_ITEM_TYPE
        public byte byChangeLineNum; //叠加项后的换行数[0-10](默认0)
        public byte bySpaceNum;      //叠加项后的空格数[0-255](默认0)
        public byte[] byRes2 = new byte[2];
        public byte byEnablePos;  //是否启用坐标显示
        public short wStartPosTop;    //起始上坐标,只对图片内部叠加有效[0~2448](默认0)
        public short wStartPosLeft;    //起始左坐标,只对图片内部叠加有效[0~2448](默认0)
        //自定义类型；与byItemType参数对应。可将byItemType参数类型自定义名称。若自定义内容为空，便默认以byItemType参数中的类型命名。
        public byte[] byItemTypeCustom = new byte[32];
        public byte[] byRes = new byte[8];

    }

    public int MAX_OVERLAP_ITEM_NUM = 50; //最大字符叠加种数

    public static class NET_ITS_OVERLAP_ITEM_PARAM_V50 extends Structure {
        public NET_ITS_OVERLAP_SINGLE_ITEM_PARAM_V50[] struSingleItem = new NET_ITS_OVERLAP_SINGLE_ITEM_PARAM_V50[MAX_OVERLAP_ITEM_NUM]; //单条字符参数
        public int dwLinePercent;  //叠加行百分比(0-100),(默认100)
        public int dwItemsStlye;   //叠加方式：0-横排,1-竖排(默认横排)
        public short wStartPosTop;    //起始上坐标,只对图片内部叠加有效[0~2448](默认0)
        public short wStartPosLeft;    //起始左坐标,只对图片内部叠加有效[0~2448](默认0)
        public short wCharStyle;    //字体类型,0-宋体1-魏体(默认)
        public short wCharSize;    //字符大小,0--16x16,1--32x32,2-48x48,3--64x64 (默认),8x128(Ver3.7)
        public short wCharInterval;    //字符间距，[0～16]，可设单位：像素(默认)
        public byte[] byRes1 = new byte[2];
        public int dwForeClorRGB;      //前景色的RGB值bit0-1:(B) bit2-3:(G) bit4-5:(G) (默认x00FFFFFF-白)
        public int dwBackClorRGB; //背景色的RGB值,只对图片外叠加有效bit0-1:(B) bit2-3:(G) bit4-5:(G) (默认x00000000-黑)
        public byte byColorAdapt;    //颜色是否自适应0-否1-是
        //(Ver3.7 新增)
        // 参数补零使能 0-补零, 1-不补零（详细注释）速度,限速值 不足3位补0
        public byte byParamFillZeroEnble;
        public byte byPlateLeftCornerEnable;// 车牌小图叠加左上角使能 0-不叠加, 1-叠加
        public byte byRes2;
        public short wStartSPicPosTop; //起始上坐标,只对图片内部叠加有效[0~2448](默认0)
        public short wStartSPicPosLeft; //起始左坐标,只对图片内部叠加有效[0~2448](默认0)
        //OSD叠加位置  0-图片内,1-图片上边缘,2-图片下边缘（合成图专用的是上边缘外）（V3.7）
        public byte byOsdLocate;
        public byte[] byRes = new byte[63];

    }

    //叠加项具体信息
    public static class NET_ITS_OVERLAP_INFO_PARAM extends Structure {
        public byte[] bySite = new byte[128];           //地点描述
        public byte[] byRoadNum = new byte[32];  //路口编号
        public byte[] byInstrumentNum = new byte[32];                //设备编号
        public byte[] byDirection = new byte[32];        //方向编号
        public byte[] byDirectionDesc = new byte[32];    //方向描述
        public byte[] byLaneDes = new byte[32];        //车道描述
        public byte[] byRes1 = new byte[32];     //保留
        public byte[] byMonitoringSite1 = new byte[44];        //监测点1信息
        public byte[] byMonitoringSite2 = new byte[32];        //监测点2信息
        public byte[] byRes = new byte[64];        //保留
    }

    public static class NET_ITS_OVERLAP_CFG_V50 extends Structure {
        public int dwSize;
        public byte byEnable; //是否启用，0-不启用，1-启用
        public byte[] byRes1 = new byte[3];
        public NET_ITS_OVERLAP_ITEM_PARAM_V50 struOverLapItemV50 = new NET_ITS_OVERLAP_ITEM_PARAM_V50(); //字符串参数
        public NET_ITS_OVERLAP_INFO_PARAM struOverLapInfo = new NET_ITS_OVERLAP_INFO_PARAM();  //字符串内容信息
        public byte[] byRes = new byte[120];

    }

    //人体特征识别结果结构体
    public static class NET_VCA_HUMAN_FEATURE extends Structure {
        public byte byAgeGroup;    //年龄段,参见 HUMAN_AGE_GROUP_ENUM
        public byte bySex;         //性别, 0-表示“未知”（算法不支持）,1 – 男 , 2 – 女, 0xff-算法支持，但是没有识别出来
        public byte byEyeGlass;    //是否戴眼镜 0-表示“未知”（算法不支持）,1 – 不戴, 2 – 戴,0xff-算法支持，但是没有识别出来
        //抓拍图片人脸年龄的使用方式，如byAge为15,byAgeDeviation为1,表示，实际人脸图片年龄的为14-16之间
        public byte byAge;//年龄 0-表示“未知”（算法不支持）,0xff-算法支持，但是没有识别出来
        public byte byAgeDeviation;//年龄误差值
        public byte byRes0;   //字段预留
        public byte byMask;       //是否戴口罩 0-表示“未知”（算法不支持）,1 – 不戴, 2 – 戴, 0xff-算法支持，但是没有识别出来
        public byte bySmile;      //是否微笑 0-表示“未知”（算法不支持）,1 – 不微笑, 2 – 微笑, 0xff-算法支持，但是没有识别出来
        public byte byFaceExpression;    /* 表情,参见FACE_EXPRESSION_GROUP_ENUM*/
        public byte byRes1;
        public byte byRes2;
        public byte byHat; // 帽子, 0-不支持,1-不戴帽子,2-戴帽子,0xff-unknow表示未知,算法支持未检出
        public byte[] byRes = new byte[4];    //保留
    }

    //人脸抓拍附加信息结构体
    public static class NET_VCA_FACESNAP_ADDINFO extends Structure {
        //人脸矩形框,该坐标为人脸小图(头肩照)中人脸的坐标
        public NET_VCA_RECT struFacePicRect = new NET_VCA_RECT();
        public int iSwingAngle;//旋转角, -90~90度
        public int iTiltAngle;//俯仰角, -90~90度
        public int dwPupilDistance;//瞳距,范围为：最小值为10像素,最大值为当前分辨率宽度/1.6
        public byte byBlockingState;//目标遮挡状态， 0-表示“未知”（算法不支持）,1~无遮挡,2~瞬时轻度遮挡，3~持续轻度遮挡，4~严重遮挡
        public byte byFaceSnapThermometryEnabled;//人脸抓拍测温使能 1-开启 0-关闭
        public byte byIsAbnomalTemperature;//人脸抓拍测温是否温度异常 1-是 0-否
        public byte byThermometryUnit;//测温单位: 0-摄氏度（℃），1-华氏度（℉），2-开尔文(K)
        public NET_DVR_TIME_EX struEnterTime = new NET_DVR_TIME_EX();   // 最佳抓拍下进入时间
        public NET_DVR_TIME_EX struExitTime = new NET_DVR_TIME_EX();    // 最佳抓拍下离开时间
        public float fFaceTemperature; // 人脸温度（ - 20.0℃~150.0℃，精确到小数点后1位）
        public float fAlarmTemperature;// 测温报警警阈值（精确到小数点后1位）
        public byte[] byRes = new byte[472];// 保留字节
    }

    //人脸抓拍结果
    public static class NET_VCA_FACESNAP_RESULT extends Structure {
        public int dwSize;             // 结构大小
        public int dwRelativeTime;     // 相对时标
        public int dwAbsTime;            // 绝对时标
        public int dwFacePicID;       //人脸图ID
        public int dwFaceScore;        //人脸评分,0-100
        public NET_VCA_TARGET_INFO struTargetInfo = new NET_VCA_TARGET_INFO();//报警目标信息
        public NET_VCA_RECT struRect = new NET_VCA_RECT();      //人脸子图区域
        public NET_VCA_DEV_INFO struDevInfo = new NET_VCA_DEV_INFO();    //前端设备信息
        public int dwFacePicLen;        //人脸子图的长度，为0表示没有图片，大于0表示有图片
        public int dwBackgroundPicLen; //背景图的长度，为0表示没有图片，大于0表示有图片(保留)
        public byte bySmart;            //IDS设备返回0(默认值)，Smart Functiom Return 1
        public byte byAlarmEndMark;//报警结束标记0-保留，1-结束标记（该字段结合人脸ID字段使用，表示该ID对应的下报警结束，主要提供给NVR使用，用于判断报警结束，提取识别图片数据中，清晰度最高的图片）
        public byte byRepeatTimes;   //重复报警次数，0-无意义
        public byte byUploadEventDataType;//人脸图片数据长传方式：0-二进制数据，1-URL
        public NET_VCA_HUMAN_FEATURE struFeature = new NET_VCA_HUMAN_FEATURE();  //人体属性
        public float fStayDuration;  //停留画面中时间(单位: 秒)
        public byte[] sStorageIP = new byte[16];        //存储服务IP地址
        public short wStoragePort;            //存储服务端口号
        public short wDevInfoIvmsChannelEx;     //与NET_VCA_DEV_INFO里的byIvmsChannel含义相同，能表示更大的值。老客户端用byIvmsChannel能继续兼容，但是最大到255。新客户端版本请使用wDevInfoIvmsChannelEx。
        public byte byFacePicQuality;
        public byte byUIDLen;     // 上传报警的标识长度
        public byte byLivenessDetectionStatus;// 活体检测状态：0-保留，1-未知(检测失败)，2-非真人人脸，3-真人人脸，4-未开启活体检测
        /*附加信息标识位（即是否有NET_VCA_FACESNAP_ADDINFO结构体）,0-无附加信息, 1-有附加信息。*/
        public byte byAddInfo;
        public Pointer pUIDBuffer;  //标识指针
        //附加信息指针,指向NET_VCA_FACESNAP_ADDINFO结构体
        public Pointer pAddInfoBuffer;
        public byte byTimeDiffFlag;      /*时差字段是否有效  0-时差无效， 1-时差有效 */
        public byte cTimeDifferenceH;         /*与UTC的时差（小时），-12 ... +14， +表示东区,，byTimeDiffFlag为1时有效*/
        public byte cTimeDifferenceM;        /*与UTC的时差（分钟），-30, 30, 45， +表示东区，byTimeDiffFlag为1时有效*/
        public byte byBrokenNetHttp;     //断网续传标志位，0-不是重传数据，1-重传数据
        public Pointer pBuffer1;  //人脸子图的图片数据
        public Pointer pBuffer2;  //背景图的图片数据（保留，通过查找背景图接口可以获取背景图）
    }

    //人脸抓拍信息
    public static class NET_VCA_FACESNAP_INFO_ALARM extends Structure {
        public int dwRelativeTime;     // 相对时标
        public int dwAbsTime;            // 绝对时标
        public int dwSnapFacePicID;       //抓拍人脸图ID
        public int dwSnapFacePicLen;        //抓拍人脸子图的长度，为0表示没有图片，大于0表示有图片
        public NET_VCA_DEV_INFO struDevInfo = new NET_VCA_DEV_INFO();        //前端设备信息
        public byte byFaceScore;        //人脸评分，指人脸子图的质量的评分,0-100
        public byte bySex;//性别，0-未知，1-男，2-女
        public byte byGlasses;//是否带眼镜，0-未知，1-是，2-否
        //抓拍图片人脸年龄的使用方式，如byAge为15,byAgeDeviation为1,表示，实际人脸图片年龄的为14-16之间
        public byte byAge;//年龄
        public byte byAgeDeviation;//年龄误差值
        public byte byAgeGroup;//年龄段，详见HUMAN_AGE_GROUP_ENUM，若传入0xff表示未知
        public byte byFacePicQuality;
        public byte byRes1;              // 保留字节
        public int dwUIDLen; // 上传报警的标识长度
        public Pointer pUIDBuffer;  //标识指针
        public float fStayDuration;  //停留画面中时间(单位: 秒)
        public Pointer pBuffer1;  //抓拍人脸子图的图片数据
    }

    //籍贯参数
    public static class NET_DVR_AREAINFOCFG extends Structure {
        public short wNationalityID; //国籍
        public short wProvinceID; //省
        public short wCityID; //市
        public short wCountyID; //县
        public int dwCode; //国家标准的省份、城市、县级代码，当这个字段不为0的时候，使用这个值，新设备上传这个值表示籍贯参数，老设备这个值为0
    }

    //人员信息
    public int MAX_HUMAN_BIRTHDATE_LEN = 10;

    public static class NET_VCA_HUMAN_ATTRIBUTE extends Structure {
        public byte bySex; //性别：0-男，1-女
        public byte byCertificateType; //证件类型：0-身份证，1-警官证
        public byte[] byBirthDate = new byte[MAX_HUMAN_BIRTHDATE_LEN]; //出生年月，如：201106
        public byte[] byName = new byte[NAME_LEN]; //姓名
        public NET_DVR_AREAINFOCFG struNativePlace = new NET_DVR_AREAINFOCFG(); //籍贯参数
        public byte[] byCertificateNumber = new byte[NAME_LEN];  //证件号
        public int dwPersonInfoExtendLen;// 人员标签信息扩展长度
        public Pointer pPersonInfoExtend;  //人员标签信息扩展信息
        public byte byAgeGroup;//年龄段，详见HUMAN_AGE_GROUP_ENUM，如传入0xff表示未知
        public byte[] byRes2 = new byte[11];
    }

    //禁止名单信息
    public static class NET_VCA_BLOCKLIST_INFO extends Structure {
        public int dwSize;   //结构大小
        public int dwRegisterID;  //名单注册ID号（只读）
        public int dwGroupNo; //分组号
        public byte byType; //允许名单标志：0-全部，1-允许名单，2-禁止名单
        public byte byLevel; //禁止名单等级，0-全部，1-低，2-中，3-高
        public byte[] byRes1 = new byte[2];  //保留
        public NET_VCA_HUMAN_ATTRIBUTE struAttribute = new NET_VCA_HUMAN_ATTRIBUTE();  //人员信息
        public byte[] byRemark = new byte[NAME_LEN]; //备注信息
        public int dwFDDescriptionLen;//人脸库描述数据长度
        public Pointer pFDDescriptionBuffer;//人脸库描述数据指针
        public int dwFCAdditionInfoLen;//抓拍库附加信息长度
        public Pointer pFCAdditionInfoBuffer;//抓拍库附加信息数据指针（FCAdditionInfo中包含相机PTZ坐标）
        public byte[] byRes2 = new byte[4];
    }

    //禁止名单报警信息
    public static class NET_VCA_BLOCKLIST_INFO_ALARM extends Structure {
        public NET_VCA_BLOCKLIST_INFO struBlockListInfo = new NET_VCA_BLOCKLIST_INFO(); //禁止名单基本信息
        public int dwBlockListPicLen;       //禁止名单人脸子图的长度，为0表示没有图片，大于0表示有图片
        public int dwFDIDLen;// 人脸库ID长度
        public Pointer pFDID;  //人脸库Id指针
        public int dwPIDLen;// 人脸库图片ID长度
        public Pointer pPID;  //人脸库图片ID指针
        public short wThresholdValue; //人脸库阈值[0,100]
        public byte byIsNoSaveFDPicture;//0-保存人脸库图片,1-不保存人脸库图片, 若开启了导入图片或者建模时不保存原图功能时,该字段返回1,此时人脸库图片将不再返回
        public byte byRealTimeContrast;//是否实时报警 0-实时 1-非实时
        public Pointer pBuffer1;  //禁止名单人脸子图的图片数据
    }


    //禁止名单比对结果报警上传
    public static class NET_VCA_FACESNAP_MATCH_ALARM extends Structure {
        public int dwSize;             // 结构大小
        public float fSimilarity; //相似度，[0.001,1]
        public NET_VCA_FACESNAP_INFO_ALARM struSnapInfo = new NET_VCA_FACESNAP_INFO_ALARM(); //抓拍信息
        public NET_VCA_BLOCKLIST_INFO_ALARM struBlockListInfo = new NET_VCA_BLOCKLIST_INFO_ALARM(); //禁止名单信息
        public byte[] sStorageIP = new byte[16];        //存储服务IP地址
        public short wStoragePort;            //存储服务端口号
        public byte byMatchPicNum; //匹配图片的数量，0-保留（老设备这个值默认0，新设备这个值为0时表示后续没有匹配的图片信息）
        public byte byPicTransType;//图片数据传输方式: 0-二进制；1-url
        public int dwSnapPicLen;//设备识别抓拍图片长度
        public Pointer pSnapPicBuffer;//设备识别抓拍图片指针
        public NET_VCA_RECT struRegion = new NET_VCA_RECT();//目标边界框，设备识别抓拍图片中，人脸子图坐标
        public int dwModelDataLen;//建模数据长度
        public Pointer pModelDataBuffer;// 建模数据指针
        public byte byModelingStatus;// 建模状态
        public byte byLivenessDetectionStatus;//活体检测状态：0-保留，1-未知（检测失败），2-非真人人脸，3-真人人脸，4-未开启活体检测
        public byte cTimeDifferenceH;         /*与UTC的时差（小时），-12 ... +14， +表示东区,0xff无效*/
        public byte cTimeDifferenceM;        /*与UTC的时差（分钟），-30, 30, 45， +表示东区，0xff无效*/
        public byte byMask;                //抓拍图是否戴口罩，0-保留，1-未知，2-不戴口罩，3-戴口罩
        public byte bySmile;               //抓拍图是否微笑，0-保留，1-未知，2-不微笑，3-微笑
        public byte byContrastStatus;      //比对结果，0-保留，1-比对成功，2-比对失败
        public byte byBrokenNetHttp;     //断网续传标志位，0-不是重传数据，1-重传数据
    }

    //交通事件报警(扩展)
    public static class NET_DVR_AID_ALARM_V41 extends Structure {
        public int dwSize;              //结构长度
        public int dwRelativeTime;        //相对时标
        public int dwAbsTime;            //绝对时标
        public NET_VCA_DEV_INFO struDevInfo = new NET_VCA_DEV_INFO();            //前端设备信息
        public NET_DVR_AID_INFO struAIDInfo = new NET_DVR_AID_INFO();         //交通事件信息
        public NET_DVR_SCENE_INFO struSceneInfo = new NET_DVR_SCENE_INFO();       //场景信息
        public int dwPicDataLen;        //图片长度
        public Pointer pImage;             //指向图片的指针
        // 0-数据直接上传; 1-云存储服务器URL(3.7Ver)原先的图片数据变成URL数据，图片长度变成URL长度
        public byte byDataType;
        public byte byLaneNo;  //关联车道号
        public short wMilliSecond;        //时标毫秒
        //监测点编号（路口编号、内部编号）
        public byte[] byMonitoringSiteID = new byte[MONITORSITE_ID_LEN/*48*/];
        public byte[] byDeviceID = new byte[DEVICE_ID_LEN/*48*/];//设备编号
        public int dwXmlLen;//XML报警信息长度
        public Pointer pXmlBuf;// XML报警信息指针,其XML对应到EventNotificationAlert XML Block
        public byte byTargetType;// 检测的目标类型，0~未知，1~行人、2~二轮车、3~三轮车(行人检测中返回)
        public byte[] byRes = new byte[19]; // 保留字节
    }

    //交通统计信息报警(扩展)
    public static class NET_DVR_TPS_ALARM_V41 extends Structure {
        public int dwSize;          // 结构体大小
        public int dwRelativeTime;  // 相对时标
        public int dwAbsTime;       // 绝对时标
        public NET_VCA_DEV_INFO struDevInfo;     // 前端设备信息
        public NET_DVR_TPS_INFO_V41 struTPSInfo;     // 交通参数统计信息
        //监测点编号（路口编号、内部编号）
        public byte[] byMonitoringSiteID = new byte[MONITORSITE_ID_LEN/*48*/];
        public byte[] byDeviceID = new byte[DEVICE_ID_LEN/*48*/];//设备编号
        public int dwStartTime;  // 开始统计时间
        public int dwStopTime;    // 结束统计时间
        public byte[] byRes = new byte[24];      // 保留
    }

    public static class NET_DVR_LANE_PARAM_V41 extends Structure {
        public byte[] byRuleName = new byte[NAME_LEN]; // 车道规则名称
        public byte byRuleID;             // 规则序号，为规则配置结构下标，0-7
        public byte byLaneType;             // 车道上行或下行
        public byte byTrafficState;       // 车道的交通状态，0-无效，1-畅通，2-拥挤，3-堵塞
        public byte byLaneNo;            //车道号
        public int dwVaryType;           // 车道交通参数变化类型参照  TRAFFIC_DATA_VARY_TYPE_EX_ENUM，按位区分
        public int dwTpsType;            // 数据变化类型标志，表示当前上传的统计参数中，哪些数据有效，参照ITS_TPS_TYPE,按位区分
        public int dwLaneVolume;         // 车道流量，统计有多少车子通过
        public int dwLaneVelocity;       // 车道速度，公里计算
        public int dwTimeHeadway;       // 车头时距，以秒计算
        public int dwSpaceHeadway;       // 车头间距，以米来计算
        public float fSpaceOccupyRation;   // 车道占有率，百分比计算（空间上)
        public float fTimeOccupyRation;    // 时间占有率，百分比计算
        public int dwLightVehicle;       // 小型车数量
        public int dwMidVehicle;         // 中型车数量
        public int dwHeavyVehicle;       // 重型车数量
        public NET_DVR_LANE_QUEUE struLaneQueue;        // 车道队列长度
        public NET_VCA_POINT struRuleLocation;     // 规则位置虚拟线圈的中心
        public int dwOversizeVehicle;    // 大型车数量
        public byte[] byRes2 = new byte[60];           // 保留
    }

    public int MAX_TPS_RULE = 8;     // 最大参数规则数目

    public static class NET_DVR_TPS_INFO_V41 extends Structure {
        public int dwLanNum;          // 交通参数的车道数目
        public NET_DVR_LANE_PARAM_V41[] struLaneParam = new NET_DVR_LANE_PARAM_V41[MAX_TPS_RULE];
        public int dwSceneID;//场景ID
        public byte[] byRes = new byte[28];         //保留
    }

    // 车道队列结构体
    public static class NET_DVR_LANE_QUEUE extends Structure {
        public NET_VCA_POINT struHead;       //队列头
        public NET_VCA_POINT struTail;       //队列尾
        public int dwLength;      //实际队列长度 单位为米 [0-500]
    }

    //TPS统计过车数据上传
    public static class NET_DVR_TPS_STATISTICS_INFO extends Structure {
        public int dwSize;          // 结构体大小
        public int dwChan;//通道号
        public NET_DVR_TPS_STATISTICS_PARAM struTPSStatisticsInfo;// 交通参数统计信息
        public byte[] byRes = new byte[128];      // 保留
    }

    // 交通参数统计信息
    public static class NET_DVR_TPS_STATISTICS_PARAM extends Structure {
        public byte byStart;          // 开始码
        public byte byCMD;         // 命令号， 08-定时成组数据指令
        public byte[] byRes = new byte[2];        // 预留字节
        public short wDeviceID;      // 设备ID
        public short wDataLen;       // 数据长度
        public byte byTotalLaneNum;  // 有效车道总数
        public byte[] byRes1 = new byte[15];
        public NET_DVR_TIME_V30 struStartTime;    //统计开始时间
        public int dwSamplePeriod;    //统计时间,单位秒
        public NET_DVR_TPS_LANE_PARAM[] struLaneParam = new NET_DVR_TPS_LANE_PARAM[8];
    }

    //统计信息
    public static class NET_DVR_TPS_LANE_PARAM extends Structure {
        public byte byLane;             // 对应车道号
        public byte bySpeed;             // 车道过车平均速度
        public byte[] byRes = new byte[2];             // 保留
        public int dwLightVehicle;      // 小型车数量
        public int dwMidVehicle;        // 中型车数量
        public int dwHeavyVehicle;      // 重型车数量
        public int dwTimeHeadway;      // 车头时距，以秒计算
        public int dwSpaceHeadway;     // 车头间距，以米来计算
        public float fSpaceOccupyRation; // 空间占有率，百分比计算,浮点数*1000
        public float fTimeOccupyRation;  // 时间占有率，百分比计算,浮点数*1000
        public byte[] byRes1 = new byte[16];               // 保留
    }

    public static class NET_DVR_TIME_SEARCH_COND extends Structure {
        public short wYear; //年
        public byte byMonth; //月
        public byte byDay; //日
        public byte byHour; //时
        public byte byMinute; //分
        public byte bySecond; //秒
        public byte byLocalOrUTC; //0-时差无效，设备本地时间，即设备OSD时间  1-时差有效
        public short wMillisecond;       //毫秒，精度不够，默认为0
        public byte cTimeDifferenceH;   //与UTC的时差（小时），-12 ... +14，+表示东区，byLocalOrUTC为1时有效
        public byte cTimeDifferenceM;   //与UTC的时差（分钟），-30, 0, 30, 45，+表示东区，byLocalOrUTC为1时有效
    }

    //事件搜索条件
    public static class NET_DVR_SEARCH_EVENT_PARAM extends Structure {
        public short wMajorType;        //0-移动侦测，1-报警输入, 2-智能事件 5-pos录像 7-门禁事件, 8-非视频联动事件
        public short wMinorType;       //搜索次类型- 根据主类型变化，0xffff表示全部
        public NET_DVR_TIME struStartTime = new NET_DVR_TIME();    //搜索的开始时间，停止时间: 同时为(0, 0) 表示从最早的时间开始，到最后，最前面的4000个事件
        public NET_DVR_TIME struEndTime = new NET_DVR_TIME();    //搜索的结束时间
        public byte byLockType;      // 0xff-全部，0-未锁，1-锁定
        public byte byValue;        //0-按位表示，1-按值表示
        public byte[] byRes = new byte[130];        // 保留
        public UNION_EVENT_PARAM uSeniorParam = new UNION_EVENT_PARAM();
    }

    public static class UNION_EVENT_PARAM extends Union {
        public byte[] byLen = new byte[SEARCH_EVENT_INFO_LEN];
        public EVENT_INQUESTPARAM struInquestParam = new EVENT_INQUESTPARAM();
    }

    //审讯事件搜索条件
    public static class EVENT_INQUESTPARAM extends Structure {
        public byte byRoomIndex;    //审讯室编号,按值表示，从1开始
        public byte[] byRes1 = new byte[3];
        public byte[] sInquestInfo = new byte[INQUEST_CASE_LEN];
        public byte[] byRes2 = new byte[232];     //保留
    }

    //事件搜索条件
    public static class NET_DVR_SEARCH_EVENT_PARAM_V50 extends Structure {
        public short wMajorType;            //0-移动侦测，1-报警输入, 2-智能事件 5-pos录像 7-门禁事件, 8-非视频联动事件
        public short wMinorType;            //搜索次类型- 根据主类型变化，0xffff表示全部
        public NET_DVR_TIME_SEARCH_COND struStartTime = new NET_DVR_TIME_SEARCH_COND();    //搜索的开始时间，停止时间: 同时为(0, 0) 表示从最早的时间开始，到最后，最前面的4000个事件
        public NET_DVR_TIME_SEARCH_COND struEndTime = new NET_DVR_TIME_SEARCH_COND();    //搜索的结束时间
        public byte byLockType;        // 0xff-全部，0-未锁，1-锁定
        public byte byQuickSearch;        // 是否启用快速查询，0-不启用，1-启用（快速查询不会返回文件大小，仅对设备数据库进行查询，避免频繁唤醒硬盘）
        public byte[] byRes = new byte[254];        // 保留
        public UNION_EVENT_PARAM_V50 uSeniorParam = new UNION_EVENT_PARAM_V50();
    }

    public static class UNION_EVENT_PARAM_V50 extends Union {
        public byte[] byLen = new byte[SEARCH_EVENT_INFO_LEN_V40/*800*/];
        public EVENT_ALARMPARAM_V50 struAlarmParam = new EVENT_ALARMPARAM_V50();
        public EVENT_MOTIONPARAM_V50 struMotionParam = new EVENT_MOTIONPARAM_V50();
        public EVENT_VCAPARAM_V50 struVcaParam = new EVENT_VCAPARAM_V50();
        public EVENT_INQUESTPARAM_V50 struInquestParam = new EVENT_INQUESTPARAM_V50();
        public EVENT_VCADETECTPARAM_V50 struVCADetect = new EVENT_VCADETECTPARAM_V50();
        public EVENT_STREAMIDPARAM_V50 struStreamIDParam = new EVENT_STREAMIDPARAM_V50();
        public EVENT_POSPARAM_V50 struPosAlarm = new EVENT_POSPARAM_V50();
        public EVENT_TRIALPARAM_V50 struTrialParam = new EVENT_TRIALPARAM_V50();
        public EVENT_ACSPARAM_V50 struACSAlarm = new EVENT_ACSPARAM_V50();
        public EVENT_IOTPARAM_V50 struIOTAlarm = new EVENT_IOTPARAM_V50();
    }

    public static class EVENT_ALARMPARAM_V50 extends Structure {
        /*报警输入号，按值表示,采用紧凑型排列，0xffff表示后续无效*/
        public short[] wAlarmInNo = new short[128];
        public byte[] byRes = new byte[544]; //保留
    }

    //移动侦测
    public static class EVENT_MOTIONPARAM_V50 extends Structure {
        /* 移动侦测通道，按值表示 ,采用紧凑型排列，0xffff表示后续无效*/
        public short[] wMotDetChanNo = new short[MAX_CHANNUM_V30];
        public byte[] byRes = new byte[672];                /*保留*/
    }

    //行为分析
    public static class EVENT_VCAPARAM_V50 extends Structure {
        //行为分析对应的通道，按值表示,采用紧凑型排列，0xffff表示后续无效
        public short[] wChanNo = new short[MAX_CHANNUM_V30];
        public byte byRuleID;      //行为分析类型，规则0xff表示全部，从0开始
        public byte byDriverBehaviortType;  //司机驾驶行为类型：0-保留、1-抽烟、2-接打电话、3-疲劳驾驶、4-分神提醒、5-驾驶员异常、6-未系安全带、7-红外阻断墨镜
        public byte byADASType;  //高级辅助驾驶类型：0-保留、1-前向碰撞、2-车道偏离、3-盲区检测、4-车距检测、5-行人防撞、6-急加速、7-急减速、8-急左转弯、9-急右转弯、10-车辆翻车、11-未礼让行人
        public byte byGSensorType;  // G-Sensor事件：0-保留、1-急加速、2-急减速、3-急左转弯、4-急右转弯、5-车辆翻车、6-车辆碰撞
        public byte bySensorInType;  // Sensor-In行为：0-保留、1-刹车、2-左转、3-右转、4-倒车
        public byte[] byRes = new byte[667];     /*保留*/
    }

    //审讯事件搜索条件
    public static class EVENT_INQUESTPARAM_V50 extends Structure {
        public byte byRoomIndex;    //审讯室编号,从1开始
        public byte[] byRes = new byte[799];     //保留
    }

    //智能侦测查找条件 ，通道号按值表示
    public static class EVENT_VCADETECTPARAM_V50 extends Structure {
        public byte byAll;  //查找全部通道，0-否，此时dwChanNo参数有效，
        //1-查找全部通道，此时dwChanNo参数无效。
        public byte[] byRes1 = new byte[3];
        public short[] wChanNo = new short[MAX_CHANNUM_V30];// 触发通道号,按值表示，0xffff无效，且后续数据也表示无效值
        public byte[] byRes = new byte[668];
    }

    public static class EVENT_STREAMIDPARAM_V50 extends Structure {
        public NET_DVR_STREAM_INFO struIDInfo = new NET_DVR_STREAM_INFO(); // 流id信息，72字节长
        public int dwCmdType;  // 外部触发类型，NVR接入云存储使用
        public byte byBackupVolumeNum; //存档卷号，CVR使用
        public byte[] byRes1 = new byte[3];
        public byte[] byArchiveLabel = new byte[64]; //存档标签，CVR使用
        public byte[] byRes = new byte[656];
    }

    //pos录像
    public static class EVENT_POSPARAM_V50 extends Structure {
        public short[] wChannel = new short[MAX_CHANNUM_V30];        //通道，按值表示,紧凑型排列，遇到0xffff时表示数组后续值无效
        public byte byAllChan;        //是否查找全部通道，0-否，此时wChannel有效，1-全部通道，此时wChannel无效
        public byte byCaseSensitive;      //0-不区分大小写， 1-区分大小写
        public byte byCombinateMode;  //关键字组合方式，0-或，1-与
        public byte byRes1;              //保留
        public byte[] sKeyWord = new byte[MAX_POS_KEYWORDS_NUM * MAX_POS_KEYWORD_LEN];
        //关键字查找时的条件
        public byte[] byRes = new byte[284];          //保留
    }

    public static class EVENT_TRIALPARAM_V50 extends Structure {
        public byte[] byCaseNo = new byte[SEARCH_CASE_NO_LEN];
        public byte[] byCaseName = new byte[SEARCH_CASE_NAME_LEN];
        public byte[] byLitigant1 = new byte[SEARCH_LITIGANT_LEN];
        public byte[] byLitigant2 = new byte[SEARCH_LITIGANT_LEN];
        public byte[] byChiefJudge = new byte[SEARCH_CHIEF_JUDGE_LEN];
        public byte byCaseType;
        public byte[] byRes = new byte[547];
    }

    //门禁事件搜索条件
    public static class EVENT_ACSPARAM_V50 extends Structure {
        public int dwMajor; //报警主类型（与事件上传主类型一致，0代表全部）
        public int dwMinor; //报警次类型（与事件上传主类型一致，0代表全部）
        public byte[] byCardNo = new byte[ACS_CARD_NO_LEN]; //卡号
        public byte[] byName = new byte[NAME_LEN/*32*/]; //姓名
        public byte[] byMACAddr = new byte[MACADDR_LEN]; //物理MAC地址
        public byte[] byRes = new byte[722];
    }

    //非视频联动事件搜索条件
    public static class EVENT_IOTPARAM_V50 extends Structure {
        public short wDeviceType;            //设备类型,0-海康门禁主机，1-海康可视对讲设备, 2-海康报警主机（预留） 3-GJD报警主机 4-Luminite报警主机, 5-OPTEX报警主机,6-cameraDetector模拟相机传感器设备
        public short wEventType;            //搜索次类型- 根据主类型变化，0xffff表示全部
        public short[] wChannel = new short[MAX_CHANNUM_V30/*64*/];        //通道号，按值表示,紧凑型排列，遇到0xffff时表示数组后续值无效
        public byte byAllChan;        //是否查找全部通道，0-否，此时wChannel有效，1-全部通道，此时wChannel无效
        public byte byCaseSensitive;      //0-不区分大小写， 1-区分大小写
        public byte byCombinateMode;  //关键字组合方式，0-或，1-与
        public byte bySearchType;      //搜索方式：0-按视频源搜索（此时通道号为视频通道号）
        public byte[] sKeyWord = new byte[MAX_POS_KEYWORDS_NUM * MAX_POS_KEYWORD_LEN];//关键字查找时的条件
        public short wZoneNo;      //防区号，仅当设备类型为海康报警主机，次类型为防区（wEventType为1）时有效
        public byte[] byRes = new byte[278];   //保留
    }

    //查找返回结果
    public static class NET_DVR_SEARCH_EVENT_RET extends Structure {
        public short wMajorType;            //主类型
        public short wMinorType;            //次类型
        public NET_DVR_TIME struStartTime = new NET_DVR_TIME();    //事件开始的时间
        public NET_DVR_TIME struEndTime = new NET_DVR_TIME();   //事件停止的时间
        public byte[] byChan = new byte[MAX_CHANNUM_V30];
        public byte[] byChanEx = new byte[32];   //关联通道，按位表示，使用该字段后byChan可以不使用
        public byte[] byRes = new byte[4];
        public UNION_EVENT_RET uSeniorRet = new UNION_EVENT_RET();
    }

    public static class UNION_EVENT_RET extends Union {
        public byte[] byLen = new byte[304];
        public EVENT_ALARMSTRET struAlarmRet = new EVENT_ALARMSTRET();
        public EVENT_INQUESTRET struInquestRet = new EVENT_INQUESTRET();
    }

    //报警输入结果
    public static class EVENT_ALARMSTRET extends Structure {

        public int dwAlarmInNo;     //报警输入号
        public byte[] byRes = new byte[SEARCH_EVENT_INFO_LEN];
    }

    //审讯事件
    public static class EVENT_INQUESTRET extends Structure {
        public byte byRoomIndex;     //审讯室编号,从1开始
        public byte byDriveIndex;    //刻录机编号,从1开始
        public byte[] byRes1 = new byte[6];       //保留
        public int dwSegmentNo;     //本片断在本次审讯中的序号,从1开始
        public short wSegmetSize;     //本片断的大小, 单位M
        public short wSegmentState;   //本片断状态 0 刻录正常，1 刻录异常，2 不刻录审讯
        public byte[] byRes2 = new byte[288];     //保留

        @Override
        protected List<String> getFieldOrder() {
            // TODO Auto-generated method stub
            return Arrays.asList("byRoomIndex", "byDriveIndex", "byRes1", "dwSegmentNo", "wSegmetSize", "wSegmentState", "byRes2");
        }
    }

    //查找返回结果
    public static class NET_DVR_SEARCH_EVENT_RET_V50 extends Structure {
        public short wMajorType;            //主类型
        public short wMinorType;            //次类型
        public NET_DVR_TIME_SEARCH struStartTime = new NET_DVR_TIME_SEARCH();    //事件开始的时间
        public NET_DVR_TIME_SEARCH struEndTime = new NET_DVR_TIME_SEARCH();   //事件停止的时间，脉冲事件时和开始时间一样
        public NET_DVR_ADDRESS struAddr = new NET_DVR_ADDRESS();  //片段所在的地址信息，集群回放时用到
        public short[] wChan = new short[MAX_CHANNUM_V40/*512*/];    //触发的通道号，0xffff表示后续无效
        public byte[] byRes = new byte[256];
        public UNION_EVENT_RET_V50 uSeniorRet = new UNION_EVENT_RET_V50();
    }

    public static class UNION_EVENT_RET_V50 extends Union {
        public byte[] byLen = new byte[800];
        public EVENT_ALARMRET_V50 struAlarmRet = new EVENT_ALARMRET_V50();
        public EVENT_MOTIONRET_V50 struMotionRet = new EVENT_MOTIONRET_V50();
        public EVENT_VCARET_V50 struVcaRet = new EVENT_VCARET_V50();
        public EVENT_INQUESTRET_V50 struInquestRet = new EVENT_INQUESTRET_V50();
        public EVENT_STREAMIDRET_V50 struStreamIDRet = new EVENT_STREAMIDRET_V50();
        public EVENT_POSRET_V50 struPosRet = new EVENT_POSRET_V50();
        public EVENT_TRIALRET_V50 struTrialRet = new EVENT_TRIALRET_V50();
        public EVENT_IOTRET_V50 struIOTRet = new EVENT_IOTRET_V50();
    }

    //报警输入结果
    public static class EVENT_ALARMRET_V50 extends Structure {
        public int dwAlarmInNo;     //报警输入号
        public byte[] byRes = new byte[796];
    }

    //移动侦测结果
    public static class EVENT_MOTIONRET_V50 extends Structure {
        public int dwMotDetNo;    //移动侦测通道
        public byte[] byRes = new byte[796];
    }

    //行为分析结果
    public static class EVENT_VCARET_V50 extends Structure {
        public int dwChanNo;                    //触发事件的通道号
        public byte byRuleID;                    //规则ID
        public byte[] byRes1 = new byte[3];                    //保留
        public byte[] byRuleName = new byte[NAME_LEN];        //规则名称
        public NET_VCA_EVENT_UNION uEvent = new NET_VCA_EVENT_UNION();     //行为事件参数
        public byte[] byRes = new byte[668];                    //保留
    }

    //审讯事件
    public static class EVENT_INQUESTRET_V50 extends Structure {
        public byte byRoomIndex;     //审讯室编号,从1开始
        public byte byDriveIndex;    //刻录机编号,从1开始
        public byte[] byRes1 = new byte[6];       //保留
        public int dwSegmentNo;     //本片断在本次审讯中的序号,从1开始
        public short wSegmetSize;     //本片断的大小, 单位M
        public short wSegmentState;   //本片断状态 0 刻录正常，1 刻录异常，2 不刻录审讯
        public byte[] byRes2 = new byte[784];     //保留
    }

    //流id录像查询结果
    public static class EVENT_STREAMIDRET_V50 extends Structure {
        public int dwRecordType;    //录像类型 0-定时录像 1-移动侦测 2-报警录像 3-报警|移动侦测 4-报警&移动侦测 5-命令触发 6-手动录像 7-震动报警 8-环境触发 9-智能报警 10-回传录像
        public int dwRecordLength;    //录像大小
        public byte byLockFlag;    // 锁定标志 0：没锁定 1：锁定
        public byte byDrawFrameType;    // 0：非抽帧录像 1：抽帧录像
        public byte byPosition;// 文件所在存储位置：0-阵列上，1-带库机位上，可以直接下载，2-磁带库内，需要把磁盘切换到机位上，3-不在磁带库中，需要把磁盘插到磁带库中
        public byte byRes1;
        public byte[] byFileName = new byte[NAME_LEN];     //文件名
        public int dwFileIndex;            // 存档卷上的文件索引
        public byte[] byTapeIndex = new byte[NET_SDK_MAX_TAPE_INDEX_LEN];  //文件所在磁带编号
        public byte[] byFileNameEx = new byte[NET_SDK_MAX_FILE_LEN/*256*/]; //文件名扩展
        public byte[] byRes = new byte[464];
    }

    //POS录像查询结果
    public static class EVENT_POSRET_V50 extends Structure {
        public int dwChanNo;        //触发产生pos事件的通道
        public byte[] byRes = new byte[796];
    }

    public static class EVENT_TRIALRET_V50 extends Structure {
        public byte byRoomIndex;     //审讯室编号,从1开始
        public byte byDriveIndex;    //刻录机编号,从1开始
        public short wSegmetSize;     //本片断的大小, 单位M
        public int dwSegmentNo;    //本片断在本次审讯中的序号,从1开始
        public byte bySegmentState;   //本片断状态，0-刻录正常，1-刻录异常，2-不刻录审讯
        public byte byCaseType; //案件类型；0-全部、1-刑事案件、2-民事案件
        public byte[] byRes = new byte[2];
        public byte[] byCaseNo = new byte[CASE_NO_RET_LEN];  //案件编号
        public byte[] byCaseName = new byte[CASE_NAME_RET_LEN]; //案件名称；
        public byte[] byLitigant1 = new byte[LITIGANT_RET_LEN]; //当事人1；
        public byte[] byLitigant2 = new byte[LITIGANT_RET_LEN]; //当事人2；
        public byte[] byChiefJudge = new byte[CHIEF_JUDGE_RET_LEN];//审判长
        public byte[] byRes1 = new byte[600];
    }

    //非视频通道查询结果
    public static class EVENT_IOTRET_V50 extends Structure {
        public int dwChanNo;        //触发产生事件的通道号（事件源通道）
        public byte[] byRes = new byte[796];
    }

    public static class NET_DVR_INQUEST_RESUME_SEGMENT extends Structure {
        public NET_DVR_TIME struStartTime = new NET_DVR_TIME(); //事件起始时间
        public NET_DVR_TIME struStopTime = new NET_DVR_TIME();  //事件终止时间
        public byte byRoomIndex;         //审讯室编号,从1开始
        public byte byDriveIndex;        //刻录机编号,从1开始
        public short wSegmetSize;         //本片断的大小, 单位M
        public int dwSegmentNo;         //本片断在本次审讯中的序号,从1开始
        public byte[] byRes = new byte[24];           //保留
    }

    public static class NET_DVR_INQUEST_RESUME_EVENT extends Structure {
        public int dwResumeNum;       //需恢复的事件个数
        public NET_DVR_INQUEST_RESUME_SEGMENT[] struResumeSegment = new NET_DVR_INQUEST_RESUME_SEGMENT[MAX_RESUME_SEGMENT];
        public byte byResumeMode;        //恢复模式，0-单光盘恢复，1-双光盘恢复
        public byte[] byRes = new byte[199];        //保留
    }

    //报警信息查询条件结构体
    public static class NET_DVR_ALARM_SEARCH_COND extends Structure {
        public int dwSize;
        public NET_DVR_TIME_SEARCH_COND strStartTime; //开始时间,时间为空则代表不通过时间筛选。
        public NET_DVR_TIME_SEARCH_COND strStopTime;  //结束时间, 时间为空则代表不通过时间筛选。
        /*
  	报警命令，该字段值与报警布防类型相同，目前支持：
  	COMM_VCA_ALARM 	0x4993  智能检测报警
  	COMM_UPLOAD_FACESNAP_RESULT    0x1112  人脸识别结果上传
  	COMM_SNAP_MATCH_ALAR    0x2902  人脸比对结果上传
	 */
        public int dwAlarmComm;   //若该命令为空这代表不进行报警命令过滤。
        public byte[] sAlarmUID = new byte[64];   //UID标识（上传报警时设备返回的UID标识，64字节的长度，可以使用时间（精确到毫秒）加上随即数的方式组成）,为空则代表不区分UID
        public byte[] byRes = new byte[128];
    }

    //报警信息查询结果结构体
    public static class NET_DVR_ALARM_SEARCH_RESULT extends Structure {
        public int dwSize;
        /*
  	报警命令，该字段值与报警布防类型相同，目前支持：
  	COMM_VCA_ALARM 	0x4993    智能检测报警
  	COMM_UPLOAD_FACESNAP_RESULT    0x1112  人脸识别结果上传
  	COMM_SNAP_MATCH_ALARM   0x2902 人脸比对结果上传
	 */
        public int dwAlarmComm;
        /*
  	报警信息，该字段值与报警信息相同，目前支持：
  	当COMM_VCA_ALARM时，该报警信息为JSON报文
  	当COMM_UPLOAD_FACESNAP_RESULT时，该报警信息为NET_VCA_FACESNAP_RESULT
  	当COMM_SNAP_MATCH_ALARM¶，该报警信息为NET_VCA_FACESNAP_MATCH_ALARM
	 */
        public int dwAlarmLen;//报警信息，即pAlarmInfo指针指向的数据长度
        public Pointer pAlarmInfo;
        public NET_DVR_ALARMER struAlarmer = new NET_DVR_ALARMER();
        public byte[] byRes = new byte[128];
    }

    public static class NET_DVR_ALARM_ISAPI_INFO extends Structure {
        public Pointer pAlarmData;           // 报警数据（参见下表）
        public int dwAlarmDataLen;   // 报警数据长度
        public byte byDataType;        // 0-invalid,1-xml,2-json
        public byte byPicturesNumber;  // 图片数量
        public byte[] byRes = new byte[2];
        public Pointer pPicPackData;         // 图片变长部分
        //（byPicturesNumber个{NET_DVR_ALARM_ISAPI_PICDATA}；）
        public byte[] byRes1 = new byte[32];
    }

    public static class NET_DVR_LOCAL_GENERAL_CFG extends Structure {
        public byte byExceptionCbDirectly;    //0-通过线程池异常回调，1-直接异常回调给上层
        public byte byNotSplitRecordFile;     //回放和预览中保存到本地录像文件不切片 0-默认切片，1-不切片
        public byte byResumeUpgradeEnable;    //断网续传升级使能，0-关闭（默认），1-开启
        public byte byAlarmJsonPictureSeparate;   //控制JSON透传报警数据和图片是否分离，0-不分离，1-分离（分离后走COMM_ISAPI_ALARM回调返回）
        public byte[] byRes = new byte[4];      //保留
        public long i64FileSize;      //单位：Byte
        public int dwResumeUpgradeTimeout;       //断网续传重连超时时间，单位毫秒
        public byte[] byRes1 = new byte[236];    //预留

    }

    public static class NET_DVR_LOCAL_TCP_PORT_BIND_CFG extends Structure {
        public short wLocalBindTcpMinPort;            //本地绑定Tcp最小端口
        public short wLocalBindTcpMaxPort;            //本地绑定Tcp最大端口
        public byte[] byRes = new byte[60];                        //保留
    }


    public static class NET_DVR_LOCAL_CHECK_DEV extends Structure {
        public int dwCheckOnlineTimeout;     //巡检时间间隔，单位ms  最小值为30s，最大值120s。为0时，表示用默认值(120s)
        public int dwCheckOnlineNetFailMax;  //由于网络原因失败的最大累加次数；超过该值SDK才回调用户异常，为0时，表示使用默认值1
        public byte[] byRes = new byte[256];
    }

    public static final int MAX_FILE_PATH_LEN = 256; //文件路径长度

    public static class NET_DVR_ALARM_ISAPI_PICDATA extends Structure {
        public int dwPicLen;
        public byte byPicType;  //图片格式: 1- jpg
        public byte[] byRes = new byte[3];
        public byte[] szFilename = new byte[MAX_FILE_PATH_LEN];
        public Pointer pPicData; // 图片数据
    }

    public static class NET_DVR_FOCUSMODE_CFG extends Structure {
        public int dwSize;
        public byte byFocusMode;  /* 聚焦模式，0-自动，1-手动，2-半自动 */
        public byte byAutoFocusMode; /* 自动聚焦模式，0-关，1-模式A，2-模式B，3-模式AB，4-模式C 自动聚焦模式，需要在聚焦模式为自动时才显示*/
        public short wMinFocusDistance; /* 最小聚焦距离，单位CM,  0-自动，0xffff-无穷远 */
        public byte byZoomSpeedLevel;  /* 变倍速度，为实际取值，1-3 */
        public byte byFocusSpeedLevel; /* 聚焦速度，为实际取值，1-3 */
        public byte byOpticalZoom;        /* 光学变倍，0-255 */
        public byte byDigtitalZoom;        /* 数字变倍，0-255 */
        public float fOpticalZoomLevel; /* 光学变倍(倍率值) [1,32], 最小间隔0.5 ，内部设备交互的时候*1000 */
        public int dwFocusPos;/* dwFocusPos 是focus值（聚焦值），范围为[0x1000,0xC000]，这个值是sony坐标值，使用这个值是为了对外统一，保证不同的镜头对外focus值都转换在这个范围内 (手动聚焦模式下下应用)*/
        public byte byFocusDefinitionDisplay;// 聚焦清晰度显示，0~不显示，1~显示, 开启会在码流上显示当前镜头目标的清晰度值，用于帮助客户调焦使相机抓拍能够达到最清晰的效果，该清晰度越大代表着越清晰，清晰度范围为：0~100.0000
        public byte byFocusSensitivity; //聚焦灵敏度，范围[0,2]，聚焦模式为自动、半自动时生效
        public byte[] byRes1 = new byte[2];
        public int dwRelativeFocusPos;//相对focus值，其低16位表示聚焦值，0~4000；高16位代表当前聚焦值获取时的温度值
        public byte[] byRes = new byte[48];
    }

    public static class NET_DVR_SERIALSTART_V40 extends Structure {
        public int dwSize;         //结构体大小
        public int dwSerialType;    //串口号（1-232串口，2-485串口）
        public byte bySerialNum;   //串口编号
        public byte[] byRes = new byte[255];


    }

    public static class NET_DVR_PRESET_NAME extends Structure {
        public int dwSize;
        public short wPresetNum;   //预置点编号
        public byte[] byRes1 = new byte[2]; //字节对齐
        public byte[] byName = new byte[NAME_LEN];
        public short wPanPos;  //水平参数 如果获取到的数据大于360默认减去360
        public short wTiltPos; //垂直参数 如果获取到的数据大于360默认减去360
        public short wZoomPos; //变倍参数如果获取到的数据大于360默认减去360
        public byte[] byRes = new byte[58];
    }

    //Sensor信息
    public static class NET_DVR_SENSOR_PARAM extends Structure {
        public byte bySensorType;//SensorType:0-CCD,1-CMOS
        public byte[] byRes = new byte[31];
        public float fHorWidth;//水平宽度 精确到小数点后两位 *10000
        public float fVerWidth;//垂直宽度 精确到小数点后两位 *10000
        public float fFold;//zoom=1没变时的焦距 精确到小数点后两位 *100
    }

    //球机位置信息
    public static class NET_DVR_PTZPOS_PARAM extends Structure {
        public float fPanPos;//水平参数，精确到小数点后1位
        public float fTiltPos;//垂直参数，精确到小数点后1位
        public float fZoomPos;//变倍参数，精确到小数点后1位
        public byte[] byRes = new byte[16];
    }

    public static class NET_DVR_LLI_PARAM extends Structure {
        public float fSec;//秒[0.000000,60.000000]
        public byte byDegree;//度:纬度[0,90] 经度[0,180]
        public byte byMinute;//分[0,59]
        public byte[] byRes = new byte[6];
    }

    //GIS信息上传
    public static class NET_DVR_GIS_UPLOADINFO extends Structure {
        public int dwSize;//结构体大小
        public int dwRelativeTime; //相对时标
        public int dwAbsTime; //绝对时标
        public NET_VCA_DEV_INFO struDevInfo = new NET_VCA_DEV_INFO();//前端设备
        public float fAzimuth;//电子罗盘的方位信息；方位角[0.00°,360.00°)
        public byte byLatitudeType;//纬度类型，0-北纬，1-南纬
        public byte byLongitudeType;// 经度类型，0-东度，1-西度
        public byte[] byRes1 = new byte[2];
        public NET_DVR_LLI_PARAM struLatitude = new NET_DVR_LLI_PARAM();     /*纬度*/
        public NET_DVR_LLI_PARAM struLongitude = new NET_DVR_LLI_PARAM();   /*经度*/
        public float fHorizontalValue;//水平视场角，精确到小数点后面两位
        public float fVerticalValue;//垂直视场角，精确到小数点后面两位
        public float fVisibleRadius;//当前可视半径，精确到小数点后面两位
        public float fMaxViewRadius;//最大可视半径，精确到小数点后面0位（预留处理）
        public NET_DVR_SENSOR_PARAM struSensorParam;//Sensor信息
        public NET_DVR_PTZPOS_PARAM struPtzPos; //ptz坐标
        public byte[] byRes = new byte[256];
    }

    public static class NET_DVR_DAYTIME extends Structure {
        public byte byHour;//0~24
        public byte byMinute;//0~60
        public byte bySecond;//0~60
        public byte byRes;
        public short wMilliSecond; //0~1000
        public byte[] byRes1 = new byte[2];
    }

    public static class NET_DVR_SCHEDULE_DAYTIME extends Structure {
        public NET_DVR_DAYTIME struStartTime; //开始时间
        public NET_DVR_DAYTIME struStopTime; //结束时间
    }

    public static class NET_DVR_BUILTIN_SUPPLEMENTLIGHT extends Structure {
        public int dwSize;//结构体大小
        public byte byMode;//补光灯模式 0-定时，1-开启，2-关闭，3-自动（非光敏，算法画面识别）
        public byte byBrightnessLimit;//亮度限制[0,100]
        public byte bySupplementLightMode;//补光灯类型,0~白光模式,1~混合模式
        public byte byMixedLightRegulatMode;//混合补光灯亮度调节模式,0~自动,1~手动,当bySupplementLightMode = 1时生效
        public byte byLrLightBrightness;//红外亮度控制[0,100],当byMixedLightRegulatMode = 1时生效。
        public byte byHighLrLightBrightness;// 远光红外光亮度配置[0,100],当byMixedLightRegulatMode = 1时生效
        public byte byHighBrightnessLimit;// 远光白光亮度配置[0,100],当byMixedLightRegulatMode = 1时生效
        public byte byLowLrLightBrightness;// 近光红外光亮度配置[0,100],当byMixedLightRegulatMode = 1时生效
        public NET_DVR_SCHEDULE_DAYTIME struSchedTime;//定时时间段
        public byte byLowBrightnessLimit;//近光白光亮度配置[0,100],当byMixedLightRegulatMode = 1时生效
        public byte byWhiteLightBrightness;// 白光灯亮度
        public byte[] byRes1 = new byte[254];
    }

    public static class NET_DVR_HANDLEEXCEPTION_V41 extends Structure {
        public int dwHandleType;        //异常处理,异常处理方式的"或"结果
        /*0x00: 无响应*/
        /*0x01: 监视器上警告*/
        /*0x02: 声音警告*/
        /*0x04: 上传中心*/
        /*0x08: 触发报警输出*/
        /*0x10: 触发JPRG抓图并上传Email*/
        /*0x20: 无线声光报警器联动*/
        /*0x40: 联动电子地图(目前只有PCNVR支持)*/
        /*0x200: 抓图并上传FTP*/
        /*0x400: 虚交侦测 联动 聚焦模式（提供可配置项，原先设备自动完成）IPC5.1.0*/
        /*0x800: PTZ联动跟踪(球机跟踪目标)*/
        /*0x4000:白光灯报警*/
        /*0x10000:短信报警*/
        public int dwMaxRelAlarmOutChanNum; //触发的报警输出通道数（只读）最大支持数
        public int[] dwRelAlarmOut = new int[MAX_ALARMOUT_V40]; //触发报警通道
        public byte[] byRes = new byte[64];           //保留
    }

    public static class NET_DVR_PRESETCHAN_INFO extends Structure {
        public int dwEnablePresetChan;    /*启用预置点的通道, 0xfffffff表示不调用预置点*/
        public int dwPresetPointNo;        /*调用预置点通道对应的预置点序号, 0xfffffff表示不调用预置点。*/
    }

    public static class NET_DVR_CRUISECHAN_INFO extends Structure {
        public int dwEnableCruiseChan;    /*启用巡航的通道*/
        public int dwCruiseNo;        /*巡航通道对应的巡航编号, 0xfffffff表示无效*/
    }

    public static class NET_DVR_PTZTRACKCHAN_INFO extends Structure {
        public int dwEnablePtzTrackChan;    /*启用云台轨迹的通道*/
        public int dwPtzTrackNo;        /*云台轨迹通道对应的编号, 0xfffffff表示无效*/
    }

    public static class NET_DVR_EVENT_TRIGGER extends Structure {
        public int dwSize;//结构体大小
        public NET_DVR_HANDLEEXCEPTION_V41 struHandleException;     //异常处理方式
        public int[] dwRelRecordChan = new int[MAX_CHANNUM_V40]; //实际触发录像通道，按值表示，采用紧凑型排列，从下标0开始顺序读取，中间遇到0xffffffff则后续无效。
        public NET_DVR_PRESETCHAN_INFO[] struPresetChanInfo = new NET_DVR_PRESETCHAN_INFO[MAX_CHANNUM_V40]; //启用的预置点信息
        public NET_DVR_CRUISECHAN_INFO[] struCruiseChanInfo = new NET_DVR_CRUISECHAN_INFO[MAX_CHANNUM_V40]; //启用巡航功能通道的信息
        public NET_DVR_PTZTRACKCHAN_INFO[] struPtzTrackInfo = new NET_DVR_PTZTRACKCHAN_INFO[MAX_CHANNUM_V40]; //调用云台轨迹的通道信息
        public byte byDirection;//触发方向：0-保留；1-全部；2-正向；3-反向
        public byte[] byRes2 = new byte[255];
    }

    public static class NET_DVR_FACELIB_GUARD_COND extends Structure {
        public int dwSize;
        public int dwChannel;  //通道号
        public byte[] szFDID = new byte[68];//人脸库的ID
        public byte[] byRes = new byte[128];
    }

    //导入人脸数据条件
    public static class NET_DVR_FACELIB_COND extends Structure {
        public int dwSize;
        public byte[] szFDID = new byte[NET_SDK_MAX_FDID_LEN/*256*/];//人脸库ID
        public byte byConcurrent;//设备并发处理 0-不开启，1-开始
        public byte byCover;//是否覆盖式导入 0-否，1-是
        public byte byCustomFaceLibID;//FDID是否是自定义，0-不是，1-是；
        public byte byPictureSaveMode;//上传原图保存模式，0-保存，1-不保存;
        public byte[] byIdentityKey = new byte[NET_SDK_MAX_INDENTITY_KEY_LEN/*64*/];//交互操作口令
        public byte[] byRes = new byte[60];
    }

    public static class NET_DVR_SEND_PARAM_IN extends Structure {
        public Pointer pSendData;             //发送的缓冲区,PicURL == 1 的时候，内存中存储的是 URL 字符串,byUploadModeling == 1 的时候，内存中存储的是 建模base64加密数据
        public int dwSendDataLen;         //发送数据长度,PicURL == 1 的时候，表示的 URL 字符串的长度,byUploadModeling == 1 的时候，表示为建模数据base64后的加密长度
        public NET_DVR_TIME_V30 struTime = new NET_DVR_TIME_V30();   //图片时间
        public byte byPicType;              //图片格式,1-jpg,2-bmp,3-png,4-SWF,5-GIF
        public byte byPicURL;               //图片数据采用URL方式 0-二进制图片数据，1-图片数据走URL方式
        /*是否上传建模数据；
    0-	二进制图片数据方式(pSendData指向二进制图片数据, dwPicDataLen为图片二进制数据长度)，
    1-	直接上传建模数据(pSendData指向建模base64加密数据, dwPicDataLen为建模数据base64后的加密长度)。
    注：建模数据采用base64加密方式,选择为建模数据上传后，byPicURL 无需。
    当”/ISAPI/Intelligent/channels/<ID>/faceContrast/capabilities”能力中返回isSupportUploadModeling能力节点时，支持上传建模数据. */
        public byte byUploadModeling;
        public byte byRes1;
        public int dwPicMangeNo;           //图片管理号
        public byte[] sPicName = new byte[NAME_LEN];     //图片名称
        public int dwPicDisplayTime;       //图片播放时长，单位秒
        public Pointer pSendAppendData;       //发送图片的附加信息缓冲区，对应FaceAppendData 的XML描述；
        public int dwSendAppendDataLen;    //发送图片的附加信息数据长度  FaceAppendData  XML的长度；
        public byte[] byRes = new byte[192];
    }

    public static class NET_DVR_INQUEST_ROOM extends Structure {
        public byte byRoomIndex;     //审讯室编号
        public byte byFileType;        //0-审讯文件，1-开庭上传文件
        public byte[] byRes = new byte[22];       //保留
    }

    public static class NET_DVR_INQUEST_CDRW_CFG extends Structure {
        public int dwSize;
        public int dwNum;                       //刻录机的数量
        public int[] dwRwSelectPara = new int[MAX_CHANNUM_V30];// 是否选中该光驱
        public int dwModeSelect;                //0表示循环刻录模式  1表示并行刻录模式(默认模式)
        public byte[] byRes = new byte[24];                   //保留
        public int dwStartCDRW;                 //DVR 本地已经开始刻录
        public int dwHdExcp;                    //硬盘有异 常
        public int dwInterval;                  //时间间隔，10分钟(0)、20分钟(1)、30分钟(2)
        public byte[] sLable = new byte[64];                  //光盘名称
    }

    public static class NET_DVR_INQUEST_CDRW_STATUS extends Structure {
        /*运行状态：0-审讯开始，
     1-审讯过程中刻录，2-审讯停止，
     3-刻录审讯文件,
     4-备份(事后备份和本地备份)
     5-空闲
     6-初始化硬盘
     7-恢复审讯*/
        public int dwType;
        public NET_DVR_INQUEST_CDRW[] strCDRWNum = new NET_DVR_INQUEST_CDRW[MAX_INQUEST_CDRW_NUM];   //数组0表示刻录机1
        public NET_DVR_TIME_EX struInquestStartTime = new NET_DVR_TIME_EX();        //审讯开始的时间点
        public byte[] byRes = new byte[16];             //保留
    }

    public static class NET_DVR_INQUEST_CDRW extends Structure {
        public int dwEnable;            //刻录机状态是否有效,0-无效,1-有效
        public int dwStatus;            /*当dwType=0时， 0-光盘正常，1-无光盘或光盘异常,
                                                            当dwType=1或2时，0-刻录正常，1-无光盘或光盘异常，2-光盘已封盘(81不支持)，3-光盘空间不足， 4-异常导致审讯终止(81不支持)
                                                            当dwType=3时， 0-刻录正常，1-无光盘或光盘异常，2-光盘已封盘(81不支持)，3-光盘空间不足
                                                            当dwType=4时，0-刻录正常，1-无光盘或光盘异常，2-光盘已封盘(81不支持)，3-光盘空间不足
                                                            当dwType=5时,0-光盘正常， 1-无光盘或光盘异常,2-光盘已封盘(81不支持)
                                                            当dwType=6或7时, 0-刻录正常, 1-无光盘或光盘异常, 2-光盘已封盘(81不支持), 3-光盘空间不足*/
        public int dwVolumn;      //光盘容量,单位M
        public int dwFreeSpace;   //光盘剩余容量,单位M
        public int dwTimeLeft;     // 光盘剩余时间，单位秒
        public byte byCDType;         // 光盘类型
        public byte[] byRes = new byte[3];      //保留字节
    }

    //实时温度检测条件参数
    public static class NET_DVR_REALTIME_THERMOMETRY_COND extends Structure {
        public int dwSize; /*结构体大小*/
        public int dwChan; /*通道号，从1开始，0xffffffff代表获取全部通道*/
        public byte byRuleID;/*规则ID，0代表获取全部规则，具体规则ID从1开始*/
        public byte byMode;  //长连接模式：0- 保留（兼容不支持该功能的老设备），1- 定时模式，2- 温差模式
        public byte[] byRes2 = new byte[62];
    }

    //点测温实时信息
    public static class NET_DVR_POINT_THERM_CFG extends Structure {
        public float fTemperature;
        public NET_VCA_POINT struPoint;
        public byte[] byRes = new byte[120];
    }

    //框/线测温实时信息
    public static class NET_DVR_LINEPOLYGON_THERM_CFG extends Structure {
        public float fMaxTemperature;
        public float fMinTemperature;
        public float fAverageTemperature;
        public float fTemperatureDiff;
        public NET_VCA_POLYGON struRegion;
        public byte[] byRes = new byte[32];
    }

    //实时温度信息
    public static class NET_DVR_THERMOMETRY_UPLOAD extends Structure {
        public int dwSize; /* 结构体大小 */
        public int dwRelativeTime;
        public int dwAbsTime;
        public byte[] szRuleName = new byte[NAME_LEN];
        public byte byRuleID;/* 规则ID，0代表获取全部规则，具体规则ID从1开始 */
        public byte byRuleCalibType;
        public short wPresetNo;
        public NET_DVR_POINT_THERM_CFG struPointThermCfg;
        public NET_DVR_LINEPOLYGON_THERM_CFG struLinePolygonThermCfg;
        public byte byThermometryUnit;
        public byte byDataType;
        public byte byRes1;
        public byte bySpecialPointThermType;
        public float fCenterPointTemperature;
        public float fHighestPointTemperature;
        public float fLowestPointTemperature;
        public NET_VCA_POINT struHighestPoint;
        public NET_VCA_POINT struLowestPoint;
        public byte byIsFreezedata;
        public byte[] byRes = new byte[95];
    }

    public static class NET_PTZ_INFO extends Structure {
        public float fPan;
        public float fTilt;
        public float fZoom;
        public int dwFocus;// 聚焦参数，聚焦范围：归一化0-100000
        public byte[] byRes = new byte[4];
    }

    //测温模式配置
    public static class NET_DVR_THERMOMETRY_MODE extends Structure {
        public int dwSize;//结构体大小
        public byte byMode;//测温模式，0~普通模式，1~专家模式
        public byte byThermometryROIEnabled; //测温ROI使能 0-保留 1-不开启 2-开启（基于互斥兼容考虑）
        public byte[] byRes = new byte[62];
    }

    public static class NET_DVR_THERMOMETRY_COND extends Structure {
        public int dwSize;//结构体大小
        public int dwChannel;
        public short wPresetNo;//0-保留
        public byte[] byRes = new byte[62];
    }

    public static class NET_DVR_THERMOMETRY_PRESETINFO_PARAM extends Structure {
        public byte byEnabled;  //是否使能：0- 否，1- 是
        public byte byRuleID;//规则ID 0-表示无效，从1开始 （list内部判断数据有效性）
        public short wDistance;//距离(m)[0, 10000]
        public float fEmissivity;//发射率(发射率 精确到小数点后两位)[0.01, 1.00](即：物体向外辐射能量的本领)
        public byte byDistanceUnit;//距离单位: 0-米（m），1-英尺（feet）,2-厘米(centimeter)
        public byte[] byRes = new byte[2];
        public byte byReflectiveEnabled;//反射温度使能：0- 否，1- 是
        public float fReflectiveTemperature;//反射温度 精确到小数后2位
        public byte[] szRuleName = new byte[NAME_LEN/*32*/];//规则名称
        public byte byemissivityMode; //发射率配置类型 1-粗糙，2-较粗糙，3-较光滑, 4-光滑, 0xff-自定义
        public byte[] byRes1 = new byte[62];
        public byte byRuleCalibType;//规则标定类型 0-点，1-框，2-线
        public NET_VCA_POINT struPoint = new NET_VCA_POINT();//点测温坐标（当规则标定类型为"点"的时候生效）
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();//区域、线（当规则标定类型为"框"或者"线"的时候生效）
    }

    public static class NET_DVR_THERMOMETRY_PRESETINFO extends Structure {
        public int dwSize;//结构体大小
        public short wPresetNo;//0-保留
        public byte[] byRes = new byte[2];
        public NET_DVR_THERMOMETRY_PRESETINFO_PARAM[] struPresetInfo = new NET_DVR_THERMOMETRY_PRESETINFO_PARAM[40];
    }

    //温度报警（检测温度和配置温度比较报警）
    public static class NET_DVR_THERMOMETRY_ALARM extends Structure {
        public int dwSize;
        public int dwChannel;//通道号
        public byte byRuleID;//规则ID
        public byte byThermometryUnit;//测温单位: 0-摄氏度（℃），1-华氏度（℉），2-开尔文(K)
        public short wPresetNo; //预置点号
        public NET_PTZ_INFO struPtzInfo = new NET_PTZ_INFO();//ptz坐标信息
        public byte byAlarmLevel;//0-预警 1-报警
        public byte byAlarmType;/*报警类型 0-最高温度 1-最低温度 2-平均温度 3-温差 4-温度突升 5-温度突降*/
        public byte byAlarmRule;//0-大于，1-小于
        public byte byRuleCalibType;//规则标定类型 0-点，1-框，2线
        public NET_VCA_POINT struPoint = new NET_VCA_POINT();//点测温坐标（当规则标定类型为点的时候生效）
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();//区域（当规则标定类型为框的时候生效）
        public float fRuleTemperature;/*配置规则温度,精确到小数点后一位(-40-1000),（浮点数+100） */
        public float fCurrTemperature;/*当前温度,精确到小数点后一位(-40-1000),（浮点数+100） */
        public int dwPicLen;//可见光图片长度
        public int dwThermalPicLen;//热成像图片长度
        public int dwThermalInfoLen;//热成像附加信息长度
        public Pointer pPicBuff; ///可见光图片指针
        public Pointer pThermalPicBuff;// 热成像图片指针
        public Pointer pThermalInfoBuff; //热成像附加信息指针
        public NET_VCA_POINT struHighestPoint = new NET_VCA_POINT();//线、框测温最高温度位置坐标（当规则标定类型为线、框的时候生效）
        public float fToleranceTemperature;/* 容差温度,精确到小数点后一位(-40-1000),（浮点数+100） */
        public int dwAlertFilteringTime;//温度预警等待时间 单位秒 范围为0-200秒，默认为0秒
        public int dwAlarmFilteringTime;//温度报警等待时间 单位秒 范围为0-200秒，默认为0秒
        public int dwTemperatureSuddenChangeCycle;//温度突变记录周期，单位秒
        public float fTemperatureSuddenChangeValue;//温度突变值,精确到小数点后一位(大于0)
        public byte byPicTransType;        //图片数据传输方式: 0-二进制；1-url
        public byte[] byRes = new byte[39];
    }

    public static class NET_DVR_ARRAY_LIST extends Structure {
        public int dwSize;     // 结构体大小
        public int dwCount;    // 阵列个数
        public NET_DVR_ARRAY_INFO[] struArrayInfo = new NET_DVR_ARRAY_INFO[SUPPORT_ARRAY_NUM];
    }

    public static class NET_DVR_BGA_INFO extends Structure {
        public byte byBga;  // 后台任务及类型
        public byte byBgaState;           /*函数返回值--后台任务状态*/
        public short wBgaPercentage;     /*函数返回值--后台任务执行百分比*/
        public byte[] byRes = new byte[4];  // 保留字节
    }

    // 阵列信息
    public static class NET_DVR_ARRAY_INFO extends Structure {
        public short wArrayID; // 阵列ID
        public byte byRaidMode; // raid模式  参照RAID_MODE
        public byte byStatus;  // 0-在线 1-磁盘丢失 2-下线 3-降级 4-异常 5-次正常 6-外来盘  7-已删除 8-SMART状态异常 0xff-不存在
        public int dwHCapacity; // 阵列容量高32位
        public int dwLCapacity; // 阵列容量低32位
        public int dwHFreeSpace;   // 阵列剩余空间高32位
        public int dwLFreeSpace;   // 阵列剩余空间高32位
        public byte[] byArrayName = new byte[MAX_NAMELEN]; // 阵列名称
        public byte byPDCount;  // 物理磁盘数目
        public byte bySpareCount;   // 热备数目
        public byte[] byRes1 = new byte[2];
        public short[] wPDSlots = new short[SUPPORT_PD_NUM];    // 物理磁盘索引
        public short[] wSparePDSlots = new short[SUPPORT_PD_NUM];    // 热备磁盘索引
        public NET_DVR_BGA_INFO struBgaInfo;    // 后台任务运行状态
        public short[] wPDSlotsPartTwo = new short[SUPPORT_PD_NUM_PARTTWO];  //物理磁盘索引扩展，0表示无效
        public short[] wSparePDSlotsPartTwo = new short[SUPPORT_PD_NUM_PARTTWO];    // 热备磁盘索引扩展，0表示无效
        public byte[] byRes2 = new byte[48]; // 保留字节
    }

    //物理磁盘
    public static class NET_DVR_PHY_DISK_INFO extends Structure {
        public short wPhySlot;         // 硬盘槽位
        public byte byType;         // 硬盘信息；0 普通，1全局热备，2-阵列热备 3-阵列盘
        public byte byStatus;       // 硬盘状态；  0-正常 1-降级 2-已删除 3-磁盘丢失 4-下线 5-次正常 6-外来 7-异常 8-SMART状态异常 9-休眠 10-有坏块 0xff-不存在
        public byte[] byMode = new byte[40];   // 硬盘类型 字符串
        public int dwHCapacity;    //  磁盘总量高32位 单位kb
        public int dwLCapacity;    //  磁盘总量低32位
        public byte[] byArrrayName = new byte[MAX_NAMELEN];
        public short wArrayID;          // 所属阵列ID
        public byte byArrayInformation;   // 是否含有阵列信息：0 否，1是
        public byte[] byRes = new byte[101];         // 保留字节
    }

    public static class NET_DVR_WORKSTATE_V40 extends Structure {
        public int dwSize;            //结构体大小
        public int dwDeviceStatic;      //设备的状态,0-正常,1-CPU占用率太高,超过85%,2-硬件错误,例如串口死掉
        public NET_DVR_DISKSTATE[] struHardDiskStatic = new NET_DVR_DISKSTATE[MAX_DISKNUM_V30];   //硬盘状态,一次最多只能获取33个硬盘信息
        public NET_DVR_CHANNELSTATE_V30[] struChanStatic = new NET_DVR_CHANNELSTATE_V30[MAX_CHANNUM_V40/*512*/];//通道的状态，从前往后顺序排列
        public int[] dwHasAlarmInStatic = new int[MAX_ALARMIN_V40]; //有报警的报警输入口，按值表示，按下标值顺序排列，值为0xffffffff时当前及后续值无效
        public int[] dwHasAlarmOutStatic = new int[MAX_ALARMOUT_V40]; //有报警输出的报警输出口，按值表示，按下标值顺序排列，值为0xffffffff时当前及后续值无效
        public int dwLocalDisplay;            //本地显示状态,0-正常,1-不正常
        public byte[] byAudioInChanStatus = new byte[MAX_AUDIO_V30/*2*/];        //按位表示语音通道的状态 0-未使用，1-使用中，第0位表示第1个语音通道
        public byte[] byRes1 = new byte[2];
        public float fHumidity;    //传感器获知的湿度,范围:0.0 ~100.0
        public float fTemperature;    //传感器获知的温度，范围：-20.0 ~ 90.0
        public byte[] byRes = new byte[116];                 //保留
    }

    public static class NET_DVR_GETWORKSTATE_COND extends Structure {
        public int dwSize;  //结构体长度
        public byte byFindHardByCond; /*0-查找全部磁盘(但一次最多只能查找33个)，此时dwFindHardStatusNum无效*/
        public byte byFindChanByCond;  /*0-查找全部通道，此时dwFindChanNum无效*/
        public byte[] byRes1 = new byte[2];//保留
        public int[] dwFindHardStatus = new int[MAX_DISKNUM_V30/*33*/]; /*要查找的硬盘号，按值表示，该值采用顺序排列， 遇到0xffffffff则认为后续无效 */
        public int[] dwFindChanNo = new int[MAX_CHANNUM_V40/*512*/]; /*要查找的通道号，按值表示，该值采用顺序排列， 遇到0xffffffff则认为后续无效 */
        public byte[] byRes = new byte[64]; //保留
    }

    //多边型结构体
    public static class NET_ITC_POLYGON extends Structure {
        public int dwPointNum; //有效点 大于等于3，若是3点在一条线上认为是无效区域，线交叉认为是无效区域
        public NET_VCA_POINT[] struPos = new NET_VCA_POINT[ITC_MAX_POLYGON_POINT_NUM]; //多边形边界点,最多20个
    }

    public static class CUSTOM_uRegion extends Union {
        public NET_VCA_RECT struRect = new NET_VCA_RECT();
        public NET_ITC_POLYGON struPolygon = new NET_ITC_POLYGON();
    }

    public static class NET_ITC_PLATE_RECOG_REGION_PARAM extends Structure {
        public byte byMode; //区域类型，0-矩形，1-多边形
        public byte[] byRes1 = new byte[3];
        public CUSTOM_uRegion uRegion = new CUSTOM_uRegion();
        public byte[] byRes = new byte[16];    //保留
    }

    //单组IO测速参数
    public static class NET_ITC_SINGLE_IOSPEED_PARAM extends Structure {
        public byte byEnable; //是否启用，0-不启用，1-启用
        public byte byTrigCoil1; //第一线圈关联IO，0-IO1,1-IO2,2-IO3,3-IO4,4-IO5,5-IO6
        public byte byCoil1IOStatus;//第一线圈IO输入口状态，0-下降沿（默认），1-上升沿，2-上升沿和下降沿，3-高电平，4-低电平
        public byte byTrigCoil2; //第二线圈关联IO，0-IO1,1-IO2,2-IO3,3-IO4,4-IO5,5-IO6
        public byte byCoil2IOStatus;//第二线圈IO输入口状态，0-下降沿（默认），1-上升沿，2-上升沿和下降沿，3-高电平，4-低电平
        public byte byRelatedDriveWay;//关联的车道号
        public byte byTimeOut;//超时时间（默认10），单位s
        public byte byRelatedIOOutEx;//第0位表示IO输出口1，以此类推，0-不关联，1-关联 支持关联到8个(兼容byRelatedIOOut字段)
        public int dwDistance;//线圈距离（默认1000）,单位：厘米
        public byte byCapSpeed;//起拍速度（默认30），单位km/h
        public byte bySpeedLimit;//限速值（默认60），单位km/h
        public byte bySpeedCapEn; //是否启用超速抓拍，0-否，1-是
        public byte bySnapTimes1; //线圈1抓拍次数（默认不抓拍），0-不抓拍，非0-连拍次数，最大5次
        public byte bySnapTimes2; //线圈2抓拍次数（默认1），0-不抓拍，非0-连拍次数，最大5次
        public byte byBigCarSpeedLimit; //大车车速限制值
        public byte byBigCarSignSpeed;//标志限速(大车)，单位km/h(3.7Ver)
        public byte byIntervalType;    //间隔类型（默认按时间），0-时间起效,1-距离起效
        public short[] wInterval1 = new short[MAX_INTERVAL_NUM];//线圈1连拍间隔时间（单位ms）或连拍间隔距离（单位分米），当byIntervalType为0时，表示间隔时间，当byIntervalType为1时，表示距离
        public short[] wInterval2 = new short[MAX_INTERVAL_NUM];//线圈2连拍间隔时间（单位ms）或连拍间隔距离（单位分米），当byIntervalType为0时，表示间隔时间，当byIntervalType为1时，表示距离
        public byte[] byRelatedIOOut = new byte[MAX_IOOUT_NUM]; //关联的IO输出口(可以同时关联多个)，数组0表示IO输出口1，数组1表示IO输出口2，以此类推，0-不关联，1-关联
        public byte byFlashMode;   //闪光灯闪烁模式，0-同时闪，1-轮流闪
        public byte byLaneType;   //车道类型，0-未配置、1-高速公路、2-城市快速路、0xff-其他道路
        public byte byCarSignSpeed;//标志限速，单位km/h(3.7Ver)
        public byte byUseageType; //车道用途类型，详见ITC_LANE_USEAGE_TYPE
        public NET_ITC_PLATE_RECOG_REGION_PARAM[] struPlateRecog = new NET_ITC_PLATE_RECOG_REGION_PARAM[MAX_LANEAREA_NUM]; //牌识参数(可用牌识区域1个，保留一个)
        //关联车道方向类型，参考ITC_RELA_LANE_DIRECTION_TYPE
        //该参数为车道方向参数，与关联车道号对应，确保车道唯一性。
        public byte byRelaLaneDirectionType;
        public byte byLowSpeedLimit;                        //小车限底速值，单位km/h
        public byte byBigCarLowSpeedLimit;                //大车限底速值，单位km/h
        public byte byLowSpeedCapEn;                 //是否启用低速抓拍，0-否，1-是
        public byte byEmergencyCapEn;                //是否启用应急车道抓拍，0-否，1-是
        public byte[] byRes = new byte[27];
    }

    //牌识参数
    public static class NET_ITC_PLATE_RECOG_PARAM extends Structure {
        public byte[] byDefaultCHN = new byte[MAX_CHJC_NUM]; /*设备运行省份的汉字简写*/
        public byte byEnable; //是否启用该区域牌识，0-否，1-是
        public int dwRecogMode;
        /*识别的类型，
     bit0-背向识别：0-正向车牌识别，1-背向识别(尾牌识别) ；
     bit1-大车牌识别或小车牌识别：0-小车牌识别，1-大车牌识别 ；
     bit2-车身颜色识别：0-不采用车身颜色识别，在背向识别或小车牌识别时禁止启用，1-车身颜色识别；
     bit3-农用车识别：0-不采用农用车识别，1-农用车识别；
     bit4-模糊识别：0-不采用模糊识别，1-模糊识别；
     bit5-帧定位或场定位：0-帧定位，1-场定位；
     bit6-帧识别或场识别：0-帧识别，1-场识别；
     bit7-晚上或白天：0-白天，1-晚上
     bit8-摩托车识别：0-不采用摩托车识别，1-摩托车识别;
     bit9-场景模式：0-电警/多帧，1-卡口；
     bit10-微小车牌：0-不启用，1-启用微小车牌识别(像素60～80)
     bit11-安全带检测：0-不启用，1-启用安全带检测
     bit12-民航车牌识别: 0-不启用，1-开启民航车牌识别
     bit13-车牌过渡倾斜处理: 0-不启用，1-开启过渡倾斜处理（PRS）
     bit14-超大车牌识别: 0-不启用，1-开启超大车牌识别（PRS）
     bit15-遮阳板检测：0-不启用，1-启用遮阳板检测
     bit16-黄标车检测：0-不启用，1-启用黄标车检测
     bit17-危险品车辆检测：0-不启用，1-启用危险品车辆检测
     bit18-使馆车牌识别：0-不启用，1-启用使馆车牌识别
     bit19-车辆子品牌识别：0-不启用，1-启用车辆子品牌识别
     bit20-打电话识别：0-不启用，1-启用
     bit21-车窗悬挂物识别：0-不启用，1-启用
     */
        public byte byVehicleLogoRecog;//车标识别 0-不启用，1-启用
        /*
     0-保留，1-澳，2-京，3-渝，4-闽，5-甘，6-粤，7-桂，8-贵，9-琼，10-冀，11-豫，
     12-黑，13-鄂，14-湘，15-吉，16-苏，17-赣，18-辽，19-蒙，20-宁，21-青，22-鲁，
     23-晋，24-陕，25-沪，26-川，27-台，28-津，29-藏，30-港，31-新，32-云，33-浙，
     34-皖，0xff-全部
     */
        public byte byProvince;//省份索引值
        public byte byRegion;// 区域索引值 0-保留，1-欧洲，2-俄语区域, 3-欧洲&俄罗斯(EU&CIS),4-中东(Middle East)
        public byte byCountry;//国家索引，参照枚举COUNTRY_INDEX(不支持“COUNTRY_ALL = 0xff,//ALL 全部”)
        public short wPlatePixelWidthMin;//车牌像素识别宽度最小值（单位是像素）当前推荐范围[130,500]
        public short wPlatePixelWidthMax;//车牌像素识别宽度最大值（单位是像素）当前推荐范围[130,500]
        public byte[] byRes = new byte[24];
    }

    //卡口IO测速参数
    public static class NET_ITC_POST_IOSPEED_PARAM extends Structure {
        public NET_ITC_PLATE_RECOG_PARAM struPlateRecog; //牌识参数
        public NET_ITC_SINGLE_IOSPEED_PARAM[] struSingleIOSpeed = new NET_ITC_SINGLE_IOSPEED_PARAM[MAX_IOSPEED_GROUP_NUM]; //单个IO测速组参数
        public byte[] byRes = new byte[32];
    }

    public static class NET_DVR_GEOGLOCATION extends Structure {
        public int[] iRes = new int[2]; /*保留*/
        public int dwCity; /*城市，详见PROVINCE_CITY_IDX */
    }

    public static class NET_ITC_INTERVAL_PARAM extends Structure {
        public byte byIntervalType;    //间隔类型（默认按时间），0-时间起效,1-距离起效
        public byte[] byRes1 = new byte[3];
        public short[] wInterval = new short[MAX_INTERVAL_NUM];//连拍间隔时间（单位ms）或连拍间隔距离（单位分米），当byIntervalType为0时，表示间隔时间，当byIntervalType为1时，表示距离
        public byte[] byRes = new byte[8];
    }

    public static class NET_ITC_VTLANE_PARAM extends Structure {
        public byte byRelatedDriveWay;//关联的车道号
        public byte bySpeedCapEn; //是否启用超速抓拍，0-否，1-是
        public byte bySignSpeed;//标志限速，单位km/h
        public byte bySpeedLimit;//限速值，单位km/h
        public byte bySnapTimes; //抓拍次数（默认1），0-不抓拍，非0-连拍次数，最大5
        public byte byBigCarSignSpeed;///*大车标志限速，单位km/h*/
        public byte byBigCarSpeedLimit;/*大车限速值，单位km/h*/
        public byte byRelatedIOOutEx;//第0位表示IO输出口1，以此类推，0-不关联，1-关联 支持关联到8个(兼容byRelatedIOOut字段)
        public NET_ITC_INTERVAL_PARAM struInterval = new NET_ITC_INTERVAL_PARAM(); //抓拍间隔参数
        public byte[] byRelatedIOOut = new byte[MAX_IOOUT_NUM]; //关联的IO输出口，可以同时关联多个
        public byte byFlashMode;   //闪光灯闪烁模式，0-同时闪，1-轮流闪
        public byte byLowSpeedLimit;/*限低速，单位km/h*/
        public byte byBigCarLowSpeedLimit; /*大车限低速，单位km/h*/
        //关联车道方向类型，参考ITC_RELA_LANE_DIRECTION_TYPE
        //该参数为车道方向参数，与关联车道号对应，确保车道唯一性。
        public byte byRelaLaneDirectionType;
        public NET_ITC_PLATE_RECOG_REGION_PARAM[] struPlateRecog = new NET_ITC_PLATE_RECOG_REGION_PARAM[MAX_LANEAREA_NUM]; //车道牌识参数
        public NET_VCA_LINE struLine = new NET_VCA_LINE(); //车道线
    }

    public static class NET_ITC_VTCOIL_INFO extends Structure {
        public NET_VCA_RECT struLaneRect = new NET_VCA_RECT();  /*虚拟线圈区域*/
        public byte byTrigFlag; //触发标志，0-车头触发；1-车尾触发；2-车头/车尾都触发
        public byte byTrigSensitive;  //触发灵敏度，1-100
        public byte[] byRelatedIOOut = new byte[MAX_IOOUT_NUM]; //关联的IO输出口(可以同时关联多个)，数组0表示IO输出口1，数组1表示IO输出口2，以此类推，0-不关联，1-关联
        public byte byFlashMode;   //闪光灯闪烁模式，0-同时闪，1-轮流闪
        public byte byLaneType;   //车道类型，0-未配置、1-高速公路、2-城市快速路、0xff-其他道路
        public byte byEnableRadar; //是否启用雷达测速，0-否，1-是
        public NET_ITC_VTLANE_PARAM struLane = new NET_ITC_VTLANE_PARAM(); //关联的车道参数
        //车道用途类型，详见ITC_LANE_USEAGE_TYPE，使用1和8两种类型(3.7Ver)
        public byte byUseageType;
        //车辆行驶方向，详见ITC_LANE_CAR_DRIVE_DIRECT(3.7Ver)
        public byte byCarDriveDirect;
        public byte[] byRes = new byte[30];
    }

    public static class NET_ITC_RADAR_PARAM extends Structure {
        public byte byRadarType;    //雷达类型，0-无雷达,1-安道雷雷达，2-奥利维亚，3-川速微波4,雷达接IO扩展盒(此参数在卡口虚拟线圈、混行卡口界面中使用，卡口RS485雷达不使用),0xff-其它类型
        public byte byLevelAngle;   //与水平线所成角度,默认为25°(0到90度)
        public short wRadarSensitivity; //雷达灵敏度
        public short wRadarSpeedValidTime;//雷达速度有效时间(0~2000] ,0表示不支持
        public byte[] byRes1 = new byte[2];
        public float fLineCorrectParam;//线性矫正参数[0.0~2.0]
        public int iConstCorrectParam;//常量矫正参数[-100~100]
        public byte[] byRes2 = new byte[8];
    }

    //卡口虚拟线圈触发参数
    public static class NET_ITC_POST_VTCOIL_PARAM extends Structure {
        public byte byRelatedLaneNum;//关联的车道个数
        public byte byIsDisplay; //视频中是否显示虚拟线圈，0-不显示，1-显示
        public byte byLoopPos; //晚间触发线圈的偏向（默认10）
        public byte byPolarLenType; /*偏振镜类型，0：不加偏振镜；1：加施耐德偏振镜。*/
        public byte byDayAuxLightMode; /*白天辅助照明模式，0：无辅助照明；1：LED灯照明；2：闪光灯照明*/
        public byte byVideoLaneNO; //视频参考亮度的参考车道号
        public byte byVideoLowTh; /*视频参考亮度低阈值初始化值（默认40）*/
        public byte byVideoHighTh; /*视频参考亮度高阈值初始化值（默认55）*/
        public byte byRecordMode; //录像标志：0-不录像，1-录像
        public byte bySnapMode;//抓拍模式：0-频闪模式；1-爆闪模式
        /*测速方式：0-不测速，0x1-雷达测速，0x2-视频测速*/
        public byte bySpeedDetector;
        public byte byRes2;
        public short wResolutionX;/* 设备当前分辨率宽*/
        public short wResolutionY;/* 设备当前分辨率高*/
        public int dwDayInitExp; /*视频白天曝光时间的初始值2000*/
        public int dwDayMaxExp; /*视频白天曝光时间的最大值20000*/
        public int dwNightExp; /*晚间视频曝光时间的设置值3000*/
        public int dwSnapExp; /*抓拍曝光时间*/
        public byte byDayInitGain; /*视频白天增益的初始值200*/
        public byte byDayMaxGain; /*视频白天增益的最大值400*/
        public byte byNightGain; /*晚间视频增益*/
        public byte bySnapGain; /*抓拍增益*/
        public int dwSceneMode; //场景模式， 详见SCENE_MODE
        public NET_DVR_GEOGLOCATION struGeogLocation = new NET_DVR_GEOGLOCATION(); //地址位置(默认浙江)
        public NET_ITC_PLATE_RECOG_PARAM struPlateRecog = new NET_ITC_PLATE_RECOG_PARAM(); //牌识参数
        public NET_ITC_VTCOIL_INFO[] struVtCoil = new NET_ITC_VTCOIL_INFO[MAX_VL_NUM]; //虚拟线圈参数
        public NET_ITC_RADAR_PARAM struRadar = new NET_ITC_RADAR_PARAM();  //雷达参数
        public NET_VCA_LINE struLine = new NET_VCA_LINE(); //右车道线
        //违规检测类型，按位表示，详见ITC_VIOLATION_DETECT_TYPE，0-不启用，1-启用(3.7Ver)
        public int dwVioDetectType;
        public byte byDebugMode; /*调试模式，0-不启用，1-启用*/
        public byte[] byRes = new byte[11];
    }

    //车道属性参数结构
    public static class NET_ITC_LANE_LOGIC_PARAM extends Structure {
        public byte byUseageType;     //车道用途类型，详见ITC_LANE_USEAGE_TYPE
        public byte byDirectionType;  //车道方向类型，详见ITC_LANE_DIRECTION_TYPE
        public byte byCarDriveDirect; //车辆行驶方向，详见ITC_LANE_CAR_DRIVE_DIRECT
        public byte[] byRes = new byte[33];        //保留
    }

    //视频电警线结构
    public static class NET_ITC_LINE extends Structure {
        public NET_VCA_LINE struLine = new NET_VCA_LINE(); //线参数
        public byte byLineType; //线类型，详见ITC_LINE_TYPE
        public byte[] byRes = new byte[7];
    }

    public static class NET_ITC_SNAPMODE_PARAM extends Structure {
        public byte byVehicleCapMode;//机动车抓拍模式，0-频闪模式；1-爆闪模式
        public byte byNoVehicleCapMode;//非机动车抓拍模式，0-频闪模式；1-爆闪模式
        public byte byPasserCapMode;//行人抓拍模式，0-频闪模式；1-爆闪模式
        public byte[] byRes = new byte[29];
    }

    //size = 128
    public static class NET_ITC_HVT_EC_PARAM extends Structure {
        public int dwCapShutter;            //抓拍快门0~65535
        public short wCapGain;            //抓拍增益0～100
        public byte[] byRes = new byte[2];
        public int dwDayTimeVideoShutter;    //白天曝光时间最大值
        public short wDayTimeVideoGain;        //白天增益最大值
        public short wNightVideoGain;            //晚上增益最大值
        public short wNightVideoShutter;        //晚上曝光时间最大值
        public byte[] byRes1 = new byte[108];
    }

    public static class NET_ITC_LANE_HVT_PARAM extends Structure {
        public byte byLaneNO; //关联的车道号 1~255（用于叠加和上传）
        public byte bySignSpeed;    //标志限速，单位km/h 0～255  70
        public byte bySpeedLimit;    //限速值，单位km/h 0～255    80 实际起效
        public byte byBigCarSignSpeed;///*大车标志限速，单位km/h*/
        public byte byBigCarSpeedLimit;/*大车限速值，单位km/h*/
        public byte bySpeedCapEn; //是否启用超速抓拍，0-否，1-是
        public byte byCaptureCount;//抓拍张数1～5(正常)
        public byte byRelatedIOOut;    /*关联的IO输出口(可以同时关联多个)，按位表示IO输出口，第0位表示IO输出口1，以此类推，0-不关联，1-关联*/
        public byte byFlashMode;        /*闪光灯闪烁模式，0-同时闪，1-轮流闪*/
        public byte byEnableRadar; //是否启用雷达测速，0-否，1-是
        public byte byChangeLaneEnable;   //违章变道抓拍使能，0-关闭，1-开启
        public byte byChangeLaneCapNo;    //违章变道抓拍张数2-3
        public int dwCapTarget;    //抓拍类型 bit0 表示机动车 bit1 表示非机动车 bit2 表示行人 0～表示不选择 1～表示选择
        public NET_ITC_INTERVAL_PARAM struInterval; //抓拍间隔参数
        public byte[] byRes3 = new byte[24];
        public NET_ITC_LANE_LOGIC_PARAM struLane; //车道属性，用byUseageType和byCarDriveDirect
        public NET_ITC_LINE struLeftLaneLine;          //左车道线，线类型为虚线、实线、单黄线和双黄线
        public NET_ITC_LINE struRightLaneLine;          //右车道线，线类型为虚线、实线、单黄线和双黄线
        public NET_ITC_POLYGON struPlateRecog;         //牌识区域参数
        public NET_ITC_POLYGON struTraceArea;          //视频触发焦点区域
        public NET_VCA_LINE struForwardTrigLine;      //正向触发线：一条线段，关心端点位置，目前只支持水平配置，接口按线段的两个端点保存。（一般配置为正向车辆的最佳触发位置）
        public NET_VCA_LINE struBackwardTrigLine;     //背向触发线：一条线段，关心端点位置，目前只支持水平配置，接口按线段的两个端点保存（一般配置为背向车辆的最佳触发位置）
        public NET_VCA_LINE struLeftTrigLine;          //左边触发线：一条线段，关心端点位置，目前只支持垂直配置，接口按线段的两个端点保存（一般配置为从左边进入车辆的最佳触发位置）
        public NET_VCA_LINE struRightTrigLine;          //右边触发线：一条线段，关心端点位置，目前只支持垂直配置，接口按线段的两个端点保存（一般配置为从右边进入车辆的最佳触发位置）
        public byte[] byRes4 = new byte[60];
    }

    public static class NET_ITC_POST_HVT_PARAM extends Structure {
        public byte byLaneNum;//识别的车道个数，1-6
        public byte bySceneMode;//0-未知1-城区道路；2-小区出入口
        public byte byRoadExpBright;//路面期望亮度（视频曝光参数调整的依据之一。在无机动车时，依据此亮度期望值，调整视频曝光参数）
        public byte byPlateExpBright;//车牌期望亮度（视频曝光参数调整的依据之一。在有机动车通过并识别到车牌时，依据此亮度期望值，对视频曝光参数调整）
        public NET_ITC_POLYGON struDetectArea;                    //视频检测区域
        public NET_ITC_SNAPMODE_PARAM struCapMode = new NET_ITC_SNAPMODE_PARAM();//抓拍模式
        public NET_ITC_HVT_EC_PARAM struEcParam = new NET_ITC_HVT_EC_PARAM();    //曝光控制参数
        public NET_ITC_LANE_HVT_PARAM[] struLaneParam = new NET_ITC_LANE_HVT_PARAM[MAX_ITC_LANE_NUM]; //单车道属性
        public NET_ITC_PLATE_RECOG_PARAM struPlateRecog = new NET_ITC_PLATE_RECOG_PARAM();    //牌识参数
        public NET_DVR_GEOGLOCATION struGeogLocation = new NET_DVR_GEOGLOCATION();    //地址位置（默认浙江）
        public byte[] byRes = new byte[324];
    }

    //抓拍机4.0新增
    public static class NET_ITC_LANE_HVT_PARAM_V50 extends Structure {
        public byte byLaneNO;        //关联的车道号1～255(用于叠加和上传)
        public byte byFlashMode;    //闪光灯闪烁模式，0-同时闪，1-轮流闪
        public byte bySignSpeed;    //小车标志限高速，单位km/h
        public byte bySpeedLimit;    //小车限高速值，单位km/h
        public byte bySignLowSpeed;    //小车标志限底速，单位km/h
        public byte byLowSpeedLimit;    //小车限底速值，单位km/h
        public byte byBigCarSignSpeed;    //大车标志限高速，单位km/h（新交规）
        public byte byBigCarSpeedLimit;    //大车限高速值，单位km/h（新交规）
        public byte byBigCarSignLowSpeed;    //大车标志限底速，单位km/h
        public byte byBigCarLowSpeedLimit;    //大车限底速值，单位km/h
        public byte bySnapTimes;    //卡口抓拍张数，1~3
        public byte byDriveLineSnapTime;// 压线抓拍张数 1~3
        public byte byHighSpeedSnapTime;// 超高速抓拍张数1~3
        public byte byLowSpeedSnapTime;// 超低速抓拍张数1~3
        public byte byBanSnapTime;// 违反禁令抓拍张数  1~3
        public byte byReverseSnapTime;//逆行抓拍张数  1~3
        public byte byRelatedDriveWay;                //关联车道号，用于匹配车检器
        public byte byLaneType;   //车道类型，0-未配置、1-高速公路、2-城市快速路、0xff-其他道路
        //关联车道方向类型，参考ITC_RELA_LANE_DIRECTION_TYPE
        //该参数为车道方向参数，与关联车道号byRelatedDriveWay对应，确保车道唯一性。
        public byte byRelaLaneDirectionType;
        public byte[] byRes1 = new byte[27];
        public byte byChangeLaneEnable;   //违章变道抓拍使能，0-关闭，1-开启
        public byte byChangeLaneCapNo;    //违章变道抓拍张数2-3
        //目前仅使用第一个车道的，以后可能会扩展为多车道分别配置
        //类型, 按位表示,0-不启用,1-启用参考 ITC_VIOLATION_DETECT_TYPE
        public int dwVioDetectType;
        public int dwRelatedIOOut;  //关联的IO输出口(可以同时关联多个)，按位表示IO输出口，第0位表示IO输出口1，以此类推，0-不关联，1-关联
        public NET_ITC_LINE struTrigLine; //触发线，目前仅使用第一个车道的，以后可能会扩展为多车道分别配置
        public NET_ITC_LINE struLineLeft;                //左车道线
        public NET_ITC_POLYGON struPlateRecog;       //牌识区域
        public NET_ITC_LANE_LOGIC_PARAM struLane;   //车道属性，用byUseageType和byCarDriveDirect
        public NET_ITC_INTERVAL_PARAM struInterval;//抓拍间隔参数（20byte）
        public byte[] byRes2 = new byte[280];
    }

    public static class NET_ITC_POST_HVT_PARAM_V50 extends Structure {
        public byte byLaneNum;    //识别的车道个数，1-6
        public byte byCapType;        //抓拍类型，0-机、非、人（默认），1-机动车
        public byte byCapMode;    //抓拍方式，0-视频抽帧，1-打断抓拍，2-混合模式，
        public byte bySecneMode;    //场景模式，0-城区道路（默认），1-小区出入口，2-高速公路
        public byte bySpeedMode;  //测速模式，0-无测速，1-雷达测速，2-视频测速
        public byte byLineRuleEffect; //触发规则线有效性,每一位代表一条触发线,0-无效;1-有效。bit0-左触发线;bit1-右触发线;bit2-视频检测区域
        public byte[] byRes1 = new byte[78];
        public NET_ITC_LINE struLeftTrigLine;    //左触发线(一条垂直线)
        public NET_ITC_LINE struRigtTrigLine;    //右触发线(一条垂直线)
        public NET_ITC_LINE struLaneBoundaryLine;        //车道边界线（最右边车道的右车道线）
        public NET_ITC_POLYGON struDetectArea;    //视频检测区域
        public NET_DVR_GEOGLOCATION struGeogLocation; //地理位置（默认浙江省）计算时区
        public NET_ITC_LANE_HVT_PARAM_V50[] struLaneParam = new NET_ITC_LANE_HVT_PARAM_V50[MAX_ITC_LANE_NUM/*6*/]; //单车道属性
        public NET_ITC_PLATE_RECOG_PARAM struPlateRecog;    //牌识参数
        public byte[] byRes2 = new byte[260];
    }


    public static class NET_ITC_LANE_PARAM extends Structure {
        public byte byEnable; //是否启用该车道，0-不启用，1-启用
        public byte byRelatedDriveWay;//关联的车道号
        public short wDistance; //线圈距离，计算速度
        public short wTrigDelayTime; //触发延迟时间（默认200），单位：毫秒
        public byte byTrigDelayDistance; //触发延迟距离（默认0），单位：分米
        public byte bySpeedCapEn; //是否启用超速抓拍，0-否，1-是
        public byte bySignSpeed;//标志限速，单位km/h
        public byte bySpeedLimit;//限速值，单位km/h
        public byte bySnapTimes; //抓拍次数（默认1），0-不抓拍，非0-连拍次数，最大5
        public byte byOverlayDriveWay; //OSD叠加的车道号
        public NET_ITC_INTERVAL_PARAM struInterval; //抓拍间隔参数
        public byte[] byRelatedIOOut = new byte[MAX_IOOUT_NUM]; //关联的IO输出口，可以同时关联多个
        public byte byFlashMode;   //闪光灯闪烁模式，0-同时闪，1-轮流闪
        public byte byCartSignSpeed;//标志限速(大车)，单位km/h
        public byte byCartSpeedLimit;//限速值（大车），单位km/h
        public byte byRelatedIOOutEx;//第0位表示IO输出口1，以此类推，0-不关联，1-关联 支持关联到8个(兼容byRelatedIOOut字段)
        public NET_ITC_PLATE_RECOG_REGION_PARAM[] struPlateRecog = new NET_ITC_PLATE_RECOG_REGION_PARAM[MAX_LANEAREA_NUM]; //车道牌识参数
        public byte byLaneType;   //车道类型，0-未配置、1-高速公路、2-城市快速路、0xff-其他道路
        public byte byUseageType; //车道用途类型，详见ITC_LANE_USEAGE_TYPE
        //关联车道方向类型，参考ITC_RELA_LANE_DIRECTION_TYPE
        //该参数为车道方向参数，与关联车道号对应，确保车道唯一性。
        public byte byRelaLaneDirectionType;
        public byte byLowSpeedLimit;                    //小车限底速值，单位km/h
        public byte byBigCarLowSpeedLimit;                //大车限底速值，单位km/h
        public byte byLowSpeedCapEn;                   //是否启用低速抓拍，0-否，1-是
        public byte byEmergencyCapEn;                 //是否启用应急车道抓拍，0-否，1-是
        public byte[] byRes = new byte[9];
    }

    //卡口RS485车检器触发参数
    public static class NET_ITC_POST_RS485_PARAM extends Structure {
        public byte byRelatedLaneNum;//关联的车道个数
        public byte byTriggerSpareMode; //触发备用模式，0-默认，1-卡口虚拟线圈模式,2-卡口混合车道模式
        public byte byFaultToleranceTime;//容错时间(单位:分钟)，用于检测车检器是否正常的最大时间
        public byte byRes1;
        public NET_ITC_PLATE_RECOG_PARAM struPlateRecog = new NET_ITC_PLATE_RECOG_PARAM(); //牌识参数
        public NET_ITC_LANE_PARAM[] struLane = new NET_ITC_LANE_PARAM[MAX_ITC_LANE_NUM]; //关联的车道参数
        public byte[] byRes = new byte[32];
    }

    //卡口RS485雷达触发参数
    public static class NET_ITC_POST_RS485_RADAR_PARAM extends Structure {
        public byte byRelatedLaneNum;//关联的车道个数
        public byte[] byRes1 = new byte[3];
        public NET_ITC_PLATE_RECOG_PARAM struPlateRecog = new NET_ITC_PLATE_RECOG_PARAM(); //牌识参数
        public NET_ITC_LANE_PARAM[] struLane = new NET_ITC_LANE_PARAM[MAX_ITC_LANE_NUM]; //关联的车道参数
        public NET_ITC_RADAR_PARAM struRadar = new NET_ITC_RADAR_PARAM();  //雷达参数
        public byte[] byRes = new byte[32];
    }

    public static class NET_ITC_TRIGGER_PARAM_UNION extends Union {
        public int[] uLen = new int[1070];            //参数
        public NET_ITC_POST_IOSPEED_PARAM struIOSpeed = new NET_ITC_POST_IOSPEED_PARAM();    //（卡口）IO测速参数
        //	public NET_ITC_POST_SINGLEIO_PARAM     struSingleIO = new NET_ITC_POST_SINGLEIO_PARAM();   //（卡口）单IO参数
        public NET_ITC_POST_RS485_PARAM struPostRs485 = new NET_ITC_POST_RS485_PARAM();  //（卡口）RS485车检器参数
        public NET_ITC_POST_RS485_RADAR_PARAM struPostRadar = new NET_ITC_POST_RS485_RADAR_PARAM();  //（卡口）RS485雷达参数
        public NET_ITC_POST_VTCOIL_PARAM struVtCoil = new NET_ITC_POST_VTCOIL_PARAM();     //（卡口）虚拟线圈参数
        public NET_ITC_POST_HVT_PARAM struHvt = new NET_ITC_POST_HVT_PARAM();        //（卡口）混行卡口参数
        //	public NET_ITC_EPOLICE_IOTL_PARAM      struIOTL = new NET_ITC_EPOLICE_IOTL_PARAM();        //（电警）IO红绿灯参数
//	public NET_ITC_EPOLICE_RS485_PARAM     struEpoliceRs485 = new NET_ITC_EPOLICE_RS485_PARAM(); //（电警）RS485车检器触发参数
//	public NET_ITC_EPOLICE_RS485_PARAM     struPERs485 = new NET_ITC_EPOLICE_RS485_PARAM();    //（卡式电警）RS485车检器触发参数
//	public NET_ITC_POST_MPR_PARAM          struPostMpr = new NET_ITC_POST_MPR_PARAM();    //多帧检测触发（MPR）
//	public NET_DVR_VIA_VTCOIL_PARAM        struViaVtCoil = new NET_DVR_VIA_VTCOIL_PARAM();  //(VIA)视频检测参数
//	public NET_ITC_POST_IMT_PARAM          struPostImt = new NET_ITC_POST_IMT_PARAM();//智慧监控触发
//	public NET_ITC_POST_PRS_PARAM          struPostPrs = new NET_ITC_POST_PRS_PARAM();//视频检测触发
//	public NET_IPC_POST_HVT_PARAM          struIpcHvt = new NET_IPC_POST_HVT_PARAM();//(IPC) 混行卡口参数
        public NET_ITC_POST_HVT_PARAM_V50 struHvtV50 = new NET_ITC_POST_HVT_PARAM_V50();  /*（卡口）混行卡口参数V50*/
//	public NET_ITC_POST_MOBILE_PARAM       struPostMobile = new NET_ITC_POST_MOBILE_PARAM();// 移动交通触发模式
//	public NET_ITC_NOCOMITY_PEDESTRIAN_PARAM struNoComityPed = new NET_ITC_NOCOMITY_PEDESTRIAN_PARAM();//不礼让行人参数
//	public NET_ITC_REDLIGHT_PEDESTRIAN_PARAM struRedLightPed = new NET_ITC_REDLIGHT_PEDESTRIAN_PARAM();//行人闯红灯参数
    }

    //单个触发参数结构
    public static class NET_ITC_SINGLE_TRIGGERCFG extends Structure {
        public byte byEnable;    //是否启用该触发模式，0-否，1-是
        public byte[] byRes1 = new byte[3];
        public int dwTriggerType; //触发类型，详见ITC_TRIGGERMODE_TYPE
        public NET_ITC_TRIGGER_PARAM_UNION uTriggerParam = new NET_ITC_TRIGGER_PARAM_UNION(); //触发参数
        public byte[] byRes = new byte[64];
    }

    //触发参数结构
    public static class NET_ITC_TRIGGERCFG extends Structure {
        public int dwSize;            //结构长度
        public NET_ITC_SINGLE_TRIGGERCFG struTriggerParam;  //单个触发参数
        public byte[] byRes = new byte[32];
    }

    //单个IO接入信号灯参数
    public static class NET_ITC_SINGLE_IO_LIGHT_PARAM extends Structure {
        public byte byLightType; //交通灯导向类型,0-左转灯,1-直行灯,2-右转灯
        public byte byRelatedIO; //关联的IO口号
        public byte byRedLightState; //红灯电平状态，0-高电平红灯，1-低电平红灯
        public byte[] byRes = new byte[17];
    }

    //IO接入信号灯参数
    public static class NET_ITC_IO_LIGHT_PARAM extends Structure {
        public NET_ITC_SINGLE_IO_LIGHT_PARAM[] struIOLight = new NET_ITC_SINGLE_IO_LIGHT_PARAM[MAX_LIGHT_NUM]; //单个IO接入信号灯参数
        public byte[] byRes = new byte[8];
    }

    //单个485接入信号灯参数
    public static class NET_ITC_SINGLE_RS485_LIGHT_PARAM extends Structure {
        public byte byLightType; //交通灯导向类型，0-左转灯，1-直行灯，2-右转灯
        public byte byRelatedLightChan; //关联的红绿灯检测器通道号
        public byte byInputLight;    //接入的信号灯类型，0-接红灯，1-接绿灯
        public byte byRelatedYLightChan; //关联的黄灯检测器通道号
        public byte[] byRes = new byte[16];
    }

    //485接入信号灯参数
    public static class NET_ITC_RS485_LIGHT_PARAM extends Structure {
        public NET_ITC_SINGLE_RS485_LIGHT_PARAM[] struRS485Light = new NET_ITC_SINGLE_RS485_LIGHT_PARAM[MAX_LIGHT_NUM]; //单个485接入信号灯参数
        public byte[] byRes = new byte[8];
    }

    public static class NET_POS_PARAM extends Structure {
        public short wLeft;
        public short wTop;
        public short wRight;
        public short wBottom;
    }

    //单组视频检测交通信号灯参数结构
    public static class NET_ITC_SINGLE_VIDEO_DETECT_LIGHT_PARAM extends Structure {
        public byte byLightNum; //交通灯个数
        public byte byStraightLight; //是否有直行标志灯，0-否 ，1-是
        public byte byLeftLight; //是否有左转标志灯，0-否，1-是
        public byte byRightLight; //是否有右转标志灯，0-否，1-是
        public byte byRedLight;//是否有红灯，0-否，1-是
        public byte byGreenLight; //是否有绿灯，0-否，1-是
        public byte byYellowLight; //是否有黄灯，0-否，1-是
        public byte byYellowLightTime;//取值范围（0～10s）（ITC3.7Ver）
        public NET_POS_PARAM struLightRect; //交通灯区域
        public byte[] byRes = new byte[24];
    }

    //视频检测交通信号灯参数结构(最大可有12个区域检测，488字节)
    public static class NET_ITC_VIDEO_DETECT_LIGHT_PARAM extends Structure {
        public NET_ITC_SINGLE_VIDEO_DETECT_LIGHT_PARAM[] struTrafficLight = new NET_ITC_SINGLE_VIDEO_DETECT_LIGHT_PARAM[MAX_VIDEO_DETECT_LIGHT_NUM]; //单个视频检测信号灯参数
        public byte[] byRes = new byte[8];
    }

    //交通信号灯接入参数
    public static class NET_ITC_LIGHT_ACCESSPARAM_UNION extends Union {
        public int[] uLen = new int[122];
        public NET_ITC_IO_LIGHT_PARAM struIOLight; //IO接入信号灯参数
        public NET_ITC_RS485_LIGHT_PARAM struRS485Light; //485接入信号灯参数
        public NET_ITC_VIDEO_DETECT_LIGHT_PARAM struVideoDelectLight; //视频检测信号灯参数
    }

    //交通信号灯参数结构
    public static class NET_ITC_TRAFFIC_LIGHT_PARAM extends Structure {
        public byte bySource; //交通信号灯接入源，0-IO接入，1-RS485接入
        public byte[] byRes1 = new byte[3];
        public NET_ITC_LIGHT_ACCESSPARAM_UNION struLightAccess = new NET_ITC_LIGHT_ACCESSPARAM_UNION();//信号灯接入参数
        public byte[] byRes = new byte[32];
    }

    //违规检测参数结构
    public static class NET_ITC_VIOLATION_DETECT_PARAM extends Structure {
        public int dwVioDetectType; //违规检测类型, 按位表示, 详见ITC_VIOLATION_DETECT_TYPE ,0-不启用,1-启用
        public byte byDriveLineSnapTimes; //压车道线抓拍张数,2-3
        public byte byReverseSnapTimes; //逆行抓拍,2-3
        public short wStayTime; //机占非停留时间（该时间后抓拍），单位s
        public byte byNonDriveSnapTimes;//机占非抓拍张数2-3
        public byte byChangeLaneTimes;//违法变道抓拍张数 2-3
        public byte bybanTimes;//违法禁令抓拍张数2-3
        public byte byDriveLineSnapSen;// 压线灵敏度(0~100)(3.7Ver)
        public short wSnapPosFixPixel; //第2,3张抓拍位置最小偏移(违反信号灯时起效)（单位：像素） 命名需改进
        public byte bySpeedTimes;//违法超速抓拍张数2-3(3.8Ver)
        public byte byTurnAroundEnable;//违章掉头使能 0~关闭 1~开启
        public byte byThirdPlateRecogTime;//第三张牌识时间 0~180s
        public byte byPostSnapTimes;//卡口抓拍张数,1-2张
        public byte[] byRes1 = new byte[18];
        public short wStopLineDis;  //电警第2张违规图片与停止线的最短距离，[0,300]单位(像素)
        public byte[] byRes = new byte[14];
    }

    //违规检测线参数结构
    public static class NET_ITC_VIOLATION_DETECT_LINE extends Structure {
        public NET_ITC_LINE struLaneLine = new NET_ITC_LINE(); //车道线参数
        public NET_ITC_LINE struStopLine = new NET_ITC_LINE(); //停止线参数
        public NET_ITC_LINE struRedLightLine = new NET_ITC_LINE(); //闯红灯触发线参数
        public NET_ITC_LINE struCancelLine = new NET_ITC_LINE(); //直行触发位置取消线
        public NET_ITC_LINE struWaitLine = new NET_ITC_LINE(); //待行区停止线参数
        public NET_ITC_LINE[] struRes = new NET_ITC_LINE[8];
    }

    //单个车道视频电警触发参数结构
    public static class NET_ITC_LANE_VIDEO_EPOLICE_PARAM extends Structure {
        public byte byLaneNO; //关联的车道号
        public byte bySensitivity; //线圈灵敏度，[1,100]
        public byte byEnableRadar;//启用雷达测试0-不启用，1-启用
        //关联车道方向类型，参考ITC_RELA_LANE_DIRECTION_TYPE
        //该参数为车道方向参数，与关联车道号对应，确保车道唯一性。
        public byte byRelaLaneDirectionType;
        public NET_ITC_LANE_LOGIC_PARAM struLane; //车道参数
        public NET_ITC_VIOLATION_DETECT_PARAM struVioDetect; //违规检测参数
        public NET_ITC_VIOLATION_DETECT_LINE struLine; //违规检测线
        public NET_ITC_POLYGON struPlateRecog; //牌识区域参数
        public byte byRecordEnable;//闯红灯周期录像标志，0-不录像，1-录像
        public byte byRecordType;//闯红灯录像类型，0-预录，1-延时录像
        public byte byPreRecordTime;//闯红灯录像片段预录时间（默认0），单位：秒
        public byte byRecordDelayTime;//闯红灯录像片段延时时间（默认0），单位：秒
        public byte byRecordTimeOut;//闯红灯周期录像超时时间（秒）
        public byte byCarSpeedLimit; //车速限制值，单位km/h
        public byte byCarSignSpeed;//标志限速，单位km/h
        public byte bySnapPicPreRecord; //抓拍图片预录时间点；0-默认值（第二张图片），1-第一张图片，2-第二张图片，3-第三张图片
        public NET_ITC_INTERVAL_PARAM struInterval;//抓拍间隔参数（20byte）
        public byte[] byRes = new byte[36];
    }

    //视频电警触发参数结构
    public static class NET_ITC_VIDEO_EPOLICE_PARAM extends Structure {
        public byte byEnable;    //是否启用，0-不启用，1-启用
        public byte byLaneNum; //识别的车道个数
        public byte byLogicJudge;//闯红灯违规判断逻辑，设置值为：0-按方向，1-按车道
        public byte byRes1;
        public NET_ITC_PLATE_RECOG_PARAM struPlateRecog; //牌识参数
        public NET_ITC_TRAFFIC_LIGHT_PARAM struTrafficLight; //交通信号灯参数
        public NET_ITC_LANE_VIDEO_EPOLICE_PARAM[] struLaneParam = new NET_ITC_LANE_VIDEO_EPOLICE_PARAM[MAX_ITC_LANE_NUM]; //单车道参数
        public NET_ITC_LINE struLaneBoundaryLine; //车道边界线（最右边车道的边界线）
        public NET_ITC_LINE struLeftLine; //左转弯分界线
        public NET_ITC_LINE struRightLine; //右转弯分界线
        public NET_ITC_LINE struTopZebraLine; //上部斑马线
        public NET_ITC_LINE struBotZebraLine; //下部斑马线
        public byte[] byRes = new byte[32];
    }

    public static class NET_DVR_CURTRIGGERMODE extends Structure {
        public int dwSize;
        public int dwTriggerType; //触发类型，详见ITC_TRIGGERMODE_TYPE
        public byte[] byRes = new byte[24];
    }

    public static class NET_ITC_VIDEO_TRIGGER_COND extends Structure {
        public int dwSize;
        public int dwChannel;
        public int dwTriggerMode; //视频触发模式类型，详见ITC_TRIGGERMODE_TYPE
        public byte[] byRes = new byte[16];
    }

    public static class NET_ITC_VIDEO_TRIGGER_PARAM_UNION extends Union {
        public int[] uLen = new int[1150];
        public NET_ITC_VIDEO_EPOLICE_PARAM struVideoEP = new NET_ITC_VIDEO_EPOLICE_PARAM(); //视频电警参数
    }

    public static class NET_ITC_VIDEO_TRIGGER_PARAM extends Structure {
        public int dwSize;
        public int dwMode; //触发模式，详见ITC_TRIGGERMODE_TYPE
        public NET_ITC_VIDEO_TRIGGER_PARAM_UNION uVideoTrigger = new NET_ITC_VIDEO_TRIGGER_PARAM_UNION(); //触发模式参数
        public byte[] byRes = new byte[32];
    }

    public static class NET_DVR_CMS_PARAM extends Structure {
        public int dwSize;
        public NET_DVR_IPADDR struAddr = new NET_DVR_IPADDR();                    // 平台服务器IP
        public short wServerPort;                   // 平台服务器侦听端口，
        public byte bySeverProtocolType;            //平台协议类型 1-私有，2-Ehome
        public byte byStatus;                         //设备注册到该平台的状态，1-未注册，2-已注册
        public byte[] sDeviceId = new byte[NAME_LEN/*32*/];     //设备ID，由平台提供
        public byte[] sPassWord = new byte[PASSWD_LEN];  //密码
        /********* IPC5.1.7 新增参数 Begin 2014-03-21***********/
        public byte[] sPlatformEhomeVersion = new byte[NAME_LEN];//平台EHOME协议版本
        /********* IPC5.1.7 新增参数 end 2014-03-21***********/
        public byte byNetWork;                //网络类型：0- 无意义，1-自动，2-有线网络优先，3-有线网络，4-3G网络（无线网络），5-有线网络1，6-有线网络2
        public byte byAddressType;            //0 - 无意义, 1 - ipv4/ipv6地址，2 - 域名
        public byte byProtocolVersion;            //协议版本 0 - 无意义, 1 – v2.0，2 – v4.0,3-v2.6
        public byte byRes1;
        public byte[] sDomainName = new byte[MAX_DOMAIN_NAME/*64*/]; //平台服务器域名，byAddressType为2时有效
        public byte byEnable;      //0-关闭，1-开启
        public byte[] byRes = new byte[139];          // 保留字节
    }

    //设置完全获取出厂值
    public static class NET_DVR_COMPLETE_RESTORE_INFO extends Structure {
        public int dwSize; //结构体长度
        public int dwChannel; //通道号
        public byte[] byRes = new byte[64];
    }

    public static class NET_DVR_STD_ABILITY extends Structure {
        public Pointer lpCondBuffer;    //[in]条件参数(码字格式),例如通道号等.可以为NULL
        public int dwCondSize;        //[in] dwCondSize指向的内存大小
        public Pointer lpOutBuffer;    //[out]输出参数(XML格式),不为NULL
        public int dwOutSize;        //[in] lpOutBuffer指向的内存大小
        public Pointer lpStatusBuffer;    //[out]返回的状态参数(XML格式),获取成功时不会赋值,如果不需要,可以置NULL
        public int dwStatusSize;    //[in] lpStatusBuffer指向的内存大小
        public int dwRetSize;        //[out]获取到的数据长度(lpOutBuffer或者lpStatusBuffer指向的实际数据长度)
        public byte[] byRes = new byte[32];        //保留字节
    }

    public static class NET_DVR_STD_CONFIG extends Structure {
        public Pointer lpCondBuffer;        //[in]条件参数(结构体格式),例如通道号等.可以为NULL
        public int dwCondSize;            //[in] lpCondBuffer指向的内存大小
        public Pointer lpInBuffer;            //[in]输入参数(结构体格式),设置时不为NULL，获取时为NULL
        public int dwInSize;            //[in] lpInBuffer指向的内存大小
        public Pointer lpOutBuffer;        //[out]输出参数(结构体格式),获取时不为NULL,设置时为NULL
        public int dwOutSize;            //[in] lpOutBuffer指向的内存大小
        public Pointer lpStatusBuffer;        //[out]返回的状态参数(XML格式),获取成功时不会赋值,如果不需要,可以置NULL
        public int dwStatusSize;        //[in] lpStatusBuffer指向的内存大小
        public Pointer lpXmlBuffer;    //[in/out]byDataType = 1时有效,xml格式数据
        public int dwXmlSize;      //[in/out]lpXmlBuffer指向的内存大小,获取时同时作为输入和输出参数，获取成功后会修改会实际长度，设置时表示实际长度，而不是整个内存大小
        public byte byDataType;     //[in]输入/输出参数类型,0-使用结构体类型lpInBuffer/lpOutBuffer有效,1-使用XML类型lpXmlBuffer有效
        public byte[] byRes = new byte[23];
    }

    public static final int NET_SDK_MAX_FILE_PATH = 256;//路径长度

    public static class NET_DVR_LOCAL_SDK_PATH extends Structure {
        public byte[] sPath = new byte[NET_SDK_MAX_FILE_PATH];//组件库地址
        public byte[] byRes = new byte[128];
    }

    public static class BYTE_ARRAY extends Structure {
        public byte[] byValue;

        public BYTE_ARRAY(int iLen) {
            byValue = new byte[iLen];
        }
    }

    public static class NET_DVR_JSON_DATA_CFG extends Structure {
        public int dwSize;                        //结构体大小
        public Pointer lpJsonData;                //JSON报文
        public int dwJsonDataSize;                //JSON报文大小
        public Pointer lpPicData;                //图片内容
        public int dwPicDataSize;                //图片内容大小
        public int lpInfraredFacePicBuffer;        //红外人脸图片数据缓存
        public Pointer dwInfraredFacePicSize;    //红外人脸图片数据大小，等于0时，代表无人脸图片数据(当JSON报文为当ResponseStatus（JSON）报文时，该字段无意义；当Inbound Data（JSON）报文中没有infraredFaceURL时，该字段需要带上二进制图片内容）
        public byte[] byRes = new byte[248];
    }

    public static class CallBack_USER extends Structure {
        public byte[] byDeviceID = new byte[16];
        public byte[] byCardNo = new byte[32];
        public byte[] byDevIP = new byte[16];
    }


    /***API函数声明,详细说明见API手册***/
    public static interface FRealDataCallBack_V30 extends StdCallCallback {
        public void invoke(int lRealHandle, int dwDataType,
                           ByteByReference pBuffer, int dwBufSize, Pointer pUser);
    }

    public static interface FMSGCallBack extends StdCallCallback {
        public void invoke(int lCommand, NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser);
    }

    public static interface FMSGCallBack_V31 extends StdCallCallback {
        public boolean invoke(int lCommand, NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser);
    }

    public static interface FMessCallBack extends StdCallCallback {
        public boolean invoke(int lCommand, String sDVRIP, String pBuf, int dwBufLen);
    }

    public static interface FMessCallBack_EX extends StdCallCallback {
        public boolean invoke(int lCommand, int lUserID, String pBuf, int dwBufLen);
    }

    public static interface FMessCallBack_NEW extends StdCallCallback {
        public boolean invoke(int lCommand, String sDVRIP, String pBuf, int dwBufLen, short dwLinkDVRPort);
    }

    public static interface FMessageCallBack extends StdCallCallback {
        public boolean invoke(int lCommand, String sDVRIP, String pBuf, int dwBufLen, int dwUser);
    }

    public static interface FExceptionCallBack extends StdCallCallback {
        public void invoke(int dwType, int lUserID, int lHandle, Pointer pUser);
    }

    public static interface FDrawFun extends StdCallCallback {
        public void invoke(int lRealHandle, W32API.HDC hDc, int dwUser);
    }

    public static interface FStdDataCallBack extends StdCallCallback {
        public void invoke(int lRealHandle, int dwDataType, ByteByReference pBuffer, int dwBufSize, int dwUser);
    }

    public static interface FPlayDataCallBack extends StdCallCallback {
        public void invoke(int lPlayHandle, int dwDataType, ByteByReference pBuffer, int dwBufSize, int dwUser);
    }

    public static interface FPlayESCallBack extends StdCallCallback {
        public void invoke(int lPlayHandle, NET_DVR_PACKET_INFO_EX struPackInfo, Pointer pUser);
    }

    public static interface FVoiceDataCallBack extends StdCallCallback {
        public void invoke(int lVoiceComHandle, Pointer pRecvDataBuffer, int dwBufSize, byte byAudioFlag, int dwUser);
    }

    public static interface FVoiceDataCallBack_V30 extends StdCallCallback {
        public void invoke(int lVoiceComHandle, Pointer pRecvDataBuffer, int dwBufSize, byte byAudioFlag, Pointer pUser);
    }

    public static interface FVoiceDataCallBack_MR extends StdCallCallback {
        public void invoke(int lVoiceComHandle, Pointer pRecvDataBuffer, int dwBufSize, byte byAudioFlag, int dwUser);
    }

    public static interface FVoiceDataCallBack_MR_V30 extends StdCallCallback {
        public void invoke(int lVoiceComHandle, Pointer pRecvDataBuffer, int dwBufSize, byte byAudioFlag, Pointer pUser);
    }

    public static interface FVoiceDataCallBack2 extends StdCallCallback {
        public void invoke(String pRecvDataBuffer, int dwBufSize, Pointer pUser);
    }

    public static interface FSerialDataCallBack extends StdCallCallback {
        public void invoke(int lSerialHandle, String pRecvDataBuffer, int dwBufSize, int dwUser);
    }

    public static interface FRowDataCallBack extends StdCallCallback {
        public void invoke(int lUserID, String sIPAddr, int lRowAmout, String pRecvDataBuffer, int dwBufSize, int dwUser);
    }

    public static interface FColLocalDataCallBack extends StdCallCallback {
        public void invoke(int lUserID, String sIPAddr, int lColumnAmout, String pRecvDataBuffer, int dwBufSize, int dwUser);
    }

    public static interface FColGlobalDataCallBack extends StdCallCallback {
        public void invoke(int lUserID, String sIPAddr, int lColumnAmout, String pRecvDataBuffer, int dwBufSize, int dwUser);
    }

    public static interface FJpegdataCallBack extends StdCallCallback {
        public int invoke(int lCommand, int lUserID, String sDVRIP, String sJpegName, String pJpegBuf, int dwBufLen, int dwUser);
    }

    public static interface FPostMessageCallBack extends StdCallCallback {
        public int invoke(int dwType, int lIndex);
    }

    boolean NET_DVR_Init();

    boolean NET_DVR_Cleanup();

    boolean NET_DVR_SetSDKInitCfg(int enumType, Pointer lpInBuff);

    boolean NET_DVR_SetSDKLocalCfg(int enumType, Pointer lpInBuff);

    boolean NET_DVR_GetSDKLocalCfg(int enumType, Pointer lpOutBuff);

    boolean NET_DVR_SetDVRMessage(int nMessage, int hWnd);

    //NET_DVR_SetDVRMessage的扩展
    boolean NET_DVR_SetExceptionCallBack_V30(int nMessage, int hWnd, FExceptionCallBack fExceptionCallBack, Pointer pUser);

    boolean NET_DVR_SetDVRMessCallBack(FMessCallBack fMessCallBack);

    boolean NET_DVR_SetDVRMessCallBack_EX(FMessCallBack_EX fMessCallBack_EX);

    boolean NET_DVR_SetDVRMessCallBack_NEW(FMessCallBack_NEW fMessCallBack_NEW);

    boolean NET_DVR_SetDVRMessageCallBack(FMessageCallBack fMessageCallBack, int dwUser);

    boolean NET_DVR_SetDVRMessageCallBack_V30(FMSGCallBack fMessageCallBack, Pointer pUser);

    boolean NET_DVR_SetDVRMessageCallBack_V31(FMSGCallBack_V31 fMessageCallBack, Pointer pUser);

    boolean NET_DVR_SetConnectTime(int dwWaitTime, int dwTryTimes);

    boolean NET_DVR_SetReconnect(int dwInterval, boolean bEnableRecon);

    int NET_DVR_GetSDKVersion();

    int NET_DVR_GetSDKBuildVersion();

    int NET_DVR_IsSupport();

    boolean NET_DVR_StartListen(String sLocalIP, short wLocalPort);

    boolean NET_DVR_StopListen();

    int NET_DVR_StartListen_V30(String sLocalIP, short wLocalPort, FMSGCallBack DataCallBack, Pointer pUserData);

    boolean NET_DVR_StopListen_V30(int lListenHandle);

    int NET_DVR_Login(String sDVRIP, short wDVRPort, String sUserName, String sPassword, NET_DVR_DEVICEINFO lpDeviceInfo);

    int NET_DVR_Login_V30(String sDVRIP, short wDVRPort, String sUserName, String sPassword, NET_DVR_DEVICEINFO_V30 lpDeviceInfo);

    int NET_DVR_Login_V40(NET_DVR_USER_LOGIN_INFO pLoginInfo, NET_DVR_DEVICEINFO_V40 lpDeviceInfo);

    boolean NET_DVR_Logout(int lUserID);

    boolean NET_DVR_Logout_V30(int lUserID);

    int NET_DVR_GetLastError();

    String NET_DVR_GetErrorMsg(IntByReference pErrorNo);

    boolean NET_DVR_SetShowMode(int dwShowType, int colorKey);

    boolean NET_DVR_GetDVRIPByResolveSvr(String sServerIP, short wServerPort, String sDVRName, short wDVRNameLen, String sDVRSerialNumber, short wDVRSerialLen, String sGetIP);

    boolean NET_DVR_GetDVRIPByResolveSvr_EX(String sServerIP, short wServerPort, String sDVRName, short wDVRNameLen, String sDVRSerialNumber, short wDVRSerialLen, String sGetIP, IntByReference dwPort);

    //预览相关接口
    int NET_DVR_RealPlay(int lUserID, NET_DVR_CLIENTINFO lpClientInfo);

    int NET_DVR_RealPlay_V30(int lUserID, NET_DVR_CLIENTINFO lpClientInfo, FRealDataCallBack_V30 fRealDataCallBack_V30, Pointer pUser, boolean bBlocked);

    int NET_DVR_RealPlay_V40(int lUserID, NET_DVR_PREVIEWINFO lpPreviewInfo, FRealDataCallBack_V30 fRealDataCallBack_V30, Pointer pUser);

    boolean NET_DVR_StopRealPlay(int lRealHandle);

    boolean NET_DVR_RigisterDrawFun(int lRealHandle, FDrawFun fDrawFun, int dwUser);

    boolean NET_DVR_SetPlayerBufNumber(int lRealHandle, int dwBufNum);

    boolean NET_DVR_ThrowBFrame(int lRealHandle, int dwNum);

    boolean NET_DVR_SetAudioMode(int dwMode);

    boolean NET_DVR_OpenSound(int lRealHandle);

    boolean NET_DVR_CloseSound();

    boolean NET_DVR_OpenSoundShare(int lRealHandle);

    boolean NET_DVR_CloseSoundShare(int lRealHandle);

    boolean NET_DVR_Volume(int lRealHandle, short wVolume);

    boolean NET_DVR_SaveRealData(int lRealHandle, String sFileName);

    boolean NET_DVR_StopSaveRealData(int lRealHandle);

    boolean NET_DVR_SetRealDataCallBack(int lRealHandle, FRowDataCallBack fRealDataCallBack, int dwUser);

    boolean NET_DVR_SetStandardDataCallBack(int lRealHandle, FStdDataCallBack fStdDataCallBack, int dwUser);

    boolean NET_DVR_CapturePicture(int lRealHandle, String sPicFileName);//bmp

    //动态生成I帧
    boolean NET_DVR_MakeKeyFrame(int lUserID, int lChannel);//主码流

    boolean NET_DVR_MakeKeyFrameSub(int lUserID, int lChannel);//子码流

    //云台控制相关接口
    boolean NET_DVR_PTZControl(int lRealHandle, int dwPTZCommand, int dwStop);

    boolean NET_DVR_PTZControl_Other(int lUserID, int lChannel, int dwPTZCommand, int dwStop);

    boolean NET_DVR_TransPTZ(int lRealHandle, String pPTZCodeBuf, int dwBufSize);

    boolean NET_DVR_TransPTZ_Other(int lUserID, int lChannel, String pPTZCodeBuf, int dwBufSize);

    boolean NET_DVR_PTZPreset(int lRealHandle, int dwPTZPresetCmd, int dwPresetIndex);

    boolean NET_DVR_PTZPreset_Other(int lUserID, int lChannel, int dwPTZPresetCmd, int dwPresetIndex);

    boolean NET_DVR_TransPTZ_EX(int lRealHandle, String pPTZCodeBuf, int dwBufSize);

    boolean NET_DVR_PTZControl_EX(int lRealHandle, int dwPTZCommand, int dwStop);

    boolean NET_DVR_PTZPreset_EX(int lRealHandle, int dwPTZPresetCmd, int dwPresetIndex);

    boolean NET_DVR_PTZCruise(int lRealHandle, int dwPTZCruiseCmd, byte byCruiseRoute, byte byCruisePoint, short wInput);

    boolean NET_DVR_PTZCruise_Other(int lUserID, int lChannel, int dwPTZCruiseCmd, byte byCruiseRoute, byte byCruisePoint, short wInput);

    boolean NET_DVR_PTZCruise_EX(int lRealHandle, int dwPTZCruiseCmd, byte byCruiseRoute, byte byCruisePoint, short wInput);

    boolean NET_DVR_PTZTrack(int lRealHandle, int dwPTZTrackCmd);

    boolean NET_DVR_PTZTrack_Other(int lUserID, int lChannel, int dwPTZTrackCmd);

    boolean NET_DVR_PTZTrack_EX(int lRealHandle, int dwPTZTrackCmd);

    boolean NET_DVR_PTZControlWithSpeed(int lRealHandle, int dwPTZCommand, int dwStop, int dwSpeed);

    boolean NET_DVR_PTZControlWithSpeed_Other(int lUserID, int lChannel, int dwPTZCommand, int dwStop, int dwSpeed);

    boolean NET_DVR_PTZControlWithSpeed_EX(int lRealHandle, int dwPTZCommand, int dwStop, int dwSpeed);

    boolean NET_DVR_GetPTZCruise(int lUserID, int lChannel, int lCruiseRoute, NET_DVR_CRUISE_RET lpCruiseRet);

    boolean NET_DVR_PTZMltTrack(int lRealHandle, int dwPTZTrackCmd, int dwTrackIndex);

    boolean NET_DVR_PTZMltTrack_Other(int lUserID, int lChannel, int dwPTZTrackCmd, int dwTrackIndex);

    boolean NET_DVR_PTZMltTrack_EX(int lRealHandle, int dwPTZTrackCmd, int dwTrackIndex);

    //文件查找与回放
    int NET_DVR_FindFile(int lUserID, int lChannel, int dwFileType, NET_DVR_TIME lpStartTime, NET_DVR_TIME lpStopTime);

    int NET_DVR_FindNextFile(int lFindHandle, NET_DVR_FIND_DATA lpFindData);

    boolean NET_DVR_FindClose(int lFindHandle);

    int NET_DVR_FindNextFile_V30(int lFindHandle, NET_DVR_FINDDATA_V30 lpFindData);

    int NET_DVR_FindFile_V30(int lUserID, NET_DVR_FILECOND pFindCond);

    int NET_DVR_FindFile_V40(int lUserID, NET_DVR_FILECOND_V40 pFindCond);

    int NET_DVR_FindNextFile_V40(int lFindHandle, NET_DVR_FINDDATA_V40 lpFindData);

    int NET_DVR_FindFile_V50(int lUserID, NET_DVR_FILECOND_V50 pFindCond);

    int NET_DVR_FindNextFile_V50(int lFindHandle, NET_DVR_FINDDATA_V50 lpFindData);

    boolean NET_DVR_FindClose_V30(int lFindHandle);

    //按事件查找
    int NET_DVR_FindFileByEvent(int lUserID, NET_DVR_SEARCH_EVENT_PARAM lpSearchEventParam);

    int NET_DVR_FindNextEvent(int lSearchHandle, NET_DVR_SEARCH_EVENT_RET lpSearchEventRet);

    int NET_DVR_FindFileByEvent_V50(int lUserID, NET_DVR_SEARCH_EVENT_PARAM_V50 lpSearchEventParam);

    int NET_DVR_FindNextEvent_V50(int lFindHandle, NET_DVR_SEARCH_EVENT_RET_V50 lpSearchEventRet);

    //2007-04-16增加查询结果带卡号的文件查找
    int NET_DVR_FindNextFile_Card(int lFindHandle, NET_DVR_FINDDATA_CARD lpFindData);

    int NET_DVR_FindFile_Card(int lUserID, int lChannel, int dwFileType, NET_DVR_TIME lpStartTime, NET_DVR_TIME lpStopTime);

    boolean NET_DVR_LockFileByName(int lUserID, String sLockFileName);

    boolean NET_DVR_UnlockFileByName(int lUserID, String sUnlockFileName);

    int NET_DVR_PlayBackByName(int lUserID, String sPlayBackFileName, HWND hWnd);

    int NET_DVR_PlayBackByTime(int lUserID, int lChannel, NET_DVR_TIME lpStartTime, NET_DVR_TIME lpStopTime, HWND hWnd);

    int NET_DVR_PlayBackByTime_V40(int lUserID, NET_DVR_VOD_PARA pVodPara);

    boolean NET_DVR_PlayBackControl(int lPlayHandle, int dwControlCode, int dwInValue, IntByReference LPOutValue);

    boolean NET_DVR_PlayBackControl_V40(int lPlayHandle, int dwControlCode, Pointer lpInBuffer, int dwInLen, Pointer lpOutBuffer, IntByReference lpOutLen);

    boolean NET_DVR_StopPlayBack(int lPlayHandle);

    boolean NET_DVR_SetPlayDataCallBack(int lPlayHandle, FPlayDataCallBack fPlayDataCallBack, int dwUser);

    boolean NET_DVR_SetPlayBackESCallBack(int lPlayHandle, FPlayESCallBack fPlayESCallBack, Pointer pUser);

    boolean NET_DVR_PlayBackSaveData(int lPlayHandle, String sFileName);

    boolean NET_DVR_StopPlayBackSave(int lPlayHandle);

    boolean NET_DVR_GetPlayBackOsdTime(int lPlayHandle, NET_DVR_TIME lpOsdTime);

    boolean NET_DVR_PlayBackCaptureFile(int lPlayHandle, String sFileName);

    int NET_DVR_GetFileByName(int lUserID, String sDVRFileName, byte[] sSavedFileName);

    int NET_DVR_GetFileByTime(int lUserID, int lChannel, NET_DVR_TIME lpStartTime, NET_DVR_TIME lpStopTime, String sSavedFileName);

    int NET_DVR_GetFileByTime_V40(int lUserID, byte[] sSavedFileName, NET_DVR_PLAYCOND pDownloadCond);

    boolean NET_DVR_StopGetFile(int lFileHandle);

    int NET_DVR_GetDownloadPos(int lFileHandle);

    int NET_DVR_GetPlayBackPos(int lPlayHandle);

    //图片查找
    int NET_DVR_FindPicture(int lUserID, NET_DVR_FIND_PICTURE_PARAM pFindParam);

    int NET_DVR_FindNextPicture_V50(int lFindHandle, NET_DVR_FIND_PICTURE_V50 lpFindData);

    boolean NET_DVR_CloseFindPicture(int lFindHandle);

    boolean NET_DVR_GetPicture_V50(int lUserID, NET_DVR_PIC_PARAM lpPicParam);

    //升级
    int NET_DVR_Upgrade(int lUserID, String sFileName);

    int NET_DVR_GetUpgradeState(int lUpgradeHandle);

    int NET_DVR_GetUpgradeProgress(int lUpgradeHandle);

    boolean NET_DVR_CloseUpgradeHandle(int lUpgradeHandle);

    boolean NET_DVR_SetNetworkEnvironment(int dwEnvironmentLevel);

    //远程格式化硬盘
    int NET_DVR_FormatDisk(int lUserID, int lDiskNumber);

    boolean NET_DVR_GetFormatProgress(int lFormatHandle, IntByReference pCurrentFormatDisk, IntByReference pCurrentDiskPos, IntByReference pFormatStatic);

    boolean NET_DVR_CloseFormatHandle(int lFormatHandle);

    //报警
    int NET_DVR_SetupAlarmChan(int lUserID);

    boolean NET_DVR_CloseAlarmChan(int lAlarmHandle);

    int NET_DVR_SetupAlarmChan_V30(int lUserID);

    int NET_DVR_SetupAlarmChan_V41(int lUserID, NET_DVR_SETUPALARM_PARAM lpSetupParam);

    boolean NET_DVR_CloseAlarmChan_V30(int lAlarmHandle);

    //语音对讲
    int NET_DVR_StartVoiceCom(int lUserID, FVoiceDataCallBack fVoiceDataCallBack, int dwUser);

    int NET_DVR_StartVoiceCom_V30(int lUserID, int dwVoiceChan, boolean bNeedCBNoEncData, FVoiceDataCallBack_V30 fVoiceDataCallBack, Pointer pUser);

    boolean NET_DVR_SetVoiceComClientVolume(int lVoiceComHandle, short wVolume);

    boolean NET_DVR_StopVoiceCom(int lVoiceComHandle);

    //语音转发
    int NET_DVR_StartVoiceCom_MR(int lUserID, FVoiceDataCallBack_MR fVoiceDataCallBack, int dwUser);

    int NET_DVR_StartVoiceCom_MR_V30(int lUserID, int dwVoiceChan, FVoiceDataCallBack_MR_V30 fVoiceDataCallBack, Pointer pUser);

    boolean NET_DVR_VoiceComSendData(int lVoiceComHandle, byte[] pSendBuf, int dwBufSize);

    //语音广播
    boolean NET_DVR_ClientAudioStart();

    boolean NET_DVR_ClientAudioStart_V30(FVoiceDataCallBack2 fVoiceDataCallBack2, Pointer pUser);

    boolean NET_DVR_ClientAudioStop();

    boolean NET_DVR_AddDVR(int lUserID);

    int NET_DVR_AddDVR_V30(int lUserID, int dwVoiceChan);

    boolean NET_DVR_DelDVR(int lUserID);

    boolean NET_DVR_DelDVR_V30(int lVoiceHandle);

    ////////////////////////////////////////////////////////////
//透明通道设置
    int NET_DVR_SerialStart(int lUserID, int lSerialPort, FSerialDataCallBack fSerialDataCallBack, int dwUser);

    public static interface FSerialDataCallBack_V40 extends StdCallCallback {
        public void invoke(int lSerialHandle, int lCHannel, byte[] pRecvDataBuffer, int dwBufSize, Pointer pUser);
    }

    int NET_DVR_SerialStart_V40(int lUserID, Pointer lpInBuffer, int dwInBufferSize, FSerialDataCallBack_V40 fSerialDataCallBack_V40, Pointer pUser);

    //485作为透明通道时，需要指明通道号，因为不同通道号485的设置可以不同(比如波特率)
    boolean NET_DVR_SerialSend(int lSerialHandle, int lChannel, byte[] pSendBuf, int dwBufSize);

    boolean NET_DVR_SerialStop(int lSerialHandle);

    boolean NET_DVR_SendTo232Port(int lUserID, String pSendBuf, int dwBufSize);

    boolean NET_DVR_SendToSerialPort(int lUserID, int dwSerialPort, int dwSerialIndex, String pSendBuf, int dwBufSize);

    //Win64、Linux32、Linux64
    Pointer NET_DVR_InitG722Encoder(NET_DVR_AUDIOENC_INFO enc_info);

    boolean NET_DVR_EncodeG722Frame(Pointer handle, NET_DVR_AUDIOENC_PROCESS_PARAM param);

    void NET_DVR_ReleaseG722Encoder(Pointer pEncodeHandle);

    Pointer NET_DVR_InitG722Decoder();

    boolean NET_DVR_DecodeG722Frame(Pointer handle, NET_DVR_AUDIODEC_PROCESS_PARAM param);

    void NET_DVR_ReleaseG722Decoder(Pointer pDecHandle);

    //G711: Win64、Linux32、Linux64
    Pointer NET_DVR_InitG711Encoder(Pointer enc_info); //NET_DVR_AUDIOENC_INFO

    boolean NET_DVR_EncodeG711Frame(Pointer handle, NET_DVR_AUDIOENC_PROCESS_PARAM p_enc_proc_param);

    boolean NET_DVR_ReleaseG711Encoder(Pointer pEncodeHandle);

    Pointer NET_DVR_InitG711Decoder();

    boolean NET_DVR_DecodeG711Frame(Pointer handle, NET_DVR_AUDIODEC_PROCESS_PARAM p_dec_proc_param);

    boolean NET_DVR_ReleaseG711Decoder(Pointer pDecHandle);

    //远程控制本地显示
    boolean NET_DVR_ClickKey(int lUserID, int lKeyIndex);

    //远程控制设备端手动录像
    boolean NET_DVR_StartDVRRecord(int lUserID, int lChannel, int lRecordType);

    boolean NET_DVR_StopDVRRecord(int lUserID, int lChannel);

    //解码卡
    boolean NET_DVR_InitDevice_Card(IntByReference pDeviceTotalChan);

    boolean NET_DVR_ReleaseDevice_Card();

    boolean NET_DVR_InitDDraw_Card(int hParent, int colorKey);

    boolean NET_DVR_ReleaseDDraw_Card();

    int NET_DVR_RealPlay_Card(int lUserID, NET_DVR_CARDINFO lpCardInfo, int lChannelNum);

    boolean NET_DVR_ResetPara_Card(int lRealHandle, NET_DVR_DISPLAY_PARA lpDisplayPara);

    boolean NET_DVR_RefreshSurface_Card();

    boolean NET_DVR_ClearSurface_Card();

    boolean NET_DVR_RestoreSurface_Card();

    boolean NET_DVR_OpenSound_Card(int lRealHandle);

    boolean NET_DVR_CloseSound_Card(int lRealHandle);

    boolean NET_DVR_SetVolume_Card(int lRealHandle, short wVolume);

    boolean NET_DVR_AudioPreview_Card(int lRealHandle, boolean bEnable);

    int NET_DVR_GetCardLastError_Card();

    Pointer NET_DVR_GetChanHandle_Card(int lRealHandle);

    boolean NET_DVR_CapturePicture_Card(int lRealHandle, String sPicFileName);

    //获取解码卡序列号此接口无效，改用GetBoardDetail接口获得(2005-12-08支持)
    boolean NET_DVR_GetSerialNum_Card(int lChannelNum, IntByReference pDeviceSerialNo);

    //日志
    int NET_DVR_FindDVRLog(int lUserID, int lSelectMode, int dwMajorType, int dwMinorType, NET_DVR_TIME lpStartTime, NET_DVR_TIME lpStopTime);

    int NET_DVR_FindNextLog(int lLogHandle, NET_DVR_LOG lpLogData);

    boolean NET_DVR_FindLogClose(int lLogHandle);

    int NET_DVR_FindDVRLog_V30(int lUserID, int lSelectMode, int dwMajorType, int dwMinorType, NET_DVR_TIME lpStartTime, NET_DVR_TIME lpStopTime, boolean bOnlySmart);

    int NET_DVR_FindNextLog_V30(int lLogHandle, NET_DVR_LOG_V30 lpLogData);

    boolean NET_DVR_FindLogClose_V30(int lLogHandle);

    //截止2004年8月5日,共113个接口
//ATM DVR
    int NET_DVR_FindFileByCard(int lUserID, int lChannel, int dwFileType, int nFindType, String sCardNumber, NET_DVR_TIME lpStartTime, NET_DVR_TIME lpStopTime);
//截止2004年10月5日,共116个接口

    //2005-09-15
    boolean NET_DVR_CaptureJPEGPicture(int lUserID, int lChannel, NET_DVR_JPEGPARA lpJpegPara, byte[] sPicFileName);

    //JPEG抓图到内存
    boolean NET_DVR_CaptureJPEGPicture_NEW(int lUserID, int lChannel, NET_DVR_JPEGPARA lpJpegPara, byte[] sJpegPicBuffer, int dwPicSize, IntByReference lpSizeReturned);


    //2006-02-16
    int NET_DVR_GetRealPlayerIndex(int lRealHandle);

    int NET_DVR_GetPlayBackPlayerIndex(int lPlayHandle);

    //2006-08-28 704-640 缩放配置
    boolean NET_DVR_SetScaleCFG(int lUserID, int dwScale);

    boolean NET_DVR_GetScaleCFG(int lUserID, IntByReference lpOutScale);

    boolean NET_DVR_SetScaleCFG_V30(int lUserID, NET_DVR_SCALECFG pScalecfg);

    boolean NET_DVR_GetScaleCFG_V30(int lUserID, NET_DVR_SCALECFG pScalecfg);

    //2006-08-28 ATM机端口设置
    boolean NET_DVR_SetATMPortCFG(int lUserID, short wATMPort);

    boolean NET_DVR_GetATMPortCFG(int lUserID, ShortByReference LPOutATMPort);

    //2006-11-10 支持显卡辅助输出
    boolean NET_DVR_InitDDrawDevice();

    boolean NET_DVR_ReleaseDDrawDevice();

    int NET_DVR_GetDDrawDeviceTotalNums();

    boolean NET_DVR_SetDDrawDevice(int lPlayPort, int nDeviceNum);

    boolean NET_DVR_PTZSelZoomIn(int lRealHandle, NET_DVR_POINT_FRAME pStruPointFrame);

    boolean NET_DVR_PTZSelZoomIn_EX(int lUserID, int lChannel, NET_DVR_POINT_FRAME pStruPointFrame);

    boolean NET_DVR_FocusOnePush(int lUserID, int lChannel);

    //解码设备DS-6001D/DS-6001F
    boolean NET_DVR_StartDecode(int lUserID, int lChannel, NET_DVR_DECODERINFO lpDecoderinfo);

    boolean NET_DVR_StopDecode(int lUserID, int lChannel);

    boolean NET_DVR_GetDecoderState(int lUserID, int lChannel, NET_DVR_DECODERSTATE lpDecoderState);

    //2005-08-01
    boolean NET_DVR_SetDecInfo(int lUserID, int lChannel, NET_DVR_DECCFG lpDecoderinfo);

    boolean NET_DVR_GetDecInfo(int lUserID, int lChannel, NET_DVR_DECCFG lpDecoderinfo);

    boolean NET_DVR_SetDecTransPort(int lUserID, NET_DVR_PORTCFG lpTransPort);

    boolean NET_DVR_GetDecTransPort(int lUserID, NET_DVR_PORTCFG lpTransPort);

    boolean NET_DVR_DecPlayBackCtrl(int lUserID, int lChannel, int dwControlCode, int dwInValue, IntByReference LPOutValue, NET_DVR_PLAYREMOTEFILE lpRemoteFileInfo);

    boolean NET_DVR_StartDecSpecialCon(int lUserID, int lChannel, NET_DVR_DECCHANINFO lpDecChanInfo);

    boolean NET_DVR_StopDecSpecialCon(int lUserID, int lChannel, NET_DVR_DECCHANINFO lpDecChanInfo);

    boolean NET_DVR_DecCtrlDec(int lUserID, int lChannel, int dwControlCode);

    boolean NET_DVR_DecCtrlScreen(int lUserID, int lChannel, int dwControl);

    boolean NET_DVR_GetDecCurLinkStatus(int lUserID, int lChannel, NET_DVR_DECSTATUS lpDecStatus);

    //多路解码器
//2007-11-30 V211支持以下接口 //11
    boolean NET_DVR_MatrixStartDynamic(int lUserID, int dwDecChanNum, NET_DVR_MATRIX_DYNAMIC_DEC lpDynamicInfo);

    boolean NET_DVR_MatrixStopDynamic(int lUserID, int dwDecChanNum);

    boolean NET_DVR_MatrixGetDecChanInfo(int lUserID, int dwDecChanNum, NET_DVR_MATRIX_DEC_CHAN_INFO lpInter);

    boolean NET_DVR_MatrixSetLoopDecChanInfo(int lUserID, int dwDecChanNum, NET_DVR_MATRIX_LOOP_DECINFO lpInter);

    boolean NET_DVR_MatrixGetLoopDecChanInfo(int lUserID, int dwDecChanNum, NET_DVR_MATRIX_LOOP_DECINFO lpInter);

    boolean NET_DVR_MatrixSetLoopDecChanEnable(int lUserID, int dwDecChanNum, int dwEnable);

    boolean NET_DVR_MatrixGetLoopDecChanEnable(int lUserID, int dwDecChanNum, IntByReference lpdwEnable);

    boolean NET_DVR_MatrixGetLoopDecEnable(int lUserID, IntByReference lpdwEnable);

    boolean NET_DVR_MatrixSetDecChanEnable(int lUserID, int dwDecChanNum, int dwEnable);

    boolean NET_DVR_MatrixGetDecChanEnable(int lUserID, int dwDecChanNum, IntByReference lpdwEnable);

    boolean NET_DVR_MatrixGetDecChanStatus(int lUserID, int dwDecChanNum, NET_DVR_MATRIX_DEC_CHAN_STATUS lpInter);

    boolean NET_DVR_MatrixStartDynamic_V41(int lUserID, int dwDecChanNum, NET_DVR_PU_STREAM_CFG_V41 lpDynamicInfo);

    boolean NET_DVR_MatrixGetLoopDecChanInfo_V41(int lUserID, int dwDecChanNum, NET_DVR_MATRIX_LOOP_DECINFO_V41 lpOuter);

    boolean NET_DVR_MatrixSetLoopDecChanInfo_V41(int lUserID, int dwDecChanNum, NET_DVR_MATRIX_LOOP_DECINFO_V41 lpInter);

    //2007-12-22 增加支持接口 //18
    boolean NET_DVR_MatrixSetTranInfo(int lUserID, NET_DVR_MATRIX_TRAN_CHAN_CONFIG lpTranInfo);

    boolean NET_DVR_MatrixGetTranInfo(int lUserID, NET_DVR_MATRIX_TRAN_CHAN_CONFIG lpTranInfo);

    boolean NET_DVR_MatrixSetRemotePlay(int lUserID, int dwDecChanNum, NET_DVR_MATRIX_DEC_REMOTE_PLAY lpInter);

    boolean NET_DVR_MatrixSetRemotePlayControl(int lUserID, int dwDecChanNum, int dwControlCode, int dwInValue, IntByReference LPOutValue);

    boolean NET_DVR_MatrixGetRemotePlayStatus(int lUserID, int dwDecChanNum, NET_DVR_MATRIX_DEC_REMOTE_PLAY_STATUS lpOuter);

    //end
    boolean NET_DVR_RefreshPlay(int lPlayHandle);

    //恢复默认值
    boolean NET_DVR_RestoreConfig(int lUserID);

    //保存参数
    boolean NET_DVR_SaveConfig(int lUserID);

    //重启
    boolean NET_DVR_RebootDVR(int lUserID);

    //关闭DVR
    boolean NET_DVR_ShutDownDVR(int lUserID);

    //参数配置 begin
    boolean NET_DVR_GetDeviceConfig(int lUserID, int dwCommand, int dwCount, Pointer lpInBuffer, int dwInBufferSize, Pointer lpStatusList, Pointer lpOutBuffer, int dwOutBufferSize);

    boolean NET_DVR_SetDeviceConfig(int lUserID, int dwCommand, int dwCount, Pointer lpInBuffer, int dwInBufferSize, Pointer lpStatusList, Pointer lpInParamBuffer, int dwInParamBufferSize);

    boolean NET_DVR_SetDeviceConfigEx(int lUserID, int dwCommand, int dwCount, NET_DVR_IN_PARAM lpInParam, NET_DVR_OUT_PARAM lpOutParam);

    boolean NET_DVR_GetDVRConfig(int lUserID, int dwCommand, int lChannel, Pointer lpOutBuffer, int dwOutBufferSize, IntByReference lpBytesReturned);

    boolean NET_DVR_SetDVRConfig(int lUserID, int dwCommand, int lChannel, Pointer lpInBuffer, int dwInBufferSize);

    boolean NET_DVR_GetSTDConfig(int lUserID, int dwCommand, NET_DVR_STD_CONFIG lpConfigParam);

    boolean NET_DVR_SetSTDConfig(int lUserID, int dwCommand, NET_DVR_STD_CONFIG lpConfigParam);

    boolean NET_DVR_GetDVRWorkState_V30(int lUserID, NET_DVR_WORKSTATE_V30 lpWorkState);

    boolean NET_DVR_GetDVRWorkState(int lUserID, NET_DVR_WORKSTATE lpWorkState);

    boolean NET_DVR_SetVideoEffect(int lUserID, int lChannel, int dwBrightValue, int dwContrastValue, int dwSaturationValue, int dwHueValue);

    boolean NET_DVR_GetVideoEffect(int lUserID, int lChannel, IntByReference pBrightValue, IntByReference pContrastValue, IntByReference pSaturationValue, IntByReference pHueValue);

    boolean NET_DVR_ClientGetframeformat(int lUserID, NET_DVR_FRAMEFORMAT lpFrameFormat);

    boolean NET_DVR_ClientSetframeformat(int lUserID, NET_DVR_FRAMEFORMAT lpFrameFormat);

    boolean NET_DVR_ClientGetframeformat_V30(int lUserID, NET_DVR_FRAMEFORMAT_V30 lpFrameFormat);

    boolean NET_DVR_ClientSetframeformat_V30(int lUserID, NET_DVR_FRAMEFORMAT_V30 lpFrameFormat);

    boolean NET_DVR_GetAlarmOut_V30(int lUserID, NET_DVR_ALARMOUTSTATUS_V30 lpAlarmOutState);

    boolean NET_DVR_GetAlarmOut(int lUserID, NET_DVR_ALARMOUTSTATUS lpAlarmOutState);

    boolean NET_DVR_SetAlarmOut(int lUserID, int lAlarmOutPort, int lAlarmOutStatic);

    //视频参数调节
    boolean NET_DVR_ClientSetVideoEffect(int lRealHandle, int dwBrightValue, int dwContrastValue, int dwSaturationValue, int dwHueValue);

    boolean NET_DVR_ClientGetVideoEffect(int lRealHandle, IntByReference pBrightValue, IntByReference pContrastValue, IntByReference pSaturationValue, IntByReference pHueValue);

    //配置文件
    boolean NET_DVR_GetConfigFile(int lUserID, String sFileName);

    boolean NET_DVR_SetConfigFile(int lUserID, String sFileName);

    boolean NET_DVR_GetConfigFile_V30(int lUserID, String sOutBuffer, int dwOutSize, IntByReference pReturnSize);

    boolean NET_DVR_GetConfigFile_EX(int lUserID, String sOutBuffer, int dwOutSize);

    boolean NET_DVR_SetConfigFile_EX(int lUserID, String sInBuffer, int dwInSize);

    //启用日志文件写入接口
    boolean NET_DVR_SetLogToFile(int bLogEnable, String strLogDir, boolean bAutoDel);

    boolean NET_DVR_GetSDKState(NET_DVR_SDKSTATE pSDKState);

    boolean NET_DVR_GetSDKAbility(NET_DVR_SDKABL pSDKAbl);

    boolean NET_DVR_GetPTZProtocol(int lUserID, NET_DVR_PTZCFG pPtzcfg);

    //前面板锁定
    boolean NET_DVR_LockPanel(int lUserID);

    boolean NET_DVR_UnLockPanel(int lUserID);

    boolean NET_DVR_SetRtspConfig(int lUserID, int dwCommand, NET_DVR_RTSPCFG lpInBuffer, int dwInBufferSize);

    boolean NET_DVR_GetRtspConfig(int lUserID, int dwCommand, NET_DVR_RTSPCFG lpOutBuffer, int dwOutBufferSize);

    boolean NET_DVR_ContinuousShoot(int lUserID, NET_DVR_SNAPCFG lpInter);

    boolean NET_DVR_ManualSnap(int lUserID, NET_DVR_MANUALSNAP lpInter, NET_DVR_PLATE_RESULT lpOuter);

    public static interface FRemoteConfigCallBack extends StdCallCallback {
        public void invoke(int dwType, Pointer lpBuffer, int dwBufLen, Pointer pUserData);
    }

    int NET_DVR_StartRemoteConfig(int lUserID, int dwCommand, Pointer lpInBuffer, int dwInBufferLen, FRemoteConfigCallBack cbStateCallBack, Pointer pUserData);

    boolean NET_DVR_SendRemoteConfig(int lHandle, int dwDataType, Pointer pSendBuf, int dwBufSize);

    int NET_DVR_GetNextRemoteConfig(int lHandle, Pointer lpOutBuff, int dwOutBuffSize);

    int NET_DVR_SendWithRecvRemoteConfig(int lHandle, Pointer lpInBuff, int dwInBuffSize, Pointer lpOutBuff, int dwOutBuffSize, IntByReference dwOutDataLen);

    boolean NET_DVR_StopRemoteConfig(int lHandle);

    boolean NET_DVR_RemoteControl(int lUserID, int dwCommand, Pointer lpInBuffer, int dwInBufferSize);

    boolean NET_DVR_STDXMLConfig(int lUserID, NET_DVR_XML_CONFIG_INPUT lpInputParam, NET_DVR_XML_CONFIG_OUTPUT lpOutputParam);

    boolean NET_DVR_GetSTDAbility(int lUserID, int dwAbilityType, NET_DVR_STD_ABILITY lpAbilityParam);

    boolean NET_DVR_GetDeviceAbility(int lUserID, int dwAbilityType, Pointer pInBuf, int dwInLength, Pointer pOutBuf, int dwOutLength);

    boolean NET_DVR_ControlGateway(int lUserID, int lGatewayIndex, int dwStaic);

    boolean NET_DVR_InquestStartCDW_V30(int lUserID, NET_DVR_INQUEST_ROOM lpInquestRoom, boolean bNotBurn);

    boolean NET_DVR_InquestStopCDW_V30(int lUserID, NET_DVR_INQUEST_ROOM lpInquestRoom, boolean bCancelWrite);

    boolean NET_DVR_GetArrayList(int lUserID, NET_DVR_ARRAY_LIST lpArrayList);

    int NET_DVR_InquestResumeEvent(int lUserID, NET_DVR_INQUEST_RESUME_EVENT lpResumeEvent);

    boolean NET_DVR_InquestGetResumeProgress(int lHandle, IntByReference pState);

    boolean NET_DVR_InquestStopResume(int lHandle);

    boolean NET_DVR_GetLocalIP(byte[] strIP, IntByReference pValidNum, boolean pEnableBind);

    boolean NET_DVR_SetValidIP(int dwIPIndex, boolean bEnableBind);

    boolean NET_DVR_AlarmHostAssistantControl(int lUserID, int dwType, int dwNumber, int dwCmdParam);

    boolean NET_DVR_GetPlanList(int lUserID, int dwDevNum, NET_DVR_PLAN_LIST lpPlanList);

    int NET_DVR_UploadFile_V40(int lUserID, int dwUploadType, Pointer lpInBuffer, int dwInBufferSize, String sFileName, Pointer lpOutBuffer, int dwOutBufferSize);

    int NET_DVR_GetUploadState(int lUploadHandle, Pointer pProgress);

    boolean NET_DVR_UploadClose(int lUploadHandle);

    //gps相关结构定义
    public static class TimeSegParam extends Structure {
        //GPS数据查找起始时间
        public NET_DVR_TIME struBeginTime;
        //GPS数据查找结束时间
        public NET_DVR_TIME struEndTime;
        //GPS点时间间隔，单位：秒
        public int dwInterval;
        //保留
        public byte[] byRes = new byte[76];
    }

    //按时间点查询
    public static class TimePointParam extends Structure {
        //GPS数据查找时间点
        public NET_DVR_TIME struTimePoint;
        //保留
        public byte[] byRes = new byte[104];
    }

    public static class GpsDataParamUion extends Union {
        //按时间段查询
        public TimeSegParam timeSeg = new TimeSegParam();
        //按时间点查询
        public TimePointParam timePoint = new TimePointParam();
    }

    //gps查询参数定义
    public static class NET_DVR_GET_GPS_DATA_PARAM extends Structure {
        //查找方式：0- 按时间段查找GPS数据，1- 按时间点查找GPS数据
        public int dwCmdType;
        public GpsDataParamUion gpsDataParam;

        public void read() {
            super.read();
            switch (dwCmdType) {
                case 0:
                    gpsDataParam.setType(TimeSegParam.class);
                    break;
                case 1:
                    gpsDataParam.setType(TimePointParam.class);
                    break;
                default:
                    break;
            }
            gpsDataParam.read();
        }

        public void write() {
            super.write();
            gpsDataParam.write();
        }
    }

    //gps数据结构定义
    public static class NET_DVR_GPS_INFO extends Structure {
        public byte[] byDirection = new byte[2];
        public byte bySvs;
        public byte byLocateMode;
        public short wHDOP;
        public short wHeight;
        public int dwLatitude;
        public int dwLongitude;
        public int dwVehicleSpeed;
        public int dwVehicleDirection;
        public byte[] byRes = new byte[8];
    }

    //gps返回数据结构定义
    public static class NET_DVR_GPS_DATA extends Structure {
        public NET_DVR_GPS_INFO struGPSInfo;
        public NET_DVR_TIME struTime;
        public byte[] byRes = new byte[12];
    }

    public static interface fGPSDataCallback extends StdCallCallback {
        public void invoke(int nHandle, int dwState, Pointer lpBuffer, int dwBufLen, Pointer pUser);
    }

    int NET_DVR_GetVehicleGpsInfo(int lUserID, NET_DVR_GET_GPS_DATA_PARAM lpGPSDataParam, fGPSDataCallback cbGPSDataCallBack, Pointer pUser);
}

