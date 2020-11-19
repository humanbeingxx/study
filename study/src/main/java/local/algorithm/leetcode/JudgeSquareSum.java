package local.algorithm.leetcode;

public class JudgeSquareSum {

    public boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            System.out.println(i * i);
            int target = c - (int) (i * i);
            if (searchB(0, target, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean searchB(long start, long end, int target) {
        if (start > end) {
            return false;
        }
        long num = start + (end - start) / 2;
        long product = num * num;
        if (product == target) {
            return true;
        } else if (product > target) {
            return searchB(start, num - 1, target);
        } else {
            return searchB(num + 1, end, target);
        }
    }
}
