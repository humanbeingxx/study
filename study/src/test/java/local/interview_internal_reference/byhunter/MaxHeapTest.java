package local.interview_internal_reference.byhunter;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class MaxHeapTest {

    @Test
    public void testFixUp() {
        Random random = new Random();
        for (int round = 0; round < 100; round++) {
            int[] data = new int[100];
            for (int i = 0; i < data.length; i++) {
                data[i] = random.nextInt(100);
            }
            MaxHeap.fixUp(data);
            checkHeap(data);
        }
    }

    private void checkHeap(int[] data) {
        for (int i = 0; i < data.length / 2; i++) {
            int left = 2 * i + 1, right = 2 * i + 2;
            if (left < data.length) {
                Assert.assertTrue(data[i] >= data[left]);
            }
            if (right < data.length) {
                Assert.assertTrue(data[i] >= data[right]);
            }
        }
    }
}