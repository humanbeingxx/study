package priv.cxs.springboot2.schedule.jobs;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.model.JobStatistics;
import priv.cxs.springboot2.service.JobService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiaoshuangB.cui
 * @date 2018/11/15 下午4:23
 **/
@Slf4j
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class StatisticsCronJob extends AbstractCronJob {

    @Override
    protected void executeInternal(JobExecutionContext context) {
        JobService jobService = getApplicationContext(context).getBean(JobService.class);
        List<Job> jobs = jobService.getAll();
        JobStatistics statistics = JobStatistics.calculate(jobs);

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        log.info("previous quartz dataMap {}", Lists.newArrayList(dataMap.values()));

        log.info("new quartz statistics {}", JSON.toJSONString(statistics));
        dataMap.put("job_statistics", JSON.toJSONString(statistics));
    }

    @Override
    public String getCron() {
        return "0/3 * * * * ?";
    }
}
