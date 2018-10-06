package local.algorithm;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/6 下午2:10
 **/
public class TakeNFromMEZTest {

    @Test
    public void testTakeN() {
        List<char[]> result = TakeNFromMEZ.takeN(Lists.newArrayList('a', 'b', 'c', 'd'), 2);
        Assert.assertEquals(result.size(), 16);
    }

    @Test
    public void testTakeN2() {
        List<char[]> result = TakeNFromMEZ.takeN(Lists.newArrayList('a'), 2);
        Assert.assertEquals(result.size(), 0);
    }


    @Test
    public void testTakeN3() {
        List<char[]> result = TakeNFromMEZ.takeN(Lists.newArrayList('a', 'b'), 2);
        Assert.assertEquals(result.size(), 4);
    }

    @Test
    public void testTakeN4() {
        List<char[]> result = TakeNFromMEZ.takeN(Lists.newArrayList('a', 'b'), 1);
        Assert.assertEquals(result.size(), 2);
    }
}