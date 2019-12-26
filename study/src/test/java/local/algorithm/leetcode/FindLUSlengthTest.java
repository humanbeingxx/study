package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-26
 **/
public class FindLUSlengthTest {

    @Test
    public void testFindLUSlength() {
        int result = new FindLUSlength().findLUSlength("aba", "cbc");
        assertEquals(result, 3);
    }
}