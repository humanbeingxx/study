package local.algorithm.leetcode;

import org.testng.annotations.Test;

public class LongestCommonSubsequenceTest {

    @Test
    public void testLongestCommonSubsequenceWithResult() {
        LongestCommonSubsequence func = new LongestCommonSubsequence();
        String text1 = "abcdefg";
        String text2 = "acdeg";
        int len = func.longestCommonSubsequence(text1, text2);
        String result = func.longestCommonSubsequenceWithResult(text1, text2);
        System.out.println(len);
        System.out.println(result);
    }

    @Test
    public void testLongestCommonSubsequenceWithResult2() {
        LongestCommonSubsequence func = new LongestCommonSubsequence();
        String text1 = "BDCABA";
        String text2 = "ABCBDAB";
        int len = func.longestCommonSubsequence(text1, text2);
        String result = func.longestCommonSubsequenceWithResult(text1, text2);
        System.out.println(len);
        System.out.println(result);
    }
}