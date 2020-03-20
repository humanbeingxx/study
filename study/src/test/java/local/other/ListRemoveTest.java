package local.other;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListRemoveTest {

    @Test
    public void testArray() {
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
    public void testLinked() {
        List<Integer> data = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            data.add(1);
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000/2; i++) {
            data.remove(100000/2 - 1);
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
