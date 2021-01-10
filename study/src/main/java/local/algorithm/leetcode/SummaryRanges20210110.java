package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges20210110 {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                end = nums[i];
            } else {
                if (start == end) {
                    result.add(Integer.toString(start));
                } else {
                    result.add(start + "->" + end);
                }
                start = nums[i];
                end = nums[i];
            }
        }
        if (start == end) {
            result.add(Integer.toString(start));
        } else {
            result.add(start + "->" + end);
        }
        return result;
    }
}
