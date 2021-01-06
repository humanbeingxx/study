package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-31
 **/
public class NumPrimeArrangementsTest {

    @Test
    public void testNumPrimeArrangements() {
        int result = new NumPrimeArrangements().numPrimeArrangements(100);
        assertEquals(result, 682289015);
    }

    @Test
    public void testCountPrime() {
        int result = new NumPrimeArrangements().countPrime(10);
        assertEquals(result, 4);

        result = new NumPrimeArrangements().countPrime(100);
        assertEquals(result, 25);
    }
}