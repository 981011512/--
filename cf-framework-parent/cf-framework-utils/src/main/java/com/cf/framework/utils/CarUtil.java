package com.cf.framework.utils;

import org.springframework.util.StringUtils;

public class CarUtil {

    public static boolean isCarNo(String carNo) {
//        if (carNo.length() >= 7 && carNo.length() <= 8) {
//            Pattern p = Pattern.compile("^([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[a-zA-Z](([DF]((?![IO])[a-zA-Z0-9](?![IO]))[0-9]{4})|([0-9]{5}[DF]))|[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1})$");
//            Matcher m = p.matcher(carNo);
//            if (!m.matches()) {
//                return false;
//            }
//            return true;
//        } else {
//            return false;
//        }
        if (StringUtils.isEmpty(carNo)) {
            return false;
        } else {
            // #匹配民用车牌和使馆车牌
            //    # 判断标准
            //    # 1，第一位为汉字省份缩写
            //    # 2，第二位为大写字母城市编码
            //    # 3，后面是5位仅含字母和数字的组合
            if (carNo.matches("([京津冀晋蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼川贵云渝藏陕甘青宁新]{1}[A-Z]{1}[0-9a-zA-Z 港澳]{5})")) {
                return true;
            }
//            if (carNo.matches("([京津晋冀蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川贵云藏陕甘青宁新][ABCDEFGHJKLMNPQRSTUVWXY][1-9DF][1-9ABCDEFGHJKLMNPQRSTUVWXYZ]\\d{3}[1-9DF]|[京津晋冀蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川贵云藏陕甘青宁新][ABCDEFGHJKLMNPQRSTUVWXY][\\dABCDEFGHJKLNMxPQRSTUVWXYZ]{5})")) {
//                return true;
//            }
            // 新能源
            if (carNo.matches("[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼 A-Z]{1}[A-Z]{1}(([0-9]{5}[DF])|([DF][A-HJ-NP-Z0-9][0-9]{4}))")) {
                return true;
            }
            boolean isSpecialCar = isSpecialCar(carNo);

            if (isSpecialCar) {
                return isSpecialCar;
            }

            return false;
        }
    }

    /**
     * 是否是特殊车辆
     * @param carNo
     * @return
     */
    public static boolean isSpecialCar(String carNo) {
        if (StringUtils.isEmpty(carNo)) {
            return false;
        }
        // 匹配特种车牌(挂,警,学,领)
        if (carNo.matches("([京津冀晋蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼川贵云渝藏陕甘青宁新]{1}[A-Z]{1}[0-9a-zA-Z]{4}[挂警学领]{1})")) {
            return true;
        }
        // 应急车辆
        if (carNo.matches("([京津冀晋蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼川贵云渝藏陕甘青宁新]{1}[A-Z]{1}[0-9a-zA-Z]{4}[应急]{2})")) {
            return true;
        }
        // 匹配武警车牌
        if (carNo.matches("(^WJ[京津冀晋蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼川贵云渝藏陕甘青宁新]?[0-9a-zA-Z]{5})")) {
            return true;
        }
        // 匹配军牌
        if (carNo.matches("([A-Z]{2}[0-9]{5})")) {
            return true;
        }
        return false;
    }
}
