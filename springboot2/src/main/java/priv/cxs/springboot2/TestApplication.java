package priv.cxs.springboot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@SpringBootApplication
public class TestApplication {

    @Configuration
    public static class AppConfig {
        public AppConfig() {
        }

        @Bean
        public Object beanA() {
            return new Object();
        }

        @Bean
        public Object beanB() {
            System.out.println(System.identityHashCode(beanA()));
            return new Object();
        }

        @Bean
        public A beanA1(){
            return new A();
        }

        @Bean
        public A beanA2(){
            return new A();
        }

        @Resource(type = A.class)
        private A beanA1;

        @Bean
        public B beanB1() {
            return new B();
        }

        @Autowired
        private B beanA2;

        @Resource
        private B beanB2;
    }

    static class A {}
    static class B {}



    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig appConfig = context.getBean(AppConfig.class);
        Object beanA = context.getBean("beanA");
        System.out.println(System.identityHashCode(beanA));
        Object beanB = context.getBean("beanB");

        System.out.println(appConfig.beanA1);
        System.out.println(appConfig.beanA2);
        System.out.println(appConfig.beanB2);
    }
}
