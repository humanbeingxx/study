package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MaxEventsTest {

    @Test
    public void testMaxEvents() {
        int result = new MaxEvents().maxEvents(new int[][]{{1, 2}, {1, 2}, {3, 3}, {1, 5}, {1, 5}});
        assertEquals(result, 5);
    }
}