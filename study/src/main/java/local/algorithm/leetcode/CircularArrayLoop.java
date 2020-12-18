package local.algorithm.leetcode;

public class CircularArrayLoop {

    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i;
            int fast = mov(i, nums[i], nums.length);
            while (nums[i] * nums[slow] > 0 && nums[i] * nums[fast] > 0) {
                if (slow == fast) {
                    if (slow != mov(slow, nums[slow], nums.length)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = mov(slow, nums[slow], nums.length);
                fast = mov(fast, nums[fast], nums.length);
                if (nums[fast] * nums[i] < 0) {
                    break;
                }
                fast = mov(fast, nums[fast], nums.length);
            }
            makeNoLoop(nums, slow);

        }
        return false;
    }

    private int mov(int start, int val, int len) {
        return (((start + val) % len) + len) % len;
    }

    private void makeNoLoop(int[] nums, int start) {
        int index = start, mov;
        while (nums[index] * nums[start] > 0) {
            mov = mov(index, nums[index], nums.length);
            nums[index] = 0;
            index = mov;
        }
    }
}
