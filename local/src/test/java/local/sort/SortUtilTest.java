package local.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SortUtilTest {
    @Test
    public void testQuickSort() throws Exception {
        int[] array = new int[]{1, 5, 7, 0, 0, 1, 2, 7, 6, 5, 4};
        SortUtil.quickSort(array);

        System.out.println(Arrays.toString(array));
        int[] expectedArray = new int[]{0, 0, 1, 1, 2, 4, 5, 5, 6, 7, 7};
        assertArrayEquals(expectedArray, array);

    }

    @Test
    public void testQuickSort2() throws Exception {
        int[] array = new int[]{0,0,0,0,0};
        SortUtil.quickSort(array);

        System.out.println(Arrays.toString(array));
        int[] expectedArray = new int[]{0,0,0,0,0};
        assertArrayEquals(expectedArray, array);

    }

    @Test
    public void testBubbleSort() throws Exception {

        int[] array = new int[]{1, 5, 7, 0, 0, 1, 2, 7, 6, 5, 4};
        SortUtil.bubbleSort(array);

        int[] expectedArray = new int[]{0, 0, 1, 1, 2, 4, 5, 5, 6, 7, 7};
        assertArrayEquals(expectedArray, array);
    }
}