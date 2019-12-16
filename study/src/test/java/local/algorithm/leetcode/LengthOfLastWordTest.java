package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-16
 **/
public class LengthOfLastWordTest {

    @Test
    public void testLengthOfLastWord1() {
        int len = new LengthOfLastWord().lengthOfLastWord("Hello World");
        Assert.assertEquals(len, 5);
    }

    @Test
    public void testLengthOfLastWord2() {
        int len = new LengthOfLastWord().lengthOfLastWord("Hello World  ");
        Assert.assertEquals(len, 5);
    }

    @Test
    public void testLengthOfLastWord3() {
        int len = new LengthOfLastWord().lengthOfLastWord("Hello");
        Assert.assertEquals(len, 5);
    }

    @Test
    public void testLengthOfLastWord4() {
        int len = new LengthOfLastWord().lengthOfLastWord("Hello ");
        Assert.assertEquals(len, 5);
    }

    @Test
    public void testLengthOfLastWord5() {
        int len = new LengthOfLastWord().lengthOfLastWord("");
        Assert.assertEquals(len, 0);
    }

    @Test
    public void testLengthOfLastWord6() {
        int len = new LengthOfLastWord().lengthOfLastWord("  ");
        Assert.assertEquals(len, 0);
    }
}