package concurrent;

public class DeadLockDemo {

    private static String resource_A = "A";
    private static String resource_B = "B";

    public static void main(String[] args) {
        deadLock();
    }

    private static void deadLock(){
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("get resource_A ！");
                synchronized (resource_A){
                    try {
                        Thread.sleep(3000);
                        synchronized (resource_B){
                            System.out.println("get resource_B ！");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("get resource_B ！");
                synchronized (resource_B){
                    try {
                        Thread.sleep(3000);
                        synchronized (resource_A){
                            System.out.println("get resource_A ！");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        threadA.start();
        threadB.start();
    }
}
