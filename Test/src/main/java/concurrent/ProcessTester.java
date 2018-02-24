package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/29 15:44
 */
public class ProcessTester {

    private static final int             LOOP                 = 10000000;                        // 单次循环数量
    private static final int             THREADS              = 20;                              // 并发线程数量
    private static final List<Long>      trycatchTimes       = new ArrayList<>(THREADS);
    private static final List<Long>      ifelseTimes    = new ArrayList<>(THREADS);
    private static final ExecutorService POOL                 = Executors.newFixedThreadPool(40);

    public static void main(String[] args) throws Exception{
//        List<Callable<Boolean>> all = new ArrayList<>();
//        all.addAll(tasks(new ProcessTester.TryCatch()));
//        all.addAll(tasks(new ProcessTester.IfElse()));
//
//        POOL.invokeAll(all);
//
//        System.out.println("tc:\t\t" + total(trycatchTimes));
//        System.out.println("ie:\t\t" + total(ifelseTimes));
//
//        POOL.shutdown();
        System.out.println(Objects.equals(false,Boolean.FALSE));
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

    public static class TryCatch implements Callable<Boolean>{
        @Override
        public Boolean call() throws Exception {
            long start = System.currentTimeMillis();

            for(int i=0;i<LOOP;i++){
                try{
                    exception();
                }catch (ExtCustomException ex){
//                    System.out.println(ex.message);
                }
            }
            trycatchTimes.add(System.currentTimeMillis() - start);
            return true;
        }

        private ExtCustomException exception() throws ExtCustomException{
            throw  new ExtCustomException("try-catch");
        }
    }

    public static class IfElse implements Callable<Boolean>{
        @Override
        public Boolean call() throws Exception {
            long start = System.currentTimeMillis();
            for(int i=0;i<LOOP;i++){
                ExtCustomException e = exception();
                if(e instanceof ExtCustomException){
//                    System.out.println(e.message);
                }
            }

            ifelseTimes.add(System.currentTimeMillis() - start);
            return true;
        }

        private ExtCustomException exception(){
            return new ExtCustomException("if-else");
        }
    }

    public static class ExtCustomException extends Exception{

        private static final long serialVersionUID = 8541357828657628414L;
        private String message;

        public ExtCustomException(String message){
            this.message = message;
        }

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
