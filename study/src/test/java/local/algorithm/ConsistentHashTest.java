package local.algorithm;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import static org.testng.Assert.assertEquals;

/**
 * @author xiaoshuang.cui
 * @date 2018/9/5 下午9:41
 **/
public class ConsistentHashTest {

    @Test
    public void testGetHashNodes() {
        ConsistentHash hash = new ConsistentHash(Lists.newArrayList("1", "100", "1000", "10000", "100000"));
        System.out.println(hash);

        hash.addNode("200");
        hash.addNode("1000001");
        System.out.println(hash);
    }

    @Test
    public void testHashTo() {
        ConsistentHash hash = new ConsistentHash(Lists.newArrayList("1", "100", "1000", "10000", "100000"));

        assertEquals(hash.hashTo("150"), "1000");
        assertEquals(hash.hashTo("500"), "1000");
        assertEquals(hash.hashTo("100001"), "1");
    }

    @Test
    public void testAdd() {
        ConsistentHash hash = new ConsistentHash(Lists.newArrayList("1", "100", "1000", "10000", "100000"));

        assertEquals(hash.hashTo("150"), "1000");
        assertEquals(hash.hashTo("500"), "1000");
        assertEquals(hash.hashTo("100001"), "1");

        hash.addNode("200");
        hash.addNode("100001");

        assertEquals(hash.hashTo("150"), "200");
        assertEquals(hash.hashTo("500"), "1000");
        assertEquals(hash.hashTo("100001"), "100001");
    }

    @Test
    public void testRemove() {
        ConsistentHash hash = new ConsistentHash(Lists.newArrayList("1", "100", "1000", "10000", "100000"));

        assertEquals(hash.hashTo("150"), "1000");
        assertEquals(hash.hashTo("500"), "1000");
        assertEquals(hash.hashTo("100001"), "1");

        hash.removeNode("200");
        assertEquals(hash.hashTo("150"), "1000");

        hash.removeNode("1000");
        assertEquals(hash.hashTo("150"), "10000");
    }

    @Test
    public void testDistribution() {
        ConsistentHash hash = new ConsistentHash(Lists.newArrayList("1", "100", "1000", "10000", "100000"));

        Multiset<String> count = HashMultiset.create();
        for (int i = 0; i < 1000000; i++) {
            count.add(hash.hashTo(Integer.toString(i)));
        }

        System.out.println(count);
    }
}