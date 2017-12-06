package jsr303.validator;

import jsr303.annotation.Matches;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/3 15:18
 */
public class MatchesValidator implements ConstraintValidator<Matches,Object> {

    private String field;
    private String verifyField;

    @Override
    public void initialize(Matches constraintAnnotation) {
        this.field= constraintAnnotation.field();
        this.verifyField = constraintAnnotation.verifyField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            String fieldValue= BeanUtils.getProperty(value,field);
            String verifyFieldValue = BeanUtils.getProperty(value,verifyField);
            boolean valid = (fieldValue == null) && (verifyFieldValue == null);
            if(valid){
                return true;
            }

            boolean match = (fieldValue!=null) && fieldValue.equals(verifyFieldValue);
            if(!match){
                String messageTemplate = context.getDefaultConstraintMessageTemplate();
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(messageTemplate)
                        .addNode(verifyField)
                        .addConstraintViolation();
            }
            return match;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return true;
    }
}
