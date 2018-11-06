package priv.cxs.springboot2.support;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/5 0:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesDrivenConfigTest {

    @Resource
    private PropertiesDrivenConfig config;

    @Test
    public void test() {
        System.out.println(config);
    }
}