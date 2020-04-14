package concurrent.safe;



public class Singleton1 {

    //volatile禁止指令重排?
    private volatile static Singleton1 uniqueInstance;

    public static Singleton1 getInstance(){
        if(uniqueInstance == null){
            synchronized (Singleton1.class){
                if(uniqueInstance == null){
                    uniqueInstance = new Singleton1();
                }
            }
        }
        return uniqueInstance;
    }

}
