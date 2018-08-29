package local.algorithm;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 * <p>
 * 计算无序数组排序后相邻元素最大的差值
 *
 * @author xiaoshuang.cui
 * @date 2018/8/29 下午7:40
 **/
public class GapOfNeighbour {

    public final static int BUCKET_NUM = 20;

    static class Bucket {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        void put(int num) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
    }

    /**
     * 基本思路：利用桶排序。
     * 相邻的最大差值，必然出现在两个桶的最大和最小之前。
     */
    public static int calculate(int[] data) {
        if (data.length == 0) {
            return 0;
        }

        int max = max(data);
        int min = min(data);

        fixNegative(data, min);

        if (max == min) {
            return 0;
        }

        int stepLength = ((max - min) % BUCKET_NUM == 0) ? ((max - min) / BUCKET_NUM) : ((max - min) / BUCKET_NUM + 1);

        Bucket[] buckets = new Bucket[BUCKET_NUM];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }

        for (int num : data) {
            int index = num / stepLength;
            buckets[index].put(num);
        }


        int gap = -1;

        int curMin = Integer.MAX_VALUE;
        int curMax = Integer.MIN_VALUE;

        for (Bucket bucket : buckets) {
            if (bucket.min != Integer.MAX_VALUE) {
                curMin = bucket.min;
                if (curMax != Integer.MIN_VALUE && curMin - curMax > gap) {
                    gap = curMin - curMax;
                }
            }
            if (bucket.max != Integer.MIN_VALUE) {
                curMax = bucket.max;
            }

        }

        return gap;
    }

    /**
     * 哎，还是会cover不住
     */
    private static void fixNegative(int[] data, int min) {
        if (min > 0) {
            return;
        }

        for (int i = 0; i < data.length; i++) {
            data[i] -= min;
        }
    }

    private static int min(int[] data) {
        int min = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }

    private static int max(int[] data) {
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }
}
