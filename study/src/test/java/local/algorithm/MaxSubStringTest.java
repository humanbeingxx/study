package local.algorithm;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/6 下午3:24
 **/
public class MaxSubStringTest {

    @Test
    public void testMax1() {
        String result = MaxSubString.max("abcabc");
        Assert.assertEquals(result, "abc");
    }

    @Test
    public void testMax2() {
        String result = MaxSubString.max("aaaa");
        Assert.assertEquals(result, "aaa");
    }

    @Test
    public void testMax3() {
        String result = MaxSubString.max("abc");
        Assert.assertEquals(result, "");
    }

    @Test
    public void testMax4() {
        String result = MaxSubString.max("aaccc");
        Assert.assertEquals(result, "cc");
    }

    @Test
    public void testMax5() {
        String result = MaxSubString.max("");
        Assert.assertEquals(result, "");
    }
}