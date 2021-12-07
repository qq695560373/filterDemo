package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author laogao
 * @date 2021/12/7 9:50
 */

@Aspect
@Component
public class InterceptControllerAspect {
    private static final Logger logger = LoggerFactory.getLogger(InterceptControllerAspect.class);

    @Pointcut("execution(public * com.example.demo.controller..*.*(..))")
    public void interceptController() {

    }

    @Around("interceptController()")
    public Object handle(ProceedingJoinPoint joinPoint) throws Throwable {

        logger.info("aspect before.");

        try {
            return joinPoint.proceed();
        } finally {
            logger.info("aspect after.");
        }
    }

    @Before("interceptController()")
    public void before(JoinPoint joinPoint) {

        logger.info("aspect @Before before.",joinPoint);
    }

    @AfterThrowing(value = "interceptController()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        //发生异常之后输出异常信息
        logger.info(joinPoint + ",发生异常：" + e.getMessage());
    }
}
