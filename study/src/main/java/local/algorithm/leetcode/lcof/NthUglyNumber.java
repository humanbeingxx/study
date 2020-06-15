package local.algorithm.leetcode.lcof;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/14 16:59
 */
public class NthUglyNumber {

    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(Math.min(ugly[index2] * 2, ugly[index3] * 3), ugly[index5] * 5);
            if (ugly[i] == ugly[index2] * 2) {
                index2++;
            }
            if (ugly[i] == ugly[index3] * 3) {
                index3++;
            }
            if (ugly[i] == ugly[index5] * 5) {
                index5++;
            }
        }
        return ugly[n - 1];
    }

}
