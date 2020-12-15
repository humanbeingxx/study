package local.algorithm;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
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

    /**
     * 找小于或等于target的最右元素
     */
    public static <T extends Comparable<T>> int searchFloor(List<T> data, T target) {
        if (data == null || data.size() == 0 || target == null || data.get(0).compareTo(target) > 0) {
            return -1;
        }
        int low = 0, high = data.size(), mid;
        while (low <= high) {
            mid = (high - low) / 2 + low;
            if (mid == data.size()) {
                return data.size() - 1;
            }
            if (data.get(mid).compareTo(target) <= 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low - 1;
    }
}
