package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 16:55
 */
public class InverseInt {

    public int reverse(int x) {
        int y = 0;
        while (x != 0) {
            int left = x % 10;
            x /= 10;
            if (y > Integer.MAX_VALUE / 10 || (y == Integer.MAX_VALUE / 10 && left > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if (y < Integer.MIN_VALUE / 10 || (y == Integer.MIN_VALUE / 10 && left < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            y = y * 10 + left;
        }
        return y;
    }

}
