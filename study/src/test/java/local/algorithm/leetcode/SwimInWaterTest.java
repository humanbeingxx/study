package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SwimInWaterTest {

    @Test
    public void testSwimInWater1() {
        int result = new SwimInWater().swimInWater(new int[][]{
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        });
        assertEquals(result, 16);
    }
}