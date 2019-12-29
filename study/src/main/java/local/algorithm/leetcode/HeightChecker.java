package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/29 22:06
 */
public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] clone = heights.clone();
        Arrays.sort(clone);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != clone[i]) {
                count++;
            }
        }
        return count;
    }
}
