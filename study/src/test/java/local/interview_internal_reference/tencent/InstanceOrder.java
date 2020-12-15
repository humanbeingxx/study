package local.interview_internal_reference.tencent;

import org.testng.annotations.Test;

public class InstanceOrder {

    static class A {
        private static int val = makeVal();
        private int val2 = makeVal2();

        private int makeVal2() {
            System.out.println("make val A2");
            return 2;
        }

        private static int makeVal() {
            System.out.println("make val A");
            return 1;
        }

        public A() {
            System.out.println("constructor A");
        }
    }

    static class B extends A {
        private static int val = makeVal();
        private int val2 = makeVal2();

        private int makeVal2() {
            System.out.println("make val B2");
            return 2;
        }

        private static int makeVal() {
            System.out.println("make val B");
            return 1;
        }

        public B() {
            System.out.println("constructor B");
        }
    }

    @Test
    public void test() {
        new B();
    }
}
