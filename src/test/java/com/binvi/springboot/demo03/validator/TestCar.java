package com.binvi.springboot.demo03.validator;

import com.binvi.springboot.demo03.entity.Audi;
import com.binvi.springboot.demo03.entity.BMW;
import com.binvi.springboot.demo03.entity.Car;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.Set;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/17 22:16
 */
@RunWith(SpringRunner.class)
public class TestCar {

    private static final Logger logger = LoggerFactory.getLogger(TestCar.class);

    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void validate() {
        Car car = new Car();
        car.setManufacturer(null);
        car.setLicensePlate("A");
        car.setSeatCount(1);
        car.setTopSpeed(400.1231321);
        car.setPrice(new BigDecimal(3000000));
        logger.info("car: {}", car);

        String message = validator.validateProperty(car, "manufacturer")
                .iterator().next().getMessage();
        logger.info("message:{}", message);
        Assert.assertEquals("must not be null", message);

        message = validator.validateProperty(car, "seatCount").iterator().next().getMessage();
        logger.info("message:{}", message);
        Assert.assertEquals("There must be at least 2 seats", message);

        message = validator.validateProperty(car, "topSpeed").iterator().next().getMessage();
        logger.info("message:{}", message);
        Assert.assertEquals("The top speed 400.12 is higher than 350", message);

        message = validator.validateProperty(car, "price").iterator().next().getMessage();
        logger.info("message:{}", message);
        Assert.assertEquals("Price must not be higher than $100000", message);

    }

    @Test
    public void testValidateHesting() {
        Car car = new Car();
        car.setManufacturer(null);
        car.setLicensePlate("A");
        car.setSeatCount(1);
        car.setTopSpeed(400.1231321);
        car.setPrice(new BigDecimal(3000000));

        BMW bmw = new BMW();
        bmw.setBmw("bmw1");

        Audi audi = new Audi();
        audi.setAudi("audi1");
        car.setBmwList(Lists.newArrayList(bmw));
        car.setAudiList(Lists.newArrayList(audi));

        Set<ConstraintViolation<Car>> violations = validator.validate(car);
        logger.info("violations: {}", violations);

        Set<ConstraintViolation<BMW>> violations_bmw = validator.validate(bmw);
        logger.info("violations_bmw: {}", violations_bmw);

        Set<ConstraintViolation<Audi>> violations_audi = validator.validate(audi);
        logger.info("violations_audi: {}", violations_audi);

    }

}
