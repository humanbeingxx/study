package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/1 14:02
 */
public class FindOddNumbers {

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (isOdd(num)) {
                count++;
            }
        }
        return count;
    }

    private boolean isOdd(int num) {
        return (num >= 10 && num <= 99)
                || (num >= 1000 && num <= 9999)
                || (num == 100000);
    }
}
