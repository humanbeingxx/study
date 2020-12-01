package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WordsFrequencyTest {

    @Test
    public void testGet1() {
        WordsFrequency wordsFrequency = new WordsFrequency(
                new String[]{"i", "have", "an", "apple", "he", "have", "a", "pen", new String(new char[]{0})});
        assertEquals(wordsFrequency.get("have"), 2);
        assertEquals(wordsFrequency.get("an"), 1);
        assertEquals(wordsFrequency.get("ana"), 0);
        assertEquals(wordsFrequency.get(new String(new char[]{0})), 1);
    }


}