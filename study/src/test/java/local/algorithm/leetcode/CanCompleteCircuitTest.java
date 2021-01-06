package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CanCompleteCircuitTest {

    @Test
    public void testCanCompleteCircuit1() {
        int result = new CanCompleteCircuit().canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
        assertEquals(result, 3);
    }

    @Test
    public void testCanCompleteCircuit2() {
        int result = new CanCompleteCircuit().canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3});
        assertEquals(result, -1);
    }

    @Test
    public void testCanCompleteCircuit3() {
        int result = new CanCompleteCircuit().canCompleteCircuit(new int[]{1, 3, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 3, 1});
        assertEquals(result, 1);
    }

    @Test
    public void testCanCompleteCircuit4() {
        int result = new CanCompleteCircuit().canCompleteCircuit(new int[]{1, 2}, new int[]{2, 1});
        assertEquals(result, 1);
    }

    @Test
    public void testCanCompleteCircuit5() {
        int result = new CanCompleteCircuit().canCompleteCircuit(new int[]{2, 0, 3}, new int[]{1, 2, 2});
        assertEquals(result, 2);
    }
}