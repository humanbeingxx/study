package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DecompressStringTest {

    @Test
    public void testDecompress1() {
        String result = new DecompressString().decompress("");
        assertEquals(result, "");
    }

    @Test
    public void testDecompress2() {
        String result = new DecompressString().decompress("A3B");
        assertEquals(result, "AAAB");
    }

    @Test
    public void testDecompress3() {
        String result = new DecompressString().decompress("((AB)2C)2D");
        assertEquals(result, "ABABCABABCD");
    }

    @Test
    public void testDecompress4() {
        String result = new DecompressString().decompress("(AB)2C");
        assertEquals(result, "ABABC");
    }
}