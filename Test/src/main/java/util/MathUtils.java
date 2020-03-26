package util;

import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 *
 * @author fanwenhao
 * @version V1.0
 * @since 2018-12-05 17:26
 */
public class MathUtils {

    public static void main(String[] args) {
//        float v = 0.06f;
//        BigDecimal bg = new BigDecimal(v);
//        System.out.println(bg.setScale(3,RoundingMode.FLOOR).doubleValue());
//
//
//        DecimalFormat df = new DecimalFormat("#0.00");
//        System.out.println(Double.parseDouble(df.format(v)));;

//        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
//        double doubleSimilar = 0.266f;
//        for (int i = 0; i < 200; i++) {
//            doubleSimilar += 0.01f;
//            System.out.println(to2bit(doubleSimilar));
//        }

    }

    private static double to2bit(double d){
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setRoundingMode(RoundingMode.FLOOR);
        String numStr = nf.format(d);
        return Double.parseDouble(numStr);
    }


    public void test() {
        //        System.out.println(doubleSimilar);
        //        String similar = decimalFormat.format(doubleSimilar);
        //        int index = similar.indexOf(".");
        //        if(similar.length() - index > 2){
        //            similar = similar.substring(0,index+3);
        //        }
        //        doubleSimilar = Double.parseDouble(similar) + 0.01;
    }
}

