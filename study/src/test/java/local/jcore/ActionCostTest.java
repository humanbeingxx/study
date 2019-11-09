package local.jcore;

import com.google.common.base.Splitter;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2019-08-12
 **/
public class ActionCostTest {

    @Test
    public void testNewArray() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String[] strings = new String[3000];
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

    @Test
    public void testSplit() {
        String value = "a,b,c,d,e,f,g,h";

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String[] split = value.split(",");
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

    @Test
    public void testGuavaSplit() {
        String value = "a,b,c,d,e,f,g,h";
        Splitter splitter = Splitter.on(",");

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            List<String> list = Lists.newArrayList();
            for (String s : splitter.split(value)) {
                list.add(s);
            }
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
