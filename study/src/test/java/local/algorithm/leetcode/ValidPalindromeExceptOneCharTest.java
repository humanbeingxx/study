package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-16
 **/
public class ValidPalindromeExceptOneCharTest {

    @Test
    public void testCheckPalindrome1() {
        boolean check = new ValidPalindromeExceptOneChar().checkPalindrome("aba");
        Assert.assertTrue(check);
    }

    @Test
    public void testCheckPalindrome2() {
        boolean check = new ValidPalindromeExceptOneChar().checkPalindrome("aaa");
        Assert.assertTrue(check);
    }

    @Test
    public void testCheckPalindrome3() {
        boolean check = new ValidPalindromeExceptOneChar().checkPalindrome("abba");
        Assert.assertTrue(check);
    }

    @Test
    public void testCheckPalindrome4() {
        boolean check = new ValidPalindromeExceptOneChar().checkPalindrome("abbaa");
        Assert.assertFalse(check);
    }

    @Test
    public void testCheckPalindrome5() {
        boolean check = new ValidPalindromeExceptOneChar().checkPalindrome("");
        Assert.assertTrue(check);
    }

    @Test
    public void testValidPalindromeByForce1() {
        boolean result = new ValidPalindromeExceptOneChar().validPalindrome("abca");
        Assert.assertTrue(result);
    }

    @Test
    public void testValidPalindromeByForce2() {
        boolean result = new ValidPalindromeExceptOneChar().validPalindrome("eedede");
        Assert.assertTrue(result);
    }

    @Test
    public void testValidPalindromeByForce3() {
        boolean result = new ValidPalindromeExceptOneChar().validPalindrome("abc");
        Assert.assertFalse(result);
    }

    @Test
    public void testValidPalindromeByForce4() {
        boolean result = new ValidPalindromeExceptOneChar().validPalindrome("abba");
        Assert.assertTrue(result);
    }
}