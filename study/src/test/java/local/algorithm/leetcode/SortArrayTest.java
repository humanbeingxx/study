package local.algorithm.leetcode;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/5/27 17:08
 */
public class SortArrayTest {

    static List<SortArray> sorters = new ArrayList<>();

    @BeforeClass
    public static void init() {
        sorters.add(new SortArrayHeapSort());
        sorters.add(new SortArrayQSort());
    }

    @Test
    public void testSortArray() {
        for (int time = 0; time < 100; time++) {
            Random random = new Random();
            int[] data0 = new int[100];
            int[] data1 = new int[100];
            int[] data2 = new int[100];
            for (int i = 0; i < 100; i++) {
                int val = random.nextInt(10000);
                data0[i] = val;
                data2[i] = val;
            }
            Arrays.sort(data2);
            for (SortArray sorter : sorters) {
                cpy(data0, data1);
                sorter.sortArray(data1);
                assertEquals(data1, data2);
            }
        }
    }

    private void cpy(int[] source, int[] target) {
        for (int i = 0; i < source.length; i++) {
            target[i] = source[i];
        }
    }
}