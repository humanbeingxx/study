package local.algorithm.leetcode;

import java.util.*;

public class LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        Map<String, Set<String>> convertMap = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String word1 = wordList.get(i);
            convertMap.putIfAbsent(word1, new HashSet<>());
            for (int j = i + 1; j < wordList.size(); j++) {
                String word2 = wordList.get(j);
                if (diff(word1, word2)) {
                    convertMap.get(word1).add(word2);
                    convertMap.putIfAbsent(word2, new HashSet<>());
                    convertMap.get(word2).add(word1);
                }
            }
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> saw = new HashSet<>();
        queue.add(beginWord);
        saw.add(beginWord);
        int len = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(endWord)) {
                    return len;
                }
                Set<String> nexts = convertMap.get(poll);
                if (nexts.contains(endWord)) {
                    return len + 1;
                }
                for (String next : nexts) {
                    if (!saw.contains(next)) {
                        queue.add(next);
                        saw.add(next);
                    }
                }
            }
            len++;
        }
        return 0;
    }

    private boolean diff(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
                if (diffCount > 1) {
                    return false;
                }
            }
        }
        return diffCount == 1;
    }
}
