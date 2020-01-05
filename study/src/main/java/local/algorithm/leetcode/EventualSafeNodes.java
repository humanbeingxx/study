package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cuixiaoshuang
 * @date 2020-01-03
 **/
public class EventualSafeNodes {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Set<Integer>> canReach = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < graph[i].length; j++) {
                set.add(graph[i][j]);
            }
            canReach.add(set);
        }

        boolean[] flag = new boolean[graph.length];

        for (int time = 0; time < graph.length + 1; time++) {
            for (int i = 0; i < canReach.size(); i++) {
                if (flag[i]) {
                    continue;
                }
                Set<Integer> set = canReach.get(i);
                Set<Integer> reachMore = new HashSet<>();
                for (Integer reach : set) {
                    if (flag[reach]) {
                        flag[i] = true;
                        break;
                    } else {
                        reachMore.addAll(canReach.get(reach));
                    }
                }
                set.addAll(reachMore);

                if (set.contains(i)) {
                    flag[i] = true;
                    break;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < flag.length; i++) {
            if (!flag[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
