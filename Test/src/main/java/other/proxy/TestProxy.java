package other.proxy;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-06-27 13:14
 *  
 */
public class TestProxy {
    public static void main(String[] args) {
        HelloServiceProxy proxy = new HelloServiceProxy();
        HelloService service = new HelloServiceImpl();
        //绑定代理对象。
        service = (HelloService) proxy.bind(service,new Class[]{HelloService.class});
        //这里service经过绑定，就会进入invoke方法里面了。
        service.sayHello("张三");

//        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
