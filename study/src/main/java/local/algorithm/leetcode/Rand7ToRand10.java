package local.algorithm.leetcode;

import java.util.Random;

public class Rand7ToRand10 {

    private Random random = new Random();

    private int rand7() {
        return random.nextInt(7) + 1;
    }

    public int rand10() {
        // (randX - 1) * Y + randY -> [1, X*Y]
        int num = (rand7() - 1) * 7 + rand7();
        while (num > 10) {
            num = (rand7() - 1) * 7 + rand7();
        }
        return num;
    }

    public int rand10Better() {
        // (randX - 1) * Y + randY -> [1, X*Y]
        int num = (rand7() - 1) * 7 + rand7();
        while (num > 40) {
            num = (rand7() - 1) * 7 + rand7();
        }
        return num % 10 + 1;
    }
}
