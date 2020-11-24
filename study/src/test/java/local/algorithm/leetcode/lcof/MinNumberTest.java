package local.algorithm.leetcode.lcof;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.*;

public class MinNumberTest {

    @Test
    public void testMinNumber1() {
        String result = new MinNumber().minNumber(new int[]{824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247});
        System.out.println(result);
        assertEquals(result, "1399439856075703697382478249389609");
    }

    @Test
    public void testRandom() {
        Random random = new Random();
        int[] data = new int[20];
        for (int i = 0; i < 20; i++) {
            data[i] = random.nextInt(30);
        }
        System.out.println(Arrays.toString(data));
        String result = new MinNumber().minNumber(data);
        System.out.println(result);
    }
}