package local.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CinemaSeatAllocation {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int[] seats = new int[n + 1];
        Arrays.fill(seats, 0b11111111);
        for (int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0], column = reservedSeat[1];
            if (column == 1 || column == 10) {
                continue;
            }
            seats[row] &= ~(1 << (column - 2));
        }
        int count = 0;
        for (int i = 1; i < seats.length; i++) {
            int seat = seats[i];
            if (seat == 0b11111111) {
                count += 2;
                continue;
            }
            if ((seat & 0b00001111) == 0b00001111 || (seat & 0b00111100) == 0b00111100 || (seat & 0b11110000) == 0b11110000) {
                count++;
            }
        }
        return count;
    }

    public int maxNumberOfFamiliesByMap(int n, int[][] reservedSeats) {
        Map<Integer, Integer> usedSeats = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0], column = reservedSeat[1];
            if (column == 1 || column == 10) {
                continue;
            }
            usedSeats.put(row, usedSeats.getOrDefault(row, 0b11111111) & (~(1 << (column - 2))));
        }
        int count = (n - usedSeats.size()) * 2;
        for (Integer seat : usedSeats.values()) {
            if ((seat & 0b00001111) == 0b00001111 || (seat & 0b00111100) == 0b00111100 || (seat & 0b11110000) == 0b11110000) {
                count++;
            }
        }
        return count;
    }
}
