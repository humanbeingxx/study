package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 21:44
 */
public class FindPairsDiffKTest {

    @Test
    public void testFindPairs() {
        int pairs = new FindPairsDiffK().findPairs(new int[]{3, 1, 4, 1, 5}, 2);

        Assert.assertEquals(pairs, 2);
    }

    @Test
    public void testFindPairs2() {
        int pairs = new FindPairsDiffK().findPairs(new int[]{1, 2, 3, 4, 5}, 1);

        Assert.assertEquals(pairs, 4);
    }

    @Test
    public void testFindPairs3() {
        int pairs = new FindPairsDiffK().findPairs(new int[]{1, 3, 1, 5, 4}, 0);

        Assert.assertEquals(pairs, 1);
    }
}