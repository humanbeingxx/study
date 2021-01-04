package local.jcore;

import org.testng.annotations.Test;

public class ConstantPoolTest {

    static class WithConstant {
        static String val = "123";
    }

    @Test
    public void testRead() {
        new WithConstant();
        String val = "123";
        System.out.println(val == WithConstant.val);
    }

    @Test
    public void testNoRead() {
        String val = "123";
        System.out.println(val == WithConstant.val);
    }
}
