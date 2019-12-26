package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/26 0:33
 */
public class TitleToNumberTest {

    @Test
    public void testTitleToNumber() {
        int result = new TitleToNumber().titleToNumber("AB");
        assertEquals(result, 28);

        result = new TitleToNumber().titleToNumber("ZY");
        assertEquals(result, 701);
    }
}