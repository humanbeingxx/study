package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-27
 **/
public class SearchRangeTest {

    @Test
    public void testSearchFirst() {
        int result = new SearchRange().searchFirst(new int[]{1, 2, 3}, 2);
        assertEquals(result, 1);

        result = new SearchRange().searchFirst(new int[]{1, 2, 2, 2, 3}, 2);
        assertEquals(result, 1);

        result = new SearchRange().searchFirst(new int[]{1, 2, 2, 2, 2, 2, 2, 2, 3}, 2);
        assertEquals(result, 1);

        result = new SearchRange().searchFirst(new int[]{0}, 2);
        assertEquals(result, -1);

        result = new SearchRange().searchFirst(new int[]{2, 2, 2, 3}, 2);
        assertEquals(result, 0);
    }

    @Test
    public void testSearchLast() {
        int result = new SearchRange().searchLast(new int[]{1, 2, 3}, 2);
        assertEquals(result, 1);

        result = new SearchRange().searchLast(new int[]{1, 2, 2, 2, 3}, 2);
        assertEquals(result, 3);

        result = new SearchRange().searchLast(new int[]{1, 2, 2, 2, 2, 2, 2, 2, 3}, 2);
        assertEquals(result, 7);

        result = new SearchRange().searchLast(new int[]{0}, 2);
        assertEquals(result, -1);

        result = new SearchRange().searchLast(new int[]{2, 2, 2, 3}, 2);
        assertEquals(result, 2);
    }
}