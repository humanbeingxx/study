package local.algorithm.leetcode;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }

        int pos = 1;
        while ((pos & xor) != pos) {
            pos <<= 1;
        }
        Integer r1 = null, r2 = null;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & pos) == pos) {
                if (r1 == null) {
                    r1 = nums[i];
                } else {
                    r1 ^= nums[i];
                }
            } else {
                if (r2 == null) {
                    r2 = nums[i];
                } else {
                    r2 ^= nums[i];
                }
            }
        }

        return new int[]{r1, r2};
    }
}
