package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountsMerge20210118Test {

    @Test
    public void testAccountsMerge20210118() {
        List<List<String>> result = new AccountsMerge20210118().accountsMerge(Lists.newArrayList(
                Lists.newArrayList("John", "johnsmith@mail.com", "john00@mail.com"),
                Lists.newArrayList("John", "johnnybravo@mail.com"),
                Lists.newArrayList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Lists.newArrayList("Mary", "mary@mail.com")
        ));
        System.out.println(result);
    }
}