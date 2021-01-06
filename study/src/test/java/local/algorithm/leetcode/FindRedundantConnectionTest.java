package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

public class FindRedundantConnectionTest {

    @Test
    public void testFindRedundantConnection1() {
        int[] result = new FindRedundantConnection().findRedundantConnection(new int[][]{
                {1, 2}, {1, 3}, {2, 3}
        });
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testFindRedundantConnection2() {
        int[] result = new FindRedundantConnection().findRedundantConnection(new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}
        });
        System.out.println(Arrays.toString(result));
    }
}