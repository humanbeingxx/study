package priv.cxs.springboot2.service;

import com.google.common.collect.Lists;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import priv.cxs.springboot2.SpringBaseTest;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.model.JobType;

import static org.testng.Assert.*;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/15 下午3:08
 **/
public class JobScheduleServiceTest extends SpringBaseTest {

    @BeforeClass
    @Override
    public void init() {
        super.init();
        jobDao.insertMulti(Lists.newArrayList(
                Job.builder().code(1).name("java1").address("北京市朝阳区").salary(1000).jobType(JobType.JAVA).level(1).build(),
                Job.builder().code(2).name("java2").address("北京市海淀区").salary(1500).jobType(JobType.JAVA).level(1).build(),
                Job.builder().code(3).name("java3").address("北京市东城区").salary(2000).jobType(JobType.JAVA).level(1).build()
        ));
    }

    @Test
    public void testStatistics() throws InterruptedException {
        Thread.sleep(10000);
    }
}