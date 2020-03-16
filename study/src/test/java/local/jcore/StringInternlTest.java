package local.jcore;

import org.testng.annotations.Test;

import java.lang.reflect.Field;

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

        for (int i = 0; i < 10; i++) {
            System.out.println(System.identityHashCode(new StringBuilder("ja").append("va").toString()));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(System.identityHashCode(new StringBuilder("ja").append("va").toString().intern()));
        }
    }

    @Test
    public void test2() {
        char[] chars = new char[5];
        for (int i = 0; i < 5; i++) {
            chars[i] = (char) ('a' + i);
        }
        System.out.println(new String(chars).intern() == new String(chars).intern());
    }

    @Test
    public void testModify() throws NoSuchFieldException, IllegalAccessException {
        String reverse = "abc";
        Class<String> clazz = String.class;
        Field valueFiled = clazz.getDeclaredField("value");
        valueFiled.setAccessible(true);
        char[] value = (char[]) valueFiled.get(reverse);
        value[0] = 'c';
        value[1] = 'b';
        value[2] = 'a';
        System.out.println("abc");
    }
}
