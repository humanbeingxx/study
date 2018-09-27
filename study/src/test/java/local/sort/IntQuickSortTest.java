package local.sort;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author xiaoshuang.cui
 * @date 2018/9/26 下午5:44
 **/
public class IntQuickSortTest {

    @Test
    public void testSort() {

        int[] data = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        IntQuickSort.sort(data);

        System.out.println(Arrays.toString(data));
        Assert.assertEquals(data, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    @Test
    public void testSortEmpty() {

        int[] data = {};

        IntQuickSort.sort(data);

        System.out.println(Arrays.toString(data));
        Assert.assertEquals(data, new int[]{});
    }

    @Test
    public void testSortSame() {

        int[] data = {1, 1, 1, 1, 1, 1, 1};

        IntQuickSort.sort(data);

        System.out.println(Arrays.toString(data));
        Assert.assertEquals(data, new int[]{1, 1, 1, 1, 1, 1, 1});
    }

    @Test
    public void testSortOne() {

        int[] data = {1};

        IntQuickSort.sort(data);

        System.out.println(Arrays.toString(data));
        Assert.assertEquals(data, new int[]{1});
    }

    @Test
    public void testSortTwo() {

        int[] data = {3, 1};

        IntQuickSort.sort(data);

        System.out.println(Arrays.toString(data));
        Assert.assertEquals(data, new int[]{1, 3});
    }

    @Test
    public void test2() {
        int[] data = {1, 2, 3, 4};

        IntQuickSort.sort(data);

        Assert.assertEquals(data, new int[]{1, 2, 3, 4});
    }
}