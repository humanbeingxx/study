package priv.cxs.springboot2.support.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
        log.info("before2 execution......");
    }

}
