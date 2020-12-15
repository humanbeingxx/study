package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;
import scala.Int;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.*;

public class FindClosedNumbersTest {

    @Test
    public void testFindClosedNumbers1() {
        int[] result = new FindClosedNumbers().findClosedNumbers(0b1010101000111);
        for (int i : result) {
            System.out.println(Integer.toBinaryString(i) + " ->" + i);
        }
    }

    @Test
    public void testFindClosedNumbers2() {
        int[] result = new FindClosedNumbers().findClosedNumbers(Integer.MAX_VALUE);
        for (int i : result) {
            System.out.println(Integer.toBinaryString(i) + " ->" + i);
        }
    }

    @Test
    public void testFindClosedNumbers3() {
        int[] result = new FindClosedNumbers().findClosedNumbers(0b1011111111111111111111111111111);
        for (int i : result) {
            System.out.println(Integer.toBinaryString(i) + " ->" + i);
        }
    }

    @Test
    public void testFindClosedNumbers4() {
        int[] result = new FindClosedNumbers().findClosedNumbers(0b1000100111011010101000010111110);
        for (int i : result) {
            System.out.println(Integer.toBinaryString(i) + " ->" + i);
        }
    }

    @Test
    public void testRandom() {
        FindClosedNumbers func = new FindClosedNumbers();
        Random random = new Random();
        for (int round = 0; round < 100; round++) {
            int data = random.nextInt(Integer.MAX_VALUE);
            System.out.println(data + "->" + Integer.toBinaryString(data));
            int[] result = func.findClosedNumbers(data);
            for (int i : result) {
                System.out.println(Integer.toBinaryString(i) + "->" + i);
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    @Test
    public void testBound() {
        func(1);
        func(2);
        func(3);

        func(Integer.MAX_VALUE);
        func(Integer.MAX_VALUE - 1);
        func(Integer.MAX_VALUE - 2);
    }

    private void func(int data) {
        FindClosedNumbers func = new FindClosedNumbers();
        int[] result = func.findClosedNumbers(data);
        System.out.println(Integer.toBinaryString(data) + "->" + data);
        for (int i : result) {
            System.out.println(Integer.toBinaryString(i) + "->" + i);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}