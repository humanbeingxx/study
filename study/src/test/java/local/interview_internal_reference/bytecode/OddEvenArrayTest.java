package local.interview_internal_reference.bytecode;

import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

public class OddEvenArrayTest {

    @Test
    public void testMoveOddEven() {
        int len = 101;
        Random random = new Random();
        int[] arr = new int[len];
        Queue<Integer> odds = new LinkedList<>();
        Queue<Integer> evens = new LinkedList<>();
        for (int i = 0; i < len / 2; i++) {
            odds.add(random.nextInt(100) * 2 + 1);
        }
        for (int i = 0; i < (len % 2 == 0 ? len / 2 : (len / 2 + 1)); i++) {
            evens.add(random.nextInt(100));
        }
        for (int i = 0; i < arr.length; i++) {
            if (random.nextInt(2) == 0 && !evens.isEmpty()) {
                Integer poll = evens.poll();
                arr[i] = poll;
            } else if (!odds.isEmpty()){
                Integer poll = odds.poll();
                arr[i] = poll;
            } else {
                Integer poll = evens.poll();
                arr[i] = poll;
            }
        }
        new OddEvenArray().moveOddEven(arr);
        System.out.println(Arrays.toString(arr));
        check(arr);
    }

    private void check(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                assertTrue(arr[i] % 2 == 1);
            }
        }
    }
}