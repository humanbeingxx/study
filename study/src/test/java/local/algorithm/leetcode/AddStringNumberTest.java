package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/16 20:40
 */
public class AddStringNumberTest {

    @Test
    public void testAddStrings1() {
        String result = new AddStringNumber().addStrings("123", "11");
        Assert.assertEquals(result, "134");
    }

    @Test
    public void testAddStrings2() {
        String result = new AddStringNumber().addStrings("1", "1");
        Assert.assertEquals(result, "2");
    }

    @Test
    public void testAddStrings3() {
        String result = new AddStringNumber().addStrings("1", "9");
        Assert.assertEquals(result, "10");
    }

    @Test
    public void testAddStrings4() {
        String result = new AddStringNumber().addStrings("999", "1");
        Assert.assertEquals(result, "1000");
    }

    @Test
    public void testAddStrings5() {
        String result = new AddStringNumber().addStrings("1", "0");
        Assert.assertEquals(result, "1");
    }

    @Test
    public void testAddStrings6() {
        String result = new AddStringNumber().addStrings("0", "0");
        Assert.assertEquals(result, "0");
    }
}