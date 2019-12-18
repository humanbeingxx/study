package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-18
 **/
public class NumSpecialEquivGroupsTest {

    @Test
    public void testNumSpecialEquivGroups1() {
        int result = new NumSpecialEquivGroups().numSpecialEquivGroups(new String[]{"a", "b", "c", "a", "c", "c"});
        Assert.assertEquals(result, 3);
    }

    @Test
    public void testNumSpecialEquivGroups2() {
        int result = new NumSpecialEquivGroups().numSpecialEquivGroups(new String[]{"aa", "bb", "ab", "ba"});
        Assert.assertEquals(result, 4);
    }

    @Test
    public void testNumSpecialEquivGroups3() {
        int result = new NumSpecialEquivGroups().numSpecialEquivGroups(new String[]{"abc", "acb", "bac", "bca", "cab", "cba"});
        Assert.assertEquals(result, 3);
    }

    @Test
    public void testNumSpecialEquivGroups4() {
        int result = new NumSpecialEquivGroups().numSpecialEquivGroups(new String[]{"abcd", "cdab", "adcb", "cbad"});
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testNumSpecialEquivGroups5() {
        int result = new NumSpecialEquivGroups().numSpecialEquivGroups(new String[]{"abcd"});
        Assert.assertEquals(result, 1);
    }
}