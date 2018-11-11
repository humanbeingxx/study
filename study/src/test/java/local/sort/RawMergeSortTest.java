package local.sort;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author xiaoshuang.cui
 * @date 2018/9/26 下午4:42
 **/
public class RawMergeSortTest {

    @Test
    public void testSort() {

        int[] data = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        RawMergeSort.sort(data);

        System.out.println(Arrays.toString(data));
        Assert.assertEquals(data, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    @Test
    public void testSortEmpty() {

        int[] data = {};

        RawMergeSort.sort(data);

        System.out.println(Arrays.toString(data));
        Assert.assertEquals(data, new int[]{});
    }

    @Test
    public void testSortSame() {

        int[] data = {1, 1, 1, 1, 1, 1, 1};

        RawMergeSort.sort(data);

        System.out.println(Arrays.toString(data));
        Assert.assertEquals(data, new int[]{1, 1, 1, 1, 1, 1, 1});
    }

    @Test
    public void testSortOne() {

        int[] data = {1};

        RawMergeSort.sort(data);

        System.out.println(Arrays.toString(data));
        Assert.assertEquals(data, new int[]{1});
    }

    @Test
    public void testSortTwo() {

        int[] data = {3, 1};

        RawMergeSort.sort(data);

        System.out.println(Arrays.toString(data));
        Assert.assertEquals(data, new int[]{1, 3});
    }
}