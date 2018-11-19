package priv.cxs.springboot2.schedule;

import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/19 下午3:29
 **/
@Component
public class SchedulerFactoryBeanContextCustomizer implements SchedulerFactoryBeanCustomizer {

    public static final String APPLICATION_CONTEXT = "ApplicationContext";

    private ApplicationContext applicationContext;

    public SchedulerFactoryBeanContextCustomizer(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void customize(SchedulerFactoryBean schedulerFactoryBean) {
        schedulerFactoryBean.setApplicationContextSchedulerContextKey(APPLICATION_CONTEXT);

        schedulerFactoryBean.setApplicationContext(applicationContext);
    }
}
