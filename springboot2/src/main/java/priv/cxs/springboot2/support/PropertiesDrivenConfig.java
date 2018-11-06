package priv.cxs.springboot2.support;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/5 0:37
 */
@Component
@ConfigurationProperties("config")
@Profile("dev")
@Data
public class PropertiesDrivenConfig {

    private String name;
    private String level;
    private String source;

}
