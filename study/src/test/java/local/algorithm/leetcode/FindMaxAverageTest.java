package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/18 22:04
 */
public class FindMaxAverageTest {

    @Test
    public void testFindMaxAverage() {
        double result = new FindMaxAverage().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4);
        Assert.assertEquals(result, 12.75, 0.01);

        result = new FindMaxAverage().findMaxAverage(new int[]{1, 12, -5, -6}, 4);
        Assert.assertEquals(result, 0.5, 0.01);
    }

}