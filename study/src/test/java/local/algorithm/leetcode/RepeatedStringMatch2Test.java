package local.algorithm.leetcode;

import org.testng.annotations.Test;

public class RepeatedStringMatch2Test {

    @Test
    public void testRepeatedStringMatch() {
        System.out.println(new RepeatedStringMatch2().repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println(new RepeatedStringMatch2().repeatedStringMatch("abcd", "cdabcdabe"));
        System.out.println(new RepeatedStringMatch2().repeatedStringMatch("ab", "abab"));

    }
}