package local.algorithm.leetcode;

import java.util.*;

public class RandomizedSet {

    private Map<Integer, Integer> indexMap;
    private List<Integer> list;
    private Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        indexMap = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        list.add(val);
        indexMap.put(val, list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        int index = indexMap.get(val);
        list.set(index, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        indexMap.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.get(random.nextInt(list.size()));
    }
}
