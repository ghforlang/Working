package designpattern.template;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-19 14:20
 *  
 */
public abstract class CarModel {
    protected abstract void start();

    protected abstract void stop();

    public final void execute(){
        this.start();
        this.stop();
    }

}
