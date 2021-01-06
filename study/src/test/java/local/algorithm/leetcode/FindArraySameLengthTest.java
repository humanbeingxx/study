package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FindArraySameLengthTest {

    @Test
    public void testFindLength() {
        int result = new FindArraySameLength().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7});
        assertEquals(result, 3);
    }
}