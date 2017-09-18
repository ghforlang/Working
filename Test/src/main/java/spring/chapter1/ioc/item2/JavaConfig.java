package spring.chapter1.ioc.item2;

import org.springframework.context.annotation.Bean;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-18 11:11
 *  
 */
public class JavaConfig {

    @Bean
    public FunctionService functionService(){
        return new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService(){
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService());
        return useFunctionService;
    }

    public UseFunctionService userFunctionService(FunctionService functionService){
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService);
        return useFunctionService;
    }

}
