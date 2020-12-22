package local.algorithm.leetcode;

public class CorporateFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] changes = new int[n + 1];
        for (int[] booking : bookings) {
            changes[booking[0] - 1] += booking[2];
            changes[booking[1]] -= booking[2];
        }
        int[] result = new int[n];
        int currentTickets = 0;
        for (int i = 0; i < result.length; i++) {
            currentTickets += changes[i];
            result[i] = currentTickets;
        }
        return result;
    }
}
