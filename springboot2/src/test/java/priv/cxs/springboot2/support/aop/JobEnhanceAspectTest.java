package priv.cxs.springboot2.support.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.service.JobEnhance;
import priv.cxs.springboot2.service.JobServiceImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/6 下午3:43
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class JobEnhanceAspectTest {

    @Resource
    private JobServiceImpl jobService;

    @Test
    public void test() {
        List<Job> all = jobService.getAll();
        System.out.println(all);
        ((JobEnhance)jobService).enhanceTest();
    }
}