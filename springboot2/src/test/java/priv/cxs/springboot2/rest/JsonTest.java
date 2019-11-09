package priv.cxs.springboot2.rest;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

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

    @Test
    public void testArrayAndList() {
        List<String> list = Lists.newArrayList();
        String[] array = new String[10000];

        for (int i = 0; i < 10000; i++) {
            list.add("test");
            array[i] = "test";
        }

        JSON.toJSONString(list);
        JSON.toJSONString(array);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            JSON.toJSONString(array);
        }
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            JSON.toJSONString(list);
        }
        System.out.println(System.currentTimeMillis() - startTime);

    }

    @Test
    public void testForLoop() {
        List<String> list = Lists.newArrayList();
        String[] array = new String[10000];

        for (int i = 0; i < 10000; i++) {
            list.add("test");
            array[i] = "test";
        }

        JSON.toJSONString(list);
        JSON.toJSONString(array);

        for (int i = 0; i < 1000; i++) {
            JSON.toJSONString(array);
            JSON.toJSONString(list);
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            JSON.toJSONString(array);
            JSON.toJSONString(list);
        }

        System.out.println(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            JSON.toJSONString(array);
        }

        for (int i = 0; i < 1000; i++) {
            JSON.toJSONString(list);
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
