package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class NextGreaterElementITest {

    @Test
    public void testNextGreaterElement1() {
        int[] result = new NextGreaterElementI().nextGreaterElement(
                new int[]{4, 1, 2},
                new int[]{1, 3, 4, 2}
        );
        assertEquals(result, new int[]{-1, 3, -1});
    }

    @Test
    public void testNextGreaterElement2() {
        int[] result = new NextGreaterElementI().nextGreaterElement(
                new int[]{2, 4},
                new int[]{1, 2, 3, 4}
        );
        assertEquals(result, new int[]{3, -1});
    }
}