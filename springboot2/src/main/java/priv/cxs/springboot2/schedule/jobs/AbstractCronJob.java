package priv.cxs.springboot2.schedule.jobs;

import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/17 15:36
 */
public abstract class AbstractCronJob extends QuartzJobBean {

    public abstract String identity();

    public abstract String getCron();
}
