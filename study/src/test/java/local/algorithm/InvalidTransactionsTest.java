package local.algorithm;

import local.algorithm.leetcode.InvalidTransactions;
import org.testng.annotations.Test;

import java.util.List;

public class InvalidTransactionsTest {

    @Test
    public void testInvalidTransactions() {
        List<String> result = new InvalidTransactions().invalidTransactions(new String[]{"bob,689,1910,barcelona", "alex,696,122,bangkok", "bob,832,1726,barcelona", "bob,820,596,bangkok", "chalicefy,217,669,barcelona", "bob,175,221,amsterdam"});
        System.out.println(result);
    }
}