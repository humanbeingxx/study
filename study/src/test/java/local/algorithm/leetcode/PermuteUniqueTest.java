package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

public class PermuteUniqueTest {

    @Test
    public void testPermuteUnique() {
        List<List<Integer>> result = new PermuteUnique().permuteUnique(new int[]{1, 2, 1, 2});
        result.forEach(System.out::println);
    }
}