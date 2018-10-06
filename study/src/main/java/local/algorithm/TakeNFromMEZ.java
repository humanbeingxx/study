package local.algorithm;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/6 下午2:08
 **/
public class TakeNFromMEZ {

    public static List<char[]> takeN(List<Character> source, int n) {
        if (n <= 0 || n > source.size()) {
            return Lists.newArrayList();
        }

        List<char[]> result = Lists.newArrayList();
        char[] collector = new char[n];
        rec(source, n, collector, result);

        return result;
    }

    private static void rec(List<Character> source, int n, char[] collector, List<char[]> result) {
        if (n == 0) {
            result.add(Arrays.copyOf(collector, collector.length));
            return;
        }
        for (int i = 0; i < source.size(); i++) {
            collector[n - 1] = source.get(i);
            rec(source, n -1 , collector, result);
        }
    }
}
