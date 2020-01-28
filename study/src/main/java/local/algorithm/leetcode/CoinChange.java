package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-28
 **/
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] changes = new int[amount];
        boolean changed = false;
        for (int coin : coins) {
            if (coin > amount) {
                continue;
            }
            changes[coin - 1] = 1;
        }
        while (true) {
            for (int i = 0; i < amount; i++) {
                for (int coin : coins) {
                    if (coin > amount - 1 - i || changes[i] == 0) {
                        continue;
                    }
                    if (changes[coin + i] == 0) {
                        changed = true;
                        changes[coin + i] = changes[i] + 1;
                    } else if (changes[coin + i] > changes[i] + 1){
                        changed = true;
                        changes[coin + i] = changes[i] + 1;
                    }
                }
            }
            if (!changed) {
                break;
            } else {
                changed = false;
            }
        }
        return changes[amount - 1] > 0 ? changes[amount - 1]: -1;
    }
}
