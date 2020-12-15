package local.algorithm.leetcode.sort;

public class SortArrayInsertSortTest extends SortArrayTest {

    @Override
    protected void sort(int[] data) {
        new SortArrayInsertSort().sortArray(data);
    }
}