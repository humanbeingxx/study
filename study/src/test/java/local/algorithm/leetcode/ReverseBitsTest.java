package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class ReverseBitsTest {

    @Test
    public void testReverseBits() {
        int result = new ReverseBits().reverseBits(0b00000010100101000001111010011100);
        assertEquals(result, 0b00111001011110000010100101000000);
    }
}