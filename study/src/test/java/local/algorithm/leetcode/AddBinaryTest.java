package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 13:31
 */
public class AddBinaryTest {

    @Test
    public void testAddBinary() {
        String result = new AddBinary().addBinary("111", "0");
        assertEquals(result, "111");

        result = new AddBinary().addBinary("111", "1");
        assertEquals(result, "1000");

        result = new AddBinary().addBinary("1010", "1011");
        assertEquals(result, "10101");
    }
}