package priv.cxs.springboot2.service;

import com.google.common.collect.Lists;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import priv.cxs.springboot2.SpringBaseTest;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.model.JobType;
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
    public void testStatistics() throws InterruptedException {
        scheduleInitializeService.initJobs();
        Thread.sleep(100);
    }
}