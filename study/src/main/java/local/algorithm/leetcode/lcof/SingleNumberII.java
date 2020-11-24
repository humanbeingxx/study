package local.algorithm.leetcode.lcof;

public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int[] bitCount = new int[32];
        for (int num : nums) {
            int index = 0;
            while (num != 0) {
                if ((num & 1) == 1) {
                    bitCount[index]++;
                }
                num >>>= 1;
                index++;
            }
        }
        for (int i = 0; i < bitCount.length; i++) {
            bitCount[i] %= 3;
        }
        int result = 0, base = 1;
        for (int i = 0; i < bitCount.length; i++, base <<= 1) {
            if (bitCount[i] != 0) {
                result |= base;
            }
        }
        return result;
    }
}
