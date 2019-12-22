package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/22 15:44
 */
public class CheckPalindrome {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        int from = (int) Math.pow(10, 9);
        while (x / from == 0) {
            from /= 10;
        }
        int to = 1;
        while (from > to) {
            int high = (x / from) % 10;
            int low = (x / to) % 10;
            if (high != low) {
                return false;
            }
            from /= 10;
            to *= 10;
        }
        return true;
    }
}
