package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RemoveDuplicates2Test {

    @Test
    public void testRemoveDuplicates() {
        int result = new RemoveDuplicates2().removeDuplicates(new int[]{1, 1, 2, 2, 2});
        assertEquals(result, 2);
    }
}