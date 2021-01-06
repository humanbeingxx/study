package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CircularArrayLoopTest {

    @Test
    public void testCircularArrayLoop1() {
        boolean result = new CircularArrayLoop().circularArrayLoop(new int[]{-1, -2, -3, -4, -5});
        assertFalse(result);
    }

    @Test
    public void testCircularArrayLoop2() {
        boolean result = new CircularArrayLoop().circularArrayLoop(new int[]{2, -1, 1, 2, 2});
        assertTrue(result);
    }

    @Test
    public void testCircularArrayLoop3() {
        boolean result = new CircularArrayLoop().circularArrayLoop(new int[]{-2, 1, -1, -2, -2});
        assertFalse(result);
    }

    @Test
    public void testCircularArrayLoop4() {
        boolean result = new CircularArrayLoop().circularArrayLoop(new int[]{2, 2, 2, 2, 2, 4, 7});
        assertFalse(result);
    }

    @Test
    public void testCircularArrayLoop5() {
        boolean result = new CircularArrayLoop().circularArrayLoop(new int[]{-1, 2, 1, 2});
        assertTrue(result);
    }

    @Test
    public void testCircularArrayLoop6() {
        boolean result = new CircularArrayLoop().circularArrayLoop(new int[]{2, 1, 1, -1});
        assertFalse(result);
    }

    @Test
    public void testCircularArrayLoop0() {
        boolean result = new CircularArrayLoop().circularArrayLoop(new int[]{-1});
        assertFalse(result);
    }
}