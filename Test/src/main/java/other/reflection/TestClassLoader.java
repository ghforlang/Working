package other.reflection;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-06-28 15:18
 *  
 */
public class TestClassLoader {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统加载器(或者叫应用加载器)：" + classLoader);

        classLoader = classLoader.getParent();
        System.out.println("扩展加载器：" + classLoader);

        //对java程序不可见，结果为null
        classLoader = classLoader.getParent();
        System.out.println("bootstrap加载器：" + classLoader);

        //测试当前类由哪个加载器加载
        classLoader = Class.forName("other.reflection.TestClassLoader").getClassLoader();
        System.out.println("当前类的加载器：" + classLoader);

        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println("object类的加载器" + classLoader);
    }
}
