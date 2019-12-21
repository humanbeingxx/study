package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/21 19:17
 */
public class SumEvenAfterQueries {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        for (int a : A) {
            if (a % 2 ==0 ) {
                sum += a;
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            if (A[index] % 2 !=0 && val % 2 != 0) {
                sum += A[index] + val;
            } else if (A[index] % 2 ==0 && val % 2 != 0) {
                sum -= A[index];
            } else if (A[index] % 2 ==0 && val % 2 == 0) {
                sum += val;
            }

            result[i] = sum;
            A[index] = A[index] + val;
        }
        return result;
    }
}
