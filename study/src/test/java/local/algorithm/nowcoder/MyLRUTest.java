package local.algorithm.nowcoder;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class MyLRUTest {

    @Test
    public void test1() {
        MyLRU<Integer, Integer> myLRU = new MyLRU<>(2);
        myLRU.put(1, 11);
        myLRU.put(2, 22);
        myLRU.put(3, 33);
        assertNull(myLRU.get(1));
    }

    @Test
    public void test2() {
        MyLRU<Integer, Integer> myLRU = new MyLRU<>(2);
        myLRU.put(1, 11);
        myLRU.put(2, 22);
        myLRU.get(1);
        myLRU.put(3, 33);
        assertNull(myLRU.get(2));
        assertEquals(myLRU.get(1), Integer.valueOf(11));
    }
}