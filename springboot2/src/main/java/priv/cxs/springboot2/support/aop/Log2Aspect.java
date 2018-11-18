package priv.cxs.springboot2.support.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
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
public class Log2Aspect {

    @Pointcut("execution(* priv.cxs.springboot2.service..*.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before() {
        log.debug("before 2 execution......");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.debug("around 2 before......");
        try {
            return joinPoint.proceed();
        } finally {
            log.debug("around 2 after......");
        }
    }

    @After("pointCut()")
    public void after() {
        log.debug("after 2 execution......");
    }

    @AfterReturning(value = "pointCut()", returning = "ret")
    public void afterReturning(JoinPoint joinPoint, Object ret) {
        log.debug("after 2 returning execution......result {}", ret);
    }


}
