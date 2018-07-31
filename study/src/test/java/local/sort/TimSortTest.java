package local.sort;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class TimSortTest {
    @Test
    public void testMerge() throws Exception {
        TimSort timSort = new TimSort(new int[]{1, 3, 5, 2, 4, 6});
        timSort.merge(timSort.new SubArray(0, 2), timSort.new SubArray(3, 5));
        Assert.assertEquals(new int[]{1, 2, 3, 4, 5, 6}, timSort.getOriginData());
    }

    @Test
    public void testSplitRun() throws Exception {
        TimSort timSort = new TimSort(new int[]{5, 4, 3, 2, 1});
        timSort.splitRun();
        Stack<TimSort.SubArray> stack = timSort.getStack();
        TimSort.SubArray pop1 = stack.pop();
        TimSort.SubArray pop2 = stack.pop();
        TimSort.SubArray pop3 = stack.pop();

        Assert.assertEquals(new int[]{1}, pop1.getCopy());
        Assert.assertEquals(new int[]{2, 3}, pop2.getCopy());
        Assert.assertEquals(new int[]{4, 5}, pop3.getCopy());
    }

    @Test
    public void testTurnover() throws Exception {
        TimSort timSort = new TimSort(new int[]{1, 2, 3, 4, 5});
        timSort.turnover(0, 3);
        Assert.assertEquals(new int[]{4, 3, 2, 1, 5}, timSort.getOriginData());
    }


}