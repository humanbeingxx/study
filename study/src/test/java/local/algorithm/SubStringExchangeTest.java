package local.algorithm;


import org.testng.Assert;
import org.testng.annotations.Test;

public class SubStringExchangeTest {
    @Test
    public void testExchange() throws Exception {
        char[] str = new char[]{'1', '2', '3', '4', '5', '6', '7', '8'};
        SubStringExchange.exchange(str, 0, 7, 2);

        Assert.assertEquals(new char[]{'4', '5', '6', '7', '8', '1', '2', '3'}, str);

        char[] str2 = new char[]{'1', '2', '3', '4', '5', '6', '7', '8'};
        SubStringExchange.exchange(str2, 0, 2, 0);
        System.out.println(str2);
    }

    @Test
    public void testExchangeSameLength() throws Exception {
        char[] str1 = new char[]{'1', '2', '3', '4', '5', '6', '7', '8'};
        char[] str2 = new char[]{'1', '2', '3', '4', '5', '6', '7', '8'};
        char[] str3 = new char[]{'1', '2', '3', '4', '5', '6', '7', '8'};

        SubStringExchange.exchangeSameLength(str1, 0, 4, 3);
        SubStringExchange.exchangeSameLength(str2, 1, 4, 2);
        SubStringExchange.exchangeSameLength(str3, 1, 4, 1);


    }

}