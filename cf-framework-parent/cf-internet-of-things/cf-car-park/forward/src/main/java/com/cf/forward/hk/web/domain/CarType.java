package com.cf.forward.hk.web.domain;

public class CarType {

    public static String getCarType( String carType ) {
        switch (carType) {
            case "0":
                return "未知";
            case "1":
                return "客车";
            case "2":
                return "货车";
            case "3":
                return "轿车";
            case "4":
                return "面包车";
            case "5":
                return "小货车";
            case "6":
                return "行人";
            case "7":
                return "二轮车";
            case "8":
                return "三轮车";
            case "9":
                return "SUV";
            case "10":
                return "中型课车";
            case "11":
                return "机动车";
            case "12":
                return "非机动车";
            case "13":
                return "小型轿车";
            case "14":
                return "微型轿车";
            case "15":
                return "皮卡车";
            case "16":
                return "集装箱卡车";
            case "17":
                return "微卡";
            case "18":
                return "渣土车";
            case "19":
                return "吊车，工程车";
            case "20":
                return "油罐车";
            case "21":
                return "混凝土搅拌车";
            case "22":
                return "平板拖车";
            case "23":
                return "两厢轿车";
            case "24":
                return "三厢轿车";
            case "25":
                return "轿跑";
            case "26":
                return "小型客车";
            default:
                return null;
        }
    }
}
