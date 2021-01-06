package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-31
 **/
public class SubarrayBitwiseORsTest {

    @Test
    public void testSubarrayBitwiseORs() {
        int result = new SubarrayBitwiseORs().subarrayBitwiseORs(new int[]{1});
        assertEquals(result, 1);

        result = new SubarrayBitwiseORs().subarrayBitwiseORs(new int[]{1, 1, 2});
        assertEquals(result, 3);

        result = new SubarrayBitwiseORs().subarrayBitwiseORs(new int[]{1, 2, 4});
        assertEquals(result, 6);
    }
}