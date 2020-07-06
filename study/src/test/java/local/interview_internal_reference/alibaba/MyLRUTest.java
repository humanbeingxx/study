package local.interview_internal_reference.alibaba;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/7/6 17:29
 */
public class MyLRUTest {

    @Test
    public void test1() {
        MyLRU myLRU = new MyLRU(2);
        myLRU.put(1, 11);
        myLRU.put(2, 22);
        myLRU.put(3, 33);
        assertEquals(myLRU.get(1), -1);
    }

    @Test
    public void test2() {
        MyLRU myLRU = new MyLRU(2);
        myLRU.put(1, 11);
        myLRU.put(2, 22);
        myLRU.get(1);
        myLRU.put(3, 33);
        assertEquals(myLRU.get(2), -1);
        assertEquals(myLRU.get(1), 11);
    }
}