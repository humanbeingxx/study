package priv.cxs.springboot2.support.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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
    public void before() {
        log.info("before1 execution......");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around before......");
        try {
            return joinPoint.proceed();
        } finally {
            log.info("around after......");
        }
    }

    @After("pointCut()")
    public void after() {
        log.info("after execution......");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        log.info("after returning execution......");
    }


}
