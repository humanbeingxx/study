package local.algorithm.leetcode;

import java.util.List;

public class MaxLengthOfConcatWithUniqChars {

    public int maxLength(List<String> arr) {
        int[] bits = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            bits[i] = toBit(arr.get(i));
        }
        return rec(bits, 0, 0, arr);
    }

    private int rec(int[] bits, int currBit, int currIndex, List<String> arr) {
        if (currIndex == bits.length) {
            return 0;
        }
        int max = 0;
        for (int i = currIndex; i < bits.length; i++) {
            if (bits[i] != 0 && (currBit & bits[i]) == 0) {
                max = Math.max(max, rec(bits, currBit | bits[i], i + 1, arr) + arr.get(i).length());
            }
        }
        return max;
    }

    int toBit(String s) {
        int bit = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int pos = 1 << (c - 'a');
            if ((bit & pos) == pos) {
                return 0;
            }
            bit |= pos;
        }
        return bit;
    }
}
