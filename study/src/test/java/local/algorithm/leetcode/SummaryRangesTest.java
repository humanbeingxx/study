package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class SummaryRangesTest {

    @Test
    public void testSummaryRanges1() {
        List<String> result = new SummaryRanges().summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        System.out.println(result);
    }

    @Test
    public void testSummaryRanges2() {
        List<String> result = new SummaryRanges().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
        System.out.println(result);
    }

    @Test
    public void testSummaryRanges3() {
        List<String> result = new SummaryRanges().summaryRanges(new int[]{-1});
        System.out.println(result);
    }
}