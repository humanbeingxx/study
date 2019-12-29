package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/28 20:27
 */
public class FindErrorNums {

    public int[] findErrorNums(int[] nums) {
        int[] counter = new int[10001];
        for (int num : nums) {
            counter[num]++;
        }

        int[] result = new int[2];
        for (int i = 1; i < result.length; i++) {
            if (counter[i] == 2) {
                result[0] = i;
            } else if (counter[i] == 0) {
                result[1] = i;
            }
        }

        return result;
    }
}
