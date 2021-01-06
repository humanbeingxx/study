package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-31
 **/
public class SmallestRepunitDivByKTest {

    @Test
    public void testSmallestRepunitDivByK() {
        int result = new SmallestRepunitDivByK().smallestRepunitDivByK(3);
        assertEquals(result, 3);

        result = new SmallestRepunitDivByK().smallestRepunitDivByK(2);
        assertEquals(result, -1);

        result = new SmallestRepunitDivByK().smallestRepunitDivByK(17);
        assertEquals(result, 16);
    }
}