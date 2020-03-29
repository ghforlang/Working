package concurrent.callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " call is invoking ！");
        return 1;
    }
}
