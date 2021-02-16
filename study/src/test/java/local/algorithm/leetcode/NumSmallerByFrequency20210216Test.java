package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class NumSmallerByFrequency20210216Test {

    @Test
    public void testFirstBigger1() {
        int[] data = {1, 2, 3, 4, 5, 6};
        int result = new NumSmallerByFrequency20210216().firstBigger(data, 1);
        assertEquals(result, 1);
    }

    @Test
    public void testFirstBigger2() {
        int[] data = {1, 2, 3, 4, 5, 6};
        int result = new NumSmallerByFrequency20210216().firstBigger(data, 6);
        assertEquals(result, 6);
    }

    @Test
    public void testFirstBigger3() {
        int[] data = {1, 2, 3, 3, 5, 6};
        int result = new NumSmallerByFrequency20210216().firstBigger(data, 2);
        assertEquals(result, 2);
    }

    @Test
    public void testFirstBigger4() {
        int[] data = {1, 2, 3, 3, 5, 6};
        int result = new NumSmallerByFrequency20210216().firstBigger(data, 7);
        assertEquals(result, 6);
    }

    @Test
    public void testFirstBigger5() {
        int[] data = {1, 2, 3, 4};
        int result = new NumSmallerByFrequency20210216().firstBigger(data, 2);
        assertEquals(result, 2);
    }

    @Test
    public void testNumSmallerByFrequency() {
        String[] queries = {"bba", "abaaaaaa", "aaaaaa", "bbabbabaab", "aba", "aa", "baab", "bbbbbb", "aab", "bbabbaabb"};
        String[] words = {"aaabbb", "aab", "babbab", "babbbb", "b", "bbbbbbbbab", "a", "bbbbbbbbbb", "baaabbaab", "aa"};
        int[] result = new NumSmallerByFrequency20210216().numSmallerByFrequency(queries, words);
        System.out.println(Arrays.toString(result));
    }
}