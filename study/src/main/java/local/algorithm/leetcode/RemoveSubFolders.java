package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/8 20:00
 */
public class RemoveSubFolders {
    public List<String> removeSubFolders(String[] folder) {
        List<String> result = new ArrayList<>();
        if (folder.length == 1) {
            result.add(folder[0]);
            return result;
        }
        Arrays.sort(folder);
        for (int pre = 0, curr = 1; curr < folder.length; curr++) {
            if (checkSub(folder[pre], folder[curr])) {
                folder[curr] = "";
            } else {
                pre = curr;
            }
        }
        for (String f : folder) {
            if (!f.isEmpty()) {
                result.add(f);
            }
        }
        return result;
    }

    private boolean checkSub(String sub, String str) {
        return str.indexOf(sub + "/") == 0;
    }
}
