package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/22 15:49
 */
public class CheckPalindromeTest {

    @Test
    public void testIsPalindrome() {
        boolean result = new CheckPalindrome().isPalindrome(123321);
        assertTrue(result);
        result = new CheckPalindrome().isPalindrome(12321);
        assertTrue(result);
        result = new CheckPalindrome().isPalindrome(1);
        assertTrue(result);
        result = new CheckPalindrome().isPalindrome(0);
        assertTrue(result);

        result = new CheckPalindrome().isPalindrome(-10);
        assertFalse(result);
        result = new CheckPalindrome().isPalindrome(123221);
        assertFalse(result);

    }
}