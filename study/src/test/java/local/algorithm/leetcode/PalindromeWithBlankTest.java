package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/1 14:07
 */
public class PalindromeWithBlankTest {

    @Test
    public void testIsPalindrome() {
        boolean result = new PalindromeWithBlank().isPalindrome("abccba");
        assertTrue(result);

        result = new PalindromeWithBlank().isPalindrome("A man, a plan, a canal: Panama");
        assertTrue(result);

        result = new PalindromeWithBlank().isPalindrome("race a car");
        assertFalse(result);
    }
}