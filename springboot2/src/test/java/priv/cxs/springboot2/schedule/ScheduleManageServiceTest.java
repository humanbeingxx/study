package priv.cxs.springboot2.schedule;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import priv.cxs.springboot2.SpringBaseTest;
import priv.cxs.springboot2.controller.view.ScheduleJobView;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.model.JobType;
import priv.cxs.springboot2.service.JobService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/17 21:41
 */
@Slf4j
public class ScheduleManageServiceTest extends SpringBaseTest {

    @Autowired
    private ScheduleManageService manageService;

    @Autowired
    private Scheduler scheduler;

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

    @AfterClass
    public void reset() {
        try {
            scheduler.shutdown();
        } catch (SchedulerException e) {
            log.error("shutdown failed", e);
        }
    }

    @Test
    public void test() throws InterruptedException, SchedulerException {
        manageService.resume("StatisticsCronJob");
        manageService.resume("PublishCronJob");
        Thread.sleep(7000);
        log.info("********************enable test finished, start disable********************");

        manageService.pause("StatisticsCronJob");
        log.info("********************disable StatisticsCronJob finished********************");
        manageService.pause("PublishCronJob");
        log.info("********************disable PublishCronJob finished********************");
        Thread.sleep(1000);
    }

    @Test
    public void testConcurrent() throws SchedulerException, InterruptedException {
        manageService.resume("LongTimeCronJob");
        Thread.sleep(10000);
        manageService.pause("LongTimeCronJob");
    }

    @Test
    public void testAllJobs() throws SchedulerException, InterruptedException {
        List<ScheduleJobView> views = manageService.allJobs();
        Assert.assertEquals(views.size(), 3);

        manageService.resume("StatisticsCronJob");
        manageService.resume("PublishCronJob");
        manageService.resume("LongTimeCronJob");

        views = manageService.allJobs();

        Assert.assertTrue(views.stream()
                .allMatch(scheduleJobView -> StringUtils.isNotBlank(scheduleJobView.getTriggerCron())
                        && StringUtils.isNotBlank(scheduleJobView.getTriggerState())));

        Thread.sleep(3000);
    }


    @Test
    public void testReschedule() throws SchedulerException, InterruptedException {
        manageService.resume("StatisticsCronJob");
        Thread.sleep(4000);

        log.info("trying to reschedule StatisticsCronJob......");
        manageService.reschedule("StatisticsCronJob", "0/1 * * * * ?");
        Thread.sleep(6000);
    }

    @Test
    public void testContext() throws SchedulerException {
        Object context = scheduler.getContext().get("applicationContext");
        Assert.assertNotNull(context);
        Assert.assertTrue(context instanceof ApplicationContext);
    }
}