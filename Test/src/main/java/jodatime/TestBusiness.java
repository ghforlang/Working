package jodatime;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Duration;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/11/24 16:13
 */
public class TestBusiness {

    public static void main(String[] args) {
//        secondDiff();
        System.out.println(strNumCompose("12s","w134"));
    }

    private static void secondDiff(){
        DateTime begin = new DateTime();
        System.out.println(begin);
        DateTime end = begin.plusDays(1).withTimeAtStartOfDay().withTime(2,0,0,0);
        System.out.println(end);
        //计算区间毫秒数
        Duration d = new Duration(begin, end);
        long time = d.getMillis();
        System.out.println(time);
    }

    private static String strNumCompose(String srcVal,String desVal){
        Long srcValue = 0L;
        Long desValue = 0L;
        if(StringUtils.isNumeric(srcVal)){
            srcValue = Long.valueOf(srcVal);
        }
        if(StringUtils.isNumeric(desVal)){
            desValue = srcValue + Long.valueOf(desVal);
        }

        return String.valueOf(desValue);
    }
}
