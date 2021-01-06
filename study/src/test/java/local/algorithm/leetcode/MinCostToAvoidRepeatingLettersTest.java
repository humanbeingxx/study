package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MinCostToAvoidRepeatingLettersTest {

    @Test
    public void testMinCost1() {
        int result = new MinCostToAvoidRepeatingLetters().minCost("abaac", new int[]{1, 2, 3, 4, 5});
        assertEquals(result, 3);
    }

    @Test
    public void testMinCost2() {
        int result = new MinCostToAvoidRepeatingLetters().minCost("aabaa", new int[]{1, 2, 3, 4, 1});
        assertEquals(result, 2);
    }

    @Test
    public void testMinCost3() {
        int result = new MinCostToAvoidRepeatingLetters().minCost("abc", new int[]{1, 2, 3});
        assertEquals(result, 0);
    }
}