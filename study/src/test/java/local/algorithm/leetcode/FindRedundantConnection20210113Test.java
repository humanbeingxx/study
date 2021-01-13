package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

public class FindRedundantConnection20210113Test {

    @Test
    public void testFindRedundantConnection1() {
        int[] result = new FindRedundantConnection20210113().findRedundantConnection(new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}
        });
        System.out.println(Arrays.toString(result));;
    }
}