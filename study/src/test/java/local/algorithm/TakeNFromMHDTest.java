package local.algorithm;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/6 下午2:38
 **/
public class TakeNFromMHDTest {

    @Test
    public void testTakeN0() {
        List<char[]> result = TakeNFromMHD.takeN(new char[]{'a', 'b', 'c', 'd'}, 0);
        Assert.assertEquals(result.size(), 0);
    }
    @Test
    public void testTakeN1() {
        List<char[]> result = TakeNFromMHD.takeN(new char[]{'a', 'b', 'c', 'd'}, 1);
        Assert.assertEquals(result.size(), 4);
    }
    @Test
    public void testTakeN2() {
        List<char[]> result = TakeNFromMHD.takeN(new char[]{'a', 'b', 'c', 'd'}, 2);
        print(result);
        Assert.assertEquals(result.size(), 6);
    }
    @Test
    public void testTakeN3() {
        List<char[]> result = TakeNFromMHD.takeN(new char[]{'a', 'b', 'c', 'd'}, 3);
        Assert.assertEquals(result.size(), 4);
    }
    @Test
    public void testTakeN4() {
        List<char[]> result = TakeNFromMHD.takeN(new char[]{'a', 'b', 'c', 'd'}, 4);
        Assert.assertEquals(result.size(), 1);
    }

    private void print(List<char[]> result) {
        for (char[] chars : result) {
            System.out.println(Arrays.toString(chars));
        }
    }
}