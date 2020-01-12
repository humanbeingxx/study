package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/12 23:52
 */
public class GroupThePeople {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            groups.putIfAbsent(groupSizes[i], new ArrayList<>());
            groups.get(groupSizes[i]).add(i);
        }
        for (Map.Entry<Integer, List<Integer>> entry : groups.entrySet()) {
            int count = entry.getKey();
            List<Integer> values = entry.getValue();
            int index = 0;
            for (int i = 0, times = values.size() / count; i < times; i++) {
                List<Integer> oneGroup = new ArrayList<>();
                for (int j = 0; j < count; j++) {
                    oneGroup.add(values.get(index++));
                }
                result.add(oneGroup);
            }
        }
        return result;
    }
}
