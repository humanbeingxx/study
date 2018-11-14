package priv.cxs.springboot2.support;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/5 0:42
 */
@SpringBootTest
public class PropertiesDrivenConfigTest {

    @Resource
    private PropertiesDrivenConfig config;

    @Test
    public void test() {
        System.out.println(config);
    }
}