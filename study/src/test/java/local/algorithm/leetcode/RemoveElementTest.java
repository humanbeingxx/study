package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/22 16:24
 */
public class RemoveElementTest {

    @Test
    public void testRemoveElement1() {
        int[] data = {1, 1, 1, 1};
        int result = new RemoveElement().removeElement(data, 1);
        assertEquals(result, 0);

        result = new RemoveElement().removeElement(data, 2);
        assertEquals(result, 4);
    }

    @Test
    public void testRemoveElement2() {
        int[] data = {1, 2, 2, 1};
        int result = new RemoveElement().removeElement(data, 1);
        assertEquals(result, 2);
        assertEquals(data, new int[]{2, 2, 1, 1});

        data = new int[]{1, 2, 2, 1};
        result = new RemoveElement().removeElement(data, 2);
        assertEquals(result, 2);
        assertEquals(data, new int[]{1, 1, 2, 2});
    }

    @Test
    public void testRemoveElement3() {
        int[] data = {0, 1, 2, 2, 3, 0, 4, 2};
        int result = new RemoveElement().removeElement(data, 2);
        assertEquals(result, 5);
        assertEquals(data, new int[]{0, 1, 4, 0, 3, 2, 2, 2});
    }
}