package priv.cxs.springboot2.rest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import priv.cxs.springboot2.SpringBaseTest;
import priv.cxs.springboot2.controller.view.WebRet;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.model.JobType;

import java.io.IOException;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/13 下午5:34
 **/
@Slf4j
public class RestHttpTest extends SpringBaseTest {

    static CloseableHttpClient client;

    static TypeReference<WebRet<Job>> typeReference = new TypeReference<WebRet<Job>>() {
    };

    @BeforeClass
    public void init() {
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
        manager.setMaxTotal(10);
        client = HttpClientBuilder.create().setConnectionManager(manager).build();
        super.init();
    }

    @Test
    public void test() throws IOException {
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        CloseableHttpResponse response = client.execute(httpGet);
        String result = EntityUtils.toString(response.getEntity(), Charsets.UTF_8);
        log.info("{}", result);
    }

    @Test(dependsOnMethods = "testPost")
    public void testGet() throws IOException {
        HttpGet httpGet = new HttpGet("http://127.0.0.1:8080/springboot2/rest/job/9");
        CloseableHttpResponse response = client.execute(httpGet);
        String result = EntityUtils.toString(response.getEntity(), Charsets.UTF_8);
        WebRet<Job> jobWebRet = JSON.parseObject(result, typeReference);

        Assert.assertNotNull(jobWebRet);
        Assert.assertTrue(jobWebRet.isSuccess());
        Assert.assertNotNull(jobWebRet.getData());
        Job job = jobWebRet.getData();
        Assert.assertEquals(job.getName(), "java9");

        log.info("{}", result);
    }

    @Test
    public void testPost() throws IOException {
        HttpPost post = new HttpPost("http://127.0.0.1:8080/springboot2/rest/job");
        post.setEntity(new StringEntity(getDataList(), ContentType.create("application/json", Charsets.UTF_8)));
        CloseableHttpResponse response = client.execute(post);

        log.info("http status {}", response.getStatusLine().getStatusCode());
        String result = EntityUtils.toString(response.getEntity(), Charsets.UTF_8);
        if (response.getStatusLine().getStatusCode() == 200) {
            WebRet jobWebRet = JSON.parseObject(result, WebRet.class);
            log.info("{}", jobWebRet);
        } else {
            log.info("{}", result);
        }
    }

    @Test
    public void testPut() throws IOException {
        HttpPut put = new HttpPut("http://127.0.0.1:8080/springboot2/rest/job/9");
        put.setEntity(new StringEntity(getDataSingle(), ContentType.create("application/json", Charsets.UTF_8)));
        CloseableHttpResponse response = client.execute(put);

        String result = EntityUtils.toString(response.getEntity(), Charsets.UTF_8);
        WebRet jobWebRet = JSON.parseObject(result, WebRet.class);

        log.info("{}", jobWebRet);
    }

    @Test
    public void testDel() throws IOException {
        HttpDelete delete = new HttpDelete("http://127.0.0.1:8080/springboot2/rest/job/9");
        CloseableHttpResponse response = client.execute(delete);

        String result = EntityUtils.toString(response.getEntity(), Charsets.UTF_8);
        WebRet jobWebRet = JSON.parseObject(result, WebRet.class);

        log.info("{}", jobWebRet);
    }

    private String getDataList() {
        Job job9 = new Job();
        job9.setCode(9);
        job9.setName("java9");
        job9.setSalary(9000);
        job9.setAddress("北京市海淀区");
        job9.setLevel(2);
        job9.setJobType(JobType.codeOf(4));

        return JSON.toJSONString(Lists.newArrayList(job9));
    }

    private String getDataSingle() {
        Job job9 = new Job();
        job9.setCode(9);
        job9.setName("java9");
        job9.setSalary(7000);
        job9.setAddress("北京市海淀区");
        job9.setLevel(1);
        job9.setJobType(JobType.codeOf(4));

        return JSON.toJSONString(job9);
    }
}
