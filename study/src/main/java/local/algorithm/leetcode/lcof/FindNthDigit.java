package local.algorithm.leetcode.lcof;

public class FindNthDigit {

    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int length = 1;
        long base = 1, digitCount = 0;
        while (digitCount < n) {
            digitCount += (base * 10 - base) * length;
            base *= 10;
            length++;
        }
        base /= 10;
        length--;
        long start = digitCount - (base * 10 - base) * length + 1;
        long offset = n - start;
        int quotient = (int) (offset / length), remainder = (int) (offset % length);
        String num = Long.toString(base + quotient);
        return num.charAt(remainder) - '0';
    }

}
