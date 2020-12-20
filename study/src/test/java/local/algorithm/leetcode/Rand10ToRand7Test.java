package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class Rand10ToRand7Test {

    @Test
    public void testRand7() {
        Map<Integer, Integer> counter = new HashMap<>();
        Rand10ToRand7 rand10ToRand7 = new Rand10ToRand7();
        for (int i = 0; i < 100000; i++) {
            int rand7 = rand10ToRand7.rand7();
            counter.put(rand7, counter.getOrDefault(rand7, 0) + 1);
        }
        System.out.println(counter);
    }
}