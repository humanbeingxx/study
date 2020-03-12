package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ReverseStringInParenthesesTest {

    @Test
    public void testReverseParentheses1() {
        String result = new ReverseStringInParentheses().reverseParentheses("(ed(et(oc))el)");
        assertEquals(result, "leetcode");
    }

    @Test
    public void testReverseParentheses2() {
        String result = new ReverseStringInParentheses().reverseParentheses("a(bcdefghijkl(mno)p)q");
        assertEquals(result, "apmnolkjihgfedcbq");
    }

    @Test
    public void testReverseParentheses3() {
        String result = new ReverseStringInParentheses().reverseParentheses("(u(love)i)");
        assertEquals(result, "iloveu");
    }

    @Test
    public void testReverseParentheses4() {
        String result = new ReverseStringInParentheses().reverseParentheses("(love)");
        assertEquals(result, "evol");
    }
}