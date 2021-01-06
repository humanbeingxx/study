package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-19
 **/
public class ReverseStrKTest {

    @Test
    public void testCopy1() {
        String str = "abcedfg";
        char[] chars = new char[7];
        new ReverseStrK().copy(str, 1, 5, chars, 2);
        for (char aChar : chars) {
            System.out.print(aChar);
        }
    }

    @Test
    public void testCopy2() {
        String str = "abcedfg";
        char[] chars = new char[7];
        new ReverseStrK().copy(str, 4, 1, chars, 2);
        for (char aChar : chars) {
            System.out.print(aChar);
        }
    }

    @Test
    public void testReverse1() {
        char[] chars = new char[7];
        new ReverseStrK().reverse("abcdefg".substring(0, 6), chars, 0, 3);
        for (char aChar : chars) {
            System.out.print(aChar);
        }
    }

    @Test
    public void testReverse2() {
        char[] chars = new char[7];
        new ReverseStrK().reverse("abcdefg".substring(0, 4), chars, 0, 3);
        for (char aChar : chars) {
            System.out.print(aChar);
        }
    }

    @Test
    public void testReverse3() {
        char[] chars = new char[7];
        new ReverseStrK().reverse("abcdefg".substring(0, 3), chars, 0, 3);
        for (char aChar : chars) {
            System.out.print(aChar);
        }
    }

    @Test
    public void testReverse4() {
        char[] chars = new char[7];
        new ReverseStrK().reverse("abcdefg".substring(0, 2), chars, 0, 3);
        for (char aChar : chars) {
            System.out.print(aChar);
        }
    }

    @Test
    public void testReverseStr1() {
        String result = new ReverseStrK().reverseStr("abcdefg", 2);
        assertEquals(result, "bacdfeg");
    }

    @Test
    public void testReverseStr2() {
        String result = new ReverseStrK().reverseStr("abcdef12345", 3);
        assertEquals(result, "cbadef32145");
    }

    @Test
    public void testReverseStr3() {
        String result = new ReverseStrK().reverseStr("abcdef123", 3);
        assertEquals(result, "cbadef321");
    }

    @Test
    public void testReverseStr4() {
        String result = new ReverseStrK().reverseStr("abcdef12", 3);
        assertEquals(result, "cbadef21");
    }

    @Test
    public void testReverseStr5() {
        String result = new ReverseStrK().reverseStr("abcdefg", 8);
        assertEquals(result, "gfedcba");
    }
}