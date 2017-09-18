package spring.chapter1.ioc.item1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-18 11:00
 *  
 */
@Service
public class UserFunctionService {
    @Autowired
    FunctionService functionService;
    public String sayHello(String word){
        return functionService.sayHello(word);
    }
}
