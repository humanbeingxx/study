package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-03
 **/
public class AddToArrayFormTest {

    @Test
    public void testAddToArrayForm() {
        List<Integer> result = new AddToArrayForm().addToArrayForm(new int[]{1, 2, 0, 0}, 34);
        assertEquals(result, Lists.newArrayList(1, 2, 3, 4));

        result = new AddToArrayForm().addToArrayForm(new int[]{2, 7, 4}, 181);
        assertEquals(result, Lists.newArrayList(4, 5, 5));

        result = new AddToArrayForm().addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1);
        assertEquals(result, Lists.newArrayList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

        result = new AddToArrayForm().addToArrayForm(new int[]{0}, 10000);
        assertEquals(result, Lists.newArrayList(1, 0, 0, 0, 0));
    }
}