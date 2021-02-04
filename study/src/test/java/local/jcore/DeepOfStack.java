package local.jcore;

import org.testng.annotations.Test;

public class DeepOfStack {

    int deep = 0;

    @Test
    public void test() {
        try {
            testRec();
        } catch (Error e) {
            System.out.println(deep);
            e.printStackTrace();
        }
    }

    private void testRec() {
        deep++;
        testRec();
    }
}
