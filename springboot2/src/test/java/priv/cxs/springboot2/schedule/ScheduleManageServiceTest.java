package priv.cxs.springboot2.schedule;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import priv.cxs.springboot2.SpringBaseTest;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.model.JobType;
import priv.cxs.springboot2.service.JobService;

import javax.annotation.Resource;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/17 21:41
 */
@Slf4j
public class ScheduleManageServiceTest extends SpringBaseTest {

    @Autowired
    private ScheduleManageService manageService;

    @Resource
    private JobService jobService;

    @BeforeClass
    @Override
    public void init() {
        super.init();
        jobService.insertMulti(Lists.newArrayList(
                Job.builder().code(1).name("java1").address("北京市朝阳区").salary(1000).jobType(JobType.JAVA).level(1).build(),
                Job.builder().code(2).name("java2").address("北京市海淀区").salary(1500).jobType(JobType.JAVA).level(1).build(),
                Job.builder().code(3).name("java3").address("北京市东城区").salary(2000).jobType(JobType.JAVA).level(1).build()
        ));
    }

    @Test
    public void test() throws InterruptedException, SchedulerException {
        manageService.enable("StatisticsCronJob");
        manageService.enable("PublishCronJob");
        Thread.sleep(7000);
        log.info("********************enable test finished, start disable********************");

        manageService.disable("StatisticsCronJob");
        log.info("********************disable StatisticsCronJob finished********************");
        manageService.disable("PublishCronJob");
        log.info("********************disable PublishCronJob finished********************");
        Thread.sleep(1000);
    }
}