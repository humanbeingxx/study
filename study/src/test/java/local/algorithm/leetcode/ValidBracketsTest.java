package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-18
 **/
public class ValidBracketsTest {

    @Test
    public void testIsValid() {
        boolean result = new ValidBrackets().isValid("");
        Assert.assertTrue(result);

        result = new ValidBrackets().isValid("((()))");
        Assert.assertTrue(result);

        result = new ValidBrackets().isValid("[{[{}]}]");
        Assert.assertTrue(result);

        result = new ValidBrackets().isValid("()[]{}");
        Assert.assertTrue(result);

        result = new ValidBrackets().isValid("(]");
        Assert.assertFalse(result);

        result = new ValidBrackets().isValid("([)]");
        Assert.assertFalse(result);

        result = new ValidBrackets().isValid("(");
        Assert.assertFalse(result);
    }
}