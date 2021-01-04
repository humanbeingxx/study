package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FractionToDecimalTest {

    @Test
    public void testFractionToDecimal1() {
        assertEquals(new FractionToDecimal().fractionToDecimal(4, 10), "0.4");
        assertEquals(new FractionToDecimal().fractionToDecimal(4, 16), "0.25");
        assertEquals(new FractionToDecimal().fractionToDecimal(16, 4), "4");
        assertEquals(new FractionToDecimal().fractionToDecimal(405, 10), "40.5");
    }

    @Test
    public void testFractionToDecimal2() {
        assertEquals(new FractionToDecimal().fractionToDecimal(4, 3), "1.(3)");
    }

    @Test
    public void testFractionToDecimal3() {
        assertEquals(new FractionToDecimal().fractionToDecimal(4, 333), "0.(012)");
    }

    @Test
    public void testFractionToDecimal4() {
        String actual = new FractionToDecimal().fractionToDecimal(1237312, 1817);
        System.out.println(actual);
        System.out.println(1237312d / 1817);
    }

    @Test
    public void testFractionToDecimal5() {
        String actual = new FractionToDecimal().fractionToDecimal(1, 90);
        assertEquals(actual, "0.0(1)");
    }

    @Test
    public void testBoundary() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new FractionToDecimal().fractionToDecimal(Integer.MAX_VALUE, Integer.MAX_VALUE));
        System.out.println(new FractionToDecimal().fractionToDecimal(Integer.MAX_VALUE, Integer.MIN_VALUE));
        System.out.println(new FractionToDecimal().fractionToDecimal(Integer.MIN_VALUE, Integer.MIN_VALUE));
//        System.out.println(new FractionToDecimal().fractionToDecimal(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void test() {
        System.out.println(((double)Integer.MIN_VALUE) / Integer.MAX_VALUE);
        System.out.println(((double)Integer.MAX_VALUE) / Integer.MIN_VALUE);
    }
}