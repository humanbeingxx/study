package local.algorithm.leetcode;

public class NumArray20210105 {

    private int[] nums;
    private int[] accumulate;
    private final int accumulateSize;

    public NumArray20210105(int[] nums) {
        this.nums = nums;
        this.accumulateSize = (int) Math.sqrt(nums.length) + 1;
        accumulate = new int[accumulateSize];
        int index = 0, posOfAcc = 0;
        while (index < nums.length) {
            int sum = 0;
            for (int i = 0; i < accumulateSize && index < nums.length; i++) {
                sum += nums[index++];
            }
            accumulate[posOfAcc++] = sum;
        }
    }

    public void update(int i, int val) {
        nums[i] = val;
        int iGroup = i / accumulateSize;
        int sum = 0;
        for (int index = iGroup * accumulateSize; index < nums.length && index < (iGroup + 1) * accumulateSize; index++) {
            sum += nums[index];
        }
        accumulate[iGroup] = sum;
    }

    public int sumRange(int i, int j) {
        int iGroup = i / accumulateSize;
        int jGroup = j / accumulateSize;
        int sum = 0;
        int index = i;
        for (; index < nums.length && index <= j && index < accumulateSize * (iGroup + 1); index++) {
            sum += nums[index];
        }
        for (int k = iGroup + 1; k < jGroup; k++) {
            sum += accumulate[k];
        }
        if (jGroup > iGroup + 1) {
            index += (jGroup - iGroup - 1) * accumulateSize;
        }
        for (; index < nums.length && index <= j; index++) {
            sum += nums[index];
        }
        return sum;
    }
}
