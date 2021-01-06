package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-31
 **/
public class SingleNumberTest {

    @Test
    public void testSingleNumber() {
        int result = new SingleNumber().singleNumber(new int[]{1, 2, 1, 2, 5});
        assertEquals(result, 5);
    }
}