package com.codefans.basicjava.util;

import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.FastDateFormat;

import java.text.ParseException;
import java.util.Date;

/**
 * @author: codefans
 * @date: 2018-06-21 15:00
 */
public class CommonsDateUtils {

    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final String PATTERN_MILLISECOND = "yyyy-MM-dd HH:mm:ss:SSS";

    public static FastDateFormat fdf = FastDateFormat.getInstance(PATTERN);

    public static FastDateFormat fdfMillisecond = FastDateFormat.getInstance(PATTERN_MILLISECOND);

    public static String format(Date date) {
        return fdf.format(date);
    }

    public static String formatMilliecond(Date date) {
        return fdfMillisecond.format(date);
    }

    public static Date parse(String dateStr) throws ParseException {
        return DateUtils.parseDate(dateStr, new String[]{PATTERN, PATTERN_MILLISECOND});
    }

}
