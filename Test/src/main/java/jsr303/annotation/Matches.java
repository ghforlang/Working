package jsr303.annotation;

import jsr303.validator.MatchesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/3 15:14
 */
@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MatchesValidator.class)

public @interface Matches {
    String message() default "{constraint.not.matches}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String field();
    String verifyField();
}
