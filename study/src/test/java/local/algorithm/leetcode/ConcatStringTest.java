package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-17
 **/
public class ConcatStringTest {

    @Test
    public void testCountCharacters1() {
        int result = new ConcatString().countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr");
        Assert.assertEquals(result, 10);
    }

    @Test
    public void testCountCharacters2() {
        int result = new ConcatString().countCharacters(new String[]{"cat","bt","hat","tree"}, "atach");
        Assert.assertEquals(result, 6);
    }

    @Test
    public void testCountCharacters3() {
        int result = new ConcatString().countCharacters(new String[]{"cat","bt","hat","tree"}, "aaa");
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testCountCharacters4() {
        int result = new ConcatString().countCharacters(new String[]{}, "atach");
        Assert.assertEquals(result, 0);
    }
}