package com.binvi.springboot.demo03.validator.referenceguide.chapter03.parametersciptassert;

/**
 * @author binvi
 * @version 1.0
 * @Description: Built-in method constraints test
 * @date 2019/6/20 22:57
 */
/*public class ParameterScriptAssertTest {

    private static ExecutableValidator executableValidator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        executableValidator = factory.getValidator().forExecutables();
    }

    @Test
    public void validateParameters() throws Exception {
        Car object = new Car();
        Method method = Car.class.getMethod("load", List.class, List.class);
        Object[] parameterValues = {
                Arrays.asList(new Person()),
                Arrays.asList(new PieceOfLuggage(), new PieceOfLuggage(), new PieceOfLuggage())
        };

        Set<ConstraintViolation<Car>> violations = executableValidator.validateParameters(
                object,
                method,
                parameterValues
        );
        Assert.assertEquals(1, violations.size());
        Class<? extends Annotation> annotationType = violations.iterator()
                .next()
                .getConstraintDescriptor()
                .getAnnotation()
                .annotationType();
        Assert.assertEquals(ParameterScriptAssert.class, annotationType);
    }

}*/
