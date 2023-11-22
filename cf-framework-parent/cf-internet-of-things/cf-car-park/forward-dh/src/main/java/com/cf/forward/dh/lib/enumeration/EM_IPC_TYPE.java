package com.cf.forward.dh.lib.enumeration;

/**
 * IPC类型
 *
 * @author ： 47040
 * @since ： Created in 2020/12/23 9:46
 */
public enum EM_IPC_TYPE {

    NET_IPC_PRIVATE(0, "私有"),
    NET_IPC_AEBELL(1, "美电贝尔"),
    NET_IPC_PANASONIC(2, "松下"),
    NET_IPC_SONY(3, "索尼"),
    NET_IPC_DYNACOLOR(4, "Dynacolor"),
    NET_IPC_TCWS(5, "天城威视"),
    NET_IPC_SAMSUNG(6, "三星"),
    NET_IPC_YOKO(7, "YOKO"),
    NET_IPC_AXIS(8, "安讯视"),
    NET_IPC_SANYO(9, "三洋"),
    NET_IPC_BOSH(10, "Bosch"),
    NET_IPC_PECLO(11, "Peclo"),
    NET_IPC_PROVIDEO(12, "Provideo"),
    NET_IPC_ACTI(13, "ACTi"),
    NET_IPC_VIVOTEK(14, "Vivotek"),
    NET_IPC_ARECONT(15, "Arecont"),
    NET_IPC_PRIVATEEH(16, "PrivateEH"),
    NET_IPC_IMATEK(17, "IMatek"),
    NET_IPC_SHANY(18, "Shany"),
    NET_IPC_VIDEOTREC(19, "动力盈科"),
    NET_IPC_URA(20, "Ura"),
    NET_IPC_BITICINO(21, "Bticino"),
    NET_IPC_ONVIF(22, "Onvif协议类型"),
    NET_IPC_SHEPHERD(23, "视霸"),
    NET_IPC_YAAN(24, "亚安"),
    NET_IPC_AIRPOINT(25, "Airpop"),
    NET_IPC_TYCO(26, "TYCO"),
    NET_IPC_XUNMEI(27, "讯美"),
    NET_IPC_HIKVISION(28, "海康"),
    NET_IPC_LG(29, "LG"),
    NET_IPC_AOQIMAN(30, "奥奇曼"),
    NET_IPC_BAOKANG(31, "宝康"),
    NET_IPC_WATCHNET(32, "Watchnet"),
    NET_IPC_XVISION(33, "Xvision"),
    NET_IPC_FUSITSU(34, "富士通"),
    NET_IPC_CANON(35, "Canon"),
    NET_IPC_GE(36, "GE"),
    NET_IPC_Basler(37, "巴斯勒"),
    NET_IPC_Patro(38, "帕特罗"),
    NET_IPC_CPKNC(39, "CPPLUS K系列"),
    NET_IPC_CPRNC(40, "CPPLUS R系列"),
    NET_IPC_CPUNC(41, "CPPLUS U系列"),
    NET_IPC_CPPLUS(42, "CPPLUS IPC"),
    NET_IPC_XunmeiS(43, "讯美s,实际协议为Onvif"),
    NET_IPC_GDDW(44, "广东电网"),
    NET_IPC_PSIA(45, "PSIA"),
    NET_IPC_GB2818(46, "GB2818"),
    NET_IPC_GDYX(47, "GDYX"),
    NET_IPC_OTHER(48, "由用户自定义"),
    NET_IPC_CPUNR(49, "CPPLUS NVR"),
    NET_IPC_CPUAR(50, "CPPLUS DVR"),
    NET_IPC_AIRLIVE(51, "Airlive"),
    NET_IPC_NPE(52, "NPE"),
    NET_IPC_AXVIEW(53, "AXVIEW"),
    NET_IPC_DFWL(54, "东方网力"),
    NET_IPC_HYUNDAI(56, "HYUNDAI DVR"),
    NET_IPC_APHD(57, "爱普华顿"),
    NET_IPC_WELLTRANS(58, "微创"),
    NET_IPC_CDJF(59, "成都佳发"),
    NET_IPC_JVC(60, "JVC"),
    NET_IPC_INFINOVA(61, "英飞拓"),
    NET_IPC_ADT(62, "ADT"),
    NET_IPC_SIVIDI(63, "海南创先"),
    NET_IPC_CPUNP(64, "CPPLUS 球机"),
    NET_IPC_HX(65, "海信"),
    NET_IPC_TJGS(66, "天津高速"),
    NET_IPC_MULTICAST(79, "组播"),
    NET_IPC_RVI(84, "RVi"),
    NET_IPC_HONEYWELL(95, "Honeywell");

    private final int value;
    private final String note;

    private EM_IPC_TYPE(int givenValue, String note) {
        this.value = givenValue;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public int getValue() {
        return value;
    }

    public static String getNoteByValue(int givenValue) {
        for (EM_IPC_TYPE enumType : EM_IPC_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_IPC_TYPE enumType : EM_IPC_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_IPC_TYPE getEnum(int value) {
        for (EM_IPC_TYPE e : EM_IPC_TYPE.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_IPC_TYPE.NET_IPC_PRIVATE;
    }
}
