package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AsFarFromLandAsPossibleTest {

    @Test
    public void testMaxDistance1() {
        int result = new AsFarFromLandAsPossible().maxDistance(new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        });
        assertEquals(result, 2);
    }

    @Test
    public void testMaxDistance2() {
        int result = new AsFarFromLandAsPossible().maxDistance(new int[][]{
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });
        assertEquals(result, 4);
    }

    @Test
    public void testMaxDistance3() {
        int result = new AsFarFromLandAsPossible().maxDistance(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });
        assertEquals(result, -1);
    }

    @Test
    public void testMaxDistance4() {
        int result = new AsFarFromLandAsPossible().maxDistance(new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });
        assertEquals(result, -1);
    }
}