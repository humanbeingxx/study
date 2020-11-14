package local.algorithm.leetcode;

public class MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int N) {
        if (N <= 10) {
            return N - 1;
        }
        char[] chars = String.valueOf(N).toCharArray();
        int ninePos = chars.length, index = chars.length - 1;
        boolean shouldNine = false;
        while (index >= 0) {
            if (shouldNine) {
                if (chars[index] != '0') {
                    chars[index] -= 1;
                    shouldNine = false;
                } else {
                    ninePos = index;
                }
            }
            if (index > 0 && chars[index] < chars[index - 1]) {
                shouldNine = true;
                ninePos = index;
            }
            index--;
        }
        for (int i = ninePos; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }
}
