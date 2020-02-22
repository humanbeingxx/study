package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author cuixiaoshuang
 * @date 2020-02-22
 **/
public class CanPartitionKSubsetsTest {

    @Test
    public void testCanPartitionKSubsets1() {
        boolean result = new CanPartitionKSubsets().canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4);
        assertTrue(result);
    }

    @Test
    public void testCanPartitionKSubsets2() {
        boolean result = new CanPartitionKSubsets().canPartitionKSubsets(new int[]{2, 2, 2, 2, 3, 4, 5}, 4);
        assertFalse(result);
    }
}