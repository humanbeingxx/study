package local.algorithm.leetcode;

public class AverageWaitingTime {

    public double averageWaitingTime(int[][] customers) {
        long nextCook = customers[0][0], totalWait = 0;
        for (int[] customer : customers) {
            totalWait += Math.max(0, nextCook - customer[0]) + customer[1];
            nextCook = Math.max(nextCook, customer[0]) + customer[1];
        }
        return ((double)totalWait) / customers.length;
    }
}
