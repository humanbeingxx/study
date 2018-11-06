package priv.cxs.springboot2.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import priv.cxs.springboot2.model.Job;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 1:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JobServiceTest {

    @Resource
    private JobService jobService;

    @Test
    public void insertOne() {
        jobService.insertOne(Job.builder().name("java 后端").level(6).address("朝阳区").salary(30000).build());
    }

    @Test
    public void selectAll() {
        System.out.println(jobService.getAll());
    }
}