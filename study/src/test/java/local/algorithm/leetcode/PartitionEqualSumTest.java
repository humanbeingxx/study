package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author cuixiaoshuang
 * @date 2020-01-27
 **/
public class PartitionEqualSumTest {

    @Test
    public void testCanPartition() {
        boolean result = new PartitionEqualSum().canPartition(new int[]{1, 5, 11, 5});
        assertTrue(result);
        result = new PartitionEqualSum().canPartition(new int[]{1, 2, 3, 5});
        assertFalse(result);
    }
}