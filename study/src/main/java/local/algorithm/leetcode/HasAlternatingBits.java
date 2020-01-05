package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 14:04
 */
public class HasAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        int curr = n & 1;
        n >>= 1;
        while (n > 0) {
            if ((n & 1) == curr) {
                return false;
            }
            curr = n & 1;
            n >>= 1;
        }
        return true;
    }
}
