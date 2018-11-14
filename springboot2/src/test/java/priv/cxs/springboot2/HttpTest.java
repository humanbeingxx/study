package priv.cxs.springboot2;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.model.JobType;

import java.io.IOException;
import java.net.URI;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/10 17:40
 */
public class HttpTest {

    static CloseableHttpClient client;

    @BeforeClass
    public static void init() {
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
        manager.setMaxTotal(10);
        client = HttpClientBuilder.create().setConnectionManager(manager).build();
    }


    @Test
    public void test() throws IOException {
        HttpPost request = new HttpPost();
        request.setURI(URI.create("http://127.0.0.1:8080/springboot2/test_yml/job/multiAdd"));
        HttpEntity entity = new StringEntity(getData(), ContentType.create("application/json", Charsets.UTF_8));
        request.setEntity(entity);

        try (CloseableHttpResponse response = client.execute(request)) {
            if (response.getStatusLine().getStatusCode() != 200) {
                Assert.fail(response.getStatusLine().getStatusCode() + "not 200");
            }
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        }
    }

    private String getData() {
        List<Job> data = Lists.newArrayList();

        Job job1 = new Job();
        job1.setCode(1);
        job1.setName("java1");
        job1.setSalary(1000);
        job1.setAddress("海淀区");
        job1.setLevel(1);
        job1.setJobType(JobType.JAVA);

        Job job2 = new Job();
        job2.setCode(2);
        job2.setName("java2");
        job2.setSalary(1100);
        job2.setAddress("海淀区");
        job2.setLevel(2);
        job2.setJobType(JobType.JAVA);

        data.add(job1);
        data.add(job2);

        return JSON.toJSONString(data);
    }
}
