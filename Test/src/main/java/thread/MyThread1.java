package thread;


import biz.Singleton;

/**
 * 测试线程1
 *
 * @author fanwh
 * @create 2017-03-31 16:04
 **/
public class MyThread1 implements Runnable {
    private Singleton singleton;

    public void run() {
        singleton = Singleton.getInstance();
    }

}
