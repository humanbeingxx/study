package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RespaceTest {

    @Test
    public void testRespace1() {
        int result = new Respace().respace(new String[]{"looked","just","like","her","brother"},
                "jesslookedjustliketimherbrother");
        assertEquals(result, 7);
    }
}