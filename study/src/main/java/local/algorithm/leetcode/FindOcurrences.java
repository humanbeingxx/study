package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/2 21:48
 */
public class FindOcurrences {

    public String[] findOcurrences(String text, String first, String second) {
        List<String> result = new ArrayList<>();

        String[] split = text.split(" ");
        for (int i = 0; i < split.length - 2; i++) {
            if (split[i].equals(first) && split[i + 1].equals(second)) {
                result.add(split[i + 2]);
            }
        }
        return result.toArray(new String[0]);
    }
}
