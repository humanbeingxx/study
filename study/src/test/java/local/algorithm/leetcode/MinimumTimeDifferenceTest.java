package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MinimumTimeDifferenceTest {

    @Test
    public void testFindMinDifference() {
        int result = new MinimumTimeDifference().findMinDifference(Lists.newArrayList("23:51","00:05"));
        System.out.println(result);
    }
}