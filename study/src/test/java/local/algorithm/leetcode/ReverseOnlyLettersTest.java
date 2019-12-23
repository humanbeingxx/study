package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class ReverseOnlyLettersTest {

    @Test
    public void testReverseOnlyLetters1() {
        String result = new ReverseOnlyLetters().reverseOnlyLetters("ab-cd");
        assertEquals(result, "dc-ba");
    }

    @Test
    public void testReverseOnlyLetters2() {
        String result = new ReverseOnlyLetters().reverseOnlyLetters("a-bC-dEf-ghIj");
        assertEquals(result, "j-Ih-gfE-dCba");
    }

    @Test
    public void testReverseOnlyLetters3() {
        String result = new ReverseOnlyLetters().reverseOnlyLetters("ab");
        assertEquals(result, "ba");

        result = new ReverseOnlyLetters().reverseOnlyLetters("a");
        assertEquals(result, "a");

        result = new ReverseOnlyLetters().reverseOnlyLetters("a-");
        assertEquals(result, "a-");

        result = new ReverseOnlyLetters().reverseOnlyLetters("-b");
        assertEquals(result, "-b");

        result = new ReverseOnlyLetters().reverseOnlyLetters("7_28]");
        assertEquals(result, "7_28]");
    }

}