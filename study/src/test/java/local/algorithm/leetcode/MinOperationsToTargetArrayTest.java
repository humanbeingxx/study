package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.*;

public class MinOperationsToTargetArrayTest {

    @Test
    public void testMinOperationsRandom() {
        int[] data = new int[10];
        Random random = new Random();
        for (int i = 1; i < data.length; i++) {
            data[i] = random.nextInt(1000);
        }
        System.out.println(Arrays.toString(data));
    }
}