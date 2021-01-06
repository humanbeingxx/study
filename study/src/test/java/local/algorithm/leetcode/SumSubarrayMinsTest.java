package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class SumSubarrayMinsTest {

    @Test
    public void testSumSubarrayMins0() {
        int resultForce = new SumSubarrayMins().sumSubarrayMinsForce(new int[]{1});
        int result = new SumSubarrayMins().sumSubarrayMins(new int[]{1});
        assertEquals(result, resultForce);
    }

    @Test
    public void testSumSubarrayMins1() {
        int resultForce = new SumSubarrayMins().sumSubarrayMinsForce(new int[]{1, 3, 2, 4});
        int result = new SumSubarrayMins().sumSubarrayMins(new int[]{1, 3, 2, 4});
        assertEquals(result, resultForce);
    }

    @Test
    public void testSumSubarrayMins2() {
        int resultForce = new SumSubarrayMins().sumSubarrayMinsForce(new int[]{3, 1, 2, 4});
        int result = new SumSubarrayMins().sumSubarrayMins(new int[]{3, 1, 2, 4});
        assertEquals(result, resultForce);
    }

    @Test
    public void testSumSubarrayMins3() {
        int resultForce = new SumSubarrayMins().sumSubarrayMinsForce(new int[]{11, 81, 94, 43, 20, 10});
        int result = new SumSubarrayMins().sumSubarrayMins(new int[]{11, 81, 94, 43, 20, 10});
        assertEquals(result, resultForce);
    }

    @Test
    public void testSumSubarrayMins4() {
        int resultForce = new SumSubarrayMins().sumSubarrayMinsForce(new int[]{5, 4, 5, 3, 5, 3});
        int result = new SumSubarrayMins().sumSubarrayMins(new int[]{5, 4, 5, 3, 5, 3});
        assertEquals(result, resultForce);
    }

    @Test
    public void testSumSubarrayMins5() {
        int resultForce = new SumSubarrayMins().sumSubarrayMinsForce(new int[]{5, 6, 5});
        int result = new SumSubarrayMins().sumSubarrayMins(new int[]{5, 6, 5});
        assertEquals(result, resultForce);
    }

    @Test
    public void testSumSubarrayMinsRandom() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int[] data = new int[20];
            for (int j = 0; j < 20; j++) {
                data[j] = random.nextInt(6) + 1;
            }
            int resultForce = new SumSubarrayMins().sumSubarrayMinsForce(data);
            int result = new SumSubarrayMins().sumSubarrayMins(data);
            if (resultForce != result) {
                System.out.println(Arrays.toString(data));
            }
        }

    }


}