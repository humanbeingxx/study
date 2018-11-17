package priv.cxs.springboot2.schedule;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import priv.cxs.springboot2.schedule.jobs.AbstractCronJob;

import java.util.List;

import static priv.cxs.springboot2.schedule.JobCollector.generateTriggerKey;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/17 21:03
 */
@Service
@Slf4j
public class ScheduleManageService {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Scheduler scheduler;

    public void enable(String name) throws SchedulerException {
        List<AbstractCronJob> jobs = JobCollector.collectJobClasses(applicationContext);

        for (AbstractCronJob job : jobs) {
            if (job.identity().equals(name)) {
                doEnable(job);
                return;
            }
        }
        throw new IllegalArgumentException("unknown job " + name);
    }

    private void doEnable(AbstractCronJob job) throws SchedulerException {

        checkValidJob(job);

        TriggerKey triggerKey = generateTriggerKey(job.identity());
        if (scheduler.checkExists(triggerKey)) {
            log.info("job {} already scheduled", job.identity());
            return;
        }

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                .cronSchedule(job.getCron())
                .withMisfireHandlingInstructionDoNothing();

        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .forJob(JobCollector.generateJobKey(job.identity()))
                .withIdentity(triggerKey)
                .withSchedule(scheduleBuilder)
                .startNow()
                .build();

        scheduler.scheduleJob(cronTrigger);
    }

    private void checkValidJob(AbstractCronJob job) throws SchedulerException {
        if (!scheduler.checkExists(JobCollector.generateJobKey((job.identity())))) {
            log.error("job {} existed !!!", job.identity());
            throw new IllegalStateException("unreached job " + job.identity());
        }

    }



    public void disable(String name) throws SchedulerException {
        List<AbstractCronJob> jobs = JobCollector.collectJobClasses(applicationContext);
        for (AbstractCronJob job : jobs) {
            if (job.identity().equals(name)) {
                doDisable(job);
                return;
            }
        }
        throw new IllegalArgumentException("unknown job " + name);
    }

    private void doDisable(AbstractCronJob job) throws SchedulerException {
        checkValidJob(job);

        TriggerKey triggerKey = generateTriggerKey(job.identity());
        if (!scheduler.checkExists(triggerKey)) {
            log.info("job {} is not scheduled", job.identity());
            return;
        }

        scheduler.unscheduleJob(triggerKey);
    }
}
