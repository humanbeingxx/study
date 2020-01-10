package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author cuixiaoshuang
 * @date 2020-01-10
 **/
public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] numStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStr[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(numStr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        String join = String.join("", numStr);
        int trim = 0;
        while (trim < join.length() - 1 && join.charAt(trim) == '0') {
            trim++;
        }
        return join.substring(trim);
    }
}
