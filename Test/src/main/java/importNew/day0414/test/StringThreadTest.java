package importNew.day0414.test;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-04-14 13:37
 *  
 */
public class StringThreadTest {
    public static void main(String[] args){
        Thread[] threads = new Thread[5];
        for(int i=0;i<5;i++){
            threads[i] = new Thread(new StringThread("192.168.1.1"));
        }

        for(int i=0;i<5;i++){
            threads[i].start();
        }
    }


}
