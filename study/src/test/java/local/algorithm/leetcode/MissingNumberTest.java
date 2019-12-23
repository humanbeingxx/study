package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class MissingNumberTest {

    @Test
    public void testMissingNumber() {
        int result = new MissingNumber().missingNumber(new int[]{0, 1, 2, 3, 4, 6});
        assertEquals(result, 5);
        result = new MissingNumber().missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
        assertEquals(result, 8);
    }
}