package priv.cxs.springboot2.aop;

import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Aspect
@Slf4j
public class LogAspect {

    private AtomicInteger callCount = new AtomicInteger();
    private static AtomicInteger staticCallCount = new AtomicInteger();

    @Before("@annotation(ParamLogged)")
    public void logParam(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        log.info("function {} is called by {}", signature.getName(), Arrays.deepToString(args));
    }

    @AfterReturning(value = "@annotation(ResultLogged)", returning = "retVal")
    public void logResult(JoinPoint joinPoint, Object retVal) {
        Signature signature = joinPoint.getSignature();
        log.info("function {} return {}", signature.getName(), JSON.toJSON(retVal));
    }

    @SneakyThrows
    @Around("@annotation(TimeLogged)")
    public Object logTime(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        log.info("function {} start at {}", joinPoint.getSignature().getName(), System.currentTimeMillis());
        Object retVal = joinPoint.proceed();
        log.info("function {} finish at {}, cost {}", joinPoint.getSignature().getName(),
                System.currentTimeMillis(), System.currentTimeMillis() - startTime);
        return retVal;
    }

    @After("@annotation(CallLogged)")
    public void logCall(JoinPoint joinPoint) {
        log.info("function {} called {} times", joinPoint.getSignature().getName(), callCount.incrementAndGet());
        log.info("function {} called {} times by static count", joinPoint.getSignature().getName(), staticCallCount.incrementAndGet());
    }
}
