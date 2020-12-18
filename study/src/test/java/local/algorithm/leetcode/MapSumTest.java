package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MapSumTest {

    @Test
    public void test1() {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        int result = mapSum.sum("ap");
        assertEquals(result, 3);
        mapSum.insert("app", 2);
        result = mapSum.sum("ap");
        assertEquals(result, 5);
        mapSum.insert("app", 3);
        result = mapSum.sum("ap");
        assertEquals(result, 6);
    }

    @Test
    public void test2() {
        MapSum mapSum = new MapSum();
        int result = mapSum.sum("ap");
        assertEquals(result, 0);
    }

    @Test
    public void test3() {
        MapSum mapSum = new MapSum();
        mapSum.insert("aa",3);
        mapSum.insert("aa",2);
        mapSum.insert("aaa",3);
        int result = mapSum.sum("aaa");
        assertEquals(result, 3);
    }
}