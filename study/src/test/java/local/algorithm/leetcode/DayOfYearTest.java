package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-20
 **/
public class DayOfYearTest {

    @Test
    public void testDayOfYear() {
        int result = new DayOfYear().dayOfYear("2019-01-01");
        assertEquals(result, 1);

        result = new DayOfYear().dayOfYear("2019-02-10");
        assertEquals(result, 41);

        result = new DayOfYear().dayOfYear("2003-03-01");
        assertEquals(result, 60);

        result = new DayOfYear().dayOfYear("2004-03-01");
        assertEquals(result, 61);
    }
}