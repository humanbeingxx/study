package local.algorithm.leetcode.lcof;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MyPowTest {

    @Test
    public void testMyPow1() {
        double result = new MyPow().myPow(2.0, 3);
        assertEquals(result, Math.pow(2.0, 3));
    }

    @Test
    public void testMyPow2() {
        double result = new MyPow().myPow(2.0, -3);
        assertEquals(result, Math.pow(2.0, -3));
    }

    @Test
    public void testMyPow3() {
        double result = new MyPow().myPow(1.5, 3);
        assertEquals(result, Math.pow(1.5, 3));
    }

    @Test
    public void testMyPow4() {
        double result = new MyPow().myPow(0.5, 3);
        assertEquals(result, Math.pow(0.5, 3));
    }

    @Test
    public void testMyPow5() {
        double result = new MyPow().myPow(0.5, -3);
        assertEquals(result, Math.pow(0.5, -3));
    }
}