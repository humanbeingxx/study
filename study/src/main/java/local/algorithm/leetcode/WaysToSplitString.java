package local.algorithm.leetcode;

public class WaysToSplitString {
    public int numWays(String s) {
        int countOfOne = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countOfOne++;
            }
        }
        long num = 1;
        if (countOfOne == 0) {
            num *= s.length() - 2;
            num *= s.length() - 1;
            num /= 2;
            return (int) (num % 1000000007);
        }
        if (countOfOne % 3 != 0) {
            return 0;
        }
        int target = countOfOne / 3;
        int firstCount = 0, secondCount = 0, firstEnd = 0, secondStart, secondEnd, thirdStart;
        while (firstCount < target) {
            if (s.charAt(firstEnd) == '1') {
                firstCount++;
            }
            firstEnd++;
        }
        secondStart = firstEnd;
        while (s.charAt(secondStart) == '0') {
            secondStart++;
        }
        secondEnd = secondStart;
        while (secondCount < target) {
            if (s.charAt(secondEnd) == '1') {
                secondCount++;
            }
            secondEnd++;
        }
        thirdStart = secondEnd;
        while (s.charAt(thirdStart) == '0') {
            thirdStart++;
        }
        num *= secondStart - firstEnd + 1;
        num *= thirdStart - secondEnd + 1;
        return (int) (num % 1000000007);
    }
}
