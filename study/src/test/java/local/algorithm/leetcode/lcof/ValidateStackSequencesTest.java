package local.algorithm.leetcode.lcof;

import local.algorithm.leetcode.ValidateStackSequences;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidateStackSequencesTest {

    @Test
    public void testValidateStackSequences1() {
        boolean result = new local.algorithm.leetcode.ValidateStackSequences().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
        assertTrue(result);
    }

    @Test
    public void testValidateStackSequences2() {
        boolean result = new ValidateStackSequences().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 1, 2});
        assertFalse(result);
    }
}