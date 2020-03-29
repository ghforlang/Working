package concurrent.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyCallable());
        Thread t1 = new Thread(futureTask);

        t1.start();
        try {
            Thread.sleep(1000L);
            System.out.println("返回结果：" + futureTask.get());
        }catch (ExecutionException e){
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main方法执行完成!");
    }
}
