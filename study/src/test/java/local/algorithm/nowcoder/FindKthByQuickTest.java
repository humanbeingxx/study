package local.algorithm.nowcoder;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class FindKthByQuickTest {

    @Test
    public void testFindKthRandom() {
        Random random = new Random();
        FindKthByQuick func = new FindKthByQuick();
        for (int i = 0; i < 100; i++) {
            int[] data = new int[100];
            for (int j = 0; j < 100; j++) {
                data[j] = random.nextInt(20);
            }
            int[] copy = data.clone();
            Arrays.sort(copy);
            assertEquals(func.findKth(data, 100, 1), copy[99]);
            for (int j = 0; j < 10; j++) {
                int k = random.nextInt(100) + 1;
                assertEquals(func.findKth(data, 100, k), copy[100 - k]);
            }
            assertEquals(func.findKth(data, 100, 100), copy[0]);
        }
    }

    @Test
    public void testFindKth1() {
        int[] data = {1, 5, 4, 2, 3, 1, 2};
        assertEquals(new FindKthByQuick().findKth(data, data.length, 3), 2);
    }

    @Test
    public void testFindKth2() {
        int[] data = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertEquals(new FindKthByQuick().findKth(data, data.length, 3), 1);
    }

    @Test
    public void testFindKth3() {
        int[] data = {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,
                1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,
                1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,
                1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        assertEquals(new FindKthByQuick().findKth(data, data.length, 24), 986578);
    }
}