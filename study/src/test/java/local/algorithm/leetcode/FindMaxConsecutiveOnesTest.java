package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-18
 **/
public class FindMaxConsecutiveOnesTest {

    @Test
    public void testFindMaxConsecutiveOnes() {
        int result = new FindMaxConsecutiveOnes().findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});
        Assert.assertEquals(result, 3);

        result = new FindMaxConsecutiveOnes().findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1});
        Assert.assertEquals(result, 2);

        result = new FindMaxConsecutiveOnes().findMaxConsecutiveOnes(new int[]{0});
        Assert.assertEquals(result, 0);

        result = new FindMaxConsecutiveOnes().findMaxConsecutiveOnes(new int[]{1});
        Assert.assertEquals(result, 1);
    }
}