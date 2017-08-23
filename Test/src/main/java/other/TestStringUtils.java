package other;

import org.apache.commons.lang.StringUtils;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-08-23 16:45
 *  
 */
public class TestStringUtils {
    public static void main(String[] args) {
        String[] str = {
                "a",
                "abc,aaa",
                "a x , b"
        };

        for(String s : str){
            String[] subStr = StringUtils.split(s,",");
            for(String ss : subStr){
                System.out.print(ss + "|");
            }
            System.out.println();
        }
    }
}
