package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/28 21:50
 */
public class FindNumberOfLISTest {

    @Test
    public void testFindNumberOfLIS() {
        int result = new FindNumberOfLIS().findNumberOfLIS(new int[]{1, 1, 1, 1, 1});
        assertEquals(result, 5);

        result = new FindNumberOfLIS().findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
        assertEquals(result, 2);

        result = new FindNumberOfLIS().findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2});
        assertEquals(result, 3);
    }

    @Test
    public void testFindNumberOfLIS2() {
        int result = new FindNumberOfLIS().findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2});
        assertEquals(result, 3);
    }

    @Test
    public void testFindNumberOfLIS3() {
        int result = new FindNumberOfLIS().findNumberOfLIS(new int[]{2, 1});
        assertEquals(result, 2);
    }

    @Test
    public void testFindNumberOfLIS4() {
        int result = new FindNumberOfLIS().findNumberOfLIS(new int[]{3,1,2});
        assertEquals(result, 1);
    }
}