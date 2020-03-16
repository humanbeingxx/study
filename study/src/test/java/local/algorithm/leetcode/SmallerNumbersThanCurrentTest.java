package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class SmallerNumbersThanCurrentTest {

    @Test
    public void testSmallerNumbersThanCurrent1() {
        int[] result = new SmallerNumbersThanCurrent().smallerNumbersThanCurrent(new int[]{8,1,2,2,3});
        System.out.println(Arrays.toString(result));
    }
}