package local.algorithm;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/9/2 下午4:56
 **/
public class KMPTest {

    @Test
    public void testSearch1() {
        assertEquals(KMP.search("cb", "abcba"), 2);
    }

    @Test
    public void testSearch2() {
        assertEquals(KMP.search("x", "abcdefg"), -1);
    }

    @Test
    public void testSearch3() {
        assertEquals(KMP.search("aa", "aaaa"), 0);
    }

    @Test
    public void testSearch4() {
        assertEquals(KMP.search("cb", "abcba"), 2);
    }

    @Test
    public void testSearch5() {
        assertEquals(KMP.search("ABCDABD", "BBCABCDABABCDABCDABDE"), 13);
    }

    @Test
    public void testSearch6() {
        assertEquals(KMP.search("abcdef","abcdeg, abcdeh, abcdef!这个会匹配2次"), 16);
    }

    @Test
    public void testGetNext() {
        int[] next = KMP.getNext("aabcaaaba");
        System.out.println(Arrays.toString(next));
    }
}