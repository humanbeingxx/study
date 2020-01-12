package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/8 19:37
 */
public class XorQueries {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] arrResult = new int[arr.length];
        arrResult[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arrResult[i] = arr[i] ^ arrResult[i - 1];
        }
        int[] result = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int res = 0;
            if (query[0] == 0) {
                res = arrResult[query[1]];
            } else {
                res = arrResult[query[1]] ^ arrResult[query[0] - 1];
            }
            result[index++] = res;
        }
        return result;
    }
}
