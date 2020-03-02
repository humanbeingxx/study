package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LRUCacheTest {

    @Test
    public void test() {
        //["LRUCache","put","put","put","get","put","put","get","put","put","get","put","get","get","get","put","put","get","put","get"]
        //[[2],[13],[8,30],[1,5],[1],[13,2],[12]]
        LRUCache cache = new LRUCache(10);
        cache.put(7, 28);
        cache.put(7, 1);
        cache.put(8, 15);
        System.out.println(cache.get(6));
        cache.put(10, 27);
        cache.put(8, 10);
        System.out.println(cache.get(8));
        cache.put(6, 29);
        cache.put(1, 9);
        System.out.println(cache.get(6));
        cache.put(10, 7);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(13));
        cache.put(8, 30);
        cache.put(1, 5);
        System.out.println(cache.get(1));
        cache.put(13, 2);
        System.out.println(cache.get(12));
    }
}