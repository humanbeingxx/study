package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-13
 **/
public class CoinChangeII {

    public int change(int amount, int[] coins) {
        int[] changes = new int[amount + 1];
        changes[0] = 1;
        for (int coin : coins) {
            for (int i = 0; i + coin <= amount; i++) {
                changes[i + coin] += changes[i];
            }
        }
        return changes[amount];
    }
}
