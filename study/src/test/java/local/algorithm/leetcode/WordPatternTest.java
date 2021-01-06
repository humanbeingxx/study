package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/25 22:26
 */
public class WordPatternTest {

    @Test
    public void testWordPattern() {
        boolean result = new WordPattern().wordPattern("abba", "dog cat cat dog");
        assertTrue(result);

        result = new WordPattern().wordPattern("abba", "dog cat cat fish");
        assertFalse(result);

        result = new WordPattern().wordPattern("aaaa", "dog cat cat dog");
        assertFalse(result);
    }
}