package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.testng.Assert.*;

public class RemoveMinSubarrayModPTest {

    @Test
    public void testMinSubarray1() {
        int result = new RemoveMinSubarrayModP().minSubarray(new int[]{6, 3, 5, 2}, 9);
        assertEquals(result, 2);
    }

    @Test
    public void testMinSubarray2() {
        int result = new RemoveMinSubarrayModP().minSubarray(new int[]{3, 1, 4, 2}, 6);
        assertEquals(result, 1);
    }

    @Test
    public void testMinSubarray3() {
        int result = new RemoveMinSubarrayModP().minSubarray(new int[]{1, 2, 3}, 3);
        assertEquals(result, 0);
    }

    @Test
    public void testMinSubarray4() {
        int result = new RemoveMinSubarrayModP().minSubarray(new int[]{1, 2, 3}, 7);
        assertEquals(result, -1);
    }

    @Test
    public void testMinSubarray5() {
        int result = new RemoveMinSubarrayModP().minSubarray(new int[]{1000000000, 1000000000, 1000000000}, 3);
        assertEquals(result, 0);
    }

    @Test
    public void testMinSubarray6() {
        int result = new RemoveMinSubarrayModP().minSubarray(new int[]{8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2}, 148);
        assertEquals(result, 7);
    }

    @Test
    public void testMinSubarrayX() throws IOException {
        URL resource = this.getClass().getClassLoader().getResource("RemoveMinSubarrayModPTest.data");
        List<String> dataLines = Files.readAllLines(Paths.get(resource.getFile()));
        int[] data = new int[dataLines.size() - 1];
        for (int i = 0; i < dataLines.size() - 1; i++) {
            data[i] = Integer.parseInt(dataLines.get(i));
        }
        int p = Integer.parseInt(dataLines.get(dataLines.size() - 1));
        int result = new RemoveMinSubarrayModP().minSubarray(data, p);
        System.out.println(result);
    }

    @Test
    public void test() {
        long result = (long) Math.pow(10, 14);
        System.out.println(result);
    }
}