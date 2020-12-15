package local.algorithm.leetcode.lcci;

import java.util.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/23 16:54
 */
public class FindLadders {

    private List<String> foundPath;

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return new ArrayList<>();
        }
        wordList.add(beginWord);
        Map<String, Set<String>> relations = buildRelation(wordList);
        List<String> path = new ArrayList<>();
        findPath(beginWord, endWord, relations, path, new HashSet<String>());
        return path;
    }

    private boolean findPath(String beginString, String endString, Map<String, Set<String>> relations, List<String> path, HashSet<String> checked) {
        if (foundPath != null) {
            return true;
        }
        if (beginString.equals(endString)) {
            path.add(endString);
            foundPath = path;
            return true;
        }
        Set<String> next = relations.get(beginString);
        if (next == null || next.isEmpty()) {
            return false;
        }
        path.add(beginString);
        checked.add(beginString);
        for (String s : next) {
            if (!checked.contains(s)) {
                if (findPath(s, endString, relations, path, checked)) {
                    return true;
                }
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    private Map<String, Set<String>> buildRelation(List<String> wordList) {
        Map<String, Set<String>> relations = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < wordList.size(); j++) {
                String from = wordList.get(i);
                String to = wordList.get(j);
                if (from.equals(to)) {
                    continue;
                }
                if (canTrans(from, to)) {
                    relations.putIfAbsent(from, new HashSet<>());
                    relations.get(from).add(to);
                }
            }
        }
        return relations;
    }

    private boolean canTrans(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        boolean changed = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (changed) {
                    return false;
                } else {
                    changed = true;
                }
            }
        }
        return true;
    }
}
