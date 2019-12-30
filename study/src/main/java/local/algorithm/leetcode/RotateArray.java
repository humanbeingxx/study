package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class RotateArray {

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len <= 0) {
            return;
        }
        k = k % len;
        if (k == 0) {
            return;
        }

        for (int i = 0; i < nums.length; i += k, len -= k, k = k % len) {
            if (k == 0) {
                return;
            }
            for (int j = 0; j < k; j++) {
                swap(nums, i + j, nums.length - k + j);
            }
        }
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }

    public void rotateByForce(int[] nums, int k) {
        if (nums.length <= 0) {
            return;
        }
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = temp;
        }
    }
}
