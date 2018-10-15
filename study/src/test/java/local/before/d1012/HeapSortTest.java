package local.before.d1012;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/12 下午11:49
 **/
public class HeapSortTest {

    public void sort(int[] data) {
        if (data.length <= 1) {
            return;
        }

        buildHeap(data);
    }

    private void buildHeap(int[] data) {
        for (int i = data.length / 2 - 1; i >= 0; i--) {
            adjust(data, i, data.length - 1);
        }
    }

    private void adjust(int[] data, int from, int to) {

    }

    @Test
    public void test() {
        int[] data = {1, 23, 3, 4, 5, 6, 7, 7, 8, 10};
        sort(data);

        int[] result = Arrays.copyOf(data, data.length);
        Arrays.sort(result);
        Assert.assertEquals(data, result);
    }
}
