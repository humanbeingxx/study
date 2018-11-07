package priv.cxs.springboot2.dao;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import priv.cxs.springboot2.dao.config.RedisConfiguration;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/7 16:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    private static AnnotationConfigApplicationContext context = null;
    private static RedisTemplate template = null;


    @BeforeClass
    public static void init() {
        context = new AnnotationConfigApplicationContext(RedisConfiguration.class);
        template = context.getBean(RedisTemplate.class);
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
}
