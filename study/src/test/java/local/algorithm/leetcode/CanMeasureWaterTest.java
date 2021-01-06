package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CanMeasureWaterTest {

    @Test
    public void testCanMeasureWater1() {
        boolean result = new CanMeasureWater().canMeasureWater(3, 5, 4);
        assertTrue(result);
    }

    @Test
    public void testCanMeasureWater2() {
        boolean result = new CanMeasureWater().canMeasureWater(2, 6, 5);
        assertFalse(result);
    }

    @Test
    public void testCanMeasureWaterRandom() {
        Random random = new Random();
        CanMeasureWater measure = new CanMeasureWater();
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(10);
            int y = random.nextInt(100) + x;
            int z = random.nextInt(y);
            System.out.println(String.format("x = %d, y = %d, z = %d, result: %b", x, y, z, measure.canMeasureWater(x, y, z)));
        }
    }
}