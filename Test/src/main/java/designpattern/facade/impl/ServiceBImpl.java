package designpattern.facade.impl;

import designpattern.facade.ServiceB;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-18 17:19
 *  
 */
public class ServiceBImpl implements ServiceB{
    @Override
    public void methodB() {
        System.out.println("methodB is running");
    }
}
