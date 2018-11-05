package local.before.d1101;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/31 下午10:33
 **/
public class IntegerTest {

    @Test
    public void test() {
        Assert.assertTrue(Integer.valueOf(1) == Integer.valueOf(1));
        Assert.assertFalse(new Integer(1) == new Integer(1));
    }
}
