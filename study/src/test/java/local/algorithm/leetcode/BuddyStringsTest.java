package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/16 2:01
 */
public class BuddyStringsTest {

    @Test
    public void testBuddyStrings1() {
        boolean b = new BuddyStrings().buddyStrings("ab", "ab");
        Assert.assertFalse(b);
    }

    @Test
    public void testBuddyStrings2() {
        boolean b = new BuddyStrings().buddyStrings("ab", "ba");
        Assert.assertTrue(b);
    }

    @Test
    public void testBuddyStrings3() {
        boolean b = new BuddyStrings().buddyStrings("aa", "ab");
        Assert.assertFalse(b);
    }

    @Test
    public void testBuddyStrings4() {
        boolean b = new BuddyStrings().buddyStrings("aaaaaaabc", "aaaaaaacb");
        Assert.assertTrue(b);
    }

    @Test
    public void testBuddyStrings5() {
        boolean b = new BuddyStrings().buddyStrings("aaaaaaabc", "aaaaaabca");
        Assert.assertFalse(b);
    }
}