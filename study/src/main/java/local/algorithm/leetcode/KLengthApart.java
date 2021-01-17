package local.algorithm.leetcode;

public class KLengthApart {

    public boolean kLengthApart(int[] nums, int k) {
        int lastOne = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {
                if (lastOne == -1) {
                    lastOne = i;
                } else {
                    if (i - lastOne < k) {
                        return false;
                    }
                    lastOne = i;
                }
            }
        }
        return true;
    }
}
