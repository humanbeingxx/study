package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions20210105 {

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> groups = new ArrayList<>();
        int count = 1, start = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                if (count >= 3) {
                    groups.add(group(start, start + count - 1));
                }
                start = i;
                count = 1;
            }
        }
        if (count >= 3) {
            groups.add(group(start, start + count - 1));
        }
        return groups;
    }

    private List<Integer> group(int start, int end) {
        List<Integer> group = new ArrayList<>();
        group.add(start);
        group.add(end);
        return group;
    }
}
