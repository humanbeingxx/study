package priv.cxs.springboot2.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;
import priv.cxs.springboot2.SpringBaseTest;
import priv.cxs.springboot2.schedule.jobs.AbstractCronJob;
import priv.cxs.springboot2.schedule.jobs.StatisticsCronJob;

import java.util.List;
import java.util.function.Function;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/17 16:10
 */
public class JobCollectorTest extends SpringBaseTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testCollectJobClasses() {
        List<AbstractCronJob> cronJobs = JobCollector.collectJobClasses(applicationContext);

        Assert.assertTrue(
                cronJobs.stream()
                        .map((Function<AbstractCronJob, Class>) AbstractCronJob::getClass)
                        .anyMatch(aClass -> aClass == StatisticsCronJob.class)
        );

        Assert.assertTrue(
                cronJobs.stream()
                        .map((Function<AbstractCronJob, Class>) AbstractCronJob::getClass)
                        .noneMatch(aClass -> aClass == AbstractCronJob.class)
        );
    }
}