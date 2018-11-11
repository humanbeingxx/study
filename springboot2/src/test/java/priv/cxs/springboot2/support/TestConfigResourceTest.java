package priv.cxs.springboot2.support;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 22:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestConfigResourceTest {

//    @Resource(name = "config1")
//    private Map<String, String> config2_1;
//
//    @Resource(name = "config2")
//    private Map<String, String> config2_2;

//    @Resource(name = "config3")
//    private Map<String, String> config1;

//    @Resource
//    private Map<String, String> config1;
//
//    @Resource
//    private Map<String, String> config2;

    @Resource(name = "config2", type = List.class)
    private List<String> configx;

//    @Resource
//    private Map<String, String> config3;

//    @Resource(type = Set.class)
//    private Set<String> configxx;

    @Test
    public void test() {
//        Assert.assertNotNull(config1);
//        Assert.assertNotNull(config2);
//        Assert.assertNotNull(config2_1);
//        Assert.assertNotNull(config2_2);
//        Assert.assertEquals(configx.getClass(), ArrayList.class);
        System.out.println(configx);
//        System.out.println(configxx);
//        Assert.assertNotNull(config3);
    }
}