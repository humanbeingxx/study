package local.algorithm.leetcode;

public class ReverseInt {

    public int reverse(int x) {
        int reversed = 0;
        int maxDivide = Integer.MAX_VALUE / 10, minDivide = Integer.MIN_VALUE / 10;
        int maxMod = Integer.MAX_VALUE % 10, minMod = Integer.MIN_VALUE % 10;
        while (x != 0) {
            int left = x % 10;
            x /= 10;
            if (reversed > maxDivide || (reversed == maxDivide && left > maxMod)) {
                return 0;
            } else if (reversed < minDivide || (reversed == minDivide && left < minMod)) {
                return 0;
            }
            reversed = reversed * 10 + left;
        }
        return reversed;
    }
}
