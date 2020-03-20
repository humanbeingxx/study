package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.*;

public class SortArrayHeapSortTest {

    @Test
    public void testSortArrayRandom() {
        for (int time = 0; time < 100; time++) {
            Random random = new Random();
            int[] data1 = new int[100];
            int[] data2 = new int[100];
            for (int i = 0; i < 100; i++) {
                int val = random.nextInt(10000);
                data1[i] = val;
                data2[i] = val;
            }
            new SortArrayHeapSort().sortArray(data1);
            Arrays.sort(data2);
            assertEquals(data1,data2);
        }
    }

    @Test
    public void testBoundary() {
        int[] data = new int[]{};
        new SortArrayHeapSort().sortArray(data);
        data = new int[]{3,2,1};
        new SortArrayHeapSort().sortArray(data);
    }
}