package local.algorithm.leetcode.lcof;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MovingCountTest {

    @Test
    public void testMovingCount0() {
        int result = new MovingCount().movingCount(1, 1, 0);
        assertEquals(result, 1);
    }

    @Test
    public void testMovingCount1() {
        int result = new MovingCount().movingCount(2, 3, 1);
        assertEquals(result, 3);
    }

    @Test
    public void testMovingCount2() {
        int result = new MovingCount().movingCount(3, 1, 0);
        assertEquals(result, 1);
    }

    @Test
    public void testMovingCount3() {
        int result = new MovingCount().movingCount(10, 20, 14);
        assertEquals(result, 175);
    }

}