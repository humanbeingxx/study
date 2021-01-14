package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MinTimeForApplesTest {

    @Test
    public void testMinTime1() {
        int result = new MinTimeForApples().minTime(7, new int[][]{
                        {0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}
                },
                Lists.newArrayList(false, false, true, false, true, true, false));
        assertEquals(result, 8);
    }
}