package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-20
 **/
public class DecimalToHexTest {

    @Test
    public void testToHex1() {
        String result = new DecimalToHex().toHex(-1);
        assertEquals(result, "ffffffff");
    }

    @Test
    public void testToHex2() {
        String result = new DecimalToHex().toHex(26);
        assertEquals(result, "1a");
    }

    @Test
    public void testToHex3() {
        String result = new DecimalToHex().toHex(0);
        assertEquals(result, "0");
    }

    @Test
    public void testToHex4() {
        String result = new DecimalToHex().toHex(Integer.MAX_VALUE);
        assertEquals(result, "7fffffff");
    }

    @Test
    public void testToHex5() {
        String result = new DecimalToHex().toHex(Integer.MIN_VALUE);
        assertEquals(result, "80000000");
    }
}