package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-01-03
 **/
public class RemoveOuterParenthesesTest {

    @Test
    public void testRemoveOuterParentheses() {
        String result = new RemoveOuterParentheses().removeOuterParentheses("()()()");
        assertEquals(result, "");

        result = new RemoveOuterParentheses().removeOuterParentheses("((()))");
        assertEquals(result, "(())");

        result = new RemoveOuterParentheses().removeOuterParentheses("(()())(())(()(()))");
        assertEquals(result, "()()()()(())");

        result = new RemoveOuterParentheses().removeOuterParentheses("()");
        assertEquals(result, "");

        result = new RemoveOuterParentheses().removeOuterParentheses("");
        assertEquals(result, "");
    }
}