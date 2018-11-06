package priv.cxs.springboot2.support.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/5 下午2:50
 **/
@Component
@Aspect
@Slf4j
public class Log1Aspect {

    @Pointcut("execution(* priv.cxs.springboot2.service..*.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    @Order(1)
    public void before11() {
        log.info("before 11 execution......");
    }

    @Before("pointCut()")
    @Order(2)
    public void before12() {
        log.info("before 12 execution......");
    }


    @Around("pointCut()")
    @Order(3)
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around 1 before......");
        try {
            return joinPoint.proceed();
        } finally {
            log.info("around 1 after......");
        }
    }

    @After("pointCut()")
    public void after() {
        log.info("after 1 execution......");
    }

    @AfterReturning(value = "pointCut()", returning = "ret")
    public void afterReturning(JoinPoint joinPoint, Object ret) {
        log.info("after 1 returning execution......");
    }


}
