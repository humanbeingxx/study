package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CinemaSeatAllocationTest {

    @Test
    public void testMaxNumberOfFamilies1() {
        int result = new CinemaSeatAllocation().maxNumberOfFamilies(3, new int[][]{
                {1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}
        });
        assertEquals(result, 4);
    }

    @Test
    public void testMaxNumberOfFamilies2() {
        int result = new CinemaSeatAllocation().maxNumberOfFamilies(4, new int[][]{
                {2, 10}, {3, 1}, {1, 2}, {2, 2}, {3, 5}, {4, 1}, {4, 9}, {2, 7}
        });
        assertEquals(result, 3);
    }

    @Test
    public void testMaxNumberOfFamiliesByMap1() {
        int result = new CinemaSeatAllocation().maxNumberOfFamiliesByMap(3, new int[][]{
                {1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}
        });
        assertEquals(result, 4);
    }

    @Test
    public void testMaxNumberOfFamiliesByMap2() {
        int result = new CinemaSeatAllocation().maxNumberOfFamiliesByMap(4, new int[][]{
                {2, 10}, {3, 1}, {1, 2}, {2, 2}, {3, 5}, {4, 1}, {4, 9}, {2, 7}
        });
        assertEquals(result, 3);
    }
}