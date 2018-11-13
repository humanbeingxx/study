package priv.cxs.springboot2.support.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import priv.cxs.springboot2.controller.view.JobMessageConverter;
import priv.cxs.springboot2.model.Job;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/10 21:15
 */
@Configuration
public class WebConfig {

    @Bean
    public HttpMessageConverter<Job> jobHttpMessageConverter() {
        return new JobMessageConverter();
    }
}
