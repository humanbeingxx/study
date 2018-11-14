package priv.cxs.springboot2.service;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.model.JobType;

import javax.annotation.Resource;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 1:40
 */
@SpringBootTest
public class JobServiceImplTest extends AbstractTestNGSpringContextTests {

    @Resource
    private JobServiceImpl jobService;

    @Test
    public void insertOne() {
        jobService.insertOne(Job.builder().name("java 后端").level(6)
                .address("朝阳区").salary(30000).jobType(JobType.JAVA).build());
    }

    @Test
    public void selectAll() {
        System.out.println(jobService.getAll());
    }

    @Test
    public void testNew() {
        jobService.deleteTwiceWithNewTransaction("java");
    }

    @Test
    public void testNested() {
        jobService.deleteTwiceWithNestedTransaction("java");
    }

    @Test
    public void testQueryOne() {
        Job job = jobService.getOne("java3");
        System.out.println(job);
    }
}