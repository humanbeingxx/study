package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.*;

public class SubSortTest {

    @Test
    public void testSubSort1() {
        int[] result = new SubSort().subSort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testSubSort2() {
        int[] result = new SubSort().subSort(new int[]{1, 1, 1, 1, 3, 2, 3, 3, 3});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testSubSortRandom() {
        Random random = new Random();
        int[] data = new int[20];
        for (int i = 0; i < 20; i++) {
            data[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(data));
        int[] result = new SubSort().subSort(data);
        System.out.println(Arrays.toString(result));
    }
}