package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/22 21:31
 */
public class RomanToIntTest {

    RomanToInt transformer = new RomanToInt();

    @Test
    public void testRomanToInt1() {
        int result = transformer.romanToInt("III");
        assertEquals(result, 3);
    }


    @Test
    public void testRomanToInt2() {
        int result = transformer.romanToInt("IV");
        assertEquals(result, 4);
    }

    @Test
    public void testRomanToInt3() {
        int result = transformer.romanToInt("IX");
        assertEquals(result, 9);
    }

    @Test
    public void testRomanToInt4() {
        int result = transformer.romanToInt("LVIII");
        assertEquals(result, 58);
    }

    @Test
    public void testRomanToInt5() {
        int result = transformer.romanToInt("MCMXCIV");
        assertEquals(result, 1994);
    }
}