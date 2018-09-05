package local.algorithm;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Random;

import static org.testng.Assert.*;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/9/5 下午10:36
 **/
public class ConsistentHashWithFakeTest {

    @Test
    public void test() {
        ConsistentHashWithFake hash = new ConsistentHashWithFake(Lists.newArrayList("1", "100", "1000", "10000", "100000"));
        System.out.println(hash.getHashNodes());
    }

    @Test
    public void testAdd() {
        ConsistentHashWithFake hash = new ConsistentHashWithFake(Lists.newArrayList("1", "100", "1000", "10000", "100000"));

        hash.addNode("200");
        hash.addNode("100001");

        System.out.println(hash);
    }

    @Test
    public void testRemove() {
        ConsistentHashWithFake hash = new ConsistentHashWithFake(Lists.newArrayList("1", "100", "1000", "10000", "100000"));

        hash.removeNode("200");
        hash.removeNode("1000");
        System.out.println(hash);
    }

    @Test
    public void testDistribution() {
        ConsistentHashWithFake hash = new ConsistentHashWithFake(Lists.newArrayList("1", "100", "1000", "10000", "100000"));

        Multiset<String> count = HashMultiset.create();
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            count.add(hash.hashTo(Integer.toString(Math.abs(random.nextInt()))));
        }

        System.out.println(count);
    }
}