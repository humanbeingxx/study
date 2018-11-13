package priv.cxs.springboot2.rest;

import com.google.common.base.Charsets;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/13 下午5:34
 **/
@Slf4j
public class RestHttpTest {

    static CloseableHttpClient client;

    @BeforeClass
    public static void init() {
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
        manager.setMaxTotal(10);
        client = HttpClientBuilder.create().setConnectionManager(manager).build();
    }

    @Test
    public void test() throws IOException {
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        CloseableHttpResponse response = client.execute(httpGet);
        String result = EntityUtils.toString(response.getEntity(), Charsets.UTF_8);
        log.info("{}", result);
    }
}
