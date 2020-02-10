package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-10
 **/
public class MinSetSizeTest {

    @Test
    public void testMinSetSize() {
        int result = new MinSetSize().minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7});
        assertEquals(result, 2);
    }
}