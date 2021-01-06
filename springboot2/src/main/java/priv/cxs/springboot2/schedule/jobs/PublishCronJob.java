package priv.cxs.springboot2.schedule.jobs;

import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.service.JobService;

import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/17 21:36
 */
@Slf4j
@DisallowConcurrentExecution
public class PublishCronJob extends AbstractCronJob {

    private static final Joiner JOINER = Joiner.on("_");

    @Override
    public String getCron() {
        return "0/2 * * * * ?";
    }

    @Override
    protected void executeInternal(JobExecutionContext context) {
        JobService jobService = getApplicationContext(context).getBean(JobService.class);
        List<Job> jobs = jobService.getAll();
        log.info("publishing begin.......");
        for (Job job : jobs) {
            log.info(publishInfo(job));
        }
        log.info("publishing finish.......");
    }

    private String publishInfo(Job job) {
        return "publishing =>> " + JOINER.join(
                job.getCode(),
                job.getName(),
                job.getAddress(),
                job.getSalary(),
                job.getLevel(),
                job.getJobType().name()
        );
    }
}
