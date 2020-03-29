package concurrent.thread;

public class ThreadJoinDemo2 extends Thread{

    //须等待前一个线程结束之后才继续下一个线程执行
    int i;
    private Thread preThread;

    public ThreadJoinDemo2(int i, Thread preThread) {
        this.i = i;
        this.preThread = preThread;
    }

    @Override
    public void run() {
        try {
            //可注释之后观察效果
            preThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("num : " + i);
    }

    public static void main(String[] args) {
        Thread preThread = Thread.currentThread();
        for(int i=0;i<100 ;i ++){
            ThreadJoinDemo2 thread = new ThreadJoinDemo2(i,preThread);
            thread.start();
            preThread = thread;
        }
    }
}
