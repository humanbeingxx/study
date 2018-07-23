package local.other;

import org.junit.Test;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/7/16 下午4:48
 **/
public class FieldExtendsTest {

    class A {
        protected int protectedValue = 1;
        public int publicValue = 2;

        public int getProtectedValue() {
            return protectedValue;
        }
    }

    class B extends A {
        protected int protectedValue = 10;
        public int publicValue = 20;

        public int getProtectedValue() {
            return protectedValue;
        }
    }

    @Test
    public void test() {
        final A b = new B();

        System.out.println(b.publicValue);
        System.out.println(b.getProtectedValue());
    }
}
