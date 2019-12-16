package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-16
 **/
public class FirstUniqCharTest {

    @Test
    public void testFirstUniqChar1() {
        int index = new FirstUniqChar().firstUniqChar("leetcode");
        Assert.assertEquals(index, 0);
    }

    @Test
    public void testFirstUniqChar2() {
        int index = new FirstUniqChar().firstUniqChar("loveleetcode");
        Assert.assertEquals(index, 2);
    }

    @Test
    public void testFirstUniqChar3() {
        int index = new FirstUniqChar().firstUniqChar("l");
        Assert.assertEquals(index, 0);
    }

    @Test
    public void testFirstUniqChar4() {
        int index = new FirstUniqChar().firstUniqChar("llll");
        Assert.assertEquals(index, -1);
    }

    @Test
    public void testFirstUniqChar5() {
        int index = new FirstUniqChar().firstUniqChar("");
        Assert.assertEquals(index, -1);
    }
}