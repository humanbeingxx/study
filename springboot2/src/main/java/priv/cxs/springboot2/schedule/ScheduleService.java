package priv.cxs.springboot2.schedule;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import priv.cxs.springboot2.schedule.jobs.AbstractCronJob;
import priv.cxs.springboot2.schedule.jobs.StatisticsCronJob;

import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/17 15:30
 */
@Service
@Slf4j
public class ScheduleService {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Scheduler scheduler;

    private volatile boolean started = false;

    public synchronized void schedule() {
        if (started) {
            return;
        }
        List<AbstractCronJob> jobs = getJobs();
        for (AbstractCronJob job : jobs) {
            JobDetail jobDetail = JobBuilder.newJob(job.getClass())
                    .withIdentity("job :: " + job.identity())
                    .build();

            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCron()).withMisfireHandlingInstructionDoNothing();

            CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger :: " + job.identity())
                    .withSchedule(scheduleBuilder)
                    .startNow()
                    .build();

            try {
                scheduler.scheduleJob(jobDetail, cronTrigger);
            } catch (SchedulerException e) {
                log.error("schedule {} failed", job.identity(), e);
            }
        }

        started = true;
    }

    private List<AbstractCronJob> getJobs() {
        return JobCollector.collectJobClasses(applicationContext);
    }
}
