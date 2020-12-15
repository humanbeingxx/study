package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-18
 **/
public class ProductExceptSelf2 {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i + 1];
        }
        int h2tProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] *= h2tProduct;
            h2tProduct *= nums[i];
        }
        return result;
    }
}
