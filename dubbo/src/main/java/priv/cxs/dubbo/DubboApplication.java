package priv.cxs.dubbo;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableDubbo
//@ImportResource({"classpath:dubbo-consumer.xml"})
@ComponentScan(excludeFilters = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = {DubboConsumerApplication.class}
))
public class DubboApplication extends SpringBootServletInitializer {

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("multicast://224.5.6.7:1234");
        return registryConfig;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DubboApplication.class);
    }

    public static void main(String[] args) {
//        ExtensionLoader<Transporter> loader = ExtensionLoader.getExtensionLoader(Transporter.class);
//        Transporter adaptiveExtension = loader.getAdaptiveExtension();
//        System.out.println(adaptiveExtension);

        SpringApplication.run(DubboApplication.class, args);
//        List<Filter> filters = ExtensionLoader.getExtensionLoader(Filter.class).getActivateExtension(URL.valueOf("dubbo://"), "service.filter", "provider");
//        System.out.println(filters);
    }
}
