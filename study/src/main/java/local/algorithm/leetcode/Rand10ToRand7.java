package local.algorithm.leetcode;

import java.util.Random;

public class Rand10ToRand7 {

    private Random random = new Random();

    public int rand10() {
        return random.nextInt(10) + 1;
    }

    public int rand7() {
        int num = rand10();
        while (num > 7) {
            num = rand10();
        }
        return num;
    }
}
