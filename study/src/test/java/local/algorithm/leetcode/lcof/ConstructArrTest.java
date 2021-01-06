package local.algorithm.leetcode.lcof;

import org.testng.annotations.Test;

import java.util.Arrays;

public class ConstructArrTest {

    @Test
    public void testConstructArr1() {
        int[] result = new ConstructArr().constructArr(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testConstructArr2() {
        int[] result = new ConstructArr().constructArr(new int[]{1});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testConstructArr3() {
        int[] result = new ConstructArr().constructArr(new int[]{1, 2});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testConstructArr4() {
        int[] data = new int[10];
        for (int i = 0; i < 10; i++) {
            data[i] = i + 1;
        }
        int[] result = new ConstructArr().constructArr(data);
        System.out.println(Arrays.toString(result));
    }
}