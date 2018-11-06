package priv.cxs.springboot2.support.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/5 下午4:39
 **/
@Component
@Aspect
@Slf4j
public class TimeRecodAspect {

    @Pointcut("@annotation(TimeRecord)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object record(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            log.info("invoke {} cost {}", joinPoint.getSignature().getName(), System.currentTimeMillis() - startTime);
        }
    }
}
