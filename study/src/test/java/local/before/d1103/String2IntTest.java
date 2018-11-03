package local.before.d1103;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/3 23:42
 */
public class String2IntTest {

    @Test
    public void test() {
        int i = transform("1234567890");
        Assert.assertEquals(i, 1234567890);
    }

    @Test
    public void test2() {
        int i = transform("-1234567890");
        Assert.assertEquals(i, -1234567890);
    }

    @Test
    public void test3() {
        int i = transform("+1234567890");
        Assert.assertEquals(i, +1234567890);
    }

    @Test
    public void test4() {
        int i = transform("-001234567890");
        Assert.assertEquals(i, -1234567890);
    }

    private int transform(String data) {
        char[] chars = data.toCharArray();
        int result = 0;
        int negative = 1;
        int first = 0;
        if (data.charAt(0) == '-') {
            negative = -1;
            first = 1;
        } else if (data.charAt(0) == '+') {
            first = 1;
        }

        int multi = 1;
        for (int i = chars.length - 1; i >= first; i--, multi *= 10) {
            result += multi * (chars[i] - '0');
        }

        return result * negative;
    }
}
