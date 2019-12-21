package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/21 18:38
 */
public class RotatedDigitsTest {

    @Test
    public void testRotatedDigits10() {
        int result = new RotatedDigits().rotatedDigits10(1, 1);
        assertEquals(result, 4);

        result = new RotatedDigits().rotatedDigits10(1, 2);
        assertEquals(result, 40);

        result = new RotatedDigits().rotatedDigits10(1, 3);
        assertEquals(result, 316);

        result = new RotatedDigits().rotatedDigits10(2, 3);
        assertEquals(result, 633);

        result = new RotatedDigits().rotatedDigits10(3, 3);
        assertEquals(result, 975);

        result = new RotatedDigits().rotatedDigits10(5, 3);
        assertEquals(result, 976);

        result = new RotatedDigits().rotatedDigits10(6, 3);
        assertEquals(result, 1319);

        result = new RotatedDigits().rotatedDigits10(7, 3);
        assertEquals(result, 1661);

        result = new RotatedDigits().rotatedDigits10(8, 3);
        assertEquals(result, 1661);

        result = new RotatedDigits().rotatedDigits10(9, 3);
        assertEquals(result, 1978);

        result = new RotatedDigits().rotatedDigits10(1, 4);
        assertEquals(result, 2320);
    }

    @Test
    public void testRotatedDigits() {
        int result = new RotatedDigits().rotatedDigits(223);
        assertEquals(result, 97);

        result = new RotatedDigits().rotatedDigits(1234);
        assertEquals(result, 417);
    }
}