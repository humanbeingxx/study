package local.algorithm.nowcoder;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class ThreeSum0Test {

    @Test
    public void testThreeSum1() {
        ArrayList<ArrayList<Integer>> result = new ThreeSum0().threeSum(new int[]{-2, 0, 1, 1, 2});
        System.out.println(result);
    }

    @Test
    public void testThreeSum2() {
        ArrayList<ArrayList<Integer>> result = new ThreeSum0().threeSum(new int[]{0, 0, 0, 0});
        System.out.println(result);
    }

    @Test
    public void testThreeSum3() {
        ArrayList<ArrayList<Integer>> result = new ThreeSum0().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(result);
    }
}