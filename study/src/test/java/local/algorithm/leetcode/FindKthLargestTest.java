package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-07
 **/
public class FindKthLargestTest {

    @Test
    public void testFindKthLargest() {
        int result = new FindKthLargest().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        assertEquals(result, 4);
    }
}