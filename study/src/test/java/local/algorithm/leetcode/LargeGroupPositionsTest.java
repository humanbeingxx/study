package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-24
 **/
public class LargeGroupPositionsTest {

    @Test
    public void testLargeGroupPositions() {
        List<List<Integer>> result = new LargeGroupPositions().largeGroupPositions("a");
        System.out.println(result);

    }
}