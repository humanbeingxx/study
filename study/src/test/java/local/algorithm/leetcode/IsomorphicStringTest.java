package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/29 21:54
 */
public class IsomorphicStringTest {

    @Test
    public void testIsIsomorphic() {
        boolean result = new IsomorphicString().isIsomorphic("egg", "add");
        assertTrue(result);

        result = new IsomorphicString().isIsomorphic("foo", "bar");
        assertFalse(result);

        result = new IsomorphicString().isIsomorphic("paper", "title");
        assertTrue(result);

        result = new IsomorphicString().isIsomorphic("ab", "aa");
        assertFalse(result);
    }
}