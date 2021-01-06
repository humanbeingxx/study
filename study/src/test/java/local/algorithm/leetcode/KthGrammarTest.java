package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KthGrammarTest {

    @Test
    public void testKthGrammar0() {
        int result = new KthGrammar().kthGrammar(2, 1);
        assertEquals(result, 0);
    }

    @Test
    public void testKthGrammar1() {
        int result = new KthGrammar().kthGrammar(4, 5);
        assertEquals(result, 1);
    }

    @Test
    public void testKthGrammar2() {
        int result = new KthGrammar().kthGrammar(14, 50);
        assertEquals(result, 1);
    }
}