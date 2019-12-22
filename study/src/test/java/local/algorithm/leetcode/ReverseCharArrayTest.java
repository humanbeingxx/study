package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/22 15:41
 */
public class ReverseCharArrayTest {

    @Test
    public void testReverseString1() {
        char[] s = {};
        new ReverseCharArray().reverseString(s);
        assertEquals(s, new char[]{});
    }

    @Test
    public void testReverseString2() {
        char[] s = {'a'};
        new ReverseCharArray().reverseString(s);
        assertEquals(s, new char[]{'a'});
    }

    @Test
    public void testReverseString3() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        new ReverseCharArray().reverseString(s);
        assertEquals(s, new char[]{'o', 'l', 'l', 'e', 'h'});
    }

    @Test
    public void testReverseString4() {
        char[] s = {'h', 'e', 'l', 'o'};
        new ReverseCharArray().reverseString(s);
        assertEquals(s, new char[]{'o', 'l', 'e', 'h'});
        System.out.println(Integer.MAX_VALUE);
    }
}