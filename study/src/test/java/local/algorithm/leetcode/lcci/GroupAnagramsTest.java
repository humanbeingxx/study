package local.algorithm.leetcode.lcci;

import local.algorithm.leetcode.GroupAnagrams;
import org.testng.annotations.Test;

import java.util.List;

public class GroupAnagramsTest {

    @Test
    public void testGroupAnagrams() {
        List<List<String>> result = new GroupAnagrams().groupAnagrams(new String[]{
                "eat", "eat", "tea", "tan", "ate", "nat", "bat"
        });
        result.forEach(System.out::println);
    }
}