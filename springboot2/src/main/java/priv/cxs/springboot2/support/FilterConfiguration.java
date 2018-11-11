package priv.cxs.springboot2.support;

import com.google.common.collect.Lists;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import priv.cxs.springboot2.support.web.JobSalaryEncryptFilter;
import priv.cxs.springboot2.support.web.TestFilter;

import javax.servlet.Filter;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/5 下午5:59
 **/
@Configuration
public class FilterConfiguration {

    @Bean(name = "testFilter")
    public TestFilter testFilter() {
        return new TestFilter();
    }

    @Bean
    public JobSalaryEncryptFilter jobSalaryEncryptFilter() {
        return new JobSalaryEncryptFilter();
    }

    @Bean
    public FilterRegistrationBean jobEncryptConfig() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(jobSalaryEncryptFilter());
        registrationBean.setUrlPatterns(Lists.newArrayList("/job/*"));
        registrationBean.setName("jobSalaryEncryptFilter");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean configTest() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(testFilter());
        registrationBean.setUrlPatterns(Lists.newArrayList("/job/add", "/job/delete"));
        registrationBean.setName("testFilter");
        return registrationBean;
    }
}
