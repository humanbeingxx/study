package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

public class RepeatedDNASequencesTest {

    @Test
    public void testFindRepeatedDnaSequences1() {
        List<String> result = new RepeatedDNASequences().findRepeatedDnaSequences("AAAAAAAAAAA");
        System.out.println(result);
    }

    @Test
    public void testFindRepeatedDnaSequences2() {
        List<String> result = new RepeatedDNASequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(result);
    }
}