package local.algorithm;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

public class OpenApiSignTest {

    public static final String MOCK_URL = "https://mock.com";

    @Test
    public void testWrongPWD() {

        String token = OpenApiSign.getToken("testUser", "123456");
        Assert.assertEquals(token, "");
    }

    @Test
    public void testCorrectPWD() {
        String token = OpenApiSign.getToken("testUser", "tesPWD");
        Assert.assertTrue(StringUtils.isNotBlank(token));
        Assert.assertTrue(OpenApiSign.tokens.contains(token));
    }

    @Test
    public void testSign() {

        boolean check = OpenApiSign.checkSign(generateUrl());

        Assert.assertTrue(check);
    }

    private String generateUrl() {
        String token = OpenApiSign.getToken("testUser", "tesPWD");

        Joiner.MapJoiner mapJoiner = Joiner.on("&").withKeyValueSeparator("=");
        LinkedHashMap<String, String> params = Maps.newLinkedHashMap();
        params.put("param1", "value1");
        params.put("param2", "value2");
        params.put("token", token);
        params.put("time", String.valueOf(System.currentTimeMillis()));

        String url = MOCK_URL + "?" + mapJoiner.join(params);

        String sign = OpenApiSign.generateSign(url);
        return url + "&sign=" + sign;
    }

    @Test
    public void testRequest() {
        String url = generateUrl();
        OpenApiSign.request(url);
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testRequestTooOften() {
        String url = generateUrl();
        OpenApiSign.request(url);
        OpenApiSign.request(url);
    }

    @Test
    public void testRequestNotOften() throws InterruptedException {
        String url = generateUrl();
        OpenApiSign.request(url);
        Thread.sleep(1100);
        OpenApiSign.request(url);
    }

}