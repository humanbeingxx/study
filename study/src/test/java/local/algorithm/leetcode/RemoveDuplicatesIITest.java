package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-10
 **/
public class RemoveDuplicatesIITest {

    @Test
    public void testRemoveDuplicates1() {
        int[] data = {1, 1, 1, 1, 2, 2, 3};
        int result = new RemoveDuplicatesII().removeDuplicates(data);
        assertEquals(result, 5);
        assertEquals(data, new int[]{1, 1, 2, 2, 3, 2, 3});
    }

    @Test
    public void testRemoveDuplicates2() {
        int[] data = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int result = new RemoveDuplicatesII().removeDuplicates(data);
        assertEquals(result, 7);
        assertEquals(data, new int[]{0, 0, 1, 1, 2, 3, 3, 3, 3});
    }

    @Test
    public void testRemoveDuplicates3() {
        int[] data = {0, 0, 0, 0, 0, 0};
        int result = new RemoveDuplicatesII().removeDuplicates(data);
        assertEquals(result, 2);
        assertEquals(data, new int[]{0, 0, 0, 0, 0, 0});
    }
}