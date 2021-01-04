package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CheckValidAfterSubstitutionsTest {

    @Test
    public void testIsValid1() {
        boolean result = new CheckValidAfterSubstitutions().isValid("abc");
        assertTrue(result);
    }

    @Test
    public void testIsValid2() {
        boolean result = new CheckValidAfterSubstitutions().isValid("aabcbc");
        assertTrue(result);
    }

    @Test
    public void testIsValid3() {
        boolean result = new CheckValidAfterSubstitutions().isValid("abcabcababcc");
        assertTrue(result);
    }

    @Test
    public void testIsValid4() {
        boolean result = new CheckValidAfterSubstitutions().isValid("abccba");
        assertFalse(result);
    }

    @Test
    public void testIsValid5() {
        boolean result = new CheckValidAfterSubstitutions().isValid("cababc");
        assertFalse(result);
    }
}