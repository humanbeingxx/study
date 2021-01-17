package local.algorithm.leetcode;

public class GrumpyBookstoreOwner {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sumOfPeace = 0, sumWithGaMan = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                sumOfPeace += customers[i];
            }
        }
        int max = 0;
        for (int i = 0; i < customers.length; i++) {
            sumWithGaMan += grumpy[i] == 1 ? customers[i] : 0;
            sumWithGaMan -= (i >= X && grumpy[i - X] == 1) ? customers[i - X] : 0;
            max = Math.max(max, sumWithGaMan);
        }
        return max + sumOfPeace;
    }
}
