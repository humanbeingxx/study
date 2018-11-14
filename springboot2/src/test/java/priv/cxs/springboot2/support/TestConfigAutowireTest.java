package priv.cxs.springboot2.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 22:02
 */
@SpringBootTest
public class TestConfigAutowireTest extends AbstractTestNGSpringContextTests {


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

        System.out.println(config1);
        System.out.println(config2);

        Assert.assertNotNull(config19);
        System.out.println(config19.getClass());

        Assert.assertNull(configx);
    }

    @Test
    public void testValue() {
        System.out.println(value1);
    }
}