package local.algorithm.leetcode;

public class MinOpReduceXToZero {

    public int minOperations(int[] nums, int x) {
        int leftSum = 0, left = 0, min = Integer.MAX_VALUE;
        while (left < nums.length) {
            leftSum += nums[left];
            if (leftSum >= x) {
                break;
            }
            left++;
        }
        if (leftSum > x) {
            leftSum -= nums[left];
            left--;
        } else if (leftSum < x) {
            return -1;
        }
        int rightSum = 0, right = nums.length;
        while (left >= 0) {
            while (left < right) {
                int sum = leftSum + rightSum;
                if (sum > x) {
                    break;
                } else if (sum == x) {
                    min = Math.min(min, left + 1 + nums.length - right);
                    break;
                }
                right--;
                rightSum += nums[right];
            }
            leftSum -= nums[left];
            left--;
        }
        while (right > 0) {
            if (rightSum == x) {
                min = Math.min(min, nums.length - right);
                break;
            } else if (rightSum > x) {
                break;
            }
            right--;
            rightSum += nums[right];
        }
        if (rightSum == x) {
            min = Math.min(min, nums.length - right);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
