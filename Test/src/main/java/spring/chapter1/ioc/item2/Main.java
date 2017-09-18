package spring.chapter1.ioc.item2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-18 11:15
 *  
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("javaConfig"));

        context.close();
    }
}
