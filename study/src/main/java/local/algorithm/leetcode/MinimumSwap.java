package local.algorithm.leetcode;

public class MinimumSwap {

    public int minimumSwap(String s1, String s2) {
        int xyCount = 0, yxCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                xyCount++;
            } else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                yxCount++;
            }
        }
        int swapCount = 0;
        swapCount += xyCount / 2;
        xyCount %= 2;
        swapCount += yxCount / 2;
        yxCount %= 2;
        if (xyCount != yxCount) {
            return -1;
        } else {
            return swapCount + xyCount + yxCount;
        }
    }
}
