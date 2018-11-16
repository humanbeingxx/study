package priv.cxs.springboot2.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/15 下午4:23
 **/
public class StatisticsJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

    }
}
