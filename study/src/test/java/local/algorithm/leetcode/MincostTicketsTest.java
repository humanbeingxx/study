package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MincostTicketsTest {

    @Test
    public void testMincostTickets1() {
        int result = new MincostTickets().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{7, 2, 15});
        assertEquals(result, 6);
    }

    @Test
    public void testMincostTickets2() {
        int result = new MincostTickets().mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15});
        assertEquals(result, 17);
    }
}