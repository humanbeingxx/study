package priv.cxs.springboot2.service;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import priv.cxs.springboot2.dao.JobDao;
import priv.cxs.springboot2.model.Job;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/15 下午3:00
 **/
@Service
@Slf4j
public class JobScheduleService {

    @Resource
    private JobDao jobDao;

    @Scheduled(cron = "0/3 * * * * ?")
    public void statistics() {
        List<Job> jobs = jobDao.selectAll();
        log.info("{}", JSON.toJSONString(JobStatistics.calculate(jobs)));
    }

    @Data
    private static class JobStatistics {
        int count;
        List<String> names;
        int salarySum;

        public static JobStatistics calculate(List<Job> jobs) {
            JobStatistics statistics = new JobStatistics();
            statistics.setCount(jobs.size());
            statistics.setNames(jobs.stream().map(Job::getName).collect(Collectors.toList()));
            statistics.setSalarySum(jobs.stream()
                    .map(Job::getSalary)
                    .reduce((i1, i2) -> i1 + i2)
                    .orElse(0));

            return statistics;
        }
    }
}
