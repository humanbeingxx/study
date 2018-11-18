package priv.cxs.springboot2.schedule;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import priv.cxs.springboot2.controller.view.ScheduleJobView;
import priv.cxs.springboot2.schedule.jobs.AbstractCronJob;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public void resume(String name) throws SchedulerException {
        List<AbstractCronJob> jobs = JobCollector.collectJobClasses(applicationContext);

        for (AbstractCronJob job : jobs) {
            if (job.identity().equals(name)) {
                doResume(job);
                return;
            }
        }
        throw new IllegalArgumentException("unknown job " + name);
    }

    private void doResume(AbstractCronJob job) throws SchedulerException {

        checkValidJob(job);

        TriggerKey triggerKey = generateTriggerKey(job.identity());
        if (scheduler.checkExists(triggerKey)) {
            log.info("trigger {} already exist, try resuming", job.identity());
            scheduler.resumeTrigger(triggerKey);
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

    public void pause(String name) throws SchedulerException {
        List<AbstractCronJob> jobs = JobCollector.collectJobClasses(applicationContext);
        for (AbstractCronJob job : jobs) {
            if (job.identity().equals(name)) {
                doPause(job);
                return;
            }
        }
        throw new IllegalArgumentException("unknown job " + name);
    }

    private void doPause(AbstractCronJob job) throws SchedulerException {
        checkValidJob(job);

        TriggerKey triggerKey = generateTriggerKey(job.identity());
        if (!scheduler.checkExists(triggerKey)) {
            log.info("trigger {} is not scheduled", triggerKey.getName());
            return;
        }

        scheduler.pauseTrigger(triggerKey);
    }

    public void reschedule(String jobName, String cron) throws SchedulerException {
        List<AbstractCronJob> jobs = JobCollector.collectJobClasses(applicationContext);
        for (AbstractCronJob job : jobs) {
            if (job.identity().equals(jobName)) {
                doReschedule(job, cron);
                return;
            }
        }
        throw new IllegalArgumentException("unknown job " + jobName);
    }

    private void doReschedule(AbstractCronJob job, String cron) throws SchedulerException {
        checkValidJob(job);

        TriggerKey triggerKey = generateTriggerKey(job.identity());

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                .cronSchedule(cron)
                .withMisfireHandlingInstructionDoNothing();

        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .forJob(JobCollector.generateJobKey(job.identity()))
                .withIdentity(triggerKey)
                .withSchedule(scheduleBuilder)
                .startNow()
                .build();

        scheduler.rescheduleJob(triggerKey, cronTrigger);
    }

    public List<ScheduleJobView> allJobs() {
        List<AbstractCronJob> jobs = JobCollector.collectJobClasses(applicationContext);

        List<AbstractCronJob> registeredJobs = jobs.stream().filter(abstractCronJob -> {
            try {
                return scheduler.checkExists(JobCollector.generateJobKey(abstractCronJob.identity()));
            } catch (SchedulerException e) {
                throw new JobInitializeException(e);
            }
        }).collect(Collectors.toList());

        return registeredJobs.stream().map(this::constructView).collect(Collectors.toList());
    }

    private ScheduleJobView constructView(AbstractCronJob job) {
        try {
            ScheduleJobView jobView = new ScheduleJobView();
            jobView.setName(job.identity());

            TriggerKey triggerKey = JobCollector.generateTriggerKey(job.identity());
            Trigger trigger = scheduler.getTrigger(triggerKey);
            if (trigger instanceof CronTrigger) {
                jobView.setTriggerCron(((CronTrigger) trigger).getCronExpression());
            }


            Trigger.TriggerState triggerState = scheduler.getTriggerState(triggerKey);
            if (triggerState != null) {
                jobView.setTriggerState(triggerState.name());
            }
            return jobView;
        } catch (SchedulerException e) {
            log.error("query job error {}", job.identity(), e);
            throw new RuntimeException(e);
        }
    }
}
