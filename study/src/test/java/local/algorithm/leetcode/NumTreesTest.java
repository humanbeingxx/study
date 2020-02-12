package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-11
 **/
public class NumTreesTest {

    @Test
    public void testNumTrees() {
        int result = new NumTrees().numTrees(18);
        assertEquals(result, 477638700);
    }
}