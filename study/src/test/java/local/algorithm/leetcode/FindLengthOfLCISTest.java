package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/28 21:45
 */
public class FindLengthOfLCISTest {

    @Test
    public void testFindLengthOfLCIS() {
        int result = new FindLengthOfLCIS().findLengthOfLCIS(new int[]{1, 3, 5, 4, 7});
        assertEquals(result, 3);

        result = new FindLengthOfLCIS().findLengthOfLCIS(new int[]{1, 3, 4, 5, 7});
        assertEquals(result, 5);

        result = new FindLengthOfLCIS().findLengthOfLCIS(new int[]{5, 4, 3, 2, 1});
        assertEquals(result, 1);

        result = new FindLengthOfLCIS().findLengthOfLCIS(new int[]{1, 3});
        assertEquals(result, 2);

        result = new FindLengthOfLCIS().findLengthOfLCIS(new int[]{3, 1});
        assertEquals(result, 1);
    }
}