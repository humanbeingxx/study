package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/28 21:37
 */
public class AllCheckRecordTest {

    @Test
    public void testCheckRecord() {
        int res = new AllCheckRecord().checkRecord(10000);
        assertEquals(res, 67802379);
    }
}