package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-01-23
 **/
public class PalindromePartitionTest {

    @Test
    public void testPartition1() {
        List<List<String>> result = new PalindromePartition().partition("aab");
        result.forEach(System.out::println);
    }

    @Test
    public void testPartition2() {
        List<List<String>> result = new PalindromePartition().partition("aaaaaaaaaabbbbbbbbbb");
        result.forEach(System.out::println);
    }
}