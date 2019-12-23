package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class MajorityElementTest {

    @Test
    public void testMajorityElement() {
        int result = new MajorityElement().majorityElement(new int[]{3, 2, 3});
        assertEquals(result, 3);

        result = new MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        assertEquals(result, 2);

        result = new MajorityElement().majorityElement(new int[]{6,5,5});
        assertEquals(result, 5);
    }
}