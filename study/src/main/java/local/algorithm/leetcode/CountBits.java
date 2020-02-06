package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-06
 **/
public class CountBits {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int count = count(i);
            result[i] = count;
        }
        return result;
    }

    private int count(int i) {
        int count = 0;
        while (i != 0) {
            if ((i & 1) == 1) {
                count++;
            }
            i >>= 1;
        }
        return count;
    }

    public int[] countBits2(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }
}
