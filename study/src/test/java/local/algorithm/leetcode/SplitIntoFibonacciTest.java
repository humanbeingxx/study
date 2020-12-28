package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class SplitIntoFibonacciTest {

    @Test
    public void testSplitIntoFibonacci1() {
        List<Integer> result = new SplitIntoFibonacci().splitIntoFibonacci("123456579");
        System.out.println(result);
    }

    @Test
    public void testSplitIntoFibonacci2() {
        List<Integer> result = new SplitIntoFibonacci().splitIntoFibonacci("11235813");
        System.out.println(result);
    }

    @Test
    public void testSplitIntoFibonacci3() {
        List<Integer> result = new SplitIntoFibonacci().splitIntoFibonacci("112358130");
        System.out.println(result);
    }

    @Test
    public void testSplitIntoFibonacci5() {
        List<Integer> result = new SplitIntoFibonacci().splitIntoFibonacci("0123");
        System.out.println(result);
    }

    @Test
    public void testSplitIntoFibonacci6() {
        List<Integer> result = new SplitIntoFibonacci().splitIntoFibonacci("110001111");
        System.out.println(result);
    }
}