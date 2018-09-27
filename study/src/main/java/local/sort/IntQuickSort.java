package local.sort;

/**
 * @author xiaoshuang.cui
 * @date 2018/9/26 下午5:40
 **/
public class IntQuickSort {

    public static void sort(int[] data) {
        if (data.length <= 1) {
            return;
        }

        sortRec(data, 0, data.length - 1);
    }

    private static void sortRec(int[] data, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int pivot = data[begin];
        int low = begin;
        int high = end;

        while (low < high) {
            while (data[high] >= pivot && low < high) {
                high--;
            }
            while (data[low] <= pivot && low < high) {
                low++;
            }
            if (low < high) {
                exchange(data, low, high);
            }
        }
        data[begin] = data[low];
        data[low] = pivot;

        sortRec(data, begin, low - 1);
        sortRec(data, low + 1, end);
    }

    private static void exchange(int[] data, int from, int to) {
        int temp = data[from];
        data[from] = data[to];
        data[to] = temp;
    }
}
