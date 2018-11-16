package priv.cxs.springboot2.support;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 21:30
 */
@Configuration
public class TestConfig {

    @Bean(name = "config1")
    public Map<String, String> getConfig1() {
        HashMap<String, String> map = Maps.newHashMap();
        map.put("key1.1", "value1.1");
        map.put("key1.2", "value1.2");
        map.put("key1.3", "value1.3");
        map.put("key1.4", "value1.4");
        return map;
    }

    @Bean(name = "config2")
    public Map<String, String> getConfig2() {
        HashMap<String, String> map = Maps.newHashMap();
        map.put("key2.1", "value2.1");
        map.put("key2.2", "value2.2");
        map.put("key2.3", "value2.3");
        map.put("key2.4", "value2.4");
        return map;
    }

    @Bean(name = "config2")
    public List<String> getConfig2_2() {
        return Lists.newArrayList("value1", "value2");
    }

    @Bean(name = "config19")
    public Set<String> getConfig19() {
        return Sets.newHashSet("value1", "value2");
    }

    @Bean(name = "config91")
    public List<String> getConfig91() {
        return Lists.newArrayList("value1", "value2");
    }
}
