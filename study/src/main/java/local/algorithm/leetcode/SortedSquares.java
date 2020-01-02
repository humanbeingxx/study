package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class SortedSquares {

    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];

        int from = 0, to = A.length - 1, index = A.length - 1;
        while (from <= to) {
            if (from == to) {
                result[index] = A[from] * A[from];
                break;
            } else if (Math.abs(A[from]) > Math.abs(A[to])) {
                result[index--] = A[from] * A[from];
                from++;
            } else {
                result[index--] = A[to] * A[to];
                to--;
            }
        }
        return result;
    }
}
