package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

public class LargeGroupPositions20210105Test {

    @Test
    public void testLargeGroupPositions1() {
        List<List<Integer>> result = new LargeGroupPositions20210105().largeGroupPositions("abbxxxxzzy");
        System.out.println(result);
    }

    @Test
    public void testLargeGroupPositions2() {
        List<List<Integer>> result = new LargeGroupPositions20210105().largeGroupPositions("abcdddeeeeaabbbcd");
        System.out.println(result);
    }

    @Test
    public void testLargeGroupPositions3() {
        List<List<Integer>> result = new LargeGroupPositions20210105().largeGroupPositions("a");
        System.out.println(result);
    }
}