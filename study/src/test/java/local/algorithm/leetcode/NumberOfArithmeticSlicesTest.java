package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumberOfArithmeticSlicesTest {

    @Test
    public void testNumberOfArithmeticSlices1() {
        int result = new NumberOfArithmeticSlices().numberOfArithmeticSlices(new int[]{1, 2, 3, 4});
        assertEquals(result, 3);
    }

    @Test
    public void testNumberOfArithmeticSlices2() {
        int result = new NumberOfArithmeticSlices().numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5});
        assertEquals(result, 6);
    }

    @Test
    public void testNumberOfArithmeticSlices3() {
        int result = new NumberOfArithmeticSlices().numberOfArithmeticSlices(new int[]{1,1,1,1,1,1,1,1,1});
        assertEquals(result, 28);
    }

}