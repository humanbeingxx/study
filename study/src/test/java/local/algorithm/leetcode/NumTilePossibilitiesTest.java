package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NumTilePossibilitiesTest {

    @Test
    public void testNumTilePossibilities1() {
        int result = new NumTilePossibilities().numTilePossibilities("AAB");
        assertEquals(result, 8);
    }

    @Test
    public void testNumTilePossibilities2() {
        int result = new NumTilePossibilities().numTilePossibilities("AAABBC");
        assertEquals(result, 188);
    }
}