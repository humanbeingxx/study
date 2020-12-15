package local.interview_internal_reference.didi;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/7/8 0:23
 */
public class MyQuickSort2Test {

    @Test
    public void testSort1() {
        int[] data = new int[]{5, 4, 3, 2, 1};
        MyQuickSort2.sort(data);
        Assert.assertEquals(data, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testSort2() {
        int[] data = new int[]{1, 2, 3, 4, 5};
        MyQuickSort2.sort(data);
        Assert.assertEquals(data, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testRandom() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int[] data = new int[1000];
            for (int j = 0; j < data.length; j++) {
                data[i] = random.nextInt(100000);
            }
            MyQuickSort2.sort(data);
            Assert.assertTrue(isSorted(data));
        }
    }

    private boolean isSorted(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] > data[i + 1]) {
                return false;
            }
        }
        return true;
    }
}