package local.algorithm.leetcode.sort;

import org.testng.annotations.Test;

public class SortArrayHeapSortTest extends SortArrayTest {

    @Override
    protected void sort(int[] data) {
        new SortArrayHeapSort().sortArray(data);
    }

    @Test
    public void testBoundary() {
        int[] data = new int[]{};
        new SortArrayHeapSort().sortArray(data);
        data = new int[]{3, 2, 1};
        new SortArrayHeapSort().sortArray(data);
    }

}