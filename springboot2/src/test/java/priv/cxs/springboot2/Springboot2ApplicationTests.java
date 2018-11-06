package priv.cxs.springboot2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import priv.cxs.springboot2.support.TestConfig;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot2ApplicationTests {

	@Test
	public void contextLoads() {

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
