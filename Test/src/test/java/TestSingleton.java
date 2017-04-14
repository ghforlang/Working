import biz.Singleton;

/**
 * 单例模式测试
 *
 * @author fanwh
 * @create 2017-03-31 15:53
 **/
public class TestSingleton {
    public static void main(String[] args){
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
    }
}

