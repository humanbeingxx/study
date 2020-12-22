package local.algorithm.leetcode;

import java.util.Arrays;

public class SundaySearch {

    public static int search(String source, String target) {
        int[] lastIndex = calcLastIndex(target);
        int sourceIndex = 0;
        boolean found;
        while (sourceIndex < source.length()) {
            int targetIndex = 0, sourceIndexOneTurn = sourceIndex;
            found = true;
            while (targetIndex < target.length()) {
                if (source.charAt(sourceIndex) == target.charAt(targetIndex)) {
                    sourceIndex++;
                    targetIndex++;
                } else {
                    found = false;
                    int nextAlignIndex = sourceIndex + target.length() - targetIndex;
                    if (nextAlignIndex >= source.length()) {
                        return -1;
                    } else {
                        int lastIndexOfAlign = lastIndex[source.charAt(nextAlignIndex)];
                        if (lastIndexOfAlign == -1) {
                            sourceIndex = nextAlignIndex;
                        } else {
                            sourceIndex = sourceIndexOneTurn + target.length() - lastIndexOfAlign;
                        }
                    }
                    break;
                }
            }
            if (found) {
                return sourceIndex - target.length();
            }
        }
        return -1;
    }

    private static int[] calcLastIndex(String target) {
        int[] lastIndex = new int[Character.MAX_VALUE];
        Arrays.fill(lastIndex, -1);
        for (int i = 0; i < target.length(); i++) {
            lastIndex[target.charAt(i)] = i;
        }
        return lastIndex;
    }
}
