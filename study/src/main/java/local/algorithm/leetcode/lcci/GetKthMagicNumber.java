package local.algorithm.leetcode.lcci;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/23 19:27
 */
public class GetKthMagicNumber {

    public int getKthMagicNumber(int k) {
        int[] numbers = new int[k];
        numbers[0] = 1;
        int p3 = 0, p5 = 0, p7 = 0;
        for (int i = 1; i < k; i++) {
            int val = Math.min(numbers[p3] * 3, Math.min(numbers[p5] * 5, numbers[p7] * 7));
            numbers[i] = val;
            if (val == numbers[p3] * 3) {
                p3++;
            }
            if (val == numbers[p5] * 5) {
                p5++;
            }
            if (val == numbers[p7] * 7) {
                p7++;
            }
        }
        return numbers[k - 1];
    }
}
