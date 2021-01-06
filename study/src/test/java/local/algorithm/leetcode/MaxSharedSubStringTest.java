package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-13
 **/
public class MaxSharedSubStringTest {

    @Test
    public void testSearchSubString() {
        String result = new MaxSharedSubString().searchSubString("adcfgeheightkdeffcser", "theightyye");
        assertEquals(result, "height");
    }
}