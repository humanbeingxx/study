package local.algorithm;

import org.apache.commons.lang3.tuple.Pair;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/24 下午1:36
 **/
public class RulerTake {

    public static Pair<Integer, Integer> take(int[] data, int target) {
        if (data == null || data.length == 0) {
            return null;
        }
        int begin = 0, end = 0, sum = data[0];
        int currentMinLen = Integer.MAX_VALUE;
        Pair<Integer, Integer> result = null;

        for (; begin < data.length && end < data.length; ) {
            if (sum < target) {
                if (++end >= data.length) {
                    return result;
                }
                sum += data[end];
            } else {
                if (end - begin + 1 < currentMinLen) {
                    currentMinLen = end - begin + 1;
                    result = Pair.of(begin, end);
                }
                if (begin < end) {
                    sum -= data[begin++];
                } else if (begin == end) {
                    if (++end >= data.length) {
                        return result;
                    }
                    sum -= data[begin++];
                    sum += data[end];
                }
            }
        }

        return result;
    }

}
