package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/26 0:28
 */
public class ReverseVowelsTest {

    @Test
    public void testReverseVowels() {
        String result = new ReverseVowels().reverseVowels("");
        assertEquals(result, "");

        result = new ReverseVowels().reverseVowels("hello");
        assertEquals(result, "holle");

        result = new ReverseVowels().reverseVowels("leetcode");
        assertEquals(result, "leotcede");

        result = new ReverseVowels().reverseVowels("llllll");
        assertEquals(result, "llllll");
    }
}