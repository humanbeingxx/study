package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author cuixiaoshuang
 * @date 2020-02-08
 **/
public class ContainsNearbyAlmostDuplicateTest {

    @Test
    public void testContainsNearbyAlmostDuplicate1() {
        boolean result = new ContainsNearbyAlmostDuplicate().containsNearbyAlmostDuplicate(
                new int[]{1, 2, 3, 1}, 3, 0
        );
        assertTrue(result);
    }

    @Test
    public void testContainsNearbyAlmostDuplicate2() {
        boolean result = new ContainsNearbyAlmostDuplicate().containsNearbyAlmostDuplicate(
                new int[]{1, 0, 1, 1}, 1, 2
        );
        assertTrue(result);
    }

    @Test
    public void testContainsNearbyAlmostDuplicate3() {
        boolean result = new ContainsNearbyAlmostDuplicate().containsNearbyAlmostDuplicate(
                new int[]{1, 5, 9, 1, 5, 9}, 2, 3
        );
        assertFalse(result);
    }
}