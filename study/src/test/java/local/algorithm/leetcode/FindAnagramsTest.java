package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class FindAnagramsTest {

    @Test
    public void testFindAnagrams1() {
        List<Integer> result = new FindAnagrams().findAnagrams("cbaebabacd", "abc");
        assertEquals(result, Lists.newArrayList(0, 6));
    }

    @Test
    public void testFindAnagrams2() {
        List<Integer> result = new FindAnagrams().findAnagrams("abcdefg", "c");
        assertEquals(result, Lists.newArrayList(2));
    }

    @Test
    public void testFindAnagrams3() {
        List<Integer> result = new FindAnagrams().findAnagrams("abab", "ab");
        assertEquals(result, Lists.newArrayList(0, 1, 2));
    }

    @Test
    public void testFindAnagrams4() {
        List<Integer> result = new FindAnagrams().findAnagrams("aaaaa", "a");
        assertEquals(result, Lists.newArrayList(0, 1, 2, 3, 4));
    }
}