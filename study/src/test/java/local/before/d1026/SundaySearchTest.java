package local.before.d1026;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SundaySearchTest {

    @Test
    public void testSearch() {
        assertEquals(SundaySearch.search("substring searching".toCharArray(), "search".toCharArray()), 10);
        assertEquals(SundaySearch.search("search substring searching".toCharArray(), "search".toCharArray()), 0);
        assertEquals(SundaySearch.search("substring searching".toCharArray(), "searchx".toCharArray()), -1);
        assertEquals(SundaySearch.search("substring searching".toCharArray(), "".toCharArray()), 0);
        assertEquals(SundaySearch.search("".toCharArray(), "searchx".toCharArray()), -1);
        assertEquals(SundaySearch.search("".toCharArray(), "".toCharArray()), -1);
    }

    @Test
    public void testOne() {
        int result = SundaySearch.search("aacc".toCharArray(), "acc".toCharArray());
        Assert.assertEquals(result, 1);
    }
}