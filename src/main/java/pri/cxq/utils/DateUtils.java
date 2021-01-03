package pri.cxq.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtils {

    /**
     * 获取当前时间(毫秒数)
     * getTime() 返回自1970年1月1日以来，由此 Date对象表示的00:00:00 GMT的毫秒 数
     * @return
     */
    public static long getDateTime(){
        Date date = new Date();
        long time = date.getTime();
        return time;
    }
    /**
     * 通过毫秒数获取date对象
     * @param
     */
    public static Date getDate(long dateTime){
        Date date = new Date(dateTime);
        return date;
    }
    /**
     * 通过毫秒数获取时间字符串
     * @param dateTime
     * @param pattern
     * @return
     */
    public static  String formatDate(long dateTime,String pattern){
        Date date = new Date(dateTime);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
    /**
     * 通过毫秒数获取时间字符串
     * @param dateTime
     * @param pattern
     * @return
     */
    public static  String formatDate(Date dateTime,String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(dateTime);
    }

    /**
     * 通过年月日获得date对象
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date parseDate(String year,String month,String day) {
        Date date = null;
        date = new Date(Integer.valueOf(year)-1900,Integer.valueOf(month)-1,Integer.valueOf(day));
        return date;
    }
}
