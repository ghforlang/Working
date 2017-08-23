package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-08-23 13:27
 *  
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface FanAnnotation {
    String color() default "red";
    String value();
    int[] arr() default {1,2,3};
    EnumTrafficLamp trafficLamp() default EnumTrafficLamp.GREEN;
    MetaFanAnnotation metaAnnotation() default @MetaFanAnnotation(property = "annotation");
}
