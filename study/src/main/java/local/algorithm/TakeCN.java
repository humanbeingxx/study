package local.algorithm;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/17 上午11:13
 **/
public class TakeCN {

    public static List<int[]> takeC2(int[] data) {
        List<int[]> result = Lists.newArrayList();

        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                result.add(new int[]{data[i], data[j]});
            }
        }

        return result;
    }

    public static List<int[]> takeCN(int[] data, int n) {

        List<int[]> result = Lists.newArrayList();

        if (n == 0) {
            return result;
        }

        int[] temp = new int[n];
        for (int i = 0; i < data.length; i++) {
            temp[0] = data[i];
            takeCNRec(data, i + 1, 1, n, temp, result);
        }
        return result;
    }

    private static void takeCNRec(int[] data, int from, int current, int n, int[] temp, List<int[]> result) {
        if (current == n) {
            result.add(copy(temp, 0, temp.length - 1));
            return;
        }

        if (from >= data.length) {
            return;
        }

        for (int i = from; i < data.length; i++) {
            temp[current] = data[i];
            takeCNRec(data, i + 1, current + 1, n, temp, result);
        }
    }

    protected static int[] copy(int[] source, int fromS, int toS) {
        int[] result = new int[toS - fromS + 1];
        for (int i = fromS, j = 0; i <= toS; i++, j++) {
            result[j] = source[i];
        }
        return result;
    }
}
