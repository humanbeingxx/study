package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/2 22:06
 */
public class CanThreePartsEqualSumTest {

    @Test
    public void testCanThreePartsEqualSum() {
        boolean result = new CanThreePartsEqualSum().canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1});
        assertTrue(result);

        result = new CanThreePartsEqualSum().canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4});
        assertTrue(result);

        result = new CanThreePartsEqualSum().canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1});
        assertFalse(result);
    }
}