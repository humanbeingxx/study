package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-08
 **/
public class DivideWithAddTest {

    @Test
    public void testDivide1() {
        int result = new DivideWithAdd().divide(10, 3);
        assertEquals(result, 3);
    }

    @Test
    public void testDivide2() {
        int result = new DivideWithAdd().divide(10, -3);
        assertEquals(result, -3);
    }

    @Test
    public void testDivide3() {
        int result = new DivideWithAdd().divide(-2147483648, -1);
        assertEquals(result, 2147483647);
    }

    @Test
    public void testDivide4() {
        int result = new DivideWithAdd().divide(-2147483648, 1);
        assertEquals(result, -2147483648);
    }


    @Test
    public void testDivide5() {
        int result = new DivideWithAdd().divide(7, -3);
        assertEquals(result, -2);
    }

    @Test
    public void testDivide6() {
        int result = new DivideWithAdd().divide(-2147483648, -1);
        assertEquals(result, 2147483647);
    }

}