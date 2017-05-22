package freemarker;

import freemarker.core.Environment;
import freemarker.template.*;

import java.io.IOException;
import java.util.Map;


/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-08 15:10
 *  
 */
public class ContentDirective implements TemplateDirectiveModel {

    private static final String PARAM_NAME = "name";
    private static final String PARAM_AGE = "age";
    private static final ObjectWrapper DEFAULT_WRAPPER = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_23).build();


    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        if(null == body){
            throw new TemplateModelException("null body");
        }else{
            String name = getString(PARAM_NAME,params);
            Integer age = getInteger(PARAM_AGE,params);

            if(null != name){
                env.setVariable("append",DEFAULT_WRAPPER.wrap("从ContentDirective解析类中获得的参数是：" + name));
            }
        }

    }

    private static String getString(String paramName, Map<String,TemplateModel> paramMap) throws TemplateModelException {
        TemplateModel model = paramMap.get(paramName);
        if(null == model){
            return null;
        }
        if(model instanceof TemplateScalarModel){
            return ((TemplateScalarModel)model).getAsString();
        }else if(model instanceof TemplateNumberModel) {
            return ((TemplateNumberModel) model).getAsNumber().toString();
        }else{
            throw new  TemplateModelException(paramName);
        }
    }

    private static Integer getInteger(String paramName,Map<String,TemplateModel> params) throws TemplateModelException {
        TemplateModel model = params.get(paramName);
        if(null == model){
            return null;
        }

        if(model instanceof TemplateScalarModel){
            String str = ((TemplateScalarModel)model).getAsString();
            try{
                return Integer.valueOf(str);
            }catch(NumberFormatException e){
                throw new TemplateModelException(paramName);
            }
        }else if(model instanceof TemplateNumberModel){
            return ((TemplateNumberModel)model).getAsNumber().intValue();
        }else{
            throw new TemplateModelException(paramName);
        }
    }
}
