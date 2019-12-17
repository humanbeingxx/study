package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-17
 **/
public class CalBaseballPointsTest {

    @Test
    public void testCalPoints1() {
        int result = new CalBaseballPoints().calPoints(new String[]{"5", "2", "C", "D", "+"});
        Assert.assertEquals(result, 30);
    }

    @Test
    public void testCalPoints2() {
        int result = new CalBaseballPoints().calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
        Assert.assertEquals(result, 27);
    }
}