package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-17
 **/
public class NumberOfLinesTest {

    @Test
    public void testNumberOfLines1() {
        int[] widths = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int[] result = new NumberOfLines().numberOfLines(widths, "abcdefghijklmnopqrstuvwxyz");
        Assert.assertEquals(result, new int[]{3, 60});
    }

    @Test
    public void testNumberOfLines2() {
        int[] widths = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int[] result = new NumberOfLines().numberOfLines(widths, "bbbcccdddaaa");
        Assert.assertEquals(result, new int[]{2, 4});
    }
}