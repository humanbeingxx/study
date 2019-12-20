package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-20
 **/
public class RotateStringTest {

    @Test
    public void testRotateString1() {
        boolean result = new RotateString().rotateString("abcde", "cdeab");
        assertTrue(result);
    }

    @Test
    public void testRotateString2() {
        boolean result = new RotateString().rotateString("abcde", "abced");
        assertFalse(result);
    }

    @Test
    public void testRotateString3() {

    }
}