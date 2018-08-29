package local.algorithm;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/8/29 下午7:42
 **/
public class GapOfNeighbourTest {

    @Test
    public void testCalculate() {

        int[] data = {1, 3, 4, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28};

        int result = GapOfNeighbour.calculate(data);

        assertEquals(result, directly(data));
    }

    @Test
    public void testCalculateSame() {

        int[] data = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        int result = GapOfNeighbour.calculate(data);

        assertEquals(result, directly(data));
    }

    @Test
    public void testCalculate2() {

        int[] data = {1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        int result = GapOfNeighbour.calculate(data);

        assertEquals(result, directly(data));
    }

    @Test
    public void testCalculateNone() {

        int[] data = {};

        int result = GapOfNeighbour.calculate(data);

        assertEquals(result, 0);
    }

    @Test
    public void testCalculateSingle() {

        int[] data = {1};

        int result = GapOfNeighbour.calculate(data);

        assertEquals(result, 0);
    }

    @Test
    public void testCalculateDouble() {

        int[] data = {1, -1};

        int result = GapOfNeighbour.calculate(data);

        assertEquals(result, directly(data));
    }

    @Test
    public void testCalculateNegative() {

        int[] data = {-1, -2, -3, -6, -7, -8};

        int result = GapOfNeighbour.calculate(data);

        assertEquals(result, directly(data));
    }

    @Test
    public void testAll() {
        int[] data = new int[10000 * 2];
        for (int i = 0; i < 10000; i++) {
            data[i] = i;
            data[2 * i] = -i;
        }

        int result = GapOfNeighbour.calculate(data);

        assertEquals(result, directly(data));
    }

    public int directly(int[] data) {
        Arrays.sort(data);
        int gap = -1;

        for (int i = 0; i < data.length - 1; i++) {
            if (gap < data[i + 1] - data[i]) {
                gap = data[i + 1] - data[i];
            }
        }
        return gap;
    }
}