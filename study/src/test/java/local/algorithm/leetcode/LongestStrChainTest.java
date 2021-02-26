package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LongestStrChainTest {

    @Test
    public void testLongestStrChain() {
        int result = new LongestStrChain().longestStrChain(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"});
        assertEquals(result, 5);
    }
}