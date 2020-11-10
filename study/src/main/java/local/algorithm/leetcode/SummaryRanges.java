package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(Integer.toString(nums[0]));
            return result;
        }
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (nums[i - 1] == start) {
                    result.add(Integer.toString(start));
                } else {
                    result.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];
            }
        }
        if (start == nums[nums.length - 1]) {
            result.add(Integer.toString(start));
        } else {
            result.add(start + "->" + nums[nums.length - 1]);
        }
        return result;
    }
}
