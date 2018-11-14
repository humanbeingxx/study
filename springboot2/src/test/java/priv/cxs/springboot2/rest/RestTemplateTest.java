package priv.cxs.springboot2.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import priv.cxs.springboot2.controller.view.WebRet;
import priv.cxs.springboot2.model.Job;

import javax.annotation.Resource;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/14 下午3:44
 **/
@Slf4j
@SpringBootTest
public class RestTemplateTest extends AbstractTestNGSpringContextTests {

    @Resource
    private RestTemplate template;

    @Test
    public void testGet() {
        String url = "http://127.0.0.1:8080/springboot2/rest/job/{code}";

        ResponseEntity<WebRet> entity = template.getForEntity(url, WebRet.class, 1);

        Assert.assertEquals(entity.getStatusCodeValue(), 200);
        WebRet result = entity.getBody();

        Assert.assertNotNull(result);
        Assert.assertTrue(result.isSuccess());
        Assert.assertFalse(result.getData() instanceof Job);
    }

    @Test
    public void testGeneric() {
        String url = "http://127.0.0.1:8080/springboot2/rest/job/{code}";

        ResponseEntity<WebRet<Job>> entity = template.exchange(url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<WebRet<Job>>(){},
                1);

        Assert.assertEquals(entity.getStatusCodeValue(), 200);
        WebRet result = entity.getBody();

        Assert.assertNotNull(result);
        Assert.assertTrue(result.isSuccess());
        Assert.assertTrue(result.getData() instanceof Job);
    }
}
