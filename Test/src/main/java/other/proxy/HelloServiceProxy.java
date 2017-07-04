package other.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-06-27 11:05
 *  
 */
public class HelloServiceProxy implements InvocationHandler {

    //真实对象
    private Object target;

    public Object bind(Object target,Class[] interfaces){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),interfaces,this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("动态代理测试!");
        Object result = null;
        //反射方法前调用
        System.err.println("我准备说hello。");
        //反射执行方法  相当于调用target.sayHelllo;
        result=method.invoke(target, args);
        //反射方法后调用.
        System.err.println("我说过hello了");
        return result;
    }
}
