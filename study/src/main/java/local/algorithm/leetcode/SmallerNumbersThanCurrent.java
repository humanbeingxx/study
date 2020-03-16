package local.algorithm.leetcode;

public class SmallerNumbersThanCurrent {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counts = new int[101];
        for (int num : nums) {
            for (int i = num + 1; i < 101; i++) {
                counts[i]++;
            }
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = counts[nums[i]];
        }
        return result;
    }
}
