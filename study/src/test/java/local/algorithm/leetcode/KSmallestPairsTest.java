package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class KSmallestPairsTest {

    Random random = new Random();

    @Test
    public void testKSmallestPairs() {
        int[] data1 = makeData(5);
        int[] data2 = makeData(5);
        List<List<Integer>> result = new KSmallestPairs().kSmallestPairs(data1, data2, 5);
        result.sort((o1, o2) -> o1.get(0) + o1.get(1) - o2.get(0) - o2.get(1));
        check(result, force(data1, data2, 5));
    }

    @Test
    public void testKSmallestPairsBetter1() {
        int[] data1 = makeData(5);
        int[] data2 = makeData(5);
        List<List<Integer>> result = new KSmallestPairs().kSmallestPairsBetter1(data1, data2, 50000);
        result.sort((o1, o2) -> o1.get(0) + o1.get(1) - o2.get(0) - o2.get(1));
        check(result, force(data1, data2, 50000));
    }

    private void check(List<List<Integer>> result, List<List<Integer>> force) {
        List<Integer> actual = result.stream().map(e -> e.get(0) + e.get(1)).sorted().collect(Collectors.toList());
        List<Integer> expected = force.stream().map(e -> e.get(0) + e.get(1)).sorted().collect(Collectors.toList());
        assertEquals(actual, expected);
    }

    private int[] makeData(int k) {
        int len = random.nextInt(5) + k;
        int[] data = new int[len];
        for (int i = 0; i < len; i++) {
            data[i] = random.nextInt(20);
        }
        Arrays.sort(data);
        return data;
    }

    private List<List<Integer>> force(int[] data1, int[] data2, int k) {
        List<List<Integer>> result = Lists.newArrayList();
        for (int val1 : data1) {
            for (int val2 : data2) {
                result.add(Lists.newArrayList(val1, val2));
            }
        }
        result.sort((o1, o2) -> o1.get(0) + o1.get(1) - o2.get(0) - o2.get(1));
        return result.subList(0, Math.min(result.size(), k));
    }
}