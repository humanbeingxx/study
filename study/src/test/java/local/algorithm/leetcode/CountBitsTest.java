package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-06
 **/
public class CountBitsTest {

    @Test
    public void testCountBits() {
        int[] result = new CountBits().countBits(5);
        System.out.println(Arrays.toString(result));
    }
}