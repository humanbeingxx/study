package local.sort;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;


public class SortUtilTest {
    @Test
    public void testBubbleSort1() throws Exception {

        int[] array = new int[]{1, 5, 7, 0, 0, 1, 2, 7, 6, 5, 4};
        SortUtil.bubbleSort(array, 0, 3);

        Assert.assertEquals(0, array[0]);
        Assert.assertEquals(1, array[1]);
        Assert.assertEquals(5, array[2]);
        Assert.assertEquals(7, array[3]);

    }

    @Test
    public void testQuickSort() throws Exception {
        int[] array = new int[]{1, 5, 7, 0, 0, 1, 2, 7, 6, 5, 4};
        SortUtil.quickSort(array);

        System.out.println(Arrays.toString(array));
        int[] expectedArray = new int[]{0, 0, 1, 1, 2, 4, 5, 5, 6, 7, 7};
        Assert.assertEquals(expectedArray, array);

    }

    @Test
    public void testQuickSort2() throws Exception {
        int[] array = new int[]{0, 0, 0, 0, 0};
        SortUtil.quickSort(array);

        System.out.println(Arrays.toString(array));
        int[] expectedArray = new int[]{0, 0, 0, 0, 0};
        Assert.assertEquals(expectedArray, array);

    }

    @Test
    public void testBubbleSort() throws Exception {

        int[] array = new int[]{1, 5, 7, 0, 0, 1, 2, 7, 6, 5, 4};
        SortUtil.bubbleSort(array);

        int[] expectedArray = new int[]{0, 0, 1, 1, 2, 4, 5, 5, 6, 7, 7};
        Assert.assertEquals(expectedArray, array);
    }
}