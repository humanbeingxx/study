package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-06
 **/
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        int start = 0, oddEnd = A.length - 1, evenEnd = A.length - 2;
        while (start < oddEnd || start < evenEnd) {
            if (start % 2 == 0) {
                if (A[start] % 2 == 0) {
                    start++;
                } else {
                    while (oddEnd > start && A[oddEnd] % 2 == 1) {
                        oddEnd -= 2;
                    }
                    if (oddEnd > start) {
                        swap(A, start, oddEnd);
                    }
                    start++;
                }
            } else {
                if (A[start] % 2 != 0) {
                    start++;
                } else {
                    while (evenEnd > start && A[evenEnd] % 2 == 0) {
                        evenEnd -= 2;
                    }
                    if (evenEnd > start) {
                        swap(A, start, evenEnd);
                    }
                    start++;
                }
            }
        }
        return A;
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
