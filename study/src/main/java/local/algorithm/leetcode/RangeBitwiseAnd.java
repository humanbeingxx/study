package local.algorithm.leetcode;

public class RangeBitwiseAnd {

    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        int pos = 1, result = 0xFFFFFFFF;
        for (int i = 0; i < 32; i++) {
            int currBit = m & pos;
            if (currBit == 0) {
                result &= ~pos;
            } else {
                int maxBackBits = pos - 1;
                int diff = maxBackBits - (m & maxBackBits);
                if (n - m > diff) {
                    result &= ~pos;
                }
            }
            pos <<= 1;
        }
        return result;
    }

    //找共同前缀
    public int rangeBitwiseAnd2(int m, int n) {
        int shift = 0;
        while (n > m) {
            n = n >> 1;
            m = m >> 1;
            shift++;
        }
        return n << shift;
    }
}
