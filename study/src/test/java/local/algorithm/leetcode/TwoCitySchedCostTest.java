package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/17 22:01
 */
public class TwoCitySchedCostTest {

    @Test
    public void testTwoCitySchedCost1() {
        int cost = new TwoCitySchedCost().twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}});
        Assert.assertEquals(cost, 110);
    }

    @Test
    public void testTwoCitySchedCost2() {
        int cost = new TwoCitySchedCost().twoCitySchedCost(new int[][]{{9, 1}, {10, 9}});
        Assert.assertEquals(cost, 11);
    }

}