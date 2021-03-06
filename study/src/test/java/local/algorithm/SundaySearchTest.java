package local.algorithm;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author xiaoshuang.cui
 * @date 2018/9/2 下午5:50
 **/
public class SundaySearchTest {

    @Test
    public void testPrepareShift() {
        int[] shift = SundaySearch.prepareShift("search");
        System.out.println(shift['s' - 'a']);
        System.out.println(shift['e' - 'a']);
        System.out.println(shift['a' - 'a']);
        System.out.println(shift['r' - 'a']);
        System.out.println(shift['c' - 'a']);
        System.out.println(shift['h' - 'a']);
    }

    @Test
    public void testSearch() {
        assertEquals(SundaySearch.search("substring searching", "search"), 10);
        assertEquals(SundaySearch.search("search substring searching", "search"), 0);
        assertEquals(SundaySearch.search("substring searching", "searchx"), -1);
        assertEquals(SundaySearch.search("substring searching", ""), -1);
        assertEquals(SundaySearch.search("", "searchx"), -1);
        assertEquals(SundaySearch.search("", ""), -1);
    }

    @Test
    public void testOne() {
        int result = SundaySearch.search("aacc", "acc");
        Assert.assertEquals(result, 1);
    }
}