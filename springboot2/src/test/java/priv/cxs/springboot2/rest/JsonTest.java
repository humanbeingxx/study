package priv.cxs.springboot2.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/15 2:19
 */
public class JsonTest {

    @Test
    public void testJackson() throws IOException {
        String text = "true,123";
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.readValue(text, String.class);
        System.out.println(value);
    }
}
