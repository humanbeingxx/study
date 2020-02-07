package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-07
 **/
public class CompareVersionTest {

    @Test
    public void testCompareVersion1() {
        int result = new CompareVersion().compareVersion("7.5.2.4", "7.5.3");
        assertEquals(result, -1);
    }

    @Test
    public void testCompareVersion2() {
        int result = new CompareVersion().compareVersion("1.0", "1.0.0");
        assertEquals(result, 0);
    }

    @Test
    public void testCompareVersion3() {
        int result = new CompareVersion().compareVersion("1.01", "1.00001");
        assertEquals(result, 0);
    }

    @Test
    public void testCompareVersion4() {
        int result = new CompareVersion().compareVersion("1.0.1", "1");
        assertEquals(result, 1);
    }
}