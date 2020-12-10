package local.algorithm.leetcode;

public class ShipWithinDays {

    public int shipWithinDays(int[] weights, int D) {
        int minLimit = Integer.MIN_VALUE, maxLimit = 0;
        for (int weight : weights) {
            maxLimit += weight;
            minLimit = Math.max(minLimit, weight);
        }
        int midLimit;
        while (minLimit <= maxLimit) {
            midLimit = minLimit + (maxLimit - minLimit) / 2;
            if (canShip(weights, midLimit, D)) {
                if (minLimit == maxLimit) {
                    return maxLimit;
                }
                maxLimit = midLimit;
            } else {
                minLimit = midLimit + 1;
            }
        }
        return maxLimit;
    }

    private boolean canShip(int[] weights, int limit, int D) {
        int currWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            if (D == 0) {
                return false;
            }
            if (i == weights.length - 1) {
                break;
            } else {
                currWeight += weights[i];
                if (currWeight + weights[i + 1] > limit) {
                    currWeight = 0;
                    D--;
                }
            }
        }
        return true;
    }
}
