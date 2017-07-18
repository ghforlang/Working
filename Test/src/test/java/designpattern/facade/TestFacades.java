package designpattern.facade;

import org.junit.Test;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-18 17:24
 *  
 */
public class TestFacades {
    private Facades  facades = new Facades();


    @Test
    public void testMethod1(){
        facades.method1();
    }

    @Test
    public void testMethod2(){
        facades.method2();
    }

    @Test
    public void testMethod3(){
        facades.method3();
    }
}
