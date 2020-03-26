import org.joda.time.DateTime;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by fanwenhao on 2017/3/31.
 */
public class TestTime {
    public static void main(String[] args){
//        testCalendar(90);
//        testJoda();
//        testJodaDay(90);
//        testPlusDays();
//        Long time = 1525250900755L;
//        Date dae = new Date(time);
//        System.out.println(dae);
        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println(df.format(0.456));

        DecimalFormat df1 = new DecimalFormat("#.0");
        System.out.println(df1.format(0.45654));
    }

    public static void testTimeStamp(){

    }

    public static void testJoda(){
        DateTime dateTime = new DateTime(2017,1,1,0,0,0);
        System.out.println(dateTime.toString("E MM/dd/yyyy HH:mm:ss.SSS", Locale.US));
    }

    public static void testJodaDay(int day){
        DateTime dateTime = new DateTime(2017,1,1,0,0,0);
        dateTime.plusDays(day);
//        System.out.println(dateTime.toDate());
        System.out.println(dateTime.toString("E MM/dd/yyyy HH:mm:ss.SSS", Locale.US));
    }

    public static void testPlusDays(){
        DateTime dateTime = new DateTime(2017,1,1,0,0,0);
        System.out.println(dateTime.plusDays(45).plusMonths(0).dayOfWeek().withMaximumValue().toString("E MM/dd/yyyy HH:mm:ss.SSS"));
    }

    public static void testPlusHours(){
        System.out.println("start");
    }


    public static void testCalendar(int day){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017,Calendar.JANUARY,1,0,0,0);
        SimpleDateFormat sdf = new SimpleDateFormat("E MM/dd/yyyy HH:mm:ss.SSS");
        calendar.add(Calendar.DAY_OF_MONTH,day);
        String date = sdf.format(calendar.getTime());
        System.out.println(date);
    }

}
