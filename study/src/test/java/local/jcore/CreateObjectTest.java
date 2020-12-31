package local.jcore;

import org.openjdk.jol.info.ClassLayout;
import org.testng.annotations.Test;

public class CreateObjectTest {

    static class MyObject implements Cloneable {
        {
            System.out.println("creating");
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    @Test
    public void test() throws CloneNotSupportedException {
        MyObject origin = new MyObject();
        MyObject clone = (MyObject)origin.clone();
    }

    static class Parent {
        private Object obj1 = makeObj();

        {
            System.out.println("parent between making obj");
        }

        private Object obj2 = makeObj();

        private Object makeObj() {
            System.out.println("parent making obj");
            return new Object();
        }

        public Parent() {
            System.out.println("parent creating");
        }
    }

    static class Child extends Parent {
        private Object obj1 = makeObj();

        {
            System.out.println("child between making obj");
        }

        private Object obj2 = makeObj();

        private Object makeObj() {
            System.out.println("child making obj");
            return new Object();
        }

        public Child() {
            System.out.println("child creating");
        }
    }

    @Test
    public void testOrder() {
        Child child = new Child();
        ClassLayout layout = ClassLayout.parseClass(Child.class);
        System.out.println(layout.toPrintable());
    }
}
