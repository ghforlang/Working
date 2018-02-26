package frp.demo2;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/2/26 17:58
 */
public abstract class AsyncJob<T> {
    public abstract void start(CallBack<T> callBack);
}
