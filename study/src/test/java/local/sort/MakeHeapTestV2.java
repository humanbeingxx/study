package local.sort;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author xiaoshuang.cui
 * @date 2018/9/26 下午9:39
 **/
public class MakeHeapTestV2 {

    private void makeBigHeap(int[] data) {
        for (int i = data.length - 1; i >= 0; i--) {
            adjust(data, i);
        }
    }

    private void adjust(int[] data, int from) {
        for (int i = from / 2; i >= 0; i /= 2) {
            int bigChild = i * 2;
            if (i * 2 + 1 < data.length && data[i * 2 + 1] > data[i * 2]) {
                bigChild = i * 2 + 1;
            }
            if (data[i] < data[bigChild]) {
                exchange(data, i, bigChild);
            }
            if (i == 0) {
                return;
            }
        }
    }

    private void exchange(int[] data, int from, int to) {
        int temp = data[from];
        data[from] = data[to];
        data[to] = temp;
    }

    @Test
    public void test() {
        int[] data = {1, 2, 3, 4, 5, 5, 6, 7, 8};
        makeBigHeap(data);

        Assert.assertEquals(data[0], 8);
    }

    @Test
    public void test2() {
        int[] data = {1, 2, 3, 1, 2, 3,};
        makeBigHeap(data);

        Assert.assertEquals(3, data[0]);
    }

    @Test
    public void test3() {
        int[] data = {1};
        makeBigHeap(data);

        Assert.assertEquals(1, data[0]);
    }

    @Test
    public void test4() {
        int[] data = {};
        makeBigHeap(data);
    }

    @Test
    public void test5() {
        int[] data = {1, 2, 3};
        makeBigHeap(data);

        Assert.assertEquals(3, data[0]);
    }
}
