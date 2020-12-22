package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SundaySearchTest {

    @Test
    public void testSearch1() {
        int pos = SundaySearch.search("substring searching", "hing");
        System.out.println(pos);
        System.out.println(0xFFFF);
    }

    @Test
    public void testSearch2() {
        assertEquals(SundaySearch.search("substring searching", "search"), 10);
        assertEquals(SundaySearch.search("search substring searching", "search"), 0);
        assertEquals(SundaySearch.search("substring searching", "searchx"), -1);
        assertEquals(SundaySearch.search("substring searching", ""), 0);
        assertEquals(SundaySearch.search("", "searchx"), -1);
        assertEquals(SundaySearch.search("", ""), -1);
    }

    @Test
    public void testOne() {
        int result = SundaySearch.search("aacc", "acc");
        Assert.assertEquals(result, 1);
    }
}