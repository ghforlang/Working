package biz;

public class Singleton {
    private Integer num = 0;
    private Singleton(){}

    public static class SingletonHolder{
        static Singleton instance= new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.instance;
    }

}
