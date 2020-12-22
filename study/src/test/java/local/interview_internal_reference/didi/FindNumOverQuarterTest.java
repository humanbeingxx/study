package local.interview_internal_reference.didi;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class FindNumOverQuarterTest {

    @Test
    public void testFind() {
        int[] result = new FindNumOverQuarter().find(new int[]{1, 2, 4, 1, 4, 3, 2, 3, 3, 1, 2});
        System.out.println(Arrays.toString(result));
    }
}