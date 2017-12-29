package concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/28 16:58
 */
public class CompletionServiceDemo {

    //CompletionService ： Executor + BlockingQueue

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(11);
        final BlockingQueue<Future<Integer>> queue = new LinkedBlockingDeque<>(10);
        final CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService,queue);

        /**
         * 模拟瞬间产生10个任务，且每个任务执行时间不一致
         */
        for (int i = 0; i < 10; i++)
        {
            completionService.submit(new Callable<Integer>()
            {
                @Override
                public Integer call() throws Exception
                {
                    int ran = new Random().nextInt(1000);
                    Thread.sleep(ran);
                    System.out.println(Thread.currentThread().getName()
                            + " 休息了 " + ran);
                    return ran;
                }
            });
        }

        /**
         * 立即输出结果
         */
        for (int i = 0; i < 10; i++)
        {
            try
            {
                //谁最先执行完成，直接返回
                Future<Integer> f = completionService.take();
                System.out.println(f.get());
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            } catch (ExecutionException e)
            {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }
}
