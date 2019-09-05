package com.hrt.cloud.common.core.util;

import org.springframework.util.ObjectUtils;

import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * @Description: 日期格式化工具类
 * @Author: gradual
 * @Date: 2019-03-19 10:42
 */
public class LocalDateFormatUtil {

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyyMM");
    private static final DateTimeFormatter SHORT_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyMMdd");
    private static final DateTimeFormatter SHORT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyMMddHHmmss");
    private static final DateTimeFormatter DATETIME_FORMATTER =  DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final DateTimeFormatter VIEW_FORMATTER1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter VIEW_FORMATTER2 =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter VIEW_FORMATTER3 = DateTimeFormatter.ofPattern("MM-dd HH:mm");
    private static final DateTimeFormatter VIEW_FORMATTER4 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DEVICE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmsse");

    /**
     * @description: 日期格式化
     *
     * @date: 2019-03-19 10:43
     * @author: gradual
     * @param: [time]
     * @return: java.lang.String
     */
    public static String viewFormat1(LocalDateTime time) {
        if (ObjectUtils.isEmpty(time)) {
            return null;
        }
        return time.format(VIEW_FORMATTER1);
    }

    public static String shortDateFormat(LocalDateTime time) {
        return time.format(SHORT_DATE_FORMATTER);
    }

    public static String viewFormat2(LocalDateTime time) {
        return time.format(VIEW_FORMATTER2);
    }

    public static String viewFormat3(LocalDateTime time) {
        return time.format(VIEW_FORMATTER3);
    }
    public static String viewFormat4(LocalDateTime time) {
        return time.format(VIEW_FORMATTER4);
    }

    public static String deviceFormat(LocalDateTime time) {
        return time.format(DEVICE_TIME_FORMATTER);
    }

    public static LocalDateTime timestamp2LocalDateTime(Long timestamp) {
        if (timestamp == 0) {
            return null;
        }
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), TimeZone
                .getDefault().toZoneId());
    }

    public static LocalDateTime string2LocalDateTime(String str) {
        return LocalDateTime.parse(str, DATETIME_FORMATTER);
    }

    public static boolean timeCompareTo(String time) {
        return LocalDateTime.now().format(TIME_FORMATTER).compareTo(time) >= 0;
    }

    private static final int ONEDAYSECOND = 86400;
    private static final int ONEHOURSECOND = 3600;
    private static final int ONEMINUTESECOND = 60;
    private static final DecimalFormat DF = new DecimalFormat("00");

    /**
     * 整数秒 转 时间字符串
     *
     * @param second
     * @return java.lang.String
     * @author David Hong
     */
    public static String second2Time(int second) {
        if (second <= 0) {
            return "00:00";
        }
        if (second > ONEDAYSECOND) {
            return "一天多";
        }
        int hour = second / ONEHOURSECOND;
        String hourStr = DF.format(hour);
        int minute = second % ONEHOURSECOND / ONEMINUTESECOND;
        String minuteStr = DF.format(minute);
        second = second % ONEHOURSECOND % ONEMINUTESECOND;
        return hourStr + ":" + minuteStr + ":" + DF.format(second);
    }

}
