package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-01-03
 **/
public class SubtractProductAndSumTest {

    @Test
    public void testSubtractProductAndSum() {
        int result = new SubtractProductAndSum().subtractProductAndSum(4421);
        assertEquals(result, 21);

        result = new SubtractProductAndSum().subtractProductAndSum(234);
        assertEquals(result, 15);

        result = new SubtractProductAndSum().subtractProductAndSum(1024);
        assertEquals(result, -7);
    }
}