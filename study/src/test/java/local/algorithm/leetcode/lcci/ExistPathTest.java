package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ExistPathTest {

    @Test
    public void testExist1() {
        boolean result = new ExistPath().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},
                "ABCCED");
        assertTrue(result);
    }

    @Test
    public void testExist2() {
        boolean result = new ExistPath().exist(new char[][]{{'a','b'},{'c','d'}},
                "abcd");
        assertFalse(result);
    }
}