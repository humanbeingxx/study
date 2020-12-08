package local.algorithm.leetcode.lcci;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.*;

public class StreamRankTest {

    @Test
    public void testBinarySearch() {
        StreamRank streamRank = new StreamRank();
        streamRank.sorted = Lists.newArrayList(1, 3, 5, 5, 7, 9, 11, 11, 13, 13, 15, 17, 19);
        System.out.println(streamRank.binarySearch(11));
        System.out.println(streamRank.binarySearch(1));
        System.out.println(streamRank.binarySearch(4));
        System.out.println(streamRank.binarySearch(0));
        System.out.println(Collections.binarySearch(streamRank.sorted, 0));
        System.out.println(streamRank.binarySearch(40));
        System.out.println(Collections.binarySearch(streamRank.sorted, 40));
    }

    @Test
    public void testBinarySearchRandom() {
        Random random = new Random();
        for (int n = 0; n < 10; n++) {
            List<Integer> data = new ArrayList<>();
            for (int i = 0; i < 50; i++) {
                data.add(random.nextInt(20));
            }
            data.sort(Integer::compareTo);
            StreamRank streamRank = new StreamRank();
            streamRank.sorted = data;
            for (int i = 0; i < 30; i++) {
                assertEquals(streamRank.binarySearch(i), force(data, i));
            }
        }
    }

    private int force(List<Integer> data, int target) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) == target) {
                return i;
            } else if (data.get(i) > target) {
                return -(i + 1);
            }
        }
        return -(data.size() + 1);
    }
}