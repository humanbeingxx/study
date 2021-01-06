package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/22 23:47
 */
public class MultiplyTest {

    @Test
    public void testMultiply1() {
        int result = new Multiply().multiply(2, 4);
        assertEquals(result, 8);
    }

    @Test
    public void testMultiply2() {
        int result = new Multiply().multiply(-2, 4);
        assertEquals(result, -8);
    }

    @Test
    public void testMultiply3() {
        int result = new Multiply().multiply(2, -4);
        assertEquals(result, -8);
    }
}