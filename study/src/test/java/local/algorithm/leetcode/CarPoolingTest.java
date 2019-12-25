package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author cuixiaoshuang
 * @date 2019-12-25
 **/
public class CarPoolingTest {

    @Test
    public void testCarPooling1() {
        boolean result = new CarPooling().carPooling(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3);
        assertTrue(result);
    }

    @Test
    public void testCarPooling2() {
        boolean result = new CarPooling().carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4);
        assertFalse(result);
    }
}