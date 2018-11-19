package priv.cxs.springboot2.schedule.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import priv.cxs.springboot2.schedule.SchedulerFactoryBeanContextCustomizer;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/17 15:36
 */
public abstract class AbstractCronJob extends QuartzJobBean {

    public String identity() {
        return this.getClass().getSimpleName();
    }

    public abstract String getCron();

    protected ApplicationContext getApplicationContext(JobExecutionContext context) {
        try {
            return (ApplicationContext) context.getScheduler().getContext()
                    .get(SchedulerFactoryBeanContextCustomizer.APPLICATION_CONTEXT);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}
