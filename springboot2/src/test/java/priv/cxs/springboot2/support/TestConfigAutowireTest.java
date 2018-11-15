package priv.cxs.springboot2.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import org.testng.annotations.Test;
import priv.cxs.springboot2.SpringBaseTest;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 22:02
 */
@Slf4j
public class TestConfigAutowireTest extends SpringBaseTest {


    @Autowired
    private Map<String, String> config1;

    @Autowired
    private Map<String, String> config2;

    @Autowired
    private Set<String> config19;

    @Autowired(required = false)
    private List<Integer> configx;

    @Value("#{config1.get('${testKey}')}")
    private String value1;

    @Test
    public void test() {
        Assert.assertNotNull(config1);
        Assert.assertNotNull(config2);

        log.info("{}", config1);
        log.info("{}", config2);

        Assert.assertNotNull(config19);
        log.info("{}", config19.getClass());

        Assert.assertNull(configx);
    }

    @Test
    public void testValue() {
        log.info("{}", value1);
    }
}