package local.algorithm.leetcode.lcof;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class IsNumberTest {

    @Test
    public void testIsNumber0() {
        boolean result = new IsNumber().isNumber("1");
        assertTrue(result);
    }

    @Test
    public void testIsNumber1() {
        boolean result = new IsNumber().isNumber("3.1416");
        assertTrue(result);
    }

    @Test
    public void testIsNumber2() {
        boolean result = new IsNumber().isNumber("-1E-16");
        assertTrue(result);
    }

    @Test
    public void testIsNumber3() {
        boolean result = new IsNumber().isNumber("-1.1E+16");
        assertTrue(result);
    }

    @Test
    public void testIsNumber4() {
        boolean result = new IsNumber().isNumber("12e+5.4");
        assertFalse(result);
    }

    @Test
    public void testIsNumber5() {
        boolean result = new IsNumber().isNumber("1.2.3");
        assertFalse(result);
    }

    @Test
    public void testIsNumber6() {
        boolean result = new IsNumber().isNumber("e10");
        assertFalse(result);
    }

    @Test
    public void testIsNumber7() {
        boolean result = new IsNumber().isNumber(".10");
        assertFalse(result);
    }

    @Test
    public void testIsNumber8() {
        boolean result = new IsNumber().isNumber("1.e1");
        assertFalse(result);
    }
}