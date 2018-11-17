package priv.cxs.springboot2.schedule.jobs;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.context.ApplicationContext;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.model.JobStatistics;
import priv.cxs.springboot2.service.JobService;

import java.util.List;

/**
 * @author xiaoshuangB.cui
 * @date 2018/11/15 下午4:23
 **/
@Slf4j
public class StatisticsCronJob extends AbstractCronJob {

    private JobService jobService;

    public StatisticsCronJob(ApplicationContext applicationContext) {
        Preconditions.checkNotNull(applicationContext);
        jobService = applicationContext.getBean(JobService.class);
        Preconditions.checkNotNull(jobService);
    }

    @Override
    protected void executeInternal(JobExecutionContext context) {
        List<Job> jobs = jobService.getAll();
        JobStatistics statistics = JobStatistics.calculate(jobs);
        log.info("quartz statistics {}", JSON.toJSONString(statistics));
    }

    @Override
    public String identity() {
        return "StatisticsCronJob";
    }

    @Override
    public String getCron() {
        return "0/3 * * * * ?";
    }
}
