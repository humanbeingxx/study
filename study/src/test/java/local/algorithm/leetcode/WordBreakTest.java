package local.algorithm.leetcode;

import org.testng.annotations.Test;
import org.testng.collections.Lists;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author cuixiaoshuang
 * @date 2020-01-23
 **/
public class WordBreakTest {

    @Test
    public void testWordBreak1() {
        boolean result = new WordBreak().wordBreak("leetcode", Lists.newArrayList("leet", "code"));
        assertTrue(result);
    }

    @Test
    public void testWordBreak2() {
        boolean result = new WordBreak().wordBreak("applepenapple", Lists.newArrayList("apple", "pen"));
        assertTrue(result);
    }

    @Test
    public void testWordBreak3() {
        boolean result = new WordBreak().wordBreak("catsandog", Lists.newArrayList("cats", "dog", "sand", "and", "cat"));
        assertFalse(result);
    }

    @Test
    public void testWordBreak4() {
        boolean result = new WordBreak().wordBreak("aaaaaaa", Lists.newArrayList("aaaa", "aa"));
        assertFalse(result);
    }
}