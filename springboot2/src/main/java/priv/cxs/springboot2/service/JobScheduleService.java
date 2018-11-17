package priv.cxs.springboot2.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import priv.cxs.springboot2.dao.JobDao;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.model.JobStatistics;

import javax.annotation.Resource;
import java.util.List;

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
}
