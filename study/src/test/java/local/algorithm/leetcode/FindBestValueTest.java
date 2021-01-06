package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class FindBestValueTest {

    @Test
    public void testFindBestValue1() {
        int result = new FindBestValue().findBestValue(new int[]{4, 9, 3}, 10);
        assertEquals(result, 3);
    }

    @Test
    public void testFindBestValue2() {
        int result = new FindBestValue().findBestValue(new int[]{2, 3, 5}, 10);
        assertEquals(result, 5);
    }

    @Test
    public void testFindBestValue6() {
        int result = new FindBestValue().findBestValue(new int[]{2, 3, 5}, 11);
        assertEquals(result, 5);
    }

    @Test
    public void testFindBestValue5() {
        int result = new FindBestValue().findBestValue(new int[]{1547, 83230, 57084, 93444, 70879}, 71237);
        assertEquals(result, 17422);
    }

    @Test
    public void testFindBestValue3() {
        int[] arr = {
                0, 86, 76, 46, 67, 20, 72, 57, 60, 21, 92, 37, 64, 26, 48, 37, 98, 28, 88, 4, 79, 94, 3, 24, 69, 74, 29, 41, 11, 75, 56, 40, 22, 84, 19, 80, 31, 16, 54, 76, 90, 62, 31, 11, 23, 65, 75, 27, 59, 88, 25, 16, 49, 75, 33, 13, 92, 37, 72, 86, 46, 51, 0, 82, 16, 75, 34, 20, 21, 2, 77, 4, 55, 56, 75, 56, 0, 2, 78, 85, 94, 58, 77, 21, 91, 51, 16, 98, 9, 16, 99, 84, 6, 86, 15, 54, 60, 74, 67, 54
        };
        int result = new FindBestValue().findBestValue(arr, 999);
        assertEquals(result, 11);
    }

    @Test
    public void testFindBestValue4() {
        int[] arr = {
                0, 86, 76, 46, 67, 20, 72, 57, 60, 21, 92, 37, 64, 26, 48, 37, 98, 28, 88, 4, 79, 94, 3, 24, 69, 74, 29, 41, 11, 75, 56, 40, 22, 84, 19, 80, 31, 16, 54, 76, 90, 62, 31, 11, 23, 65, 75, 27, 59, 88, 25, 16, 49, 75, 33, 13, 92, 37, 72, 86, 46, 51, 0, 82, 16, 75, 34, 20, 21, 2, 77, 4, 55, 56, 75, 56, 0, 2, 78, 85, 94, 58, 77, 21, 91, 51, 16, 98, 9, 16, 99, 84, 6, 86, 15, 54, 60, 74, 67, 54
        };
        int result = new FindBestValue().findBestValue(arr, 999);
        assertEquals(result, 11);
    }

    @Test
    public void testRandom() {
        Random random = new Random();
        int[] data = new int[500];
        for (int i = 0; i < 500; i++) {
            data[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(data));

    }
}