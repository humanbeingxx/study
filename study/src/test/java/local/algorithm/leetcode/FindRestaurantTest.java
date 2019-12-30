package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class FindRestaurantTest {

    @Test
    public void testFindRestaurant() {
        String[] result = new FindRestaurant().findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Shogun", "Burger King"});
        System.out.println(Arrays.toString(result));
    }
}