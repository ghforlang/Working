package util;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-04 18:23
 *  
 */
public class PrintUtils {
    public static void println(Object obj){
        if(obj == null){{
            System.out.println("null\n");
        }}else{
            System.out.println(obj);
        }
    }

    public static void print(Object obj){
        if(obj == null){{
            System.out.print("null\n");
        }}else{
            System.out.print(obj);
        }
    }

    public static void println(){
        System.out.println();
    }
}
