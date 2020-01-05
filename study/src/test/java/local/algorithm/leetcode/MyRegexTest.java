package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-01-03
 **/
public class MyRegexTest {

    @Test
    public void testIsMatch() {
        boolean result = new MyRegex().isMatch("aabb", "aabb");
        assertTrue(result);

        result = new MyRegex().isMatch("aabb", "abb");
        assertFalse(result);

        result = new MyRegex().isMatch("aabb", "a*b*");
        assertTrue(result);

        result = new MyRegex().isMatch("aabb", "a*c*");
        assertFalse(result);

        result = new MyRegex().isMatch("abcdefg", ".*");
        assertTrue(result);

        result = new MyRegex().isMatch("aaabb", "a*ab*b");
        assertTrue(result);

        result = new MyRegex().isMatch("mississippi", "mis*is*p*.");
        assertFalse(result);

        result = new MyRegex().isMatch("ippi", "ip*.");
        assertTrue(result);

        result = new MyRegex().isMatch("", "c*c*");
        assertTrue(result);

        result = new MyRegex().isMatch("a", ".*..a*");
        assertFalse(result);

        result = new MyRegex().isMatch("", ".*");
        assertTrue(result);
    }
}