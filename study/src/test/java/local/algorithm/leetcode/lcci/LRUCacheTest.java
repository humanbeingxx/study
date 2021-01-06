package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/23 17:43
 */
public class LRUCacheTest {

    @Test
    public void test() {
        LRUCache cache = new LRUCache(2);
        cache.get(1);
    }
}