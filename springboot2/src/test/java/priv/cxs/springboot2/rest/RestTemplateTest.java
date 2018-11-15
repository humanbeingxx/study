package priv.cxs.springboot2.rest;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import priv.cxs.springboot2.SpringBaseTest;
import priv.cxs.springboot2.controller.view.WebRet;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.model.JobType;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/14 下午3:44
 **/
@Slf4j
public class RestTemplateTest extends SpringBaseTest {

    @Resource
    private RestTemplate restTemplate;

    @Test
    public void testGet() {
        String url = "http://127.0.0.1:8080/springboot2/rest/job/{code}";

        ResponseEntity<WebRet> entity = restTemplate.getForEntity(url, WebRet.class, 1);

        Assert.assertEquals(entity.getStatusCodeValue(), 200);
        WebRet result = entity.getBody();

        Assert.assertNotNull(result);
        Assert.assertTrue(result.isSuccess());
        Assert.assertFalse(result.getData() instanceof Job);
    }

    @Test
    public void testPost() {
        RequestEntity<List<Job>> requestEntity = RequestEntity.post(URI.create("http://127.0.0.1:8080/springboot2/rest/job"))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(getData());

        ResponseEntity<WebRet> responseEntity = restTemplate.postForEntity("http://127.0.0.1:8080/springboot2/rest/job", requestEntity, WebRet.class);

        WebRet ret = responseEntity.getBody();
        Assert.assertNotNull(ret);
        Assert.assertTrue(ret.isSuccess());
    }

    private List<Job> getData() {
        Job job = new Job();
        job.setCode(1);
        job.setName("java1");
        job.setSalary(1000);
        job.setAddress("北京市海淀区");
        job.setLevel(1);
        job.setJobType(JobType.codeOf(1));
        return Lists.newArrayList(job);
    }


    @Test(dependsOnMethods = "testPost")
    public void testGeneric() {
        String url = "http://127.0.0.1:8080/springboot2/rest/job/{code}";

        ResponseEntity<WebRet<Job>> entity = restTemplate.exchange(url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<WebRet<Job>>() {
                },
                1);

        Assert.assertEquals(entity.getStatusCodeValue(), 200);
        WebRet result = entity.getBody();

        Assert.assertNotNull(result);
        Assert.assertTrue(result.isSuccess());
        Assert.assertTrue(result.getData() instanceof Job);
    }

    @Test
    public void testPostMulti() {
        RequestEntity<List<Job>> requestEntity = RequestEntity.post(URI.create("http://127.0.0.1:8080/springboot2/rest/job"))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(getDataList());

        ResponseEntity<WebRet> responseEntity = restTemplate.postForEntity("http://127.0.0.1:8080/springboot2/rest/job", requestEntity, WebRet.class);

        WebRet ret = responseEntity.getBody();
        Assert.assertNotNull(ret);
        Assert.assertFalse(ret.isSuccess());
        Assert.assertEquals(ret.getErrCode(), 400);
        Assert.assertEquals(ret.getMessage(), "必须是北京市地址;必须是北京市地址");
    }

    private List<Job> getDataList() {
        Job job1 = new Job();
        job1.setCode(2);
        job1.setName("java2");
        job1.setSalary(1000);
        job1.setAddress("海淀区");
        job1.setLevel(1);
        job1.setJobType(JobType.codeOf(1));

        Job job2 = new Job();
        job2.setCode(3);
        job2.setName("java3");
        job2.setSalary(1000);
        job2.setAddress("海淀区");
        job2.setLevel(1);
        job2.setJobType(JobType.codeOf(1));


        return Lists.newArrayList(job1, job2);

    }
}
