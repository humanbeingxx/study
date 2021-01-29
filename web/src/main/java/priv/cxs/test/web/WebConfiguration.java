package priv.cxs.test.web;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        return new FastJsonHttpMessageConverter();
    }

    @Order(1)
    @Bean
    public HandlerInterceptor interceptor1() {
        return new HandlerInterceptor(){
            int id = 1;
        };
    }

    @Order(3)
    @Bean
    public HandlerInterceptor interceptor2() {
        return new HandlerInterceptor(){
            int id = 2;
        };
    }

    @Order(2)
    @Bean
    public HandlerInterceptor interceptor3() {
        return new HandlerInterceptor(){
            int id = 3;
        };
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor1());
        registry.addInterceptor(interceptor2());
        registry.addInterceptor(interceptor3());
    }
}
