package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/4 13:55
 */
public class ArrangeCoins {

    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(2) * Math.sqrt(0.125 + n) - 0.5);
    }
}
