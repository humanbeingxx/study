package local.interview_internal_reference.byhunter;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TrappingRainWaterTest {

    @Test
    public void testTrap1() {
        int result = new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        assertEquals(result, 6);
    }

    @Test
    public void testTrap2() {
        int result = new TrappingRainWater().trap(new int[]{4,3,2,1,2,3,4});
        assertEquals(result, 9);
    }
}