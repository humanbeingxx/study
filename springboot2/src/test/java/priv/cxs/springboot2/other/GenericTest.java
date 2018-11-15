package priv.cxs.springboot2.other;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 22:25
 */
public class GenericTest {

    @Test
    public void test() {
        List<String> stringList;
        List integerList = Lists.newArrayList(1, 2, 3);
        stringList = integerList;
        Object data = stringList.get(0);
        System.out.println(data);
    }
}
