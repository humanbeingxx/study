package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/22 19:42
 */
public class PrintBinTest {

    @Test
    public void testPrintBin1() {
        String result = new PrintBin().printBin(0.625);
        assertEquals(result, "0.101");
    }

    @Test
    public void testPrintBin2() {
        String result = new PrintBin().printBin(0.1);
        assertEquals(result, "ERROR");
    }

    @Test
    public void testPrintBin3() {
        String result = new PrintBin().printBin(0.5);
        assertEquals(result, "0.1");
    }
}