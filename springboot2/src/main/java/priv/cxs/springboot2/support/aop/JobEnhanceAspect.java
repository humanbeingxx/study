package priv.cxs.springboot2.support.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;
import priv.cxs.springboot2.service.JobEnhance;
import priv.cxs.springboot2.service.JobEnhanceImpl;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/6 下午3:39
 **/
@Aspect
@Component
public class JobEnhanceAspect {

    @DeclareParents(value = "priv.cxs.springboot2.service.JobServiceImpl", defaultImpl = JobEnhanceImpl.class)
    public JobEnhance jobEnhanceService;
}
