package designpattern.facade.impl;

import designpattern.facade.ServiceA;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-18 17:18
 *  
 */
public class ServiceAImpl implements ServiceA {
    @Override
    public void methodA() {
        System.out.println("methodA is running");
    }
}
