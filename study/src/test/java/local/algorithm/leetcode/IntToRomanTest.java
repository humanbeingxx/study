package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-13
 **/
public class IntToRomanTest {

    @Test
    public void testIntToRoman1() {
        String result = new IntToRoman().intToRoman(1994);
        assertEquals(result, "MCMXCIV");
    }
}