package priv.cxs.springboot2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import priv.cxs.springboot2.dao.JobDao;
import priv.cxs.springboot2.dao.config.redis.RedisNullValue;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.model.JobType;
import priv.cxs.springboot2.service.JobService;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/9 下午5:59
 **/
@Slf4j
public class CacheTotalTest extends SpringBaseTest {

    @Resource
    private JobService jobService;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private JobDao jobDao;

    @BeforeMethod
    public void init() {
        jobDao.flushAll();
        Set keys = redisTemplate.keys("*");
        redisTemplate.delete(keys);
    }

    @AfterMethod
    public void reset() {
        jobDao.flushAll();
        Set keys = redisTemplate.keys("*");
        redisTemplate.delete(keys);
    }

    @Test
    public void test() {
        prepareStep1();
        checkStep1();

        prepareStep2();
        checkStep2();

        prepareStep3();
        checkStep3();

        prepareStep4();
        checkStep4();
    }

    // step1 insert
    private void prepareStep1() {
        Job job1 = new Job();
        job1.setCode(1);
        job1.setName("java1");
        job1.setSalary(1000);
        job1.setAddress("东升科技园");
        job1.setLevel(1);
        job1.setJobType(JobType.JAVA);

        Job job2 = new Job();
        job2.setCode(2);
        job2.setName("java2");
        job2.setSalary(1000);
        job2.setAddress("东升科技园");
        job2.setLevel(1);
        job2.setJobType(JobType.JAVA);

        jobService.insertOne(job1);
        jobService.insertOne(job2);
    }

    // step1 check value and expire
    private void checkStep1() {
        Job job1 = (Job) redisTemplate.opsForValue().get("job_1");
        Job job2 = (Job) redisTemplate.opsForValue().get("job_2");

        Assert.assertNotNull(job1);
        Assert.assertNotNull(job2);
        Assert.assertEquals("java1", job1.getName());
        Assert.assertEquals("java2", job2.getName());

        Long expire1 = redisTemplate.getExpire("job_1", TimeUnit.SECONDS);
        Long expire2 = redisTemplate.getExpire("job_2", TimeUnit.SECONDS);

        Assert.assertTrue(expire1 > 500 && expire1 < 601);
        Assert.assertTrue(expire2 > 500 && expire2 < 601);
    }

    // step2 query job which is not in redis
    private void prepareStep2() {
        redisTemplate.delete("job_1");

        jobService.getByCode(1);
    }

    private void checkStep2() {
        Job job1 = (Job) redisTemplate.opsForValue().get("job_1");

        Assert.assertNotNull(job1);
        Assert.assertEquals("java1", job1.getName());
        Long expire1 = redisTemplate.getExpire("job_1", TimeUnit.SECONDS);
        Assert.assertTrue(expire1 > 500 && expire1 < 601);
    }

    // step3 update job
    private void prepareStep3() {
        // make sure data exists in redis
        Assert.assertNotNull(jobService.getOne("java1"));
        Assert.assertNotNull(jobService.getByCode(1));

        Job jobExistByCode = (Job) redisTemplate.opsForValue().get("job_1");
        Job jobExistByName = (Job) redisTemplate.opsForValue().get("job_java1");
        Assert.assertNotNull(jobExistByCode);
        Assert.assertNotNull(jobExistByName);

        Job job1 = new Job();
        job1.setCode(1);
        job1.setName("java1");
        job1.setSalary(2000);
        job1.setAddress("东升科技园");
        job1.setLevel(2);
        job1.setJobType(JobType.JAVA);

        jobService.updateByCode(job1);
    }

    // step3 check update evict cache
    private void checkStep3() {
        Job jobExistByCode = (Job) redisTemplate.opsForValue().get("job_1");
        Job jobExistByName = (Job) redisTemplate.opsForValue().get("job_java1");
        Assert.assertNull(jobExistByCode);
        Assert.assertNull(jobExistByName);
    }

    // step4 query not exist data
    private void prepareStep4() {
        jobService.getOne("not_exist");
    }

    private void checkStep4() {
        Object jobNotExist = redisTemplate.opsForValue().get("job_not_exist");

        Assert.assertNotNull(jobNotExist);
        Assert.assertTrue(jobNotExist instanceof RedisNullValue);
    }
}
