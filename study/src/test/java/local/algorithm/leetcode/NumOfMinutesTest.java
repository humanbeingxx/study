package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NumOfMinutesTest {

    @Test
    public void testNumOfMinutes1() {
        int result = new NumOfMinutes().numOfMinutes(7, 6, new int[]{1, 2, 3, 4, 5, 6, -1}, new int[]{0, 6, 5, 4, 3, 2, 1});
        assertEquals(result, 21);
    }

    @Test
    public void testNumOfMinutes2() {
        int result = new NumOfMinutes().numOfMinutes(15, 0,
                new int[]{-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6},
                new int[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        assertEquals(result, 3);
    }

    @Test
    public void testNumOfMinutes3() {
        int result = new NumOfMinutes().numOfMinutes(4, 2,
                new int[]{3, 3, -1, 2},
                new int[]{0, 0, 162, 914});
        assertEquals(result, 1076);
    }
}