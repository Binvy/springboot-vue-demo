package com.binvi.springboot.demo03.validator.referenceguide.chapter03.validation;

import com.binvi.springboot.demo03.validator.referenceguide.chapter03.model.DemoRequest;
import com.sun.media.jfxmedia.logging.Logger;
import org.hibernate.validator.HibernateValidator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author binvi
 * @version 1.0
 * @Description: Hibernate validator条件必输 测试类
 * @date 2019/12/19 22:32
 */
public class ConditionalRequiredTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.byProvider(HibernateValidator.class)
				.configure()
				.buildValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void conditionalRequiredTest() {
		DemoRequest request = new DemoRequest();
		request.setId("id");
		request.setName("name");
		request.setType("00");
		request.setFlag("");
		request.setFlag2("");
		request.setFlag3("");
		request.setFlag4("");

		Set<ConstraintViolation<DemoRequest>> violations = validator.validate(request);
		violations.forEach(violation -> {
			System.out.println(violation.getMessage());
		});
		Assert.assertFalse(violations.isEmpty());
	}

}
