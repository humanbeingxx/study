package priv.cxs.springboot2.schedule;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
        initJobs();
    }

    public void initJobs() {
        List<AbstractCronJob> jobs = JobCollector.collectJobClasses();
        for (AbstractCronJob job : jobs) {
            JobKey jobKey = JobCollector.generateJobKey(job.identity());

            try {
                JobDetail existDetail = scheduler.getJobDetail(jobKey);

                JobDetail jobDetail = JobBuilder.newJob(job.getClass())
                        .withIdentity(jobKey)
                        .storeDurably(true)
                        .usingJobData(existDetail == null ? null : existDetail.getJobDataMap())
                        .build();
                scheduler.addJob(jobDetail, true);
            } catch (SchedulerException e) {
                log.error("schedule {} failed", job.identity(), e);
            }
        }
    }
}
