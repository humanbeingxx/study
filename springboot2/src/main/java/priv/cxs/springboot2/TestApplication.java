package priv.cxs.springboot2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import priv.cxs.springboot2.aop.AspectUser1;

@SpringBootApplication
public class TestApplication {

    @Configuration
    public static class AppConfig {
        @Bean
        public Object beanA() {
            return new Object();
        }

        @Bean
        public Object beanB() {
            System.out.println(System.identityHashCode(beanA()));
            return new Object();
        }
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = context.getBean(AppConfig.class);
        Object beanA = context.getBean("beanA");
        System.out.println(System.identityHashCode(beanA));
        Object beanB = context.getBean("beanB");
    }
}
