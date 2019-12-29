package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/29 21:26
 */
public class AddDigits {

    public int addDigits(int num) {
        if (num < 9) {
            return num;
        }
        int left = num % 9;
        return left == 0 ? 9 : left;
    }
}
