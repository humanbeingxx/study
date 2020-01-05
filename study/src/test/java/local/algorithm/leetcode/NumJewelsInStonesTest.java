package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/1 21:44
 */
public class NumJewelsInStonesTest {

    @Test
    public void testNumJewelsInStones() {
        int result = new NumJewelsInStones().numJewelsInStones("abA", "aAAbbbb");
        assertEquals(result, 7);

        result = new NumJewelsInStones().numJewelsInStones("z", "ZZ");
        assertEquals(result, 0);
    }
}