package com.cf.framework.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期工具类
 *
 * @ClassName DateUtil
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/5/005 20:45
 * @Version 1.0
 **/
public class DateUtil {

    /**
     * 获取当天凌晨起到那时的毫秒数
     * @param timeStamp
     * @return
     */
    public static Long getMillisecondBaseOnTheDay(Long timeStamp) throws Exception
    {
        String dateString = DateUtil.stampToDate(timeStamp, "yyyy-MM-dd");
        return timeStamp-DateUtil.dateToStamp(dateString+" 00:00:00", "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取当天某一时间的时间戳(毫秒)
     * @param millisecondBaseOnTheDay
     * @return
     * @throws Exception
     */
    public static Long MillisecondBaseOnTheDayToTimestamp(Long millisecondBaseOnTheDay)  throws Exception
    {
        String dateString = DateUtil.stampToDate(millisecondBaseOnTheDay, "yyyy-MM-dd");
        return millisecondBaseOnTheDay+DateUtil.dateToStamp(dateString+" 00:00:00", "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取当天某一时间的时间戳(毫秒)
     * @param millisecondBaseOnTheDay 当天的某个时间距离当天凌晨的时间戳
     * @param timeStamp 传入该时间戳的目的是获取该时间戳的年月日
     * @return
     * @throws Exception
     */
    public static Long MillisecondBaseOnTheDayToTimestamp(Long millisecondBaseOnTheDay, Long timeStamp)  throws Exception
    {
        String dateString = DateUtil.stampToDate(timeStamp, "yyyy-MM-dd");
        return millisecondBaseOnTheDay+DateUtil.dateToStamp(dateString+" 00:00:00", "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取当天凌晨0点的时间戳(毫秒)
     * @param timeStamp
     * @return
     * @throws Exception
     */
    public static Long minMillisecondBaseOnTheDayToTimestamp(Long timeStamp)  throws Exception
    {
        String dateString = DateUtil.stampToDate(timeStamp, "yyyy-MM-dd");
        return DateUtil.dateToStamp(dateString+" 00:00:00", "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取当天24点的时间戳(毫秒)
     * @param timeStamp
     * @return
     * @throws Exception
     */
    public static Long maxMillisecondBaseOnTheDayToTimestamp(Long timeStamp)  throws Exception
    {
        String dateString = DateUtil.stampToDate(timeStamp, "yyyy-MM-dd");
        return DateUtil.dateToStamp(dateString+" 23:59:59", "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取当天凌晨或者晚上24点的时间戳
     * @param minOrMax
     * @return
     * @throws Exception
     */
    public static Long getSameDayMinOrMaxTimestamp(String minOrMax)throws Exception
    {
        if(minOrMax.equals("max")){
            String dateString = DateUtil.stampToDate(System.currentTimeMillis(), "yyyy-MM-dd");
            return DateUtil.dateToStamp(dateString+" 23:59:59", "yyyy-MM-dd HH:mm:ss");
        }else{
            String dateString = DateUtil.stampToDate(System.currentTimeMillis(), "yyyy-MM-dd");
            return DateUtil.dateToStamp(dateString+" 00:00:00", "yyyy-MM-dd HH:mm:ss");
        }
    }

    /**
     * 将时间戳转换为时间
     * @param timeStamp
     * @param pattern 格式 例如:yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String stampToDate(Long timeStamp, String pattern)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = new Date(timeStamp);
        return simpleDateFormat.format(date);
    }

    /**
     * 将时间转换为时间戳
     * @param dateString
     * @param pattern 格式 例如:yyyy-MM-dd HH:mm:ss
     * @return
     * @throws ParseException
     */
    public static Long dateToStamp(String dateString, String pattern) throws Exception
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(dateString);
        return date.getTime();
    }

    /**
     * 获取当月开始时间戳
     *
     * @param timeStamp 毫秒级时间戳
     * @param timeZone  如 GMT+8:00
     * @return
     */
    public static Long getMonthStartTime(Long timeStamp, String timeZone) {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        calendar.setTimeInMillis(timeStamp);
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取当月的结束时间戳
     *
     * @param timeStamp 毫秒级时间戳
     * @param timeZone  如 GMT+8:00
     * @return
     */
    public static Long getMonthEndTime(Long timeStamp, String timeZone) {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        calendar.setTimeInMillis(timeStamp);
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));// 获取当前月最后一天
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取当年的开始时间戳
     *
     * @param timeStamp 毫秒级时间戳
     * @param timeZone  如 GMT+8:00
     * @return
     */
    public static Long getYearStartTime(Long timeStamp, String timeZone) {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        calendar.setTimeInMillis(timeStamp);
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.DATE, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取当年的最后时间戳
     *
     * @param timeStamp 毫秒级时间戳
     * @param timeZone  如 GMT+8:00
     * @return
     */
    public static Long getYearEndTime(Long timeStamp, String timeZone) {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        calendar.setTimeInMillis(timeStamp);
        int year = calendar.get(Calendar.YEAR);
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取两个时间戳相差的时间  天/时/分/秒
     * @param timeStamp1
     * @param timeStamp2
     * @return
     */
    public static String getDifferenceByTimeStamp(Long timeStamp1, Long timeStamp2){
        long l = timeStamp2 - timeStamp1;
        String dayStr = "";
        if(l>=86400000){
            dayStr = ((new Double(Math.floor(l/86400000))).intValue())+"天";
        }
        String hourStr = "";
        if(l>=3600000){
            hourStr = ((new Double(Math.floor((l%86400000)/3600000))).intValue())+"时";
        }
        String minStr = "";
        if(l>=600000){
            minStr = ((new Double(Math.floor(((l%86400000)%3600000)/60000))).intValue())+"分";
        }
        String s = ((new Double(Math.floor( (((l%86400000)%3600000)%60000)/1000 ))).intValue())+"秒";
        return dayStr+hourStr+minStr+s;
    }

}
