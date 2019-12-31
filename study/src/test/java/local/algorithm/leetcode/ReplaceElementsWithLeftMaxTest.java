package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-31
 **/
public class ReplaceElementsWithLeftMaxTest {

    @Test
    public void testReplaceElements() {
        int[] result = new ReplaceElementsWithLeftMax().replaceElements(new int[]{17, 18, 5, 4, 6, 1});
        assertEquals(result, new int[]{18, 6, 6, 6, 1, -1});
    }
}