package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class FindCheapestPriceTest {

    @Test
    public void testFindCheapestPrice1() {
        int result = new FindCheapestPrice().findCheapestPrice(3, new int[][]{
                {0, 1, 100}, {1, 2, 100}, {0, 2, 500}
        }, 0, 2, 1);
        assertEquals(result, 200);
    }

    @Test
    public void testFindCheapestPrice4() {
        int result = new FindCheapestPrice().findCheapestPrice(5, new int[][]{{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}}, 0, 2, 2);
        assertEquals(result, 7);
    }

    @Test
    public void testFindCheapestPrice3() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(FindCheapestPriceTest.class.getClassLoader().getResource("FindCheapestPrice.data1").getFile()));
        int[][] data = new int[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            int[] lineData = new int[3];
            String[] split = line.split(",");
            lineData[0] = Integer.parseInt(split[0]);
            lineData[1] = Integer.parseInt(split[1]);
            lineData[2] = Integer.parseInt(split[2]);
            data[i] = lineData;
        }
        int result = new FindCheapestPrice().findCheapestPrice(94, data, 17, 33, 39);
        assertEquals(result, 200);
    }

    @Test
    public void testFindCheapestPrice2() {
        int result = new FindCheapestPrice().findCheapestPrice(10, new int[][]{
                {3, 4, 4}, {2, 5, 6}, {4, 7, 10}, {9, 6, 5}, {7, 4, 4}, {6, 2, 10}, {6, 8, 6}, {7, 9, 4}, {1, 5, 4}, {1, 0, 4}, {9, 7, 3}, {7, 0, 5}, {6, 5, 8}, {1, 7, 6}, {4, 0, 9}, {5, 9, 1}, {8, 7, 3}, {1, 2, 6}, {4, 1, 5}, {5, 2, 4}, {1, 9, 1}, {7, 8, 10}, {0, 4, 2}, {7, 2, 8}
        }, 6, 0, 7);
        assertEquals(result, 14);
    }
}