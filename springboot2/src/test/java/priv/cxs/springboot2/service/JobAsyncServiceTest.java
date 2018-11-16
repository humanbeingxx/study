package priv.cxs.springboot2.service;
import priv.cxs.springboot2.model.JobType;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import priv.cxs.springboot2.SpringBaseTest;
import priv.cxs.springboot2.model.Job;

import javax.annotation.Resource;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/15 下午2:46
 **/
@Slf4j
public class JobAsyncServiceTest extends SpringBaseTest {

    @Resource
    private JobAsyncService jobAsyncService;

    @Test
    public void testInner() {
        jobAsyncService.notifyInner();
    }

    @Test
    public void test() {
        Job newOne = new Job();
        newOne.setCode(1);
        newOne.setName("javax");
        newOne.setSalary(1000);
        newOne.setAddress("东升科技园");
        newOne.setLevel(1);
        newOne.setJobType(JobType.codeOf(1));


        jobAsyncService.notifyJobChange(null, newOne);
    }
}
