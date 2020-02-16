package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-16
 **/
public class GroupAnagramsTest {

    @Test
    public void testGroupAnagrams() {
        List<List<String>> result = new GroupAnagrams().groupAnagrams(new String[]{
                "eat","eat","tea","tan","ate","nat","bat"
        });
        result.forEach(System.out::println);
    }
}