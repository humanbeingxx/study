package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BalancedStringTest {

    @Test
    public void testBalancedString1() {
        int result = new BalancedString().balancedString("QQQQQQQQ");
        assertEquals(result, 6);
    }

    @Test
    public void testBalancedString2() {
        int result = new BalancedString().balancedString("QEWR");
        assertEquals(result, 0);
    }

    @Test
    public void testBalancedString3() {
        int result = new BalancedString().balancedString("QQWE");
        assertEquals(result, 1);
    }

    @Test
    public void testBalancedString4() {
        int result = new BalancedString().balancedString("QQQW");
        assertEquals(result, 2);
    }
}