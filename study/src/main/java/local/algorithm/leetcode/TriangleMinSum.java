package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TriangleMinSum {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        List<Integer> currentLevel = new ArrayList<>();
        List<Integer> preLevel = new ArrayList<>(triangle.get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> level = triangle.get(i);
            List<Integer> upperLevel = triangle.get(i - 1);
            int maxEnd = Math.min(level.size(), upperLevel.size() + 1);
            currentLevel.add(preLevel.get(0) + level.get(0));
            for (int j = 1; j < maxEnd; j++) {
                if (j == maxEnd - 1) {
                    currentLevel.add(preLevel.get(j - 1) + level.get(j));
                } else {
                    currentLevel.add(Math.min(preLevel.get(j), preLevel.get(j - 1)) + level.get(j));
                }
            }
            preLevel.clear();
            preLevel.addAll(currentLevel);
            currentLevel.clear();
        }
        int min = Integer.MAX_VALUE;
        for (Integer sum : preLevel) {
            min = Math.min(min, sum);
        }
        return min;
    }
}
