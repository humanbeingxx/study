package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

public class DicesProbabilityTest {

    @Test
    public void testDicesProbability() {
        double[] doubles = new DicesProbability().dicesProbability(2);
        System.out.println(Arrays.toString(doubles));
    }
}