package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HIndexIITest {

    @Test
    public void testHIndex() {
        int result = new HIndexII().hIndex(new int[]{1, 1, 1, 1, 1});
        assertEquals(result, 1);
    }

    @Test
    public void testHIndex2() {
        int result = new HIndexII().hIndex(new int[]{0});
        assertEquals(result, 0);
    }
}