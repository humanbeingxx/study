package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class MinCostToMoveChips {

    public int minCostToMoveChips(int[] chips) {
        int sumOdd = 0, sumEven = 0;
        for (int chip : chips) {
            if (chip % 2 == 0) {
                sumEven++;
            } else {
                sumOdd++;
            }
        }

        return Math.min(sumEven, sumOdd);
    }
}
