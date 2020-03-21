package priv.cxs.springboot2.service;

import org.quartz.SchedulerException;
import org.testng.annotations.Test;
import priv.cxs.springboot2.SpringBaseTest;
import priv.cxs.springboot2.schedule.ScheduleInitializeService;

import javax.annotation.Resource;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/15 下午3:08
 **/
public class JobScheduleInitializeServiceTest extends SpringBaseTest {

    @Resource
    private ScheduleInitializeService scheduleInitializeService;

    @Test
    public void testStatistics() throws InterruptedException, SchedulerException {
        scheduleInitializeService.initJobs();
        Thread.sleep(100);
    }
}