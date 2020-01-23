package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-23
 **/
public class PalindromeSubStringTest {

    @Test
    public void testCountSubstrings1() {
        int result = new PalindromeSubString().countSubstrings("aaa");
        assertEquals(result, 6);
    }

    @Test
    public void testCountSubstrings2() {
        int result = new PalindromeSubString().countSubstrings("abc");
        assertEquals(result, 3);
    }
    @Test
    public void testCountSubstrings3() {
        int result = new PalindromeSubString().countSubstrings("dnncbwoneinoplypwgbwktmvkoimcooyiwirgbxlcttgteqthcvyoueyftiwgwwxvxvg");
        assertEquals(result, 3);
    }
}