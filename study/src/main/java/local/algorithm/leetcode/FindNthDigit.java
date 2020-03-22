package local.algorithm.leetcode;

public class FindNthDigit {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int num = 9, bits = 1;
        while (n - num * bits > 0) {
            n -= num * bits;
            num *= 10;
            bits++;
        }
        int divide = (n - 1) / bits;
        int remain = (n - 1) % bits;
        return String.valueOf(Math.pow(10, bits - 1) + divide).charAt(remain) - '0';
    }
}
