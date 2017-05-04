package other;

import com.google.gson.annotations.Since;

import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-02 10:16
 *  
 */
public class TestCompletableFuture {
    static ExecutorService executor = Executors.newFixedThreadPool(5);
    public static void main(String[] args){
//        testFuture();
//        test();
//        test1();
//        test2();
//        test3();
//        testException();
    }

    public static void testFuture(){
        Future<String> result = executor.submit(()->{
                    TimeUnit.SECONDS.sleep(3);
                   return  "test future";
                }
        );
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    public static void test(){
        CompletableFuture<String> resultFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("this is completableFuture test!");
                return "success";
            }
        },executor);
        try {
            System.out.println(resultFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    public static void test1(){
        CompletableFuture<String> result = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "hello";
            }
        },executor);

        System.out.println(result.thenAccept(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
                System.out.println(Thread.currentThread().getName());
            }
        }));
    }

    public static void test2(){
        CompletableFuture<String> result  = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "test2";
            }
        },executor);
        System.out.println(result.thenAcceptAsync(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
                System.out.println(Thread.currentThread().getName());
            }
        },executor));
        System.out.println("finish");
    }

    public static void test3(){
        CompletableFuture<String> result  = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "test3";
            }
        });

        System.out.println(result.thenAcceptAsync(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
                System.out.println(Thread.currentThread().getName());
            }
        },executor));
        System.out.println("test3 finish");
    }

    public static void testException(){
        CompletableFuture<String> result  = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "testException";
            }
        },executor);

        System.out.println(result.thenAccept(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("accept: " + s);
                System.out.println(Thread.currentThread().getName());
            }
        }));

        result.completeExceptionally(new Exception("error"));
        System.out.println("test4 finish");

    }

    public static void testExceptional(){
        CompletableFuture<String> result = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return  "hello world";
            }
        },executor);

        result.thenAccept(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("accept " + s);
            }
        });
    }
}
