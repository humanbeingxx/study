package local.algorithm;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Sets;

import java.util.Set;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/8/30 下午7:15
 **/
public class GapInListTest {

    @Test
    public void testCountPair() {
        int[] data = {3, 2, 5, 8, 0, 1, 1, 1, 2, 11};

        Assert.assertEquals(GapInList.countPair(data, 1), 3);
        Assert.assertEquals(GapInList.countPair(data, 2), 3);
        Assert.assertEquals(GapInList.countPair(data, 3), 4);
    }
}