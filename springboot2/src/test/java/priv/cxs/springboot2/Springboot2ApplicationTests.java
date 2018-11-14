package priv.cxs.springboot2;

import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import priv.cxs.springboot2.support.TestConfig;

import java.util.Map;

@SpringBootTest
public class Springboot2ApplicationTests extends AbstractTestNGSpringContextTests {

    @Test
    public void contextLoads() {

    }

    @Test
    public void testWithSingleConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        Map<String, String> config = context.getBean("config1", Map.class);
        System.out.println(config);

        try {
            Object testService = context.getBean("testService");
            Assert.fail();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

}
