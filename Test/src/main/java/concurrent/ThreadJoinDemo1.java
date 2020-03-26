package concurrent;

public class ThreadJoinDemo1 {

    // blog :https://www.jianshu.com/p/fc51be7e5bc0

    // join 通过 Object.wait / notifyAll实现线程通信，达到线程阻塞的目的。
    //在实际使用过程中，我们可以通过join方法来等待线程执行的结果，其实有点类似future/callable的功能

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " is running !");

        Thread threadA = new Thread("threadA"){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running");
                try {
                    sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " : " +  isAlive());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running!");
            }
        });
        threadB.setName("threadB");

        threadA.start();
        threadB.start();
        threadB.join();
        System.out.println("threadB " + threadB.isAlive());
    }

}
