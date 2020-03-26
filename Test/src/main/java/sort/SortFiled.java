package sort;

import java.lang.reflect.Method;
import java.util.Comparator;

public class SortFiled<T> {
    private Method method;
    private Direction direction;
    private Comparator<T> comparator;


    SortFiled(Direction direction, Method method, Comparator<T> comparator) {
        this.method = method;
        this.direction = direction;
        this.comparator = comparator;
    }

    @SuppressWarnings("unchecked")
    public static <T> SortFiled<T> builder(Direction direction, Method method, Comparator<T> comparator) {
        return new SortFiled(direction, method, comparator);
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Comparator<T> getComparator() {
        return comparator;
    }

    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }
}
