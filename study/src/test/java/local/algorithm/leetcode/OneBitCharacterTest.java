package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class OneBitCharacterTest {

    @Test
    public void testIsOneBitCharacter() {
        boolean result = new OneBitCharacter().isOneBitCharacter(new int[]{1, 1, 0});
        assertTrue(result);

        result = new OneBitCharacter().isOneBitCharacter(new int[]{1, 1, 1, 0});
        assertFalse(result);
    }
}