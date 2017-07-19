package designpattern.template;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-19 14:24
 *  
 */
public class Client {
    public static void main(String[] args) {
        CarModel wcar = new Wcar();
        wcar.start();
        wcar.stop();

        CarModel acar = new Acar();
        acar.start();
        acar.stop();
    }
}
