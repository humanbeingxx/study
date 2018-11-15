package priv.cxs.springboot2.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.ValueOperations;
import org.testng.annotations.Test;
import priv.cxs.springboot2.SpringBaseTest;

import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/7 16:34
 */
@SuppressWarnings("unchecked")
@Slf4j
public class RedisTest extends SpringBaseTest {

    @Test
    public void testRedis() {
        ValueOperations<String, String> operations = template.opsForValue();
        Object value1 = operations.get("test_key1");
        log.info("value1 = {}", value1);

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

        log.info("result = {}", result);
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
        log.info("pipeline cost  {}", System.currentTimeMillis() - begin);

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

        log.info("non-pipeline cost {}", System.currentTimeMillis() - begin);
    }
}
