package local.algorithm.leetcode;

import java.util.Arrays;

public class NextGreaterElementIII {

//    public int nextGreaterElement(int n) {
//        char[] chars = Integer.toString(n).toCharArray();
//        int tail = chars.length - 1, exchangePos;
//        while (tail > 0) {
//            char tailC = chars[tail];
//            for (int i = tail - 1; i >= 0; i--) {
//                char highC = chars[i];
//                if (highC < tailC) {
//                    exchangePos = i;
//                    chars[tail] = chars[exchangePos];
//                    chars[exchangePos] = tailC;
//                    Arrays.sort(chars, exchangePos + 1, chars.length);
//                    return Integer.parseInt(new String(chars));
//                }
//            }
//            tail--;
//        }
//        return -1;
//    }

    static final long MAX = Integer.MAX_VALUE;

    public int nextGreaterElement(int n) {
        char[] chars = Integer.toString(n).toCharArray();
        int tailIndex = chars.length - 2;
        while (tailIndex >= 0) {
            char tailC = chars[tailIndex], minBigger = '9' + 1;
            int exchangePos = -1;
            for (int i = tailIndex + 1; i < chars.length; i++) {
                if (chars[i] > tailC && chars[i] < minBigger) {
                    exchangePos = i;
                    minBigger = chars[i];
                }
            }
            if (exchangePos != -1) {
                chars[tailIndex] = minBigger;
                chars[exchangePos] = tailC;
                Arrays.sort(chars, tailIndex + 1, chars.length);
                long l = Long.parseLong(new String(chars));
                if (l > MAX) {
                    return -1;
                }
                return (int) l;
            }
            tailIndex--;
        }
        return -1;
    }
}
