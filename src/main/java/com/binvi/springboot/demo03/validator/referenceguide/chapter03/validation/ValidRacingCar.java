package com.binvi.springboot.demo03.validator.referenceguide.chapter03.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/20 21:40
 */
@Target({METHOD, CONSTRUCTOR, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {ValidRacingCar.Validator.class})
@Documented
public @interface ValidRacingCar {

    String message() default "{com.binvi.springboot.demo03.validator.referenceguide.chapter03.validation.ValidRacingCar.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<ValidRacingCar, Car> {

        @Override
        public void initialize(ValidRacingCar ConstraintAnnotation) { }

        @Override
        public boolean isValid(Car value, ConstraintValidatorContext context) {
            return false;
        }
    }

}
