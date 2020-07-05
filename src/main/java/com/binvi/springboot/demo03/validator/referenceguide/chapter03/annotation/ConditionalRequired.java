package com.binvi.springboot.demo03.validator.referenceguide.chapter03.annotation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.binvi.springboot.demo03.validator.referenceguide.chapter03.annotation.ConditionalRequired.List;
import com.binvi.springboot.demo03.validator.referenceguide.chapter03.model.DemoRequest;
import org.apache.commons.lang3.StringUtils;

/**
 * @author binvi
 * @version 1.0
 * @Description: hibernate-validator“条件必输”
 * @date 2019/12/19 21:56
 */
@Documented
@Constraint(validatedBy = ConditionalRequired.Validator.class)
@Target({TYPE})
@Retention(RUNTIME)
@Repeatable(List.class)
public @interface ConditionalRequired {

	String message() default "{com.binvi.springboot.demo03.validator.referenceguide.chapter03.annotation.ConditionalRequired.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	class Validator implements ConstraintValidator<ConditionalRequired, DemoRequest> {

		@Override
		public void initialize(ConditionalRequired constraintAnnotation) {

		}

		@Override
		public boolean isValid(DemoRequest request, ConstraintValidatorContext context) {
			if (request == null) {
				return true;
			}
			if (StringUtils.isEmpty(request.getType())) {
				return true;
			}
			return (!StringUtils.equals("01", request.getType()) || StringUtils.isNotEmpty(request.getFlag())) &&
					(!StringUtils.equals("01", request.getType()) || StringUtils.isNotEmpty(request.getFlag2())) &&
					(!StringUtils.equals("01", request.getType()) || StringUtils.isNotEmpty(request.getFlag3())) &&
					(!StringUtils.equals("01", request.getType()) || StringUtils.isNotEmpty(request.getFlag4()));
		}
	}

	@Target(TYPE)
	@Retention(RUNTIME)
	@Documented
	@interface List {
		ConditionalRequired[] value();
	}

}
