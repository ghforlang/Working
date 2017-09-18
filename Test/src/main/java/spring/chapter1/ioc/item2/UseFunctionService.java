package spring.chapter1.ioc.item2;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-18 11:09
 *  
 */
public class UseFunctionService {
    FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String sayHello(String word){
        return functionService.sayHello(word);
    }
}
