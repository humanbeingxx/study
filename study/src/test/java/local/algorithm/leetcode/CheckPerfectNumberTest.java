package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-18
 **/
public class CheckPerfectNumberTest {

    @Test
    public void testCheckPerfectNumber1() {
        CheckPerfectNumber checkPerfectNumber = new CheckPerfectNumber();

        boolean result = checkPerfectNumber.checkPerfectNumber(6);
        Assert.assertTrue(result);

        result = checkPerfectNumber.checkPerfectNumber(28);
        Assert.assertTrue(result);

        result = checkPerfectNumber.checkPerfectNumber(27);
        Assert.assertFalse(result);

        result = checkPerfectNumber.checkPerfectNumber(0);
        Assert.assertFalse(result);
    }
}