package spring.chapter1.ioc.item1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-18 11:03
 *  
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ItemConfig.class);

        UserFunctionService userFunctionService = context.getBean(UserFunctionService.class);
        System.out.println(userFunctionService.sayHello("item1"));
        context.close();
    }
}
