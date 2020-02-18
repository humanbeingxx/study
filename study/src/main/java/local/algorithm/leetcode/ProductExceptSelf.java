package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-18
 **/
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = nums[i + 1] * result[i + 1];
        }
        int leftProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct * result[i];
            leftProduct *= nums[i];
        }
        return result;
    }
}
