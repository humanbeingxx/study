package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class ReverseBits {

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= n & 0b1;
            n >>= 1;
        }
        return result;
    }
}
