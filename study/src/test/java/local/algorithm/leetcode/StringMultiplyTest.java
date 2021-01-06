package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StringMultiplyTest {

    @Test
    public void testMultiply1() {
        String result = new StringMultiply().multiply("100", "1000");
        assertEquals(result, "100000");
    }

    @Test
    public void testMultiply2() {
        String result = new StringMultiply().multiply("123", "456");
        assertEquals(result, "56088");
    }

    @Test
    public void testMultiply3() {
        String result = new StringMultiply().multiply("111111111111111111111111111111", "111111111111111111111111111111");
        assertEquals(result, "12345679012345679012345679012320987654320987654320987654321");
    }

    @Test
    public void testMultiply4() {
        String result = new StringMultiply().multiply("100", "1000");
        assertEquals(result, "100000");
    }

    @Test
    public void testAdd() {
        String result = new StringMultiply().add("12345", "43210");
        System.out.println(result);
    }
}