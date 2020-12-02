package local.algorithm.leetcode.lcci;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSubarray {

    public String[] findLongestSubarray(String[] array) {
        if (array == null || array.length < 2) {
            return new String[0];
        }
        int currSub = 0, maxLen = Integer.MIN_VALUE, start = -1;
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, -1);
        for (int i = 0; i < array.length; i++) {
            String str = array[i];
            char c = str.charAt(0);
            if (Character.isDigit(c)) {
                currSub--;
            } else {
                currSub++;
            }
            Integer pre = prefix.get(currSub);
            if (pre != null) {
                int currLen = i - pre;
                if (currLen > maxLen) {
                    maxLen = currLen;
                    start = pre + 1;
                }
            }
            prefix.putIfAbsent(currSub, i);
        }
        if (start < 0) {
            return new String[0];
        } else {
            String[] result = new String[maxLen];
            System.arraycopy(array, start, result, 0, maxLen);
            return result;
        }
    }
}
