package local.algorithm;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/6 下午2:33
 **/
public class TakeNFromMHD {

    public static List<char[]> takeN(char[] source, int n) {
        if (n <= 0 || n > source.length) {
            return Lists.newArrayList();
        }

        List<char[]> result = Lists.newArrayList();
        rec(source, 0, 0, n, new char[n], result);
        return result;
    }

    private static void rec(char[] source, int index, int pos, int n, char[] collector, List<char[]> result) {
        if (pos == n) {
            result.add(Arrays.copyOf(collector, collector.length));
            return;
        }
        for (int i = index; i < source.length; i++) {
            collector[pos] = source[i];
            rec(source, i + 1, pos + 1, n, collector, result);
        }
    }
}
