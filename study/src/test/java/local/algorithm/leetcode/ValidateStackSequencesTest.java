package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author cuixiaoshuang
 * @date 2020-01-13
 **/
public class ValidateStackSequencesTest {

    @Test
    public void testValidateStackSequences1() {
        boolean result = new ValidateStackSequences().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
        assertTrue(result);
    }

    @Test
    public void testValidateStackSequences2() {
        boolean result = new ValidateStackSequences().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 1, 2});
        assertFalse(result);
    }
}