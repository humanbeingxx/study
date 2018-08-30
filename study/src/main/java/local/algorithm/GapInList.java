package local.algorithm;

import java.util.Arrays;

/**
 * 输出数组中相差为给定值的数对个数，重复的一对只算一次
 *
 * @author xiaoshuang.cui
 * @date 2018/8/30 下午5:56
 **/
public class GapInList {

    /**
     * 计数指定差值的数字对
     */
    public static int countPair(int[] data, int gap) {
        if (data.length < 2) {
            return 0;
        }

        Arrays.sort(data);

        int count = 0;
        int down = 0;
        int up = 1;
        int preDownData = -1;
        int preUpData = -1;


        for (; down < data.length;) {
            int curGap = data[up] - data[down];
            if (curGap == gap && data[down] != preDownData && data[up] != preUpData) {
                count++;
                preDownData = data[down];
                preUpData = data[up];
                down++;
                if (up < data.length - 1) {
                    up++;
                }

            } else if (curGap < gap && up < data.length - 1) {
                up++;
            } else {
                down++;
            }
        }

        return count;
    }
}
