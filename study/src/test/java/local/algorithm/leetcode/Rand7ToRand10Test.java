package local.algorithm.leetcode;

import org.testng.annotations.Test;

public class Rand7ToRand10Test {

    @Test
    public void testRand10() {
        Rand7ToRand10 rand7ToRand10 = new Rand7ToRand10();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            rand7ToRand10.rand10();
        }
        System.out.println("cost " + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void testRand10Better() {
        Rand7ToRand10 rand7ToRand10 = new Rand7ToRand10();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            rand7ToRand10.rand10Better();
        }
        System.out.println("cost " + (System.currentTimeMillis() - startTime));
    }
}