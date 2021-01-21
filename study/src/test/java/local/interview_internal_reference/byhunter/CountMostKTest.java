package local.interview_internal_reference.byhunter;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class CountMostKTest {

    @Test
    public void testMostK() {
        char[] result = new CountMostK().mostK("abcesacesabb", 3);
        System.out.println(Arrays.toString(result));
    }
}