package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StrInStrBySundayTest {

    @Test
    public void testStrStr1() {
        int result = new StrInStrBySunday().strStr("hello", "ll");
        assertEquals(result, 2);
    }

    @Test
    public void testStrStr2() {
        int result = new StrInStrBySunday().strStr("abbbabbbabbb", "bbbb");
        assertEquals(result, -1);
    }

    @Test
    public void testStrStr3() {
        int result = new StrInStrBySunday().strStr("aaaaa", "bba");
        assertEquals(result, -1);
    }

    @Test
    public void testStrStr4() {
        int result = new StrInStrBySunday().strStr("aaabbaaabb", "baaab");
        assertEquals(result, 4);
    }

    @Test
    public void testStrStr5() {
        int result = new StrInStrBySunday().strStr("mississippi", "sippia");
        assertEquals(result, -1);
    }
}