package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description \if ENGLISH_LANG
 * <p>
 * \else
 * 太阳能系统故障信息
 * \endif
 * @date 2020/8/11
 */
public enum EM_SOLARCELL_SYSTEM_FAULT_TYPE {

    /**
     * 未知
     */
    EM_SOLARCELL_SYSTEM_FAULT_TYPE_UNKNOWN(0, "未知"),
    /**
     * 电池过放
     */
    EM_SOLARCELL_SYSTEM_FAULT_TYPE_BATTERY_OVER_DISCHARGE(1, "电池过放"),
    /**
     * 电池施压
     */
    EM_SOLARCELL_SYSTEM_FAULT_TYPE_BATTERY_OVERPRESSURE(2, "电池施压"),
    /**
     * 欠压警告
     */
    EM_SOLARCELL_SYSTEM_FAULT_TYPE_UNDERVOLTAGE_WARNING(3, "欠压警告"),
    /**
     * 负载短路
     */
    EM_SOLARCELL_SYSTEM_FAULT_TYPE_LOAD_SHORT_CIRCUIT(4, "负载短路"),
    /**
     * 负载功率过大或负载过流
     */
    EM_SOLARCELL_SYSTEM_FAULT_TYPE_EXCESSIVE_LOAD_POWER_OR_LOAD_OVER_CURRENT(5, "负载功率过大或负载过流"),
    /**
     * 控制器温度过高
     */
    EM_SOLARCELL_SYSTEM_FAULT_TYPE_CONTROLLER_TEMPERATURE_IS_TOO_HIGH(6, "控制器温度过高"),
    /**
     * 外部环境温度过高
     */
    EM_SOLARCELL_SYSTEM_FAULT_TYPE_EXTERNAL_AMBIENT_TEMPERATURE_IS_TOO_HIGH(7, "外部环境温度过高"),
    /**
     * 光伏输入功率过大
     */
    EM_SOLARCELL_SYSTEM_FAULT_TYPE_EXCESSIVE_PHOTOVOLTAIC_INPUT_POWER(8, "光伏输入功率过大"),
    /**
     * 光伏输入短路
     */
    EM_SOLARCELL_SYSTEM_FAULT_TYPE_PHOTOVOLTAIC_INPUT_SHORT_CIRCUIT(9, "光伏输入短路"),
    /**
     * 光伏输入端超压
     */
    EM_SOLARCELL_SYSTEM_FAULT_TYPE_PHOTOVOLTAIC_INPUT_TERMINAL_OVERPRESSURE(10, "光伏输入端超压"),
    /**
     * 太阳板逆流
     */
    EM_SOLARCELL_SYSTEM_FAULT_TYPE_PHOTOVOLTAIC_SOLAR_PLATE_COUNTERCURRENT(11, "太阳板逆流"),
    /**
     * 太阳板工作点超压
     */
    EM_SOLARCELL_SYSTEM_FAULT_TYPE_OVERPRESSURE_AT_WORKING_POINT_OF_SOLAR_PANEL(12, "太阳板工作点超压"),
    /**
     * 太阳板反接
     */
    EM_SOLARCELL_SYSTEM_FAULT_TYPE_REVERSE_CONNECTION_OF_SOLAR_PANEL(13, "太阳板反接"),
    /**
     * Anti-reverse MOS short
     */
    EM_SOLARCELL_SYSTEM_FAULT_TYPE_ANTI_REVERSE_MOS_SHORT(14, "Anti-reverse MOS short"),
    /**
     * Circuit,charge MOS short circui
     */
    EM_SOLARCELL_SYSTEM_FAULT_TYPE_ANTI_CIRCUIT_CHARGE_MOS_SHORT_CIRCUI(15, "Circuit,charge MOS short circui");
    private int type;
    private String info;

    private EM_SOLARCELL_SYSTEM_FAULT_TYPE(int type, String info) {
        this.type = type;
        this.info = info;
    }

    public int getType() {
        return type;
    }

    public String getInfo() {
        return info;
    }

    public static EM_SOLARCELL_SYSTEM_FAULT_TYPE getSolarcellFaultType(int type) {
        for (EM_SOLARCELL_SYSTEM_FAULT_TYPE faultType : EM_SOLARCELL_SYSTEM_FAULT_TYPE.values()) {
            if (faultType.getType() == type) {
                return faultType;
            }
        }
        return null;
    }
}
