package concurrent;

public class SleepUtils {

    private SleepUtils(){}

    public static void second(int second){
        try {
            Thread.sleep(second *1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
