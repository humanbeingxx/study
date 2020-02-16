package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-16
 **/
public class CheckValidStringTest {

    @Test
    public void testCheckValidString1() {
        boolean result = new CheckValidString().checkValidString("*()(())*()(()()((()(()()*)(*(())((((((((()*)(()(*)");
        assertFalse(result);
    }
    @Test
    public void testCheckValidString2() {
        boolean result = new CheckValidString().checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*");
        assertFalse(result);
    }
}