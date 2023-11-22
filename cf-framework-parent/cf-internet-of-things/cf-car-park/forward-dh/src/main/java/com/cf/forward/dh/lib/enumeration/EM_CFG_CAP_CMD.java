package com.cf.forward.dh.lib.enumeration;

/**
 * 命令类型,对应QueryNewSystemInfo接口
 */
public enum EM_CFG_CAP_CMD {
    /**
     * 获取设备状态信息 (对应 CFG_CAP_TRAFFIC_DEVICE_STATUS)
     */
    CFG_CAP_CMD_DEVICE_STATE("trafficSnap.getDeviceStatus"),
    /**
     * 获取查询记录能力集, (对应结构体 CFG_CAP_RECORDFINDER_INFO)
     */
    CFG_CAP_CMD_RECORDFINDER("RecordFinder.getCaps"),
    /**
     *获取视频诊断进行状态(CFG_VIDEODIAGNOSIS_STATE_INFO)
     */
    CFG_CMD_VIDEODIAGNOSIS_GETSTATE("videoDiagnosisServer.getState"),
    /**
     * 获取云台支持信息(CFG_CAP_PTZ_ENABLEINFO)
     */
    CFG_CAP_CMD_PTZ_ENABLE("ptz.factory.instance");
    /**
     * 获取门禁能力集,对应结构体CFG_CAP_ACCESSCONTROL
     */
    public static final String CFG_CAP_CMD_ACCESSCONTROLMANAGER="accessControlManager.getCaps";
    private String cmd;
    EM_CFG_CAP_CMD(String cmd){
        this.cmd=cmd;
    }

    public String getCmd() {
        return cmd;
    }
}
