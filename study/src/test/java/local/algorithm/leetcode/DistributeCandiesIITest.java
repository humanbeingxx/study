package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-06
 **/
public class DistributeCandiesIITest {

    @Test
    public void testDistributeCandies() {
        int[] result = new DistributeCandiesII().distributeCandies(20, 4);
        assertEquals(result, new int[]{6, 7, 3, 4});

        result = new DistributeCandiesII().distributeCandies(60, 4);
        assertEquals(result, new int[]{15, 18, 15, 12});

        result = new DistributeCandiesII().distributeCandies2(20, 4);
        assertEquals(result, new int[]{6, 7, 3, 4});

        result = new DistributeCandiesII().distributeCandies2(60, 4);
        assertEquals(result, new int[]{15, 18, 15, 12});
    }
}