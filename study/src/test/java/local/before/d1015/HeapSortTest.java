package local.before.d1015;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/15 上午11:18
 **/
public class HeapSortTest {

    @Test
    public void testBuildMaxHeap() {
        Random random = new Random();
//        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] data = new int[10];
        for (int i = 0; i < 10; i++) {
            data[i] = Math.abs(random.nextInt(100));
        }
        HeapSort.buildMaxHeap(data);

        for (int i = 0; i < data.length; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < data.length) {
                Assert.assertTrue(data[i] >= data[left]);
            }
            if (right < data.length) {
                Assert.assertTrue(data[i] >= data[right]);
            }
        }
    }

    @Test
    public void testSort() {
        Random random = new Random();
        int[] data1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        shuffle(data1);

        int[] data2 = new int[10];
        for (int i = 0; i < 10; i++) {
            data2[i] = Math.abs(random.nextInt(100));
        }

        HeapSort.sort(data1);
        HeapSort.sort(data2);

        assertSorted(data1);
        assertSorted(data2);
    }

    private void shuffle(int[] data) {
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            int pos1 = Math.abs(random.nextInt(data.length));
            int pos2 = Math.abs(random.nextInt(data.length));
            int temp = data[pos1];
            data[pos1] = data[pos2];
            data[pos2] = temp;
        }
    }

    private void assertSorted(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            Assert.assertTrue(data[i] <= data[i + 1]);
        }
    }

    @Test
    public void testSortMany() {
        Random random = new Random();
        int[] data = new int[10];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 10; j++) {
                data[j] = Math.abs(random.nextInt(100));
            }
            HeapSort.sort(data);
            assertSorted(data);
        }
    }

    @Test
    public void assertBound() {
        int[] data1 = {};
        int[] data2 = {1};
        int[] data3 = {2,1,};

        HeapSort.sort(data1);
        HeapSort.sort(data2);
        HeapSort.sort(data3);

        assertSorted(data1);
        assertSorted(data2);
        assertSorted(data3);
    }
}