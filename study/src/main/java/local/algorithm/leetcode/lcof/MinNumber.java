package local.algorithm.leetcode.lcof;

import java.util.Arrays;
import java.util.Comparator;

public class MinNumber {

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        StringBuilder cp1 = new StringBuilder();
        StringBuilder cp2 = new StringBuilder();
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                cp1.setLength(0);
                cp2.setLength(0);
                cp1.append(o1).append(o2);
                cp2.append(o2).append(o1);
                return compareBuilder(cp1, cp2);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    private int compareBuilder(StringBuilder cp1, StringBuilder cp2) {
        for (int i = 0; i < cp1.length(); i++) {
            if (cp1.charAt(i) != cp2.charAt(i)) {
                return cp1.charAt(i) - cp2.charAt(i);
            }
        }
        return 0;
    }
}
