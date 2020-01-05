package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 13:14
 */
public class HammingDistanceTest {

    @Test
    public void testHammingDistance() {
        int result = new HammingDistance().hammingDistance(1,2);
        System.out.println(result);
    }
}