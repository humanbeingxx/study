package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompressString2Test {

    @Test
    public void testCompress1() {
        char[] chars = {'a', 'a', 'b', 'c', 'c'};
        int result = new CompressString2().compress(chars);
        Assert.assertEquals(result, 5);
        Assert.assertEquals(chars[0], 'a');
        Assert.assertEquals(chars[1], '2');
        Assert.assertEquals(chars[2], 'b');
        Assert.assertEquals(chars[3], 'c');
        Assert.assertEquals(chars[4], '2');
    }

    @Test
    public void testcompress() {
        char[] chars = {'a'};
        int result = new CompressString2().compress(chars);
        Assert.assertEquals(result, 1);
        Assert.assertEquals(chars[0], 'a');

    }

    @Test
    public void testCompress3() {
        char[] chars = {'a', 'b', 'c'};
        int result = new CompressString2().compress(chars);
        Assert.assertEquals(result, 3);
        Assert.assertEquals(chars[0], 'a');
        Assert.assertEquals(chars[1], 'b');
        Assert.assertEquals(chars[2], 'c');
    }

    @Test
    public void testCompress4() {
        char[] chars = {'a', 'a', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'};
        int result = new CompressString2().compress(chars);
        Assert.assertEquals(result, 6);
        Assert.assertEquals(chars[0], 'a');
        Assert.assertEquals(chars[1], '2');
        Assert.assertEquals(chars[2], 'b');
        Assert.assertEquals(chars[3], 'c');
        Assert.assertEquals(chars[4], '1');
        Assert.assertEquals(chars[5], '2');
    }

    @Test
    public void testCompress5() {
        char[] chars = {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'b',
                'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'};
        int result = new CompressString2().compress(chars);
        Assert.assertEquals(result, 7);
        Assert.assertEquals(chars[0], 'a');
        Assert.assertEquals(chars[1], '1');
        Assert.assertEquals(chars[2], '2');
        Assert.assertEquals(chars[3], 'b');
        Assert.assertEquals(chars[4], 'c');
        Assert.assertEquals(chars[5], '1');
        Assert.assertEquals(chars[6], '2');
    }

    @Test
    public void testCompress6() {
        char[] chars = {'a', 'a', 'a', 'b', 'b', 'a', 'a', 'b'};
        int result = new CompressString2().compress(chars);
        Assert.assertEquals(result, 7);
        Assert.assertEquals(chars[0], 'a');
        Assert.assertEquals(chars[1], '3');
        Assert.assertEquals(chars[2], 'b');
        Assert.assertEquals(chars[3], '2');
        Assert.assertEquals(chars[4], 'a');
        Assert.assertEquals(chars[5], '2');
        Assert.assertEquals(chars[6], 'b');
    }

    @Test
    public void testCompress7() {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        int result = new CompressString2().compress(chars);
        Assert.assertEquals(result, 8);
        Assert.assertEquals(chars[0], 'a');
        Assert.assertEquals(chars[1], 'b');
        Assert.assertEquals(chars[2], 'c');
        Assert.assertEquals(chars[3], 'd');
        Assert.assertEquals(chars[4], 'e');
        Assert.assertEquals(chars[5], 'f');
        Assert.assertEquals(chars[6], 'g');
        Assert.assertEquals(chars[7], 'h');
    }
}