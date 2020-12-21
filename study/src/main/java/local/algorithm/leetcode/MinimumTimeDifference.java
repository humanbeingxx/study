package local.algorithm.leetcode;

import java.util.List;

public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440 || timePoints.size() <= 1) {
            return 0;
        }
        timePoints.sort(String::compareTo);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size() - 1; i++) {
            String after = timePoints.get(i + 1);
            String before = timePoints.get(i);
            String[] afterSplit = after.split(":");
            String[] beforeSplit = before.split(":");
            int diff = (Integer.parseInt(afterSplit[0]) - Integer.parseInt(beforeSplit[0])) * 60
                    + (Integer.parseInt(afterSplit[1]) - Integer.parseInt(beforeSplit[1]));
            minDiff = Math.min(minDiff, diff);
        }
        String[] firstSplit = timePoints.get(0).split(":");
        String[] lastSplit = timePoints.get(timePoints.size() - 1).split(":");
        int lastDiff = (Integer.parseInt(firstSplit[0]) + 24 - Integer.parseInt(lastSplit[0])) * 60 + (Integer.parseInt(firstSplit[1]) - Integer.parseInt(lastSplit[1]));
        minDiff = Math.min(minDiff, lastDiff);
        return minDiff;
    }
}
