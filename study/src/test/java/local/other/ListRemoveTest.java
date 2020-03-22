package local.other;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListRemoveTest {

    @Test
    public void testArrayHead() {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            data.add(1);
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000 - 1; i++) {
            data.remove(0);
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

    @Test
    public void testArrayMid() {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            data.add(1);
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000/2; i++) {
            data.remove(100000/2 - 1);
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

    @Test
    public void testArrayTail() {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            data.add(1);
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000 - 1; i++) {
            data.remove(data.size() - 1);
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

    @Test
    public void testLinkedHead() {
        List<Integer> data = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            data.add(1);
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000 - 1; i++) {
            data.remove(0);
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

    @Test
    public void testLinkedMid() {
        List<Integer> data = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            data.add(1);
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000/2; i++) {
            data.remove(i);
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

    @Test
    public void testLinkedTail() {
        List<Integer> data = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            data.add(1);
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000 - 1; i++) {
            data.remove(data.size() - 1);
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
