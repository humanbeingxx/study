package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

public class RobIITest {

    @Test
    public void test() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.print(random.nextInt(10) + ",");
        }
    }
}