package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class IncreasingTripletTest {

    @Test
    public void testIncreasingTriplet1() {
        boolean result = new IncreasingTriplet().increasingTriplet(new int[]{3, 2, 1, 4});
        assertFalse(result);
    }
}