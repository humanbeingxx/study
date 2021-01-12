package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SortByGroupsRespectingDependenciesTest {

    @Test
    public void testSortItems1() {
        int[] result = new SortByGroupsRespectingDependencies().sortItems(8, 3,
                new int[]{-1, -1, 1, 0, 0, 1, 0, -1},
                Lists.newArrayList(
                        Lists.newArrayList(),
                        Lists.newArrayList(6),
                        Lists.newArrayList(5),
                        Lists.newArrayList(6),
                        Lists.newArrayList(3, 6),
                        Lists.newArrayList(),
                        Lists.newArrayList(),
                        Lists.newArrayList()
                ));
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testSortItems2() {
        int[] result = new SortByGroupsRespectingDependencies().sortItems(8, 2,
                new int[]{-1, -1, 1, 0, 0, 1, 0, -1},
                Lists.newArrayList(
                        Lists.newArrayList(),
                        Lists.newArrayList(6),
                        Lists.newArrayList(5),
                        Lists.newArrayList(6),
                        Lists.newArrayList(3),
                        Lists.newArrayList(),
                        Lists.newArrayList(4),
                        Lists.newArrayList()
                ));
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testSortItems3() {
        int[] result = new SortByGroupsRespectingDependencies().sortItems(8, 2,
                new int[]{-1, 1, 1, -1, 1, 1, 0, -1},
                Lists.newArrayList(
                        Lists.newArrayList(),
                        Lists.newArrayList(6),
                        Lists.newArrayList(5),
                        Lists.newArrayList(6),
                        Lists.newArrayList(3, 6),
                        Lists.newArrayList(),
                        Lists.newArrayList(),
                        Lists.newArrayList()
                ));
        System.out.println(Arrays.toString(result));
    }
}