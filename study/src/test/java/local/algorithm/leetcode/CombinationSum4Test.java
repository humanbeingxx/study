package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @author cuixiaoshuang
 * @date 2020-01-28
 **/
public class CombinationSum4Test {

    @Test
    public void testCombinationSum4() {
        int result = new CombinationSum4().combinationSum4(new int[]{1, 2, 3}, 4);
        assertEquals(result, 7);
    }
}