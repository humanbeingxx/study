package local.algorithm.leetcode.lcci;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/23 17:39
 */
public class LRUCache {

    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        return cache.get(key);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
