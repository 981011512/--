package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 设备类型
 * @date 2020/9/12
 */
public enum EMDeviceType {
    /**
     * none
     */
    NET_PRODUCT_NONE(0, "未知"),
    /**
     * 非实时MACE
     */
    NET_DVR_NONREALTIME_MACE(1, "非实时MACE"),
    /**
     * 非实时
     */
    NET_DVR_NONREALTIME(2, "非实时"),
    /**
     * 网络视频服务器
     */
    NET_NVS_MPEG1(3, "网络视频服务器"),
    /**
     * MPEG1二路录像机
     */
    NET_DVR_MPEG1_2(4, "MPEG1二路录像机"),
    /**
     * MPEG1八路录像机
     */
    NET_DVR_MPEG1_8(5, "MPEG1八路录像机"),
    /**
     * MPEG4八路录像机
     */
    NET_DVR_MPEG4_8(6, "MPEG4八路录像机"),
    /**
     * MPEG4十六路录像机
     */
    NET_DVR_MPEG4_16(7, "MPEG4十六路录像机"),
    /**
     * LB系列录像机
     */
    NET_DVR_MPEG4_SX2(8, "LB系列录像机"),
    /**
     * GB系列录像机
     */
    NET_DVR_MEPG4_ST2(9, "GB系列录像机"),
    /**
     * HB系列录像机
     */
    NET_DVR_MEPG4_SH2(10, "HB系列录像机"),
    /**
     * GBE系列录像机
     */
    NET_DVR_MPEG4_GBE(11, "GBE系列录像机"),
    /**
     * II代网络视频服务器
     */
    NET_DVR_MPEG4_NVSII(12, "II代网络视频服务器"),
    /**
     * 新标准配置协议
     */
    NET_DVR_STD_NEW(13, "新标准配置协议"),
    /**
     * DDNS服务器
     */
    NET_DVR_DDNS(14, "DDNS服务器"),
    /**
     * ATM机
     */
    NET_DVR_ATM(15, "ATM机"),
    /**
     * 二代非实时NB系列机器
     */
    NET_NB_SERIAL(16, "二代非实时NB系列机器"),
    /**
     * LN系列产品
     */
    NET_LN_SERIAL(17, "LN系列产品"),
    /**
     * BAV系列产品
     */
    NET_BAV_SERIAL(18, "BAV系列产品"),
    /**
     * SDIP系列产品
     */
    NET_SDIP_SERIAL(19, "SDIP系列产品"),
    /**
     * IPC系列产品
     */
    NET_IPC_SERIAL(20, "IPC系列产品"),
    /**
     * NVS B系列
     */
    NET_NVS_B(21, "NVS B系列"),
    /**
     * NVS H系列
     */
    NET_NVS_C(22, "NVS H系列"),
    /**
     * NVS S系列
     */
    NET_NVS_S(23, "NVS S系列"),
    /**
     * NVS E系列
     */
    NET_NVS_E(24, "NVS E系列"),
    /**
     * 从QueryDevState中查询设备类型,以字符串格式
     */
    NET_DVR_NEW_PROTOCOL(25, "从QueryDevState中查询设备类型,以字符串格式"),
    /**
     * 解码器
     */
    NET_NVD_SERIAL(26, "解码器"),
    /**
     * N5
     */
    NET_DVR_N5(27, "N5"),
    /**
     * 混合DVR
     */
    NET_DVR_MIX_DVR(28, "混合DVR"),
    /**
     * SVR系列
     */
    NET_SVR_SERIAL(29, "SVR系列"),
    /**
     * SVR-BS
     */
    NET_SVR_BS(30, "SVR-BS"),
    /**
     * NVR系列
     */
    NET_NVR_SERIAL(31, "NVR系列"),
    /**
     * N51
     */
    NET_DVR_N51(32, "N51"),
    /**
     * ITSE 智能分析盒
     */
    NET_ITSE_SERIAL(33, "ITSE 智能分析盒"),
    /**
     * 智能交通像机设备
     */
    NET_ITC_SERIAL(34, "智能交通像机设备"),
    /**
     * 雷达测速仪HWS
     */
    NET_HWS_SERIAL(35, "雷达测速仪HWS"),
    /**
     * 便携式音视频录像机
     */
    NET_PVR_SERIAL(36, "便携式音视频录像机"),
    /**
     * IVS（智能视频服务器系列）
     */
    NET_IVS_SERIAL(37, "IVS（智能视频服务器系列）"),
    /**
     * 通用智能视频侦测服务器
     */
    NET_IVS_B(38, "通用智能视频侦测服务器"),
    /**
     * 人脸识别服务器
     */
    NET_IVS_F(39, "人脸识别服务器"),
    /**
     * 视频质量诊断服务器
     */
    NET_IVS_V(40, "视频质量诊断服务器"),
    /**
     * 矩阵
     */
    NET_MATRIX_SERIAL(41, "矩阵"),
    /**
     * N52
     */
    NET_DVR_N52(42, "N52"),
    /**
     * N56
     */
    NET_DVR_N56(43, "N56"),
    /**
     * ESS
     */
    NET_ESS_SERIAL(44, "ESS"),
    /**
     * 人数统计服务器
     */
    NET_IVS_PC(45, "人数统计服务器"),
    /**
     * pc-nvr
     */
    NET_PC_NVR(46, "pc-nvr"),
    /**
     * 大屏控制器
     */
    NET_DSCON(47, "大屏控制器"),
    /**
     * 网络视频存储服务器
     */
    NET_EVS(48, "网络视频存储服务器"),
    /**
     * 嵌入式智能分析视频系统
     */
    NET_EIVS(49, "嵌入式智能分析视频系统"),
    /**
     * DVR-N6
     */
    NET_DVR_N6(50, "DVR-N6"),
    /**
     * 万能解码器
     */
    NET_UDS(51, "万能解码器"),
    /**
     * 银行报警主机
     */
    NET_AF6016(52, "银行报警主机"),
    /**
     * 视频网络报警主机
     */
    NET_AS5008(53, "视频网络报警主机"),
    /**
     * 网络报警主机
     */
    NET_AH2008(54, "网络报警主机"),
    /**
     * 报警主机系列
     */
    NET_A_SERIAL(55, "报警主机系列"),
    /**
     * 门禁系列产品
     */
    NET_BSC_SERIAL(56, "门禁系列产品"),
    /**
     * NVS系列产品
     */
    NET_NVS_SERIAL(57, "NVS系列产品"),
    /**
     * VTO系列产品
     */
    NET_VTO_SERIAL(58, "VTO系列产品"),
    /**
     * VTNC系列产品
     */
    NET_VTNC_SERIAL(59, "VTNC系列产品"),
    /**
     * TPC系列产品(热成像设备)
     */
    NET_TPC_SERIAL(60, "TPC系列产品(热成像设备)"),
    /**
     * 无线中继设备
     */
    NET_ASM_SERIAL(61, "无线中继设备"),
    /**
     * 管理机
     */
    NET_VTS_SERIAL(62, "管理机");

    private EMDeviceType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    private int type;
    private String desc;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static EMDeviceType getEMDeviceType(int type) {
        for (EMDeviceType deviceType : EMDeviceType.values()) {
            if (deviceType.getType() == type) {
                return deviceType;
            }
        }
        return null;
    }
}
