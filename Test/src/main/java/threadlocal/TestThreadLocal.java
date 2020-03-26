package threadlocal;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/5/8 11:02
 */
public class TestThreadLocal {
    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        new TestCaseOne().caseOneTest();
//        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor();
    }

    private static void baseTest(){
        Thread thread =  new Thread(new Runnable(){
            @Override
            public void run() {

            }
        });
        thread.start();
    }

}
