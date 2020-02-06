package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-05
 **/
public class Find132patternTest {

    @Test
    public void testFind132pattern1() {
        boolean result = new Find132pattern().find132pattern(new int[]{1, 2, 3, 4});
        assertFalse(result);
    }

    @Test
    public void testFind132pattern2() {
        boolean result = new Find132pattern().find132pattern(new int[]{3, 1, 4, 2});
        assertTrue(result);
    }

    @Test
    public void testFind132pattern3() {
        boolean result = new Find132pattern().find132pattern(new int[]{-1, 3, 2, 0});
        assertTrue(result);
    }
}