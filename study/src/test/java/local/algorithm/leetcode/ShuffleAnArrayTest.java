package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

public class ShuffleAnArrayTest {

    @Test
    public void test() {
        ShuffleAnArray shuffleAnArray = new ShuffleAnArray(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(shuffleAnArray.shuffle()));
    }
}