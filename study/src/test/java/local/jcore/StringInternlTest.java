package local.jcore;

import org.testng.annotations.Test;

import java.lang.reflect.Field;

/**
 * @author xiaoshuang.cui
 * @date 2018/9/29 下午8:23
 **/
public class StringInternlTest {

    private static final String SFS = "static final";
    private static final String fs = "final";
    private String s = "string";

    private int i = 1;

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

    @Test
    public void testConstantPool1() {
        //TODO 这段代码放在main和放在test下结果不同
        String s3 = new String("1") + new String("1");
        String s5 = s3.intern();
        String s4 = "11";
        System.out.println(s5 == s3);
        System.out.println(s5 == s4);
        System.out.println(s3 == s4);
    }

    public static void main(String[] args) {
        String s3 = new String("1") + new String("1");
        String s5 = s3.intern();
        String s4 = "11";
        System.out.println(s5 == s3);
        System.out.println(s5 == s4);
        System.out.println(s3 == s4);
    }

    @Test
    public void testConstantPool2() {
        String s3 = new String("111") + new String("222");
        String s5 = s3.intern();
        String s4 = "111222";
        System.out.println(s5 == s3);
        System.out.println(s5 == s4);
        System.out.println(s3 == s4);
    }

    @Test
    public void testOrder() {
        String before = "abc";
        String order1 = new String("a") + new String("b") + new String("c");
        System.out.println(order1.intern() == order1);
//        String after = "abc";
    }
}
