package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConstructKPalindromeStringsTest {

    @Test
    public void testCanConstruct() {
        boolean result = new ConstructKPalindromeStrings().canConstruct("annabelle", 2);
        assertTrue(result);
    }
}