package concurrent.aqs;

import concurrent.SleepUtils;

import java.util.concurrent.locks.Lock;

public class TwinsLockTest {

    public static void main(String[] args) {
        new TwinsLockTest().test();
    }

    public void test(){
        final Lock lock = new TwinsLock();

        class Worker extends Thread{
            @Override
            public void run() {
                while(true){
                    lock.lock();
                    try{
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName() + "执行中!");
                        SleepUtils.second(1);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }

        //起10个守护线程
        for (int i=0;i<10;i++){
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }

        //每隔1s换行
        for(int i=0;i<10;i++){
            SleepUtils.second(1);
            System.out.println();
        }
    }
}
