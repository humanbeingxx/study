package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FindSubsequencesTest {

    @Test
    public void testFindSubsequences1() {
        List<List<Integer>> result = new FindSubsequences().findSubsequences(new int[]{4, 6, 7, 7});
        result.forEach(System.out::println);
    }

    @Test
    public void testFindSubsequences2() {
        List<List<Integer>> result = new FindSubsequences().findSubsequences(new int[]{1, 1, 1, 1});
        result.forEach(System.out::println);
    }

    @Test
    public void testFindSubsequences3() {
        Random random = new Random();
        int[] data = new int[10];
        for (int i = 0; i < 10; i++) {
            data[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(data));
        List<List<Integer>> result = new FindSubsequences().findSubsequences(data);
        result.forEach(System.out::println);
    }
}