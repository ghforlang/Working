package spring.chapter1.ioc.item1;

import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-18 10:53
 *  
 */
@Service
public class FunctionService {
    public String sayHello(String word){
        return "hello " + word;
    }
}
