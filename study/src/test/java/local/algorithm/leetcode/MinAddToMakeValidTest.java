package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

public class MinAddToMakeValidTest {

    @Test
    public void testMinAddToMakeValidRandom() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            if (random.nextInt(2) == 0) {
                stringBuilder.append('(');
            } else {
                stringBuilder.append(')');
            }
        }
        String s = stringBuilder.toString();
        int result = new MinAddToMakeValid().minAddToMakeValid(s);
        System.out.println(s);
        System.out.println(result);
    }

    @Test
    public void testMinAddToMakeValid1() {
        int result = new MinAddToMakeValid().minAddToMakeValid(")()))))))(()))((((()()))))((())");
        System.out.println(result);
    }
}