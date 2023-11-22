package com.cf.forward.hk.web.domain;

public class BreakRulesType {

    public static String getBreakRulesType( short rulesType ) {


        if(1349 <= rulesType && rulesType <=1728 && rulesType !=1357){
            return "超速行驶";
        }else
        if(1018<= rulesType && rulesType <=1625){

            switch (rulesType){
                case 1018:
                    return "占用非机动车道";
                case 1019:
                    return "占用专用车道";
                case 1039:
                    return "城市违停";
                case 1208:
                    return "不按导向车道行驶";
                case 1211:
                    return "路口停车";
                case 1228:
                    return "路口滞留";
                case 1240:
                    return "未系安全带";
                case 1301:
                    return "逆行";
                case 1344:
                    return "违反禁令标志";
                case 1357:
                    return "未礼让行人";
                case 1625:
                    return "违反信号灯";
            }
        }else {

            switch (rulesType){
                case 4613:
                    return "高速路违停";
                case 4615:
                    return "不按规定行驶";
                case 13451:
                    return "压线";
                case 13453:
                    return "违法变道";
                case 16251:
                    return "绿灯停车";
                case 4016:
                    return "低速行驶";
                case  4306:
                    return "低速行驶";
                case 6046:
                    return "超速行驶";
                case 6047:
                    return "超速行驶";
                case 6048:
                    return "超速行驶";
                case  6050:
                    return "超速行驶";
            }
        }
        return "未检测到违章";
    }

}
