package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 20:28
 */
public class BitwiseComplementTest {

    @Test
    public void testBitwiseComplement() {
        int result = new BitwiseComplement().bitwiseComplement(10);
        assertEquals(result, 5);
    }
}