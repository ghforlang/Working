package util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/10/24 17:54
 */
public class JodaTimeUtils {
    private static final String test_time = "2018年06月";
    private static final String date_time_format = "yyyy年MM月";
    private static final String UTC_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    private static final String utc_time = "2010-12-1T11:22:33.567Z";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static void main(String[] args) {
        System.out.println(getMonthStartTime(test_time));
        System.out.println("utcDate to dateLong : " + convertUTC2Date(utc_time));
        System.out.println("time start of month : " + date2UTCString(getMonthStartTime(test_time)));
        System.out.println("time end of month : " + date2UTCString(getMonthEndTime(test_time)));
        System.out.println("time of start : " + getMonthStartTimeCN(test_time));
        System.out.println("time of end : " + getMonthEndTimeCN(test_time));
    }

    public static Long getMonthStartTime(String dateTime){
        DateTime date = DateTime.parse(test_time,DateTimeFormat.forPattern(date_time_format));
        System.out.println(date.toLocalDateTime());
        return date.toLocalDateTime().toDate().getTime();
    }

    public static String getMonthStartTimeCN(String dateTime){
        LocalDateTime localDateTime = LocalDateTime.fromDateFields(new Date(getMonthStartTime(dateTime)));
        return localDateTime.toString(DateTimeFormat.forPattern(YYYY_MM_DD));
    }

    public static String getMonthEndTimeCN(String dateTime){
        LocalDateTime localDateTime = LocalDateTime.fromDateFields(new Date(getMonthEndTime(dateTime)));
        return localDateTime.toString(DateTimeFormat.forPattern(YYYY_MM_DD));
    }

    public static Long getMonthEndTime(String dateTime){
        DateTime date = DateTime.parse(test_time,DateTimeFormat.forPattern(date_time_format));
        int month = date.dayOfMonth().getMaximumValue();
        date = date.plusDays(month - 1);
        return date.toLocalDateTime().toDate().getTime();
    }

    public static long convertUTC2Date(String utcDate){
        DateTime dateTime = DateTime.parse(utcDate, DateTimeFormat.forPattern(UTC_TIME_FORMAT));
        return dateTime.toDate().getTime();
    }

    public static String date2UTCString(Long date){
        DateTime dateTime = new DateTime(date, DateTimeZone.UTC);
        return dateTime.toString();

    }

}
