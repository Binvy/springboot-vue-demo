package com.binvi.springboot.demo03.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author binvi
 * @version 1.0
 * @Description: 切面类
 * @date 2019/6/9 15:04
 */
@Component
@Aspect
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.binvi.springboot.demo03.service.*.*(..))")
    public void pc1() {
        logger.info("pointcut [1]");
    }

    @Before(value = "pc1()")
    public void before(JoinPoint jp) {
        logger.info("{} method begin.", jp.getSignature().getName());
    }

    @After(value = "pc1()")
    public void after(JoinPoint jp) {
        logger.info("{} method end.", jp.getSignature().getName());
    }

    @AfterReturning(value = "pc1()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result) {
        logger.info("{} return result: {}", jp.getSignature().getName(), result);
    }

    @AfterThrowing(value = "pc1()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e) {
        logger.info("{} throw a exception: {}", jp.getSignature().getName(), e.getMessage());
    }

    @Around("pc1()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("{} around", pjp.getSignature().getName());
        return pjp.proceed();
    }

}
