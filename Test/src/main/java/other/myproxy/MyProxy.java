package other.myproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-03 14:00
 *  
 */
public class MyProxy implements InvocationHandler {

    private Object target;

    public MyProxy() {
    }

    public MyProxy(Object target) {
        this.target = target;
    }

    public Object bind(Object target, Class[] interfaces){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),interfaces,this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("开始调用代理方法" + method.getName());
        result = method.invoke(target,args);
        System.out.println("调用代理方法结束" + method.getName());
        return result;
    }
}
