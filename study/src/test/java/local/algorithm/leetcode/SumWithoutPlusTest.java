package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/26 22:13
 */
public class SumWithoutPlusTest {

    @Test
    public void testGetSum() {
        int sum = new SumWithoutPlus().getSum(1, 2);
        assertEquals(sum, 3);

        sum = new SumWithoutPlus().getSum(2, 3);
        assertEquals(sum, 5);

        sum = new SumWithoutPlus().getSum(-2, 3);
        assertEquals(sum, 1);

        sum = new SumWithoutPlus().getSum(4, 5);
        assertEquals(sum, 9);

        sum = new SumWithoutPlus().getSum(Integer.MAX_VALUE, Integer.MIN_VALUE);
        assertEquals(sum, -1);
    }
}