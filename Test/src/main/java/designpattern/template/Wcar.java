package designpattern.template;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-19 14:22
 *  
 */
public class Wcar extends CarModel{
    @Override
    protected void start() {
        System.out.println("WCar is starting");
    }

    @Override
    protected void stop() {
        System.out.println("Wcar is stopping");
    }
}
