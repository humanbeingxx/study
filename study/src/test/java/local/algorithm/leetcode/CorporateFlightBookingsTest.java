package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

public class CorporateFlightBookingsTest {

    @Test
    public void testCorpFlightBookings() {
        int[] result = new CorporateFlightBookings().corpFlightBookings(new int[][]{
                {1, 2, 10}, {2, 3, 20}, {2, 5, 25}
        }, 5);
        System.out.println(Arrays.toString(result));
    }
}