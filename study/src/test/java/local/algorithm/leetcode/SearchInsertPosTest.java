package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-20
 **/
public class SearchInsertPosTest {

    @Test
    public void testSearchInsert() {
        int result = new SearchInsertPos().searchInsert(new int[]{1, 3, 5, 6}, 5);
        assertEquals(result, 2);

        result = new SearchInsertPos().searchInsert(new int[]{1, 3, 5, 6}, 2);
        assertEquals(result, 1);

        result = new SearchInsertPos().searchInsert(new int[]{1, 3, 5, 6}, 7);
        assertEquals(result, 4);

        result = new SearchInsertPos().searchInsert(new int[]{1, 3, 5, 6}, 0);
        assertEquals(result, 0);

        result = new SearchInsertPos().searchInsert(new int[]{1, 3}, 2);
        assertEquals(result, 1);
    }
}