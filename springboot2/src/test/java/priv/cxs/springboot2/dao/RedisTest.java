package priv.cxs.springboot2.dao;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import priv.cxs.springboot2.dao.config.redis.RedisConfiguration;

import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/7 16:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@SuppressWarnings("unchecked")
public class RedisTest {

    private static AnnotationConfigApplicationContext context = null;
    private static RedisTemplate<String, String> template = null;

    @BeforeClass
    public static void init() {
        context = new AnnotationConfigApplicationContext(RedisConfiguration.class);
        template = (RedisTemplate<String, String>)context.getBean(RedisTemplate.class);
    }

    @Test
    public void testRedis() {
        ValueOperations<String, String> operations = template.opsForValue();
        Object value1 = operations.get("test_key1");
        System.out.println(value1);

        operations.set("test_key2", "test_value2");
    }

    @Test
    public void testRedisMap() {
        Object value1 = template.opsForHash().get("test_map", "test_map_key1");
        System.out.println(value1);
    }

    @Test
    public void testWatch() {
        List<Object> result = template.execute(new SessionCallback<List<Object>>() {
            @Override
            public List<Object> execute(RedisOperations operations) throws DataAccessException {
                operations.watch("test_increment");
                operations.multi();
                operations.opsForValue().set("test_watch1", "1");
                operations.opsForValue().increment("test_cannot_incr");
                operations.opsForValue().set("test_watch2", "2");
                return operations.exec();
            }
        });
        System.out.println(result);
    }

    @Test
    public void testPipeline() {
        long begin = System.currentTimeMillis();
        template.executePipelined(new SessionCallback<Object>() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                for (int i = 0; i < 100000; i++) {
                    operations.opsForValue().increment("test_increment");
                }
                return null;
            }
        });
        System.out.println("pipeline cost " + (System.currentTimeMillis() - begin));

        begin = System.currentTimeMillis();
        template.execute(new SessionCallback<Object>() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                for (int i = 0; i < 100000; i++) {
                    operations.opsForValue().increment("test_increment");
                }
                return null;
            }
        });

        System.out.println("non-pipeline cost " + (System.currentTimeMillis() - begin));
    }
}
