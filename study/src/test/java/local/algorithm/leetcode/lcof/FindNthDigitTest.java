package local.algorithm.leetcode.lcof;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.*;

public class FindNthDigitTest {

    private static List<Character> chars;

    @BeforeClass
    public static void doInit() {
        chars = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            char[] charArray = String.valueOf(i).toCharArray();
            for (char c : charArray) {
                chars.add(c);
            }
        }
    }

    @Test
    public void testFindNthDigit1() {
        int result = new FindNthDigit().findNthDigit(111);
        assertEquals(result, byForce(111));
    }

    @Test
    public void testFindNthDigit2() {
        int result = new FindNthDigit().findNthDigit(1000000000);
        assertEquals(result, 1);
    }

    @Test
    public void testFindNthDigit3() {
        int result = new FindNthDigit().findNthDigit(1234567);
        assertEquals(result, 2);
        assertEquals(result, byForce(1234567));
    }

    @Test
    public void testFindNthDigitMax() {
        System.out.println(Integer.MAX_VALUE);
        int result = new FindNthDigit().findNthDigit(Integer.MAX_VALUE);
        assertEquals(result, 2);
    }

    @Test
    public void testRandom() {
        Random random = new Random();
        FindNthDigit func = new FindNthDigit();
        for (int i = 0; i < 10; i++) {
            int n = random.nextInt(chars.size());
            System.out.println(n);
            int result = func.findNthDigit(n);
            assertEquals(result, byForce(n));
        }
    }

    public int byForce(int n) {
        return chars.get(n) - '0';
    }
}