package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CountSortedVowelStringsTest {

    @Test
    public void testCountVowelStrings1() {
        int result = new CountSortedVowelStrings().countVowelStrings(1);
        assertEquals(result, 5);
    }

    @Test
    public void testCountVowelStrings2() {
        int result = new CountSortedVowelStrings().countVowelStrings(2);
        assertEquals(result, 15);
    }

    @Test
    public void testCountVowelStrings33() {
        int result = new CountSortedVowelStrings().countVowelStrings(33);
        assertEquals(result, 66045);
    }
}