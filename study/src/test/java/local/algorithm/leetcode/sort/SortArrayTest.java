package local.algorithm.leetcode.sort;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public abstract class SortArrayTest {

    @Test
    public void testSortRandom() {
        for (int time = 0; time < 100; time++) {
            Random random = new Random();
            int[] data1 = new int[100];
            int[] data2 = new int[100];
            for (int i = 0; i < 100; i++) {
                int val = random.nextInt(10000);
                data1[i] = val;
                data2[i] = val;
            }
            sort(data1);
            Arrays.sort(data2);
            assertEquals(data1, data2);
        }
    }

    abstract protected void sort(int[] data);
}
