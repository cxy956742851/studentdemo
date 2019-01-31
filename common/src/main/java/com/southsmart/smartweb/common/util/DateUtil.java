package com.southsmart.smartweb.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 韦锦超
 * @version 20160601
 * 
 */
public class DateUtil {
    /**
     * 默认日期格式
     */
    public static String DEFAULT_FORMAT = "yyyy-MM-dd";
    
    /**
     * 格式化日期
     * 
     * @param date 日期对象
     * @return String 日期字符串
     */
    public static String formatDate(Date date) {
        SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT);
        String sDate = f.format(date);
        return sDate;
    }
    
    /**
     * 格式化日期
     * 
     * @param date 日期对象
     * @return String 日期字符串
     */
    public static String formatDate(Date date, String format) {
        SimpleDateFormat f = null;
        if (format == null) {
            f = new SimpleDateFormat(DEFAULT_FORMAT);
        } else {
            f = new SimpleDateFormat(format);
        }
        
        String sDate = f.format(date);
        return sDate;
    }
    
    public static String formatDate(String date, String format) {
        SimpleDateFormat f = null;
        if (format == null) {
            f = new SimpleDateFormat(DEFAULT_FORMAT);
        } else {
            f = new SimpleDateFormat(format);
        }
        
        String sDate = f.format(ConvertStringToDate(date, "yyyyMMdd", false));
        return sDate;
    }
    
    /**
     * 获取当前系统时间
     * 
     * @return
     */
    public static Date getCurrTime() {
        Calendar currCal = Calendar.getInstance();
        return currCal.getTime();
    }
    
    /**
     * 获取当前年份的字符串
     * 
     * @return
     */
    public static String getCurrYear() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return String.valueOf(currentYear);
    }
    
    /**
     * 获取当年的第一天
     * 
     * @param year
     * @return
     */
    public static Date getCurrYearFirst() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }
    
    /**
     * 获取当年的最后一天
     * 
     * @param year
     * @return
     */
    public static Date getCurrYearLast() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }
    
    /**
     * 获取某年第一天日期
     * 
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }
    
    /**
     * 获取某年最后一天日期
     * 
     * @param year 年份
     * @return Date
     */
    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
        
        return currYearLast;
    }
    
    /**
     * 获取当前月的第一天，即一号的日期
     * 
     * @param currentDate
     * @return
     */
    public static String getMonthFirst(String currentDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ConvertStringToDate(currentDate, "yyyyMMdd", false));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime().toString();
    }
    
    /**
     * 获取当前月的最后一天的日期
     * 
     * @param currentDate
     * @return
     */
    public static String getMonthLast(String currentDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ConvertStringToDate(currentDate, "yyyyMMdd", false));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime().toString();
    }
    
    /**
     * 字符类型转换为日期，转换失败暂时返回null
     * 
     * @param strDate 字符类型的日期
     * @param format 日期格式，支持“date”为年月日，“time”为年月日时分秒
     * @param bDefault 如果传入为空或异常时，是否采用当前时间作为默认时间
     * @return 格式的日期或时间
     */
    public static Date ConvertStringToDate(String strDate, String format, Boolean bDefault) {
        if (strDate == null || strDate == "") {
            if (bDefault == true) {
                return null;
            } else {
                return null;
            }
        }
        if (format == "date") {
            format = "yyyy-MM-dd";
        } else if (format == "time") {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            date = sdf.parse(strDate);
        } catch (Exception e) {
            return null;
        }
        return date;
    }
    
    /**
     * 根据时间获取月份的序数
     * 
     * @param date
     * @return
     */
    public static int GetMonthNumFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }
    
    /**
     * 根据时间获取一个月当中第几天
     * 
     * @param date
     * @return
     */
    public static int GetDayNumOfMonthFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
    
    /**
     * 根据时间获取一周当中第几天
     * 
     * @param date
     * @return
     */
    public static String GetDayNumOfweekFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String value = null;
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                value = "星期日";
                break;
            case 2:
                value = "星期一";
                break;
            case 3:
                value = "星期二";
                break;
            case 4:
                value = "星期三";
                break;
            case 5:
                value = "星期四";
                break;
            case 6:
                value = "星期五";
                break;
            case 7:
                value = "星期六";
                break;
            
            default:
                break;
        }
        return value;
    }
    
    /**
     * 
     * @param s_date 如："201605"
     * @param format 如："yyyyMM"
     * @return
     * @throws ParseException
     */
    public static Date[] getMonthDayGap(String s_date, String format)
        throws ParseException {
        DateFormat df = new SimpleDateFormat(format);
        Date d_date = df.parse(s_date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d_date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        Date start = cal.getTime();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date end = cal.getTime();
        Date[] dates = {start, end};
        return dates;
    }
    
    public static String getYear(String year, int amount)
        throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        Date end = format.parse(year);
        Calendar cal = Calendar.getInstance();
        cal.setTime(end);
        cal.add(Calendar.YEAR, amount);
        Date start = cal.getTime();
        String strStart = format.format(start);
        return strStart;
    }
    
    /**
     * 获取给定月份amount个月之前/之后的月份
     * 
     * @param month 格式为yyyyMM
     * @param amount 正值表示之后，负值表示之前
     * @return 月份，格式为yyyyMM
     * @throws ParseException
     */
    public static String getMonth(String month, int amount)
        throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        Date end = format.parse(month);
        Calendar cal = Calendar.getInstance();
        cal.setTime(end);
        cal.add(Calendar.MONTH, amount);
        Date start = cal.getTime();
        String strStart = format.format(start);
        return strStart;
    }
    
    public static String getMonthday(String month, int amount)
        throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MMdd");
        Date end = format.parse(month);
        Calendar cal = Calendar.getInstance();
        cal.setTime(end);
        cal.add(Calendar.MONTH, amount);
        Date start = cal.getTime();
        String strStart = format.format(start);
        return strStart;
    }
    
    /**
     * 获取给定月份amount个月之前/之后的月份
     * 
     * @param month 格式为yyyyMMdd
     * @param amount 正值表示之后，负值表示之前
     * @return 月份，格式为yyyyMMdd
     * @throws ParseException
     */
    public static String getDay(String day, int amount)
        throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date end = format.parse(day);
        Calendar cal = Calendar.getInstance();
        cal.setTime(end);
        cal.add(Calendar.DATE, amount);
        Date start = cal.getTime();
        String strStart = format.format(start);
        return strStart;
    }
    
    public static String getFirstDateOfWeek(Date date, int amout) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.setFirstDayOfWeek(Calendar.MONDAY);//将每周第一天设为星期一，默认是星期天
        cal.add(Calendar.DATE, amout * 7);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        String monday = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
        return monday;
    }
    
    public static String getLastDateOfWeek(Date date, int amout) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.setFirstDayOfWeek(Calendar.MONDAY);//将每周第一天设为星期一，默认是星期天
        cal.add(Calendar.DATE, amout * 7);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        String sunday = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
        return sunday;
    }
    
    public static void main(String[] args)
        throws ParseException {
        
    }
    
}
