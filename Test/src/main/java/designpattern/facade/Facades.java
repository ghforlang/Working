package designpattern.facade;

import designpattern.facade.impl.ServiceAImpl;
import designpattern.facade.impl.ServiceBImpl;
import designpattern.facade.impl.ServiceCImpl;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-18 17:17
 *  
 */
public class Facades {
    private ServiceC serviceC;
    private ServiceB serviceB;
    private ServiceA serviceA;

    public Facades() {
        serviceA = new ServiceAImpl();
        serviceB = new ServiceBImpl();
        serviceC = new ServiceCImpl();
    }

    public void method1(){
        serviceA.methodA();
        serviceB.methodB();
    }

    public void method2(){
        serviceB.methodB();
        serviceC.methodC();
    }
    public void method3(){
        serviceA.methodA();
        serviceB.methodB();
        serviceC.methodC();
    }
}
