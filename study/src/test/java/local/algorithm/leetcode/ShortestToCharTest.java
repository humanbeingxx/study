package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-31
 **/
public class ShortestToCharTest {

    @Test
    public void testSearch1() {
        int result = new ShortestToChar().search(Lists.newArrayList(1, 2, 3), 5);
        assertEquals(result, 3);

        result = new ShortestToChar().search(Lists.newArrayList(1, 2, 3), 0);
        assertEquals(result, 1);
    }

    @Test
    public void testSearch2() {
        int result = new ShortestToChar().search(Lists.newArrayList(1, 2, 6), 5);
        assertEquals(result, 6);
    }

    @Test
    public void testShortestToChar() {
        int[] result = new ShortestToChar().shortestToChar("loveleetcode", 'e');
        System.out.println(Arrays.toString(result));
        assertEquals(result, new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0});
    }
}