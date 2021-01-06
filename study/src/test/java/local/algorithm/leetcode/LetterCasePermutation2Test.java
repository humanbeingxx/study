package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

public class LetterCasePermutation2Test {

    @Test
    public void testLetterCasePermutation1() {
        List<String> result = new LetterCasePermutation2().letterCasePermutation("a1b2");
        System.out.println(result);
    }

    @Test
    public void testLetterCasePermutation2() {
        List<String> result = new LetterCasePermutation2().letterCasePermutation("3z4");
        System.out.println(result);
    }
}