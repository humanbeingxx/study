package local.jcore;

import org.openjdk.jol.info.ClassLayout;
import org.testng.annotations.Test;

public class SizeOfPointerTest {

    static class A {
        char c1;
        int i1;
        char c2;
    }

    @Test
    public void testObjectPointer() {
        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }

    @Test
    public void testA() {
        A a = new A();
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }

    @Test
    public void testInt() {
        Integer i = 1;
        System.out.println(ClassLayout.parseInstance(i).toPrintable());
    }

    @Test
    public void testLong() {
        Long l = 1L;
        System.out.println(ClassLayout.parseInstance(l).toPrintable());
    }

    static class Parent {
        int pi;
    }

    static class Child extends Parent {
        int ci;
    }

    @Test
    public void testExtends() {
        Child child = new Child();
        System.out.println(ClassLayout.parseInstance(child).toPrintable());
    }

    class Inner {
        int i;
    }

    @Test
    public void testInner() {
        Inner inner = new Inner();
        System.out.println(ClassLayout.parseInstance(inner).toPrintable());
    }

    @Test
    public void testStaticField() {
        WithStaticField withStaticField = new WithStaticField();
        System.out.println(ClassLayout.parseInstance(withStaticField).toPrintable());
    }
}
