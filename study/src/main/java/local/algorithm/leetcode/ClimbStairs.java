package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 13:34
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        int[] ways = new int[n + 1];
        ways[0] = 0;
        ways[1] = 1;
        ways[2] = 2;
        return calc(n, ways);
    }

    private int calc(int n, int[] ways) {
        if (n <= 2) {
            return ways[n];
        }
        int n1 = ways[n - 1];
        int n2 = ways[n - 2];
        if (n1 == 0) {
            n1 = calc(n - 1, ways);
            ways[n - 1] = n1;
        }
        if (n2 == 0) {
            n2 = calc(n - 2, ways);
            ways[n - 2] = n2;
        }
        return n1 + n2;
    }
}
