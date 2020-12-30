package local.algorithm.leetcode;

public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {
        return findRec(input, 0);
    }

    private int findRec(String input, int preLength) {
        int max = 0;
        String[] parallelFiles = input.split("\\\\n(?!\\\\)");
        for (String parallelFile : parallelFiles) {
            if (isFile(parallelFile)) {
                if (preLength == 0) {
                    max = Math.max(max, parallelFile.length());
                } else {
                    max = Math.max(max, preLength + 1 + parallelFile.length());
                }
            } else {
                String[] split = parallelFile.split("\\\\n\\\\t(?!\\\\)");
                int directoryLen = split[0].length();
                for (int i = 1; i < split.length; i++) {
                    if (preLength == 0) {
                        max = Math.max(max, findRec(split[i].replaceAll("\\\\n\\\\t", "\\\\n"), directoryLen));
                    } else {
                        max = Math.max(max, findRec(split[i].replaceAll("\\\\n\\\\t", "\\\\n"), preLength + 1 + directoryLen));
                    }
                }
            }
        }
        return max;
    }

    private boolean isFile(String parallelFile) {
        return parallelFile.contains(".") && !parallelFile.contains("\\");
    }
}
