package concurrent.thread;

public class WaitTest {
    private static  Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {
        //标准使用wait、nofity方法的代码
        synchronized (monitor){
            //判断条件是否得到满足
            while(true){
                //等待唤醒
                monitor.wait();
            }
            //处理其他业务逻辑
        }
    }
}
