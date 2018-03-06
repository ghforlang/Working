package jodatime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/3/5 16:26
 */
public class TestTime {


    public static final String[] days = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
    public static final String MM_DD = "MM月dd日";
    public static final String HH_mm = "HH:mm";
    public static void main(String[] args) {
//        Date date = new Date();
//        String result = formatDate(date,MM_DD) + " " + getWeekOfday(date);
//        System.out.println(result);
        System.out.println(getDatePer(new Date(),new Date()));
    }

    public static String getDatePer(Date startTime,Date endTime){
        StringBuffer sb = new StringBuffer(formatDate(startTime,MM_DD));
        sb.append(" ");
        sb.append(getWeekOfday(startTime));
        sb.append(" ");
        sb.append(formatDate(startTime,HH_mm));
        sb.append("-");
        sb.append(formatDate(endTime,HH_mm));
        return sb.toString();
    }


    public static String formatDate(Date date, String pattern) {
        if (null != date) {
            DateFormat dateFomat = new SimpleDateFormat(pattern);
            return dateFomat.format(date);
        }
        return "";
    }

    public static String getWeekOfday(Date date) {
        if (date == null) {
            return "";
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return days[w];
    }
}
