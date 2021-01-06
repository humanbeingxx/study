package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/22 17:18
 */
public class CountBinarySubstringsTest {

    @Test
    public void testCountBinarySubstrings() {
        int result = new CountBinarySubstrings().countBinarySubstrings("10101");
        assertEquals(result, 4);

        result = new CountBinarySubstrings().countBinarySubstrings("00110011");
        assertEquals(result, 6);

        result = new CountBinarySubstrings().countBinarySubstrings("111");
        assertEquals(result, 0);

        result = new CountBinarySubstrings().countBinarySubstrings("00100");
        assertEquals(result, 2);
    }

    @Test
    public void testCountBinarySubstrings2() {
        int result = new CountBinarySubstrings().countBinarySubstrings("00100");
        assertEquals(result, 2);
    }
}