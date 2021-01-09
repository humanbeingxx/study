package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

public class MaxBinaryStringAfterChangeTest {

    @Test
    public void testMaximumBinaryString1() {
        String result = new MaxBinaryStringAfterChange().maximumBinaryString("000110");
        assertEquals(result, "111011");
    }

    @Test
    public void testMaximumBinaryString2() {
        String result = new MaxBinaryStringAfterChange().maximumBinaryString("01");
        assertEquals(result, "01");
    }

    @Test
    public void testMaximumBinaryString3() {
        String result = new MaxBinaryStringAfterChange().maximumBinaryString("1110100000000101110000011001000");
        assertEquals(result, "1111111111111111111111011111111");
    }

    @Test
    public void testRandom() {
        Random random = new Random();
        MaxBinaryStringAfterChange func = new MaxBinaryStringAfterChange();
        for (int i = 0; i < 10; i++) {
            String data = Integer.toBinaryString(random.nextInt());
            String result = func.maximumBinaryString(data);
            System.out.println(data + " -> " + result);
        }
    }
}