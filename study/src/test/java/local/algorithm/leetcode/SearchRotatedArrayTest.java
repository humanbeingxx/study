package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-20
 **/
public class SearchRotatedArrayTest {

    @Test
    public void testSearch1() {
        int result = new SearchRotatedArray().search(new int[]{4, 5, 6, 7, 1, 2, 3}, 2);
        assertEquals(result, 5);
    }

    @Test
    public void testSearch2() {
        int result = new SearchRotatedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2, 3}, 0);
        assertEquals(result, 4);
    }

    @Test
    public void testSearch3() {
        int result = new SearchRotatedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        assertEquals(result, -1);
    }

    @Test
    public void testSearch4() {
        int result = new SearchRotatedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, -1);
        assertEquals(result, -1);
    }

    @Test
    public void testSearch5() {
        int result = new SearchRotatedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6);
        assertEquals(result, 2);
    }

    @Test
    public void testSearch6() {
        int result = new SearchRotatedArray().search(new int[]{5, 1, 2, 3, 4}, 1);
        assertEquals(result, 1);
    }
}