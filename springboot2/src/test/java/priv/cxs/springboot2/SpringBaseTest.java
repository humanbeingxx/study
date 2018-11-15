package priv.cxs.springboot2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import priv.cxs.springboot2.dao.JobDao;

import javax.annotation.Resource;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/15 上午10:41
 **/
@SpringBootTest
@Slf4j
public class SpringBaseTest extends AbstractTestNGSpringContextTests {
    @Resource
    protected JobDao jobDao;

    @Resource
    protected RedisTemplate<String, String> template;

    @BeforeClass
    public void init() {
        log.info("********** init mysql && redis **********");
        jobDao.flushAll();
        template.delete(template.keys("*"));
    }

    @AfterClass
    public void reset() {
        log.info("********** reset mysql && redis **********");
        jobDao.flushAll();
        template.delete(template.keys("*"));
    }
}
