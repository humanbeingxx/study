package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MctFromLeafValuesTest {

    @Test
    public void testMctFromLeafValues() {
        int result = new MctFromLeafValues().mctFromLeafValues(new int[]{6, 4, 8, 2, 6, 4});
        assertEquals(result, 156);
    }
}