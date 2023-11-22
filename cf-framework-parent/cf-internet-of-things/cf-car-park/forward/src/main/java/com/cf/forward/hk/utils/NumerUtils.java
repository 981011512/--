package com.cf.forward.hk.utils;

/**
 * @author why
 */
public class NumerUtils {


    /**
     * 判断传入来的字符串是否是数字字符串
     * @param str
     * @return
     */
    public static boolean isNumeric(final String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException ex) {
                try {
                    Float.parseFloat(str);
                    return true;
                } catch (NumberFormatException exx) {
                    return false;
                }
            }
        }
    }


}
