package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-20
 **/
public class TheZWordTest {

    @Test
    public void testConvert1() {
        String result = new TheZWord().convert("LEETCODEISHIRING", 3);
        assertEquals(result, "LCIRETOESIIGEDHN");
    }

    @Test
    public void testConvert2() {
        String result = new TheZWord().convert("LEETCODEISHIRING", 4);
        assertEquals(result, "LDREOEIIECIHNTSG");
    }

    @Test
    public void testConvert3() {
        String result = new TheZWord().convert("LEETCODEISHIRING", 1);
        assertEquals(result, "LEETCODEISHIRING");
    }

    @Test
    public void testConvert4() {
        String result = new TheZWord().convert("LEETCODEISHIRING", 100);
        assertEquals(result, "LEETCODEISHIRING");
    }
}