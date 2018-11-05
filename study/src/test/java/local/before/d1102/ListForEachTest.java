package local.before.d1102;

import com.google.common.collect.Lists;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/2 下午12:54
 **/
public class ListForEachTest {

    @Test
    public void test() {
        List<Object> arrayList = Lists.newArrayListWithExpectedSize(10000000);
        for (int i = 0; i < 10000000; i++) {
            arrayList.add(i);
        }
        List<Object> linkedList = Lists.newLinkedList(arrayList);

        long startTime = System.currentTimeMillis();

        for (Object o : arrayList) {
            Assert.assertNotNull(o);
        }

        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();

        for (Object o : linkedList) {
            Assert.assertNotNull(o);
        }

        System.out.println(System.currentTimeMillis() - startTime);
    }
}
