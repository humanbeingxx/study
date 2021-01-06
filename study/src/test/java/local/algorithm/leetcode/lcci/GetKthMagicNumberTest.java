package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/23 19:30
 */
public class GetKthMagicNumberTest {

    @Test
    public void testGetKthMagicNumber() {
        int result = new GetKthMagicNumber().getKthMagicNumber(100);
        assertEquals(result, 33075);
    }
}