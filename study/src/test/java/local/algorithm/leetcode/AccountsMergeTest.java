package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.testng.Assert.*;

public class AccountsMergeTest {

    @Test
    public void testAccountsMerge() {
        List<List<String>> result = new AccountsMerge().accountsMerge(Lists.newArrayList(
                Lists.newArrayList("John", "johnsmith@mail.com", "john00@mail.com"),
                Lists.newArrayList("John", "johnnybravo@mail.com"),
                Lists.newArrayList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Lists.newArrayList("Mary", "mary@mail.com")
        ));
        System.out.println(result);
    }

    @Test
    public void testSplitByConnection() {
        Set<String> nodes = Sets.newHashSet("1", "2", "3", "4", "5", "6");
        Map<String, Set<String>> connections = Maps.newHashMap();
        connections.put("1", Sets.newHashSet("2"));
        connections.put("2", Sets.newHashSet("3","1"));
        connections.put("3", Sets.newHashSet("4","2"));
        connections.put("4", Sets.newHashSet("3"));
        connections.put("5", Sets.newHashSet("6"));
        connections.put("6", Sets.newHashSet("5"));
        List<List<String>> result = new AccountsMerge().splitByConnection(nodes, connections);
        System.out.println(result);
    }

    @Test
    public void testProcessOneName() {
        List<List<String>> result = new AccountsMerge().processOneName(Lists.newArrayList(
            Lists.newArrayList("N1","1","2","3"),
            Lists.newArrayList("N1","4","5","6"),
            Lists.newArrayList("N1","7","1")
        ));
        System.out.println(result);
    }
}