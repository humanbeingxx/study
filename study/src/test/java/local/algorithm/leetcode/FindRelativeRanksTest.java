package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/20 23:27
 */
public class FindRelativeRanksTest {

    @Test
    public void testFindRelativeRanks() {
        String[] result = new FindRelativeRanks().findRelativeRanks(new int[]{1, 2, 3, 4, 5});
        assertEquals(result, new String[]{"5", "4", "Bronze Medal", "Silver Medal", "Gold Medal"});

        result = new FindRelativeRanks().findRelativeRanks(new int[]{5, 4, 3, 2, 1});
        assertEquals(result, new String[]{"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"});

        result = new FindRelativeRanks().findRelativeRanks(new int[]{5, 1, 2, 3, 4});
        assertEquals(result, new String[]{"Gold Medal", "5", "4", "Bronze Medal", "Silver Medal"});


        result = new FindRelativeRanks().findRelativeRanks(new int[]{5, 4});
        assertEquals(result, new String[]{"Gold Medal", "Silver Medal"});

        result = new FindRelativeRanks().findRelativeRanks(new int[]{5});
        assertEquals(result, new String[]{"Gold Medal"});

        result = new FindRelativeRanks().findRelativeRanks(new int[]{});
        assertEquals(result, new String[]{});

    }
}