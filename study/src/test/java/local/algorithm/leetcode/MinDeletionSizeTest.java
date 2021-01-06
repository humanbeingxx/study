package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/21 22:04
 */
public class MinDeletionSizeTest {

    @Test
    public void testMinDeletionSize() {
        int result = new MinDeletionSize().minDeletionSize(new String[]{"cba", "daf", "ghi"});
        assertEquals(result, 1);

        result = new MinDeletionSize().minDeletionSize(new String[]{"zyx", "wvu", "tsr"});
        assertEquals(result, 3);

        result = new MinDeletionSize().minDeletionSize(new String[]{"a", "b"});
        assertEquals(result, 0);
    }

}