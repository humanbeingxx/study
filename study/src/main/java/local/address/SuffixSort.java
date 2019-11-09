package local.address;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2019-11-05
 **/
public class SuffixSort {

    public static List<String> sort(String origin) {
        List<String> suffix = extractSuffix(origin);
        suffix.sort(String::compareToIgnoreCase);
        return suffix;
    }

    private static List<String> extractSuffix(String origin) {
        List<String> suffix = Lists.newArrayList();
        int length = origin.length();
        for (int i = 0; i < length; i++) {
            suffix.add(origin.substring(i, length));
        }
        return suffix;
    }
}
