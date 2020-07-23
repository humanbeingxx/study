package priv.cxs.springboot2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = {"priv.cxs.springboot2.dao"})
@PropertySource(value = {"classpath:config.properties"})
@EnableCaching
@EnableAsync
@EnableScheduling
public class Springboot2Application extends SpringBootServletInitializer {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "hello boot";
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Springboot2Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Springboot2Application.class, args);
    }
}
