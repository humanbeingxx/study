package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2019-12-18
 **/
public class PowerfulIntegersTest {

    @Test
    public void testPowerfulIntegers() {
        List<Integer> result = new PowerfulIntegers().powerfulIntegers(2, 3, 10);
        Collections.sort(result);
        Assert.assertEquals(result, Lists.newArrayList(2, 3, 4, 5, 7, 9, 10));

        result = new PowerfulIntegers().powerfulIntegers(3, 5, 15);
        Collections.sort(result);
        Assert.assertEquals(result, Lists.newArrayList(2, 4, 6, 8, 10, 14));

        result = new PowerfulIntegers().powerfulIntegers(1, 1, 2);
        Collections.sort(result);
        Assert.assertEquals(result, Lists.newArrayList(2));

        result = new PowerfulIntegers().powerfulIntegers(1, 1, 1);
        Collections.sort(result);
        Assert.assertEquals(result, Lists.newArrayList());

    }
}