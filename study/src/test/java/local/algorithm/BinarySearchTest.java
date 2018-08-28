package local.algorithm;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

/**

 *
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

//    @Test
//    public void testUnsorted() {
//        final List<Integer> integers = Lists.newArrayList(1, 9, 1, 9, 1, 9, 1, 9);
//
//        int resultLow = BinarySearch.search(integers, 4);
//        Assert.assertEquals(resultLow, -1);
//    }
}