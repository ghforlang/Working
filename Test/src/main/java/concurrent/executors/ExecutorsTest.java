package concurrent.executors;

import concurrent.runnable.MyRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MyRunnable runnable = new MyRunnable();
        for(int i=0;i<5 ; i++){
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }

}
