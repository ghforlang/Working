package jsr303;

import jsr303.test.TwoPassword;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/3 16:06
 */
public class TestJSR303 {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    public void testBuildDefaultValidatorFactory() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        assertNotNull(validator);
    }

    @Test
    public void testPasswordEqualsConfirmPassword() {
        TwoPassword bean = new TwoPassword();
        bean.setNewPassword("110");
        bean.setConfirmNewPassword("110");

        Set<ConstraintViolation<TwoPassword>> constraintViolations = validator.validate(bean);
        for (ConstraintViolation<TwoPassword> constraintViolation : constraintViolations) {
            System.out.println(constraintViolation.getMessage());
        }

        assertEquals("newPassword and confirmNewPassword should be the same.", 0, constraintViolations.size());
    }

    @Test
    public void testPasswordNotEqualsConfirmPassword() {
        TwoPassword bean = new TwoPassword();
        bean.setNewPassword("110");
        bean.setConfirmNewPassword("111");

        Set<ConstraintViolation<TwoPassword>> constraintViolations = validator.validate(bean);

        assertEquals(1, constraintViolations.size());
        assertEquals("two password not the same", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testIfTwoPasswordWereNullShouldPast() {
        TwoPassword bean = new TwoPassword();
        bean.setNewPassword(null);
        bean.setConfirmNewPassword(null);

        Set<ConstraintViolation<TwoPassword>> constraintViolations = validator.validate(bean);

        assertEquals(0, constraintViolations.size());
    }

    @Test
    public void testIfOneIsNullAndOtherIsNotShouldNotPast() {
        TwoPassword bean = new TwoPassword();
        bean.setNewPassword(null);
        bean.setConfirmNewPassword("110");

        Set<ConstraintViolation<TwoPassword>> constraintViolations = validator.validate(bean);

        assertEquals(1, constraintViolations.size());
        assertEquals("two password not the same", constraintViolations.iterator().next().getMessage());
    }
}
