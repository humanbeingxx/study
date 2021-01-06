package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

public class MajorityElementOneThirdTest {

    @Test
    public void testMajorityElement1() {
        List<Integer> result = new MajorityElementOneThird().majorityElement(new int[]{3, 3, 2});
        System.out.println(result);
    }

    @Test
    public void testMajorityElement2() {
        List<Integer> result = new MajorityElementOneThird().majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2});
        System.out.println(result);
    }

    @Test
    public void testMajorityElement3() {
        List<Integer> result = new MajorityElementOneThird().majorityElement(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        System.out.println(result);
    }

    @Test
    public void testMajorityElement4() {
        List<Integer> result = new MajorityElementOneThird().majorityElement(new int[]{1, 1, 2, 2, 3, 3});
        System.out.println(result);
    }

    @Test
    public void testMajorityElement5() {
        List<Integer> result = new MajorityElementOneThird().majorityElement(new int[]{1});
        System.out.println(result);
    }

    @Test
    public void testMajorityElement6() {
        List<Integer> result = new MajorityElementOneThird().majorityElement(new int[]{2, 1, 1});
        System.out.println(result);
    }
}