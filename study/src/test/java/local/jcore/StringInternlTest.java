package local.jcore;

import org.testng.annotations.Test;

/**
 * @author xiaoshuang.cui
 * @date 2018/9/29 下午8:23
 **/
public class StringInternlTest {

    @Test
    public void test() {
        String str = new StringBuilder("ja").append("va").toString();
        System.out.println(System.identityHashCode(str));
        System.out.println(System.identityHashCode(str.intern()));
        System.out.println(System.identityHashCode("java"));

        for (int i = 0; i < 100; i++) {
            System.out.println(System.identityHashCode(new StringBuilder("ja").append("va").toString()));
        }
    }
}
