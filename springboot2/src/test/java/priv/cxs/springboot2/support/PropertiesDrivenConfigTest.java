package priv.cxs.springboot2.support;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import priv.cxs.springboot2.SpringBaseTest;

import javax.annotation.Resource;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/5 0:42
 */
@Slf4j
public class PropertiesDrivenConfigTest extends SpringBaseTest {

    @Resource
    private PropertiesDrivenConfig config;

    @Test
    public void test() {
        log.info("{}", config);
    }
}