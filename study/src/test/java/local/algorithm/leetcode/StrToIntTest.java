package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/6 17:26
 */
public class StrToIntTest {

    @Test
    public void testStrToInt0() {
        int result = new StrToInt().strToInt("  ");
        assertEquals(result, 0);
    }

    @Test
    public void testStrToInt1() {
        int result = new StrToInt().strToInt("12345");
        assertEquals(result, 12345);
    }

    @Test
    public void testStrToInt2() {
        int result = new StrToInt().strToInt("  -42");
        assertEquals(result, -42);
    }

    @Test
    public void testStrToInt3() {
        int result = new StrToInt().strToInt("4193 with words");
        assertEquals(result, 4193);
    }

    @Test
    public void testStrToInt4() {
        int result = new StrToInt().strToInt("words and 987");
        assertEquals(result, 0);
    }

    @Test
    public void testStrToInt5() {
        int result = new StrToInt().strToInt("-91283472332");
        assertEquals(result, -2147483648);
    }

    @Test
    public void testStrToInt6() {
        int result = new StrToInt().strToInt("1234567890000");
        assertEquals(result, 2147483647);
    }

    @Test
    public void testStrToInt7() {
        int result = new StrToInt().strToInt("  -0012a42");
        assertEquals(result, -12);
    }
}