package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

public class RepeatedDNASequences2Test {

    @Test
    public void testFindRepeatedDnaSequences1() {
        List<String> result = new RepeatedDNASequences2().findRepeatedDnaSequences("AAAAAAAAAAA");
        System.out.println(result);
    }

    @Test
    public void testFindRepeatedDnaSequences2() {
        List<String> result = new RepeatedDNASequences2().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(result);
    }
}