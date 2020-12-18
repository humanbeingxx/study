package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MaxRepOpt1Test {

    @Test
    public void testMaxRepOpt11() {
        int result = new MaxRepOpt1().maxRepOpt1("aaaa");
        assertEquals(result, 4);
    }

    @Test
    public void testMaxRepOpt12() {
        int result = new MaxRepOpt1().maxRepOpt1("aabaa");
        assertEquals(result, 4);
    }

    @Test
    public void testMaxRepOpt13() {
        int result = new MaxRepOpt1().maxRepOpt1("aaabaaa");
        assertEquals(result, 6);
    }

    @Test
    public void testMaxRepOpt14() {
        int result = new MaxRepOpt1().maxRepOpt1("aababbbb");
        assertEquals(result, 5);
    }

    @Test
    public void testMaxRepOpt15() {
        int result = new MaxRepOpt1().maxRepOpt1("abcdef");
        assertEquals(result, 1);
    }

    @Test
    public void testMaxRepOpt16() {
        int result = new MaxRepOpt1().maxRepOpt1("acbaaa");
        assertEquals(result, 4);
    }

    @Test
    public void testMaxRepOpt17() {
        int result = new MaxRepOpt1().maxRepOpt1("acbaaadd");
        assertEquals(result, 4);
    }
}