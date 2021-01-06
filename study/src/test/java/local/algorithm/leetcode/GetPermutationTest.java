package local.algorithm.leetcode;

import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-02-23
 **/
public class GetPermutationTest {

    @Test
    public void testGetPermutation1() {
        String result = new GetPermutation().getPermutation(4, 9);
        System.out.println(result);
    }

    @Test
    public void testGetPermutation2() {
        String result = new GetPermutation().getPermutation(3, 4);
        System.out.println(result);
    }

    @Test
    public void testGetPermutation3() {
        String result = new GetPermutation().getPermutation(9, 123456);
        System.out.println(result);
    }
}