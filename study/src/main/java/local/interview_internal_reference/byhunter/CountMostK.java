package local.interview_internal_reference.byhunter;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CountMostK {

    public char[] mostK(String str, int k) {
        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - 'a']++;
        }
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> counts[o - 'a']));
        for (int i = 0; i < 26; i++) {
            priorityQueue.add((char)('a' + i));
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        char[] result = new char[k];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }
}
