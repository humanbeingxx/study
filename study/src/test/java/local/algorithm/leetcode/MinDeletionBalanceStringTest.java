package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

public class MinDeletionBalanceStringTest {

    @Test
    public void testMinimumDeletions1() {
        int result = new MinDeletionBalanceString().minimumDeletions("aababbab");
        assertEquals(result, 2);
    }

    @Test
    public void testMinimumDeletions2() {
        int result = new MinDeletionBalanceString().minimumDeletions("bbaaaaabb");
        assertEquals(result, 2);
    }

    @Test
    public void testMinimumDeletions3() {
        int result = new MinDeletionBalanceString().minimumDeletions("ba");
        assertEquals(result, 1);
    }

    @Test
    public void testMinimumDeletions4() {
        int result = new MinDeletionBalanceString().minimumDeletions("bbbbbbbaabbbbbaaabbbabbbbaabbbbbbaabbaaabaabbbaaaabaaababbbabbabbaaaabbbabbbbbaabbababbbaaaaaababaaababaabbabbbaaaabbbbbabbabaaaabbbaba");
        assertEquals(result, 60);
    }

    @Test
    public void testRandom() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            stringBuilder.append((char)('a' + random.nextInt(2)));
        }
        System.out.println(stringBuilder.toString());
        System.out.println(new MinDeletionBalanceString().minimumDeletions(stringBuilder.toString()));
    }
}