package local.algorithm;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/8/17 下午8:41
 **/
public class BinarySearch {

    public static <T extends Comparable<T>> int search(List<T> data, T target) {
        if (CollectionUtils.isEmpty(data)) {
            return -1;
        }

        int low = 0;
        int high = data.size() - 1;

        while (low <= high) {
            int index = (low + high) / 2;
            T current = data.get(index);
            if (current.equals(target)) {
                return index;
            }
            if (current.compareTo(target) > 0) {
                high = index - 1;
            } else {
                low = index + 1;
            }
        }

        return -1;
    }
}
