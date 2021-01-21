package local.interview_internal_reference.byhunter;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class PrimeInNTest {

    @Test
    public void testPrimeInN() {
        List<Integer> result = new PrimeInN().primeInN(1000);
        System.out.println(result);
    }
}