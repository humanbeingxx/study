package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RearrangeWordsTest {

    @Test
    public void testArrangeWords1() {
        String result = new RearrangeWords().arrangeWords("Keep calm and code on");
        assertEquals(result, "On and keep calm code");
    }

    @Test
    public void testArrangeWords2() {
        String result = new RearrangeWords().arrangeWords("Leetcode is cool");
        assertEquals(result, "Is cool leetcode");
    }
}