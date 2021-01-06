package local.algorithm;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author xiaoshuang.cui
 * @date 2018/8/17 下午8:51
 **/
public class BinarySearchTest {

    @Test
    public void testSearch() {

        final List<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        int result = BinarySearch.search(integers, 6);
        Assert.assertEquals(result, 5);
    }

    @Test
    public void testSearchMiss() {

        final List<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        int result = BinarySearch.search(integers, -1);
        Assert.assertEquals(result, -1);
    }

    @Test
    public void testSearchBound() {

        final List<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        int resultLow = BinarySearch.search(integers, 1);
        Assert.assertEquals(resultLow, 0);


        int resultHigh = BinarySearch.search(integers, 9);
        Assert.assertEquals(resultHigh, 8);
    }

    @Test
    public void testDuplicate() {
        final List<Integer> integers = Lists.newArrayList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

        int resultLow = BinarySearch.search(integers, 1);
        Assert.assertEquals(resultLow, 4);


        int resultHigh = BinarySearch.search(integers, 9);
        Assert.assertEquals(resultHigh, -1);
    }

    @Test
    public void testSearchFloor1() {
        int result = BinarySearch.searchFloor(Lists.newArrayList(1, 1, 2, 2, 3, 3, 4, 4), 3);
        Assert.assertEquals(result, 5);
    }

    @Test
    public void testSearchFloor2() {
        int result = BinarySearch.searchFloor(Lists.newArrayList(1, 1, 2, 2, 4, 4), 3);
        Assert.assertEquals(result, 3);
    }

    @Test
    public void testSearchFloor3() {
        int result = BinarySearch.searchFloor(Lists.newArrayList(1, 1, 2, 2, 2), 3);
        Assert.assertEquals(result, 4);
    }

    @Test
    public void testSearchFloorRandom() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            List<Integer> data = new ArrayList<>();
            for (int j = 0; j < 100; j++) {
                data.add(random.nextInt(1000));
            }
            data.sort(Integer::compareTo);
            for (int j = 0; j < 100; j++) {
                int search = random.nextInt(1000);
                int forceSearch = forceSearch(data, search);
                int binarySearch = BinarySearch.searchFloor(data, search);
                Assert.assertEquals(binarySearch, forceSearch);
            }
        }
    }

    private int forceSearch(List<Integer> data, int search) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) > search) {
                return i - 1;
            }
        }
        return data.size() - 1;
    }

//    @Test
//    public void testUnsorted() {
//        final List<Integer> integers = Lists.newArrayList(1, 9, 1, 9, 1, 9, 1, 9);
//
//        int resultLow = BinarySearch.search(integers, 4);
//        Assert.assertEquals(resultLow, -1);
//    }
}