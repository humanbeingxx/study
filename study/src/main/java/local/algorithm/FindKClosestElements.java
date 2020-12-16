package local.algorithm;

import java.util.*;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pos = Arrays.binarySearch(arr, x);
        Deque<Integer> deque = new LinkedList<>();
        int before, after;
        if (pos >= 0) {
            before = pos;
            after = pos + 1;
        } else {
            before = -pos - 2;
            after = -pos - 1;
        }
        for (int i = 0; i < k; i++) {
            if (before < 0) {
                deque.addLast(arr[after++]);
            } else if (after >= arr.length) {
                deque.addFirst(arr[before--]);
            } else {
                int valBefore = arr[before];
                int valAfter = arr[after];
                if (x - valBefore <= valAfter - x) {
                    deque.addFirst(valBefore);
                    before--;
                } else {
                    deque.addLast(valAfter);
                    after++;
                }
            }
        }
        return new ArrayList<>(deque);
    }
}
