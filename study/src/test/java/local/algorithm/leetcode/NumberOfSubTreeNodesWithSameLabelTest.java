package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

public class NumberOfSubTreeNodesWithSameLabelTest {

    @Test
    public void testCountSubTrees1() {
        int[] result = new NumberOfSubTreeNodesWithSameLabel().countSubTrees(4, new int[][]{{0, 2}, {0, 3}, {1, 2}}, "aeed");
        System.out.println(Arrays.toString(result));
    }
}