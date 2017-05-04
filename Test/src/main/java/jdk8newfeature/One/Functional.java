package jdk8newfeature.One;

import util.PrintUtils;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-04 18:49
 *  
 */
@FunctionalInterface
public interface Functional {
    void method();

    default  void defaultMethod(){
        PrintUtils.print("this is a Functional Interface Test!");
    }
}
