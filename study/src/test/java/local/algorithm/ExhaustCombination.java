package local.algorithm;

import org.testng.collections.Lists;

import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/17 上午10:09
 **/
public class ExhaustCombination {

    public static List<int[]> exhaust(int[] data) {
        List<int[]> result = Lists.newArrayList();

        int len = data.length;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                result.add(copy(data, i, j));
            }
        }

        return result;
    }

    protected static int[] copy(int[] source, int fromS, int toS) {
        int[] result = new int[toS - fromS + 1];
        for (int i = fromS, j = 0; i <= toS; i++, j++) {
            result[j] = source[i];
        }
        return result;
    }
}
