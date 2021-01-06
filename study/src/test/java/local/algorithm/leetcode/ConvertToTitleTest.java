package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/1 14:16
 */
public class ConvertToTitleTest {

    @Test
    public void testConvertToTitle() {
        String result = new ConvertToTitle().convertToTitle(701);
        assertEquals(result, "ZY");

        result = new ConvertToTitle().convertToTitle(26);
        assertEquals(result, "Z");

        result = new ConvertToTitle().convertToTitle(27);
        assertEquals(result, "AA");

        result = new ConvertToTitle().convertToTitle(28);
        assertEquals(result, "AB");

    }
}