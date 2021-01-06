package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class ConvertToBase7Test {

    @Test
    public void testConvertToBase7() {
        String result = new ConvertToBase7().convertToBase7(100);
        assertEquals(result, "202");

        result = new ConvertToBase7().convertToBase7(-100);
        assertEquals(result, "-202");
    }
}