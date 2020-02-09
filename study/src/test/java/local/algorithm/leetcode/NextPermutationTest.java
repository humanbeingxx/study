package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-09
 **/
public class NextPermutationTest {

    @Test
    public void testNextPermutation1() {
        int[] data = {1, 2, 3, 4};
        new NextPermutation().nextPermutation(data);
        assertEquals(Arrays.toString(data), Arrays.toString(new int[]{1, 2, 4, 3}));
    }

    @Test
    public void testNextPermutation2() {
        int[] data = {4, 3, 2, 1};
        new NextPermutation().nextPermutation(data);
        assertEquals(Arrays.toString(data), Arrays.toString(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void testNextPermutation3() {
        int[] data = {3, 4, 2, 1};
        new NextPermutation().nextPermutation(data);
        assertEquals(Arrays.toString(data), Arrays.toString(new int[]{4, 1, 2, 3}));
    }

    @Test
    public void testNextPermutation4() {
        int[] data = {5, 4, 7, 5, 3, 2};
        new NextPermutation().nextPermutation(data);
        assertEquals(Arrays.toString(data), Arrays.toString(new int[]{5, 5, 2, 3, 4, 7}));
    }

    @Test
    public void testNextPermutation5() {
        int[] data = {4, 3, 2, 5};
        new NextPermutation().nextPermutation(data);
        assertEquals(Arrays.toString(data), Arrays.toString(new int[]{4, 3, 5, 2}));
    }

    @Test
    public void testNextPermutation6() {
        int[] data = {4, 2, 0, 2, 3, 2, 0};
        new NextPermutation().nextPermutation(data);
        assertEquals(Arrays.toString(data), Arrays.toString(new int[]{4, 2, 0, 3, 0, 2, 2}));
    }

    @Test
    public void testNextPermutation7() {
        int[] data = {3, 4, 1, 4, 3, 3};
        new NextPermutation().nextPermutation(data);
        assertEquals(Arrays.toString(data), Arrays.toString(new int[]{3, 4, 3, 1, 3, 4}));
    }
}