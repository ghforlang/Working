package other.proxy;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-06-27 13:15
 *  
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}
