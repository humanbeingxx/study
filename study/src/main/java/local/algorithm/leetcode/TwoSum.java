package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-06
 **/
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        int[] result = new int[2];
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                break;
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return result;
    }
}
