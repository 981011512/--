package com.cf.forward.dh.common;

import com.cf.forward.dh.lib.LastError;

/**
 * 登录设备设备错误状态
 */
public class ErrorCode {

	/**
	 * 登录设备设备错误状态中英文
	 * @param err 接口CLIENT_GetLastError返回, error code: (0x80000000|" + (LoginModule.netsdk.CLIENT_GetLastError() & 0x7fffffff) +")
	 * @return
	 */
	public static String getErrorCode(int err) {
		String msg = "";
		switch(err) {
		case LastError.NET_NOERROR:  // 0  没有错误
			msg = Res.string().getBundle().getString("NET_ERROR"); 
			break;
		case LastError.NET_ERROR:  // -1  未知错误
			msg = Res.string().getBundle().getString("NET_ERROR"); 
			break;
		case LastError.NET_SYSTEM_ERROR: // (0x80000000|1) Windows系统出错
			msg = Res.string().getBundle().getString("NET_SYSTEM_ERROR"); 
			break;
		case LastError.NET_NETWORK_ERROR: // (0x80000000|2) 网络错误，可能是因为网络超时
			msg = Res.string().getBundle().getString("NET_NETWORK_ERROR"); 
			break;
		case LastError.NET_DEV_VER_NOMATCH: // (0x80000000|3) 设备协议不匹配
			msg = Res.string().getBundle().getString("NET_DEV_VER_NOMATCH"); 
			break;
		case LastError.NET_INVALID_HANDLE: // (0x80000000|4) 句柄无效
			msg = Res.string().getBundle().getString("NET_INVALID_HANDLE"); 
			break;
		case LastError.NET_OPEN_CHANNEL_ERROR: // (0x80000000|5) 打开通道失败
			msg = Res.string().getBundle().getString("NET_OPEN_CHANNEL_ERROR"); 
			break;
		case LastError.NET_CLOSE_CHANNEL_ERROR: // (0x80000000|6) 关闭通道失败
			msg = Res.string().getBundle().getString("NET_CLOSE_CHANNEL_ERROR"); 
			break;
		case LastError.NET_ILLEGAL_PARAM: // (0x80000000|7) 用户参数不合法
			msg = Res.string().getBundle().getString("NET_ILLEGAL_PARAM"); 
			break;
		case LastError.NET_SDK_INIT_ERROR: // (0x80000000|8) SDK初始化出错
			msg = Res.string().getBundle().getString("NET_SDK_INIT_ERROR"); 
			break;
		case LastError.NET_SDK_UNINIT_ERROR: // (0x80000000|9) SDK清理出错
			msg = Res.string().getBundle().getString("NET_SDK_UNINIT_ERROR"); 
			break;
		case LastError.NET_RENDER_OPEN_ERROR: // (0x80000000|10) 申请render资源出错
			msg = Res.string().getBundle().getString("NET_RENDER_OPEN_ERROR"); 
			break;
		case LastError.NET_DEC_OPEN_ERROR: // (0x80000000|11) 打开解码库出错
			msg = Res.string().getBundle().getString("NET_DEC_OPEN_ERROR"); 
			break;
		case LastError.NET_DEC_CLOSE_ERROR: // (0x80000000|12) 关闭解码库出错
			msg = Res.string().getBundle().getString("NET_DEC_CLOSE_ERROR"); 
			break;
		case LastError.NET_MULTIPLAY_NOCHANNEL: // (0x80000000|13) 多画面预览中检测到通道数为0
			msg = Res.string().getBundle().getString("NET_MULTIPLAY_NOCHANNEL"); 
			break;
		case LastError.NET_TALK_INIT_ERROR: // (0x80000000|14) 录音库初始化失败
			msg = Res.string().getBundle().getString("NET_TALK_INIT_ERROR"); 
			break; 
		case LastError.NET_TALK_NOT_INIT:  // (0x80000000|15) 录音库未经初始化
			msg = Res.string().getBundle().getString("NET_TALK_NOT_INIT"); 
			break;
		case LastError.NET_TALK_SENDDATA_ERROR: // (0x80000000|16) 发送音频数据出错
			msg = Res.string().getBundle().getString("NET_TALK_SENDDATA_ERROR"); 
			break;
		case LastError.NET_REAL_ALREADY_SAVING: // (0x80000000|17) 实时数据已经处于保存状态
			msg = Res.string().getBundle().getString("NET_REAL_ALREADY_SAVING"); 
			break;
		case LastError.NET_NOT_SAVING: // (0x80000000|18) 未保存实时数据
			msg = Res.string().getBundle().getString("NET_NOT_SAVING"); 
			break;
		case LastError.NET_OPEN_FILE_ERROR: // (0x80000000|19) 打开文件出错
			msg = Res.string().getBundle().getString("NET_OPEN_FILE_ERROR"); 
			break;
		case LastError.NET_PTZ_SET_TIMER_ERROR: // (0x80000000|20) 启动云台控制定时器失败
			msg = Res.string().getBundle().getString("NET_PTZ_SET_TIMER_ERROR"); 
			break;
		case LastError.NET_RETURN_DATA_ERROR: // (0x80000000|21) 对返回数据的校验出错
			msg = Res.string().getBundle().getString("NET_RETURN_DATA_ERROR"); 
			break;
		case LastError.NET_INSUFFICIENT_BUFFER: // (0x80000000|22) 没有足够的缓存
			msg = Res.string().getBundle().getString("NET_INSUFFICIENT_BUFFER"); 
			break;
		case LastError.NET_NOT_SUPPORTED: // (0x80000000|23) 当前SDK未支持该功能
			msg = Res.string().getBundle().getString("NET_NOT_SUPPORTED"); 
			break;
		case LastError.NET_NO_RECORD_FOUND: // (0x80000000|24) 查询不到录像
			msg = Res.string().getBundle().getString("NET_NO_RECORD_FOUND"); 
			break;
		case LastError.NET_NOT_AUTHORIZED: // (0x80000000|25) 无操作权限
			msg = Res.string().getBundle().getString("NET_NOT_AUTHORIZED"); 
			break;
		case LastError.NET_NOT_NOW: // (0x80000000|26) 暂时无法执行
			msg = Res.string().getBundle().getString("NET_NOT_NOW"); 
			break;
		case LastError.NET_NO_TALK_CHANNEL: // (0x80000000|27) 未发现对讲通道
			msg = Res.string().getBundle().getString("NET_NO_TALK_CHANNEL"); 
			break;
		case LastError.NET_NO_AUDIO: // (0x80000000|28) 未发现音频
			msg = Res.string().getBundle().getString("NET_NO_AUDIO"); 
			break;
		case LastError.NET_NO_INIT: // (0x80000000|29) 网络SDK未经初始化
			msg = Res.string().getBundle().getString("NET_NO_INIT"); 
			break;
		case LastError.NET_DOWNLOAD_END: // (0x80000000|30) 下载已结束
			msg = Res.string().getBundle().getString("NET_DOWNLOAD_END"); 
			break;
		case LastError.NET_EMPTY_LIST: // (0x80000000|31) 查询结果为空
			msg = Res.string().getBundle().getString("NET_EMPTY_LIST"); 
			break;
		case LastError.NET_ERROR_GETCFG_SYSATTR: // (0x80000000|32) 获取系统属性配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_SYSATTR"); 
			break;
		case LastError.NET_ERROR_GETCFG_SERIAL: // (0x80000000|33) 获取序列号失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_SERIAL"); 
			break;
		case LastError.NET_ERROR_GETCFG_GENERAL: // (0x80000000|34) 获取常规属性失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_GENERAL"); 
			break;
		case LastError.NET_ERROR_GETCFG_DSPCAP: // (0x80000000|35) 获取DSP能力描述失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_DSPCAP"); 
			break;
		case LastError.NET_ERROR_GETCFG_NETCFG: // (0x80000000|36) 获取网络配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_NETCFG"); 
			break;
		case LastError.NET_ERROR_GETCFG_CHANNAME: // (0x80000000|37) 获取通道名称失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_CHANNAME"); 
			break;
		case LastError.NET_ERROR_GETCFG_VIDEO: // (0x80000000|38) 获取视频属性失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_VIDEO"); 
			break; 
		case LastError.NET_ERROR_GETCFG_RECORD: // (0x80000000|39) 获取录象配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_RECORD"); 
			break;
		case LastError.NET_ERROR_GETCFG_PRONAME: // (0x80000000|40) 获取解码器协议名称失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_PRONAME"); 
			break;
		case LastError.NET_ERROR_GETCFG_FUNCNAME: // (0x80000000|41)  获取232串口功能名称失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_FUNCNAME"); 
			break;
		case LastError.NET_ERROR_GETCFG_485DECODER: // (0x80000000|42) 获取解码器属性失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_485DECODER"); 
			break;
		case LastError.NET_ERROR_GETCFG_232COM:   // (0x80000000|43) 获取232串口配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_232COM"); 
			break;
		case LastError.NET_ERROR_GETCFG_ALARMIN:  // (0x80000000|44) 获取外部报警输入配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_ALARMIN"); 
			break;
		case LastError.NET_ERROR_GETCFG_ALARMDET: // (0x80000000|45) 获取动态检测报警失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_ALARMDET"); 
			break;
		case LastError.NET_ERROR_GETCFG_SYSTIME: // (0x80000000|46) 获取设备时间失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_SYSTIME"); 
			break;
		case LastError.NET_ERROR_GETCFG_PREVIEW: // (0x80000000|47) 获取预览参数失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_PREVIEW"); 
			break;
		case LastError.NET_ERROR_GETCFG_AUTOMT: // (0x80000000|48) 获取自动维护配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_AUTOMT"); 
			break;
		case LastError.NET_ERROR_GETCFG_VIDEOMTRX: // (0x80000000|49) 获取视频矩阵配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_VIDEOMTRX"); 
			break;
		case LastError.NET_ERROR_GETCFG_COVER:  // (0x80000000|50) 获取区域遮挡配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_COVER"); 
			break;
		case LastError.NET_ERROR_GETCFG_WATERMAKE: // (0x80000000|51) 获取图象水印配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_WATERMAKE"); 
			break;
		case LastError.NET_ERROR_GETCFG_MULTICAST: // (0x80000000|52) 获取配置失败位置：组播端口按通道配置
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_MULTICAST"); 
			break;
		case LastError.NET_ERROR_SETCFG_GENERAL:  // (0x80000000|55) 修改常规属性失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_GENERAL"); 
			break;
		case LastError.NET_ERROR_SETCFG_NETCFG:  // (0x80000000|56) 改网络配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_NETCFG"); 
			break;
		case LastError.NET_ERROR_SETCFG_CHANNAME: // (0x80000000|57) 修改通道名称失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_CHANNAME"); 
			break;
		case LastError.NET_ERROR_SETCFG_VIDEO:  // (0x80000000|58) 修改视频属性失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_VIDEO"); 
			break;
		case LastError.NET_ERROR_SETCFG_RECORD: // (0x80000000|59) 修改录象配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_RECORD"); 
			break;
		case LastError.NET_ERROR_SETCFG_485DECODER: // (0x80000000|60) 修改解码器属性失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_485DECODER"); 
			break;
		case LastError.NET_ERROR_SETCFG_232COM:  // (0x80000000|61) 修改232串口配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_232COM"); 
			break;
		case LastError.NET_ERROR_SETCFG_ALARMIN: // (0x80000000|62) 修改外部输入报警配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_ALARMIN"); 
			break; 
		case LastError.NET_ERROR_SETCFG_ALARMDET: // (0x80000000|63)  修改动态检测报警配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_ALARMDET"); 
			break;
		case LastError.NET_ERROR_SETCFG_SYSTIME: // (0x80000000|64) 修改设备时间失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_SYSTIME"); 
			break;
		case LastError.NET_ERROR_SETCFG_PREVIEW: // (0x80000000|65) 修改预览参数失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_PREVIEW"); 
			break;
		case LastError.NET_ERROR_SETCFG_AUTOMT: // (0x80000000|66) 修改自动维护配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_AUTOMT"); 
			break;
		case LastError.NET_ERROR_SETCFG_VIDEOMTRX: // (0x80000000|67) 修改视频矩阵配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_VIDEOMTRX"); 
			break;
		case LastError.NET_ERROR_SETCFG_COVER:  // (0x80000000|68) 修改区域遮挡配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_COVER"); 
			break;
		case LastError.NET_ERROR_SETCFG_WATERMAKE: // (0x80000000|69) 修改图象水印配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_WATERMAKE"); 
			break;
		case LastError.NET_ERROR_SETCFG_WLAN:  // (0x80000000|70) 修改无线网络信息失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_WLAN"); 
			break;
		case LastError.NET_ERROR_SETCFG_WLANDEV: // (0x80000000|71) 选择无线网络设备失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_WLANDEV"); 
			break;
		case LastError.NET_ERROR_SETCFG_REGISTER: // (0x80000000|72) 修改主动注册参数配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_REGISTER"); 
			break;
		case LastError.NET_ERROR_SETCFG_CAMERA:  // (0x80000000|73) 修改摄像头属性配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_CAMERA"); 
			break;
		case LastError.NET_ERROR_SETCFG_INFRARED: // (0x80000000|74)  修改红外报警配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_INFRARED"); 
			break;
		case LastError.NET_ERROR_SETCFG_SOUNDALARM: // (0x80000000|75) 修改音频报警配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_SOUNDALARM"); 
			break;
		case LastError.NET_ERROR_SETCFG_STORAGE:  // (0x80000000|76) 修改存储位置配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_STORAGE"); 
			break;
		case LastError.NET_AUDIOENCODE_NOTINIT:  // (0x80000000|77) 音频编码接口没有成功初始化
			msg = Res.string().getBundle().getString("NET_AUDIOENCODE_NOTINIT"); 
			break;
		case LastError.NET_DATA_TOOLONGH:  // (0x80000000|78) 数据过长
			msg = Res.string().getBundle().getString("NET_DATA_TOOLONGH"); 
			break;
		case LastError.NET_UNSUPPORTED:  // (0x80000000|79) 备不支持该操作
			msg = Res.string().getBundle().getString("NET_UNSUPPORTED"); 
			break;
		case LastError.NET_DEVICE_BUSY:  // (0x80000000|80) 设备资源不足
			msg = Res.string().getBundle().getString("NET_DEVICE_BUSY"); 
			break;
		case LastError.NET_SERVER_STARTED: // (0x80000000|81) 服务器已经启动
			msg = Res.string().getBundle().getString("NET_SERVER_STARTED"); 
			break;
		case LastError.NET_SERVER_STOPPED: // (0x80000000|82) 服务器尚未成功启动
			msg = Res.string().getBundle().getString("NET_SERVER_STOPPED"); 
			break;
		case LastError.NET_LISTER_INCORRECT_SERIAL: // (0x80000000|83) 输入序列号有误
			msg = Res.string().getBundle().getString("NET_LISTER_INCORRECT_SERIAL"); 
			break;
		case LastError.NET_QUERY_DISKINFO_FAILED:  // (0x80000000|84) 获取硬盘信息失败
			msg = Res.string().getBundle().getString("NET_QUERY_DISKINFO_FAILED"); 
			break;
		case LastError.NET_ERROR_GETCFG_SESSION:  // (0x80000000|85) 获取连接Session信息
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_SESSION"); 
			break;
		case LastError.NET_USER_FLASEPWD_TRYTIME: // (0x80000000|86) 输入密码错误超过限制次数
			msg = Res.string().getBundle().getString("NET_USER_FLASEPWD_TRYTIME"); 
			break;
		case LastError.NET_LOGIN_ERROR_PASSWORD:  // (0x80000000|100) 密码不正确
			msg = Res.string().getBundle().getString("NET_LOGIN_ERROR_PASSWORD"); 
			break; 
		case LastError.NET_LOGIN_ERROR_USER:  // (0x80000000|101) 帐户不存在
			msg = Res.string().getBundle().getString("NET_LOGIN_ERROR_USER"); 
			break;
		case LastError.NET_LOGIN_ERROR_TIMEOUT:  // (0x80000000|102) 等待登录返回超时
			msg = Res.string().getBundle().getString("NET_LOGIN_ERROR_TIMEOUT"); 
			break;
		case LastError.NET_LOGIN_ERROR_RELOGGIN: // (0x80000000|103) 帐号已登录
			msg = Res.string().getBundle().getString("NET_LOGIN_ERROR_RELOGGIN"); 
			break;
		case LastError.NET_LOGIN_ERROR_LOCKED:  // (0x80000000|104) 帐号已被锁定
			msg = Res.string().getBundle().getString("NET_LOGIN_ERROR_LOCKED"); 
			break;
		case LastError.NET_LOGIN_ERROR_BLACKLIST: // (0x80000000|105) 帐号已被列为黑名单
			msg = Res.string().getBundle().getString("NET_LOGIN_ERROR_BLACKLIST"); 
			break;
		case LastError.NET_LOGIN_ERROR_BUSY:  // (0x80000000|106) 资源不足，系统忙
			msg = Res.string().getBundle().getString("NET_LOGIN_ERROR_BUSY"); 
			break;
		case LastError.NET_LOGIN_ERROR_CONNECT:  // (0x80000000|107) 登录设备超时，请检查网络并重试
			msg = Res.string().getBundle().getString("NET_LOGIN_ERROR_CONNECT"); 
			break;
		case LastError.NET_LOGIN_ERROR_NETWORK: // (0x80000000|108)  网络连接失败
			msg = Res.string().getBundle().getString("NET_LOGIN_ERROR_NETWORK"); 
			break;
		case LastError.NET_LOGIN_ERROR_SUBCONNECT: // (0x80000000|109) 登录设备成功，但无法创建视频通道，请检查网
			msg = Res.string().getBundle().getString("NET_LOGIN_ERROR_SUBCONNECT"); 
			break;
		case LastError.NET_LOGIN_ERROR_MAXCONNECT:  // (0x80000000|110) 超过最大连接数
			msg = Res.string().getBundle().getString("NET_LOGIN_ERROR_MAXCONNECT"); 
			break;
		case LastError.NET_LOGIN_ERROR_PROTOCOL3_ONLY: // (0x80000000|111) 只支持3代协议
			msg = Res.string().getBundle().getString("NET_LOGIN_ERROR_PROTOCOL3_ONLY"); 
			break;
		case LastError.NET_LOGIN_ERROR_UKEY_LOST:  // (0x80000000|112) 插入U盾或U盾信息错误
			msg = Res.string().getBundle().getString("NET_LOGIN_ERROR_UKEY_LOST"); 
			break;
		case LastError.NET_LOGIN_ERROR_NO_AUTHORIZED: // (0x80000000|113) 客户端IP地址没有登录权限
			msg = Res.string().getBundle().getString("NET_LOGIN_ERROR_NO_AUTHORIZED"); 
			break;
		case LastError.NET_LOGIN_ERROR_USER_OR_PASSOWRD:  // (0x80000000|117) 账号或密码错误 
			msg = Res.string().getBundle().getString("NET_LOGIN_ERROR_USER_OR_PASSOWRD"); 
			break;
		case LastError.NET_LOGIN_ERROR_DEVICE_NOT_INIT:  // (0x80000000|118) 设备尚未初始化，不能登录，请先初始化设备
			msg = Res.string().getBundle().getString("NET_LOGIN_ERROR_DEVICE_NOT_INIT"); 
			break;
		case LastError.NET_RENDER_SOUND_ON_ERROR:  // (0x80000000|120) Render库打开音频出错
			msg = Res.string().getBundle().getString("NET_RENDER_SOUND_ON_ERROR"); 
			break;
		case LastError.NET_RENDER_SOUND_OFF_ERROR: // (0x80000000|121) Render库关闭音频出错
			msg = Res.string().getBundle().getString("NET_RENDER_SOUND_OFF_ERROR"); 
			break;
		case LastError.NET_RENDER_SET_VOLUME_ERROR: // (0x80000000|122) Render库控制音量出错
			msg = Res.string().getBundle().getString("NET_RENDER_SET_VOLUME_ERROR"); 
			break;
		case LastError.NET_RENDER_ADJUST_ERROR:  // (0x80000000|123) Render库设置画面参数出错
			msg = Res.string().getBundle().getString("NET_RENDER_ADJUST_ERROR"); 
			break;
		case LastError.NET_RENDER_PAUSE_ERROR: // (0x80000000|124) Render库暂停播放出错
			msg = Res.string().getBundle().getString("NET_RENDER_PAUSE_ERROR"); 
			break;
		case LastError.NET_RENDER_SNAP_ERROR:  // (0x80000000|125) Render库抓图出错
			msg = Res.string().getBundle().getString("NET_RENDER_SNAP_ERROR"); 
			break;
		case LastError.NET_RENDER_STEP_ERROR:  // (0x80000000|126) Render库步进出错
			msg = Res.string().getBundle().getString("NET_RENDER_STEP_ERROR"); 
			break;
		case LastError.NET_RENDER_FRAMERATE_ERROR:  // (0x80000000|127) Render库设置帧率出错
			msg = Res.string().getBundle().getString("NET_RENDER_FRAMERATE_ERROR"); 
			break;
		case LastError.NET_RENDER_DISPLAYREGION_ERROR: // (0x80000000|128) Render库设置显示区域出错
			msg = Res.string().getBundle().getString("NET_RENDER_DISPLAYREGION_ERROR"); 
			break;
		case LastError.NET_RENDER_GETOSDTIME_ERROR: // (0x80000000|129) Render库获取当前播放时间出错
			msg = Res.string().getBundle().getString("NET_RENDER_GETOSDTIME_ERROR"); 
			break;
		case LastError.NET_GROUP_EXIST: // (0x80000000|140) 组名已存在
			msg = Res.string().getBundle().getString("NET_GROUP_EXIST"); 
			break;
		case LastError.NET_GROUP_NOEXIST: // (0x80000000|141) 组名不存在
			msg = Res.string().getBundle().getString("NET_GROUP_NOEXIST"); 
			break;
		case LastError.NET_GROUP_RIGHTOVER: // (0x80000000|142) 组的权限超出权限列表范围
			msg = Res.string().getBundle().getString("NET_GROUP_RIGHTOVER"); 
			break;
		case LastError.NET_GROUP_HAVEUSER: // (0x80000000|143) 组下有用户，不能删除
			msg = Res.string().getBundle().getString("NET_GROUP_HAVEUSER"); 
			break;
		case LastError.NET_GROUP_RIGHTUSE: // (0x80000000|144) 组的某个权限被用户使用，不能出除
			msg = Res.string().getBundle().getString("NET_GROUP_RIGHTUSE"); 
			break;
		case LastError.NET_GROUP_SAMENAME: // (0x80000000|145) 新组名同已有组名重复
			msg = Res.string().getBundle().getString("NET_GROUP_SAMENAME"); 
			break; 
		case LastError.NET_USER_EXIST:  // (0x80000000|146) 用户已存在
			msg = Res.string().getBundle().getString("NET_USER_EXIST"); 
			break;
		case LastError.NET_USER_NOEXIST: // (0x80000000|147) 用户不存在
			msg = Res.string().getBundle().getString("NET_USER_NOEXIST"); 
			break; 
		case LastError.NET_USER_RIGHTOVER: // (0x80000000|148) 用户权限超出组权限
			msg = Res.string().getBundle().getString("NET_USER_RIGHTOVER"); 
			break;
		case LastError.NET_USER_PWD: // (0x80000000|149) 保留帐号，不容许修改密码
			msg = Res.string().getBundle().getString("NET_USER_PWD"); 
			break;
		case LastError.NET_USER_FLASEPWD: // (0x80000000|150) 密码不正确
			msg = Res.string().getBundle().getString("NET_USER_FLASEPWD"); 
			break;
		case LastError.NET_USER_NOMATCHING: // (0x80000000|151)  密码不匹配
			msg = Res.string().getBundle().getString("NET_USER_NOMATCHING"); 
			break;
		case LastError.NET_USER_INUSE: // (0x80000000|152)  账号正在使用中
			msg = Res.string().getBundle().getString("NET_USER_INUSE"); 
			break;
		case LastError.NET_ERROR_GETCFG_ETHERNET: // (0x80000000|300) 获取网卡配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_ETHERNET"); 
			break;
		case LastError.NET_ERROR_GETCFG_WLAN: // (0x80000000|301) 获取无线网络信息失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_WLAN"); 
			break;
		case LastError.NET_ERROR_GETCFG_WLANDEV:  // (0x80000000|302) 获取无线网络设备失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_WLANDEV"); 
			break;
		case LastError.NET_ERROR_GETCFG_REGISTER: // (0x80000000|303) 获取主动注册参数失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_REGISTER"); 
			break;
		case LastError.NET_ERROR_GETCFG_CAMERA: // (0x80000000|304) 获取摄像头属性失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_CAMERA"); 
			break;
		case LastError.NET_ERROR_GETCFG_INFRARED: // (0x80000000|305) 获取红外报警配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_INFRARED"); 
			break;
		case LastError.NET_ERROR_GETCFG_SOUNDALARM: // (0x80000000|306)  获取音频报警配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_SOUNDALARM"); 
			break;
		case LastError.NET_ERROR_GETCFG_STORAGE:  // (0x80000000|307)  获取存储位置配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_STORAGE"); 
			break;
		case LastError.NET_ERROR_GETCFG_MAIL:  // (0x80000000|308) 获取邮件配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_MAIL"); 
			break;
		case LastError.NET_CONFIG_DEVBUSY: // (0x80000000|309) 暂时无法设置
			msg = Res.string().getBundle().getString("NET_CONFIG_DEVBUSY"); 
			break;
		case LastError.NET_CONFIG_DATAILLEGAL: // (0x80000000|310) 配置数据不合法
			msg = Res.string().getBundle().getString("NET_CONFIG_DATAILLEGAL"); 
			break;
		case LastError.NET_ERROR_GETCFG_DST: // (0x80000000|311) 获取夏令时配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_DST"); 
			break;
		case LastError.NET_ERROR_SETCFG_DST: // (0x80000000|312) 设置夏令时配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_DST"); 
			break;
		case LastError.NET_ERROR_GETCFG_VIDEO_OSD: // (0x80000000|313) 获取视频OSD叠加配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_VIDEO_OSD"); 
			break;
		case LastError.NET_ERROR_SETCFG_VIDEO_OSD:  // (0x80000000|314) 设置视频OSD叠加配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_VIDEO_OSD"); 
			break;
		case LastError.NET_ERROR_GETCFG_GPRSCDMA:  // (0x80000000|315) 获取CDMA\GPRS网络配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_GPRSCDMA"); 
			break;
		case LastError.NET_ERROR_SETCFG_GPRSCDMA: // (0x80000000|316) 设置CDMA\GPRS网络配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_GPRSCDMA"); 
			break;
		case LastError.NET_ERROR_GETCFG_IPFILTER: // (0x80000000|317) 获取IP过滤配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_IPFILTER"); 
			break;
		case LastError.NET_ERROR_SETCFG_IPFILTER: // (0x80000000|318) 设置IP过滤配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_IPFILTER"); 
			break;
		case LastError.NET_ERROR_GETCFG_TALKENCODE: // (0x80000000|319) 获取语音对讲编码配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_TALKENCODE"); 
			break;
		case LastError.NET_ERROR_SETCFG_TALKENCODE: // (0x80000000|320) 设置语音对讲编码配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_TALKENCODE"); 
			break;
		case LastError.NET_ERROR_GETCFG_RECORDLEN: // (0x80000000|321) 获取录像打包长度配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_RECORDLEN"); 
			break;
		case LastError.NET_ERROR_SETCFG_RECORDLEN: // (0x80000000|322) 设置录像打包长度配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_RECORDLEN"); 
			break;
		case LastError.NET_DONT_SUPPORT_SUBAREA: // (0x80000000|323) 不支持网络硬盘分区
			msg = Res.string().getBundle().getString("NET_DONT_SUPPORT_SUBAREA"); 
			break;
		case LastError.NET_ERROR_GET_AUTOREGSERVER: // (0x80000000|324) 获取设备上主动注册服务器信息失败
			msg = Res.string().getBundle().getString("NET_ERROR_GET_AUTOREGSERVER"); 
			break;
		case LastError.NET_ERROR_CONTROL_AUTOREGISTER: // (0x80000000|325) 主动注册重定向注册错误
			msg = Res.string().getBundle().getString("NET_ERROR_CONTROL_AUTOREGISTER"); 
			break;
		case LastError.NET_ERROR_DISCONNECT_AUTOREGISTER: // (0x80000000|326) 断开主动注册服务器错误
			msg = Res.string().getBundle().getString("NET_ERROR_DISCONNECT_AUTOREGISTER"); 
			break;
		case LastError.NET_ERROR_GETCFG_MMS: // (0x80000000|327) 获取mms配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_MMS"); 
			break;
		case LastError.NET_ERROR_SETCFG_MMS: // (0x80000000|328) 设置mms配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_MMS"); 
			break;
		case LastError.NET_ERROR_GETCFG_SMSACTIVATION: // (0x80000000|329) 获取短信激活无线连接配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_SMSACTIVATION"); 
			break;
		case LastError.NET_ERROR_SETCFG_SMSACTIVATION: // (0x80000000|330) 设置短信激活无线连接配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_SMSACTIVATION"); 
			break;
		case LastError.NET_ERROR_GETCFG_DIALINACTIVATION: // (0x80000000|331) 获取拨号激活无线连接配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_DIALINACTIVATION"); 
			break;
		case LastError.NET_ERROR_SETCFG_DIALINACTIVATION: // (0x80000000|332) 设置拨号激活无线连接配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_DIALINACTIVATION"); 
			break;
		case LastError.NET_ERROR_GETCFG_VIDEOOUT: // (0x80000000|333) 查询视频输出参数配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_VIDEOOUT"); 
			break;
		case LastError.NET_ERROR_SETCFG_VIDEOOUT: // (0x80000000|334) 设置视频输出参数配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_VIDEOOUT"); 
			break;
		case LastError.NET_ERROR_GETCFG_OSDENABLE: // (0x80000000|335) 获取osd叠加使能配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_OSDENABLE"); 
			break;
		case LastError.NET_ERROR_SETCFG_OSDENABLE: // (0x80000000|336) 设置osd叠加使能配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_OSDENABLE"); 
			break;
		case LastError.NET_ERROR_SETCFG_ENCODERINFO: // (0x80000000|337) 设置数字通道前端编码接入配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_ENCODERINFO"); 
			break;
		case LastError.NET_ERROR_GETCFG_TVADJUST: // (0x80000000|338) 获取TV调节配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_TVADJUST"); 
			break;
		case LastError.NET_ERROR_SETCFG_TVADJUST: // (0x80000000|339) 设置TV调节配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_TVADJUST"); 
			break;
		case LastError.NET_ERROR_CONNECT_FAILED: // (0x80000000|340) 请求建立连接失败
			msg = Res.string().getBundle().getString("NET_ERROR_CONNECT_FAILED"); 
			break;
		case LastError.NET_ERROR_SETCFG_BURNFILE: // (0x80000000|341) 请求刻录文件上传失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_BURNFILE"); 
			break;
		case LastError.NET_ERROR_SNIFFER_GETCFG: // (0x80000000|342) 获取抓包配置信息失败
			msg = Res.string().getBundle().getString("NET_ERROR_SNIFFER_GETCFG"); 
			break;
		case LastError.NET_ERROR_SNIFFER_SETCFG: // (0x80000000|343) 设置抓包配置信息失败
			msg = Res.string().getBundle().getString("NET_ERROR_SNIFFER_SETCFG"); 
			break;
		case LastError.NET_ERROR_DOWNLOADRATE_GETCFG: // (0x80000000|344) 查询下载限制信息失败
			msg = Res.string().getBundle().getString("NET_ERROR_DOWNLOADRATE_GETCFG"); 
			break;
		case LastError.NET_ERROR_DOWNLOADRATE_SETCFG: // (0x80000000|345) 设置下载限制信息失败
			msg = Res.string().getBundle().getString("NET_ERROR_DOWNLOADRATE_SETCFG"); 
			break;
		case LastError.NET_ERROR_SEARCH_TRANSCOM:  // (0x80000000|346) 查询串口参数失败
			msg = Res.string().getBundle().getString("NET_ERROR_SEARCH_TRANSCOM"); 
			break;
		case LastError.NET_ERROR_GETCFG_POINT: // (0x80000000|347) 获取预制点信息错误
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_POINT"); 
			break;
		case LastError.NET_ERROR_SETCFG_POINT: // (0x80000000|348) 设置预制点信息错误
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_POINT"); 
			break;
		case LastError.NET_SDK_LOGOUT_ERROR:  // (0x80000000|349) SDK没有正常登出设备
			msg = Res.string().getBundle().getString("NET_SDK_LOGOUT_ERROR"); 
			break;
		case LastError.NET_ERROR_GET_VEHICLE_CFG: // (0x80000000|350) 获取车载配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GET_VEHICLE_CFG"); 
			break;
		case LastError.NET_ERROR_SET_VEHICLE_CFG: // (0x80000000|351) 设置车载配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SET_VEHICLE_CFG"); 
			break;
		case LastError.NET_ERROR_GET_ATM_OVERLAY_CFG: // (0x80000000|352) 获取atm叠加配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GET_ATM_OVERLAY_CFG"); 
			break;
		case LastError.NET_ERROR_SET_ATM_OVERLAY_CFG: // (0x80000000|353) 设置atm叠加配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SET_ATM_OVERLAY_CFG"); 
			break;
		case LastError.NET_ERROR_GET_ATM_OVERLAY_ABILITY: // (0x80000000|354) 获取atm叠加能力失败
			msg = Res.string().getBundle().getString("NET_ERROR_GET_ATM_OVERLAY_ABILITY"); 
			break;
		case LastError.NET_ERROR_GET_DECODER_TOUR_CFG: // (0x80000000|355) 获取解码器解码轮巡配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GET_DECODER_TOUR_CFG"); 
			break;
		case LastError.NET_ERROR_SET_DECODER_TOUR_CFG: // (0x80000000|356) 设置解码器解码轮巡配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SET_DECODER_TOUR_CFG"); 
			break;
		case LastError.NET_ERROR_CTRL_DECODER_TOUR: // (0x80000000|357) 控制解码器解码轮巡失败
			msg = Res.string().getBundle().getString("NET_ERROR_CTRL_DECODER_TOUR"); 
			break;
		case LastError.NET_GROUP_OVERSUPPORTNUM:  // (0x80000000|358) 超出设备支持最大用户组数目
			msg = Res.string().getBundle().getString("NET_GROUP_OVERSUPPORTNUM"); 
			break;
		case LastError.NET_USER_OVERSUPPORTNUM: // (0x80000000|359) 超出设备支持最大用户数目
			msg = Res.string().getBundle().getString("NET_USER_OVERSUPPORTNUM"); 
			break;
		case LastError.NET_ERROR_GET_SIP_CFG:  // (0x80000000|368) 获取SIP配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GET_SIP_CFG"); 
			break;
		case LastError.NET_ERROR_SET_SIP_CFG:  // (0x80000000|369) 设置SIP配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SET_SIP_CFG"); 
			break;
		case LastError.NET_ERROR_GET_SIP_ABILITY: // (0x80000000|370) 获取SIP能力失败
			msg = Res.string().getBundle().getString("NET_ERROR_GET_SIP_ABILITY"); 
			break;
		case LastError.NET_ERROR_GET_WIFI_AP_CFG: // (0x80000000|371) 获取WIFI ap配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GET_WIFI_AP_CFG"); 
			break;
		case LastError.NET_ERROR_SET_WIFI_AP_CFG: // (0x80000000|372) 设置WIFI ap配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SET_WIFI_AP_CFG"); 
			break;
		case LastError.NET_ERROR_GET_DECODE_POLICY: // (0x80000000|373) 获取解码策略配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GET_DECODE_POLICY"); 
			break;
		case LastError.NET_ERROR_SET_DECODE_POLICY: // (0x80000000|374) 设置解码策略配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SET_DECODE_POLICY"); 
			break;
		case LastError.NET_ERROR_TALK_REJECT: // (0x80000000|375) 拒绝对讲
			msg = Res.string().getBundle().getString("NET_ERROR_TALK_REJECT"); 
			break;
		case LastError.NET_ERROR_TALK_OPENED: // (0x80000000|376) 对讲被其他客户端打开
			msg = Res.string().getBundle().getString("NET_ERROR_TALK_OPENED"); 
			break;
		case LastError.NET_ERROR_TALK_RESOURCE_CONFLICIT: // (0x80000000|377) 资源冲突
			msg = Res.string().getBundle().getString("NET_ERROR_TALK_RESOURCE_CONFLICIT"); 
			break;
		case LastError.NET_ERROR_TALK_UNSUPPORTED_ENCODE: // (0x80000000|378) 不支持的语音编码格式
			msg = Res.string().getBundle().getString("NET_ERROR_TALK_UNSUPPORTED_ENCODE"); 
			break;
		case LastError.NET_ERROR_TALK_RIGHTLESS:  // (0x80000000|379) 无权限
			msg = Res.string().getBundle().getString("NET_ERROR_TALK_RIGHTLESS"); 
			break;
		case LastError.NET_ERROR_TALK_FAILED:  // (0x80000000|380) 请求对讲失败
			msg = Res.string().getBundle().getString("NET_ERROR_TALK_FAILED"); 
			break;
		case LastError.NET_ERROR_GET_MACHINE_CFG: // (0x80000000|381) 获取机器相关配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GET_MACHINE_CFG"); 
			break;
		case LastError.NET_ERROR_SET_MACHINE_CFG: // (0x80000000|382) 设置机器相关配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SET_MACHINE_CFG"); 
			break;
		case LastError.NET_ERROR_GET_DATA_FAILED: // (0x80000000|383) 设备无法获取当前请求数据
			msg = Res.string().getBundle().getString("NET_ERROR_GET_DATA_FAILED"); 
			break;
		case LastError.NET_ERROR_MAC_VALIDATE_FAILED: // (0x80000000|384) MAC地址验证失败
			msg = Res.string().getBundle().getString("NET_ERROR_MAC_VALIDATE_FAILED"); 
			break;
		case LastError.NET_ERROR_GET_INSTANCE:  // (0x80000000|385) 获取服务器实例失败
			msg = Res.string().getBundle().getString("NET_ERROR_GET_INSTANCE"); 
			break;
		case LastError.NET_ERROR_JSON_REQUEST: // (0x80000000|386) 生成的json字符串错误
			msg = Res.string().getBundle().getString("NET_ERROR_JSON_REQUEST"); 
			break;
		case LastError.NET_ERROR_JSON_RESPONSE: // (0x80000000|387) 响应的json字符串错误
			msg = Res.string().getBundle().getString("NET_ERROR_JSON_RESPONSE"); 
			break;
		case LastError.NET_ERROR_VERSION_HIGHER: // (0x80000000|388) 协议版本低于当前使用的版本
			msg = Res.string().getBundle().getString("NET_ERROR_VERSION_HIGHER"); 
			break;
		case LastError.NET_SPARE_NO_CAPACITY: // (0x80000000|389) 热备操作失败, 容量不足
			msg = Res.string().getBundle().getString("NET_SPARE_NO_CAPACITY"); 
			break;
		case LastError.NET_ERROR_SOURCE_IN_USE: // (0x80000000|390) 显示源被其他输出占用
			msg = Res.string().getBundle().getString("NET_ERROR_SOURCE_IN_USE"); 
			break;
		case LastError.NET_ERROR_REAVE: // (0x80000000|391) 高级用户抢占低级用户资源
			msg = Res.string().getBundle().getString("NET_ERROR_REAVE"); 
			break;
		case LastError.NET_ERROR_NETFORBID: // (0x80000000|392) 禁止入网
			msg = Res.string().getBundle().getString("NET_ERROR_NETFORBID"); 
			break;
		case LastError.NET_ERROR_GETCFG_MACFILTER: // (0x80000000|393) 获取MAC过滤配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_MACFILTER"); 
			break;
		case LastError.NET_ERROR_SETCFG_MACFILTER: // (0x80000000|394) 设置MAC过滤配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_MACFILTER"); 
			break;
		case LastError.NET_ERROR_GETCFG_IPMACFILTER: // (0x80000000|395) 获取IP/MAC过滤配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_GETCFG_IPMACFILTER"); 
			break;
		case LastError.NET_ERROR_SETCFG_IPMACFILTER: // (0x80000000|396) 设置IP/MAC过滤配置失败
			msg = Res.string().getBundle().getString("NET_ERROR_SETCFG_IPMACFILTER"); 
			break;
		case LastError.NET_ERROR_OPERATION_OVERTIME: // (0x80000000|397) 当前操作超时
			msg = Res.string().getBundle().getString("NET_ERROR_OPERATION_OVERTIME"); 
			break;
		case LastError.NET_ERROR_SENIOR_VALIDATE_FAILED: // (0x80000000|398) 高级校验失败
			msg = Res.string().getBundle().getString("NET_ERROR_SENIOR_VALIDATE_FAILED"); 
			break;
		case LastError.NET_ERROR_DEVICE_ID_NOT_EXIST: // (0x80000000|399) 设备ID不存在
			msg = Res.string().getBundle().getString("NET_ERROR_DEVICE_ID_NOT_EXIST"); 
			break;
		case LastError.NET_ERROR_UNSUPPORTED:  // (0x80000000|400) 不支持当前操作
			msg = Res.string().getBundle().getString("NET_ERROR_UNSUPPORTED"); 
			break;
		case LastError.NET_ERROR_PROXY_DLLLOAD: // (0x80000000|401) 代理库加载失败
			msg = Res.string().getBundle().getString("NET_ERROR_PROXY_DLLLOAD"); 
			break;
		case LastError.NET_ERROR_PROXY_ILLEGAL_PARAM: // (0x80000000|402) 代理用户参数不合法
			msg = Res.string().getBundle().getString("NET_ERROR_PROXY_ILLEGAL_PARAM"); 
			break;
		case LastError.NET_ERROR_PROXY_INVALID_HANDLE: // (0x80000000|403) 代理句柄无效
			msg = Res.string().getBundle().getString("NET_ERROR_PROXY_INVALID_HANDLE"); 
			break;
		case LastError.NET_ERROR_PROXY_LOGIN_DEVICE_ERROR: // (0x80000000|404) 代理登入前端设备失败
			msg = Res.string().getBundle().getString("NET_ERROR_PROXY_LOGIN_DEVICE_ERROR"); 
			break;
		case LastError.NET_ERROR_PROXY_START_SERVER_ERROR: // (0x80000000|405) 启动代理服务失败
			msg = Res.string().getBundle().getString("NET_ERROR_PROXY_START_SERVER_ERROR"); 
			break;
		case LastError.NET_ERROR_SPEAK_FAILED: // (0x80000000|406) 请求喊话失败
			msg = Res.string().getBundle().getString("NET_ERROR_SPEAK_FAILED"); 
			break;
		case LastError.NET_ERROR_NOT_SUPPORT_F6: // (0x80000000|407) 设备不支持此F6接口调用
			msg = Res.string().getBundle().getString("NET_ERROR_NOT_SUPPORT_F6"); 
			break;
		case LastError.NET_ERROR_CD_UNREADY: // (0x80000000|408) 光盘未就绪
			msg = Res.string().getBundle().getString("NET_ERROR_CD_UNREADY"); 
			break;
		case LastError.NET_ERROR_DIR_NOT_EXIST: // (0x80000000|409) 目录不存在
			msg = Res.string().getBundle().getString("NET_ERROR_DIR_NOT_EXIST"); 
			break;
		case LastError.NET_ERROR_UNSUPPORTED_SPLIT_MODE: // (0x80000000|410) 设备不支持的分割模式
			msg = Res.string().getBundle().getString("NET_ERROR_UNSUPPORTED_SPLIT_MODE"); 
			break;
		case LastError.NET_ERROR_OPEN_WND_PARAM: // (0x80000000|411) 开窗参数不合法
			msg = Res.string().getBundle().getString("NET_ERROR_OPEN_WND_PARAM"); 
			break;
		case LastError.NET_ERROR_LIMITED_WND_COUNT: // (0x80000000|412) 开窗数量超过限制
			msg = Res.string().getBundle().getString("NET_ERROR_LIMITED_WND_COUNT"); 
			break;
		case LastError.NET_ERROR_UNMATCHED_REQUEST: // (0x80000000|413) 请求命令与当前模式不匹配
			msg = Res.string().getBundle().getString("NET_ERROR_UNMATCHED_REQUEST"); 
			break;
		case LastError.NET_RENDER_ENABLELARGEPICADJUSTMENT_ERROR: // (0x80000000|414) Render库启用高清图像内部调整策略出错
			msg = Res.string().getBundle().getString("NET_RENDER_ENABLELARGEPICADJUSTMENT_ERROR"); 
			break;
		case LastError.NET_ERROR_UPGRADE_FAILED: // (0x80000000|415) 设备升级失败
			msg = Res.string().getBundle().getString("NET_ERROR_UPGRADE_FAILED"); 
			break;
		case LastError.NET_ERROR_NO_TARGET_DEVICE: // (0x80000000|416) 找不到目标设备
			msg = Res.string().getBundle().getString("NET_ERROR_NO_TARGET_DEVICE"); 
			break;
		case LastError.NET_ERROR_NO_VERIFY_DEVICE: // (0x80000000|417) 找不到验证设备
			msg = Res.string().getBundle().getString("NET_ERROR_NO_VERIFY_DEVICE"); 
			break;
		case LastError.NET_ERROR_CASCADE_RIGHTLESS: // (0x80000000|418) 无级联权限
			msg = Res.string().getBundle().getString("NET_ERROR_CASCADE_RIGHTLESS"); 
			break;
		case LastError.NET_ERROR_LOW_PRIORITY: // (0x80000000|419) 低优先级
			msg = Res.string().getBundle().getString("NET_ERROR_LOW_PRIORITY"); 
			break;
		case LastError.NET_ERROR_REMOTE_REQUEST_TIMEOUT: // (0x80000000|420) 远程设备请求超时
			msg = Res.string().getBundle().getString("NET_ERROR_REMOTE_REQUEST_TIMEOUT"); 
			break;
		case LastError.NET_ERROR_LIMITED_INPUT_SOURCE: // (0x80000000|421) 输入源超出最大路数限制
			msg = Res.string().getBundle().getString("NET_ERROR_LIMITED_INPUT_SOURCE"); 
			break;
		case LastError.NET_ERROR_SET_LOG_PRINT_INFO: // (0x80000000|422) 设置日志打印失败
			msg = Res.string().getBundle().getString("NET_ERROR_SET_LOG_PRINT_INFO"); 
			break;
		case LastError.NET_ERROR_PARAM_DWSIZE_ERROR: // (0x80000000|423) 入参的dwsize字段出错
			msg = Res.string().getBundle().getString("NET_ERROR_PARAM_DWSIZE_ERROR"); 
			break;
		case LastError.NET_ERROR_LIMITED_MONITORWALL_COUNT: // (0x80000000|424) 电视墙数量超过上限
			msg = Res.string().getBundle().getString("NET_ERROR_LIMITED_MONITORWALL_COUNT"); 
			break;
		case LastError.NET_ERROR_PART_PROCESS_FAILED: // (0x80000000|425) 部分过程执行失败
			msg = Res.string().getBundle().getString("NET_ERROR_PART_PROCESS_FAILED"); 
			break;
		case LastError.NET_ERROR_TARGET_NOT_SUPPORT: // (0x80000000|426) 该功能不支持转发
			msg = Res.string().getBundle().getString("NET_ERROR_TARGET_NOT_SUPPORT"); 
			break;
		case LastError.NET_ERROR_VISITE_FILE: // (0x80000000|510) 访问文件失败
			msg = Res.string().getBundle().getString("NET_ERROR_VISITE_FILE"); 
			break;
		case LastError.NET_ERROR_DEVICE_STATUS_BUSY: // (0x80000000|511) 设备忙
			msg = Res.string().getBundle().getString("NET_ERROR_DEVICE_STATUS_BUSY"); 
			break;
		case LastError.NET_USER_PWD_NOT_AUTHORIZED: // (0x80000000|512)修改密码无权限
			msg = Res.string().getBundle().getString("NET_USER_PWD_NOT_AUTHORIZED"); 
			break;
		case LastError.NET_USER_PWD_NOT_STRONG: // (0x80000000|513) 密码强度不够
			msg = Res.string().getBundle().getString("NET_USER_PWD_NOT_STRONG"); 
			break;
		case LastError.NET_ERROR_NO_SUCH_CONFIG: // (0x80000000|514) 没有对应的配置
			msg = Res.string().getBundle().getString("NET_ERROR_NO_SUCH_CONFIG"); 
			break;
		case LastError.NET_ERROR_AUDIO_RECORD_FAILED: // (0x80000000|515) 录音失败
			msg = Res.string().getBundle().getString("NET_ERROR_AUDIO_RECORD_FAILED"); 
			break;
		case LastError.NET_ERROR_SEND_DATA_FAILED: // (0x80000000|516) 数据发送失败
			msg = Res.string().getBundle().getString("NET_ERROR_SEND_DATA_FAILED"); 
			break;
		case LastError.NET_ERROR_OBSOLESCENT_INTERFACE: // (0x80000000|517) 废弃接口
			msg = Res.string().getBundle().getString("NET_ERROR_OBSOLESCENT_INTERFACE"); 
			break;
		case LastError.NET_ERROR_INSUFFICIENT_INTERAL_BUF: // (0x80000000|518) 内部缓冲不足
			msg = Res.string().getBundle().getString("NET_ERROR_INSUFFICIENT_INTERAL_BUF"); 
			break;
		case LastError.NET_ERROR_NEED_ENCRYPTION_PASSWORD: // (0x80000000|519) 修改设备ip时,需要校验密码
			msg = Res.string().getBundle().getString("NET_ERROR_NEED_ENCRYPTION_PASSWORD"); 
			break;
		case LastError.NET_ERROR_NOSUPPORT_RECORD: // (0x80000000|520) 设备不支持此记录集
			msg = Res.string().getBundle().getString("NET_ERROR_NOSUPPORT_RECORD"); 
			break;
		case LastError.NET_ERROR_SERIALIZE_ERROR: // (0x80000000|1010) 数据序列化错误
			msg = Res.string().getBundle().getString("NET_ERROR_SERIALIZE_ERROR"); 
			break;
		case LastError.NET_ERROR_DESERIALIZE_ERROR: // (0x80000000|1011) 数据反序列化错误
			msg = Res.string().getBundle().getString("NET_ERROR_DESERIALIZE_ERROR"); 
			break;
		case LastError.NET_ERROR_LOWRATEWPAN_ID_EXISTED: // (0x80000000|1012) 该无线ID已存在
			msg = Res.string().getBundle().getString("NET_ERROR_LOWRATEWPAN_ID_EXISTED"); 
			break;
		case LastError.NET_ERROR_LOWRATEWPAN_ID_LIMIT: // (0x80000000|1013) 无线ID数量已超限
			msg = Res.string().getBundle().getString("NET_ERROR_LOWRATEWPAN_ID_LIMIT"); 
			break;
		case LastError.NET_ERROR_LOWRATEWPAN_ID_ABNORMAL: // (0x80000000|1014) 无线异常添加
			msg = Res.string().getBundle().getString("NET_ERROR_LOWRATEWPAN_ID_ABNORMAL"); 
			break;
		case LastError.NET_ERROR_ENCRYPT: // (0x80000000|1015) 加密数据失败
			msg = Res.string().getBundle().getString("NET_ERROR_ENCRYPT"); 
			break;
		case LastError.NET_ERROR_PWD_ILLEGAL: // (0x80000000|1016) 新密码不合规范
			msg = Res.string().getBundle().getString("NET_ERROR_PWD_ILLEGAL"); 
			break;
		case LastError.NET_ERROR_DEVICE_ALREADY_INIT: // (0x80000000|1017) 设备已经初始化
			msg = Res.string().getBundle().getString("NET_ERROR_DEVICE_ALREADY_INIT"); 
			break;
		case LastError.NET_ERROR_SECURITY_CODE: // (0x80000000|1018) 安全码错误
			msg = Res.string().getBundle().getString("NET_ERROR_SECURITY_CODE"); 
			break;
		case LastError.NET_ERROR_SECURITY_CODE_TIMEOUT: // (0x80000000|1019) 安全码超出有效期
			msg = Res.string().getBundle().getString("NET_ERROR_SECURITY_CODE_TIMEOUT"); 
			break;
		case LastError.NET_ERROR_GET_PWD_SPECI: // (0x80000000|1020) 获取密码规范失败
			msg = Res.string().getBundle().getString("NET_ERROR_GET_PWD_SPECI"); 
			break;
		case LastError.NET_ERROR_NO_AUTHORITY_OF_OPERATION: // (0x80000000|1021) 无权限进行该操作
			msg = Res.string().getBundle().getString("NET_ERROR_NO_AUTHORITY_OF_OPERATION"); 
			break;
		case LastError.NET_ERROR_DECRYPT: // (0x80000000|1022) 解密数据失败
			msg = Res.string().getBundle().getString("NET_ERROR_DECRYPT"); 
			break;
		case LastError.NET_ERROR_2D_CODE: // (0x80000000|1023) 2D code校验失败
			msg = Res.string().getBundle().getString("NET_ERROR_2D_CODE"); 
			break;
		case LastError.NET_ERROR_INVALID_REQUEST: // (0x80000000|1024) 非法的RPC请求
			msg = Res.string().getBundle().getString("NET_ERROR_INVALID_REQUEST"); 
			break;
		case LastError.NET_ERROR_PWD_RESET_DISABLE: // (0x80000000|1025) 密码重置功能已关闭
			msg = Res.string().getBundle().getString("NET_ERROR_PWD_RESET_DISABLE"); 
			break;
		case LastError.NET_ERROR_PLAY_PRIVATE_DATA: // (0x80000000|1026) 显示私有数据，比如规则框等失败
			msg = Res.string().getBundle().getString("NET_ERROR_PLAY_PRIVATE_DATA"); 
			break;
		case LastError.NET_ERROR_ROBOT_OPERATE_FAILED: // (0x80000000|1027) 机器人操作失败
			msg = Res.string().getBundle().getString("NET_ERROR_ROBOT_OPERATE_FAILED"); 
			break;
		case LastError.NET_ERROR_PHOTOSIZE_EXCEEDSLIMIT: // (0x80000000|1028) 图片大小超限
			msg = Res.string().getBundle().getString("NET_ERROR_PHOTOSIZE_EXCEEDSLIMIT"); 
			break;
		case LastError.NET_ERROR_USERID_INVALID: // (0x80000000|1029) 用户ID不存在
			msg = Res.string().getBundle().getString("NET_ERROR_USERID_INVALID"); 
			break;
		case LastError.NET_ERROR_EXTRACTFEATURE_FAILED: // (0x80000000|1030) 照片特征值提取失败
			msg = Res.string().getBundle().getString("NET_ERROR_EXTRACTFEATURE_FAILED"); 
			break;
		case LastError.NET_ERROR_PHOTO_EXIST: // (0x80000000|1031) 照片已存在
			msg = Res.string().getBundle().getString("NET_ERROR_PHOTO_EXIST"); 
			break;
		case LastError.NET_ERROR_PHOTO_OVERFLOW: // (0x80000000|1032) 照片数量超过上限
			msg = Res.string().getBundle().getString("NET_ERROR_PHOTO_OVERFLOW"); 
			break;
		case LastError.NET_ERROR_CHANNEL_ALREADY_OPENED: // (0x80000000|1033) 通道已经打开
			msg = Res.string().getBundle().getString("NET_ERROR_CHANNEL_ALREADY_OPENED"); 
			break;
		case LastError.NET_ERROR_CREATE_SOCKET: // (0x80000000|1034) 创建套接字失败
			msg = Res.string().getBundle().getString("NET_ERROR_CREATE_SOCKET"); 
			break;
		case LastError.NET_ERROR_CHANNEL_NUM: // (0x80000000|1035) 通道号错误
			msg = Res.string().getBundle().getString("NET_ERROR_CHANNEL_NUM"); 
			break;
		case LastError.NET_ERROR_FACE_RECOGNITION_SERVER_GROUP_ID_EXCEED: // (0x80000000|1051) 组ID超过最大值
			msg = Res.string().getBundle().getString("NET_ERROR_FACE_RECOGNITION_SERVER_GROUP_ID_EXCEED"); 
			break;
		default:
	    	msg = Res.string().getBundle().getString("NET_ERROR");
			break;
		}
		return msg;
	}
				
}
