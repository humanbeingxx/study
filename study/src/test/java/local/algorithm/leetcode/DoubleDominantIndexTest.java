package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-25
 **/
public class DoubleDominantIndexTest {

    @Test
    public void testDominantIndex() {
        int result = new DoubleDominantIndex().dominantIndex(new int[]{3, 6, 1, 0});
        assertEquals(result, 1);

        result = new DoubleDominantIndex().dominantIndex(new int[]{1, 2, 3, 4});
        assertEquals(result, -1);

        result = new DoubleDominantIndex().dominantIndex(new int[]{1});
        assertEquals(result, 0);

        result = new DoubleDominantIndex().dominantIndex(new int[]{});
        assertEquals(result, -1);

        result = new DoubleDominantIndex().dominantIndex(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE});
        assertEquals(result, -1);
    }
}