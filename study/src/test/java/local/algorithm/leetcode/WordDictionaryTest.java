package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class WordDictionaryTest {

    @Test
    public void testAddWord() {
        WordDictionary dic = new WordDictionary();
        dic.addWord("abc");
        dic.addWord("def");
        dic.addWord("-");
        System.out.println(dic);
    }

    @Test
    public void testSearch() {
        WordDictionary dic = new WordDictionary();
        dic.addWord("bad");
        dic.addWord("dad");
        dic.addWord("mad");
        assertTrue(dic.search("bad"));
        assertTrue(dic.search(".ad"));
        assertTrue(dic.search("b.."));
        assertFalse(dic.search("pad"));
    }
}