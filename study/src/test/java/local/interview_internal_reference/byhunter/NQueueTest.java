package local.interview_internal_reference.byhunter;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class NQueueTest {

    @Test
    public void testPut() {
        boolean[][] result = new NQueue().put(7);
        for (boolean[] r : result) {
            System.out.println(Arrays.toString(r));
        }
    }
}