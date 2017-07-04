package other.myproxy;

import java.lang.reflect.Proxy;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-03 14:04
 *  
 */
public class TestMyProxy {
    public static void main(String[] args) {
        //调用bind方法完成代理绑定
        MyProxy myProxy = new MyProxy();
        OtherService service = new OtherServiceImpl();

        service = (OtherService)myProxy.bind(service,new Class[]{OtherService.class});
        System.out.println(service.method1());


        //调用构造方法绑定,然后再绑定代理
        OtherService otherService = new OtherServiceImpl();
        myProxy = new MyProxy(otherService);

        OtherService realService = (OtherService) Proxy.newProxyInstance(otherService.getClass().getClassLoader(),service.getClass().getInterfaces(),myProxy);
        System.out.println(realService.method2());
    }
}
