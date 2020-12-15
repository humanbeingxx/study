package local.interview_internal_reference.didi;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/7/7 23:54
 */
public class MyQuickSort {

    public static void sort(int[] data) {
        partial(data, 0, data.length - 1);
    }

    private static void partial(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int low = start, high = end;
        int pivot = data[low];
        while (low < high) {
            while (low < high && data[high] >= pivot) {
                high--;
            }
            if (low < high) {
                data[low] = data[high];
            }
            while (low < high && data[low] <= pivot) {
                low++;
            }
            if (low < high) {
                data[high] = data[low];
            }
        }
        data[low] = pivot;
        partial(data, start, low - 1);
        partial(data, low + 1, end);
    }


}
