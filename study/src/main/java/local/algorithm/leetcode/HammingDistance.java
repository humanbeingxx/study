package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 13:12
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            if ((xor & 1) == 1) {
                count++;
            }
            xor >>= 1;
        }
        return count;
    }
}
