package priv.cxs.dubbo;

import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(excludeFilters = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = {DubboApplication.class}
))
@SpringBootApplication
public class DubboConsumerApplication {

    @Bean("register")
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("multicast://224.5.6.7:1234");
        return registryConfig;
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(DubboConsumerApplication.class)
                .web(WebApplicationType.NONE)
                .build().run();
    }
}
