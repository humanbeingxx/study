package priv.cxs.dubbo;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest(classes = DubboConsumerApplication.class)
public class DubboConsumerApplicationTest extends AbstractTestNGSpringContextTests {

    @DubboReference(injvm = false, cluster = "failfast", timeout = 600000)
    private TestService useTestService2;

    @Test
    public void testConsume() {
        String response = useTestService2.nothing();
        System.out.println(response);
    }
}