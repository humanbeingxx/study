package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class PathInZigZagTreeTest {

    @Test
    public void testPathInZigZagTree1() {
        List<Integer> result = new PathInZigZagTree().pathInZigZagTree(1);
        System.out.println(result);
    }

    @Test
    public void testPathInZigZagTree2() {
        List<Integer> result = new PathInZigZagTree().pathInZigZagTree(2);
        System.out.println(result);
    }
    @Test
    public void testPathInZigZagTree3() {
        List<Integer> result = new PathInZigZagTree().pathInZigZagTree(14);
        System.out.println(result);
    }
    @Test
    public void testPathInZigZagTree4() {
        List<Integer> result = new PathInZigZagTree().pathInZigZagTree(26);
        System.out.println(result);
    }
}