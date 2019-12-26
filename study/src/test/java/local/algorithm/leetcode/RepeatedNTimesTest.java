package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-26
 **/
public class RepeatedNTimesTest {

    @Test
    public void testRepeatedNTimes() {
        int result = new RepeatedNTimes().repeatedNTimes(new int[]{1, 2, 3, 3});
        assertEquals(result, 3);

        result = new RepeatedNTimes().repeatedNTimes(new int[]{9, 5, 6, 9});
        assertEquals(result, 9);
    }
}