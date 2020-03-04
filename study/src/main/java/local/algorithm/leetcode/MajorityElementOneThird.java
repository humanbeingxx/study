package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementOneThird {

    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int m1 = 0, m2 = 0, mc1 = 0, mc2 = 0;
        for (int num : nums) {
            if (num == m1) {
                mc1++;
            } else if (num == m2) {
                mc2++;
            } else {
                if (mc1 == 0) {
                    m1 = num;
                    mc1 = 1;
                } else if (mc2 == 0) {
                    m2 = num;
                    mc2 = 1;
                } else {
                    mc1--;
                    mc2--;
                }
            }
        }
        mc1 = 0;
        mc2 = 0;
        for (int num : nums) {
            if (num == m1) {
                mc1++;
            } else if (num == m2) {
                mc2++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (mc1 > nums.length / 3) {
            result.add(m1);
        }
        if (mc2 > nums.length / 3) {
            result.add(m2);
        }
        return result;
    }
}
