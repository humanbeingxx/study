package local.jcore;

import org.testng.annotations.Test;

public class ThisTest {

    class S {
        protected  int val = -1;
    }

    class Sup extends S  {

//        protected int val = 0;

        public void f(Sup sup) {
            System.out.println(sup == this);
            System.out.println(this.getClass().getName());
            System.out.println(this.val);
        }
    }

    class Ext extends Sup {
        protected int val = 1;

    }

    @Test
    public void test() {
        Sup ext = new Ext();
        ext.f(ext);
    }
}
