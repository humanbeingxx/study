package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-06
 **/
public class LastStoneWeightTest {

    @Test
    public void testLastStoneWeight() {
        int result = new LastStoneWeight().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
        assertEquals(result, 1);
    }
}