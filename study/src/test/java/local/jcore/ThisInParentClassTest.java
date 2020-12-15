package local.jcore;

import org.testng.annotations.Test;

public class ThisInParentClassTest {

    class Parent {

        public int x;
        public Parent p;

        public Parent() {
        }

        public Parent(int x) {
            this.x = x;
            p = this;
        }

        public void f() {
            System.out.println("Parent::f()");
        }

        public void g() {
            System.out.println("Parent::g()");
        }

        public void h() {
            System.out.println("Parent::h()");
            f();
            g();
            y();
            System.out.println("LOOK HERE: " + x);
        }

        private void y() {
            System.out.println("Parent::y()");
        }
    }

    ;

    class Child extends Parent {
        public int x;

        public Child() {
        }

        public Child(int x) {
            super(x + 5);
            this.x = x;
        }

        public void f() {
            System.out.println("Child f()");
        }

        public void g() {
            System.out.println("Child g()");
        }
    }

    @Test
    public void test1() {
        Child ch = new Child();
        ch.h();
    }

    @Test
    public void test2() {
        Child ch = new Child(5);
        ch.h();
    }

    @Test
    public void test3() {
        Child ch = new Child(5);
        ch.p.h();
    }
}
