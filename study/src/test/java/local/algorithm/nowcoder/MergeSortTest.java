package local.algorithm.nowcoder;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

public class MergeSortTest {

    @Test
    public void testSort() {
        int[] data = {5, 4, 2, 3, 1};
        MergeSort.sort(data);
        System.out.println(Arrays.toString(data));
    }

    @Test
    public void testRandom() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int[] data = new int[1000];
            for (int j = 0; j < data.length; j++) {
                data[i] = random.nextInt();
            }
            int[] copy = data.clone();
            MergeSort.sort(data);
            Arrays.sort(copy);
            Assert.assertEquals(data, copy);
        }
    }
}