package concurrent;

public class ThreadStateDemo {

    //interrupted 线程标志位,表示运行中线程是否给其他线程进行了中断操作

    public static void main(String[] args) {
        interrupted();
    }

    private static void interrupted(){
        Thread sleepThread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };


        Thread busyThread = new Thread(){
            @Override
            public void run() {
                while(true);
            }
        };

        sleepThread.start();
        busyThread.start();
        sleepThread.interrupt();;
        busyThread.interrupt();

        //监控sleepThread线程状态，为false时才会往下继续执行
        while(sleepThread.isInterrupted());

        //抛出java.lang.InterruptedException异常，同时清除标志位 ，false
        System.out.println("sleepThread isInterrupted: " + sleepThread.isInterrupted());
        //正常中断操作
        System.out.println("busyThread isInterrupted:" + busyThread.isInterrupted());
    }
}
