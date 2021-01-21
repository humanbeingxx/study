package local.interview_internal_reference.byhunter;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

public class ExchangeOneMakeMaxTest {

    @Test
    public void testExchange1() {
        int[] data = {1, 3, 5, 6, 7, 8, 9};
        new ExchangeOneMakeMax().exchange(data);
        System.out.println(Arrays.toString(data));
    }

    @Test
    public void testExchange2() {
        int[] data = {5, 6, 8, 8, 8, 1};
        new ExchangeOneMakeMax().exchange(data);
        System.out.println(Arrays.toString(data));
    }

    @Test
    public void testExchange3() {
        int[] data = {5, 8, 6, 8, 8, 8, 1};
        new ExchangeOneMakeMax().exchange(data);
        System.out.println(Arrays.toString(data));
    }

    @Test
    public void testRandom() {
        for (int i = 0; i < 10000; i++) {
            int[] data = new int[1000];
            Random random = new Random();
            for (int j = 0; j < data.length; j++) {
                data[j] = random.nextInt(100);
            }
            int[] copy1 = data.clone();
            int[] copy2 = data.clone();
            new ExchangeOneMakeMax().exchange(copy1);
            new ExchangeOneMakeMax().exchangeForce(copy2);
            if (!Arrays.equals(copy1, copy2)) {
                System.out.println(Arrays.toString(data));
                System.out.println(Arrays.toString(copy1));
                System.out.println(Arrays.toString(copy2));
                Assert.fail();
            }
        }

    }
}