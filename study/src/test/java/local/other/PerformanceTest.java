package local.other;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;
import java.util.Random;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/8/16 下午7:19
 **/
public class PerformanceTest {

    @Test
    public void test3900() {
        List<char[]> data3900 = Lists.newArrayList();

        for (int i = 0; i < 100000; i++) {
            data3900.add(makeChars(3900));
        }

        long startTime = System.currentTimeMillis();
        for (char[] datum : data3900) {
            final int length = datum.length;
            Assert.assertEquals(3900, length);
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

    @Test
    public void test4001() {
        List<char[]> data4001 = Lists.newArrayList();

        for (int i = 0; i < 100000; i++) {
            data4001.add(makeChars(4001));
        }

        long startTime = System.currentTimeMillis();
        for (char[] datum : data4001) {
            final int length = datum.length;
            Assert.assertEquals(4001, length);
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

    private char[] makeChars(int size) {
        return new char[size];
    }

    @Test
    public void testDivide() {
        int[] ints = new int[10000000];
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < 10000000; i++) {
            ints[i] = random.nextInt();
        }

        long startTime = System.currentTimeMillis();
        for (int anInt : ints) {
            final int result = anInt / 2;
        }
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        for (int anInt : ints) {
            final int result = anInt >> 1;

        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
