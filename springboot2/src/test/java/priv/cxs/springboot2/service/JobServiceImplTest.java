package priv.cxs.springboot2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import priv.cxs.springboot2.SpringBaseTest;
import priv.cxs.springboot2.dao.JobDao;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.model.JobType;

import javax.annotation.Resource;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 1:40
 */
@Slf4j
public class JobServiceImplTest extends SpringBaseTest {

    @Resource
    private JobServiceImpl jobService;

    @Resource
    private JobDao jobDao;

    @Resource
    private RedisTemplate<String, String> template;

    @BeforeClass
    public void init() {
        jobDao.flushAll();
        template.delete(template.keys("*"));
    }

    @AfterClass
    public void reset() {
        jobDao.flushAll();
        template.delete(template.keys("*"));
    }

    @Test
    public void insertOne() {
        jobService.insertOne(Job.builder().code(1).name("java1").level(1)
                .address("朝阳区").salary(30000).jobType(JobType.JAVA).build());
    }

    @Test(dependsOnMethods = "insertOne")
    public void selectAll() {
        log.info("all = {}", jobService.getAll());
    }

    @Test(dependsOnMethods = "insertOne")
    public void testNew() {
        jobService.deleteTwiceWithNewTransaction("java");
    }

    @Test(dependsOnMethods = "insertOne")
    public void testNested() {
        jobService.deleteTwiceWithNestedTransaction("java");
    }

    @Test(dependsOnMethods = "insertOne")
    public void testQueryOne() {
        Job job = jobService.getOne("java1");
        log.info("{}", job);
    }
}