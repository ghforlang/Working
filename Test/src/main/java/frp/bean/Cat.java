package frp.bean;

import com.google.zxing.BinaryBitmap;

import java.io.Serializable;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/2/26 16:44
 */
public class Cat implements Comparable<Cat> {

    BinaryBitmap image;
    int cuteness;


    @Override
    public int compareTo(Cat o) {
        return Integer.compare(cuteness,o.cuteness);
    }
}
