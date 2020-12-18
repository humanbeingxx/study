package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MapSum {

    enum Mod {
        ADD, REPLACE
    }

    static class Node {
        char c;
        int sum;
        Node[] children = new Node[26];
    }

    Map<String, Integer> map;
    Node tree;

    public MapSum() {
        map = new HashMap<>();
        tree = new Node();
    }

    public void insert(String key, int val) {
        Integer previousVal = map.put(key, val);
        Mod mod = previousVal == null ? Mod.ADD : Mod.REPLACE;
        if (mod == Mod.REPLACE) {
            val -= previousVal;
            if (val == 0) {
                return;
            }
        }
        Node node = tree;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Node();
                node = node.children[c - 'a'];
                node.c = c;
                node.sum = val;
            } else if (mod == Mod.ADD) {
                node = node.children[c - 'a'];
                node.sum += val;
            } else {
                node = node.children[c - 'a'];
                node.sum += val;
            }
        }
    }

    public int sum(String prefix) {
        Node node = tree;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.children[c - 'a'] == null) {
                return 0;
            }
            node = node.children[c - 'a'];
        }
        return node.sum;
    }
}
