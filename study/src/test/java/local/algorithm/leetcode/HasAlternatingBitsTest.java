package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 14:07
 */
public class HasAlternatingBitsTest {

    @Test
    public void testHasAlternatingBits() {
        boolean result = new HasAlternatingBits().hasAlternatingBits(5);
        assertTrue(result);

        result = new HasAlternatingBits().hasAlternatingBits(0);
        assertTrue(result);

        result = new HasAlternatingBits().hasAlternatingBits(1);
        assertTrue(result);

        result = new HasAlternatingBits().hasAlternatingBits(2);
        assertTrue(result);

        result = new HasAlternatingBits().hasAlternatingBits(7);
        assertFalse(result);

        result = new HasAlternatingBits().hasAlternatingBits(0b010101010101010101010101010101010);
        assertTrue(result);
    }
}