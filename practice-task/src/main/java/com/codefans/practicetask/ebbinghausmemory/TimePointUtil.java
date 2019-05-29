package com.codefans.practicetask.ebbinghausmemory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author: codefans
 * @date: 2019-05-27 15:05:24
 */
public class TimePointUtil {

    private static final String PATTERN_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

    private static final String PATTERN_YYYYMMDD = "yyyy-MM-dd";
    /**
     * 5分钟
     */
    private static final int FIVE_MINUTE = 5;

    /**
     * 30分钟
     */
    private static final int THIRTY_MINUTE = 30;

    /**
     * 12小时
     */
    private static final int TWELVE_HOUR = 12;

    /**
     * 1天
     */
    private static final int ONE_DAY = 1;

    /**
     * 2天
     */
    private static final int TWO_DAY = 2;

    /**
     * 4天
     */
    private static final int FOUR_DAY = 4;

    /**
     * 7天
     */
    private static final int SEVEN_DAY = 7;

    /**
     * 15天
     */
    private static final int FIFTEEN_DAY = 15;

    public static ReviewTimePoint timePointGenerate(Date date) {
        ReviewTimePoint reviewTimePoint = new ReviewTimePoint();
        reviewTimePoint.setFiveMinute(parseYYYYMMDDHHMMSS(addMinutes(date, FIVE_MINUTE)));
        reviewTimePoint.setThirtyMinute(parseYYYYMMDDHHMMSS(addMinutes(date, THIRTY_MINUTE)));
        reviewTimePoint.setTwelveHour(parseYYYYMMDDHHMMSS(addHours(date, TWELVE_HOUR)));
        reviewTimePoint.setOneDay(parseYYYYMMDD(addDays(date, ONE_DAY)));
        reviewTimePoint.setTwoDay(parseYYYYMMDD(addDays(date, TWO_DAY)));
        reviewTimePoint.setFourDay(parseYYYYMMDD(addDays(date, FOUR_DAY)));
        reviewTimePoint.setSevenDay(parseYYYYMMDD(addDays(date, SEVEN_DAY)));
        reviewTimePoint.setFifteenDay(parseYYYYMMDD(addDays(date, FIFTEEN_DAY)));
        return reviewTimePoint;
    }

    public static Date addMinutes(Date date, int minutes) {
        return addTime(date, Calendar.MINUTE, minutes);
    }

    public static Date addHours(Date date, int hours) {
        return addTime(date, Calendar.HOUR_OF_DAY, hours);
    }

    public static Date addDays(Date date, int days) {
        return addTime(date, Calendar.DAY_OF_YEAR, days);
    }

    public static Date addTime(Date date, int type, int value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int oldVal = calendar.get(type);
        calendar.set(type, oldVal + value);
        return calendar.getTime();
    }

    public static String parseYYYYMMDDHHMMSS(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YYYYMMDDHHMMSS);
        return sdf.format(date);
    }

    public static String parseYYYYMMDD(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YYYYMMDD);
        return sdf.format(date);
    }

}
