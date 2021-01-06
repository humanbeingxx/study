package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MinRemoveToMakeValidTest {

    @Test
    public void testMinRemoveToMakeValid1() {
        String result = new MinRemoveToMakeValid().minRemoveToMakeValid("lee(t(c)o)de)");
        assertEquals(result, "lee(t(c)o)de");
    }

    @Test
    public void testMinRemoveToMakeValid2() {
        String result = new MinRemoveToMakeValid().minRemoveToMakeValid("a)b(c)d");
        assertEquals(result, "ab(c)d");
    }

    @Test
    public void testMinRemoveToMakeValid3() {
        String result = new MinRemoveToMakeValid().minRemoveToMakeValid("))((");
        assertEquals(result, "");
    }

    @Test
    public void testMinRemoveToMakeValid4() {
        String result = new MinRemoveToMakeValid().minRemoveToMakeValid("(a(b(c)d)");
        assertEquals(result, "(a(bc)d)");
    }
}