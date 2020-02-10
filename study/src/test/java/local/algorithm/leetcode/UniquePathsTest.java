package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-10
 **/
public class UniquePathsTest {

    @Test
    public void testUniquePaths1() {
        int result = new UniquePaths().uniquePaths(3, 2);
        System.out.println(result);
    }

    @Test
    public void testUniquePaths2() {
        int result = new UniquePaths().uniquePaths(7, 3);
        System.out.println(result);
    }
}