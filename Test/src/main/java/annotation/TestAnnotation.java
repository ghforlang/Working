package annotation;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-08-23 13:29
 *  
 */
@FanAnnotation(value = "fanannotation")
public class TestAnnotation {
    public static void main(String[] args) {
        //检查类是否有注解
        if(TestAnnotation.class.isAnnotationPresent(FanAnnotation.class)){
            //打印注解
            FanAnnotation fanAnnotation = TestAnnotation.class.getAnnotation(FanAnnotation.class);
            System.out.println(fanAnnotation.getClass());
            System.out.println(fanAnnotation.getClass().getName());
            System.out.println(fanAnnotation.getClass().getSimpleName());

            System.out.println(fanAnnotation.color());
            System.out.println(fanAnnotation.value());

            System.out.println(fanAnnotation.trafficLamp().name());
            System.out.println(fanAnnotation.arr().length);
            System.out.println(fanAnnotation.metaAnnotation().property());

            MetaFanAnnotation metaAnnotation = fanAnnotation.metaAnnotation();
            System.out.println(metaAnnotation.property());
        }
    }

    @Override
    public String toString() {
        return "TestAnnotation{}";
    }

    @Deprecated
    public void change(){
        System.out.println("xxxxx");
    }

    @SuppressWarnings("value")
    public String warning(){
        return "warning";
    }
}
