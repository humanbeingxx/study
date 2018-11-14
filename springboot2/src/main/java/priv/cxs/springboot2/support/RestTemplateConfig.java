package priv.cxs.springboot2.support;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.apache.commons.codec.Charsets;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/14 下午4:26
 **/
@Configuration
public class RestTemplateConfig {

    @Bean("restTemplate")
    public RestTemplate pooledRestTemplate() {
        RestTemplate template = new RestTemplate();
        template.setRequestFactory(pooledFactory());
        extendMessageConverters(template.getMessageConverters());
        return template;
    }

    private void extendMessageConverters(List<HttpMessageConverter<?>> origin) {
        origin.removeIf(converter -> converter instanceof StringHttpMessageConverter
                || converter instanceof GsonHttpMessageConverter
                || converter instanceof JsonbHttpMessageConverter);
        origin.add(new StringHttpMessageConverter(Charsets.UTF_8));
    }

    private ClientHttpRequestFactory pooledFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(pooledClient());
        // 从连接池获取连接的超时事件
        factory.setConnectionRequestTimeout(500);
        factory.setConnectTimeout(500);
        factory.setReadTimeout(1000);
        return factory;
    }

    private HttpClient pooledClient() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(20);
        connectionManager.setValidateAfterInactivity(2000);
        return HttpClients.custom().setConnectionManager(connectionManager).build();
    }
}
