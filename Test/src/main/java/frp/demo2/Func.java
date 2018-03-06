package frp.demo2;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/2/27 19:35
 */
public interface Func<T,R> {
    R call(T t);
}
