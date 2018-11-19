package priv.cxs.springboot2.schedule.jobs;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/18 14:25
 */
@Slf4j
@DisallowConcurrentExecution
public class LongTimeCronJob extends AbstractCronJob {

    @Override
    public String getCron() {
        return "0/2 * * * * ?";
    }

    @Override
    protected void executeInternal(JobExecutionContext context) {
        log.info("start executing LongTimeCronJob ...... ");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("finish executing LongTimeCronJob ...... ");
    }
}
