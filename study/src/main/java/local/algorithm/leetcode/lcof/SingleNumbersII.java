package local.algorithm.leetcode.lcof;

public class SingleNumbersII {

    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int pos = 1;
        while ((xor & 1) == 0) {
            xor >>= 1;
            pos <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & pos) == pos) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
