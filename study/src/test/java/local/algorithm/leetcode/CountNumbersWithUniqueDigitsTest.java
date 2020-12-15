package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/8 19:41
 */
public class CountNumbersWithUniqueDigitsTest {

    @Test
    public void testCountNumbersWithUniqueDigits() {
        int result = new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(2);
        assertEquals(result, 91);

        result = new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(3);
        assertEquals(result, 739);
    }
}