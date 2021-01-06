package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

public class ShuffleArrayTest {

    @Test
    public void testShuffle1() {
        int[] shuffle = new ShuffleArray().shuffle(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 4);
        System.out.println(Arrays.toString(shuffle));
    }

    @Test
    public void testShuffle2() {
        int[] shuffle = new ShuffleArray().shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4);
        System.out.println(Arrays.toString(shuffle));
    }
}