package local.other;

import org.testng.annotations.Test;

import java.util.Random;

/**

 *
 * @author xiaoshuang.cui
 * @date 2018/8/13 下午9:49
 **/
public class NamedForTest {

    @Test
    public void test() {
        out:while (true) {
            in:for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i % 3 != 0) {
                    break out;
                }
            }
        }
    }

    @Test
    public void testIf() {
        a:while (true) {
            final int anInt = new Random(System.currentTimeMillis()).nextInt(1000);
            if (anInt / 5 == 0) {
                System.out.println(anInt);
                break a;
            }
        }
    }
}
