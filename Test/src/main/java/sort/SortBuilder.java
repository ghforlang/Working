package sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortBuilder<T> {
    // Never make these public
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;
    private List<SortFiled<T>> sortFileds = new ArrayList<>();
    private Map<String, Method> propertyMethodMap = null;
    private boolean nullsFirst;
    private boolean nullsLast;
    private boolean zerosFirst;
    private boolean zerosLast;
    private boolean natural;
    private Direction naturalDirection;

    private static final Logger log = LoggerFactory.getLogger(SortBuilder.class);


    public static <C> SortBuilder<C> newBuilder(Class clazz) {
        SortBuilder<C> sortBuilder = new SortBuilder<>();
        PropertyDescriptor[] propertyDescriptor = BeanUtils.getPropertyDescriptors(clazz);
        Map<String, Method> propertyMethodMap = new HashMap<>();
        for (PropertyDescriptor pd : propertyDescriptor) {
            String key = pd.getName();
            Method value = pd.getReadMethod();
            propertyMethodMap.put(key, value);
        }
        sortBuilder.propertyMethodMap = propertyMethodMap;
        return sortBuilder;
    }

    /**
     * null 排序到最前面
     */
    public SortBuilder<T> nullsFirst() {
        nullsFirst = true;
        nullsLast = false;
        return this;
    }

    /**
     * null 排序到最后面
     */
    public SortBuilder<T> nullsLast() {
        nullsFirst = false;
        nullsLast = true;
        return this;
    }

    /**
     * 0 排序到最后面
     */
    public SortBuilder<T> zerosLast() {
        zerosFirst = false;
        zerosLast = true;
        return this;
    }

    /**
     * 0 排序到最前面
     */
    public SortBuilder<T> zerosFirst() {
        zerosFirst = true;
        zerosLast = false;
        return this;
    }

    /**
     * 自然排序 {1,5,3,2,4} = {1,2,3,4,5}
     */
    public SortBuilder<T> natural() {
        natural = true;
        return this;
    }

    /**
     * 自然排序 {1,5,3,2,4} = {1,2,3,4,5}
     */
    public SortBuilder<T> natural(Direction direction) {
        natural = true;
        naturalDirection = direction;
        return this;
    }

    public SortBuilder<T> clear() {
        sortFileds.clear();
        return this;
    }

    /**
     * 增加一个降序
     *
     * @param fieldName 属性
     */
    public SortBuilder<T> addDesc(String fieldName) {
        addFieldMethod(fieldName, Direction.DESC);
        return this;
    }

    /**
     * 增加一个自定义排序
     *
     * @param comparator 自定义比较器
     */
    public SortBuilder<T> addCustom(Comparator<T> comparator) {
        sortFileds.add(SortFiled.builder(Direction.CUSTOM, null, comparator));
        return this;
    }


    /**
     * 增加一个升序
     *
     * @param fieldName 属性
     */
    public SortBuilder<T> addAsc(String fieldName) {
        addFieldMethod(fieldName, Direction.ASC);
        return this;
    }

    /**
     * 增加一个字段排序模式
     *
     * @param fieldName 属性
     * @param direction 排序方式
     */
    private SortBuilder<T> addFieldMethod(String fieldName, Direction direction) {
        Method method = propertyMethodMap.get(fieldName);
        if (method == null) {
            log.error("NoSuchMethodException field:{}", fieldName);
        } else {
            sortFileds.add(SortFiled.<T>builder(direction, method, null));
        }
        return this;
    }

    public SortBuilder<T> sortList(List<T> list) {
        Collections.sort(list, buildComparator());
        return this;
    }

    private Comparator<T> buildComparator() {
        return new Comparator<T>() {
            public int compare(T o1, T o2) {
                int flag = 0;
                if (sortFileds.size() == 0 && natural) {
                    flag = compareNatural(o1, o2, naturalDirection);
                } else {
                    for (SortFiled<T> sortFiled : sortFileds) {
                        Method method = sortFiled.getMethod();
                        Direction direction = sortFiled.getDirection();
                        if (direction == Direction.CUSTOM) {
                            flag = sortFiled.getComparator().compare(o1, o2);
                        } else {
                            flag = this.compare(method, o1, o2, direction);
                        }
                        if (flag != 0) {
                            break;
                        }
                    }
                }
                return flag;
            }

            private int compare(Method method, T left, T right, Direction direction) {
                int flag = 0;
                try {
                    Object leftVal = method.invoke(left);
                    Object rightVal = method.invoke(right);
                    Class returnType = method.getReturnType();
                    if (nullsFirst) {
                        flag = compareNulls(returnType, leftVal, rightVal, false, direction);
                    } else if (nullsLast) {
                        flag = compareNulls(returnType, rightVal, leftVal, true, direction);
                    } else {
                        flag = compare(returnType, leftVal, rightVal, direction);
                    }
                } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                return flag;
            }

            private int compareNatural(Object leftVal, Object rightVal, Direction direction) {
                int flag;
                if (nullsFirst) {
                    flag = compareNulls(leftVal, rightVal, false, direction);
                } else if (nullsLast) {
                    flag = compareNulls(rightVal, leftVal, true, direction);
                } else {
                    flag = compare(leftVal.getClass(), leftVal, rightVal, direction);
                }
                return flag;
            }

            private int compareNulls(Object leftVal, Object rightVal, boolean reverse, Direction direction) {
                return compareNulls(leftVal == null ? null : leftVal.getClass(), leftVal, rightVal, reverse, direction);
            }

            private int compareNulls(Class returnType, Object leftVal, Object rightVal, boolean reverse,
                                     Direction direction) {
                if (leftVal == rightVal) {
                    return 0;
                } else if (leftVal == null) {
                    return RIGHT_IS_GREATER;
                } else if (rightVal == null) {
                    return LEFT_IS_GREATER;
                } else {
                    return reverse ? compare(returnType, rightVal, leftVal, direction) : compare(returnType, leftVal,
                            rightVal, direction);
                }
            }

            private int compareZeros(BigDecimal leftNumber, BigDecimal rightNumber, boolean reverse, Direction direction) {
                if (leftNumber.compareTo(rightNumber) == 0) {
                    return 0;
                } else if (leftNumber.compareTo(BigDecimal.valueOf(0)) == 0) {
                    return RIGHT_IS_GREATER;
                } else if (rightNumber.compareTo(BigDecimal.valueOf(0)) == 0) {
                    return LEFT_IS_GREATER;
                } else {
                    return reverse ? compareNumber(rightNumber, leftNumber, direction) : compareNumber(leftNumber,
                            rightNumber, direction);
                }
            }

            private int compareNumber(BigDecimal leftNumber, BigDecimal rightNumber, Direction direction) {
                if (leftNumber.compareTo(rightNumber) == 0) {
                    return 0;
                } else {
                    return direction == null || direction == Direction.ASC ? leftNumber.compareTo(rightNumber)
                            : rightNumber.compareTo(leftNumber);
                }
            }

            private int compare(Class returnType, Object leftVal, Object rightVal, Direction direction) {
                int flag;
                if (Number.class.isAssignableFrom(returnType) || returnType == int.class || returnType == long.class
                        || returnType == double.class || returnType == float.class) {
                    BigDecimal leftNumber = BigDecimal.valueOf(Double.valueOf(leftVal.toString()));
                    BigDecimal rightNumber = BigDecimal.valueOf(Double.valueOf(rightVal.toString()));
                    if (zerosFirst) {
                        flag = compareZeros(leftNumber, rightNumber, false, direction);
                    } else if (zerosLast) {
                        flag = compareZeros(rightNumber, leftNumber, true, direction);
                    } else {
                        flag = compareNumber(leftNumber, rightNumber, direction);
                    }
                } else {
                    String methodReturn1 = leftVal.toString();
                    String methodReturn2 = rightVal.toString();
                    if (direction == null || direction == Direction.ASC) {
                        flag = methodReturn1.compareTo(methodReturn2);
                    } else {
                        flag = methodReturn2.compareTo(methodReturn1);
                    }
                }
                return flag;
            }
        };
    }

}
