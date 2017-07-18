package designpattern.facade.impl;

import designpattern.facade.ServiceC;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-18 17:20
 *  
 */
public class ServiceCImpl implements ServiceC {
    @Override
    public void methodC() {
        System.out.println("methodC is running");
    }
}
