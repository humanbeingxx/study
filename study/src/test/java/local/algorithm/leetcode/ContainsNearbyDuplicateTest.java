package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class ContainsNearbyDuplicateTest {

    @Test
    public void testContainsNearbyDuplicate() {
        boolean result = new ContainsNearbyDuplicate().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3);
        assertTrue(result);

        result = new ContainsNearbyDuplicate().containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1);
        assertTrue(result);

        result = new ContainsNearbyDuplicate().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2);
        assertFalse(result);
    }
}