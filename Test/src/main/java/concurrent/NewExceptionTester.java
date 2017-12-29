package concurrent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/28 17:28
 */
public class NewExceptionTester {
    private static final int             LOOP                 = 10000000;                        // 单次循环数量
    private static final int             THREADS              = 10;                              // 并发线程数量
    private static final List<Long>      newObjectTimes       = new ArrayList<>(THREADS);
    private static final List<Long>      newExceptionTimes    = new ArrayList<>(THREADS);
    private static final List<Long>      newExtExceptionTimes = new ArrayList<>(THREADS);
    private static final ExecutorService POOL                 = Executors.newFixedThreadPool(30);

    public static void main(String[] args) throws Exception{
        List<Callable<Boolean>> all = new ArrayList<>();
        all.addAll(tasks(new NewObject()));
        all.addAll(tasks(new NewException()));
        all.addAll(tasks(new NewExtException()));

        POOL.invokeAll(all);

        System.out.println("o:\t\t" + total(newObjectTimes));
        System.out.println("e:\t\t" + total(newExceptionTimes));
        System.out.println("exte:\t\t" + total(newExtExceptionTimes));

        POOL.shutdown();
    }

    private static List<Callable<Boolean>> tasks(Callable<Boolean> c){
        List<Callable<Boolean>> list = new ArrayList<>(THREADS);
        for(int i=0;i<THREADS;i++){
            list.add(c);
        }
        return list;
    }

    private static long total(List<Long> list){
        long sum = 0L;
        for(Long v : list){
            sum += v;
        }
        return sum;
    }

    public static class NewObject implements Callable<Boolean>{
        @Override
        public Boolean call() throws Exception {
            long start = System.currentTimeMillis();
            for(int i=0;i<LOOP;i++){
                new CustomObject("");
            }
            newObjectTimes.add(System.currentTimeMillis() - start);
            return true;
        }
    }

    public static class NewException implements Callable<Boolean>{
        @Override
        public Boolean call() throws Exception {
            long start = System.currentTimeMillis();
            for(int i=0;i<LOOP;i++){
                new CustomException("");
            }

            newExceptionTimes.add(System.currentTimeMillis() - start);
            return true;
        }
    }

    public static class NewExtException implements Callable<Boolean>{
        @Override
        public Boolean call() throws Exception {
            long start = System.currentTimeMillis();
            for(int i=0;i<LOOP;i++){
                new ExtCustomException("");
            }

            newExtExceptionTimes.add(System.currentTimeMillis() - start);
            return true;
        }
    }

    public static class CustomObject extends HashMap {

        private static final long serialVersionUID = 2859323936634141734L;
        private String message;

        public CustomObject(String message){
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class CustomException extends Exception{

        private static final long serialVersionUID = 3418425651413569596L;

        private String message;

        public CustomException(String message){
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class ExtCustomException extends Exception{

        private static final long serialVersionUID = -8376552278898516769L;
        private String message;

        public ExtCustomException(String message){
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }
}
