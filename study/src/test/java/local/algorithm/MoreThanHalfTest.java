package local.algorithm;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/9/4 下午8:12
 **/
public class MoreThanHalfTest {

    @Test
    public void testFind1() {
        assertEquals(MoreThanHalf.find("aaaaa".toCharArray()), 'a');
    }

    @Test
    public void testFind2() {
        assertEquals(MoreThanHalf.find("aabb".toCharArray()), -1);
    }

    @Test
    public void testFind3() {
        assertEquals(MoreThanHalf.find("aaabbkk".toCharArray()), -1);
    }

    @Test
    public void testFind4() {
        assertEquals(MoreThanHalf.find("aaaaabbbbb".toCharArray()), -1);
    }

    @Test
    public void testFind5() {
        assertEquals(MoreThanHalf.find("abababababdddaaaa".toCharArray()), 'a');
    }
}