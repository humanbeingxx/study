package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class FindLongestSubarrayTest {

    @Test
    public void testFindLongestSubarray1() {
        String[] result = new FindLongestSubarray().findLongestSubarray(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testFindLongestSubarray2() {
        String[] result = new FindLongestSubarray().findLongestSubarray(new String[]{"A", "A"});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testFindLongestSubarray3() {
        String[] result = new FindLongestSubarray().findLongestSubarray(new String[]{"A", "A", "1", "1", "1", "1", "1", "A", "A", "A", "A", "A"});
        System.out.println(Arrays.toString(result));
    }
}