package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/26 21:20
 */
public class RemoveDuplicatesTest {

    @Test
    public void testRemoveDuplicates() {
        int result = new RemoveDuplicates().removeDuplicates(new int[]{1, 1, 2});
        assertEquals(result, 2);
    }
}