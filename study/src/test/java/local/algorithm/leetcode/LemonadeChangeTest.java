package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author cuixiaoshuang
 * @date 2019-12-25
 **/
public class LemonadeChangeTest {

    @Test
    public void testLemonadeChange1() {
        boolean result = new LemonadeChange().lemonadeChange(new int[]{5, 5, 5, 10, 20});
        assertTrue(result);
    }

    @Test
    public void testLemonadeChange2() {
        boolean result = new LemonadeChange().lemonadeChange(new int[]{5, 5, 10});
        assertTrue(result);
    }

    @Test
    public void testLemonadeChange3() {
        boolean result = new LemonadeChange().lemonadeChange(new int[]{5, 5, 10, 10, 20});
        assertFalse(result);
    }
}