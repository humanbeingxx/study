package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/17 21:21
 */
public class ReorderLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> {
            String[] split1 = o1.split(" ", 2);
            String[] split2 = o2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if (isDigit1 && isDigit2) {
                return 0;
            }
            if (!isDigit1 && isDigit2) {
                return -1;
            }
            if (isDigit1) {
                return 1;
            }
            int contentCmp = split1[1].compareTo(split2[1]);
            if (contentCmp != 0) {
                return contentCmp;
            } else {
                return split1[0].compareTo(split2[0]);
            }
        });
        return logs;
    }
}
