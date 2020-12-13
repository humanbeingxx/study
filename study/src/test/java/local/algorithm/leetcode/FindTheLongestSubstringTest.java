package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FindTheLongestSubstringTest {

    @Test
    public void testFindTheLongestSubstring() {
        int result = new FindTheLongestSubstring().findTheLongestSubstring("bbccdd");
        System.out.println(result);
    }
}