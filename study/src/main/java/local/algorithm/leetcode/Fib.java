package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 13:18
 */
public class Fib {

    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        int[] ints = new int[N+1];
        ints[0] = 0;
        ints[1] = 1;
        for (int i = 2; i <= N; i++) {
            ints[i] = ints[i-1] + ints[i-2];
        }
        return ints[N];
    }
}
