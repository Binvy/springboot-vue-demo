package com.binvi.springboot.demo03.validator.referenceguide.chapter03.validation;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Path.MethodNode;
import javax.validation.Path.Node;
import javax.validation.Path.ParameterNode;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.executable.ExecutableValidator;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/20 21:50
 */
public class CarTest {

    private static ExecutableValidator executableValidator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        executableValidator = factory.getValidator().forExecutables();
    }

    @Test
    public void validateParameters() throws Exception {
        Car object = new Car("Morris");
        Method method = Car.class.getMethod("drive", int.class);
        Object[] parameterValues = {80};
        Set<ConstraintViolation<Car>> violations = executableValidator.validateParameters(
                object,
                method,
                parameterValues
        );

        assertEquals(1, violations.size());
        Class<? extends Annotation> constraintType = violations.iterator()
                .next()
                .getConstraintDescriptor()
                .getAnnotation()
                .annotationType();
        assertEquals(Max.class, constraintType);
    }

    @Test
    public void validateReturnValue() throws Exception {
        Car object = new Car("Morris");
        Method method = Car.class.getMethod("getPassengers");
        Object returnValue = Collections.<Passenger>emptyList();
        Set<ConstraintViolation<Car>> violations = executableValidator.validateReturnValue(
                object,
                method,
                returnValue
        );

        assertEquals(1, violations.size());
        Class<? extends Annotation> constraintType = violations.iterator()
                .next()
                .getConstraintDescriptor()
                .getAnnotation()
                .annotationType();
        assertEquals(Size.class, constraintType);
    }

    @Test
    public void validateConstructorParameters() throws Exception {
        Constructor<Car> constructor = Car.class.getConstructor(String.class);
        Object[] parameterValues = { null };
        Set<ConstraintViolation<Car>> violations = executableValidator.validateConstructorParameters(
                constructor,
                parameterValues
        );

        assertEquals(1, violations.size());
        Class<? extends Annotation> annotationType = violations.iterator()
                .next()
                .getConstraintDescriptor()
                .getAnnotation()
                .annotationType();
        assertEquals(NotNull.class, annotationType);
    }

    @Test
    public void validateConstructorReturnValue() throws Exception {
        Constructor<Car> constructor = Car.class.getConstructor(String.class, String.class);
        Car createObject = new Car("Morris", null);
        Set<ConstraintViolation<Car>> violations = executableValidator.validateConstructorReturnValue(
                constructor,
                createObject
        );

        assertEquals(1, violations.size());
        Class<? extends Annotation> annotationType = violations.iterator()
                .next()
                .getConstraintDescriptor()
                .getAnnotation()
                .annotationType();
        assertEquals(ValidRacingCar.class, annotationType);
    }

    @Test
    public void retrieveMethodAndParametersInfomation() throws Exception {
        Car object = new Car("Morris");
        Method method = Car.class.getMethod("drive", int.class);
        Object[] parameterValues = { 80 };
        Set<ConstraintViolation<Car>> violations = executableValidator.validateParameters(
                object,
                method,
                parameterValues
        );

        assertEquals(1, violations.size());
        Iterator<Node> propertyPath = violations.iterator()
                .next()
                .getPropertyPath()
                .iterator();

        MethodNode methodNode = propertyPath.next().as(MethodNode.class);
        assertEquals("drive", methodNode.getName());
        assertEquals(Arrays.<Class<?>>asList(int.class), methodNode.getParameterTypes());

        ParameterNode parameterNode = propertyPath.next().as(ParameterNode.class);
        assertEquals("arg0", parameterNode.getName());
        assertEquals(0, parameterNode.getParameterIndex());
    }

}
