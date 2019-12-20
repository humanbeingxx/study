package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/20 23:23
 */
public class FindRelativeRanks {

    public String[] findRelativeRanks(int[] nums) {
        String[] result = new String[nums.length];
        int[][] indices = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            indices[i] = new int[]{nums[i], i};
        }
        Arrays.sort(indices, (o1, o2) -> o2[0] - o1[0]);

        for (int i = 0; i < indices.length; i++) {
            String rank;
            if (i == 0) {
                rank = "Gold Medal";
            } else if (i == 1) {
                rank = "Silver Medal";
            } else if (i == 2) {
                rank = "Bronze Medal";
            } else {
                rank = String.valueOf(i + 1);
            }
            result[indices[i][1]] = rank;
        }
        return result;
    }

}
