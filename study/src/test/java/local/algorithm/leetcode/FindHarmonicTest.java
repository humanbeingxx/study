package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class FindHarmonicTest {

    @Test
    public void testFindLHS() {
        int result = new FindHarmonic().findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7});
        assertEquals(result, 5);

        result = new FindHarmonic().findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7, 1, 3, 2, 2, 5, 2, 3, 7});
        assertEquals(result, 10);

        result = new FindHarmonic().findLHS(new int[]{1, 3});
        assertEquals(result, 0);

        result = new FindHarmonic().findLHS(new int[]{1, 2, 3});
        assertEquals(result, 2);

        result = new FindHarmonic().findLHS(new int[]{1, 2, 2, 1});
        assertEquals(result, 4);
    }
}