package local.algorithm;

import org.testng.annotations.Test;

import java.util.Arrays;

public class MaxDepthAfterSplitTest {

    @Test
    public void testMaxDepthAfterSplit1() {
        int[] result = new MaxDepthAfterSplit().maxDepthAfterSplit("(()())");
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testMaxDepthAfterSplit2() {
        int[] result = new MaxDepthAfterSplit().maxDepthAfterSplit("()(())()");
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testMaxDepthAfterSplit3() {
        int[] result = new MaxDepthAfterSplit().maxDepthAfterSplit("((()(()))())");
        System.out.println(Arrays.toString(result));
    }
}