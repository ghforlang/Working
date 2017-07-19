package designpattern.template;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-19 14:23
 *  
 */
public class Acar extends CarModel {
    @Override
    protected void start() {
        System.out.println("Acar is starting");
    }

    @Override
    protected void stop() {
        System.out.println("Acar is stopping");
    }
}
