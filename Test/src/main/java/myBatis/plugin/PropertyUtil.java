package myBatis.plugin;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-04 14:01
 *  
 */
public class PropertyUtil {
    public static PropertyDescriptor getPropertyDescriptor(Class clazz,String propertyName) throws NoSuchMethodException, IntrospectionException {
        StringBuffer sb = new StringBuffer();
        Method setMethod = null;
        Method getMethod = null;
        PropertyDescriptor pd = null;

        try {
            Field field = clazz.getDeclaredField(propertyName);
            if(field != null){
                String methodEnd = propertyName.substring(0,1).toUpperCase() + propertyName.substring(1);
                sb.append("set");
                sb.append(methodEnd);
                setMethod = clazz.getMethod(sb.toString(),new Class[]{field.getType()});
                sb.delete(0,sb.length());
                sb.append("get");
                sb.append(methodEnd);
                getMethod = clazz.getMethod(sb.toString(),new Class[]{});

                pd = new PropertyDescriptor(propertyName,setMethod,getMethod);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return pd;
    }

    public static void setProperty(Object obj,String propertyName, Object value){
        Class clazz = obj.getClass();
        try {
            PropertyDescriptor pd = getPropertyDescriptor(clazz,propertyName);
            Method setMethod = pd.getWriteMethod();
            try {
                setMethod.invoke(obj,new Object[]{value});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }

    public static Object getProperty(Object obj,String propertyName) throws InvocationTargetException, IllegalAccessException {
        Class clazz = obj.getClass();
        Object value = null;
        try {
            PropertyDescriptor pd = getPropertyDescriptor(clazz,propertyName);
            Method getMethod = pd.getReadMethod();
            value =  getMethod.invoke(obj,propertyName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return value;
    }
}
