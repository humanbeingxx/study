package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-01-10
 **/
public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < Math.min(3, s.length()); i++) {
            String first = s.substring(0, i + 1);
            if (!checkValid(first)) {
                continue;
            }
            String s1 = s.substring(i + 1);
            for (int j = 0; j < Math.min(3, s1.length()); j++) {
                String second = s1.substring(0, j + 1);
                if (!checkValid(second)) {
                    continue;
                }
                String s2 = s1.substring(j + 1);
                for (int k = 0; k < Math.min(3, s2.length()); k++) {
                    String third = s2.substring(0, k + 1);
                    if (!checkValid(third) || k + 1 == s2.length()) {
                        continue;
                    }
                    String forth = s2.substring(k + 1);
                    if (checkValid(forth)) {
                        result.add(String.join(".", first, second, third, forth));
                    }
                }
            }
        }
        return result;
    }

    private boolean checkValid(String segment) {
        if (segment.length() == 0 || segment.length() > 3) {
            return false;
        }
        if (segment.equals("0")) {
            return true;
        } else if (segment.startsWith("0")) {
            return false;
        }
        int i = Integer.parseInt(segment);
        return i >= 0 && i <= 255;
    }
}
