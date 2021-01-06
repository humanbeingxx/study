package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-24
 **/
public class PerfectSquare {

    public boolean isPerfectSquare(int num) {
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (Integer.MAX_VALUE / i < i) {
                break;
            }
            int left = num / i;
            if (left == i && num - left * i == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            sum += 2 * i - 1;
            if (sum == num) {
                return true;
            } else if (sum > num) {
                return false;
            }
        }
        return false;
    }


    public boolean isPerfectSquare3(int num) {
        if (num == 1) {
            return true;
        } else if (num < 4) {
            return false;
        }

        int low = 2, high = num / 2, x = (low + high) / 2;
        while (low <= high) {
            int divide = num / x;
            if (divide == x && num - divide * x == 0) {
                return true;
            }
            if (divide > x) {
                low = x + 1;
            } else {
                high = x - 1;
            }
            x = (low + high) / 2;
        }
        return false;
    }
}
