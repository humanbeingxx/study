package priv.cxs.springboot2.support.aop;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.service.JobEnhance;
import priv.cxs.springboot2.service.JobServiceImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/6 下午3:43
 **/
@SpringBootTest
public class JobEnhanceAspectTest extends AbstractTestNGSpringContextTests {

    @Resource
    private JobServiceImpl jobService;

    @Test
    public void test() {
        List<Job> all = jobService.getAll();
        System.out.println(all);
        ((JobEnhance) jobService).enhanceTest();
    }
}