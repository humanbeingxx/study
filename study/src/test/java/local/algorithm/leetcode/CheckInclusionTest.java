package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckInclusionTest {

    @Test
    public void testCheckInclusion1() {
        boolean result = new CheckInclusion().checkInclusion("ab", "eidbaooo");
        assertTrue(result);
    }

    @Test
    public void testCheckInclusion2() {
        boolean result = new CheckInclusion().checkInclusion("ab", "eidboaoo");
        assertFalse(result);
    }
}