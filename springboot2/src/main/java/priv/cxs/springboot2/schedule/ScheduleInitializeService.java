package priv.cxs.springboot2.schedule;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.listeners.JobListenerSupport;
import org.quartz.listeners.TriggerListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import priv.cxs.springboot2.schedule.jobs.AbstractCronJob;

import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/17 15:30
 */
@Service
@Slf4j
public class ScheduleInitializeService implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private Scheduler scheduler;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("ContextRefreshedEvent listened, starting init schedule!!!");
        try {
            initJobs();
        } catch (SchedulerException e) {
            log.error("initialize quartz error", e);
        }
    }

    public void initJobs() throws SchedulerException {
        List<AbstractCronJob> jobs = JobCollector.collectJobClasses();
        for (AbstractCronJob job : jobs) {
            JobKey jobKey = JobCollector.generateJobKey(job.identity());


            JobDetail existDetail = scheduler.getJobDetail(jobKey);

            JobBuilder jobBuilder = JobBuilder.newJob(job.getClass())
                    .withIdentity(jobKey)
                    .storeDurably(true);
            if (existDetail != null) {
                jobBuilder.usingJobData(existDetail.getJobDataMap());
            }
            scheduler.addJob(jobBuilder.build(), true);
        }
        addListeners();
    }

    private void addListeners() throws SchedulerException {
        ListenerManager listenerManager = scheduler.getListenerManager();

        listenerManager.addJobListener(new JobListenerSupport() {
            @Override
            public String getName() {
                return "GeneralJobListener";
            }

            @Override
            public void jobToBeExecuted(JobExecutionContext context) {
                JobKey key = context.getJobDetail().getKey();
                log.info("------------------- job {}:{} to be executed -------------------", key.getGroup(), key.getName());
            }

            @Override
            public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
                JobKey key = context.getJobDetail().getKey();
                log.info("------------------- job {}:{} was executed -------------------", key.getGroup(), key.getName());
            }
        });

        listenerManager.addTriggerListener(new TriggerListenerSupport() {
            @Override
            public String getName() {
                return "GeneralTriggerListener";
            }

            @Override
            public void triggerFired(Trigger trigger, JobExecutionContext context) {
                TriggerKey key = context.getTrigger().getKey();
                log.info("------------------- trigger {}:{} was fired -------------------", key.getGroup(), key.getName());
            }

            @Override
            public void triggerMisfired(Trigger trigger) {
                TriggerKey key = trigger.getKey();
                log.info("------------------- trigger {}:{} misfired with policy {}-------------------",
                        key.getGroup(), key.getName(), trigger.getMisfireInstruction());
            }

            @Override
            public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
                TriggerKey key = context.getTrigger().getKey();
                log.info("------------------- trigger {}:{} was completed -------------------", key.getGroup(), key.getName());
            }
        });
    }
}
