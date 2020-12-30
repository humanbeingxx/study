package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LongestAbsoluteFilePathTest {

    @Test
    public void testLengthLongestPath0() {
        int result = new LongestAbsoluteFilePath().lengthLongestPath("");
        assertEquals(result, 0);
    }

    @Test
    public void testLengthLongestPath1() {
        int result = new LongestAbsoluteFilePath().lengthLongestPath("file1.txt\\nfile2.txt\\nlongfile.txt");
        assertEquals(result, 12);
    }

    @Test
    public void testLengthLongestPath2() {
        int result = new LongestAbsoluteFilePath().lengthLongestPath("" +
                "dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext");
        assertEquals(result, 32);
    }

    @Test
    public void testLengthLongestPath3() {
        int result = new LongestAbsoluteFilePath().lengthLongestPath("" +
                "dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext");
        assertEquals(result, 20);
    }
}