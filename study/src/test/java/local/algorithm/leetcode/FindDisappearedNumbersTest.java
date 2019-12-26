package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/26 0:18
 */
public class FindDisappearedNumbersTest {

    @Test
    public void testFindDisappearedNumbers() {
        List<Integer> result = new FindDisappearedNumbers().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        Assert.assertEquals(result, Lists.newArrayList(5, 6));
    }
}