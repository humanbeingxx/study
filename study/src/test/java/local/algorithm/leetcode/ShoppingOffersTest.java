package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-13
 **/
public class ShoppingOffersTest {

    @Test
    public void testShoppingOffers1() {
        int result = new ShoppingOffers().shoppingOffers(
                Lists.newArrayList(2, 5),
                Lists.newArrayList(Lists.newArrayList(3, 0, 5), Lists.newArrayList(1, 2, 10)),
                Lists.newArrayList(3, 2));
        assertEquals(result, 14);
    }
}