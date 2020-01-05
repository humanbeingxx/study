package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 13:01
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        int start = 0, end = A.length - 1;
        while (start < end) {
            while (start < end && A[start] % 2 == 0) {
                start++;
            }
            if (start >= end) {
                break;
            }
            while (end > start && A[end] % 2 == 1) {
                end--;
            }
            if (start >= end) {
                break;
            }
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
        return A;
    }
}
