package local.jcore.err;

import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2019-07-12
 **/
public class OOMTest {

    @Test
    public void testHeapSpace() {
        List<int[]> list = Lists.newLinkedList();
        try {
            for (int i = 0; i < 10000000; i++) {
                int[] ints = new int[100];
                list.add(ints);
            }
        } catch (Throwable e) {
            throw e;
        }
    }

    @Test
    public void testGCOverHead() {
        List<Integer> list = Lists.newLinkedList();
        for (int i = 0; i < 10000000; i++) {
            list.add(0);
        }
    }
}
