package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class MinCostToMoveChipsTest {

    @Test
    public void testMinCostToMoveChips() {
        int result = new MinCostToMoveChips().minCostToMoveChips(new int[]{2, 2, 2, 3, 3});
        assertEquals(result, 2);

        result = new MinCostToMoveChips().minCostToMoveChips(new int[]{2, 2, 2, 2, 2});
        assertEquals(result, 0);

        result = new MinCostToMoveChips().minCostToMoveChips(new int[]{1, 2, 2, 2, 2});
        assertEquals(result, 1);
    }
}