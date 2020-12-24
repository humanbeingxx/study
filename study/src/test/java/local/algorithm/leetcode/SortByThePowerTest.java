package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SortByThePowerTest {

    @Test
    public void testGetKth1() {
        int result = new SortByThePower().getKth(1, 100, 30);
        assertEquals(result, 11);
    }

    @Test
    public void testGetKth2() {
        int result = new SortByThePower().getKth(1, 1, 1);
        assertEquals(result, 1);
    }

    @Test
    public void testGetKth3() {
        int result = new SortByThePower().getKth(1, 1000, 777);
        assertEquals(result, 570);
    }
}