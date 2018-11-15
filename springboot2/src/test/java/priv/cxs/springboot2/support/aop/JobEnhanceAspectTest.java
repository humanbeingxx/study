package priv.cxs.springboot2.support.aop;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import priv.cxs.springboot2.SpringBaseTest;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.service.JobEnhance;
import priv.cxs.springboot2.service.JobServiceImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/6 下午3:43
 **/
@Slf4j
public class JobEnhanceAspectTest extends SpringBaseTest {

    @Resource
    private JobServiceImpl jobService;

    @Test
    public void test() {
        List<Job> all = jobService.getAll();
        log.info("{}", all);
        ((JobEnhance) jobService).enhanceTest();
    }
}